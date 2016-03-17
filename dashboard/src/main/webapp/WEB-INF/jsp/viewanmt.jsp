<%@page import="com.ibm.icu.text.SimpleDateFormat"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.util.*"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>

  <link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.0/jquery.min.js"></script>
  <script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"></script> 
  <script>
  function startTime(){
  //alert("gkj");
	  var today=new Date();
	  
	 
	 
	   var h = today.getHours();
    	var m = today.getMinutes();
    	var s = today.getSeconds();
	  document.getElementById("hh").innerHTML=today;
	  var t = setTimeout(startTime, 500);
  
  }
  
  function setDate(){
	  
	  document.getElementById("a1").value=document.getElementById("h").innerHTML;
  }
  
  </script>
  
  <style>
  	.formfield * {
  	
    vertical-align: middle;
		}
	
	.container{
	margin-left: 2px;
	}
	
  </style>
</head>
<body onload="startTime()">



<form:form modelAttribute="anmentbean" action="addmsg.html">
	<p style="float:right" id="hh"></p>
	<div class="container">
		
		<h1>BroadcastMesg</h1>
	
		<hr>
		<form:hidden path="announcemntDt" id="a1"></form:hidden>
		<br>
	
			<div class="formfield">
				<label for="textarea">Subject:</label>
				<br>
				<form:textarea path="subject" rows="2" cols="50"/>
	
				<br>
				<br>
	
	
				<label for="textarea1">Message:</label>
				<br>
				<form:textarea path="message" rows="4" cols="50"/>
				<br>
				<br>
				<input type="submit" value="broadcast" onclick="setDate();" class="btn btn-danger">
			</div>
	
	
	</div>

</form:form>




</body>
</html>