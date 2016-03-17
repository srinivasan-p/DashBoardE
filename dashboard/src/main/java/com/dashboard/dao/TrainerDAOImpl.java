package com.dashboard.dao;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.ArrayList;
import java.util.Date;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.dashboard.beans.AnnouncementBean;
import com.dashboard.beans.CredentialBean;
import com.dashboard.beans.ProfileBean;
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
	
	
	@Transactional(propagation=Propagation.REQUIRED,readOnly=false)
	public String addMsg(AnnouncementBean announcementBean) {
		Session session = sessionFactory.getCurrentSession();
		//Query query=session.createSQLQuery("insert into db_Announcement values(?,?,?)");
		//query.setInteger(0,11);
		/*query.setString(1,announcementBean.getTrainerId().getpId());
		query.setString(2,announcementBean.getMessage());
		query.setDate(3,new java.sql.Date(announcementBean.getAnnouncemntDt().getTime()));*/
		
		
		//int count = query.executeUpdate();
		int annId=(Integer) session.save(announcementBean);
		System.out.println("rows affected: "+annId);
		if(annId!=0){
			System.out.println("success");
			return "success";
		}
		else{
			System.out.println("fail");
			return "fail";
		}
		
		
	}

	
	@Transactional(propagation=Propagation.REQUIRED,readOnly=true)
	public CredentialBean getTrainer(String trainerId) {
		if(trainerId!=null&&!trainerId.equals("")){
		CredentialBean credentialBean=new CredentialBean();
		Session session = sessionFactory.getCurrentSession();
		credentialBean=(CredentialBean) session.get(CredentialBean.class,trainerId);
		if(credentialBean==null){
			return null;
		}
		else{
			System.out.println(credentialBean.getpId());
			return credentialBean;
		}
		}
		return null;
	}
	
	

	@Transactional(propagation=Propagation.REQUIRED,readOnly=true)
	public ProfileBean getProfileBean(String id){
		if(id!=null&&!id.equals("")){
		
		ArrayList<ProfileBean> pb=new ArrayList<ProfileBean>();
		Session session = sessionFactory.getCurrentSession();
		//profileBean=(ProfileBean) session.get(ProfileBean.class,id);
		
		SQLQuery query=session.createSQLQuery("select * from db_profile where pId=?");
		query.setString(0,id);
		query.addEntity(ProfileBean.class);
		pb=(ArrayList<ProfileBean>) query.list();
		//System.out.println(profileBean);
		for(ProfileBean p:pb){
			System.out.println(p);
			return p;
		
		}
		
		}
		return null;
	}




	
}
