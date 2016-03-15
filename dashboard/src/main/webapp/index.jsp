<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
   <!-- Latest compiled and minified CSS -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css" integrity="sha384-1q8mTJOASx8j1Au+a5WDVnPi2lkFfwwEAa8hDDdjZlpLegxhjVME1fgjWPGmkzs7" crossorigin="anonymous">

<!-- Optional theme -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap-theme.min.css" integrity="sha384-fLW2N01lMqjakBkx3l/M9EahuwpSfeNvV63J5ezn3uZzapT0u7EYsXMjQV+0En5r" crossorigin="anonymous">

<!-- Latest compiled and minified JavaScript -->
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js" integrity="sha384-0mSbJDEHialfmuBBQP6A4Qrprq5OVfW37PRR3j5ELqxss1yVqOtnepnHVP9aJ7xS" crossorigin="anonymous"></script> 

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Home</title>
  <script type = "text/javascript" 
         src = "http://ajax.googleapis.com/ajax/libs/jquery/2.1.3/jquery.min.js"></script>
		
      <script type = "text/javascript" 
         src = "https://ajax.googleapis.com/ajax/libs/jqueryui/1.11.3/jquery-ui.min.js"></script>
		
  <script type = "text/javascript" language = "javascript">
  $(document).ready(function() {
	
	  
	  
$("#login").click(function(){
	
	$("#index").hide("slide",{direction:"left",},1000);
	$("#obregistration").hide("slide",{direction:"left",},1000);
	$("#oblogin").show("slide",{direction:"right",},1000);
	

});




$("#RegistrationForm").click(function(){
	
	if(this.className=="btn btn-danger btn-block show1")
		{
		//$("#index").hide("slide",{direction:"right",},1000);

		$("#RegistrationForm").toggleClass("show1").toggleClass("hide1");
	$("#obregistration").show("slide",{direction:"left",},1000);
		}
	else if(this.className=="btn btn-danger btn-block hide1")
		{		
		//$("#index").show("slide",{direction:"right",},1000);

		$("#RegistrationForm").toggleClass("show1").toggleClass("hide1");
		$("#obregistration").hide("slide",{direction:"left",},1000);
		}
});

$("#toindexfromlogin").click(function()
		{
	$("#index").show("slide",{direction:"left",},1000);

	$("#oblogin").hide("slide",{direction:"right",},1000);
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
.jumbotron
{
margin-bottom: 0;
margin-top: 0;
}

</style>
</head>
<body>

<div class="container-fluid">
<div class="row">
				


	
			<div class="col-md-4">				
					<div class="row" id="obregistration" style="display: none">
						<div class="col-md-12 offset-0" style="text-align: left">
						<object  data="RegistrationForm.html" width="100%"height="100%"></object>
						</div >
						
					</div>
	</div>			
	<div class="col-md-12">				
					<div class="row" id="oblogin" style="display: none">
						<div class="col-md-1 offset-0" id="toindexfromlogin"><span class="btn btn-success btn-block" style="height: 100%"><span class=" glyphicon glyphicon-chevron-left"></span></span></div>
						<div class="col-md-11 offset-0" style="text-align: right">
						<object  data="LoginForm.html" width="100%"height="100%"></object>
						</div>
					</div>
	</div>		
		
 <!-- 	<div class="col-md-12">
					<div class="row" id="index">
						<div class="col-md-6 offset-0">
						<a id="RegistrationForm" href="#" class="btn btn-danger btn-block show1">Registration</a></div>
						<div class="col-md-6 offset-0">
						<a id="login" href="#" class="btn btn-warning btn-block">Login</a></div>
					</div>
	</div>	 -->	
	
	<div class="jumbotron" id="index" style="background: #9B9998">	
    <div class="" style="margin-right: 50%">
	<a id="RegistrationForm" href="#" class="btn btn-danger btn-block show1">Registration</a>
	<a id="login" href="#" class="btn btn-warning btn-block" style="margin-left: 100%;margin-top: -5.50%">Login</a>
	</div>
	</div>
<div class="jumbotron" style="height: 80%;position: relative;z-index:-101;">	
	
	<!--   <div class="" style="margin-right: 50%">
	<a id="RegistrationForm" href="#" class="btn btn-danger btn-block show1">Registration</a>
	<a id="login" href="#" class="btn btn-warning btn-block" style="margin-left: 100%;margin-top: -5.50%">Login</a>
	</div> -->
	
	
   <video id="video-background" preload muted autoplay loop style="position: fixed;
    top: 0;
    right: 0;
    bottom: 0;
    left: 0;
    overflow: hidden;
    z-index: -100;
    width:100%;">
    <source src="http://dfcb.github.io/BigVideo.js/vids/dock.mp4" type="video/mp4">
  </video>
  
  <div class="container">
 
  
  </div>
	
		
  		
</div>
	



	
	</div>					

</div>
</body>
</html>