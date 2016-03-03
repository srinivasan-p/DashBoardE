package com.dashboard.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.dashboard.service.Student;

@Controller
public class StudentController {

	@Autowired
	Student studentService;

	@RequestMapping(value = "/SkillSelect", method = RequestMethod.GET)
	public String setSkill(Model model) {
		return "SkillSelect";
	}

	@RequestMapping(value = "/SkillSelect", method = RequestMethod.POST)
	public String addSkill(HttpSession httpSession, HttpServletRequest httpServletRequest) {

		String skillarray=httpServletRequest.getParameter("skillarray");
		String pId = (String) httpSession.getAttribute("pId");
		pId = pId.trim();
		String result = studentService.addStudentSkill(pId, skillarray);
		if(result.equalsIgnoreCase("Success")){
			return "Success";
		}else {
			return "Failure";
		}
	}
	
	@RequestMapping(value = "/ViewSkill", method = RequestMethod.GET)
	public String viewSkill(HttpSession httpSession, Model model) {
		String pId = (String) httpSession.getAttribute("pId");
		studentService.viewStudentSkill(pId);
		return "ViewSkill";
	}
	
	
//
//	@Autowired
//	SessionFactory sessionFactory;
//	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
//	@RequestMapping(value = "/modifyAilmentDetails", method = RequestMethod.GET)
//	public ModelAndView getModify(HttpSession httpSession, Model model) throws Exception {
//
//		String u = (String) httpSession.getAttribute("u");
//		Session session =sessionFactory.getCurrentSession();
////		patientID,userID,appointmentDate,ailmentType,ailmentDetails,diagnosisHistory
//		Query query = session.createSQLQuery("select * from OCS_TBL_PATIENT where userID = ?");
//		query.setString(0, u);
//		List<Object[]> list = query.list();
//		ArrayList<PatientBean> a = new ArrayList<>();
//		SimpleDateFormat sim = new SimpleDateFormat("dd/MM/yyyy");
//		for (Object[] object : list) {
//			PatientBean pb = new PatientBean();
//			pb.setPatientID((String)object[0]);
//			pb.setAilmentDetails((String)object[1]);
//			pb.setAilmentType((String)object[2]);
//			pb.setAppointmentDate((Date)object[3]);
//			pb.setDiagnosisHistory((String)object[4]);
//			pb.setUserID((String)object[5]);
//			a.add(pb);
//		}
//		model.addAttribute("a", a);
//		PatientBean patientBean = new PatientBean();
//		model.addAttribute("modifyAilmentDetailsModel", patientBean);
//		return new ModelAndView("modifyAilmentDetails","a", a );
//	}
//
//	@RequestMapping(value = "/modifyAilmentDetails", method = RequestMethod.POST)
//	public String postModify(HttpSession httpSession,
//			@ModelAttribute("modifyAilmentDetailsModel") @Valid PatientBean patientBean,
//			BindingResult bindingResult) {
//
//		if (bindingResult.hasErrors()) {
//
//			FieldError error = bindingResult.getFieldError();
//			System.out.println(error.getField());
//			System.out.println("HAs Errors");
//		return "modifyAilmentDetails";
//		}
//
//		if (studentService.modifyAilmentDetails(patientBean)) {
//			httpSession.setAttribute("mpatientID", patientBean.getPatientID());
//			return "modifyailmentsuccess";
//		} else {
//			return "failure";
//		}
//	}
//	
//	
//	@RequestMapping(value = "/viewAilmentDetails", method = RequestMethod.GET)
//	public String getPatient(Model model) throws Exception {
//		PatientBean patientBean = new PatientBean();
//		model.addAttribute("viewAilmentDetailsModel", patientBean);
//		return "viewAilmentDetails";
//	}
//	
//	@RequestMapping(value = "/viewAilmentDetails", method = RequestMethod.POST)
//	public String sendpatient(
//			@ModelAttribute("viewAilmentDetailsModel") @Valid PatientBean patientBean,
//			BindingResult bindingResult, Model model) {
//		
//		ArrayList<PatientBean> a = studentService.viewAilmentDetails(patientBean.getPatientID());
//		
//		if (a!=null) {
//			model.addAttribute("a1",a);
//			return "PatientAilmentDisplay";
//		} else {
//			return "failure";
//		}
//	}
//
//	
//	@RequestMapping(value = "/viewListOfDoctors", method = RequestMethod.GET)
//	public String viewListOfDoctors() throws Exception {
//		return "viewListOfDoctors";
//	}
//	
//	@RequestMapping(value = "/viewListOfDoctors", method = RequestMethod.POST)
//	public String viewListOfDoctorsPost(HttpServletRequest httpServletRequest, Model model,HttpSession session) throws Exception {
//		
//		String type = httpServletRequest.getParameter("type");
//		String d = httpServletRequest.getParameter("date");
//		SimpleDateFormat sim = new SimpleDateFormat("yyyy-MM-dd");
//		Date date = sim.parse(d);
//		System.out.println(type +" " + date);
//		ArrayList<DoctorBean> a =studentService.viewListOfDoctors(type, date);
//		if (a!=null) {
//			model.addAttribute("a1",a);
//			model.addAttribute("date",d);
//		
//			return "ListOfDoctorsDisplay";
//		} else {
//			return "failure";
//		}
//	}
//	
//	
//	@RequestMapping(value = "/requestforAppointment", method = RequestMethod.POST)
//	public String requestforAppointment(HttpServletRequest httpServletRequest,HttpSession httpSession, Model model) throws Exception {
//		
//		String userID = (String) httpSession.getAttribute("u");
//		String doctorID = httpServletRequest.getParameter("docID");
//		String date = httpServletRequest.getParameter("date");
//		String specialization = httpServletRequest.getParameter("specialization");
//		
//		System.out.println(userID+" "+doctorID+" "+date+" "+specialization);
//		
//		SimpleDateFormat sim = new SimpleDateFormat("yyyy-MM-dd");
//		Date appointmentDate = sim.parse(date);
////		
//		String a =studentService.requestforAppointment(doctorID, appointmentDate,userID,specialization);
//		if (a.equalsIgnoreCase("CONFIRMED")) {
//			httpSession.setAttribute("appdate", appointmentDate);
//			httpSession.setAttribute("special", specialization);
//			return "appointmentsuccess";
//		} else if (a.equalsIgnoreCase("addailment")) {
//			httpSession.setAttribute("special", specialization);
//			return "addailmentfirst";
//		}else {
//			return "failure";
//		}
//	}
//	
//	
//	@RequestMapping(value = "/displayPatientIdAppointments", method = RequestMethod.GET)
//	public String displayPatientIDAndAppointments(){
//		
//		return "displayPatientIdAppointments";
//	}
//	@RequestMapping(value = "/displayPatientIdAppointments", method = RequestMethod.POST)
//	public String PatientIDAndAppointments(HttpSession session,HttpServletRequest req,HttpServletResponse res, Model model) throws Exception{
//		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
//		Date date = simpleDateFormat.parse(req.getParameter("date"));
//		String patientID = req.getParameter("patientid");
//		Map<AppointmentBean, PatientBean> map = studentService.viewAppointmentDetails(patientID, date);
//		session.setAttribute("values", map);
//		Set<AppointmentBean> key = map.keySet();
//		for(AppointmentBean ab:key)
//		{
//			PatientBean pb= map.get(ab);
//		}
//		
//		return "PatientIdAppointments";
//	}
//	
//	@RequestMapping(value = "/requestforAppointmentfromsuggestions", method = RequestMethod.POST)
//	public String requestforAppointmentfromsuggestions(HttpSession session,HttpServletRequest httpServletRequest,HttpSession httpSession, Model model) throws Exception 
//	{
//		
//		String userID = (String) httpSession.getAttribute("u");
//		
//		Enumeration<String> docid = httpServletRequest.getParameterNames();
//		String doctorID = docid.nextElement();
//		System.out.println(".........................................................");
//		System.out.println(doctorID);
//		String specialization = null;
//		
//		Connection Conn = DBUtill.getDBConnection();
//		PreparedStatement pre = Conn.prepareStatement("select * from SUGGESTBEAN where DOCTORID=?");
//		pre.setString(1, doctorID);
//		
//		ResultSet res = pre.executeQuery();
//		while(res.next())
//		{
//		
//			System.out.println("Inside while....................");
//			System.out.println(res.getString("DOCTORID"));
//			if(doctorID.equals(res.getString("DOCTORID")))
//			{
//				String patientID = res.getString("PATIENTID");
//				System.out.println("INSIDE IF.........................................");
//				specialization=res.getString("SPECIALIZATION"); 
//				System.out.println(specialization);
//				Date appointmentDate = res.getDate("APPOINTMENTDATE");
//				
//				System.out.println(userID+" "+doctorID+" "+appointmentDate+" "+specialization);
//				
//				
//				
////				SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
////				java.util.Date utilDate=simpleDateFormat.parse(date);
//				java.sql.Date atParticularDate= new java.sql.Date(appointmentDate.getTime());
//				//SimpleDateFormat sim = new SimpleDateFormat("yyyy-MM-dd");
//				//Date appointmentDate = sim.parse(date);
////				
//				String a =studentService.requestforAppointment(doctorID, appointmentDate,userID,specialization);
//				if (a.equalsIgnoreCase("CONFIRMED")) 
//				{
//					
//					
//					PreparedStatement two = Conn.prepareStatement("select * from OCS_TBL_Leave where LEAVEFROM <= ? AND LEAVETO>= ? AND STATUS=1");
//					two.setDate(1, atParticularDate);
//					two.setDate(2, atParticularDate);
//					ResultSet rs1 = two.executeQuery();
//					while(rs1.next())
//					{
//						String LeaveDoctor=rs1.getString("DOCTORID");
//						java.sql.Date fromdate = new java.sql.Date(rs1.getDate("LEAVEFROM").getTime());
//						java.sql.Date todate = new java.sql.Date(rs1.getDate("LEAVETO").getTime());
//						PreparedStatement three = Conn.prepareStatement("delete from OCS_TBL_APPOINTMENTS where DOCTORID = ? and PATIENTID = ? and ? >= APPOINTMENTDATE and APPOINTMENTDATE <=?");
//						three.setString(1, LeaveDoctor);
//						three.setString(2, patientID);
//						three.setDate(3, fromdate);
//						three.setDate(4, todate);
//						three.execute();
//					}
//					
//					
//					
//					PreparedStatement one = Conn.prepareStatement("delete from SUGGESTBEAN where patientid=?");
//					System.out.println(patientID);
//					one.setString(1, patientID);
//					one.execute();
//					return "success";
//				}
//				else 
//				{
//					return "failure";
//				}	
//			}	
//		}
//		return "failure";
//
//		
//		
//		//String date = (String) session.getAttribute("LeaveDate");
//		
//		
//		
//	}
}
