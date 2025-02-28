package kr.co.basedevice.corebase.domain.td;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;

import kr.co.basedevice.corebase.domain.BaseEntity;
import kr.co.basedevice.corebase.domain.code.QuizTypCd;
import kr.co.basedevice.corebase.domain.code.TodoCreCd;
import kr.co.basedevice.corebase.domain.code.TodoTypCd;
import kr.co.basedevice.corebase.domain.code.Yn;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "TD_TODO")
@SequenceGenerator(name = "SEQGEN_TD_TODO", sequenceName = "SEQ_TD_TODO", initialValue = 1000, allocationSize = 1)
public class TdTodo extends BaseEntity implements Serializable{

	private static final long serialVersionUID = 7601560038609308698L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQGEN_TD_TODO")
	@Column(name = "TODO_SEQ", nullable = false)
	private Long todoSeq;

	@Column(name = "UP_TODO_SEQ")
	private Long upTodoSeq;		
	
	@Column(name = "TODO_TITL", length = 200, nullable = false)
	private String todoTitl;
	
	@Column(name = "TODO_CONT", length = 2000, nullable = false)
	private String todoCont;
	
	@Column(name = "TODO_DESC", length = 2000)
	private String todoDesc;
	
	@Column(name = "COMPLET_CONDI_VAL", length = 128, nullable = false)
	private String completCondiVal;
	
	@Column(name = "TODO_POINT", nullable = false)
	private Integer todoPoint;
	
	@Column(name = "TODO_TYP_CD", nullable = false, length = 35)
	@Enumerated(EnumType.STRING)
	private TodoTypCd todoTypCd;
	
	@Column(name = "TODO_DTL_VAL", length = 128)
	private String todoDtlVal;
	
	// 직접생성의 경우 하루 생성 제한
	@Column(name = "DATE_LIMIT_CNT", nullable = false)
	private Integer dateLimitCnt;
		
	@Column(name = "TODO_CRE_CD", nullable = false, length = 35)
	@Enumerated(EnumType.STRING)
	private TodoCreCd todoCreCd;
	
	// 생성 유형에 따른 세부값
	// 주간생성 : DayOfWeek String 값
	// 월간생성 : 1~31, LAST
	@Column(name = "TODO_CRE_DTL_VAL", length = 128)
	private String todoCreDtlVal;
	
	// 하위 작업의 경우만 비교 순서
	@Column(name = "APLYTO_ORD")
	private Integer aplytoOrd;
	
	@DateTimeFormat(pattern = "yyyy-MM-dd")
    @JsonFormat(shape= JsonFormat.Shape.STRING, pattern="yyyy-MM-dd", timezone="Asia/Seoul") //날짜 포멧 바꾸기
	@Column(name = "POST_BEGIN_DATE", nullable = false)
	private LocalDate postBeginDate;
	
	@DateTimeFormat(pattern = "yyyy-MM-dd")
    @JsonFormat(shape= JsonFormat.Shape.STRING, pattern="yyyy-MM-dd", timezone="Asia/Seoul") //날짜 포멧 바꾸기
	@Column(name = "POST_END_DATE", nullable = false)
	private LocalDate postEndDate;
	
	// 입력 제한 시작 시간
	@DateTimeFormat(pattern = "HH:mm.ss.SSS")
    @JsonFormat(shape= JsonFormat.Shape.STRING, pattern="HH:mm:ss", timezone="Asia/Seoul") //날짜 포멧 바꾸기
	@Column(name = "LIMIT_BEGIN_TM")
	private LocalTime limitBeginTm;
	
	// 입력 제한 종료 시간
	@DateTimeFormat(pattern = "HH:mm.ss.SSS")
    @JsonFormat(shape= JsonFormat.Shape.STRING, pattern="HH:mm:ss", timezone="Asia/Seoul") //날짜 포멧 바꾸기
	@Column(name = "LIMIT_END_TM")
	private LocalTime limitEndTm;
	
	@Column(name = "QUIZ_USE_YN", nullable = false, length = 1)
	@Enumerated(EnumType.STRING)
	private Yn quizUseYn;
	
	@Column(name = "QUIZ_TYP_CD", length = 35)
	@Enumerated(EnumType.STRING)
	private QuizTypCd quizTypCd;
	
	@Column(name = "DEL_YN", nullable = false, length = 1)
	@Enumerated(EnumType.STRING)
	private Yn delYn;
	
	
	@OneToMany(mappedBy = "tdTodo", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JsonIgnore
	private List<TdWork> tdWorkList = new ArrayList<>(1);
	
	@OneToMany(mappedBy = "tdTodo", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JsonIgnore
	private List<TdCheckerMap> tdCheckerMapList = new ArrayList<>(1);
	
	@OneToMany(mappedBy = "tdTodo", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JsonIgnore
	private List<TdWorkerMap> tdWorkerMapList = new ArrayList<>(1);
	
}
