<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@taglib uri="http://www.springframework.org/tags/form" prefix="frm"%>

<h1 style="color:red; text-align: center;">Person Details Form</h1>
<frm:form modelAttribute="perFrm">
	<table align="center" bgcolor="cyan">
		<tr>
			<td>Person Name:</td>
			<td><frm:input path="name" /></td>
		</tr>
		<tr>
			<td>Person Address:</td>
			<td><frm:input path="address" /></td>
		</tr>
		<tr>
			<td>Person Mobile Number:</td>
			<td><frm:input path="mobileNo" /></td>
		</tr>
		<tr>
			<td>Person Gender:</td>
			<td><frm:radiobuttons path="gender" items="${gendersList}" /></td>
		</tr>
		<tr>
			<td>Person Hobbies:</td>
			<td><frm:checkboxes path="hobbies" items="${hobbiesList}" /></td>
		</tr>
		<tr>
			<td>Person Qualification:</td>
			<td><frm:select path="qualification">
					<frm:options items="${qualificationsList}" />
				</frm:select></td>
		</tr>
		<tr>
			<td>Favorite color:</td>
			<td><frm:select path="colors" multiple="multiple">
					<frm:options items="${colorsList}" />
				</frm:select></td>
		</tr>
		<tr>
			<td>DOB (dd-mm-yyyy):</td>
			<td><frm:input type="date" path="dob" /></td>
		</tr>
		<tr>
			<td>DOJ (dd-mm-yyyy):</td>
			<td><frm:input type="date" path="doj" /></td>
		</tr>
		<tr>
			<td>Salary Range:</td>
			<td><frm:input type="range" min="10000" max="100000" path="salary" /></td>
		</tr>
		<tr>
			<td colspan="2"><input type="submit" value="Register" /></td>
		</tr>
	</table>
</frm:form>
