<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="frm"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<h1 style="color:red; text-align: center;"><spring:message code="person.title"/></h1>
<frm:form modelAttribute="perFrm">
	<table align="center" bgcolor="cyan">
		<tr>
			<td><spring:message code="person.name"/>:</td>
			<td><frm:input path="name" /></td>
		</tr>
		<tr>
			<td><spring:message code="person.address"/>:</td>
			<td><frm:input path="address" /></td>
		</tr>
		<tr>
			<td><spring:message code="person.mobileNo"/>:</td>
			<td><frm:input path="mobileNo" /></td>
		</tr>
		<tr>
			<td colspan="2"><input type="submit" value="<spring:message code="person.submit.cap"/>" /></td>
		</tr>
	</table>
</frm:form>

<div style="text-align: center;">
	<a href="?lang=fr_FR">French</a> &nbsp;&nbsp;
	<a href="?lang=de_DE">German</a> &nbsp;&nbsp;
	<a href="?lang=hi_IN">Hindi</a> &nbsp;&nbsp;
	<a href="?lang=zh_CN">Chinese</a> &nbsp;&nbsp;
	<br><br>
	
<fmt:setLocale value="${pageCotext.response.locale}"/>
<jsp:useBean id="dt" class="java.util.Date"/>
<fmt:formatDate var="fdt" value="${dt}" dateStyle="FULL" type="both"/>
Formatted Date: ${fdt}
<br>
<fmt:formatNumber var="fno" value="3456789080878654" type="currency"/>
Fomratted Number: ${fno}
</div>
