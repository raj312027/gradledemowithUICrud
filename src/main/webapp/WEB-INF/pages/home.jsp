<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<%@ taglib uri="http://www.springframework.org/tags/form" prefix="s"%>
<%@ taglib uri="http://java.sun.com/jstl/core" prefix="j"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="sp"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>HomePage</title>
<link type="text/css" rel="stylesheet"
	href="${pageContext.request.contextPath}/css/homepage_css.css" />
<script src="https://ajax.aspnetcdn.com/ajax/jQuery/jquery-3.4.1.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/homepagescript.js" ></script>
</head>
<body>
	<div id="login-box">
		<div class="left">
			<h1>Sign Up</h1>
			<s:form action="/createUserInfo" modelAttribute="userinfo">
				<table>
					<tr>
						<%--  <td><sp:message code="User ID" var="placeholder"/></td> --%>
						<%-- <td><s:label path="userid">User ID</s:label></td> --%>
						<td><s:input path="userid" placeholder="User ID" /></td>
						<td><s:errors cssClass="err" path="userid" /></td>
					</tr>
					<tr>
						<%-- 						<td><s:label path="name">User Name</s:label></td> --%>
						<td><s:input path="name" placeholder="Name" /></td>
						<td><s:errors cssClass="err" path="name" /></td>
					</tr>

					<tr>
						<%-- 						<td><s:label path="email">Email ID</s:label></td> --%>
						<td><s:input path="email" placeholder="Email ID" /></td>
						<td><s:errors cssClass="err" path="email" /></td>
					</tr>

					<tr>
						<%-- 						<td><s:label path="address">Address</s:label></td> --%>
						<%-- 	<td><s:input path="address" placeholder="Address"/></td>
						<td><s:errors  cssClass="err" path="address" /></td> --%>

						<td><s:input path="houseNO" placeholder="House No" /></td>
						<td><s:errors cssClass="err" path="houseNO" /></td>
					</tr>
					<tr>
					 <td>
					   <s:password path="password" placeholder="Password" cssClass="pscls" />
					 </td>
					 <td><s:errors path="password" cssClass="err"/></td>
					</tr>
					<tr>
						<td><s:input path="street" placeholder="Street" /></td>
						<td><s:errors cssClass="err" path="street" /></td>

					</tr>
					<tr>
						<td><s:input path="area" placeholder="Area" /></td>
						<td><s:errors cssClass="err" path="area" /></td>
					</tr>


					<tr>
						<td><s:select path="country" class="sel" id="cntryList">
								<s:option value="Select Country" />
								<s:options items="${countryList}" />
							</s:select> <input type="hidden" name="selectedCountry" id="hideCntry" />
					</tr>
					<tr>
						<td><s:select path="state" class="sel" id="stateList">
								<s:option value="Select State" />
								<%-- <s:options items="${stateList}" /> --%>
							</s:select></td>
					</tr>

					<tr>
						<td><s:select path="city" class="sel" id="cityList">
								<s:option value="Select City" />
								<%-- 	<s:options items="${cityList}" /> --%>
							</s:select></td>
					</tr>
					<tr>
						<td><input type="submit" name="signup_submit"
							value="Sign me up" /></td>
					</tr>
				</table>
			</s:form>

			<h3>${msg}</h3>
		</div>
		<div class="right">
			<span class="loginwith">Sign in with<br />social network
			</span>

			<button class="social-signin facebook">Log in with facebook</button>
			<button class="social-signin twitter">Log in with Twitter</button>
			<button class="social-signin google">Log in with Google+</button>
		</div>
		<div class="or">OR</div>
	</div>

</body>
</html>