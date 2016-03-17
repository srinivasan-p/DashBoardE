package com.dashboard.beans;

import java.util.Date;

import javax.annotation.Generated;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.springframework.web.multipart.MultipartFile;

@Entity
@Table(name="db_profile")
public class ProfileBean {

	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int autogen;
	
	
	@OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "pId")
	private CredentialBean pId;
	
	private String name;
	private String managerId;
	private String vertical;
	private String emailId;
	private String phoneNo;
	@Lob
	private byte[] photo;


	/*@Transient
	private MultipartFile f;

	public MultipartFile getF() {
		return f;
	}

	public void setF(MultipartFile f) {
		this.f = f;
	}
*/
	
	
	public byte[] getPhoto() {
		return photo;
	}



	public void setPhoto(byte[] photo) {
		this.photo = photo;
	}



	public void setUpdatedBy(String updatedBy) {
		this.updatedBy = updatedBy;
	}



	public void setUpdatedOn(Date updatedOn) {
		this.updatedOn = updatedOn;
	}



	public void setSkillPoints(int skillPoints) {
		this.skillPoints = skillPoints;
	}



	public CredentialBean getpId() {
		return pId;
	}



	public void setpId(CredentialBean pId) {
		this.pId = pId;
	}
	private String location;
	
	
	
	
	
	
	public String getName() {
		return name;
	}
	
	

	public void setName(String name) {
		this.name = name;
	}
	public String getManagerId() {
		return managerId;
	}
	public void setManagerId(String managerId) {
		this.managerId = managerId;
	}
	public String getVertical() {
		return vertical;
	}
	public void setVertical(String vertical) {
		this.vertical = vertical;
	}
	public String getEmailId() {
		return emailId;
	}
	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}
	public String getPhoneNo() {
		return phoneNo;
	}
	public void setPhoneNo(String phoneNo) {
		this.phoneNo = phoneNo;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}


private String updatedBy;
	

	private Date updatedOn;



private int skillPoints;

	public int getAutogen() {
	return autogen;
}



public void setAutogen(int autogen) {
	this.autogen = autogen;
}



public String getUpdatedBy() {
	return updatedBy;
}



public Date getUpdatedOn() {
	return updatedOn;
}



public int getSkillPoints() {
	return skillPoints;
}



	
	
}
