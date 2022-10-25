<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
</head>
<body>
	<div class="container p-3 my-3 bg-primary text-white">
		<h1 style="text-align: center">Employee InformationReport</h1>
	</div>
	<div class="container">
		<c:choose>
			<c:when test="${empsInfo ne null && !empty empsInfo}">
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
					<c:forEach var="dto" items="${empsInfo}">
						<tr>
							<td>${dto.serialNo}</td>
							<td>${dto.empNo}</td>
							<td>${dto.ename}</td>
							<td>${dto.job}</td>
							<td>${dto.sal}</td>
							<td>${dto.grossSalary}</td>
							<td>${dto.netSalary}</td>
							<td>${dto.deptNo}</td>
						</tr>
					</c:forEach>
				</table>
			</c:when>
		</c:choose>
				
		<h3><a href="welcome">Home</a></h3>
		<h2><a href="JavaScript:doPrint()">Print</h2>
	</div>
	<script lang="JavaScript"">
  			function doPrint() {
    			frames.focus();
    			frames.print();
  			}
	</script>
</body>
</html>

