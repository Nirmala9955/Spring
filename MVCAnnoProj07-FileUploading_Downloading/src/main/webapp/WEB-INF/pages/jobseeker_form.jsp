	<%@ page isELIgnored="false"%>
	<%@taglib uri="http://www.springframework.org/tags/form" prefix="frm"%>
	
	<h1 style="color: red; text-align: center;">File Uploading Page</h1>
	
	<frm:form modelAttribute="jsFrm" enctype="multipart/form-data">
		<table align="center" bgcolor="cyan">
			<tr>
				<td>Job Seeker Name : </td>
				<td><frm:input path="jsName"/></td>
			</tr>
			<tr>
				<td>Job Seeker Address : </td>
				<td><frm:input path="jsAddress"/></td>
			</tr>
			<tr>
				<td>Job Seeker Resume : </td>
				<td><input type="file" name="resume"/></td>
			</tr>
			<tr>
				<td>Job Seeker Photo : </td>
				<td><input type="file" name="photo"/></td>
			</tr>
			<tr>
				<td><input type="reset" value="Cancel"/></td>
				<td><input type="submit" value="Upload"/></td>
			</tr>
		</table>
	</frm:form>
