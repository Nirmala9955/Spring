<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
</head>
<body>
	<div class="container p-3 my-3 bg-primary text-white">
		<h1 style="text-align: center">Employee InformationReport</h1>
	</div>
	<div class="container">
	<c:choose>
			<c:when test="${page ne null && !empty page}">
				<table class="table table-dark table-striped table-sm">
					<tr>
						<th>Serial No.</th>
						<th>Employee ID</th>
						<th>Employee Name</th>
						<th>Designation</th>
						<th>Salary</th>
						<th>Gross Salary</th>
						<th>Net Salary</th>
						<th>Department No.</th>
					</tr>
					<c:forEach var="dto" items="${page.getContent()}">
						<tr>
							<td>${dto.serialNo}</td>
							<td>${dto.empNo}</td>
							<td>${dto.ename}</td>
							<td>${dto.job}</td>
							<td>${dto.sal}</td>
							<td>${dto.grossSalary}</td>
							<td>${dto.netSalary}</td>
							<td>${dto.deptNo}</td>
					</c:forEach>
				</table>
				<br>
				<div style="text-align: center;">
					<a href="report_paging.htm?page=0">First Page</a>&nbsp;&nbsp;&nbsp;
					<c:if test="${!page.isFirst()}">
						<a href="report_paging.htm?page=${page.getNumber()-1}">Previous</a>
					</c:if>&nbsp;&nbsp;&nbsp;
					<c:forEach var="i" begin="0" end="${page.getTotalPages()-1}" step="1">
						[<a href="report_paging.htm?page=${i}">${i+1}</a>]&nbsp;&nbsp;&nbsp;
					</c:forEach>&nbsp;&nbsp;&nbsp;
					<c:if test="${!page.isLast()}">
						<a href="report_paging.htm?page=${page.getNumber()+1}">Next</a>
					</c:if>&nbsp;&nbsp;&nbsp;
					<a href="report_paging.htm?page=${page.getTotalPages()-1}">Last Page</a>
				</div>
			</c:when>
		</c:choose>
	</div>
</body>
</html>