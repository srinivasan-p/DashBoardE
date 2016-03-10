package com.dashboard.beans;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="db_Conflict")
public class ConflictBean 
{
	@Id
	String Sno;
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="pId")
	CredentialBean pId;
	String event ;
	String courseId; 
	Date stdate;
	public CredentialBean getpId() {
		return pId;
	}
	public void setpId(CredentialBean pId) {
		this.pId = pId;
	}
	public String getEvent() {
		return event;
	}
	public void setEvent(String event) {
		this.event = event;
	}
	public String getCourseId() {
		return courseId;
	}
	public void setCourseId(String courseId) {
		this.courseId = courseId;
	}
	public Date getStdate() {
		return stdate;
	}
	public void setStdate(Date stdate) {
		this.stdate = stdate;
	} 
	

}
