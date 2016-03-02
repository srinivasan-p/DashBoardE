package com.dashboard.dao;

import java.util.ArrayList;

import com.dashboard.beans.StudentSkillBean;

public interface StudentDAO {
//	public String addAilmentDetails(PatientBean patientBean);
//	public boolean modifyAilmentDetails(PatientBean patientBean);
//	public ArrayList<PatientBean> viewAilmentDetails(String patientID);
//	public ArrayList<DoctorBean> viewListOfDoctors(String type, Date date);
//	public String requestforAppointment(String doctorID, Date appointmentDate,String userID,String specialization);
//	public Map<AppointmentBean, PatientBean> viewAppointmentDetails(String patientID, Date date);
	
	String addStudentSkill(String pId, String skillarray);
	ArrayList<StudentSkillBean> viewStudentSkill(String pId);
}
