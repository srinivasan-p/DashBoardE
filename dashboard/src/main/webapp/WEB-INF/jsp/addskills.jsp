<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@page import="java.text.SimpleDateFormat"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Add Skills</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
<link href="../dashboard/assets/css/vendor/bootstrap.min.css"
	type="text/css" rel="stylesheet">
<link href="../dashboard/assets/css/vendor/font-awesome.min.css"
	type="text/css" rel="stylesheet">
<link
	href='https://fonts.googleapis.com/css?family=Open+Sans:400,300,600'
	rel='stylesheet' type='text/css'>
<link href="../dashboard/assets/css/jquery.bdt.css" type="text/css"
	rel="stylesheet">
<link href="../dashboard/assets/css/style.css" type="text/css"
	rel="stylesheet">
<script>
	
	function add(){
		//alert("hh");
		var skillName=document.getElementById("name").value;
		alert(skillName);
		document.getElementById("view").innerHTML="";
		$.ajax({  
		     type : "Post",   
		     url : "addskill1.html",   
		     data : "&skillName=" + skillName,
		     success : function(response) {  
		    		alert("success");
		    		$('#view').html(response);
		     
		      },  
		     error : function(e) {  
		     			 alert('Error: ' + e);   
		     		}  
		   	  }); 
		}

	
	function delete1(obj){
		
		alert("delete");
		var val=obj.value;
	   	
		
	    $('#'+val).slideToggle(1000);
	  
	    $.ajax({  
		     type : "Post",   
		     url : "deleteskill.html",   
		     data : "&skillId=" + val,
		     success : function(response) {  
		    		alert("success");
		     
		      },  
		     error : function(e) {  
		     			 alert('Error: ' + e);   
		     		}  
		   	  }); 
	
	}

</script>
</head>
<body>



<div class="container">
		<div class="row">
			<div class="box clearfix">
	<%!int i=0;%>
	
	<div class="header">
	<h3>Add skills</h3>
	</div>
	<hr>
	<div>
		
		Enter the skill to add:<input id="name"></input>
		<input type="submit" class="btn btn-danger btn-sm" onclick="add();">
		
	</div>	
	<hr>
	<div id="view">
		<%int count1=(Integer)request.getAttribute("count");
		if(count1!=0){%>
		<table class="table table-striped table-hover" id="bootstrap-table">
				<tr id="head">
					<th>
						skill id
					</th>
					<th>
						skillName
					</th>	
					<th>
						delete
					</th>
				</tr>
				<c:forEach items="${skillbeans}" var="skill">
			
				<tr id="${skill.skillId}">
					<td>
						${skill.skillId}
					</td>
					<td>
						${skill.skillName}
					</td>
					
					<td>
						<button type="button" id="btn<%=i%>" value="${skill.skillId}" onclick="delete1(this);"><span class="glyphicon glyphicon-trash"></span></button>
					</td>
				</tr>
			
			<%i++;%>
			</c:forEach>	
		</table>	
		<%}else{%>
		Skills are not present....
		<%} %>
	</div>

</div></div></div>
<script src="http://code.jquery.com/jquery-2.1.1.min.js"
		type="text/javascript"></script>
	<script src="../dashboard/assets/js/vendor/bootstrap.min.js"
		type="text/javascript"></script>
	<script src="../dashboard/assets/js/vendor/jquery.sortelements.js"
		type="text/javascript"></script>
	<script src="../dashboard/assets/js/jquery.bdt.js"
		type="text/javascript"></script>
	<script>
		$(document).ready(function() {
			$('#bootstrap-table').bdt();
		});
	</script>
</body>
</html>