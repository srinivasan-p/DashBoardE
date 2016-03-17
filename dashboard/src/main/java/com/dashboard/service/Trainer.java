package com.dashboard.service;

import com.dashboard.beans.AnnouncementBean;
import com.dashboard.beans.CredentialBean;
import com.dashboard.beans.ProfileBean;
import com.dashboard.beans.TrainerBean;

public interface Trainer {
//	ArrayList<DoctorBean> viewAllAvailableDoctors(Date date);
//	ArrayList<DoctorBean> intimateAdmin(Date date, String status);
	public String addEvent(String pId,TrainerBean tb);

	public String deleteevent(String courseid);

	public String addMsg(AnnouncementBean announcementBean);
	public CredentialBean getTrainer(String trainerId);
	public ProfileBean getProfileBean(String id);

}
