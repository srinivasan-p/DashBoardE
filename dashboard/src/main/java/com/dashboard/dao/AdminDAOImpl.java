package com.dashboard.dao;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.dashboard.beans.CredentialBean;
import com.dashboard.beans.InterviewBean;
import com.dashboard.beans.IntervieweeBean;
import com.dashboard.beans.InterviewerBean;
import com.dashboard.beans.ProfileBean;
import com.dashboard.beans.StudentSkillBean;
import com.dashboard.service.Trainer;

@Repository("adminDAO")
public class AdminDAOImpl implements AdminDAO {
	@Autowired
	SessionFactory sessionFactory;

	@Autowired
	Trainer trainerService;

	@SuppressWarnings("unchecked")
	public Map<ProfileBean, ArrayList<StudentSkillBean>> viewAllStudents() {

		Session session = sessionFactory.getCurrentSession();
		Query query = session.createQuery("from CredentialBean where type='s'");
		ArrayList<CredentialBean> cblist = (ArrayList<CredentialBean>) query.list();

		ArrayList<ProfileBean> pblist = new ArrayList<ProfileBean>();
		for (CredentialBean credentialBean : cblist) {
			query = session.createQuery("from ProfileBean where pId=?");
			query.setParameter(0, credentialBean);
			ProfileBean pb = new ProfileBean();
			pb = (ProfileBean) query.list().get(0);
			pblist.add(pb);
		}
		Map<ProfileBean, ArrayList<StudentSkillBean>> mapPBandSB = new HashMap<ProfileBean, ArrayList<StudentSkillBean>>();

		for (ProfileBean profileBean : pblist) {
			ArrayList<StudentSkillBean> sbList = new ArrayList<StudentSkillBean>();
			query = session.createQuery("from StudentSkillBean where pId=?");
			query.setParameter(0, profileBean.getpId());
			sbList = (ArrayList<StudentSkillBean>) query.list();
			mapPBandSB.put(profileBean, sbList);
		}
		return mapPBandSB;
	}

	public String iSchedule(String[] interviewer, String[] interviewee, Date iDate) {

		try {
			SimpleDateFormat sim = new SimpleDateFormat("yyyy-MM-dd HH:mm");
			Session session = sessionFactory.getCurrentSession();
			InterviewBean ib = new InterviewBean();
			ib.setInterviewId(sim.format(iDate));
			ib.setiDate(iDate);
			session.save(ib);
			
			for (int i = 0; i < interviewer.length; i++) {
				InterviewerBean interviewerBean = new InterviewerBean();
				interviewerBean.setInterviewerId(sim.format(iDate) + ":-:" +interviewer[i]);
				interviewerBean.setInterviewId(ib);
				CredentialBean cd = (CredentialBean) session.get(CredentialBean.class, interviewer[i]);
				interviewerBean.setpId(cd);
				session.save(interviewerBean);
			}
			
			for (int i = 0; i < interviewee.length; i++) {
				IntervieweeBean intervieweeBean = new IntervieweeBean();
				intervieweeBean.setIntervieweeId(sim.format(iDate) + ":-:" +interviewee[i]);
				intervieweeBean.setInterviewId(ib);
				CredentialBean cd = (CredentialBean) session.get(CredentialBean.class, interviewee[i]);
				intervieweeBean.setpId(cd);
				session.save(intervieweeBean);
			}
		} catch (Exception e) {
			e.printStackTrace();
			return "Failure";
		}
		
		return "Success";
	}

	@SuppressWarnings("unchecked")
	public Map<InterviewBean, Map<Map<ProfileBean,InterviewerBean>, Map<ProfileBean,IntervieweeBean>>> ViewAllScheduledInterview() {
		
		Map<InterviewBean, Map<Map<ProfileBean,InterviewerBean>, Map<ProfileBean,IntervieweeBean>>> interviewMap;
		try {
			interviewMap = new HashMap<InterviewBean, Map<Map<ProfileBean,InterviewerBean>, Map<ProfileBean,IntervieweeBean>>>();
			
			Session session = sessionFactory.getCurrentSession();
			Query query = session.createQuery("from InterviewBean");
			ArrayList<InterviewBean> interviewBeanList = (ArrayList<InterviewBean>) query.list();
			for (InterviewBean interviewBean : interviewBeanList) {
				query = session.createQuery("from InterviewerBean where interviewId=?");
				query.setParameter(0, interviewBean);
				ArrayList<InterviewerBean> interviewerBeanList = (ArrayList<InterviewerBean>) query.list();
				
				Map<ProfileBean,InterviewerBean> pbInterviewerMap = new HashMap<ProfileBean, InterviewerBean>();
				for (InterviewerBean interviewerBean : interviewerBeanList) {
					query = session.createQuery("from ProfileBean where pId=?");
					query.setParameter(0, interviewerBean.getpId());
					ProfileBean pb = new ProfileBean();
					pb = (ProfileBean) query.list().get(0);
					pbInterviewerMap.put(pb, interviewerBean);
				}
				
				query = session.createQuery("from IntervieweeBean where interviewId=?");
				query.setParameter(0, interviewBean);
				ArrayList<IntervieweeBean> intervieweeBeanList = (ArrayList<IntervieweeBean>) query.list();
				
				Map<ProfileBean,IntervieweeBean> pbIntervieweeMap = new HashMap<ProfileBean, IntervieweeBean>();
				for (IntervieweeBean intervieweeBean : intervieweeBeanList) {
					query = session.createQuery("from ProfileBean where pId=?");
					query.setParameter(0, intervieweeBean.getpId());
					ProfileBean pb = new ProfileBean();
					pb = (ProfileBean) query.list().get(0);
					pbIntervieweeMap.put(pb, intervieweeBean);
				}
				
				Map<Map<ProfileBean,InterviewerBean>, Map<ProfileBean,IntervieweeBean>> interviewMapNested = new HashMap<Map<ProfileBean,InterviewerBean>, Map<ProfileBean,IntervieweeBean>>();
				interviewMapNested.put(pbInterviewerMap, pbIntervieweeMap);
				interviewMap.put(interviewBean, interviewMapNested);
			}
		} catch (HibernateException e) {
			e.printStackTrace();
			return null;
		}
		System.out.println(interviewMap.toString());
		return interviewMap;
	}



}
