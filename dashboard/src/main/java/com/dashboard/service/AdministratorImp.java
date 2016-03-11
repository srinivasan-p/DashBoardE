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

	// @Override
	// public String addDoctor(DoctorBean doctoerBean)
	// {
	// try
	// {
	//
	// if((doctoerBean.getCity().equalsIgnoreCase(null)) ||
	// (doctoerBean.getContactNumber().equalsIgnoreCase(null)) ||
	// (doctoerBean.getDateOfBirth().equals(null)) ||
	// (doctoerBean.getDateOfJoining().equals(null)) ||
	// (doctoerBean.getDoctorName().equalsIgnoreCase(null)) ||
	// (doctoerBean.getEmailID().equalsIgnoreCase(null)) ||
	// (doctoerBean.getGender().equalsIgnoreCase(null)) ||
	// (doctoerBean.getLocation().equalsIgnoreCase(null)) ||
	// (doctoerBean.getPincode().equalsIgnoreCase(null)) ||
	// (doctoerBean.getQualification().equalsIgnoreCase(null)) ||
	// (doctoerBean.getSpecialization().equalsIgnoreCase(null)) ||
	// (doctoerBean.getState().equalsIgnoreCase(null)) ||
	// (doctoerBean.getStreet().equalsIgnoreCase(null))||
	// doctoerBean.equals(null) )
	// {
	//
	//
	//
	// System.out.println("null block");
	// return "failure";
	//
	//
	// /* catch(Exception e)
	// {
	// System.out.println("null block");
	// return "failure";
	// }*/
	// }
	// else
	// {
	// String id = adminDAO.addDoctor(doctoerBean);
	// if(id!=null)
	// {
	// return id;
	// }
	// else
	// {
	// return "failure";
	// }
	// }
	// }
	// catch(Exception e)
	// {
	// e.printStackTrace(); System.out.println("error");
	// return "failure";
	// }
	// }
	//
	// @Override
	// public Boolean modifyDoctor(DoctorBean doctorBean)
	// {
	// try
	// {
	//
	// if((doctorBean.getCity().equalsIgnoreCase(null)) ||
	// (doctorBean.getContactNumber().equalsIgnoreCase(null)) ||
	// (doctorBean.getDateOfBirth().equals(null)) ||
	// (doctorBean.getDateOfJoining().equals(null)) ||
	// (doctorBean.getDoctorName().equalsIgnoreCase(null)) ||
	// (doctorBean.getEmailID().equalsIgnoreCase(null)) ||
	// (doctorBean.getGender().equalsIgnoreCase(null)) ||
	// (doctorBean.getLocation().equalsIgnoreCase(null)) ||
	// (doctorBean.getPincode().equalsIgnoreCase(null)) ||
	// (doctorBean.getQualification().equalsIgnoreCase(null)) ||
	// (doctorBean.getSpecialization().equalsIgnoreCase(null)) ||
	// (doctorBean.getState().equalsIgnoreCase(null)) ||
	// (doctorBean.getStreet().equalsIgnoreCase(null))|| doctorBean.equals(null)
	// )
	// {
	//
	// System.out.println("null block");
	// return false;
	//
	//
	//
	// }
	// else
	// {
	// Boolean ch = adminDAO.modifyDoctor(doctorBean);
	// if(ch)
	// {
	// return true;
	// }
	// else
	// {
	// return false;
	// }
	// }
	// }
	// catch(Exception e)
	// {
	// e.printStackTrace(); System.out.println("error");
	// return false;
	// }
	// }
	//
	// @Override
	// @Transactional(propagation = Propagation.REQUIRED, readOnly = true)
	// public ArrayList<DoctorBean> viewAllDoctors()
	// {
	// ArrayList<DoctorBean> doctor = adminDAO.viewAllDoctors();
	// return doctor;
	// }
	//
	// @Override
	// public int removeDoctor(String doctorID)
	// {
	// try
	// {
	//
	//
	// if(doctorID.equalsIgnoreCase(null) || doctorID.equals(""))
	// {
	// return 0;
	// }
	// else
	// {
	// int ch = adminDAO.removeDoctor(doctorID);
	// if(ch==1)
	// {
	// return 1;
	// }
	// else
	// {
	// return 0;
	// }
	// }
	// }
	// catch(Exception e)
	// {
	// return 0;
	//
	// }
	// }
	//
	//
	// @Transactional(propagation=Propagation.SUPPORTS,readOnly=false)
	// @Override
	// public ArrayList<DoctorBean> suggestDoctors(String patientId, Date date)
	// {
	//
	// // TODO Auto-generated method stub
	//
	// try
	// {
	// if(patientId.equalsIgnoreCase(null) || patientId.equals("") ||
	// date.equals(null))
	// {
	// return null;
	// }
	// else
	// {
	// Session session = sessionFactory.getCurrentSession();
	// //PatientBean pb = (PatientBean)session.get(PatientBean.class,
	// patientId);
	// SQLQuery sqlQueryforPatient = session.createSQLQuery("select * from
	// OCS_TBL_PATIENT where OCS_TBL_PATIENT.PATIENTID= :patientID");
	// sqlQueryforPatient.setParameter("patientID", patientId);
	// sqlQueryforPatient.addEntity(PatientBean.class);
	//
	// SQLQuery query = session.createSQLQuery("select DOCTORID from
	// OCS_TBL_APPOINTMENTS where OCS_TBL_APPOINTMENTS.PATIENTID=:patientID AND
	// OCS_TBL_APPOINTMENTS.APPOINTMENTDATE=:sqldate group by
	// OCS_TBL_APPOINTMENTS.DOCTORID");
	// query.setParameter("patientID", patientId);
	// query.setParameter("sqldate", date);
	// List ls = query.list();
	// java.sql.Date sqlDate = new java.sql.Date(date.getTime());
	// ArrayList<DoctorBean>
	// doctorsAvailable=reporterService.viewAllAvailableDoctors(sqlDate);
	// ArrayList<DoctorBean> doctorsRecommenedForParticularPatientId= new
	// ArrayList<>();
	// int count=0;
	// for(int i=0;i<ls.size();i++){
	//
	// String docid= (String) ls.get(i);
	// for(int j=0;j<doctorsAvailable.size();j++){
	// if(doctorsAvailable.get(j).getDoctorID().equals(docid)){
	// count=1;
	// }
	//
	// }
	// if(count==0){
	// DoctorBean doct = (DoctorBean) session.get(DoctorBean.class, docid);
	// for(int j=0;j<doctorsAvailable.size();j++){
	// if(doct.getSpecialization().equals(doctorsAvailable.get(j).getSpecialization())){
	// doctorsRecommenedForParticularPatientId.add(doctorsAvailable.get(j));
	// System.out.println(doctorsAvailable.get(j).getDoctorName());
	// }
	//
	// }
	//
	// }
	// count=0;
	// }
	// return doctorsRecommenedForParticularPatientId;
	// } // else
	// }
	// catch(Exception e)
	// {
	// e.printStackTrace();return null;
	// }
	// }
	//
	//
	// @Override
	// @Transactional(propagation = Propagation.SUPPORTS, readOnly = false)
	// public Map<PatientBean, AppointmentBean> viewPatientsByDate(
	// Date appointmentDate)
	// {
	//
	// try
	// {
	// if( appointmentDate.equals(null))
	// {
	// return null;
	// }
	// else
	// {
	// Map<PatientBean, AppointmentBean> map =
	// adminDAO.viewPatientsByDate(appointmentDate);
	// return map;
	// }
	// }
	// catch(Exception e)
	// {
	// e.printStackTrace();
	// return null;
	// }
	// }

}
