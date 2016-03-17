package com.dashboard.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.Map;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.dashboard.beans.InterviewBean;
import com.dashboard.beans.IntervieweeBean;
import com.dashboard.beans.InterviewerBean;
import com.dashboard.beans.ProfileBean;
import com.dashboard.beans.SkillBean;
import com.dashboard.beans.StudentSkillBean;
import com.dashboard.dao.AdminDAO;

@Service("adminService")
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
public class AdministratorImp implements Administrator {
	@Autowired
	SessionFactory sessionFactory;
	@Autowired
	AdminDAO adminDAO;
	@Autowired
	Trainer trainerService;

	public Map<ProfileBean, ArrayList<StudentSkillBean>> viewAllStudents() {

		return adminDAO.viewAllStudents();

	}
	
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = false)
	public String iSchedule(String[] interviewer, String[] interviwee, Date iDate) {
		
		return adminDAO.iSchedule(interviewer, interviwee, iDate);
	}

	public Map<InterviewBean, Map<Map<ProfileBean, InterviewerBean>, Map<ProfileBean, IntervieweeBean>>> ViewAllScheduledInterview() {
		return adminDAO.ViewAllScheduledInterview();
	}

	public String DeleteInterview(String[] interviewIDstoDelete) {
		return adminDAO.DeleteInterview(interviewIDstoDelete);
	}

	public Map<ProfileBean, ArrayList<StudentSkillBean>> viewAllTrainers() {
		return adminDAO.viewAllTrainers();
	}

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = false)
	public String aa(String id) 
	{
		String result=adminDAO.aa(id);
		return result;
	}

	//vvvvvvvvvvvvvvv
	public ProfileBean getProfileBean(String id) {
		// TODO Auto-generated method stub
		return adminDAO.getProfileBean(id);
	}

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = false)
	public String addSkill(SkillBean skillBean) {
		// TODO Auto-generated method stub
		return adminDAO.addSkill(skillBean);
	}

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = false)
	public int deleteSkill(int skillId) {
		// TODO Auto-generated method stub
		return adminDAO.deleteSkill(skillId);
	}

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public ArrayList<SkillBean> viewSkills() {
		// TODO Auto-generated method stub
		return adminDAO.viewSkills();
	}

}
