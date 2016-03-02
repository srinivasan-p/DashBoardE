package com.dashboard.service;

import java.util.ArrayList;

import com.dashboard.beans.StudentSkillBean;;

public interface Student {
//	String addAilmentDetails(PatientBean patientBean);
//	boolean modifyAilmentDetails(PatientBean patientBean);
//	ArrayList<PatientBean> viewAilmentDetails(String patientID);
//	ArrayList<DoctorBean> viewListOfDoctors(String type, Date date);
//	String requestforAppointment(String doctorID, Date appointmentDate,String userID,String specialization);
//	Map<AppointmentBean, PatientBean> viewAppointmentDetails(String patientID, Date date);
	
	String addStudentSkill(String pId,String skillarray);
	ArrayList<StudentSkillBean> viewStudentSkill(String pId);
	
}
