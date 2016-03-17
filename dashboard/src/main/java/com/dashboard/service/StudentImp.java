package com.dashboard.service;

import java.util.ArrayList;

import javax.json.JsonObject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.dashboard.beans.AnnouncementBean;
import com.dashboard.beans.AskBean;
import com.dashboard.beans.CredentialBean;
import com.dashboard.beans.NotificationBean;
import com.dashboard.beans.ProfileBean;
import com.dashboard.beans.ScheduleBean;
import com.dashboard.beans.TrainerBean;
import com.dashboard.dao.StudentDAO;

@Service("studentService")
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
public class StudentImp implements Student {

	@Autowired
	StudentDAO studentDAO;


	
	@Transactional(propagation=Propagation.REQUIRED,readOnly=true)
	public ArrayList<AnnouncementBean> viewAnnouncements() {
		return studentDAO.viewAnnouncements();
	}


	@Transactional(propagation=Propagation.REQUIRED,readOnly=true)
	public AnnouncementBean getAnnouncementBean(int anmtId) {
		// TODO Auto-generated method stub
		return studentDAO.getAnnouncementBean(anmtId);
	}


	@Transactional(propagation=Propagation.REQUIRED,readOnly=true)
	public CredentialBean getStudent(String studentId) {
		// TODO Auto-generated method stub
		return studentDAO.getStudent(studentId);
	}

	@Transactional(propagation=Propagation.REQUIRED,readOnly=false)
	public String addNotification(NotificationBean nb) {
		// TODO Auto-generated method stub
		return studentDAO.addNotification(nb);
	}


	@Transactional(propagation=Propagation.REQUIRED,readOnly=true)
	public int countOfanmts(String studentId) {
		// TODO Auto-generated method stub
		return studentDAO.countOfanmts(studentId);
	}

	@Transactional(propagation=Propagation.REQUIRED,readOnly=true)
	public int countOfSameAnmts(int anmtId, String studentId) {
		// TODO Auto-generated method stub
		return studentDAO.countOfSameAnmts(anmtId, studentId);
	}


	@Transactional(propagation=Propagation.REQUIRED,readOnly=true)
	public ArrayList<AnnouncementBean> readAnnouncements(String studentId) {
		// TODO Auto-generated method stub
		return studentDAO.readAnnouncements(studentId);
	}



	@Transactional(propagation=Propagation.REQUIRED,readOnly=true)
	public ArrayList<AnnouncementBean> readAnnouncementsSearch(String studentId, String subject) {
		// TODO Auto-generated method stub
		return studentDAO.readAnnouncementsSearch(studentId, subject);
	}

	
	@Transactional(propagation=Propagation.REQUIRED,readOnly=true)
	public ArrayList<AnnouncementBean> viewAnnouncementsSearch(String studentId, String subject) {
		// TODO Auto-generated method stub
		return studentDAO.viewAnnouncementsSearch(studentId, subject);
	}

	


	public JsonObject addEvent(TrainerBean tb, int pagenumber) {
		// TODO Auto-generated method stub
		return studentDAO.addEvent(tb, pagenumber);
	}


	public ProfileBean getProfileBean(String id) {
		// TODO Auto-generated method stub
		return studentDAO.getProfileBean(id);
	}

	
	public AskBean addPost(AskBean askbean) {
		// TODO Auto-generated method stub
		return studentDAO.addPost(askbean);
	}

	
	public AskBean addComment(AskBean askbean) {
		// TODO Auto-generated method stub
		return studentDAO.addComment(askbean);
	}
	
	
	
	
	
	
	
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


	public AskBean addCommentpost(AskBean askbean) {
		// TODO Auto-generated method stub
		return studentDAO.addCommentpost(askbean);
	}


	
}
