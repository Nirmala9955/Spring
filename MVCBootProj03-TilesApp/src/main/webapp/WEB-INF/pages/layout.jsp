<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<head>
	<title><tiles:insertAttribute name="title"/></title>
</head>
<table style="height: 100%; width: 100%; border: 0;">
	<tr height="20%" bgcolor="cyan">
		<td colspan="2"><tiles:insertAttribute name="header"/></td>
	</tr>
	<tr height="70%" bgcolor="pink">
		<td width="30%"><tiles:insertAttribute name="menu"/></td>
		<td width="70%"><tiles:insertAttribute name="body"/></td>
	</tr>
	<tr height="10%" bgcolor="yellow">
		<td colspan="2"><tiles:insertAttribute name="footer"/></td>
	</tr>
</table>
