<?xml version="1.0" encoding="UTF-8" ?>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" isELIgnored="false" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Soft Base - news details</title>
	<style><%@include file="/css/style.css"%></style>
</head>
<body>

	<span class="middleLetter">
			category: ${news.category}<br/>
			date: ${news.newsDataCreate}<br/>
			source: <a href="<c:url value='${news.newsSource}' />" target="_blank">${news.newsSource}</a>
	</span>
	<br />
	<div class="document8">
		<h2>${news.newsTitle}</h2>
		<p><i><b>${news.newsShortDescription}</b></i></p>
		<p>${news.newsAllDescription}</p>
	</div>

	<br />
	<a class="design yellow" href="<c:url value='/admin/news/editnews/${news.id}' />">Edit</a>&nbsp; 
	<a class="design yellow" href="<c:url value='/admin/news/listNewses' />">Back</a>&nbsp; 
	<a class="design yellow" href="<c:url value='/admin/news/deletenews/${news.id}' />" onclick="return confirm('Are you sure?')">Delete</a>
</body>
</html>