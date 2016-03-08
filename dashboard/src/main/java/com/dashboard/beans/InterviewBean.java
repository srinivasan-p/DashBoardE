package com.dashboard.beans;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "db_interview")
public class InterviewBean {

	@Id
	private String interviewId;
	private Date iDate;

	public String getInterviewId() {
		return interviewId;
	}

	public void setInterviewId(String interviewId) {
		this.interviewId = interviewId;
	}

	public Date getiDate() {
		return iDate;
	}

	public void setiDate(Date iDate) {
		this.iDate = iDate;
	}

	@Override
	public String toString() {
		return "InterviewBean [interviewId=" + interviewId + ", iDate=" + iDate + "]";
	}

}
