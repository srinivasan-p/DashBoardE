<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!-- Latest compiled and minified CSS -->
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css"
	integrity="sha384-1q8mTJOASx8j1Au+a5WDVnPi2lkFfwwEAa8hDDdjZlpLegxhjVME1fgjWPGmkzs7"
	crossorigin="anonymous">

<!-- Optional theme -->
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap-theme.min.css"
	integrity="sha384-fLW2N01lMqjakBkx3l/M9EahuwpSfeNvV63J5ezn3uZzapT0u7EYsXMjQV+0En5r"
	crossorigin="anonymous">

<!-- Latest compiled and minified JavaScript -->
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"
	integrity="sha384-0mSbJDEHialfmuBBQP6A4Qrprq5OVfW37PRR3j5ELqxss1yVqOtnepnHVP9aJ7xS"
	crossorigin="anonymous"></script>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Home</title>
<script type="text/javascript"
	src="http://ajax.googleapis.com/ajax/libs/jquery/2.1.3/jquery.min.js"></script>

<script type="text/javascript"
	src="https://ajax.googleapis.com/ajax/libs/jqueryui/1.11.3/jquery-ui.min.js"></script>

<script type="text/javascript" language="javascript">
	$(document)
			.ready(
					function() {

						$("#login").click(function() {
							$("#objec").attr("data", "LoginForm.html");
							$("#index").hide("slide", {
								direction : "left",
							}, 1000);
							$("#obregistration").hide("slide", {
								direction : "left",
							}, 1000);
							$('#reg').animate({
								left : '0%'
							}, 1000);
							$("#oblogin").show("slide", {
								direction : "right",
							}, 1000);

						});

						$("#RegistrationForm")
								.click(
										function() {

											if (this.className == "RegistrationForm show1") {
												//$("#index").hide("slide",{direction:"right",},1000);
												$('#reg').animate({
													left : '38%'
												}, 1500);
												$("#RegistrationForm")
														.toggleClass("show1")
														.toggleClass("hide1");
												$("#obregistration").show(
														"slide", {
															direction : "left",
														}, 1000);
											} else if (this.className == "RegistrationForm hide1") {
												//$("#index").show("slide",{direction:"right",},1000);
												$('#reg').animate({
													left : '0%'
												}, 1500);
												$("#RegistrationForm")
														.toggleClass("show1")
														.toggleClass("hide1");
												$("#obregistration").hide(
														"slide", {
															direction : "left",
														}, 1000);
											}
										});

						$("#toindexfromlogin").click(function() {

							$("#objec").attr("data", "Logout.html");
							$("#index").delay(3000).show("slide", {
								direction : "left",
							}, 1500);

							$("#oblogin").delay(3000).hide("slide", {
								direction : "right",
							}, 1000);

						});

					});
</script>

<style type="text/css">
.offset-0 {
	padding-left: 0;
	padding-right: 0;
	margin-left: 0;
	margin-right: 0;
}

.jumbotron {
	margin-bottom: 0;
	margin-top: 0;
}

.button {
	display: inline-block;
	border-radius: 4px;
	background-color: #f4511e;
	border: none;
	color: #FFFFFF;
	text-align: center;
	font-size: 28px;
	padding: 20px;
	width: 200px;
	transition: all 0.5s;
	cursor: pointer;
	margin: 5px;
}

.button span {
	cursor: pointer;
	display: inline-block;
	position: relative;
	transition: 0.5s;
}

.button span:after {
	content: '»';
	position: absolute;
	opacity: 0;
	top: 0;
	right: -20px;
	transition: 0.5s;
}

.button:hover span {
	padding-right: 25px;
}

.button:hover span:after {
	opacity: 1;
	right: 0;
}

.RegistrationForm {
	display: inline-block;
	border-radius: 4px;
	background-color: #9f0303;
	border: none;
	color: #FFFFFF;
	text-align: center;
	font-size: 28px;
	padding: 20px;
	width: 20px;
	height: 400px;
	transition: all 0.5s;
	cursor: pointer;
	margin: 5px;
}

.RegistrationForm span {
	margin-left: -20px;
	padding-top: 20px;
	padding-left: -20px;
	writing-mode: tb-rl;
	cursor: pointer;
	display: inline-block;
	position: relative;
	transition: 0.5s;
}

.RegistrationForm span:after {
	writing-mode: tb-rl;
	content: '»';
	position: absolute;
	opacity: 0;
	top: 0;
	right: -20px;
	transition: 0.5s;
}

.RegistrationForm:hover span {
	padding-top: 100px;
}

.RegistrationForm:hover span:after {
	opacity: 1;
	right: 0;
}
</style>
</head>
<body>
	<div class="jumbotron"
		style="height: 80%; position: relative; z-index: 101;">
		<div class="container-fluid">
			<div class="row">
				<!-- class="btn btn-danger show1" -->
				<div class="col-md-12">
					<div class="row" id="index">
						<div class="col-md-3 offset-0" id="reg" style="left: 0%;">
							<a id="RegistrationForm" href="#" class="RegistrationForm show1"><span>Register</span></a>
						</div>
						<div class="col-md-3 offset-0"
							style="text-align: center; padding-top: 30px; color: OrangeRed; opacity: 0.6">
							<h1>A</h1>
							<h1>S</h1>
							<h1>K</h1>
						</div>
						<div class="col-md-3 offset-0"
							style="text-align: left; padding-top: 30px; color:">
							<h1>Always</h1>
							<h1>Seek</h1>
							<h1>Knowledge</h1>
						</div>

						<div class="col-md-3 offset-0" style="text-align: right">
							<a id="login" href="#" class="button"><span>Login </span></a>
						</div>
					</div>
				</div>


				<div class="col-md-6">
					<div class="row" id="obregistration"
						style="display: none; position: fixed; top: 0; bottom: 0; left: 0; overflow: hidden; width: 40%; z-index: 100;">
						<div class="col-md-12 offset-0" style="text-align: left">
							<object data="RegistrationForm.html" width="100%" height="100%"></object>
						</div>

					</div>
				</div>
				<div class="col-md-12">
					<div class="row offset-0" id="oblogin"
						style="display: none; position: fixed; top: 0; right: 0; bottom: 0; left: 0; overflow: hidden; z-index: 100; width: 100%;">
						<div class="col-md-1 offset-0" id="toindexfromlogin" style="">
							<span class="btn btn-block"
								style="height: 100%; background: gray; opacity: 0.6;"><span
								class=" glyphicon glyphicon-chevron-left"
								style="padding-top: 275px"><h5>Logout</h5></span></span>
						</div>
						<div class="col-md-11 offset-0" style="text-align: right;">
							<object id="objec" data="LoginForm.html" width="100%"
								height="100%"></object>
						</div>
					</div>
				</div>



				<!-- 	<div class="jumbotron" id="index" style="background: #9B9998;z-index: 500;">	
    <div class="" style="margin-right: 50%">
	<a id="RegistrationForm" href="#" class="btn btn-danger btn-block show1">Registration</a>
	<a id="login" href="#" class="btn btn-warning btn-block" style="margin-left: 100%;margin-top: -5.50%">Login</a>
	</div>
	</div> -->


				<!-- <div class="" style="margin-right: 50%;float: left;position: absolute;background-color: red">
	<a id="RegistrationForm" href="#" class="btn btn-danger btn-block show1">Registration</a>
	<a id="login" href="#" class="btn btn-warning btn-block" style="margin-left: 100%;margin-top: -5.50%">Login</a>
	</div>  -->


				<video id="video-background" preload muted autoplay loop
					style="position: fixed;
    top: 0;
    opacity:1;
    right: 0;
    bottom: 0;
    left: 0;
    overflow: hidden;
    z-index: -100;
    width:100%;">
				<source src="philfriedelectricbulbmp4.mp4" type="video/mp4"></video>

				<div class="container"></div>


			</div>





		</div>

	</div>
</body>
</html>