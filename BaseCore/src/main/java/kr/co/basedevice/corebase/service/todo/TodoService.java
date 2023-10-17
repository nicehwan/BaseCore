package kr.co.basedevice.corebase.service.todo;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import kr.co.basedevice.corebase.domain.code.TodoCreCd;
import kr.co.basedevice.corebase.domain.code.Yn;
import kr.co.basedevice.corebase.domain.td.TdTodo;
import kr.co.basedevice.corebase.domain.td.TdWork;
import kr.co.basedevice.corebase.dto.todo.TodayPlanDto;
import kr.co.basedevice.corebase.dto.todo.TodayTodoDto;
import kr.co.basedevice.corebase.dto.todo.TodoDetailDto;
import kr.co.basedevice.corebase.dto.todo.TodoSummaryDto;
import kr.co.basedevice.corebase.repository.td.TdTodoRepository;
import kr.co.basedevice.corebase.search.todo.SearchTodo;
import kr.co.basedevice.corebase.search.todo.SearchTodoMgt;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RequiredArgsConstructor
@Transactional
@Service
public class TodoService {
	
	final private TdTodoRepository tdTodoRepository;
	
	/**
	 * 확인자 용 할일 목록
	 * 
	 * @param searchTodo
	 * @return
	 */
	public List<TodayPlanDto> findByTodayPlanList4Checker(SearchTodo searchTodo) {
		// TODO 해당일에 생성된 확인자의 할일/작업 목록
		
		return null;
	}

	public TdWork getTdWork(Long workSeq) {
		// TODO 작업 조회
		return null;
	}

	public TdTodo getTdTodo(Long todoSeq) {
		// TODO 할일 조회 
		return null;
	}

	public List<TodoSummaryDto> findByPointSummary4Checker(SearchTodo searchTodo) {
		// TODO 확인자의 할일을 완룐한 수행자의 해당일 획득 포인트와 지급예정포인트 
		log.info("############################ 한번은 똮!");
		return null;
	}

	public List<TodoDetailDto> findByTodoList(SearchTodoMgt searchTodoMgt) {
		
		// TODO 확인자가 생성한 할일 목록 조회
		return null;
	}

	public TodoDetailDto getTdTodoDetail(Long todoSeq) {
		// TODO 할일, 작업자, 확인자
		return null;
	}

	public List<TodayTodoDto> findByTodayPlanList4Worker(SearchTodo searchTodo) {
		// 사용자용 오늘의 할일
		return null;
	}

	public List<TodoSummaryDto> findByPointSummary4Worker(SearchTodo searchTodo) {
		// TODO Auto-generated method stub
		return null;
	}

	public void saveTdWork(TdWork tdWork) {
		// TODO Auto-generated method stub
		
	}

	/**
	 * 생성일에 해당하는 할일 조회 
	 * 
	 * @param createDate
	 * @return
	 */
	public List<TdTodo> findByTargetTodoItem(LocalDate createDate) {
		
		List<TdTodo> tdTodoList = tdTodoRepository
				.findByDelYnAndTodoCreCdInAndPostBeginDateLessThanEqualAndPostEndDateGreaterThanEqual(
						Yn.N, 
						Arrays.asList(TodoCreCd.DAILY, TodoCreCd.WEEK, TodoCreCd.MONTH),
						createDate, 
						createDate);
		
		return tdTodoList;
	}


	public int createWorkItems(LocalDate createDate, Long todoSeq) {
		log.info("#############################################################");
		return 0;
	}

	public int closeWorkItems() {
		log.info("★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★");
		return 0;
	}

}