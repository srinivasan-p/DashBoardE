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

import org.hibernate.validator.constraints.NotEmpty;

@Entity
@Table(name = "db_profile")
public class ProfileBean {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int autogen;

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "pId")
	private CredentialBean pId;

	@NotEmpty
	private String name;
	@NotEmpty
	private String managerId;
	@NotEmpty
	private String vertical;
	@NotEmpty
	private String emailId;
	@NotEmpty
	private String location;
	@NotEmpty
	private String phoneNo;
	private Date updatedOn;
	private String updatedBy;

	public CredentialBean getpId() {
		return pId;
	}

	public void setpId(CredentialBean pId) {
		this.pId = pId;
	}

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

	public int getAutogen() {
		return autogen;
	}

	public void setAutogen(int autogen) {
		this.autogen = autogen;
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
