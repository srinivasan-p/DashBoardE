<%@page import="com.dashboard.util.AuthenticationImpl"%>
<%@page import="com.dashboard.util.Authentication"%>
<%@page import="org.springframework.beans.factory.annotation.Autowired"%>
<%@page import="com.dashboard.beans.CredentialBean"%>
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
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Logout</title>
<style type="text/css">
.jumbotron {
    margin-bottom: 0px;
    
    background-image: url(img/backg-auto.jpg);
   
    background-size: cover;
    background-repeat: no-repeat;
    color: white;
    text-shadow: grey 0.1em 0.1em 0.1em;
}
</style>
</head>
<body class="jumbotron">
<div >

<%

AuthenticationImpl authentication1=new AuthenticationImpl();

CredentialBean CredentialBean = (CredentialBean) session.getAttribute("cb");
authentication1.changeLoginStatus(CredentialBean, 0);
%>
<h2 style="color: OrangeRed;opacity:0.7">Logout Successful. See u soon. </h2><img alt="Loading..." src="img/ajax-loader.gif">
<h1 style="color:grey;text-align: right;opacity:0.6">Nothing happens <br>unless first we <h1 style="color:OrangeRed;text-align: right">DREAM...!</h1></h1>
</div>

</body>
</html>