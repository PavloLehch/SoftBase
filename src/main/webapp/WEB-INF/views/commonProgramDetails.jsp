<?xml version="1.0" encoding="UTF-8" ?>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" isELIgnored="false" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Soft Base - details of Program</title>

</head>
<body>

<%@ include file="/WEB-INF/jspf/header.jsp" %> <br />

	<div  class="document5">
	<h2>${program.name} ${program.version}</h2>
	
	<table class="progDetail middleLetter">
		<tr>
			<th>category</th>
			<th>added in catalog</th>
			<th>last updated</th>
			<th>developer</th>
			<th>web site</th>
			<th>link to download</th>
		</tr>
		<tr>
			<td>${program.category}</td>
			<td>${program.dataCreate}</td>
			<td>${program.dataUpdate}</td>
			<td>${program.developer}</td>
			<td><a href="${program.site}" target="_blank">web site</a></td>
			<td><a href="${program.link}" target="_blank">download</a></td>
		</tr>
	</table>
		
	<p>
		${program.allDescription}
	</p>
		
	<p class="middleLetter"><i>Operation systems:</i> ${program.opSystems}</p>
	
	<div class="middleLetter" style="background-color:lightblue;">
		<b><i>What's new in latest version:</i></b>
		<ul>${program.newInform}</ul>
	</div>
	
	</div>
	<!-- <a href="<c:url value='/common/start' />">Back</a><br /> -->
	</body>
</html>