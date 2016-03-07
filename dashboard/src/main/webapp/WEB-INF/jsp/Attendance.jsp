<%@page import="com.itextpdf.text.log.SysoLogger"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="com.dashboard.util.DBUtill"%>
<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script type="text/javascript">
function fun(skill)
{
	alert(skill);
	
}
</script>
</head>
<body>
<form action="TrainerController.html" method="POST">
<select onchange="fun(this.value);">
<option value="select">select</option>
<%
String pId =(String)session.getAttribute("pId");
String pIdsql = pId+"%";
Connection Conn = DBUtill.getDBConnection();
PreparedStatement pre = Conn.prepareStatement("SELECT title from newdb.db_Trainer where courseId like ? and skillId in (Select skillId from newdb.db_studskill where pId = ?)");

pre.setString(1, pIdsql);
pre.setString(2, pId);
ResultSet rs=pre.executeQuery();
while(rs.next())
{

%>
<option value = <%=rs.getString(1)%>><%=rs.getString(1)%></option>
<%}%>
</select>
</form>
</body>
</html>