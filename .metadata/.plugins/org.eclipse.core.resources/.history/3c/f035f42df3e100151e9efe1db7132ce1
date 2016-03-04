package com.dashboard.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.dashboard.beans.TrainerBean;

@Repository("trainerDAO")
public class TrainerDAOImpl implements TrainerDAO{

	@Autowired
	SessionFactory sessionFactory;

	@Transactional(propagation=Propagation.REQUIRED,readOnly=false)
	@Override
	public String addEvent(TrainerBean tb) {
	Session s=sessionFactory.getCurrentSession();
	String courseId=(String) s.save(tb);
	if(courseId==null){
		return "failure";
	}
	else{
	return "Success";
	}
	
	}

//	public ArrayList<DoctorBean> availableDoctorsDetails(java.sql.Date sqldate) {
//		Session session= sessionFactory.getCurrentSession();
//		System.out.println(sqldate+"in reporter dao 1 ");
//
//		
//		//SQLQuery sqlQuery = session.createSQLQuery("select * from OCS_TBL_Doctor where OCS_TBL_Doctor.DOCTORID IN (select OCS_TBL_Leave.DOCTORID from OCS_TBL_Leave where LEAVEFROM<12-jun-1993 AND LEAVETO>12-jun-1993");
//		SQLQuery sqlQuery = session.createSQLQuery("select * from OCS_TBL_Doctor where OCS_TBL_Doctor.DOCTORID NOT IN (select OCS_TBL_Leave.DOCTORID from OCS_TBL_Leave where LEAVEFROM<= :dateGiven AND LEAVETO>= :dateGiven1)");
//		//sqlQuery.setParameter("docId", "va3341");
//		sqlQuery.setParameter("dateGiven", sqldate);
//		sqlQuery.setParameter("dateGiven1", sqldate);
//		
//		
////	 select count(OCS_TBL_APPOINTMENTS.APPOINTMENTID) from OCS_TBL_APPOINTMENTS where OCS_TBL_APPOINTMENTS.APPOINTMENTDATE= '14-DEC-98' and OCS_TBL_APPOINTMENTS.DOCTORID='DF1010'
//
//		sqlQuery.addEntity(DoctorBean.class);
//		
//		ArrayList<DoctorBean> availableDoctors = new ArrayList<>();
//
//		@SuppressWarnings("unchecked")
//		ArrayList<DoctorBean> doctors= (ArrayList<DoctorBean>) sqlQuery.list();
//		if(doctors!=null){
//		for(int i =0;i<doctors.size();i++){
//			SQLQuery sqlQuery2 = session.createSQLQuery("select count(OCS_TBL_APPOINTMENTS.APPOINTMENTID) from OCS_TBL_APPOINTMENTS where OCS_TBL_APPOINTMENTS.APPOINTMENTDATE= :sqldat and OCS_TBL_APPOINTMENTS.DOCTORID=:doctId");
//			sqlQuery2.setParameter("sqldat", sqldate);
//			sqlQuery2.setParameter("doctId", doctors.get(i).doctorID);
//			
//			int count = ((BigDecimal)sqlQuery2.uniqueResult()).intValue();
//			if(count>=0 && count<8){
//				availableDoctors.add(doctors.get(i));
//			}
//			
//		}
//		}
//		//System.out.println(doctors.get(0).city);
//		return availableDoctors;
//	}
//
//	@Override
//	public ArrayList<DoctorBean> listOfDoctors(java.sql.Date sqldate, String status) {
//		Session session= sessionFactory.getCurrentSession();
//		SQLQuery sqlQuery = session.createSQLQuery("select * from OCS_TBL_Doctor where OCS_TBL_Doctor.DOCTORID IN (select OCS_TBL_Leave.DOCTORID from OCS_TBL_Leave where LEAVEFROM<= :dateGiven AND LEAVETO>= :dateGiven1 AND STATUS=:sta)");		sqlQuery.setParameter("dateGiven", sqldate);
//		sqlQuery.setParameter("dateGiven1", sqldate);
//		sqlQuery.setParameter("sta", status);
//		sqlQuery.addEntity(DoctorBean.class);
//		@SuppressWarnings("unchecked")
//		ArrayList<DoctorBean> doctors= (ArrayList<DoctorBean>) sqlQuery.list();
//		//System.out.println(doctors.get(0).city);
//		return doctors;
//	}
	
}
