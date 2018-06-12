<?xml version="1.0" encoding="UTF-8" ?>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" isELIgnored="false" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Soft Base - News list</title>
</head>
<body>

<%@ include file="/WEB-INF/jspf/headerAdmin.jsp" %> <br />
	
	<h2>News list <span class="middleLetter">${newsRecordLength}</span></h2>
	
	Search by:<br/>
	<form method="post">
		<input type="radio" name="search" value="title" checked/>Title
		<input type="radio" name="search" value="category"/>Category
		<input type="text" name="titleCat" />
		<input type="submit" value="Search" /> 
	</form>
	<br /> 
	<a class="design yellow" href="<c:url value='/admin/news/addnews' />">ADD NEWS</a>
	<br />
	<br />
	<table class="progDetailAdmin">
		<tr>
			<th>id</th>
			<th>Title</th>
			<th>Short Description</th>
			<th>Created</th>
			<th>Category</th>
			<th>Source</th>
			</tr>
		<c:forEach items="${newses}" var="news">
		<tr>
			<td width="50">${news.id}<a href="<c:url value='/common/news/${news.id}' />" target="_blank"><img width="24" src="<c:url value = "/images/world.png"/>"></a></td>
			<td><a href="<c:url value='/admin/news/findnews/${news.id}' />"> ${news.newsTitle}</a></td>
			<td style="text-align:left;">${news.newsShortDescription}</td>
			<td>${news.newsDataCreate }</td>
			<td>${news.category}</td>
			<td>${news.newsSource}</td>
		</tr>
		</c:forEach>
	</table>
</body>
</html>


      							