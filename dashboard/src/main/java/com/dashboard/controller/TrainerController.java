package com.dashboard.controller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.dashboard.beans.AnnouncementBean;
import com.dashboard.beans.CredentialBean;
import com.dashboard.service.Trainer;
import com.dashboard.util.DBUtill;

@Controller
public class TrainerController {
	
	@Autowired
	Trainer trainer;
	
	
	@RequestMapping(value="/terminateevent",method=RequestMethod.GET)
	public String terminateevent(Model model,HttpServletRequest request,HttpSession session)
	{	
		
		return "terminateevent";
	}
	
	@RequestMapping(value="/completionStatus",method=RequestMethod.GET)
	public String addEvent(Model model,HttpServletRequest request,HttpSession session)
	{	
		
		return "Attendance";
	}
	
	
	@RequestMapping(value="/tofetchstartdate",method=RequestMethod.POST)
	public @ResponseBody String tofetchstartdate(Model model,HttpServletRequest request,HttpSession session) throws Exception
	{	
		String skill=(String) request.getParameter("skill");
		//System.out.println(skill+"To Be Removed soon....");
		String pId=(String) session.getAttribute("pId");
		String response="";
		  response+="<h4>StartDate:</h4>";
		 response+="<select name="+"stdate"+" id="+"stdate"+" onchange="+"fun2(this.value);"+">";
		 response+="<option value="+"select"+">select</option>";
		 Connection Conn = DBUtill.getDBConnection();
		 PreparedStatement pre = Conn.prepareStatement("SELECT startDate FROM newdb.db_Trainer where trainerId = ? and title=? and startDate < CURDATE()");
		 pre.setString(1, pId);
		 pre.setString(2, skill);
		 ResultSet rs = pre.executeQuery();
		 while(rs.next())
		 {
			 System.out.println(rs.getDate(1));
		 response+="<option value ="+rs.getDate(1)+">"+rs.getDate(1)+"</option>";
		 }
		 response+="</select>";
		

		
		return response;
	}
	
	
	@RequestMapping(value="/tofetchenddate",method=RequestMethod.POST)
	public @ResponseBody String tofetchenddate(Model model,HttpServletRequest request,HttpSession session) throws Exception
	{	
		String skill=(String) request.getParameter("skill");
		String stdate=(String) request.getParameter("startDate");

		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		Date startdate = format.parse(stdate);
        java.sql.Date sql = new java.sql.Date(startdate.getTime());

		String pId=(String) session.getAttribute("pId");
		String response="";
		  response+="<h4>EndDate:</h4>";
		 response+="<select name="+"endate"+" id="+"endate"+" onchange="+"fun3();"+">";
		 response+="<option value="+"select"+">select</option>";
		 Connection Conn = DBUtill.getDBConnection();
		 PreparedStatement pre = Conn.prepareStatement("SELECT endDate FROM newdb.db_Trainer where trainerId = ? and title=? and startDate=?");
		 pre.setString(1, pId);
		 pre.setString(2, skill);
		 pre.setDate(3,sql);
		 
		 ResultSet rs = pre.executeQuery();
		 while(rs.next())
		 {
			 System.out.println(rs.getDate(1));
		 response+="<option value ="+rs.getDate(1)+">"+rs.getDate(1)+"</option>";
		 }
		 response+="</select>";
		return response;
	}
	
	
	@RequestMapping(value="/fetchlist",method=RequestMethod.POST)
	public @ResponseBody String fetchlist(Model model,HttpServletRequest request,HttpSession session) throws Exception
	{	
		String pId=(String) session.getAttribute("pId");
		String skill=(String) request.getParameter("skill");
		String stdate = request.getParameter("stdate");
		String endate = request.getParameter("endate");
		
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		Date startdate = format.parse(stdate);
        java.sql.Date sqlstdate = new java.sql.Date(startdate.getTime());
		Date enddate = format.parse(endate);
        java.sql.Date sqlendate = new java.sql.Date(enddate.getTime());
        String response = "";
        response += "<table class="+"table table-striped"+">";
		String courseid = (pId+skill+new SimpleDateFormat("MM/dd/yyyy").format(startdate)+new SimpleDateFormat("MM/dd/yyyy").format(enddate)).replace("/", "");
		
		Connection conn = DBUtill.getDBConnection();
		PreparedStatement pre = conn.prepareStatement("select pId from newdb.db_schedule where courseId = ?");
		pre.setString(1, courseid);
		ResultSet rs = pre.executeQuery();
		while(rs.next())
		{
			String scheduleId = rs.getString(1)+courseid;
			PreparedStatement pre2=conn.prepareStatement("select completionStatus from newdb.db_schedule where scheduleId = ?");
			pre2.setString(1, scheduleId);
			ResultSet ch = pre2.executeQuery();
			ch.next();
			if(ch.getInt(1)==0)
			{
			System.out.println("inside firstloop"+rs.getString(1));
			PreparedStatement pre1=conn.prepareStatement("select name from newdb.db_profile where pId = ?");
			pre1.setString(1, rs.getString(1));
			ResultSet rs1 = pre1.executeQuery();
			while(rs1.next())
			{
				response += "<tr>";
				response +="<td><input type=checkbox name=pId value="+rs.getString(1)+"></td><td>"+rs1.getString(1)+"</td>";
				response += "</tr>";
			}
			}
			else
			{
				if(rs.isLast())
				{
					response += "<tr><td></td>";
					response += "<td><input class="+"btn"+" type="+"submit"+" value="+"UpdateCompletionStatus"+"></td>";
					response += "</tr>";
				}
				continue;
			}
			if(rs.isLast())
			{
				response += "<tr><td></td>";
				response += "<td><input class="+"btn"+" type="+"submit"+" value="+"UpdateCompletionStatus"+"></td>";
				response += "</tr>";
			}
		}
		response += "</table>";
		return response;
	}
	
	
	
	
	@RequestMapping(value="/fixcompletedstatus",method=RequestMethod.POST)
	public String fixcompletedstatus(Model model,HttpServletRequest request,HttpSession session) throws Exception
	{	
		System.out.println("in LIST DA");
		String TpId=(String) session.getAttribute("pId");
		String skill=(String) request.getParameter("skill");
		String stdate = request.getParameter("stdate");
		String endate = request.getParameter("endate");
		
		String[] spId = request.getParameterValues("pId");
		
		
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		Date startdate = format.parse(stdate);
        java.sql.Date sqlstdate = new java.sql.Date(startdate.getTime());
		Date enddate = format.parse(endate);
        java.sql.Date sqlendate = new java.sql.Date(enddate.getTime());
        String response = "";
		for (String string : spId) 
		{
			System.out.println(string);
			String courseid = (string+TpId+skill+new SimpleDateFormat("MM/dd/yyyy").format(startdate)+new SimpleDateFormat("MM/dd/yyyy").format(enddate)).replace("/", "");
			Connection conn = DBUtill.getDBConnection();
			PreparedStatement pre = conn.prepareStatement("update newdb.db_schedule set completionStatus = 1 where scheduleId = ?");
			pre.setString(1, courseid);
			pre.executeUpdate();
			
		}
		
		
		return "Attendance";
	}
	
	@RequestMapping(value="/tofetchstartdateT",method=RequestMethod.POST)
	public @ResponseBody String tofetchstartdateT(Model model,HttpServletRequest request,HttpSession session) throws Exception
	{	
		String skill=(String) request.getParameter("skill");
		//System.out.println(skill+"To Be Removed soon....");
		String pId=(String) session.getAttribute("pId");
		String response="";
		  response+="<h4>StartDate:</h4>";
		 response+="<select name="+"stdate"+" id="+"stdate"+" onchange="+"fun2(this.value);"+">";
		 response+="<option value="+"select"+">select</option>";
		 Connection Conn = DBUtill.getDBConnection();
		 PreparedStatement pre = Conn.prepareStatement("SELECT startDate FROM newdb.db_Trainer where trainerId = ? and title=? and startDate > CURDATE()");
		 pre.setString(1, pId);
		 pre.setString(2, skill);
		 ResultSet rs = pre.executeQuery();
		 while(rs.next())
		 {
			 System.out.println(rs.getDate(1));
		 response+="<option value ="+rs.getDate(1)+">"+rs.getDate(1)+"</option>";
		 }
		 response+="</select>";
		

		
		return response;
	}
	
	
	@RequestMapping(value="/tofetchenddateT",method=RequestMethod.POST)
	public @ResponseBody String tofetchenddateT(Model model,HttpServletRequest request,HttpSession session) throws Exception
	{	
		String skill=(String) request.getParameter("skill");
		String stdate=(String) request.getParameter("startDate");

		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		Date startdate = format.parse(stdate);
        java.sql.Date sql = new java.sql.Date(startdate.getTime());

		String pId=(String) session.getAttribute("pId");
		String response="";
		  response+="<h4>EndDate:</h4>";
		 response+="<select name="+"endate"+" id="+"endate"+" onchange="+"fun3();"+">";
		 response+="<option value="+"select"+">select</option>";
		 Connection Conn = DBUtill.getDBConnection();
		 PreparedStatement pre = Conn.prepareStatement("SELECT endDate FROM newdb.db_Trainer where trainerId = ? and title=? and startDate=?");
		 pre.setString(1, pId);
		 pre.setString(2, skill);
		 pre.setDate(3,sql);
		 
		 ResultSet rs = pre.executeQuery();
		 while(rs.next())
		 {
			 System.out.println(rs.getDate(1));
		 response+="<option value ="+rs.getDate(1)+">"+rs.getDate(1)+"</option>";
		 }
		 response+="</select>";
		return response;
	}
	
	
	@RequestMapping(value="/CancelEvent",method=RequestMethod.POST)
	public @ResponseBody String CancelEvent(Model model,HttpServletRequest request,HttpSession session)
	{	
		String pId=(String) session.getAttribute("pId");
		String skill=(String) request.getParameter("skill");
		String stdate = request.getParameter("stdate");
		String endate = request.getParameter("endate");
		try
		{
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		Date startdate = format.parse(stdate);
        java.sql.Date sqlstdate = new java.sql.Date(startdate.getTime());
		Date enddate = format.parse(endate);
        java.sql.Date sqlendate = new java.sql.Date(enddate.getTime());
		String courseid = (pId+skill+new SimpleDateFormat("MM/dd/yyyy").format(startdate)+new SimpleDateFormat("MM/dd/yyyy").format(enddate)).replace("/", "");
		String result = trainer.deleteevent(courseid);
		if(result.equalsIgnoreCase("success"))
		{
			return "Event Cancelled Successfully...!!!";
		}
		else
		{
			return "Event Cancel Failed...!!!";
		}
		
		
		/*
		Connection conn = DBUtill.getDBConnection();
		PreparedStatement pre = conn.prepareStatement("delete from newdb.db_Trainer where courseId = ?");
		pre.setString(1, courseid);
		pre.execute();
		return "Event Canceled Successfully...!!!";*/
		}
		catch (Exception e)
		{
			e.printStackTrace();
			return "Event Cannot Be Cancelled...!!!";
		}
	}
	
	
	//Announcement
	
			@RequestMapping(value="/broadcast",method=RequestMethod.GET)
			public String addMessage(Model model){
			
				AnnouncementBean announcement=new AnnouncementBean();
				model.addAttribute("anmentbean", announcement);
				return "viewanmt";
			}
			
			@RequestMapping(value="/addmsg",method=RequestMethod.POST)
			public String addMessage1(@ModelAttribute AnnouncementBean announcementBean,HttpSession session){
			
				System.out.println("in post");
				
				//get from session
				String trainerId=(String) session.getAttribute("pId");
				CredentialBean trainer1=trainer.getTrainer(trainerId);
				//announcementBean.setAnnouncemntId(100);
				announcementBean.setTrainerId(trainer1);//from session
				announcementBean.setAnnouncemntDt(new Date());
				announcementBean.setSubject(announcementBean.getSubject());
				System.out.println(trainer.getProfileBean(trainerId).getName());
				announcementBean.setUpdatedBy(trainer.getProfileBean(trainerId).getName());//from session
				announcementBean.setCreationTime(new Date());
				
				String status=trainer.addMsg(announcementBean);
				System.out.println(status);
				if(status.equalsIgnoreCase("success")){
					return "brdsuccess";
				}
				else{
					return "brdfail";
				}	
				
			}
			
	

}
