<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Form Registration</title>
</head>
<style type="text/css">

	body{
	    background: url("images/photo-1456513080510-7bf3a84b82f8.jpg");
	    height: 100%;
	    width: 100%;
	    background-repeat: no-repeat;
	    background-size: cover;
	    opacity: 0.65;
	    position: fixed;
	}
	.h1{
	    color:rgb(700, 0, 0);
	    font-family:Georgia, 'Times New Roman', Times, serif;
	    position: relative;
	    left: 730px;
	    top: 40px;
	}
	#form{
	    background:darkslategrey;
	    width: 360px;
	    height: auto;
	    position:relative;
	    left: 700px;
	    top: 45px;
	    padding: 15px;
	    font-family:'Trebuchet MS', 'Lucida Sans Unicode', 'Lucida Grande', 'Lucida Sans', Arial, sans-serif;
	    color:beige;
	    border: 1px hidden; 
	    border-radius: 25px;
	}
</style>
<body>
	<h2 class="h1">Registration Form</h2>

	<div id="form">
		<table>
			<tr>
				<td>${resultMessage}</td>
			</tr>
			<tr>
				<td><a href="index.html" style="color: gold">Home</a></td>
			</tr>
		</table>
	</div>
</body>
</html>


