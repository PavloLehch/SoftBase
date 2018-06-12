<?xml version="1.0" encoding="UTF-8" ?>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" isELIgnored="false" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Soft Base - Programs list</title>
	<style><%@include file="/css/style.css"%></style>
</head>
<body>

<%@ include file="/WEB-INF/jspf/headerAdmin.jsp" %> <br />
	
	
	<h2>Programs list <span class="middleLetter">${programsRecordLength}</span></h2>
			
	Search by:<br/>
	<form method="post">
		<input type="radio" name="search" value="name" checked/>Name
		<input type="radio" name="search" value="category"/>Category
		<input type="radio" name="search" value="developer"/>Developer
		<input type="text" name="nameCatDev" />
		<input type="submit" value="Search" /> 
	</form>
	<br /> 
	<a class="design yellow" href="<c:url value='/admin/program/addprog' />">ADD NEW PROGRAM</a>
	<br /><br />
	<table class="progDetailAdmin">
		<tr>
			<th>id</th>
			<th>Name</th>
			<th>Version</th>
			<th>Category</th>
			<th>Date add</th>
			<th>Date update</th>
			<th>System</th>
			<th>Developer</th>
		</tr>
		<c:forEach items="${programs}" var="program">
		<tr>
			<td width="50">${program.id}<a href="<c:url value='/common/findprog/${program.id}' />" target="_blank"><img width="24" src="<c:url value = "/images/world.png"/>"></a></td>
			<td><a href="<c:url value='/admin/program/findprog/${program.id}' />">${program.name}</a></td>
			<td>${program.version}</td>
			<td>${program.category}</td>
			<td>${program.dataCreate}</td>
			<td>${program.dataUpdate}</td>
			<td>${program.opSystems}</td>
			<td>${program.developer}</td>
	   </tr>
		</c:forEach>
	</table>
</body>
</html>


      							