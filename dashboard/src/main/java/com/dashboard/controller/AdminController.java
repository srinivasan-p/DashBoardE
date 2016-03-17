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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.dashboard.beans.InterviewBean;
import com.dashboard.beans.IntervieweeBean;
import com.dashboard.beans.InterviewerBean;
import com.dashboard.beans.ProfileBean;
import com.dashboard.beans.SkillBean;
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
	
	@RequestMapping(value = "/ViewTrainers", method = RequestMethod.GET)
	public String viewTrainers(HttpSession httpSession, Model model) {
		Map<ProfileBean, ArrayList<StudentSkillBean>> result = adminService.viewAllTrainers();
		model.addAttribute("result", result);
		return "ViewTrainers";
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
	
	@RequestMapping(value = "/ScheduleInterviewDeletion", method = RequestMethod.POST)
	public String scheduleInterviewDeletion(HttpServletRequest httpServletRequest, HttpSession httpSession, Model model) {
		String[] interviewIDstoDelete = (String[]) httpServletRequest.getParameterValues("interviewIDstoDelete");
		String result = adminService.DeleteInterview(interviewIDstoDelete);
		if (result.equalsIgnoreCase("Success")) {
			return "Success";
		} else {
			return "Failure";
		}
	}
	
	
	@RequestMapping(value = "/authorizeaccess", method = RequestMethod.GET)
	public String authorizeaccess(HttpServletRequest httpServletRequest, HttpSession httpSession, Model model) 
	{
	return "authorizeaccess";
	}
	
	
	@RequestMapping(value = "/AuthorizeAccess", method = RequestMethod.POST)
	public @ResponseBody String AuthorizeAccess(HttpServletRequest httpServletRequest, HttpSession httpSession, Model model) 
	{
	String id=(String) httpServletRequest.getParameter("id");
	String result=adminService.aa(id);
	if(result.equalsIgnoreCase("success"))
	{
	return "<h5>Modified</h5>";
	}
	else
	{
		return "<h5>Modification Failed</h5>";
	}
	}
	
	//vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv
	@RequestMapping(value = "/addskill", method = RequestMethod.GET)
	public String addSkill(Model model,HttpServletRequest request) 
	{
		//SkillBean skillBean=new SkillBean();
		ArrayList<SkillBean> skills=adminService.viewSkills();
		if(skills!=null){
		model.addAttribute("skillbeans",skills);
		request.setAttribute("count", skills.size());
		
		}
		else{
			model.addAttribute("skillbeans",skills);
			request.setAttribute("count",0);
		}
		return "addskills";
	
	}
	
	
	@RequestMapping(value = "/addskill1", method = RequestMethod.POST)
	public @ResponseBody String addSkillPost(@RequestParam("skillName") String skillName,HttpServletRequest httpServletRequest, HttpSession httpSession) 
	{
		String result="";
		int i=0;
		String adminId=(String) httpSession.getAttribute("pId");
		SkillBean skillBean=new SkillBean();
		skillBean.setSkillName(skillName);
		skillBean.setUpdatedOn(new Date());
		skillBean.setUpdatedBy(adminService.getProfileBean(adminId).getName());
		//skillBean.setUpdatedBy("T123");
		adminService.addSkill(skillBean);
		ArrayList<SkillBean> skills=adminService.viewSkills();
		result=result+"<table class='table table-striped table-hover' id='bootstrap-table'>";
		result=result+"<tr>";
		result=result+"<th>";
		result=result+"skill id";
		result=result+"</th>";
		result=result+"<th>skillName</th>";
		
		result=result+"<th>delete</th>";
		result=result+"</tr>";
		for(SkillBean sb:skills){
			
			result=result+"<tr id='"+sb.getSkillId()+"'>";
			result=result+"<td>"+sb.getSkillId()+"</td>";
			result=result+"<td>"+sb.getSkillName()+"</td>";
			
			result=result+"<td><button type='button' id='btn"+i+"' value='"+sb.getSkillId()+"' onclick='delete1(this);'><span class='glyphicon glyphicon-trash'></span></button></td>";
			result=result+"</tr>";
			
			i++;
			
		}
		result=result+"</table>";
		return result;
	}
	
	@RequestMapping(value = "/deleteskill", method = RequestMethod.POST)
	public @ResponseBody String deleteskill1(@RequestParam("skillId") int skillId,HttpServletRequest httpServletRequest) 
	{
		
		
		adminService.deleteSkill(skillId);
		return "success";
	}
	
	

}
