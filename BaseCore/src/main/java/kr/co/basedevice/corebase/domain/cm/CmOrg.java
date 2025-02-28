package kr.co.basedevice.corebase.domain.cm;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import kr.co.basedevice.corebase.domain.BaseEntity;
import kr.co.basedevice.corebase.domain.code.Yn;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "CM_ORG")
@SequenceGenerator(name = "SEQGEN_CM_ORG", sequenceName = "SEQ_CM_ORG", initialValue = 1000, allocationSize = 1)
public class CmOrg extends BaseEntity implements Serializable{

	private static final long serialVersionUID = -5944084318276973516L;

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQGEN_CM_ORG")
	@Column(name = "ORG_SEQ", nullable = false)
	private Long orgSeq;
	
	@Column(name = "UP_ORG_SEQ")
	private Long upOrgSeq;
	
	@Column(name = "ORG_NM", length = 30, nullable = false)
	private String orgNm;
	
	@Column(name = "ORG_DESC", length = 2000)
	private String orgDesc;
	
	@Column(name = "PRNT_ORD", nullable = false)
	private Integer prntOrd;

	@Column(name = "DEL_YN", nullable = false, length = 1)
	@Enumerated(EnumType.STRING)
	private Yn delYn;
	
	@OneToMany(mappedBy = "cmOrg", cascade = CascadeType.ALL)
	@JsonIgnore
	private List<CmOrgUserMap> cmOrgUserMapList = new ArrayList<>(1);
}
