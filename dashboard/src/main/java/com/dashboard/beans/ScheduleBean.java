package com.dashboard.beans;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="db_schedule")
public class ScheduleBean {

	@Id
	private int scheduleId;
	private String courseId;
	private Date updatedOn;
	private String updatedBy;
	
	@OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "pId")
	private CredentialBean studentId;
	
	private int completionStatus;
	public int getScheduleId() {
		return scheduleId;
	}
	public void setScheduleId(int scheduleId) {
		this.scheduleId = scheduleId;
	}
	
	
	public String getCourseId() {
		return courseId;
	}
	public void setCourseId(String courseId) {
		this.courseId = courseId;
	}
	public CredentialBean getStudentId() {
		return studentId;
	}
	public void setStudentId(CredentialBean studentId) {
		this.studentId = studentId;
	}
	public int getCompletionStatus() {
		return completionStatus;
	}
	public void setCompletionStatus(int completionStatus) {
		this.completionStatus = completionStatus;
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
