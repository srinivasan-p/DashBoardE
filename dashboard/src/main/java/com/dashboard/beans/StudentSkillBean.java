package com.dashboard.beans;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "db_studskill")
public class StudentSkillBean {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int skillAutoId;

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "pId")
	private CredentialBean pId;
	private int skillId;
	private Date updatedOn;
	private String updatedBy;

	public int getSkillAutoId() {
		return skillAutoId;
	}

	public void setSkillAutoId(int skillAutoId) {
		this.skillAutoId = skillAutoId;
	}

	public CredentialBean getpId() {
		return pId;
	}

	public void setpId(CredentialBean pId) {
		this.pId = pId;
	}

	public int getSkillId() {
		return skillId;
	}

	public void setSkillId(int skillId) {
		this.skillId = skillId;
	}

	public Date getUpdatedOn() {
		return updatedOn;
	}

	public void setUpdatedOn(Date updatedOn) {
		this.updatedOn = updatedOn;
	}

	public String getUpdatedBy() {
		return updatedBy;
	}

	public void setUpdatedBy(String updatedBy) {
		this.updatedBy = updatedBy;
	}

}
