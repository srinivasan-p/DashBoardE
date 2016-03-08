package com.dashboard.dao;

import java.util.ArrayList;
import java.util.Date;
import java.util.Map;

import com.dashboard.beans.InterviewBean;
import com.dashboard.beans.IntervieweeBean;
import com.dashboard.beans.InterviewerBean;
import com.dashboard.beans.ProfileBean;
import com.dashboard.beans.StudentSkillBean;

public interface AdminDAO 
{
//	public String addDoctor(DoctorBean doctoerBean);
//	public Boolean modifyDoctor(DoctorBean doctorBean);
//	public ArrayList<DoctorBean> viewAllDoctors();
//	public int removeDoctor(String doctorID);
//	public ArrayList<DoctorBean> suggestDoctors(String patientId, Date date);
//	public Map <PatientBean, AppointmentBean> viewPatientsByDate(Date appointmentDate);

	Map <ProfileBean, ArrayList<StudentSkillBean>> viewAllStudents();
	String iSchedule(String[] interviewer, String[] interviwee, Date iDate);
	Map<InterviewBean, Map<ArrayList<InterviewerBean>, ArrayList<IntervieweeBean>>> ViewAllScheduledInterview();
	
}
