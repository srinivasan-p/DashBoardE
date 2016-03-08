<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html lang="en">
<head>
<title>Bootstrap - Data Table</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
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
	
</head>
<body>
	<div class="container">
		<div class="row">
			<div class="box clearfix">
				<h3>Bootstrap Data Table</h3>
				<p>Easily turn your tables into datatables.</p>
				<form action="ScheduleInterview.html" method="post">
					<table class="table table-hover table-striped" id="bootstrap-table">
						<thead>
							<tr>
								<th>Interview ID</th>
								<th>Date and Time</th>
								<th>Interviewers</th>
								<th>Interviewees</th>
								<th>CheckBox</th>
							</tr>
						</thead>
						<tbody>
							<!-- Map<InterviewBean, Map<Map<ProfileBean,InterviewerBean>, Map<ProfileBean,IntervieweeBean>>> interviewMap; -->
							<c:forEach items="${result}" var="entry">
								<tr>
									<td>${entry.key.interviewId}</td>
									<td>${entry.key.iDate}</td>
									<c:forEach items="${entry.value}" var="e2">
										<td><ul class="list-group"><c:forEach items="${e2.key}" var="e3">
												<li class="list-group-item"><span class="badge">${e3.key.pId.pId}</span> ${e3.key.name}</li>
												
								
								</c:forEach></ul></td>
										<td><ul class="list-group"><c:forEach items="${e2.value}" var="e3">
												
												<li class="list-group-item"><span class="badge">${e3.key.pId.pId}</span> ${e3.key.name}</li>
								
								</c:forEach></ul></td>
									</c:forEach>

									<td><input type="checkbox" name="stinlist"
										value="${entry.key.interviewId}"></td>
								</tr>
							</c:forEach>
						</tbody>
					</table>
					<input type="submit">
				</form>
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