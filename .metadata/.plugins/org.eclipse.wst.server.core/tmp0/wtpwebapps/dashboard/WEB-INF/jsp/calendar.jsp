<!DOCTYPE html>
<html>
<head>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<meta charset='utf-8' />
<link href="../Dashboard/fullcalendar.css" rel='stylesheet' />
<link href="../Dashboard/fullcalendar.print.css" rel='stylesheet' media='print' />
<script src="../Dashboard/libs/moment.min.js"></script>
 <script src="../Dashboard/libs/jquery.min.js"></script>
<script src="../Dashboard/fullcalendar.min.js"></script>

<link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css">

  <script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"></script>  


<style>

	body {
		margin: 40px 10px;
		padding: 0;
		font-family: "Lucida Grande",Helvetica,Arial,Verdana,sans-serif;
		font-size: 14px;
	}

	#calendar {
		max-width: 900px;
		margin: 0 auto;
	}

</style>
<script type="text/javascript">
function aj() {
	 
    
    
    $.ajax({
	
		        type: "POST",
		
		        url: "topopulate.html",
	
		        success:
		        	function(response){
		
		        // we have the response
		
		        $('#event').html(response);
		
		       
		 }
	
	     });
       }
       
       
       
function fu()
{
	var eventName=document.getElementById("eventName").value;
	var startDate=document.getElementById("startDate").value;
	var endDate=document.getElementById("endDate").value;
	doAjaxPost(eventName,startDate,endDate);
}


function cs()
{

	 var eventName=document.getElementsByClassName("hh1")[0].value;
	var startDate=document.getElementsByClassName("hh2")[0].value;
	var endDate=document.getElementsByClassName("hh3")[0].value;
	doAjaxPostforcancel(eventName,startDate,endDate); 
}

function doAjaxPostforcancel(eventName,startDate,endDate){
	$.ajax({
		type:"Post",
		url:"doAjaxPostforcancel.html",
		data:"&eventName="+eventName+"&startDate="+startDate+"&endDate="+endDate,
		success:
			function(response){
			document.getElementById("status").value=response;
			if(document.getElementById("status").value==="success"){
				doSubmit();
			}
			
			else{
				alert("error");
			}
		},
		error: function(e){
			alert('Error:'+e);
		}});} 
	function doSubmit(){
	  $("#createEventModal").modal('hide');
	  alert("form submitted");   
	  location.reload();
	 /*  $("#calendar").fullCalendar('renderEvent',
	      {
	          title: $('#eventName').val(),
	          start: new Date($('#startDate').val()),
				end: new Date($('#endDate').val()),
				allDay:true
	      },
	      true); */
	      
	 }  
       
       
function doAjaxPost(eventName,startDate,endDate){
	$.ajax({
		type:"Post",
		url:"fixschedule1.html",
		data:"&eventName="+eventName+"&startDate="+startDate+"&endDate="+endDate,
		success:
			function(response){
			document.getElementById("status").value=response;
			if(document.getElementById("status").value==="success"){
				doSubmit();
			}
			
			else{
				alert("error");
			}
		},
		error: function(e){
			alert('Error:'+e);
		}});} 
	function doSubmit(){
	  $("#createEventModal").modal('hide');
	  alert("form submitted");   
	  location.reload();
	 /*  $("#calendar").fullCalendar('renderEvent',
	      {
	          title: $('#eventName').val(),
	          start: new Date($('#startDate').val()),
				end: new Date($('#endDate').val()),
				allDay:true
	      },
	      true); */
	      
	 }    

</script>
</head>
<body   onload="aj();">

<input type="hidden" id="status" value="Fix Schedule"readonly="readonly">

<div id="event">
</div>
<div id='calendar'></div>
<div id="createEventModal" class="modal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel1" aria-hidden="true">
    
    <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal" aria-hidden="true">x</button>
        <h3 id="myModalLabel1">Add event</h3>
    </div>   
    <div class="modal-body">
    <form:form id="createEvent" mclass="form-horizontal" >
    
         <div class="control-group">
           <label class="control-label" for="event">Event:</label>
              <input type="text" id="eventName"></input>
        </div>
        	<div class="control-group">
          	 	 <label class="control-label" for="startDate">Start date:</label>
          	 	<input type="text" id="startDate"></input>
       		 </div>
       		 <div class="control-group">
           		 <label class="control-label" for="endDate">End date:</label>
              <input type="text" id="endDate"></input>         
        </div>     
    </form:form>
    </div>
    <div class="modal-footer">
        <button class="btn" data-dismiss="modal" aria-hidden="true">Cancel</button>
        <button type="submit" class="btn btn-danger" id="submitButton" onclick="fu();">Fix Schedule</button>
    </div>
</div> 



<div id="cancellationModal" class="modal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel1" aria-hidden="true">
    
    <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal" aria-hidden="true">x</button>
        <h3 id="myModalLabel1">Add event</h3>
    </div>   
    <div class="modal-body">
    <form:form id="createEvent" mclass="form-horizontal" >
    
         <div class="control-group">
           <label class="control-label" for="event">Event:</label>
              <input class="hh1" type="text" id="eventName"></input>
        </div>
        	<div class="control-group">
          	 	 <label class="control-label" for="startDate">Start date:</label>
          	 	<input class="hh2" type="text" id="startDate"></input>
       		 </div>
       		 <div class="control-group">
           		 <label class="control-label" for="endDate">End date:</label>
              <input class="hh3" type="text" id="endDate"></input>         
        </div>     
    </form:form>
    </div>
    <div class="modal-footer">
        <button class="btn" data-dismiss="modal" aria-hidden="true">Cancel</button>
        <button type="submit" class="btn btn-danger" id="submitButton" onclick="cs();">Cancel Schedule</button>
        
    </div>
</div> 





</body>
</html>
