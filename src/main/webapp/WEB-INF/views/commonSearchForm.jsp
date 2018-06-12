<?xml version="1.0" encoding="UTF-8" ?>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" isELIgnored="false" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<script type="text/javascript"><%@include file="/script/calendar.js"%></script>
</head>
<body>

<%@ include file="/WEB-INF/jspf/header.jsp" %> <br />

<form method="post" class="document3">
	<h3>Search:</h3>
	<i>Programs by:</i><br/>
		<input type="radio" name="search" value="name"/>Name
		<input type="radio" name="search" value="category"/>Category
		<input type="radio" name="search" value="developer"/>Developer
		
		<br />
	<i>News by:</i><br/>
		<input type="radio" name="search" value="title"/>Title
		<input type="radio" name="search" value="categoryNews"/>Category
		<input type="radio" name="search" value="date"/>Add date
		
		<input type="text" name="find" id="find"/>
		<input type="submit" value="Search" /> 
	</form>
	<br /> 
	<br />

<div class="document4">
	<h2>${programsList}${search}<i>${find}</i></h2>
		<c:forEach items="${programs}" var="program">
			<a href="<c:url value='/common/findprog/${program.id}' />"><b>${program.name} ${program.version}</b></a> <br />
			<span class="middleLetter"><i>${program.shortDescription}</i></span><br />
			<span class="smallLetter"">
			added: ${program.dataCreate}<br />
			updated: ${program.dataUpdate}<br />
			category: ${program.category}<br />
			developer: ${program.developer}
			</span>
			<hr>
		</c:forEach>

	<h2>${newsesList}${searchNews}<i>${findNews}</i></h2>
		<c:forEach items="${newses}" var="news">
			<a href="<c:url value='/common/news/${news.id}' />"><b>${news.newsTitle}</b></a> <br />
			<span class="middleLetter"><i>${news.newsShortDescription}</i></span><br />
			<span class="smallLetter">
			added: ${news.newsDataCreate}<br />
			category: ${news.category}<br />
			</span>
			<hr>
		</c:forEach>
</div>

</body>
</html>