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
	<script type="text/javascript"><%@include file="/script/notVisibleImage.js"%></script>
</head>
<body>

<%@ include file="/WEB-INF/jspf/header.jsp" %> <br />

<ul class="document">
<h4>Last 10 added programs:</h4>
	<c:forEach items="${programsNew}" var="program">
		<li>
			<a href="<c:url value='/common/findprog/${program.id}' />"><b>${program.name} ${program.version}</b></a> <br />
			<span class="middleLetter"><i>${program.shortDescription}</i></span><br />
			<span class="smallLetter">category: ${program.category}<br />
			added: ${program.dataCreate}</span>
			<hr>
		</li>
	</c:forEach>
</ul>

<br />

<ul class="document2">
<h4>Last 10 updated programs:</h4>
	<c:forEach items="${programsUpdate}" var="program">
	<li>
			<a href="<c:url value='/common/findprog/${program.id}' />"><b>${program.name} ${program.version}</b></a> <br />
			<span class="middleLetter"><i>${program.shortDescription}</i></span><br />
			<span class="smallLetter">category: ${program.category}<br />
			updated: ${program.dataUpdate}</span>
			<hr>
	</li>
	</c:forEach>
</ul>

</body>
</html>