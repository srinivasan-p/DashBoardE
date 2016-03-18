package com.dashboard.controller;

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
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.dashboard.beans.ScheduleBean;
import com.dashboard.beans.TrainerBean;
import com.dashboard.service.Student;
import com.dashboard.service.Trainer;
//import com.google.gson.Gson;
import com.dashboard.util.DBUtill;



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
	public @ResponseBody String addEvent1(@ModelAttribute TrainerBean tb,HttpServletRequest request,HttpSession session) throws Exception
	{
		Date stdt1=new Date();
		Date edt1=new Date();
		SimpleDateFormat sdf=new SimpleDateFormat("MM/dd/yyyy");
		String stdt=request.getParameter("startDate");
		String edt=request.getParameter("endDate");
		String event=(String) request.getParameter("eventName");
		String pId = (String) session.getAttribute("pId");


		try {
			stdt1=sdf.parse(stdt);
			edt1=sdf.parse(edt);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		tb.setStartDate(new java.sql.Date(stdt1.getTime()));
		tb.setEndDate(new java.sql.Date(edt1.getTime()));
		String courseId;
		courseId=(pId+event+stdt+edt).replaceAll("/", "");
		tb.setCourseId(courseId);
		Connection conn = DBUtill.getDBConnection();
		PreparedStatement pre = conn.prepareStatement("select skillId from newdb.db_skill where skillName=?");
		pre.setString(1, event);
		ResultSet rs = pre.executeQuery();
		rs.next();
		tb.setSkillId(rs.getInt(1));
		
		System.out.println(event);
		System.out.println("!!!!!!!!!!!!!!!!!!!!!!!"+courseId);
		tb.setTitle(event);
		System.out.println("aftersubmission");
		
		
		if(trainer.addEvent(pId,tb).equalsIgnoreCase("success")){
		
		return "success";
		
		}
		else{
			
			return "fail";}
		}
	
	
	@RequestMapping(value="/fixschedule1",method=RequestMethod.POST)
	public @ResponseBody String fixschedule1(HttpServletRequest request,HttpSession session) throws Exception
	{
		ScheduleBean sb = new ScheduleBean();
		String StudentId = (String) session.getAttribute("pId");
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

		PreparedStatement pre = Conn.prepareStatement("select courseId from newdb.db_Trainer where startDate=? and endDate=? and title=?");
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
		String scheduleid = StudentId+courseId;
		sb.setScheduleId(scheduleid);
		sb.setCompletionStatus(0);
		sb.setCourseId(courseId);
		//return null;
		
		
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
	public @ResponseBody String topopulate(HttpServletRequest request,HttpServletResponse response,HttpSession session) throws Exception{
		System.out.println("in ajax");
		String pId = (String) session.getAttribute("pId");

        String result = "";
        result = result  + "<script>";
        result = result  + "$(document).ready(function() {";
        result = result  + "$('#calendar').fullCalendar({";
        result = result  + "header: {";
        result = result  + "left: 'prev,next today',";
        result = result  + "center: 'title',";
        result = result  + "right: 'month,basicWeek,basicDay'";
        result = result  + "},";
        result = result  + "";
        result = result  + "editable: false,";
        result = result  + "eventLimit: true,";
        result = result  + "selectable: true,";
        
        
        
        
        result = result  + "eventSources: [ ";
        
        
        result = result  + "{";
        
        result = result  + "events: [";
		Connection Conn = DBUtill.getDBConnection();
		PreparedStatement pre = Conn
				.prepareStatement("SELECT * FROM newdb.db_Trainer");
		ResultSet res = pre.executeQuery();
		while (res.next()) 
		{
			System.out.println("-----------------------------inside res");
			PreparedStatement pre1 = Conn
					.prepareStatement("SELECT courseId FROM newdb.db_schedule where pId =?");
			pre1.setString(1, pId);
			ResultSet res1 = pre1.executeQuery();
			int ch=1;
			while(res1.next())
			{
				System.out.println("-----------------------------inside res1");

				System.out.println(res1.getString(1));
				PreparedStatement pre2 = Conn.prepareStatement("SELECT * FROM newdb.db_Trainer where courseId = ?");
				pre2.setString(1, res1.getString(1));
				ResultSet res2 = pre2.executeQuery();
				
				while (res2.next()) 
				{
					System.out.println("-----------------------------inside res2");
					
					if(res2.getString("courseId").equals(res.getString("courseId")))
					{
						ch=ch+1;
					}
				/*	if(res2.getString("courseId").equals(res.getString("courseId")))
					{

				result = result  + "{id:'tag',title:'"+res2.getString("title")+"',start:'"+res2.getDate("startDate")+"',end:'"+res2.getDate("endDate")+"T12:00:00',backgroundColor:'#FFA07A',borderColor:'#FFA07A'},";
					}
					else
					{
						result = result  + "{title:'"+res.getString("title")+"',start:'"+res.getDate("startDate")+"',end:'"+res.getDate("endDate")+"T12:00:00'},";

					}*/
					
				}
			
				
			}
			if(ch>=2)
			{
				ch=1;
			}
			else if(ch==1)
			{
				
				result = result  + "{title:'"+res.getString("title")+"',start:'"+res.getDate("startDate")+"',end:'"+res.getDate("endDate")+"T12:00:00'},";

			}
			

			
		}
		 result = result  + "],";		 
	    result = result  + "},";
	    result = result  + "{";

	     result = result  + "events: [";
			PreparedStatement pre1 = Conn
					.prepareStatement("SELECT courseId FROM newdb.db_schedule where pId =?");
			pre1.setString(1, pId);
			ResultSet res1 = pre1.executeQuery();
			while(res1.next())
			{
				System.out.println(res1.getString(1));
				PreparedStatement pre2 = Conn.prepareStatement("SELECT * FROM newdb.db_Trainer where courseId = ?");
				pre2.setString(1, res1.getString(1));
				ResultSet res2 = pre2.executeQuery();
				while (res2.next()) {
				
				result = result  + "{id:'tag',title:'"+res2.getString("title")+"',start:'"+res2.getDate("startDate")+"',end:'"+res2.getDate("endDate")+"T12:00:00',backgroundColor:'#00FF00',borderColor:'#00FF00'},";
			}
				
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
	public @ResponseBody String topopulateaddevent(HttpServletRequest request,HttpServletResponse response,HttpSession session) throws Exception
	{
		String pId = (String) session.getAttribute("pId");
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
        result = result  + "";
        result = result  + "editable: false,";
        result = result  + "eventLimit: true,";
        result = result  + "selectable: true,";       
        result = result  + "select: function(start,end) {";
        
        
       
        
        result = result  + "end.subtract(1, 'days');";
        result = result  + "starttime =moment(start).format('MM/DD/YYYY');";
        result = result  + "endtime =moment(end).format('MM/DD/YYYY');";
        
        result = result  + "var today=new Date();";
        result = result  + "if(moment(start)>today){";
        result = result  + "$('#createEventModal #startDate').val(starttime);";
        result = result  + "$('#createEventModal #endDate').val(endtime);";
        result = result  + "$('#createEventModal').modal('show');";
        result = result  + "}else{alert('Event Cannot be scheduled for the Past...!!!');}";
        
        
        
        result = result  + "},";
        result = result  + "events: [";
		Connection Conn = DBUtill.getDBConnection();
		PreparedStatement pre = Conn
				.prepareStatement("SELECT * FROM newdb.db_Trainer");
		ResultSet res = pre.executeQuery();
		while (res.next()) {
			System.out.println(res.getDate("startDate"));
			System.out.println(res.getDate("endDate"));
			System.out.println(pId);
			System.out.println(res.getString("trainerId"));
			if(res.getString("trainerId").equalsIgnoreCase(pId))
			{
			result = result  + "{title:'"+res.getString("title")+"',start:'"+res.getDate("startDate")+"',end:'"+res.getDate("endDate")+"T12:30:00Z',backgroundColor:'#FFA07A',borderColor:'#FFA07A'},";
			}
			else
			{
			result = result  + "{title:'"+res.getString("title")+"',start:'"+res.getDate("startDate")+"',end:'"+res.getDate("endDate")+"T12:30:00Z'},";
			}
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
	public @ResponseBody String doAjaxPostforcancel(HttpServletRequest request,HttpServletResponse response,HttpSession session) throws Exception
	{
		String StudentId = (String) session.getAttribute("pId");
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
		PreparedStatement pre = Conn.prepareStatement("select courseId from newdb.db_Trainer where startDate=? and endDate=? and title=?");
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
		
		
		PreparedStatement pre1 = Conn.prepareStatement("DELETE FROM newdb.db_schedule WHERE courseId =? and pId=? ;");
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
