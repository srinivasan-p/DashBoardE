package com.dashboard.beans;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "db_interviewer")
public class InterviewerBean {

	@Id
	private String interviewerId;

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "interviewId")
	private InterviewBean interviewId;

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "pId")
	private CredentialBean pId;

	public String getInterviewerId() {
		return interviewerId;
	}

	public void setInterviewerId(String interviewerId) {
		this.interviewerId = interviewerId;
	}

	public InterviewBean getInterviewId() {
		return interviewId;
	}

	public void setInterviewId(InterviewBean interviewId) {
		this.interviewId = interviewId;
	}

	public CredentialBean getpId() {
		return pId;
	}

	public void setpId(CredentialBean pId) {
		this.pId = pId;
	}

}
