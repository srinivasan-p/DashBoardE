<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <!-- Latest compiled and minified CSS -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css" integrity="sha384-1q8mTJOASx8j1Au+a5WDVnPi2lkFfwwEAa8hDDdjZlpLegxhjVME1fgjWPGmkzs7" crossorigin="anonymous">

<!-- Optional theme -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap-theme.min.css" integrity="sha384-fLW2N01lMqjakBkx3l/M9EahuwpSfeNvV63J5ezn3uZzapT0u7EYsXMjQV+0En5r" crossorigin="anonymous">

<!-- Latest compiled and minified JavaScript -->
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js" integrity="sha384-0mSbJDEHialfmuBBQP6A4Qrprq5OVfW37PRR3j5ELqxss1yVqOtnepnHVP9aJ7xS" crossorigin="anonymous"></script>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
 <%@  taglib prefix="f" uri="http://www.springframework.org/tags/form"  %>
<html>


<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Login</title>
<style type="text/css">
@import url(http://weloveiconfonts.com/api/?family=entypo);
@import url(http://fonts.googleapis.com/css?family=Roboto);

/* zocial */
[class*="entypo-"]:before {
  font-family: 'entypo', sans-serif;
}

*,
*:before,
*:after 
{
  -moz-box-sizing: border-box; 
  -webkit-box-sizing: border-box;
  box-sizing: border-box; 
}


h2 {
  color:rgba(255,255,255,.8);
  margin-left:12px;
}
h5 {
  color:rgba(255,255,255,.8);
  margin-left:12px;
}

body {
  background: #272125;
  font-family: 'Roboto', sans-serif;
  
}

form {
  position:relative;
  margin: 50px auto;
  width: 380px;
  height: auto;
}

input {
  padding: 16px;
  border-radius:7px;
  border:0px;
  background: rgba(255,255,255,.2);
  display: block;
  margin: 15px;
  width: 300px;  
  color:white;
  font-size:18px;
  height: 54px;
}

input:focus {
  outline-color: rgba(0,0,0,0);
  background: rgba(255,255,255,.95);
  color: #e74c3c;
}

button {
  float:right;
  height: 121px;
  width: 50px;
  border: 0px;
  background: #e74c3c;
  border-radius:7px;
  padding: 10px;
  color:white;
  font-size:22px;
}

.inputUserIcon {
  position:absolute;
  top:68px;
  right: 80px;
  color:white;
}

.inputPassIcon {
  position:absolute;
  top:136px;
  right: 80px;
  color:white;
}

input::-webkit-input-placeholder {
  color: white;
}

input:focus::-webkit-input-placeholder {
  color: #e74c3c;
}
.al
{
	margin-left: 200px;
	margin-right: 200px;
	margin-top: 150px;
}
.do
{
	text-align: right;
	color: green;
}
</style>
<script type="text/javascript">
function evalid(email)
{
	document.getElementById("di").innerHTML ="Click To Login";
}

	
</script>
</head>

<body>

<div class="container-fluid" style="margin-top: 8%">

<div class="row">

	<div class="col-lg-12 col-md-12 col-sm-12 col-xs-12">
	
<f:form action="LoginForm.html" modelAttribute="index">
  <h2><span class="entypo-login"></span> Login</h2>
  
  <button type="submit" value="Login" class="submit"><span class="entypo-lock"></span></button>
  
  <span class="entypo-user inputUserIcon"></span>
  <f:input path="pId" type="text" class="user" placeholder="ursername" onclick="evalid(this.value)"/>
  <span class="entypo-key inputPassIcon"></span>
  <f:input path="password" type="password" class="pass" placeholder="password"/>
 <!--  <div class="do" id="di">Click To Register</div> -->
  <div class="form-group">
  <div class="col-md-12 control">
  <div style="border-top: 1px solid#888; padding-top:15px; font-size:85%" >
  <p style="color:#CFCECF" align="center">Don't have an account!
  <a href="RegistrationForm.html" >
  Sign Up Here
  </a></p>
  </div>
  </div>
  </div>
</f:form>

</div>
</div>
</div>
</body>
</html>