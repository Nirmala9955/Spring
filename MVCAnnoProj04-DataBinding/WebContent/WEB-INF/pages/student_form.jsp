<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="frm"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
</head>
<body>
	<div class="container p-3 my-3 bg-primary text-white">
		<h1>Student Registration Form page</h1>
	</div>
	<frm:form action="register" method="POST" modelAttribute="stFrm">
	<div class="container">
		<table class="table table-dark table-striped table-sm">
			<tr>
				<td>Student Number: </td>
				<td><frm:input path="sno"/></td>
			</tr>
			<tr>
				<td>Student Name: </td>
				<td><frm:input path="sname"/></td>
			</tr>
			<tr>
				<td>Student Address: </td>
				<td><frm:input path="sadd"/></td>
			</tr>
			<tr>
				<td>Student Mark: </td>
				<td><frm:input path="avg"/></td>
			</tr>
			<tr>
				<td colspan="2"><input type="submit" value="Register student"/></td>
			</tr>
		</table>
	</div>
	</frm:form>
</body>
</html>