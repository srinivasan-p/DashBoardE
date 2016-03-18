<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="com.dashboard.util.DBUtill"%>
<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta name="description" content="">
<meta name="author" content="">
<title>AuthorizeAccess</title>
<link rel="canonical" href="http://www.bootstraptoggle.com">
<link
	href="https://cdnjs.cloudflare.com/ajax/libs/highlight.js/8.3/styles/github.min.css"
	rel="stylesheet">
<link
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.2.0/css/bootstrap.min.css"
	rel="stylesheet">
<link
	href="https://maxcdn.bootstrapcdn.com/font-awesome/4.2.0/css/font-awesome.min.css"
	rel="stylesheet">
<link href="css/bootstrap-toggle.css" rel="stylesheet">
<link href="doc/stylesheet.css" rel="stylesheet">
<script src="https://code.jquery.com/jquery-2.1.1.min.js"></script>



<!-- Bootstrap Core CSS -->
<link href="css/bootstrap.min.css" rel="stylesheet">

<!-- Custom CSS -->
<link href="css/simple-sidebar.css" rel="stylesheet">




<script type="text/javascript">
	function func(id) {
		$.ajax({

			type : "Post",

			url : "AuthorizeAccess.html",

			data : "&id=" + id,

			success : function(response) {

				// we have the response

				$("#" + id + "div").html(response);

			}

		});
	}
</script>

<link href="../dashboard/assets/css/vendor/bootstrap.min.css"
	type="text/css" rel="stylesheet">
<link href="../dashboard/assets/css/vendor/font-awesome.min.css"
	type="text/css" rel="stylesheet">
<link
	href='https://fonts.googleapis.com/css?family=Open+Sans:400,300,600'
	rel='stylesheet' type='text/css'>
<link href="../dashboard/assets/css/jquery.bdt.css" type="text/css"
	rel="stylesheet">
<link href="../dashboard/assets/css/style.css" type="text/css"
	rel="stylesheet">
<style type="text/css">
.spansize {
	font-size: 1.5em;
}
</style>
</head>
<body>
	<div class="container-fluid">
		<div class="row">
			<div class="box clearfix">
				<div class="panel-group">
					<div class="panel panel-primary">
						<div class="panel-heading"><span class="spansize">Authorize Access</span></div>
						<div class="panel-body"><table class="table table-stripped table-hover" id="bootstrap-table">
					<thead>
						<tr>
							<th><h4>Name</h4></th>
							<th><h4>Id</h4></th>
							<th><h4>Type</h4></th>
							<th><h4>Authorized/Not-Authorized</h4></th>
							<th><h4>Status</h4></th>
						</tr>
					</thead>
					<%
						Connection conn = DBUtill.getDBConnection();
						PreparedStatement pre = conn.prepareStatement("select * from newdb.db_credential where type !='a'");
						ResultSet rs = pre.executeQuery();

						while (rs.next()) {
							PreparedStatement pre1 = conn.prepareStatement("select * from newdb.db_profile where pId =?");
							pre1.setString(1, rs.getString("pId"));
							ResultSet rs2 = pre1.executeQuery();
							rs2.next();
							if (rs.getInt("status") == 9999) {
					%>
					<tbody>
						<tr>
							<td><h5><%=rs2.getString("name")%></h5></td>
							<td><h5><%=rs2.getString("pId")%></h5></td>
							<td><h5>
									<%
										if (rs.getString("type").equalsIgnoreCase("t")) {
									%>Trainer<%
										} else {
									%>Student<%
										}
									%>
								</h5></td>
							<td><input id="<%=rs.getString("pId")%>" type="checkbox"
								data-toggle="toggle" data-on="Authorized"
								data-off="Not Authorized" data-onstyle="success"
								data-offstyle="danger" onchange="func(this.id)"></td>
							<td id="<%=rs.getString("pId")%>div"></td>

						</tr>
						<%
							} else {
						%>
						<tr>
							<td><h5><%=rs2.getString("name")%></h5></td>
							<td><h5><%=rs2.getString("pId")%></h5></td>
							<td><h5>
									<%
										if (rs.getString("type").equalsIgnoreCase("t")) {
									%>Trainer<%
										} else {
									%>Student<%
										}
									%>
								</h5></td>
							<td><input id="<%=rs.getString("pId")%>" checked="checked"
								type="checkbox" data-toggle="toggle" data-on="Authorized"
								data-off="Not Authorized" data-onstyle="success"
								data-offstyle="danger" onchange="func(this.id)"></td>
							<td id="<%=rs.getString("pId")%>div"></td>
						</tr>
						<%
							}
							}
						%>
					</tbody>
				</table></div>
					</div>
				</div>

				
				<script
					src="https://maxcdn.bootstrapcdn.com/bootstrap/3.2.0/js/bootstrap.min.js"></script>
				<script src="js/bootstrap-toggle.js"></script>

				<!-- jQuery -->
				<script src="js/jquery.js"></script>

				<!-- Bootstrap Core JavaScript -->
				<script src="js/bootstrap.min.js"></script>

				<!-- Menu Toggle Script -->
				<script>
					$("#menu-toggle").click(function(e) {
						e.preventDefault();
						$("#wrapper").toggleClass("toggled");
					});
				</script>
			</div>
		</div>
	</div>

	<script src="http://code.jquery.com/jquery-2.1.1.min.js"
		type="text/javascript"></script>
	<script src="../dashboard/assets/js/vendor/bootstrap.min.js"
		type="text/javascript"></script>
	<script src="../dashboard/assets/js/vendor/jquery.sortelements.js"
		type="text/javascript"></script>
	<script src="../dashboard/assets/js/jquery.bdt.js"
		type="text/javascript"></script>
	<script>
		$(document).ready(function() {
			$('#bootstrap-table').bdt();
		});
	</script>
</body>
</html>