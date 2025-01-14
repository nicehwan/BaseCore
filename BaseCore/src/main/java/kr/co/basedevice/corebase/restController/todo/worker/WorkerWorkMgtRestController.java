package kr.co.basedevice.corebase.restController.todo.worker;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.util.ObjectUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import kr.co.basedevice.corebase.domain.cm.CmUser;
import kr.co.basedevice.corebase.domain.code.TodoCreCd;
import kr.co.basedevice.corebase.domain.td.TdTodo;
import kr.co.basedevice.corebase.dto.todo.TodoWorkerInfoDto;
import kr.co.basedevice.corebase.dto.todo.WorkerAgreeTodoDto;
import kr.co.basedevice.corebase.search.todo.SearchTodoWorker;
import kr.co.basedevice.corebase.security.service.AccountContext;
import kr.co.basedevice.corebase.service.todo.TodoService;
import kr.co.basedevice.corebase.util.DateTimeUtils;
import lombok.RequiredArgsConstructor;

/**
 * 할일 동의 및 할일 목록 조회
 * 
 * @author fishingday
 *
 */
@RestController
@RequestMapping("/worker/work_mgt")
@RequiredArgsConstructor
public class WorkerWorkMgtRestController {
	
	final private TodoService todoService;

	/**
	 * 할일 목록 조회 
	 * with 일/주/월별 예상 포인트
	 * 
	 * @param searchTodoWorker
	 * @param page
	 * @return
	 */
	@GetMapping("/list_todo_info.json")
	public ResponseEntity<List<TodoWorkerInfoDto>> listTodoWorkerInfo(SearchTodoWorker searchTodoWorker){
		
		CmUser cmUser = ((AccountContext) SecurityContextHolder.getContext().getAuthentication().getPrincipal()).getCmUser();
		searchTodoWorker.setWorkerSeq(cmUser.getUserSeq());
		
		// 지정일이 없다면..
		if(ObjectUtils.isEmpty(searchTodoWorker.getTargetDay())) {
			searchTodoWorker.setTargetDay(LocalDate.now());
		}
		
		List<TodoWorkerInfoDto> listTodoWorkerInfo = todoService.listTodoWorkerInfo(searchTodoWorker);
				
				
		return ResponseEntity.ok(listTodoWorkerInfo);
	}
	
	/**
	 * 할당된 할일 목록 조회
	 * 
	 * @return
	 */
	@GetMapping("/list_assign_todo.json")
	public ResponseEntity<List<TdTodo>> listAssignTodo(){
		CmUser cmUser = ((AccountContext) SecurityContextHolder.getContext().getAuthentication().getPrincipal()).getCmUser();
		
		List<TdTodo> listTdTodo = todoService.findByAgreeTodo(cmUser.getUserSeq());
		
		return ResponseEntity.ok(listTdTodo);
	}
	
	/**
	 * 미할달된 할일 목록 조회
	 * 
	 * @return
	 */
	@GetMapping("/list_unassign_todo.json")
	public ResponseEntity<List<TdTodo>> listUnassignTodo(){
		CmUser cmUser = ((AccountContext) SecurityContextHolder.getContext().getAuthentication().getPrincipal()).getCmUser();
		
		List<TdTodo> listTdTodo = todoService.findByUnAgreeTodo(cmUser.getUserSeq());
		
		return ResponseEntity.ok(listTdTodo);
	}
	
	/**
	 * 할일에 대한 동의/미동의 저장
	 * 
	 * @param workerAgreeTodo
	 * @return
	 */
	@PutMapping("/save_worker_agree")
	public ResponseEntity<Boolean> saveWorkerAgreeTodo(WorkerAgreeTodoDto workerAgreeTodo){
		CmUser cmUser = ((AccountContext) SecurityContextHolder.getContext().getAuthentication().getPrincipal()).getCmUser();
		workerAgreeTodo.setWorkerSeq(cmUser.getUserSeq());
		
		boolean isSave = todoService.saveWorkerAgreeTodo(workerAgreeTodo);		
		
		return ResponseEntity.ok(isSave);
	}	
}
