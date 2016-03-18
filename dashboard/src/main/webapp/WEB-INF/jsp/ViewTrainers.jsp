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
						<div class="panel-heading">
							<span class="spansize">Available Trainers</span>
						</div>
						<div class="panel-body">
							<form action="" method="post">
								<table class="table table-hover" id="bootstrap-table">
									<thead>
										<tr>
											<th>Name</th>
											<th>Employee ID</th>
											<th>Email Id</th>
											<th>Skills</th>
											<th>Skill Points</th>
										</tr>
									</thead>
									<tbody>
										<c:forEach items="${result}" var="entry">
											<tr>
												<td>${entry.key.name}</td>
												<td>${entry.key.pId.pId}</td>
												<td>${entry.key.emailId}</td>
												<td><c:forEach items="${entry.value}" var="e2">
									${e2.skillId.skillName},
								</c:forEach></td>
												<td>${entry.key.skillPoints}</td>
												
											</tr>
										</c:forEach>
									</tbody>
								</table>
								
							</form>
						</div>
					</div>
				</div>

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