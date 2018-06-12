<?xml version="1.0" encoding="UTF-8" ?>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" isELIgnored="false" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<title>SoftBase</title>
</head>
<body>

<%@ include file="/WEB-INF/jspf/header.jsp" %> <br />

<ul class="document3">
<h3>Last 10 news:</h3>
	<c:forEach items="${lastNewses}" var="news">
		<li>
			<a href="<c:url value='/common/news/${news.id}' />"><b>${news.newsTitle}</b></a> <br />
			<span class="middleLetter"><i>${news.newsShortDescription}</i></span><br />
			<span class="smallLetter">
				category: ${news.category}<br />
				added: ${news.newsDataCreate}
			</span>
			<hr>
		</li>
	</c:forEach>
</ul>

</body>
</html>