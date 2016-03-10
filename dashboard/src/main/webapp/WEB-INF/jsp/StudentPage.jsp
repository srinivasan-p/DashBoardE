
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.Connection"%>
<%@page import="com.dashboard.util.DBUtill"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<link href="../dashboard/fullcalendar.css" rel='stylesheet' />
<link href="../dashboard/fullcalendar.print.css" rel='stylesheet'
	media='print' />
<script src="../dashboard/libs/moment.min.js"></script>
<script src="../dashboard/libs/jquery.min.js"></script>
<script src="../dashboard/fullcalendar.min.js"></script>

<link rel="stylesheet"
	href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css">

<script
	src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"></script>
<title>Student</title>
<script type="text/javascript">
function fun(id,divid) 
{
	
	  $.ajax({
			
	        type: "Post",
	
	        url: "tocancelnotification.html",
			
			data:"&id="+id,

	        success:
	        	function(response){
	
	        // we have the response
	
	        $("#"+divid+"").html(response);
	
	       
	 }

}); 
	
}
</script>
</head>
<body>
	student
<!-- <<<<<<< HEAD -->

	<a href="SkillSelect.html">Skill Select</a>
	<a href="ViewSkill.html">View Skill</a>
	<a href="calendar.html">Calendar</a>
<!-- ======= -->
<br><br>
	<a href="SkillSelect.html">Skill Select</a><br>
	<a href="ViewSkill.html">View Skill</a><br>


	<a href="calendar.html">Calendar</a><br>

<br><br>

<!-- >>>>>>> branch 'master' of https://github.com/srinivasan-p/DashBoardE.git
 -->	<a href="Logout.html">Click Here to logout</a>
	<%
	Connection conn = DBUtill.getDBConnection();
	String pId=(String)session.getAttribute("pId");
	PreparedStatement pre= conn.prepareStatement("select * from newdb.db_Conflict where pId = ?");
	pre.setString(1, pId);
	ResultSet rs=pre.executeQuery();
	int i=0;
	while(rs.next())
	{
		i +=1;
	%>
	<div id="<%=i%>">
	<h4>Oopsss...Your <%=rs.getString("event")%> event on <%=rs.getDate("stdate")%> has been cancelled due to unforeseen circumstances.Please Plan Your day accordingly <span><button id="<%=rs.getString("Sno")%>" type="button" class="close" onclick="fun(this.id,<%=i%>)">&times;</button></span></h4>
	</div>
	<%} %>
</body>
</html>