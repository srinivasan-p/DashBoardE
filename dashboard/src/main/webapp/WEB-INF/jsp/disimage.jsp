<%@page import="com.dashboard.beans.ProfileBean" import="java.io.*"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>gvjh</h1>

<%
ProfileBean pb=(ProfileBean)request.getAttribute("bean");
if(pb.getPhoto()!=null){
byte[] b=pb.getPhoto();
  response.setContentType("image/gif");
  OutputStream oImage;
  oImage=response.getOutputStream();
  oImage.write(b);
  oImage.flush();
  oImage.close();
}
%>


</body>
</html>