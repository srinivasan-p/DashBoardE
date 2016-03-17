<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.Connection"%>
<%@page import="com.dashboard.util.DBUtill"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <!-- Latest compiled and minified CSS -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css" integrity="sha384-1q8mTJOASx8j1Au+a5WDVnPi2lkFfwwEAa8hDDdjZlpLegxhjVME1fgjWPGmkzs7" crossorigin="anonymous">

<!-- Optional theme -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap-theme.min.css" integrity="sha384-fLW2N01lMqjakBkx3l/M9EahuwpSfeNvV63J5ezn3uZzapT0u7EYsXMjQV+0En5r" crossorigin="anonymous">

<!-- Latest compiled and minified JavaScript -->
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js" integrity="sha384-0mSbJDEHialfmuBBQP6A4Qrprq5OVfW37PRR3j5ELqxss1yVqOtnepnHVP9aJ7xS" crossorigin="anonymous"></script>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head lang="en">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    
    <!-- Bootstrap Core CSS -->
    <link href="Dcss/bootstrap.min.css" rel="stylesheet">

    <!-- Custom CSS -->
    <link href="Dcss/simple-sidebar.css" rel="stylesheet">
<title>Admin</title>
</head>
<body>
<% Connection conn1 = DBUtill.getDBConnection();
PreparedStatement pre1 = conn1.prepareStatement("select * from newdb.db_profile where pId='"+session.getAttribute("pId")+"'");
ResultSet rs1=pre1.executeQuery();
rs1.next();


%>
<!-- <a href="ViewStudents.html">View Students</a><br>
<a href="ViewTrainers.html">View Trainers</a><br>
<a href="ViewScheduledInterview.html">View Scheduled Interview</a><br>
<a href="authorizeaccess.html">Authorize Access</a><br>
<a href="Logout.html">Click Here to logout</a> -->


<div id="margin" style="background: #d9534f;text-align: center;padding-top: 0.5%;padding-bottom: 0.5%"><span class="h3 text-capitalize">Welcome&nbsp&nbsp<%=rs1.getString("name") %></span></div>
  <div id="wrapper">

        <!-- Sidebar -->
        <div id="sidebar-wrapper">
            <ul class="sidebar-nav">
                <li class="sidebar-brand">
                    <a href="#">
                        Admin Id:&nbsp<%=session.getAttribute("pId") %>
                    </a>
                </li>
                <li>
<a href="#" onclick="func('ViewStudents.html')">View Students</a>
                </li>
                <li>
<a href="#" onclick="func('ViewTrainers.html')">View Trainers</a>
                </li>
                <li>
<a href="#" onclick="func('ViewScheduledInterview.html')">View Scheduled Interview</a>
                </li>
                <li>
<a href="#" onclick="func('authorizeaccess.html')">Authorize Access</a>
                </li>
                <li>
<a href="Logout.html">Click Here to logout</a>
                </li>
                <li class="text-center">
                <br/>
<a><img class="img-circle" src="pic.html?a=<%=session.getAttribute("pId") %>" /></a>              
                </li>
            </ul>
        </div>
        <!-- /#sidebar-wrapper -->

        <!-- Page Content -->
        <a href="#menu-toggle" class="btn btn-info" id="menu-toggle"><span id="left" class='glyphicon glyphicon-chevron-left'></span></a>
        <script type="text/javascript">
        function func(pg)
        {
        	document.getElementById("ob").data=pg;
        }
        </script>
        
        <object id="ob" data="" align="right" height="93%" width="95%">  </object>
        <!-- /#page-content-wrapper -->

    </div>
    <!-- /#wrapper -->

    <!-- jQuery -->
    <script src="Djs/jquery.js"></script>

    <!-- Bootstrap Core JavaScript -->
    <script src="Djs/bootstrap.min.js"></script>

    <!-- Menu Toggle Script -->
    <script>
    $("#menu-toggle").click(function(e) {
        e.preventDefault();
        $("#wrapper").toggleClass("toggled");
        
        
        $("#left").toggleClass("glyphicon-chevron-left").toggleClass("glyphicon-chevron-right");
        
    });
    
  
  
  
    </script>
</body>
</html>