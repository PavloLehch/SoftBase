<?xml version="1.0" encoding="UTF-8" ?>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" isELIgnored="false" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Soft Base - edit Category</title>
	<style><%@include file="/css/style.css"%></style>
</head>
<body>
	<h3>Edit Category id="${category.id}"</h3>
	<form:form method="post" modelAttribute="category">
		<div>
			Name:<br />
				<form:input path="categoryName" size="30"/>
				<form:errors path="categoryName" />
		</div>
		<br />
		<div><input class="design yellow"type="submit" value="Save"></div>
	</form:form>
	<br />
	<a class="design yellow" href="<c:url value='/admin/category/listCategories' />">Back To Categories List</a><br />
</body>
</html>