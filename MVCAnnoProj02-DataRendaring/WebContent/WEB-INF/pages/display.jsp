<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<h1 style="color: red; text-align: center;">${msg}</h1>
<%-- <b>Names : </b>
	<c:forEach var="name" items="${namesInfo}">
		${name} <br>
	</c:forEach>
	<hr>
<b>Fruits : </b>
	<c:forEach var="fruit" items="${fruitsInfo}">
		${fruit} <br>
	</c:forEach>
	<hr>
<b>Phones : </b>
	<c:forEach var="phone" items="${phonesInfo}">
		${phone} <br>
	</c:forEach>
	<hr>
<b>Ages : </b>
	<c:forEach var="age" items="${agesInfo}">
		${age} <br>
	</c:forEach>
	<hr> --%>
	
<b>Student Details : </b>
<c:choose>
	<c:when test="${studentDetails ne null && !empty studentDetails}">
		<table border="1" align="center">
			<tr> <th>sno</th><th>sname</th><th>sadd</th></tr>
			<c:forEach var="student" items="${studentDetails}">
				<tr>
					<td>${student.sno}</td>
					<td>${student.sname}</td>
					<td>${student.sadd}</td>
				</tr>
			</c:forEach>
		</table>
	</c:when>
</c:choose>