package com.dashboard.dao;


import org.hibernate.Session;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.dashboard.beans.ConflictBean;
import com.dashboard.beans.CredentialBean;
import com.dashboard.beans.ScheduleBean;
import com.dashboard.beans.TrainerBean;
import com.dashboard.util.DBUtill;

@Repository("trainerDAO")
public class TrainerDAOImpl implements TrainerDAO{

	@Autowired
	SessionFactory sessionFactory;

	public String addEvent(String pId,TrainerBean tb) 
	{
	Session s=sessionFactory.getCurrentSession();
	
	
	
	CredentialBean cb = (CredentialBean) s.get(CredentialBean.class, pId);
	tb.setTrainerId(cb);

	String courseId=(String) s.save(tb);
	if(courseId==null){
		return "failure";
	}
	else{
	return "Success";
	}
	
	}

	public String deleteevent(String courseid) 
	{
		try
		{
			Connection conn = DBUtill.getDBConnection();

		Session session = sessionFactory.getCurrentSession();
		/*Query query2 = session.createQuery("from TrainerBean where courseId=?");
		query2.setParameter(0, courseid);
		TrainerBean tb=(TrainerBean) query2.list().get(0);*/
		TrainerBean tb=(TrainerBean) session.get(TrainerBean.class, courseid);
		Query query =session.createQuery("from ScheduleBean where courseId=?");
		query.setParameter(0, courseid);
		@SuppressWarnings("unchecked")
		ArrayList<ScheduleBean>sb = (ArrayList<ScheduleBean>) query.list();
		for (ScheduleBean scheduleBean : sb) 
		{
			String sno;
			CredentialBean Scb = scheduleBean.getStudentId();
			String event = tb.getTitle();
			String Courseid = scheduleBean.getCourseId();
			Date stdate = tb.getStartDate();
			/*
			ConflictBean cb = new ConflictBean();
			cb.setpId(Scb);
			cb.setEvent(event);
			cb.setCourseId(Courseid);
			cb.setStdate(stdate);
			session.save(cb);*/
			
			sno = Courseid+Scb.getpId();
	        java.sql.Date sqlstdate = new java.sql.Date(stdate.getTime());
	        
	        
			PreparedStatement pre = conn.prepareStatement("INSERT INTO newdb.db_Conflict (Sno,courseId,event,stdate,pId) VALUES (?,?,?,?,?)");
			pre.setString(1, sno);
			pre.setString(2, Courseid);
			pre.setString(3, event);
			pre.setDate(4,sqlstdate);
			pre.setString(5, Scb.getpId());
			pre.execute();
		}
		
			PreparedStatement pre = conn.prepareStatement("delete from newdb.db_schedule where courseId = ?");
			pre.setString(1, courseid);
			pre.execute();
			
			PreparedStatement pre1 = conn.prepareStatement("delete from newdb.db_Trainer where courseId = ?");
			pre1.setString(1, courseid);
			pre1.execute();

		return "success";
		}
		catch (HibernateException e)
		{
		e.printStackTrace();
			return "fail";
		}
		catch (Exception e)
		{
		e.printStackTrace();
			return "fail";
		}
		
	}


	
}
