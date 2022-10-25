<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
<html>
<head>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
</head>
<body>
	<div class="container p-3 my-3 bg-primary text-white">
		<h1 style="text-align: center">Error Page</h1>
	</div>
	<div class="container p-3 my-3 border">
		<h2>Internal Problem: Try after some time</h2>
		<h3>Message: ${message}</h3>
		<h3>Status: ${status}</h3>
		<a href="welcome.htm"><img src="images/home.jpg" width="100" height="70"/></a>
	</div>
</body> 
</html>
