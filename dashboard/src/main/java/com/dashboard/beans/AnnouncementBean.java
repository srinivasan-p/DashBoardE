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

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name="db_Announcement")
//@SequenceGenerator(name="seq", initialValue=1000)
public class AnnouncementBean {

	@Override
	public String toString() {
		return "AnnouncementBean [announcemntId=" + announcemntId
				+ ", message=" + message + ", trainerId=" + trainerId
				+ ", announcemntDt=" + announcemntDt + ", subject=" + subject
				+ ", updatedBy=" + updatedBy + ", creationTime=" + creationTime
				+ ", getUpdatedBy()=" + getUpdatedBy() + ", getCreationTime()="
				+ getCreationTime() + ", getSubject()=" + getSubject()
				+ ", getAnnouncemntId()=" + getAnnouncemntId()
				+ ", getTrainerId()=" + getTrainerId() + ", getMessage()="
				+ getMessage() + ", getAnnouncemntDt()=" + getAnnouncemntDt()
				+ ", getClass()=" + getClass() + ", hashCode()=" + hashCode()
				+ ", toString()=" + super.toString() + "]";
	}
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int announcemntId;
	
	
	private String message;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="pId")
	private CredentialBean trainerId;
	
	@DateTimeFormat(pattern="dd/MM/yy")
	private Date announcemntDt;
	
	private String subject;
	
	
	private String updatedBy;
	public String getUpdatedBy() {
		return updatedBy;
	}
	public void setUpdatedBy(String updatedBy) {
		this.updatedBy = updatedBy;
	}
	public Date getCreationTime() {
		return creationTime;
	}
	public void setCreationTime(Date creationTime) {
		this.creationTime = creationTime;
	}
	private Date creationTime;
	
	public String getSubject() {
		return subject;
	}
	public void setSubject(String subject) {
		this.subject = subject;
	}
	public int getAnnouncemntId() {
		return announcemntId;
	}
	public void setAnnouncemntId(int announcemntId) {
		this.announcemntId = announcemntId;
	}
	
	public CredentialBean getTrainerId() {
		return trainerId;
	}
	public void setTrainerId(CredentialBean trainerId) {
		this.trainerId = trainerId;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public Date getAnnouncemntDt() {
		return announcemntDt;
	}
	public void setAnnouncemntDt(Date announcemntDt) {
		this.announcemntDt = announcemntDt;
	}
	
	
}
