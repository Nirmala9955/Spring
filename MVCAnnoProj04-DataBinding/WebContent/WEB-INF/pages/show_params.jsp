<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
</head>
<body>
	<div class="container p-3 my-3 bg-primary text-white">
		<h1>Show Params Page</h1>
	</div>
	<div class="container">
		<h3>Request param values: </h3> ${param.sno}, ${param.sname} 
		<br><br><a href="register">Home</a>
	</div>
</body>
</html>