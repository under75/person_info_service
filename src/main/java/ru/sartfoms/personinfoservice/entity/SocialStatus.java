package ru.sartfoms.personinfoservice.entity;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;

@Entity
@Table(name = "mpi_social_status", schema = "OMCOWNER")
@IdClass(CompositeKey.class)
public class SocialStatus {
	@Id
	@Column(name = "rid")
	private Long rid;

	@Id
	@Column(name = "nr")
	private Integer nr;

	@Column(name = "socialstatus")
	private Integer socialStatus;

	@Column(name = "dsourcetype")
	private String dsourceType;

	@Column(name = "dsource")
	private String dsource;

	@Column(name = "descr")
	private String descr;

	@Column(name = "regdate")
	private LocalDate regDate;

	public SocialStatus() {
	}

	public Long getRid() {
		return rid;
	}

	public void setRid(Long rid) {
		this.rid = rid;
	}

	public Integer getNr() {
		return nr;
	}

	public void setNr(Integer nr) {
		this.nr = nr;
	}

	public Integer getSocialStatus() {
		return socialStatus;
	}

	public void setSocialStatus(Integer socialStatus) {
		this.socialStatus = socialStatus;
	}

	public String getDsourceType() {
		return dsourceType;
	}

	public void setDsourceType(String dsourceType) {
		this.dsourceType = dsourceType;
	}

	public String getDsource() {
		return dsource;
	}

	public void setDsource(String dsourceStr) {
		this.dsource = dsourceStr;
	}

	public String getDescr() {
		return descr;
	}

	public void setDescr(String descr) {
		this.descr = descr;
	}

	public LocalDate getRegDate() {
		return regDate;
	}

	public void setRegDate(LocalDate regDate) {
		this.regDate = regDate;
	}

}
