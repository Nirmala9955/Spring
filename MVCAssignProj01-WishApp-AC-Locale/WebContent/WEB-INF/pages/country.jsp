<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false" import="java.util.Arrays" %>

<h1 style="color: red; text-align: center">Welcome to Wish App</h1><br>
<h2 style="color: cyan; text-align: left">Counties are</h2>

<c:forEach var="temp" items="${allCountry}">
        <font color="#00CC00"><c:out value="${temp}"/>, </font>
</c:forEach> <br>
<a href="wish.htm">back</a>