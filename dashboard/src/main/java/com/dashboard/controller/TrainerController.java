package com.dashboard.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.dashboard.service.Trainer;

@Controller
public class TrainerController {
	
	@Autowired
	Trainer trainer;
	
	
//	@RequestMapping(value="/displayDoctors",method=RequestMethod.GET)
//	public String one(){
//		
//		return "displayDoctors";
//	}
//	
//	@RequestMapping(value="/displayDoctors",method=RequestMethod.POST)
//	public ModelAndView two(HttpServletRequest httpServletRequest,HttpServletResponse httpServletResponse) throws Exception
//	{
//		ArrayList<DoctorBean> doctors = new ArrayList<>();
//		
//		String date=httpServletRequest.getParameter("date");
//		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
//		java.util.Date utilDate=simpleDateFormat.parse(date);
//		java.sql.Date atParticularDate= new java.sql.Date(utilDate.getTime());
//		doctors=trainer.viewAllAvailableDoctors(atParticularDate);
//		Map<String, ArrayList<DoctorBean>> model = new HashMap<String, ArrayList<DoctorBean>>();
//		model.put("doctorList", doctors);
//		return new ModelAndView("DoctorsNotOnLeave", "model", model);
//	}
//	@RequestMapping(value="/displayDoctors1",method=RequestMethod.POST)
//	public ModelAndView doctorsOnLeaveHaveAppointments(HttpServletRequest httpServletRequest,HttpServletResponse httpServletResponse) throws ParseException{
//		ArrayList<DoctorBean> doctors = new ArrayList<>();
//		String date=httpServletRequest.getParameter("date");
//		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
//		java.util.Date utilDate=simpleDateFormat.parse(date);
//		java.sql.Date atParticularDate= new java.sql.Date(utilDate.getTime());
//		doctors=trainer.intimateAdmin(atParticularDate,"1");
//		Map<String, ArrayList<DoctorBean>> model = new HashMap<String, ArrayList<DoctorBean>>();
//		model.put("doctorList", doctors);
//		return new ModelAndView("DoctorsWithAppointmentsAndOnLeave", "model", model);
//	}
//	
//	@RequestMapping(value="/displaydoctorsAjax",method=RequestMethod.POST)
//	public @ResponseBody String getResponse(HttpServletRequest request,HttpServletResponse response){
//		request.getParameter("date");
//		System.out.println("hi in contoller ajax");
//		return "hello";
//	}
}
