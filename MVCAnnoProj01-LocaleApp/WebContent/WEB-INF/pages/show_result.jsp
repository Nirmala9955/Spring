<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>

<h1 style="color: red; text-align: center">Welcome to Locale App</h1>
<h1 style="color: red; text-align: center">Result <c:out value="${operation}"/></h1> 

<c:choose>
	<c:when test="${!empty listInfo && listInfo ne null}">
		<c:forEach var="country" items="${listInfo}">
			<table bgcolor="pink" align="center">
				<tr>
					<td style="color: blue;">${country}</td>	
				</tr>
			</table>
		</c:forEach>
	</c:when>
	<c:otherwise>
		<h1 style="color:red; text-align: left;">No countries found</h1>
	</c:otherwise>
</c:choose>
<h3>Countries count : <c:out value="${fn:length(listInfo)}"></c:out> </h3>

<a href="welcome">Home</a>