<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<%@ taglib uri="http://www.springframework.org/tags/form" prefix="s"%>
<%@ taglib uri="http://java.sun.com/jstl/core" prefix="j"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>HomePage</title>
</head>
<body>
	<s:form action="/createUserInfo" modelAttribute="userinfo">
		<table>
			<tr>
				<td><s:label path="userid">User ID</s:label></td>
				<td><s:input path="userid" /></td><td><s:errors path="userid"/></td>
			</tr>
			<tr>
				<td><s:label path="name">User Name</s:label></td>
				<td><s:input path="name" /></td>
			</tr>

			<tr>
				<td><s:label path="email">Email ID</s:label></td>
				<td><s:input path="email" /></td>
			</tr>

			<tr>
				<td><s:label path="address">Address</s:label></td>
				<td><s:input path="address" /></td>
			</tr>
			<tr>
				<td><s:button>SingnUp</s:button></td>
			</tr>
		</table>
	</s:form>

	<h3>${msg}</h3>
</body>
</html>