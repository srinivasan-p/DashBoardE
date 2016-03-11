package com.dashboard.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.Map;

import com.dashboard.beans.InterviewBean;
import com.dashboard.beans.IntervieweeBean;
import com.dashboard.beans.InterviewerBean;
import com.dashboard.beans.ProfileBean;
import com.dashboard.beans.StudentSkillBean;

public interface Administrator {
//	String addDoctor(DoctorBean doctoerBean);
//	Boolean modifyDoctor(DoctorBean doctorBean);
//	ArrayList<DoctorBean> viewAllDoctors();
//	int removeDoctor(String doctorID);
//	ArrayList<DoctorBean> suggestDoctors(String patientId, Date date);
//	Map <PatientBean, AppointmentBean> viewPatientsByDate(Date appointmentDate);
	
	Map<ProfileBean, ArrayList<StudentSkillBean>> viewAllStudents();
	Map<ProfileBean, ArrayList<StudentSkillBean>> viewAllTrainers();
	String iSchedule(String[] interviewer, String[] interviwee, Date iDate);
	Map<InterviewBean, Map<Map<ProfileBean, InterviewerBean>, Map<ProfileBean, IntervieweeBean>>> ViewAllScheduledInterview();
	String DeleteInterview(String[] interviewIDstoDelete);
	String aa(String id);
}
