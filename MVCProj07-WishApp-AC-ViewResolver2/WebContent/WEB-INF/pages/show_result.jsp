<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page isELIgnored="false"%>

<h1 style="color: red; text-align: center">Welcome to Wish App</h1><br>
<h2 style="color: cyan; text-align: center">
	<c:out value="${wishMessage}"/>
</h2>

<a href="welcome.htm">Home</a>