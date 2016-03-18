<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>


<!DOCTYPE html>
<html lang="en">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.0/jquery.min.js"></script>
<script
	src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"></script>
<title>Your skills</title>
<style type="text/css">
.spansize {
	font-size: 1.5em;
}
.table-borderless tbody tr td, .table-borderless tbody tr th, .table-borderless thead tr th {
    border: none;
}
</style>
</head>
<body><br><br>
	<div class="container-fluid">
		<div class="panel-group">
			<div class="panel panel-primary">
				<div class="panel-heading">
					<span class="spansize">Skill you have...</span>
				</div>
				<div class="panel-body">
					<table class="table table-borderless">
						<tr>
							<td><strong>#</strong></td>
							<td><strong>Skill Name</strong></td>
						</tr>
						<c:forEach items="${skillList}" var="element" varStatus="loop">


							<tr>
								<td><c:out value="${loop.index+1}" /></td>
								<td><c:out value="${element}" /></td>
							</tr>

						</c:forEach>
					</table>
				</div>
			</div>
		</div>
	</div>



</body>
</html>