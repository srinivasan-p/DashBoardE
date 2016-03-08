package com.dashboard.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.dashboard.beans.InterviewBean;
import com.dashboard.beans.IntervieweeBean;
import com.dashboard.beans.InterviewerBean;
import com.dashboard.beans.ProfileBean;
import com.dashboard.beans.StudentSkillBean;
import com.dashboard.service.Administrator;
import com.dashboard.util.User;

@Controller
public class AdminController {

	@Autowired
	User user;

	@Autowired
	Administrator adminService;

	@RequestMapping(value = "/ViewStudents", method = RequestMethod.GET)
	public String setValues(HttpSession httpSession, Model model) {
		Map<ProfileBean, ArrayList<StudentSkillBean>> result = adminService.viewAllStudents();
		model.addAttribute("result", result);
		return "ViewStudents";
	}

	@RequestMapping(value = "/ScheduleInterview", method = RequestMethod.POST)
	public String scheduleInterview(HttpServletRequest httpServletRequest, HttpSession httpSession, Model model) {
		String[] stinlist = (String[]) httpServletRequest.getParameterValues("stinlist");
		httpSession.setAttribute("stinlist", stinlist);
		System.out.println(Arrays.toString(stinlist));
		return "DoScheduleWithInterviewer";
	}

	@RequestMapping(value = "/DoScheduleWithInterviewer", method = RequestMethod.POST)
	public String doScheduleWithInterviewer(HttpServletRequest httpServletRequest, HttpSession httpSession,
			Model model) {
		String[] stinlist = (String[]) httpSession.getAttribute("stinlist");
		String intDate = httpServletRequest.getParameter("intDate");
		String intTime = httpServletRequest.getParameter("intTime");
		String intPanel = httpServletRequest.getParameter("intPanel");
		intDate = intDate + " " + intTime;
		SimpleDateFormat sim = new SimpleDateFormat("yyyy-MM-dd HH:mm");
		Date d = null;
		try {
			d = sim.parse(intDate);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		String[] intPanelArray = intPanel.split(",");
		String result = adminService.iSchedule(intPanelArray, stinlist, d);
		if (result.equalsIgnoreCase("Success")) {
			return "Success";
		} else {
			return "Failure";
		}
	}
	
	
	@RequestMapping(value = "/ViewScheduledInterview", method = RequestMethod.GET)
	public String viewScheduledInterview(HttpSession httpSession, Model model) {
		Map<InterviewBean, Map<Map<ProfileBean, InterviewerBean>, Map<ProfileBean, IntervieweeBean>>> interviewMap = adminService.ViewAllScheduledInterview();
		httpSession.setAttribute("interviewMap", interviewMap);
		model.addAttribute("result", interviewMap);
		if(interviewMap!=null){
		return "ViewScheduledInterview";
		}else{
			return"Failure";
		}
	}
	//
	// @RequestMapping(value = "/RegistrationForm", method = RequestMethod.POST)
	// public String addValues(@ModelAttribute("RegistrationFormmodel") @Valid
	// ProfileBean pb,
	// BindingResult bindingResult,@RequestParam("file") MultipartFile
	// file,HttpSession httpSession) throws IOException
	// {
	// if (bindingResult.hasErrors())
	// {
	//
	// FieldError error = bindingResult.getFieldError();
	// System.out.println(error.getField());
	// System.out.println("HAs Errors");
	// return "RegistrationForm";
	// }
	//
	// Path path = Paths.get("C:/Users/Lenovo/Desktop/Team
	// Project/TeamProject/WebContent/Default.jpg");
	// String name = "Default.jpg";
	// String originalFileName = "Default.jpg";
	// String contentType = "image/jpg";
	// byte[] content = null;
	// content = Files.readAllBytes(path);
	// MultipartFile result = new MockMultipartFile(name,
	// originalFileName, contentType, content);
	//
	// if(!file.getOriginalFilename().equals("")){
	// System.out.println("I am in Admin Controller addvalues function");
	// pb.setProfileImgName(file.getOriginalFilename());
	// pb.setProfileImage(file.getBytes());
	// }
	// else{
	// //FileInputStream file1 = new
	// FileInputStream("F:/OnlineClinicSystemProject/TeamProject/WebContent/Default.jpg");
	//
	// //MultipartFile multipartFile = (MultipartFile) file1;
	// pb.setProfileImage(result.getBytes());
	// pb.setProfileImgName("Default.jpg");
	// }
	// String stat = user.register(pb);
	// httpSession.setAttribute("reg_id", pb.getUserID());
	// return "Reg_success";
	// }
	//
	// @RequestMapping(value = "/Date", method = RequestMethod.GET)
	// public String setGetDate(Model model)
	// {
	// return "Date";
	// }
	// @Autowired
	// Administrator AdminService;
	//
	// @RequestMapping(value = "/Date", method = RequestMethod.POST)
	// public String setPostDate(HttpSession session,HttpServletRequest
	// req,HttpServletResponse res, Model model)
	// {
	// String sdate = req.getParameter("date");
	// Date date = null;
	// System.out.println(sdate);
	// SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");//change
	// one
	// try
	// {
	// date = (Date)formatter.parse(sdate);
	// }
	// catch (ParseException e)
	// {
	// System.out.println("Date Error...Starts");
	// e.printStackTrace();
	// System.out.println("Date Error...Ends");
	// }
	// //System.out.println(date);
	// Map<PatientBean, AppointmentBean> var =
	// AdminService.viewPatientsByDate(date);
	// System.out.println(var.size());
	// session.setAttribute("map", var);
	// return "Date";
	// }
	//
	// @RequestMapping(value = "/ViewDoctor", method = RequestMethod.GET)
	// public String AllDoctors(HttpSession session,Model model)
	// {
	// ArrayList<DoctorBean> arr = AdminService.viewAllDoctors();
	// session.setAttribute("doctor", arr);
	// return "ViewDoctor";
	// }
	//
	//
	//
	//
	// //AAAAAAAAAAAAAARRRRRRRRRRRRRUUUUUUUUUUUUUUUUUUUUNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNN
	// @Autowired
	// SessionFactory sessionFactory;
	//
	// @RequestMapping(value="/AddDoctor",method=RequestMethod.GET)
	// public String setValues2(Model model)
	// {
	// DoctorBean registrationBean = new DoctorBean();
	// model.addAttribute("AddDoctorAtrrobute", registrationBean);
	// return "AddDoctor";
	// }
	//
	// @RequestMapping(value="/ViewSugg",method=RequestMethod.GET)
	// public String ViewSugg(Model model)
	// {
	// return "ViewSugg";
	// }
	//
	//
	//
	//
	// @Transactional(propagation=Propagation.REQUIRED,readOnly=false)
	// @RequestMapping(value="/AddDoctor",method=RequestMethod.POST)
	// public String addValues(HttpSession
	// session,@ModelAttribute("AddDoctorAtrrobute") @Valid DoctorBean
	// AddDoctor,BindingResult bindingResult,@RequestParam("file") MultipartFile
	// file ) throws IOException
	// {
	// if (bindingResult.hasErrors())
	// {
	//
	// FieldError error = bindingResult.getFieldError();
	// System.out.println(error);
	// System.out.println(error.getField());
	// System.out.println("error in add doctor");
	// return "AddDoctor";
	// }
	// Path path = Paths.get("C:/Users/Lenovo/Desktop/Team
	// Project/TeamProject/WebContent/Default.jpg");
	// String name = "Default.jpg";
	// String originalFileName = "Default.jpg";
	// String contentType = "image/jpg";
	// byte[] content = null;
	// content = Files.readAllBytes(path);
	// MultipartFile result = new MockMultipartFile(name,
	// originalFileName, contentType, content);
	// String filename = file.getOriginalFilename();
	// if(!file.getOriginalFilename().equals("")){
	// AddDoctor.setProfileImage(file.getBytes());
	// AddDoctor.setProfileImgName(file.getOriginalFilename());
	// System.out.println(file.getOriginalFilename());
	// System.out.println("if photo is null for add doctor in admin controller
	// is not null");
	// }
	// else{
	// /*MultipartFile result = new MockMultipartFile(name,
	// "Default.jpg", contentType, content);*/
	// /*System.out.println("if photo is null for add doctor in admin
	// controller");
	// FileInputStream file1 = new
	// FileInputStream("F:/OnlineClinicSystemProject/TeamProject/WebContent/Default.jpg");
	// FileOutputStream file3=new
	// FileOutputStream("F:/OnlineClinicSystemProject/TeamProject/WebContent/Default.jpg");
	// MultipartFile multipartFile = (MultipartFile) file1;*/
	//
	// AddDoctor.setProfileImage(result.getBytes());
	// AddDoctor.setProfileImgName("Default.jpg");
	//
	// }
	// String d = AdminService.addDoctor(AddDoctor);
	// if (d.equalsIgnoreCase("failure"))
	// {
	// return "failure";
	//
	// }
	// else
	// {
	// session.setAttribute("id", d);
	// return "Addsuccess";
	// }
	// }
	//
	// //delete
	// @RequestMapping(value="/DeleteDOctor",method=RequestMethod.GET)
	// public String deleteValues(Model model){
	// DoctorBean registrationBean = new DoctorBean();
	// model.addAttribute("DeleteDoctorAtrrobute", registrationBean);
	// return "DeleteDOctor";
	// }
	//
	//
	//
	// @Transactional(propagation=Propagation.REQUIRED,readOnly=false)
	// @RequestMapping(value="/DeleteDOctor",method=RequestMethod.POST)
	// public String deleteValues(HttpSession se
	// ,@ModelAttribute("DeleteDoctorAtrrobute") DoctorBean deleteDoctor)
	// {
	// String id = deleteDoctor.getDoctorID() ;
	// int d=0;
	// d = AdminService.removeDoctor(id);
	// if(d==1)
	// {
	// return "delete_suc";
	// }
	// else if (d==0)
	// {
	// return "failure";
	// }
	// return "failure";
	// }
	//
	// //delete
	// @Transactional(propagation=Propagation.REQUIRED,readOnly=false)
	// @RequestMapping(value="/Modify",method=RequestMethod.GET)
	// public ModelAndView modifyValues(Model model)
	// {
	// DoctorBean registrationBean = new DoctorBean();
	// Session ses = sessionFactory.getCurrentSession();
	// Query query = ses.createQuery("from DoctorBean");
	// List<DoctorBean> DoctorArry = query.list();
	// DoctorBean doc = DoctorArry.get(0);
	// System.out.println(doc.getDoctorID());
	// System.out.println(DoctorArry.size() + "size of array in modify block ");
	//
	// model.addAttribute("a", DoctorArry);
	// System.out.println("i m in modify block ");
	// return new ModelAndView("ModifyDOCtor");
	// }
	//
	//
	//
	// @Transactional(propagation=Propagation.REQUIRED,readOnly=false)
	// @RequestMapping(value="/ModifyDOCtor",method=RequestMethod.POST)
	// public ModelAndView modify1Values(HttpSession session,HttpServletRequest
	// req,Model model){
	// Enumeration<String> e = req.getParameterNames();
	//
	// String id = (String)e.nextElement();
	// System.out.println(id +" value");
	// Session ses = sessionFactory.getCurrentSession();
	// DoctorBean docBean = (DoctorBean) ses.get(DoctorBean.class, id);
	// session.setAttribute("DoctorID", docBean.getDoctorID());
	// SimpleDateFormat dat = new SimpleDateFormat("MM/dd/yyyy");
	// String DateOfBirth = dat.format(docBean.getDateOfBirth());
	// session.setAttribute("DateOfBirth", DateOfBirth);
	// String DateOfJoining = dat.format(docBean.getDateOfJoining());
	// session.setAttribute("DateOfJoining",DateOfJoining);
	// session.setAttribute("City", docBean.getCity());
	// session.setAttribute("ContactNumber", docBean.getContactNumber());
	// session.setAttribute("DoctorName", docBean.getDoctorName());
	// session.setAttribute("EmailID", docBean.getEmailID());
	// session.setAttribute("Gender", docBean.getGender());
	// session.setAttribute("Location", docBean.getLocation());
	// session.setAttribute("Pincode", docBean.getPincode());
	// session.setAttribute("Qualification", docBean.getQualification());
	// session.setAttribute("Specialization", docBean.getSpecialization());
	// session.setAttribute("State", docBean.getState());
	// session.setAttribute("Street", docBean.getStreet());
	// session.setAttribute("YearsOfExperience",
	// docBean.getYearsOfExperience());
	// model.addAttribute("a",docBean);
	//
	// DoctorBean registrationBean = new DoctorBean();
	// model.addAttribute("modelmodify", registrationBean);
	// return new ModelAndView("formModify");
	// }
	//
	//
	//
	// @Transactional(propagation=Propagation.REQUIRED,readOnly=false)
	// @RequestMapping(value="/formModify",method=RequestMethod.POST)
	// public String modifyUpdateValues(HttpSession session,HttpServletRequest
	// req,Model model,@ModelAttribute("modelmodify") @Valid DoctorBean
	// ModifyDoctor,BindingResult bindingResult)
	// {
	//
	// if (bindingResult.hasErrors())
	// {
	//
	// FieldError error = bindingResult.getFieldError();
	// System.out.println(error.getField());
	// System.out.println("error in delete doctor");
	// return "formModify";
	// }
	// String DoctorId = (String)session.getAttribute("DoctorID");
	// ModifyDoctor.setDoctorID(DoctorId);
	// Boolean d=false;
	// d = AdminService.modifyDoctor(ModifyDoctor);
	// if(d)
	// {
	// return "modifySuccess";
	// }
	// else
	// {
	// return "failure";
	// }
	//
	// }
	//
	//
	//
	// @RequestMapping(value="/delete1",method=RequestMethod.GET)
	// @Transactional(propagation=Propagation.REQUIRED,readOnly=false)
	// public ModelAndView delete1Values(HttpSession session,PrintWriter out,
	// Model model)
	// {
	// DoctorBean registrationBean = new DoctorBean();
	// model.addAttribute("DeleteDoctorAtrrobute", registrationBean);
	// Session ses = sessionFactory.getCurrentSession();
	// Query query = ses.createQuery("from DoctorBean");
	// List<DoctorBean> DoctorArry = query.list();
	// DoctorBean doc = DoctorArry.get(0);
	// session.setAttribute("a", DoctorArry);
	// return new ModelAndView("delete1");
	// }
	//
	// @RequestMapping(value="/DeleteDOctor1",method=RequestMethod.POST)
	// @Transactional(propagation=Propagation.REQUIRED,readOnly=false)
	// public String deletValues(HttpSession session,HttpServletRequest
	// req,Model model)
	// {
	// DoctorBean registrationBean = new DoctorBean();
	// model.addAttribute("DeleteDoctorAtrrobute", registrationBean);
	//
	//
	//
	// Enumeration<String> e = req.getParameterNames();
	// String id = (String)e.nextElement();
	// int res=0;
	// res = AdminService.removeDoctor(id);
	//
	// Session ses = sessionFactory.getCurrentSession();
	// Query query = ses.createQuery("from DoctorBean");
	// List<DoctorBean> DoctorArry = query.list();
	// DoctorBean doc = DoctorArry.get(0);
	// session.setAttribute("a", DoctorArry);
	//
	//
	// if (res>0)
	// {
	// return "delete1";
	// }
	// else
	// {
	// return "fail";
	// }
	// }
	//
	// @RequestMapping(value="/DeleteDOctor12",method=RequestMethod.POST)
	// public String modValues(HttpServletRequest req,Model model)
	// {
	// DoctorBean registrationBean = new DoctorBean();
	// model.addAttribute("DeleteDoctorAtrrobute", registrationBean);
	// Enumeration<String> e = req.getParameterNames();
	// String id = (String)e.nextElement();
	// int res=0;
	// if (res>0)
	// {
	// return "success";
	// }
	// else
	// {
	// return "fail";
	// }
	// }
	//
	// @RequestMapping(value = "/suggestionFromReporter", method =
	// RequestMethod.GET)
	// public String displayPatientIDAndAppointments(){
	//
	// return "suggestionFromReporter";
	// }
	//
	// @RequestMapping(value = "/suggestionFromReporter", method =
	// RequestMethod.POST)
	// public ModelAndView PatientIDAndAppointments(HttpSession
	// session,HttpServletRequest req,HttpServletResponse res, Model model)
	// throws Exception
	// {
	// SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
	// Date date = simpleDateFormat.parse(req.getParameter("date"));
	// session.setAttribute("LeaveDate", date);
	// String patientID = req.getParameter("patientid");
	// session.setAttribute("patientID", patientID);
	// System.out.println("i am in admin controller");
	// ArrayList<DoctorBean> doctors =AdminService.suggestDoctors(patientID,
	// date);
	// model.addAttribute("doctors", doctors);
	// session.setAttribute("ListOfDOctorsToModifyByAdmin", doctors);
	// return new ModelAndView("SuggestedDoctors","doctors",doctors);
	// }
	//
	//
	// @RequestMapping(value = "/suggesteddoctor", method = RequestMethod.POST)
	// @Transactional(propagation=Propagation.REQUIRED,readOnly=false)
	//
	// public String suggesteddoctor(HttpSession session,HttpServletRequest
	// req,HttpServletResponse res, Model model) throws Exception
	// {
	// Session sess = sessionFactory.getCurrentSession();
	// String patientID = (String) session.getAttribute("patientID");
	// Query query = sess.createSQLQuery("select userid from OCS_TBL_PATIENT
	// where PATIENTID =?");
	// query.setParameter(0, patientID);
	// String userID = (String) query.uniqueResult();
	//
	// Enumeration<String> en = req.getParameterNames();
	// String doctorID = en.nextElement();
	// System.out.println("DID:"+doctorID);
	// System.out.println("PID:"+patientID);
	//
	//// Query query2 = sess.createSQLQuery("select APPOINTMENTDATE from
	// OCS_TBL_APPOINTMENTS where PATIENTID =? and DOCTORID=?");
	//// query2.setParameter(0, patientID);
	//// query2.setParameter(1, doctorID);
	// Date app_date=(Date) session.getAttribute("LeaveDate");
	// DoctorBean doc = (DoctorBean) sess.get(DoctorBean.class, doctorID);
	// System.out.println(doc.getDoctorID());
	//
	// SuggestBean obj=new SuggestBean();
	// obj.setPatientId(patientID);
	// obj.setDoctorID(doctorID);
	// obj.setCity(doc.getCity());
	// obj.setContactNumber(doc.getContactNumber());
	// obj.setDateOfBirth(doc.getDateOfBirth());
	// obj.setDateOfJoining(doc.getDateOfJoining());
	// obj.setDoctorName(doc.getDoctorName());
	// obj.setEmailID(doc.getEmailID());
	// obj.setGender(doc.getGender());
	// obj.setLocation(doc.getLocation());
	// obj.setPincode(doc.getPincode());
	// obj.setQualification(doc.getQualification());
	// obj.setSpecialization(doc.getSpecialization());
	// obj.setState(doc.getState());
	// obj.setStreet(doc.getStreet());
	// obj.setYearsOfExperience(doc.getYearsOfExperience());
	// obj.setUserID(userID);
	// obj.setAppointmentDate(app_date);
	// sess.save(obj);
	//
	// return "SuggestedDoctors";
	//
	// }
	// @Transactional(propagation=Propagation.REQUIRED,readOnly=false)
	// @RequestMapping(value="/emailAjax",method=RequestMethod.POST)
	// public @ResponseBody String getResponse(HttpServletRequest
	// request,HttpServletResponse response){
	// String mailId= request.getParameter("mail");
	// org.hibernate.classic.Session hibernateSecs =
	// sessionFactory.getCurrentSession();
	// try
	// {
	// SQLQuery query = hibernateSecs.createSQLQuery("select emailid from
	// OCS_TBL_DOCTOR where emailid=:mail");
	// query.setParameter("mail", mailId);
	// if( query.list().size()>0)
	// {
	// return "Please Try with different mailId";
	// }
	// else
	// {
	//
	// return "Continue";
	// }
	//
	//
	// }
	// catch(Exception e)
	// {
	// return "Continue";
	// }
	//
	// // return "hello";
	// }
	//
	// @Transactional(propagation=Propagation.REQUIRED,readOnly=false)
	// @RequestMapping(value="/emailAjaxForProfile",method=RequestMethod.POST)
	// public @ResponseBody String getResponseForProfile(HttpServletRequest
	// request,HttpServletResponse response){
	// String mailId= request.getParameter("mail");
	// org.hibernate.classic.Session hibernateSecs =
	// sessionFactory.getCurrentSession();
	// try
	// {
	// SQLQuery query = hibernateSecs.createSQLQuery("select emailid from
	// OCS_TBL_USER_PROFILE where emailid=:mail");
	// query.setParameter("mail", mailId);
	// if( query.list().size()>0)
	// {
	// return "Please Try with different mailId";
	// }
	// else
	// {
	//
	// return "Continue";
	// }
	//
	//
	// }
	// catch(Exception e)
	// {
	// return "Continue";
	// }
	//
	// // return "hello";
	// }

}
