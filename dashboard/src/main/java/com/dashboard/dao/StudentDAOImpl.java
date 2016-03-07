package com.dashboard.dao;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.Date;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.dashboard.beans.CredentialBean;
//<<<<<<< HEAD
import com.dashboard.beans.ScheduleBean;
//=======
import com.dashboard.beans.ProfileBean;
//>>>>>>> branch 'master' of https://github.com/srinivasan-p/DashBoardE.git
import com.dashboard.beans.SkillBean;
import com.dashboard.beans.StudentSkillBean;
import com.dashboard.util.DBUtill;

@Repository("studentDAO")
public class StudentDAOImpl implements StudentDAO {

	@Autowired
	SessionFactory sessionFactory;
	@Transactional(propagation=Propagation.REQUIRED,readOnly=false)

	public String addSchedule(String studentId,ScheduleBean sb) {
		
		Connection Conn;
		try 
		{
			Conn = DBUtill.getDBConnection();
			String pId = studentId;
			System.out.println("before insertaion into the db........");
			System.out.println(sb.getCompletionStatus());
			System.out.println(sb.getCourseId());
			System.out.println(sb.getScheduleId());
			System.out.println(pId);
			Session session = sessionFactory.getCurrentSession();
			CredentialBean cb = (CredentialBean) session.get(CredentialBean.class, pId);
			System.out.println(cb.getPassword());
			System.out.println(cb.getpId());
			System.out.println(cb.getStatus());
			System.out.println(cb.getType());
			sb.setStudentId(cb);
			String scheduleId=(String) session.save(sb);

			if(scheduleId == null){
				return "failure";
			}
			else{
			return "Success";
			}
		} 
		catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "failure";

		
		

	}

	public String addStudentSkill(String pId, String skillarray) {

		try {
			String[] skilla = skillarray.trim().split(",");
			for (int i = 0; i < skilla.length; i++) {
				StudentSkillBean ssb = new StudentSkillBean();
				Session session = sessionFactory.getCurrentSession();
				CredentialBean cd = (CredentialBean) session.get(CredentialBean.class, pId);
				ssb.setpId(cd);
				int skillId = Integer.parseInt(skilla[i].trim());
				SkillBean sb = (SkillBean) session.get(SkillBean.class, skillId);
				ssb.setSkillId(sb);
				ssb.setUpdatedBy(pId);
				ssb.setUpdatedOn(new Date());
				session.save(ssb);
			}
		} catch (Exception e) {
			System.out.println(e);
			return "Failure";
		}
		return "Success";

	}

	public ArrayList<String> viewStudentSkill(String pId) {
		Session session = sessionFactory.getCurrentSession();
		CredentialBean cd = (CredentialBean) session.get(CredentialBean.class, pId);
		Query query = session.createQuery(
				"select s.skillName from StudentSkillBean as ss INNER JOIN ss.skillId as s where ss.pId=?");
		query.setParameter(0, cd);
		@SuppressWarnings("unchecked")
		ArrayList<String> list = (ArrayList<String>) query.list();
		return list;
	}

//<<<<<<< HEAD
	
//=======
	public boolean calculateSkill(String pId) {

		try {
			Session session = sessionFactory.getCurrentSession();
			CredentialBean cb = (CredentialBean) session.get(CredentialBean.class, pId);
			Query query = session.createQuery("from StudentSkillBean where pId=?");
			query.setParameter(0, cb);
			ArrayList<StudentSkillBean> ssblist = (ArrayList<StudentSkillBean>) query.list();
			int points = ssblist.size() * 10;
			
			
			CredentialBean cb1 = (CredentialBean) session.get(CredentialBean.class, pId);
			query = session.createQuery("from ProfileBean where pId=?");
			query.setParameter(0, cb1);
			ArrayList<ProfileBean> pblist = (ArrayList<ProfileBean>) query.list();
			if(!pblist.isEmpty()){
				ProfileBean pb1 = (ProfileBean) pblist.get(0);
				pb1.setSkillPoints(points);
				Session sessin = sessionFactory.getCurrentSession();

				sessin.update(pb1);
			}

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
		return true;

	}

	
//>>>>>>> branch 'master' of https://github.com/srinivasan-p/DashBoardE.git

}
