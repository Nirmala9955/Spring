<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="frm" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<h1 style="color: red; text-align: center;">Login APP</h1>
	<frm:form modelAttribute="user">
		<table bgcolor="cyan" border="1" align="center">
			<tr>
				<td>User Name : </td>
				<td><frm:input path="username"/></td>
			</tr>
			<tr>
				<td>User Password : </td>
				<td><frm:password path="password"/></td>
			</tr>
			<tr>
				<td colspan="2"><input type="submit" value="login"/></td>
			</tr>
		</table>
	</frm:form>
	
	<br>
	
	<c:if test="${resultMsg ne null && !empty resultMsg}">
		<h2 style="color:green; text-align: center;">${resultMsg}</h2>
	</c:if>

</body>
</html>