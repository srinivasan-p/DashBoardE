package com.dashboard.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.dashboard.beans.ScheduleBean;
import com.dashboard.beans.StudentSkillBean;
import com.dashboard.dao.StudentDAO;

@Service("studentService")
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
public class StudentImp implements Student {

	@Autowired
	StudentDAO studentDAO;

	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public String addStudentSkill(String pId, String skillarray) {

		return (studentDAO.addStudentSkill(pId, skillarray));

	}

	public ArrayList<String> viewStudentSkill(String pId) {
		
		return studentDAO.viewStudentSkill(pId);
	}
	
//<<<<<<< HEAD
	
	public String addEvent(String studentId,ScheduleBean sb) {
		return studentDAO.addSchedule(studentId,sb);
	}
//=======
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public boolean calculateSkill(String pId) {
		// TODO Auto-generated method stub
		return studentDAO.calculateSkill(pId);
//>>>>>>> branch 'master' of https://github.com/srinivasan-p/DashBoardE.git
	}
}
