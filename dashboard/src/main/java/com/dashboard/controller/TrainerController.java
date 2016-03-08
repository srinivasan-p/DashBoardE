package com.dashboard.controller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.dashboard.beans.TrainerBean;
import com.dashboard.service.Trainer;
import com.dashboard.util.DBUtill;

@Controller
public class TrainerController {
	
	@Autowired
	Trainer trainer;
	
	
	
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
		 PreparedStatement pre = Conn.prepareStatement("SELECT startDate FROM newdb.db_Trainer where trainerId = ? and title=?");
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
		//System.out.println("in LIST DA");
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
				System.out.println("inside secondloop"+rs1.getString(1));
				response +="<input type=checkbox name=pId value="+rs.getString(1)+">"+rs1.getString(1)+"<br>";
			}
			}
			else
			{
				continue;
			}
			if(rs.isLast())
			{
				response += "<input type="+"submit"+" value="+"Submit"+">";
			}
		}

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

}
