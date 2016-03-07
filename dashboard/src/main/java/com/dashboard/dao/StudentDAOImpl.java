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
import com.dashboard.beans.ScheduleBean;
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

	

}
