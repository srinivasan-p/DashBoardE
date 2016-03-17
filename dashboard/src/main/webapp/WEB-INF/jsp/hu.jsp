<%@page import="java.util.Date"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
 <%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<!-- Latest compiled and minified CSS -->
<link rel="stylesheet" class="btn btn-info" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css" integrity="sha384-1q8mTJOASx8j1Au+a5WDVnPi2lkFfwwEAa8hDDdjZlpLegxhjVME1fgjWPGmkzs7" crossorigin="anonymous">

<!-- Optional theme -->
<link rel="stylesheet" class="btn btn-info" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap-theme.min.css" integrity="sha384-fLW2N01lMqjakBkx3l/M9EahuwpSfeNvV63J5ezn3uZzapT0u7EYsXMjQV+0En5r" crossorigin="anonymous">

<!-- Latest compiled and minified JavaScript -->
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js" integrity="sha384-0mSbJDEHialfmuBBQP6A4Qrprq5OVfW37PRR3j5ELqxss1yVqOtnepnHVP9aJ7xS" crossorigin="anonymous"></script>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" class="btn btn-info" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.0/jquery.min.js"></script>
  <script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"></script>
  <script src="http://ajax.googleapis.com/ajax/libs/angularjs/1.4.8/angular.min.js"></script>
 
<title>Insert title here</title>

<style>
div{

margin-top:30px;margin-bottom:30px;

}
h5,a,h3{
font-family: "Droid Sans";
  font-style: normal;
color:#D9534F;
font-weight: bold !important;

}
span
{
margin-top:20px;
font-family: "Droid Sans";
  font-style: normal;
color:blue;
font-weight: bold !important;
font-size:15px;

}

textarea {
	color: #555;
	line-height: 1.5625;
	margin: 0;
	padding: 0;
	text-decoration: none;
}
.avatar,
.featuredpage img,
.featuredpost img,
.post-image {
	background-color: #f5f5f5;
	border: 1px solid #ddd;
	padding: 5px;
}


</style>

 



<script>var req;var url;
function myFunction(data,data1,desc){
//alert("im here in adding....");

req=new XMLHttpRequest();
if(data1>1)
	{
//	alert("wat happened");
	 url="tostorepost.html?description="+desc;
	}
else
	{
//	alert("right track"); 
url="tostorecomment.html?posttosend="+data+"&description="+desc+"&type="+data1;
	}

//alert(url);	
req.onreadystatechange= getResponse;//This implies that whenever state changes, getResponse is called.
	req.open("GET", url, true);	//Here it is calling the servlet, so this will change the state and hence call getResponse.

	req.send(null);  }



function getResponse(){
//alert("sahvdhsbjvdh");
	if (req.readyState==4) // if request is complete
		{
		}
}

function fun(data)
{
	//alert("todisplay"+data);
	
	var z = document.getElementById("todisplay"+data);
	z.style.display = "block";
	
	
	
	}

function sowat(data,data1)
{
	
	var z = document.getElementById("textarea"+data).value;
	var z1 = document.getElementById("e"+data);
	var z2 = document.getElementById("added"+data);
	z2.style.display = "block";
	z1.innerHTML = z1.innerHTML + z;
	var z12 = document.getElementById("todisplay"+data);
	z12.style.display = "none";
	myFunction(data,data1,z);
	
	}


</script>




</head>
<body>



<%
if(request.getAttribute("dataToDisplay")!=null){%>
<div class="container" style=" max-width: 900px;">
<h3>

	<%=request.getAttribute("dataToDisplay")%>!!!!!</h3></div><%} %>

<div class="container" style=" max-width: 900px;">
<div class="jumbotron">

<h3>Ask Your Doubt</h3>

<textarea rows="5"  style="width: 100%;" style="width: 100%;" id="textarea<%=session.getAttribute("pId") %>"></textarea><br/><br/>
<!-- You 7425 for tym being... -->
<button type="button" class="btn btn-info" onclick="sowat(<%=session.getAttribute("pId") %>,5);">Post</button>


</div>
</div>

<div class="container" style=" max-width: 900px;">
<div style="border:1px solid #d6d4d7;padding-left:40px;display:none;" id="added<%=session.getAttribute("pId") %>">
<img src="pic.html?a=<%=session.getAttribute("pId") %>" style="float:right;padding-top:10px" width="60" height="60" class="avatar photo avatar-48"/>

<span style="text-transform: capitalize;font-family: sans-serif;color:#D9534F;">You</span>&nbspsays:
<h5><%SimpleDateFormat sdf = new SimpleDateFormat("MMM d, yyyy 'at' h:mm a");
Date d = new Date();
%><%=sdf.format(d) %></h5>





<p id="e<%=session.getAttribute("pId") %>">
</p></div></div></div>

<div style="border:1px solid #d6d4d7;padding-left:40px;display:none"; id="todisplay<%=session.getAttribute("pId") %>"></div>






<%! int k = 0,k1=0;%>
 <c:forEach items="${jsonobject.array}" var="entry" > 
 
<div class="well container" style=" max-width: 900px;">

<div style="border:1px solid #d6d4d7;padding-left:40px;">
<img src="pic.html?a=${entry.postdetails[0]}" style="float:right;padding-right:10px" width="60" height=auto class="avatar photo avatar-48"/>

<span style="text-transform: capitalize;font-family: sans-serif;color:#D9534F;">${entry.postdetails[1]}</span>&nbspsays:

<br/><h5>${entry.postdetails[2]}</h5>



<p>${entry.postdetails[3]}</p>

<a class="btn btn-info" class="btn btn-info" href="#${entry.postdetails[0]}" onclick="fun(${entry.postdetails[0]});">Reply</a>
<%-- Status........${status.index} --%>

<c:forEach items="${entry.commentarray}" var="entry2" varStatus="status"> 

 <c:set var="string" value="${entry2}" ></c:set>
 <c:choose>
 <c:when test="${fn:startsWith(string, '[')}">

<div style="border:1px solid #d6d4d7;padding-left:40px;">
<%k=1; %>
<%--  ....................... ${entry2[0]}<br/> --%>
<img src="pic.html?a=${entry2[0]}" style="float:right;padding-right:10px" width="60" height="60" class="avatar photo avatar-48"/>
 
 <span style="text-transform: capitalize;font-family: sans-serif;color:#D9534F;">${entry2[1]} </span> says:<br/>
 
<h5>${entry2[2]}</h5>


<p>${entry2[3]}</p>

</div>

</c:when>
<c:otherwise>
<%k1++; %>



<%if(k1 > 4){%> 

 <a class="btn btn-info" href="#${p}" onclick="fun(${p});">Reply</a>
<div style="border:1px solid #d6d4d7;padding-left:40px;display:none;" id="added${p}">
<img src="pic.html?a=<%=session.getAttribute("pId") %>" style="float:right;padding-top:10px" width="60" height="60" class="avatar photo avatar-48"/>

<span style="text-transform: capitalize;font-family: sans-serif;color:#D9534F;">You </span>says:

<h5><%SimpleDateFormat sdf1 = new SimpleDateFormat("MMM d, yyyy 'at' h:mm a");
Date d1 = new Date();
%><%=sdf1.format(d1) %></h5>
<p id="e${p}"> </div>
</p>
<div style="border:1px solid #d6d4d7;padding-left:40px;display:none"; id="todisplay${p}">

<div>
<textarea rows="5" width=100% style="width: 90%;" id="textarea${p}"></textarea>
</div>
<button type="button" class="btn btn-info" onclick="sowat(${p},1)">Post</button></div>
</div><% k1 = 1; k=0;}  %>
<%if(k1==1&&k==0){%><div style="border:1px solid #d6d4d7;padding-left:40px;"><%} %>

<%if(k1==1){ %>    
<c:set var="p" value="${entry2}" />

<%} %>
<%if(k1==2){ %>
<img src="pic.html?a=${p}" style="float:right;padding-right:10px" width="60" height="60" class="avatar photo avatar-48"/>
 
<span style="text-transform: capitalize;font-family: sans-serif;color:#D9534F;">${entry2} </span>says:<br/><%} %>
<%if(k1==3){ %> 
<h5>${entry2}</h5>
<!-- dont know img -->

<%} %>
<%if(k1==4){ %> 
<p>${entry2}</p><%} %>
</c:otherwise></c:choose>

<c:if test="${status.last}">

<%if(k1 >=4){%><a href="#${p}" class="btn btn-info" onclick="fun(${p});">Reply</a> 
<div style="border:1px solid #d6d4d7;padding-left:40px;display:none;" id="added${p}">
<img src="pic.html?a=<%=session.getAttribute("pId") %>" style="float:right;padding-top:10px" width="60" height="60" class="avatar photo avatar-48"/>

<span style="text-transform: capitalize;font-family: sans-serif;color:#D9534F;">You</span> says:
<h5><%SimpleDateFormat sdf2 = new SimpleDateFormat("MMM d, yyyy 'at' h:mm a");
Date d2 = new Date();
%><%=sdf2.format(d2) %></h5>

<p id="e${p}">  </div>
</p>
<div style="border:1px solid #d6d4d7;padding-left:40px;display:none"; id="todisplay${p}">

<div>
<textarea rows="5" width=100% style="width: 90%;" id="textarea${p}"></textarea>
</div>
<button type="button" class="btn btn-info" onclick="sowat(${p},1)">Post</button></div>
</div><% k1 = 1; k=0;}  %>
</c:if>

 </c:forEach>

<div style="border:1px solid #d6d4d7;padding-left:40px;display:none;" id="added${entry.postdetails[0]}">
<img src="pic.html?a=${entry.postdetails[0]}" style="float:right;padding-right:10px" width="60" height="60" class="avatar photo avatar-48"/>

<span style="text-transform: capitalize;font-family: sans-serif;color:#D9534F;">You</span> says:

<h5><%SimpleDateFormat sdf4 = new SimpleDateFormat("MMM d, yyyy 'at' h:mm a");
Date d4 = new Date();
%><%=sdf4.format(d4) %></h5>

<p id="e${entry.postdetails[0]}"> </div>
</p>
<div style="border:1px solid #d6d4d7;padding-left:40px;display:none"; id="todisplay${entry.postdetails[0]}">

<div>
<textarea rows="5" width=100% style="width: 90%;" id="textarea${entry.postdetails[0]}"></textarea>
</div>
<button type="button" class="btn btn-info" onclick="sowat(${entry.postdetails[0]},0)">Post</button></div>






</div><%k1=0; %></div>
</c:forEach> 
<div class="text-center">
<a  href="hello.html" id="toSendPagePrevious" onclick="previous();" style="color:#d6d4d7;" ><span style="font-size:20px;color:#d6d4d7;"><<</span></a>
<a class="btn btn-default" href="hello.html" id="toSendPage" class="text"><span style="font-size:48px;"></span></a>
<a  href="hello.html" id="toSendNext"  onclick="next();" style="color:#d6d4d7;" ><span style="font-size:20px;color:#d6d4d7;">>></span></a>
</div>
<script>
//alert(window.location.href);
var toSend = document.getElementById("toSendPage");
var valueOfPage = window.location.href.slice(-1);
if(valueOfPage=='l')
	{
	valueOfPage = 1;
//	toSendPagePrevious.className =	toSendPagePrevious.className + " disabled";
	}
	

var val = parseInt(valueOfPage)+1;
		if(val>1){
//alert(val);
toSendPage.setAttribute("href","hello.html?page="+val);
//alert(toSendPage.getAttribute("href"));
toSendPage.innerHTML = valueOfPage;
toSendPagePrevious.setAttribute("href","hello.html?page="+(parseInt(val)-2));

toSendNext.setAttribute("href","hello.html?page="+val);}
		else
			{
			alert("no more pages to display");
			}
</script>


</body>
</html>