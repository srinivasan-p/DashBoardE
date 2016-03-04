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
		
		        url: "topopulateaddevent.html",
	
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

</script>

</head>
<body onload="aj();">



<input type="hidden" id="status" value="Fix Schedule"readonly="readonly">



<div id="event" >


</div>














<script>
function doAjaxPost(eventName,startDate,endDate){
	$.ajax({
		type:"Post",
		url:"addEvent1.html",
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




<div id="calendar"></div>
<div id="createEventModal" class="modal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel1" aria-hidden="true">
    
    <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal" aria-hidden="true">x</button>
        <h3 id="myModalLabel1">Add event</h3>
    </div>
    
    
    
    <div class="modal-body">
    
    <form:form id="createEvent" modelAttribute="addEvent" mclass="form-horizontal" >
    
         <div class="control-group">
           <label class="control-label" for="event">Event:</label>
              <form:input type="text" path="event" id="eventName"></form:input>
        </div>
        	<div class="control-group">
          	 	 <label class="control-label" for="startDate">Start date:</label>
          	 	<form:input type="text" path="startDate" id="startDate"></form:input>
       		 </div>
       		 <div class="control-group">
           		 <label class="control-label" for="endDate">End date:</label>
              <form:input type="text" path="endDate" id="endDate"></form:input>         
        </div>     
    </form:form>
    </div>
    <div class="modal-footer">
        <button class="btn" data-dismiss="modal" aria-hidden="true">Cancel</button>
        <button type="submit" class="btn btn-primary" id="submitButton" onclick="fu();">Save</button>
    </div>
</div> 
</body>
</html>
