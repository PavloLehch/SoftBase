<?xml version="1.0" encoding="UTF-8" ?>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" isELIgnored="false" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Soft Base - details of News</title>

</head>
<body>

<%@ include file="/WEB-INF/jspf/header.jsp" %> <br />

	<div  class="document5">
		<h2>${news.newsTitle}</h2>
		<span class="smallLetter">
			category: ${news.category}<br/>
			date: ${news.newsDataCreate}<br/>
			source: <a href="<c:url value='${news.newsSource}' />" target="_blank">${news.newsSource}</a>
		</span>
		<p>${news.newsAllDescription}</p>
	</div>
	<!-- <a href="<c:url value='/common/news' />">Back</a><br /> -->
	</body>
</html>