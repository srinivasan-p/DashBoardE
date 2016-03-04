package com.dashboard.dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.dashboard.beans.CredentialBean;
import com.dashboard.beans.ProfileBean;
import com.dashboard.beans.SkillBean;
import com.dashboard.beans.StudentSkillBean;
import com.dashboard.service.Trainer;

@Repository("adminDAO")
public class AdminDAOImpl implements AdminDAO
{
	@Autowired
	SessionFactory sessionFactory;
	
	@Autowired
	Trainer  trainerService;

	public Map<ProfileBean, StudentSkillBean> viewAllStudents() {
		
		Session session= sessionFactory.getCurrentSession();
		Query query = session.createQuery("from CredentialBean where type='s'");
		ArrayList<CredentialBean> cblist = (ArrayList<CredentialBean>) query.list();
		System.out.println(cblist.size() + "   " + cblist.toString() );
		ArrayList<ProfileBean> pblist = new ArrayList<ProfileBean>() ;
		for (CredentialBean credentialBean : cblist) {
			query = session.createQuery("from ProfileBean where pId=?");
			query.setParameter(0, credentialBean);
			ProfileBean pb = new ProfileBean();
			pb = (ProfileBean) query.list().get(0);
			System.out.println(pb.toString());
			pblist.add(pb);
		}
		Map<ProfileBean, StudentSkillBean> mapPBandSB = new HashMap<ProfileBean, StudentSkillBean>();
		
		for (ProfileBean profileBean : pblist) {
			ArrayList<StudentSkillBean> sbList= new ArrayList<StudentSkillBean>(); 
			query = session.createQuery("from StudentSkillBean where pId=?");
			query.setParameter(0, profileBean.getpId());
			sbList = (ArrayList<StudentSkillBean>) query.list();
			System.out.println(sbList.size()  + "   " + sbList.toString() );
			for (StudentSkillBean studentSkillBean : sbList) {
				mapPBandSB.put(profileBean, studentSkillBean);
				System.out.println(studentSkillBean.toString() );
				System.out.println("*************** from map loop");
			}
		}
		System.out.println();
		System.out.println();
		System.out.println(mapPBandSB.size()  + "   " + mapPBandSB.toString() );
		return mapPBandSB;
	}

//	@Override
//	public String addDoctor(DoctorBean doctoerBean) 
//	{
//		try
//		{
////		System.out.println(doctoerBean.getCity());	
////		System.out.println(doctoerBean.getContactNumber());	
//		System.out.println("**********"+doctoerBean.getDateOfBirth());
//		Session session = sessionFactory.getCurrentSession();
//		SQLQuery query = session
//				.createSQLQuery("select OCS_SEQ_DOCTORID.NEXTVAL from dual");
//		int seq = ((BigDecimal) query.uniqueResult()).intValue();
//		System.out.println(seq);
//		doctoerBean.setDoctorID(doctoerBean.getDoctorName().toUpperCase()
//				.substring(0, 2)
//				+ seq);
//		String id=doctoerBean.getDoctorID();
//
//		System.out.println(id);	
//	
//		session.saveOrUpdate(doctoerBean);
//		
//		DoctorImages doctorImages = new DoctorImages();
//		doctorImages.setDoctorID(doctoerBean.getDoctorID());
//		doctorImages.setDoctorprofileImgName(doctoerBean.getProfileImgName());
//		doctorImages.setDotcorProfileImg(doctoerBean.getProfileImage());
//		session.save(doctorImages);
//		
//		System.out.println("doctor bean creation ");
//		return id;
//		}
//		catch (Exception e)
//		{
//			e.getCause();
//			return null;
//		}
//	}
//
//	@Override
//	public Boolean modifyDoctor(DoctorBean doctorBean) 
//	{
//		try
//		{
//		System.out.println(doctorBean.getCity());	
//		System.out.println(doctorBean.getContactNumber());	
//		Session session = sessionFactory.getCurrentSession();
//		String id=doctorBean.getDoctorID();
//
//		System.out.println(id);	
//		doctorBean.setDoctorID(id);
//		session.update(doctorBean);
//		System.out.println("doctor bean modification ");
//		return true;
//		}
//		catch (Exception e)
//		{
//			e.printStackTrace();
//			return false;
//		}
//	}
//
//	@Override
//	public ArrayList<DoctorBean> viewAllDoctors() 
//	{
//		Session sess = sessionFactory.getCurrentSession();
//		Query query = sess.createQuery("from DoctorBean");
//		ArrayList<DoctorBean> doctor = (ArrayList<DoctorBean>) query.list();
//		return doctor;
//
//	}
//
//	@Override
//	@Transactional(propagation = Propagation.SUPPORTS, readOnly = false)
//	public int removeDoctor(String doctorID) 
//	{
//
//		try
//		{
//			System.out.println(doctorID + "doctor id");
//			Session session = sessionFactory.getCurrentSession();	
//			DoctorBean bean=	(DoctorBean)session.get(DoctorBean.class, doctorID);
//			
//			//second
//			SQLQuery sqlQueryDelete = session.createSQLQuery("SELECT  patientID FROM OCS_TBL_APPOINTMENTS WHERE OCS_TBL_APPOINTMENTS.DOCTORID=:doctorID");
//			
//			sqlQueryDelete.setParameter("doctorID", doctorID);
//			List PatientIdList=sqlQueryDelete.list();
//			if(PatientIdList.size()==0)
//			{
//				SQLQuery sqlQuery = session.createSQLQuery("DELETE FROM OCS_TBL_APPOINTMENTS WHERE OCS_TBL_APPOINTMENTS.DOCTORID=:doctorID");
//				sqlQuery.setParameter("doctorID", doctorID);
//				int i=sqlQuery.executeUpdate();
//				if(i>1){
//					System.out.println("deleted record in appointment");
//				}
//				SQLQuery sqlQueryLeave = session.createSQLQuery("DELETE FROM OCS_TBL_LEAVE WHERE OCS_TBL_LEAVE.DOCTORID=:doctorID");
//				sqlQueryLeave.setParameter("doctorID", doctorID);
//				int checkforleave=sqlQueryLeave.executeUpdate();
//
//				if(checkforleave>1){
//					System.out.println("deleted record in Leave");
//				}
//				SQLQuery sqlQuerySchedule = session.createSQLQuery("DELETE FROM OCS_TBL_SCHEDULES WHERE OCS_TBL_SCHEDULES.DOCTORID=:doctorID");
//				sqlQuerySchedule.setParameter("doctorID", doctorID);
//				int checkforSchedule=sqlQuerySchedule.executeUpdate();
//
//				if(checkforSchedule>1){
//					System.out.println("deleted record in Schedule");
//				}
//				session.delete(bean);
//				System.out.println("doctor bean delete ");
//				return 1;	
//			}
//			else
//			{
//				System.out.println("i m here else part");
//				
//				
//				SQLQuery sqlQueryDelete1 = session.createSQLQuery("SELECT  appointmentDate FROM OCS_TBL_APPOINTMENTS WHERE OCS_TBL_APPOINTMENTS.DOCTORID=:doctorID");
//				sqlQueryDelete1.setParameter("doctorID", doctorID);
//				Session ses = sessionFactory.getCurrentSession();
//				SuggestBean SuggestBean= new SuggestBean();
//				DoctorBean DoctorBean1 = (DoctorBean)ses.get(DoctorBean.class, doctorID);
//				String specific=DoctorBean1.getSpecialization();
//				System.out.println(specific + "==+++++++++++++");
//				List<Date> appointList1=sqlQueryDelete1.list();
//				
//				System.out.println(appointList1.get(0) + "date-----");
//
//			/*	return 1;*/
//				
//			
//				for (Date object : appointList1) {
//					
//					SQLQuery sqlQueryDelete2 = session.createSQLQuery("SELECT  patientID FROM OCS_TBL_APPOINTMENTS WHERE (OCS_TBL_APPOINTMENTS.DOCTORID=:doctorID) and (OCS_TBL_APPOINTMENTS.appointmentDate=:appdate)");
//					sqlQueryDelete2.setParameter("appdate", new java.sql.Date(object.getTime()));	
//					sqlQueryDelete2.setParameter("doctorID", doctorID);
//					List<String> patientId1 = sqlQueryDelete2.list();
//					System.out.println(patientId1.size() + "patient numbers");
//					for (String string : patientId1) 
//					{
//						System.out.println(string + "patient id");
//						Query query = session.createSQLQuery("select userid from OCS_TBL_PATIENT where PATIENTID =?");
//						query.setParameter(0, string);
//						String userID = (String) query.uniqueResult();
//						System.out.println(userID + "+++++++user id");
//						java.sql.Date sqlDate = new java.sql.Date(object.getTime());
//						ArrayList<DoctorBean> doctorsAvailable=reporterService.viewAllAvailableDoctors(sqlDate);
//						for (DoctorBean doctorBean : doctorsAvailable)
//{
//							if(specific.equals(doctorBean.getSpecialization()))
//							{
//								System.out.println("inside suggest bean");	
//								if(doctorBean.getDoctorID().equalsIgnoreCase(doctorID))
//								{
//									
//								}
//								else
//								{
//									System.out.println("inside suggest bean");
//								SuggestBean.setAppointmentDate(object);
//								
//								SuggestBean.setCity(doctorBean.getCity());
//								SuggestBean.setContactNumber((doctorBean.getContactNumber()));
//								SuggestBean.setDateOfBirth(doctorBean.getDateOfBirth());
//								SuggestBean.setDateOfJoining(doctorBean.getDateOfJoining());
//								
//								SuggestBean.setDoctorID(doctorBean.getDoctorID());
//								SuggestBean.setDoctorName(doctorBean.getDoctorName());
//								SuggestBean.setEmailID(doctorBean.getEmailID());
//								
//								SuggestBean.setGender(doctorBean.getGender());
//								SuggestBean.setLocation(doctorBean.getLocation());
//								SuggestBean.setPatientId(string);
//								SuggestBean.setPincode(doctorBean.getPincode());
//								
//								
//								SuggestBean.setQualification(doctorBean.getQualification());
//								SuggestBean.setSpecialization(specific);
//								SuggestBean.setState(doctorBean.getState());
//								SuggestBean.setStreet(doctorBean.getStreet());
//								
//								
//								SuggestBean.setYearsOfExperience(doctorBean.getYearsOfExperience());
//								SuggestBean.setUserID(userID);
//								SuggestBean.setStreet(doctorBean.getStreet());
//								ses.save(SuggestBean);
//								System.out.println(doctorBean.getDoctorName()  + "doctor name");
//								}
//							}
//						}
//						
//					} // patient
//					
//					
//				} // final list
//			
//				
//				
//				
//				SQLQuery sqlQuery = session.createSQLQuery("DELETE FROM OCS_TBL_APPOINTMENTS WHERE OCS_TBL_APPOINTMENTS.DOCTORID=:doctorID");
//				sqlQuery.setParameter("doctorID", doctorID);
//				int i=sqlQuery.executeUpdate();
//				if(i>1){
//					System.out.println("deleted record in appointment");
//				}
//				SQLQuery sqlQueryLeave = session.createSQLQuery("DELETE FROM OCS_TBL_LEAVE WHERE OCS_TBL_LEAVE.DOCTORID=:doctorID");
//				sqlQueryLeave.setParameter("doctorID", doctorID);
//				int checkforleave=sqlQueryLeave.executeUpdate();
//
//				if(checkforleave>1){
//					System.out.println("deleted record in Leave");
//				}
//				SQLQuery sqlQuerySchedule = session.createSQLQuery("DELETE FROM OCS_TBL_SCHEDULES WHERE OCS_TBL_SCHEDULES.DOCTORID=:doctorID");
//				sqlQuerySchedule.setParameter("doctorID", doctorID);
//				int checkforSchedule=sqlQuerySchedule.executeUpdate();
//
//				if(checkforSchedule>1){
//					System.out.println("deleted record in Schedule");
//				}
//				session.delete(bean);
//				System.out.println("doctor bean delete ");
//				
//				return 1;	
//			/*	ArrayList<DoctorBean> doctorsAvailable=reporterService.viewAllAvailableDoctors(sqlDate);*/	
//				
//			}
//			
//		}
//		catch (Exception e)
//		{
//			e.printStackTrace();
//			System.out.println("delete block error");
//			e.getCause();
//			return 0;
//		}
//	}
//
//	@Override
//	public ArrayList<DoctorBean> suggestDoctors(String patientId, Date date) 
//	{
//		// TODO Auto-generated method stub
//		return null;
//	}
//
//	@Override
//	public Map<PatientBean, AppointmentBean> viewPatientsByDate(Date appointmentDate)
//	{
//Map<PatientBean, AppointmentBean> map = new HashMap<PatientBean, AppointmentBean>();
//		
//		Format formatter = new SimpleDateFormat("dd-MMM-yy");
//		String sdate = formatter.format(appointmentDate);
//		System.out.println(sdate);
//		Session sess = sessionFactory.getCurrentSession();
//		SQLQuery query = sess.createSQLQuery("select OCS_TBL_PATIENT.PATIENTID,OCS_TBL_PATIENT.AILMENTDETAILS,OCS_TBL_PATIENT.AILMENTTYPE,OCS_TBL_PATIENT.APPOINTMENTDATE,OCS_TBL_PATIENT.DIAGNOSISHISTORY,OCS_TBL_PATIENT.USERID,OCS_TBL_APPOINTMENTS.APPOINTMENTID,OCS_TBL_APPOINTMENTS.APPOINTMENTDATE,OCS_TBL_APPOINTMENTS.APPOINTMENTTIME,OCS_TBL_APPOINTMENTS.DOCTORID,OCS_TBL_APPOINTMENTS.PATIENTID from OCS_TBL_PATIENT inner join OCS_TBL_APPOINTMENTS on OCS_TBL_PATIENT.PATIENTID = OCS_TBL_APPOINTMENTS.PATIENTID where OCS_TBL_PATIENT.APPOINTMENTDATE=?");
//		query.setString(0, sdate);
//		List<Object[]> list = query.list();
//		for (Object[] object : list) 
//		{
//			PatientBean pb = new PatientBean();
//			AppointmentBean ab = new AppointmentBean();
//			pb.setPatientID((String)object[0]);
//			pb.setDiagnosisHistory((String)object[4]);
//			pb.setAppointmentDate((Date)object[3]);
//			Date dat = (Date)object[3];
//			
//			pb.setAilmentType((String)object[2]);
//			pb.setAilmentDetails((String)object[1]);
//			pb.setUserID((String)object[5]);
//			
//			ab.setPatientID((String)object[10]);
//			ab.setDoctorID((String)object[9]);
//			ab.setAppointmentTime((String)object[8]);
//			ab.setAppointmentID((String)object[6]);
//			ab.setAppointmentDate((Date)object[7]);
//			map.put(pb, ab);
//		}
//		return map;
//	}

}
