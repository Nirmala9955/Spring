<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="frm"%>
<html>
<head>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
<!-- <script language="JavaScript" src="js/validation.js">
	
</script> -->
</head>
<body>
	<div class="container p-3 my-3 bg-primary text-white">
		<h1 style="text-align: center">Employee Registration</h1>
	</div>
	<div class="container">
		<script language="JavaScript" src="js/validation.js">
			
		</script>
		<frm:form modelAttribute="empFrm" onsubmit="return validate(this)">
			<table class="table table-dark table-striped table-sm">
				<tr>
					<th>Employee Name</th>
					<th><frm:input path="ename" /> <frm:errors
							cssClass="text-danger" path="ename" /><span id="enameId"></span></th>
				</tr>
				<tr>
					<th>Employee Designation</th>
					<th><frm:input path="job" /> <frm:errors
							cssClass="text-danger" path="job" /><span id="jobId"></span></th>
				</tr>
				<tr>
					<th>Employee Salary</th>
					<th><frm:input path="sal" /> <frm:errors
							cssClass="text-danger" path="sal" /><span id="salId"></span></th>
				</tr>
				<tr>
					<th>Department Number</th>
					<th><frm:select path="deptNo">
							<frm:options items="${deptsInfo}" />
						</frm:select></th>
				</tr>
				<tr>
					<td colspan="2"><input type="submit" value="Register" /></td>
				</tr>
			</table>
			<frm:hidden path="vflag"/>
		</frm:form>
	</div>
</body>
</html>