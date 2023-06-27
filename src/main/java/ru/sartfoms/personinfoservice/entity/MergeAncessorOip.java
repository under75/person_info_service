package ru.sartfoms.personinfoservice.entity;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "MPI_GET_MERGE_ANCESSOR_OIP", schema = "ASY23")
public class MergeAncessorOip {
	@Id
	@Column(name = "rid")
	private Long rid;

	@Column(name = "dt_ins")
	private LocalDateTime dtIns;

	@Column(name = "usr")
	private String usr;
	
	@Column(name = "oip")
	private String oip;
	
	@Column(name = "dt_req")
	private LocalDateTime dtreq;
	
	@Column(name = "err")
	private Boolean hasError;
	
	@Column(name = "when_merged")
	private LocalDateTime whenMerged;
	
	@Column(name = "merge_ancessor_oip")
	private String mergeAncessorOip;

	public Long getRid() {
		return rid;
	}

	public LocalDateTime getDtIns() {
		return dtIns;
	}

	public String getUsr() {
		return usr;
	}

	public String getOip() {
		return oip;
	}

	public LocalDateTime getDtreq() {
		return dtreq;
	}

	public Boolean getHasError() {
		return hasError;
	}

	public LocalDateTime getWhenMerged() {
		return whenMerged;
	}

	public String getMergeAncessorOip() {
		return mergeAncessorOip;
	}

	public void setRid(Long rid) {
		this.rid = rid;
	}

	public void setDtIns(LocalDateTime dtIns) {
		this.dtIns = dtIns;
	}

	public void setUsr(String usr) {
		this.usr = usr;
	}

	public void setOip(String oip) {
		this.oip = oip;
	}

	public void setDtreq(LocalDateTime dtreq) {
		this.dtreq = dtreq;
	}

	public void setHasError(Boolean hasError) {
		this.hasError = hasError;
	}

	public void setWhenMerged(LocalDateTime whenMerged) {
		this.whenMerged = whenMerged;
	}

	public void setMergeAncessorOip(String mergeAncessorOip) {
		this.mergeAncessorOip = mergeAncessorOip;
	}
	
}
