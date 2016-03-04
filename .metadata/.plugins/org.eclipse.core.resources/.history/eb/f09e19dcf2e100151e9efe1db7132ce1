package com.dashboard.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.dashboard.beans.TrainerBean;
import com.dashboard.dao.TrainerDAO;

@Service("trainerService")
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
public class TrainerImp implements Trainer {
	
	@Autowired
	TrainerDAO  trainerDAO;

	@Override
	public String addEvent(TrainerBean tb) {
		return trainerDAO.addEvent(tb);
	}

//	@Override
//	public ArrayList<DoctorBean> viewAllAvailableDoctors(Date date) {
//		
//		try
//		{
//			
//		if(date.equals(null))
//		{
//			return null;
//		}
//		else
//		{
//		
//		if(date!=null){
//			ArrayList<DoctorBean> doctorBeans=reporterDAO.availableDoctorsDetails(date);
//			System.out.println(date+"in reporter service ");
//			return doctorBeans;
//		}
//		}
//		}
//		catch(Exception e)
//		{
//			e.printStackTrace();
//			return null;
//		}
//		
//		return null;
//	}
//
//	@Override
//	public ArrayList<DoctorBean> intimateAdmin(Date date, String status) {
//		try
//		{
//			
//		if(date.equals(null) || status.equalsIgnoreCase(null)  ||  status.equalsIgnoreCase(""))
//		{
//			return null;
//		}
//		else
//		{
//		if(status!=null)
//		{
//			if(date!=null){
//				ArrayList<DoctorBean> doctorBeans=reporterDAO.listOfDoctors(date, status);
//				return doctorBeans;
//			}
//		}
//		}
//		}
//		catch(Exception e)
//		{
//			e.printStackTrace();
//			return null;
//		}
//		return null;
//	}

}
