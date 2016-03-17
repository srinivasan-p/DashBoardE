package com.dashboard.beans;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;


@Entity
@Table(name="db_Notification")

public class NotificationBean {

	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int notficationId;
	
	@OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "pId")
	private CredentialBean studId;
	
	@OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "announcementId")
	private AnnouncementBean announcementId;
	
	private int status;				//0=>general 1=>after clicking
	
	
	
	public int getNotficationId() {
		return notficationId;
	}

	public void setNotficationId(int notficationId) {
		this.notficationId = notficationId;
	}

	public CredentialBean getStudId() {
		return studId;
	}

	public void setStudId(CredentialBean studId) {
		this.studId = studId;
	}

	public AnnouncementBean getAnnouncementId() {
		return announcementId;
	}

	public void setAnnouncementId(AnnouncementBean announcementId) {
		this.announcementId = announcementId;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	
	
}
