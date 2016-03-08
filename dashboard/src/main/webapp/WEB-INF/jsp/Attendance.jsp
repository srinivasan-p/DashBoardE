<%@page import="com.itextpdf.text.log.SysoLogger"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="com.dashboard.util.DBUtill"%>
<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<meta charset='utf-8' />
<link href="../dashboard/fullcalendar.css" rel='stylesheet' />
<link href="../dashboard/fullcalendar.print.css" rel='stylesheet' media='print' />
<script src="../dashboard/libs/moment.min.js"></script>
 <script src="../dashboard/libs/jquery.min.js"></script>
<script src="../dashboard/fullcalendar.min.js"></script>

<link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css">

  <script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"></script> 
<title>Insert title here</title>
<script type="text/javascript">
function fun(skill)
{
	//alert(skill);
	 $.ajax({
			
	        type: "Post",
	
	        url: "tofetchstartdate.html",
			
			data:"&skill="+skill,

	        success:
	        	function(response){
	
	        // we have the response
	
	        $('#startDate').html(response);
	
	       
	 }

  });
	
}
function fun2(stdate) 
{
	//alert(stdate);
	var skill = document.getElementById("skill").value;
	//alert(skill);
	$.ajax({
		
        type: "Post",

        url: "tofetchenddate.html",
		
		data:"&skill="+skill+"&startDate="+stdate,

        success:
        	function(response){

        // we have the response

        $('#endDate').html(response);

       
 }

});
	
	
}

function fun3()
{
	document.getElementById("button").type="button";
	
}
function fun4()
{
	var skill = document.getElementById("skill").value;
	var stdate = document.getElementById("stdate").value;
	var endate = document.getElementById("endate").value;
	



$.ajax({
		
        type: "Post",

        url: "fetchlist.html",
		
		data:"&skill="+skill+"&stdate="+stdate+"&endate="+endate,

        success:
        	function(response){

        // we have the response

        $('#lis').html(response);

       
 }

});
}
</script>
</head>
<body>
<form action="fixcompletedstatus.html" method="post">
<h4>Skill:</h4>
<select id="skill" name="skill" onchange="fun(this.value);">
<option value="select">select</option>
<%
String pId =(String)session.getAttribute("pId");
String pIdsql = pId+"%";
Connection Conn = DBUtill.getDBConnection();
PreparedStatement pre = Conn.prepareStatement("SELECT title from newdb.db_Trainer where courseId like ? and skillId in (Select skillId from newdb.db_studskill where pId = ?)");

pre.setString(1, pIdsql);
pre.setString(2, pId);
ResultSet rs=pre.executeQuery();
while(rs.next())
{

%>
<option value = <%=rs.getString(1)%>><%=rs.getString(1)%></option>
<%}%>
</select>
<div id="startDate">

</div>

<div id="endDate">

</div>
<input id="button" type="hidden" onclick="fun4();" value="Fetch List"></input>

<div style="border: solid;margin-left: 150px;margin-top: -150px" id="lis">

</div>
</form>
</body>
</html>