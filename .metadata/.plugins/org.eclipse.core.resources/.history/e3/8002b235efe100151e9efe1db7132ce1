package com.dashboard.controller;

import com.dashboard.utill.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.dashboard.beans.CredentialBean;
import com.dashboard.beans.ScheduleBean;
import com.dashboard.beans.TrainerBean;
import com.dashboard.service.Student;
import com.dashboard.service.Trainer;
//import com.google.gson.Gson;
import com.dashboard.utill.*;



@Controller

public class controller1 
{
	@Autowired
	Trainer trainer;
	@Autowired
	Student student;
	
	/*@RequestMapping(method=RequestMethod.GET)
	public String getvalues()
	{
		System.out.println("controller...");
		return "calendar";
	}
	*/
	@RequestMapping(value="/addEvent",method=RequestMethod.GET)
	public String addEvent(Model model,HttpServletRequest request)
	{
		TrainerBean trainerBean=new TrainerBean();
		model.addAttribute("addEvent",trainerBean);		
		return "calendar1";
	}
	
	
	@RequestMapping(value = "/getVacation", method = RequestMethod.GET)
    public
    @ResponseBody
    String getVacation(HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
        ArrayList<TrainerBean> trainerBeans=new ArrayList<TrainerBean>();
		//sessionId
        int i=0;
		//trainerBeans=trainer.viewAllSchedule("111");
		
	//	for(TrainerBean t:trainerBeans){
		
		
       map.put("title", "fh");
//        map.put("start", "23/");
//       map.put("end", t.getEndDate());
        map.put("url", "http://yahoo.com/");
      // String json = new Gson().toJson(map);
        
	//	}
        // Convert to JSON string.
        

        // Write JSON string.
        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");
		return null;

     //   return json;
    }
	
	
	
	
	
	@RequestMapping(value="/addEvent1",method=RequestMethod.POST)
	public @ResponseBody String addEvent1(@ModelAttribute TrainerBean tb,HttpServletRequest request)
	{
		Date stdt1=new Date();
		Date edt1=new Date();
		SimpleDateFormat sdf=new SimpleDateFormat("MM/dd/yyyy");
		String stdt=request.getParameter("startDate");
		String edt=request.getParameter("endDate");
		try {
			stdt1=sdf.parse(stdt);
			edt1=sdf.parse(edt);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		tb.setStartDate(new java.sql.Date(stdt1.getTime()));
		tb.setEndDate(new java.sql.Date(edt1.getTime()));
		tb.setSkillId(201);
		tb.setCourseId("311");
		tb.setTrainerId("100");
		String event=(String) request.getParameter("eventName");
		System.out.println(event);
		tb.setTitle(event);
		System.out.println("aftersubmission");
		
		if(trainer.addEvent(tb).equalsIgnoreCase("success")){
		
		return "success";
		
		}
		else{
			
			return "fail";}
		}
	
	
	@RequestMapping(value="/fixschedule1",method=RequestMethod.POST)
	public @ResponseBody String fixschedule1(HttpServletRequest request) throws Exception
	{
		ScheduleBean sb = new ScheduleBean();
		String StudentId = "200";//*************student id from session tot be added*************
		int scheduleid = 100;
		Date stdt1=new Date();
		Date edt1=new Date();
		String event=(String) request.getParameter("eventName");
		SimpleDateFormat sdf=new SimpleDateFormat("MM/dd/yyyy");
		String stdt=request.getParameter("startDate");
		String edt=request.getParameter("endDate");
		try {
			stdt1=sdf.parse(stdt);
			edt1=sdf.parse(edt);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		java.sql.Date sqlstdt1Date = new java.sql.Date(stdt1.getTime());
		java.sql.Date sqledt1Date = new java.sql.Date(edt1.getTime());

		Connection Conn = DBUtill.getDBConnection();
		System.out.println(sqlstdt1Date);
		System.out.println(sqledt1Date);
		System.out.println(event);

		PreparedStatement pre = Conn.prepareStatement("select courseId from dd.db_Trainer where startDate=? and endDate=? and title=?");
		pre.setDate(1,sqlstdt1Date);
		pre.setDate(2,sqledt1Date);
		pre.setString(3, event);
		ResultSet rs = pre.executeQuery();
		String courseId = null;
		while(rs.next())
		{
			System.out.println(rs.getString(1));
			courseId = rs.getString(1);
		}
		System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!"+courseId);
		sb.setScheduleId(scheduleid);
		sb.setCompletionStatus(0);
		sb.setCourseId(courseId);
		
		
		if(student.addEvent(StudentId,sb).equalsIgnoreCase("success"))
		{
			return "success";
		}
		else
		{
			return "failure";
		}
		
		
		/*now create query to access the course id from db usinf sd ed and event name get the course id and set it to schedule bean here
		tb.setStartDate(new java.sql.Date(stdt1.getTime()));
		tb.setEndDate(new java.sql.Date(edt1.getTime()));
		tb.setSkillId(201);
		tb.setCourseId("31");
		tb.setTrainerId("111");
		System.out.println(event);
		tb.setTitle(event);
		System.out.println("aftersubmission");
		
		if(trainer.addEvent(tb).equalsIgnoreCase("success")){
		
		return "success";
		
		}
		else{
			
			return "fail";}*/
		}
	
	
	@RequestMapping(value="/topopulate",method=RequestMethod.POST)
	public @ResponseBody String topopulate(HttpServletRequest request,HttpServletResponse response) throws Exception{
		System.out.println("in ajax");
        String result = "";
        result = result  + "<script>";
        result = result  + "$(document).ready(function() {";
        result = result  + "$('#calendar').fullCalendar({";
        result = result  + "header: {";
        result = result  + "left: 'prev,next today',";
        result = result  + "center: 'title',";
        result = result  + "right: 'month,basicWeek,basicDay'";
        result = result  + "},";
        result = result  + "defaultDate: '2016-01-12',";
        result = result  + "editable: false,";
        result = result  + "eventLimit: true,";
        result = result  + "selectable: true,";
        
        
        
        
        result = result  + "eventSources: [ ";
        
        
        result = result  + "{";
        
        result = result  + "events: [";
		Connection Conn = DBUtill.getDBConnection();
		PreparedStatement pre = Conn
				.prepareStatement("SELECT * FROM dd.db_trainer");
		ResultSet res = pre.executeQuery();
		while (res.next()) {
			
			result = result  + "{title:'"+res.getString("title")+"',start:'"+res.getDate("startDate")+"',end:'"+res.getDate("endDate")+"T12:00:00'},";
		}
		 result = result  + "],";
		 
	     result = result  + "},";
	     
	     
	     
	     
	    result = result  + "{";

	     result = result  + "events: [";
			PreparedStatement pre1 = Conn
					.prepareStatement("SELECT * FROM dd.db_trainer");
			ResultSet res1 = pre.executeQuery();
			while (res1.next()) {
				
				result = result  + "{id:'tag',title:'"+res1.getString("title")+"',start:'"+res1.getDate("startDate")+"',end:'"+res1.getDate("endDate")+"T12:00:00',backgroundColor:'#B51C04'},";
			}
			 result = result  + "],";
			 
		     result = result  + "}";
	        result = result  + "],";

		 
		 
		 
		 
		 
		 
		 
		 
		 
		 
		 
		 
		 
		 result = result + "eventClick: function(event){";
		 result = result  + "var id=event._id;";
		 result = result  + "if(id!='tag'){";

		 result = result  + "starttime =(event.start).format('MM/DD/YYYY');";
		 result = result  + "if(event.end!="+"null"+"){endtime =(event.end).format('MM/DD/YYYY');}else{endtime =(event.start).format('MM/DD/YYYY');}";
	       result = result  + "$('#createEventModal #startDate').val(starttime);";
	       result = result  + "$('#createEventModal #endDate').val(endtime);";
	       result = result  + "$('#createEventModal #eventName').val(event.title);";
	        result = result  + "$('#createEventModal').modal('show');";
	        
			 result = result  + "}else{";
			 
			 
			 
			 
			 result = result  + "starttime =(event.start).format('MM/DD/YYYY');";
			 result = result  + "if(event.end!="+"null"+"){endtime =(event.end).format('MM/DD/YYYY');}else{endtime =(event.start).format('MM/DD/YYYY');}";
		       result = result  + "$('#cancellationModal #startDate').val(starttime);";
		       result = result  + "$('#cancellationModal #endDate').val(endtime);";
		       result = result  + "$('#cancellationModal #eventName').val(event.title);";
		        result = result  + "$('#cancellationModal').modal('show');";
			 
			 result = result  + "}";

			 


		 result = result + "}";
		 result = result  + "});";
	     result = result  + "});";
		result = result  + "</script> ";
		return result;
		
	}
	
	
	@RequestMapping(value="/topopulateaddevent",method=RequestMethod.POST)
	public @ResponseBody String topopulateaddevent(HttpServletRequest request,HttpServletResponse response) throws Exception
	{
		System.out.println("in ajax topopulateaddevent");
       String result = "";
        result = result  + "<script>";
        result = result  + "$(document).ready(function() {";
        
        
        result = result  + "$('#calendar').fullCalendar({";
        result = result  + "header: {";
        result = result  + "left: 'prev,next today',";
        result = result  + "center: 'title',";
        result = result  + "right: 'month,basicWeek,basicDay'";
        result = result  + "},";
        result = result  + "defaultDate: '2016-01-12',";
        result = result  + "editable: false,";
        result = result  + "eventLimit: true,";
        result = result  + "selectable: true,";       
        result = result  + "select: function(start) {";
        result = result  + "starttime =moment(start).format('MM/DD/YYYY');";
        result = result  + "$('#createEventModal #startDate').val(starttime);";
        result = result  + "$('#createEventModal').modal('show');";
        result = result  + "},";
        result = result  + "events: [";
		Connection Conn = DBUtill.getDBConnection();
		PreparedStatement pre = Conn
				.prepareStatement("SELECT * FROM dd.db_trainer");
		ResultSet res = pre.executeQuery();
		while (res.next()) {
			System.out.println(res.getDate("startDate"));
			System.out.println(res.getDate("endDate"));

			result = result  + "{title:'"+res.getString("title")+"',start:'"+res.getDate("startDate")+"',end:'"+res.getDate("endDate")+"T12:30:00Z'},";
		}
		 result = result  + "],";
		 result = result  + "});";
	     result = result  + "});";
		result = result  + "</script> ";
		return result;
		
	}
	
	@RequestMapping(value="/calendar",method=RequestMethod.GET)
	public String calendar(Model model,HttpServletRequest request)
	{
		return "calendar";
	}
	
	
	
	@RequestMapping(value="/doAjaxPostforcancel",method=RequestMethod.POST)
	public @ResponseBody String doAjaxPostforcancel(HttpServletRequest request,HttpServletResponse response) throws Exception
	{
		String StudentId = "200";//*************student id from session tot be added*************
		Date stdt1=new Date();
		Date edt1=new Date();
		String event=(String) request.getParameter("eventName");
		SimpleDateFormat sdf=new SimpleDateFormat("MM/dd/yyyy");
		String stdt=request.getParameter("startDate");
		String edt=request.getParameter("endDate");
		try {
			stdt1=sdf.parse(stdt);
			edt1=sdf.parse(edt);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		java.sql.Date sqlstdt1Date = new java.sql.Date(stdt1.getTime());
		java.sql.Date sqledt1Date = new java.sql.Date(edt1.getTime());

		Connection Conn = DBUtill.getDBConnection();
		System.out.println(sqlstdt1Date);
		System.out.println(sqledt1Date);
		System.out.println(event);
		PreparedStatement pre = Conn.prepareStatement("select courseId from dd.db_Trainer where startDate=? and endDate=? and title=?");
		pre.setDate(1,sqlstdt1Date);
		pre.setDate(2,sqledt1Date);
		pre.setString(3, event);
		ResultSet rs = pre.executeQuery();
		String courseId = null;
		while(rs.next())
		{
			System.out.println(rs.getString(1));
			courseId = rs.getString(1);
		}
		
		
		PreparedStatement pre1 = Conn.prepareStatement("DELETE FROM dd.db_schedule WHERE courseId =? and pId=? ;");
		pre1.setString(1,courseId);
		pre1.setString(2,StudentId);
		int flg = pre1.executeUpdate();
		if(flg==1)
		{
			return "success";
		}
		else
		{
		return null;
		}
		
	}
}
