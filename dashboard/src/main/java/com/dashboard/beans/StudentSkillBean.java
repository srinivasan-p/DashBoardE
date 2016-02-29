package com.dashboard.beans;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="db_studskill")
public class StudentSkillBean {

	@Id
	private int skillAutoId;
	private String studentId;
	private int skillId;
	private Date updatedOn;
	private String updatedBy;
	
	
	public int getSkillAutoId() {
		return skillAutoId;
	}
	public void setSkillAutoId(int skillAutoId) {
		this.skillAutoId = skillAutoId;
	}
	public String getStudentId() {
		return studentId;
	}
	public void setStudentId(String studentId) {
		this.studentId = studentId;
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
