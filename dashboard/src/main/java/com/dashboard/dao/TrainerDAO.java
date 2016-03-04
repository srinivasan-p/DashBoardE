package com.dashboard.dao;

import com.dashboard.beans.TrainerBean;

public interface TrainerDAO {
//		public ArrayList<DoctorBean> availableDoctorsDetails(Date date);
//		public ArrayList<DoctorBean> listOfDoctors(Date date,String status);
		public String addEvent(String pId,TrainerBean tb);
}
