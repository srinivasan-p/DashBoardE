<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.util.*" import="com.dashboard.beans.*"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>

<!-- Latest compiled and minified CSS -->
<link rel="stylesheet" class="btn btn-info" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css" integrity="sha384-1q8mTJOASx8j1Au+a5WDVnPi2lkFfwwEAa8hDDdjZlpLegxhjVME1fgjWPGmkzs7" crossorigin="anonymous">

<!-- Optional theme -->
<link rel="stylesheet" class="btn btn-info" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap-theme.min.css" integrity="sha384-fLW2N01lMqjakBkx3l/M9EahuwpSfeNvV63J5ezn3uZzapT0u7EYsXMjQV+0En5r" crossorigin="anonymous">

<!-- Latest compiled and minified JavaScript -->

<link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.0/jquery.min.js"></script>
  <script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"></script>
  
  
 <style>
	#a1{
	    color:#4169E1;
	    background-color: transparent;
	    text-decoration: none;
	}
	
	#a2{
	    color:#87CEEB ;
	    background-color: transparent;
	    text-decoration: none;
	}
	/* #a2:link {
	    color: #9C6B98;
	    background-color: transparent;
	    text-decoration: none;
	}
	 */
	/* a:visited {
	    color: #9C6B98;
	    background-color: transparent;
	    text-decoration: none;
	}
	a:hover {
	    color: #9C6B98;
	    background-color: transparent;
	    text-decoration: none;
	}
	a:active {
	    color: #F0A804;
	    background-color: transparent;
	    text-decoration: none;
	}
	 */
	
	 
	/* #header{
		
		margin-left:10px;
		
		/* color:#96CDCD; */
		
	}
	
	#blank{
		background-color:#eeeeee;
		height:15px;
    	width:100%;
	}
	 */
	#nav-links{
		margin-left:10px;
	}

	#color{
		float: left;
		margin-top:5px;
		margin-left:10px;
    	background-color:#87CEEB; 
    	width: 15px;
    	height:15px;
	}
	
	#color1{
		float: left;
		margin-top:5px;
		margin-left:10px;
    	background-color:#4169E1;
    	width: 15px;
    	height:15px;
	}
	
	
	.badge1 {
   position:relative;
	}
	.badge1[data-badge]:after {
   content:attr(data-badge);
   position:absolute;
   top:-10px;
   right:-10px;
   font-size:.7em;
   background:#DB2929;
   color:white;
   width:18px;height:18px;
   text-align:center;
   line-height:18px;
   border-radius:50%;
   box-shadow:0 0 1px #333;
}
	
  
</style>
</head>


<body>


 
<div id="header" class="navbar navbar-inverse navbar-fixed-top navbar-collapse">
	
	<div class="navbar-header navbar-brand" style="list-style-type: none;color:white;font-family: sans-serif;">
				Announcements List 
				&nbsp 
				<a href="viewannouncements.html" class="badge1 navbar-btn" data-badge="<%=request.getAttribute("count")%>"><img src="https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcRxnB63uHyqJ3YFgxrfcjfA32JAJgUcztLhRIrjnSTyRRQKM_dd"" width=28px height=28px/></a>
			</div>
	<ul>
		
			
			
			
			<li class="nav navbar-nav navbar-right"><input type="text" id="search">
			
			<button type="button" class="btn btn-danger navbar-btn" onclick="doAjaxSearch();"> <span class="glyphicon glyphicon-search"></span> Search
 		    </button>
				
			</li>
			
	</ul>
</div>


<hr>
<br>
<br>



<%ArrayList<AnnouncementBean> announcementBeans=(ArrayList<AnnouncementBean>)request.getAttribute("announcements1");%>
<%ArrayList<AnnouncementBean> readAnnouncements=(ArrayList<AnnouncementBean>)request.getAttribute("readAnnouncements");

for(AnnouncementBean a:readAnnouncements){
	System.out.println(a);
}%>
 <%-- <%ArrayList<String> subjects=(ArrayList<String>)request.getAttribute("subjects");%>  --%>
<%int i=0;%>




<div class="well" id="nav-links">

	<%if((Integer)request.getAttribute("count")==0){%>
			&nbsp There are no new announcements
	<%}else if((Integer)request.getAttribute("count")==1){%>
		&nbsp 1 new announcement
	<%}else{%>
		&nbsp There are "<%=request.getAttribute("count")%>" new announcements
	<%}%>
<p><div id="color"></div><font>&nbsp &nbsp &nbsp &nbsp Unread</font></p>
<p><div id="color1"></div><font>&nbsp &nbsp &nbsp &nbsp read</font></p>

<hr>
	<%
	for(AnnouncementBean sub:announcementBeans){
			
			SimpleDateFormat sdf=new SimpleDateFormat("MMM d, yyyy 'at' h:mm a");
			String dt=sdf.format(sub.getAnnouncemntDt());
			System.out.println("Full**"+sub);
			int count2=0;
			for(AnnouncementBean a:readAnnouncements){
				System.out.println("read**"+a);
   	
   	%>
   	
   
   	<%if(sub.getAnnouncemntId()==a.getAnnouncemntId()){
   			count2=1;
   			System.out.println("in if part");%> 
   			<p><div style="margin-left:10px;"><span class="glyphicon glyphicon-calendar"></span><font color="black"><%=dt%></font></div> <h4 style="text-transform:capitalize;"><a id="a1" href="#!b<%=i%>"> &nbsp &nbsp &nbsp<%=sub.getSubject()%></a></h4>&nbsp &nbsp &nbsp &nbsp<font color="#388E8E">created by: <%=sub.getUpdatedBy()%></font></p>
   			
   			 <div class='box' id='b<%=i%>'>&nbsp &nbsp &nbsp &nbsp <%=sub.getMessage()%></div>
   			 <input type="hidden" id="anmtId<%=i%>" value=<%=sub.getAnnouncemntId()%>>
   			<hr>
   		<%i++;
   		break;
   		}}%>
		
   			<%
   			if(count2==0){System.out.println("count2"+count2);%> 
   			<p><div style="margin-left:10px;"><span class="glyphicon glyphicon-calendar"></span><font color="black"><%=dt%></font></div> <h4 style="text-transform:capitalize;"><a id="a2" href="#!b<%=i%>"> &nbsp &nbsp &nbsp<%=sub.getSubject()%></a></h4>&nbsp &nbsp &nbsp &nbsp<font color="#388E8E">created by: <%=sub.getUpdatedBy()%></font></p>
   			<div class='box' id='b<%=i%>'>&nbsp &nbsp &nbsp &nbsp <%=sub.getMessage()%></div>
   			<input type="hidden" id="anmtId<%=i%>" value=<%=sub.getAnnouncemntId()%>>
    		<hr>
    	<%System.out.println("i**"+i);i++;
   			} }
   			%> 
    	
   
   		 <%-- <%System.out.println("i**"+i);%>  --%>
  		
   		
		
   <!--  <a href="#!b1"> link 1 </a> -->
   

	</div>

	




<script type="text/javascript">




	var current;
	
    var links = document.getElementById('nav-links').getElementsByTagName('a');
    for(var i = 0,link; link = links[i]; i++) {
      //alert("aa");
    	link.onclick = showContent;
        // Hide content divs by default
       getContentDiv(link).style.display = 'none';
    }
    // Show the first content div
   //if(links.length > 0) showContent.apply(links[0]);
	
   

    function showContent() {

    	//alert("in show content");
        // hide old content
       /* if(current) current.style.display = 'none';
		
      current.style.display = 'block'; */
       
        current = getContentDiv(this);
       // alert(current.value);
        if(!current) return true;
	        //current.innerHTML = "This is where the xml variable content should go";
        if(current.style.display === 'block'){ //display
        	current.style.display = 'none';
        }
        else{
        	current.style.display = 'block';
        }
      
        
        doAjax(document.getElementById("anmtId"+getanmtId(this)).value);	
    

        return true; 
       

    }

    function getContentDiv(link) {

    	
    	//alert("in get content");
        var linkTo = link.getAttribute('href');

        // Make sure the link is meant to go to a div
        if(linkTo.substring(0, 2) != '#!') return;
        linkTo = linkTo.substring(2);
		
        return document.getElementById(linkTo);

    }
    
	function getanmtId(link) {
	
	    	
	    	//alert("in get content");
	        var linkTo = link.getAttribute('href');
	
	        // Make sure the link is meant to go to a div
	        if(linkTo.substring(0, 2) != '#!') return;
	        linkTo = linkTo.substring(3);
			//alert(linkTo);
	        return linkTo;
	
	    }
    
    
   
    function doAjax(anmtId){
    	//alert(anmtId);
    	
    	
    	$.ajax({  
		     type : "Post",   
		     url : "addstatus.html",   
		     data : "&anmtId=" + anmtId,
		     success : function(response) {  
		    	//alert("success");
		     
		    	
		    	 	
		    	 
		      },  
		     error : function(e) {  
		     			 alert('Error: ' + e);   
		     		}  
		   	  }); 
    	
    	}
    
	 function doAjaxSearch(){
    	
	        document.getElementById("nav-links").innerHTML="";
	    	var search=document.getElementById('search').value;
	    	//alert(search);
	    	
	    	$.ajax({  
			     type : "Post",   
			     url : "searching.html",   
			     data : "&search=" + search,
			     success : function(response) {  
			    	//alert(response);
			     
			    	$('#nav-links').html(response); 	 
			      }
			 }); 
    	
    	}
    	
    

</script>
</body>
</html>