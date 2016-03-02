package com.dashboard.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.dashboard.beans.StudentSkillBean;
import com.dashboard.dao.StudentDAO;

@Service("studentService")
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
public class StudentImp implements Student {

	@Autowired
	StudentDAO studentDAO;

	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public String addStudentSkill(String pId, String skillarray) {

		return (studentDAO.addStudentSkill(pId, skillarray));

	}

	public ArrayList<StudentSkillBean> viewStudentSkill(String pId) {
		// TODO Auto-generated method stub
		return null;
	}

	// @Override
	// @Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	// public String addAilmentDetails(PatientBean patientBean) {
	// try
	// {
	// if((patientBean.equals(null)) ||
	// (patientBean.getAilmentDetails().equalsIgnoreCase(null)) ||
	// patientBean.getAilmentDetails().equalsIgnoreCase("") ||
	// (patientBean.getAilmentType().equalsIgnoreCase(null)) ||
	// patientBean.getAilmentType().equalsIgnoreCase("") ||
	// patientBean.getDiagnosisHistory().equalsIgnoreCase("") ||
	// patientBean.getDiagnosisHistory().equalsIgnoreCase(null) )
	// {
	// return "FAIL";
	// }
	// else
	// {
	//
	// String result = patientDAO.addAilmentDetails(patientBean);
	// if (result.equals("SUCCESS")) {
	// return "SUCCESS";
	// } else {
	// return "FAIL";
	// }
	// }
	// }
	// catch(Exception e)
	// {
	// e.printStackTrace();
	// return "FAIL";
	//
	// }
	// }
	//
	// @Override
	// @Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	// public boolean modifyAilmentDetails(PatientBean patientBean) {
	// try
	// {
	// if((patientBean==null) ||
	// (patientBean.getAilmentDetails().equalsIgnoreCase(null)) ||
	// patientBean.getAilmentDetails().equalsIgnoreCase("") ||
	// (patientBean.getAilmentType().equalsIgnoreCase(null)) ||
	// patientBean.getAilmentType().equalsIgnoreCase("") ||
	// patientBean.getDiagnosisHistory().equalsIgnoreCase("") ||
	// patientBean.getDiagnosisHistory().equalsIgnoreCase(null) )
	// {
	// return false;
	// }
	// else
	// {
	// System.out.println("hi");
	// boolean result = patientDAO.modifyAilmentDetails(patientBean);
	// if (result) {
	// return true;
	// } else {
	// return false;
	// }
	// }
	// }
	//
	// catch(Exception e)
	// {
	// e.printStackTrace();
	// return false;
	//
	// }
	// }
	//
	// @Override
	// public ArrayList<PatientBean> viewAilmentDetails(String patientID) {
	// try
	// {
	//
	//
	// if(patientID.equalsIgnoreCase(null) || patientID.equals(""))
	// {
	//
	// return null;
	// }
	// else
	// {
	// ArrayList<PatientBean> result = patientDAO.viewAilmentDetails(patientID);
	// if (result != null) {
	// return result;
	// }
	// }
	// }
	// catch(Exception e)
	// {
	// e.printStackTrace();
	// return null;
	//
	// }
	// return null;
	// }
	//
	// @Override
	// public ArrayList<DoctorBean> viewListOfDoctors(String type, Date date) {
	// try
	// {
	//
	//
	// if(type.equalsIgnoreCase(null) || type.equals("") || date.equals(null))
	// {
	//
	// return null;
	// }
	// else
	// {
	// ArrayList<DoctorBean> result = patientDAO.viewListOfDoctors(type, date);
	// if (result != null) {
	// return result;
	// } else {
	// return null;
	// }
	// }
	// }
	// catch(Exception e)
	// {
	// e.printStackTrace();
	// return null;
	//
	// }
	// }
	//
	// @Override
	// public String requestforAppointment(String doctorID, Date
	// appointmentDate,String userID,String specialization) {
	//
	// try
	// {
	//
	//
	// if(doctorID.equalsIgnoreCase(null) || doctorID.equals("") ||
	// appointmentDate.equals(null) || specialization.equalsIgnoreCase(null) ||
	// specialization.equals("") )
	// {
	//
	// return null;
	// }
	// else
	// {
	// String result = patientDAO.requestforAppointment(doctorID,
	// appointmentDate,userID,specialization);
	//
	// return result;
	// }
	// }
	// catch(Exception e)
	// {
	// e.printStackTrace();
	// return null;
	//
	// }
	// }
	//
	// @Override
	// public Map<AppointmentBean, PatientBean> viewAppointmentDetails(
	// String patientID, Date date)
	// {
	//
	// try
	// {
	//
	//
	// if(patientID.equalsIgnoreCase(null) || patientID.equals("") ||
	// date.equals(null))
	// {
	//
	// return null;
	// }
	// else
	// {
	// Map<AppointmentBean, PatientBean> map=
	// patientDAO.viewAppointmentDetails(patientID, date);
	// return map;
	//
	// }
	// }
	// catch(Exception e)
	// {
	// e.printStackTrace();
	// return null;
	//
	// }
	// }

}
