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
	
	@Transactional(propagation=Propagation.REQUIRED,readOnly=false)
	public String addEvent(String pId, TrainerBean tb) {
		return trainerDAO.addEvent(pId,tb);
	}
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public String deleteevent(String courseid) 
	{
		String rs=trainerDAO.deleteevent(courseid);
		return rs;
		
	}
}
