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
		<h2>Programs list (category: <i>${category}</i>)</h2>
		<c:forEach items="${programs}" var="program">
			<a href="<c:url value='/common/findprog/${program.id}' />"><b>${program.name} ${program.version}</b></a> <br />
			<span class="middleLetter"><i>${program.shortDescription}</i></span><br />
			<span style="font-size:12px;">added: ${program.dataCreate}<br />
			updated: ${program.dataUpdate}</span>
			<hr>
		</c:forEach>
	</ul>
</body>
</html>