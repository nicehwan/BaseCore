package kr.co.basedevice.corebase.repository.td.querydsl;

import java.time.LocalDateTime;
import java.time.LocalTime;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;
import org.springframework.util.ObjectUtils;

import com.querydsl.core.BooleanBuilder;
import com.querydsl.core.QueryResults;
import com.querydsl.core.types.Order;
import com.querydsl.core.types.OrderSpecifier;
import com.querydsl.core.types.Projections;
import com.querydsl.jpa.JPQLQuery;
import com.querydsl.jpa.impl.JPAQueryFactory;

import kr.co.basedevice.corebase.domain.cm.QCmUser;
import kr.co.basedevice.corebase.domain.code.Yn;
import kr.co.basedevice.corebase.domain.td.QTdTodo;
import kr.co.basedevice.corebase.domain.td.QTdWork;
import kr.co.basedevice.corebase.dto.todo.TodayPlanDto;
import kr.co.basedevice.corebase.search.todo.SearchTodo;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Repository
public class TdWorkRepositoryImpl implements TdWorkRepositoryQuerydsl{

	private final JPAQueryFactory jpaQueryFactory;
	
	
	@Override
	public Page<TodayPlanDto> pageTodayPlan(SearchTodo searchTodo, Pageable page) {
		QTdTodo tdTodo = QTdTodo.tdTodo;
		QTdWork tdWork = QTdWork.tdWork;
		QCmUser cmUser = QCmUser.cmUser; 
		
		JPQLQuery<TodayPlanDto> query = jpaQueryFactory.selectDistinct(
				Projections.bean(TodayPlanDto.class,
					 tdTodo.todoSeq
					,tdTodo.todoTitl
					,tdTodo.todoCont
					,tdTodo.completCondiVal
					,tdTodo.todoTypCd
					,tdTodo.todoCreCd
					,tdTodo.quizUseYn
					,tdTodo.quizTypCd
					
					,tdWork.workSeq
					,tdWork.workTitl
					,tdWork.workCont
					,tdWork.workDt
					,tdWork.workStatCd
					,tdWork.workPossBeginDt
					,tdWork.workPossEndDt
					,tdWork.confmDt
					,tdWork.gainPoint
					,tdWork.setleYn
				)
			)
			.from(tdTodo)
			.innerJoin(tdWork).on(tdTodo.todoSeq.eq(tdWork.todoSeq))
			.leftJoin(cmUser).on(tdWork.workerSeq.eq(cmUser.userSeq));
			
		BooleanBuilder builder = new BooleanBuilder();
		builder.and(tdTodo.delYn.eq(Yn.N));
		builder.and(tdWork.delYn.eq(Yn.N));
		
		if(!ObjectUtils.isEmpty(searchTodo.getToDay())) {
			builder.and(tdWork.workPossBeginDt.loe(LocalDateTime.of(searchTodo.getToDay(), LocalTime.of(0, 0, 0))));  // =<
			builder.and(tdWork.workPossEndDt.goe(LocalDateTime.of(searchTodo.getToDay(), LocalTime.of(23, 59, 59)))); // >=	
		}
		
		if(!ObjectUtils.isEmpty(searchTodo.getWorkerSeq())) {
			builder.and(tdWork.workerSeq.eq(searchTodo.getWorkerSeq()));
		}

		if(!ObjectUtils.isEmpty(searchTodo.getTodoTitl())) {
			builder.and(tdTodo.todoTitl.contains(searchTodo.getTodoTitl()));			
		}
		
		if(!ObjectUtils.isEmpty(searchTodo.getTodoCont())) {
			builder.and(tdTodo.todoCont.contains(searchTodo.getTodoCont()));
		}
		
		if(!ObjectUtils.isEmpty(searchTodo.getTodoDesc())) {
			builder.and(tdTodo.todoDesc.contains(searchTodo.getTodoDesc()));			
		}

		if(!ObjectUtils.isEmpty(searchTodo.getWorkTitl())) {
			builder.and(tdWork.workTitl.contains(searchTodo.getWorkTitl()));
		}
		
		if(!ObjectUtils.isEmpty(searchTodo.getWorkCont())) {
			builder.and(tdWork.workCont.contains(searchTodo.getWorkCont()));
		}
		
		if(!ObjectUtils.isEmpty(searchTodo.getWorkStatCd())) {
			builder.and(tdWork.workStatCd.eq(searchTodo.getWorkStatCd()));
		}
		if(!ObjectUtils.isEmpty(searchTodo.getCheckerSeq())) {
			builder.and(tdWork.checkerSeq.eq(searchTodo.getCheckerSeq()));
		}
				
		query.where(builder);
		
		if(!ObjectUtils.isEmpty(searchTodo.getOrder()) && !ObjectUtils.isEmpty(searchTodo.getSort())) {
	    	Order direction = Order.valueOf(searchTodo.getOrder().toUpperCase());
	    	
	        if(searchTodo.getSort().equals("loginId")) {
		        query.orderBy(new OrderSpecifier<>(direction, tdTodo.todoTitl));
	        }else{
	        	query.orderBy(tdWork.workSeq.desc());
	        }
		}else {
        	query.orderBy(tdWork.workSeq.desc());
		}
		
		QueryResults<TodayPlanDto> queryResults = query.limit(page.getPageSize()).offset(page.getOffset()).fetchResults();

		return new PageImpl<>(queryResults.getResults(), page, queryResults.getTotal());
	}

}