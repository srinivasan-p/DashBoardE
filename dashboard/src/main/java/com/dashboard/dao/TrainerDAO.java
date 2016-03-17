package com.dashboard.dao;

import com.dashboard.beans.AnnouncementBean;
import com.dashboard.beans.CredentialBean;
import com.dashboard.beans.ProfileBean;
import com.dashboard.beans.TrainerBean;

public interface TrainerDAO {
//		public ArrayList<DoctorBean> availableDoctorsDetails(Date date);
//		public ArrayList<DoctorBean> listOfDoctors(Date date,String status);
		public String addEvent(String pId,TrainerBean tb);

		public String deleteevent(String courseid);

		public String addMsg(AnnouncementBean announcementBean);
		public CredentialBean getTrainer(String trainerId);
		public ProfileBean getProfileBean(String id);

}
