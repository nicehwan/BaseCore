package kr.co.basedevice.corebase.domain.td;

import java.io.Serializable;
import java.time.LocalDateTime;
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
import kr.co.basedevice.corebase.domain.code.Yn;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "TD_SETLE")
@SequenceGenerator(name = "SEQGEN_TD_SETLE", sequenceName = "SEQ_TD_SETLE", initialValue = 1000, allocationSize = 1)
public class TdSetle extends BaseEntity implements Serializable{
	
	private static final long serialVersionUID = -8236512668919876948L;

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQGEN_TD_SETLE")
	@Column(name = "SETLE_SEQ", nullable = false)
	private Long setleSeq;

	@Column(name = "WORKER_SEQ", nullable = false)
	private Long workerSeq;
	
	@Column(name = "ACOUNT_SEQ", nullable = false)
	private Long acountSeq;
	
	@Column(name = "TOTAL_SETLE_POINT", nullable = false)
	private Integer totalSetlePoint;
	
	@Column(name = "ACCUMULT_POINT", nullable = false)
	private Integer accumultPoint;
	
	@Column(name = "SETLE_DESC")
	private String setleDesc;
	
	@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm.ss.SSS")
    @JsonFormat(shape= JsonFormat.Shape.STRING, pattern="yyyy-MM-dd HH:mm:ss", timezone="Asia/Seoul") //날짜 포멧 바꾸기
	@Column(name = "SETLE_DT")
	private LocalDateTime setleDt;
	
	@Column(name = "DEL_YN", nullable = false, length = 1)
	@Enumerated(EnumType.STRING)
	private Yn delYn;
	
	@OneToMany(mappedBy = "tdSetle", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JsonIgnore
	private List<TdWorkSetleMap> tdWorkSetleMapList = new ArrayList<>(1);
}
