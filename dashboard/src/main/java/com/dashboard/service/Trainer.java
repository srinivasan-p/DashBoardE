package com.dashboard.service;

import com.dashboard.beans.TrainerBean;

public interface Trainer {
//	ArrayList<DoctorBean> viewAllAvailableDoctors(Date date);
//	ArrayList<DoctorBean> intimateAdmin(Date date, String status);
	public String addEvent(String pId,TrainerBean tb);
}
