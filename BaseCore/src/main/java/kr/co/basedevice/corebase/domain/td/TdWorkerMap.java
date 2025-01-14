package kr.co.basedevice.corebase.domain.td;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import kr.co.basedevice.corebase.domain.BaseEntity;
import kr.co.basedevice.corebase.domain.code.Yn;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "TD_WORKER_MAP")
@IdClass(TdWorkerMapId.class)
public class TdWorkerMap extends BaseEntity implements Serializable {

	private static final long serialVersionUID = -7899404903530496762L;
	
	@Id
	@Column(name = "TODO_SEQ", nullable = false)
	private Long todoSeq;
	
	@Id
	@Column(name = "WORKER_SEQ", nullable = false)
	private Long workerSeq;
	
	@Column(name = "WORKER_AGRE_YN", nullable = false, length = 1)
	@Enumerated(EnumType.STRING)
	private Yn workerAgreYn;
	
	@Column(name = "DEL_YN", nullable = false, length = 1)
	@Enumerated(EnumType.STRING)
	private Yn delYn;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JsonIgnore
	@JoinColumn(name = "TODO_SEQ", updatable = false, insertable = false)
	private TdTodo tdTodo;
}
