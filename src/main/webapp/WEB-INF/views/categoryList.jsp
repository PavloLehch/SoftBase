<?xml version="1.0" encoding="UTF-8" ?>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" isELIgnored="false" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Soft Base - Categories list</title>
	<style><%@include file="/css/style.css"%></style>
	<script type="text/javascript"><%@include file="/script/alert.js"%></script>
</head>
<body>

<%@ include file="/WEB-INF/jspf/headerAdmin.jsp" %> <br />
	
	<h2 class="${alert}">Categories list</h2>
				
	Search by Name:<br/>
	<form method="post">
		<input type="text" name="categ" />
		<input type="submit" value="Search" /> 
	</form>
	<br/>
	<a class="design yellow" href="<c:url value='/admin/category/addcategory' />">ADD NEW CATEGORY</a>
	<br />
	<br />
	<table class="progDetailAdmin">
		<tr>
			<th>id</th>
			<th>Name</th>
			<th>Action</th>
			</tr>
		<c:forEach items="${categories}" var="category">
		<tr>
			<td>${category.id}</td>
			<td><a href="<c:url value='/admin/program/listProgramsCategory/${category.id}' />">${category.categoryName}</a></td>
			<td><a href="<c:url value='/admin/category/editcategory/${category.id}' />">Edit</a>  <a href="<c:url value='/admin/category/deletecategory/${category.id}' />" onclick="return confirm('Are you sure?')">Delete</a><br /></td>
		</tr>
		</c:forEach>
	</table>
</body>
</html>


      							