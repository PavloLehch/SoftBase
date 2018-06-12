<?xml version="1.0" encoding="UTF-8" ?>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" isELIgnored="false" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Soft Base - add new System</title>
	<style><%@include file="/css/style.css"%></style>
</head>
<body>
	<h3>Add new Operation System</h3>
	<form:form method="post" modelAttribute="opSystem">
		<div>
			Name:<br />
				<form:input path="systemName" size="30"/>
				<form:errors path="systemName" />
		</div>
		<br />
		<div><input class="design yellow" type="submit" value="Add"></div>
	</form:form>
	<br />
	<a class="design yellow" href="<c:url value='/admin/system/listSystems' />">Back To Systems List</a>
</body>
</html>