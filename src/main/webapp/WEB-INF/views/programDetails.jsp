<?xml version="1.0" encoding="UTF-8" ?>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" isELIgnored="false" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Soft Base - edit Program</title>
	<style><%@include file="/css/style.css"%></style>
</head>
<body>
	<table class="middleLetter">
		<tr>
			<td>
				<i><b>Category:</b></i> ${program.category}&nbsp;|&nbsp;
			</td>
			<td>
				<i><b>Developer:</b></i> ${program.developer}&nbsp;|&nbsp;
			</td>
			<td>
				<i><b>Create date:</b><i></i> ${program.dataCreate}&nbsp;|&nbsp;
			</td>
			<td>
				<i><b>Last update:</b><i></i> ${program.dataUpdate}
			</td>
		</tr>
	</table>
	<table class="middleLetter">
		<tr>
			<td>
				<i><b>Web Site:</b></i> <a href="${program.site}" target="_blank">${program.site}</a>&nbsp;|&nbsp;
			</td>
			<td>
				<i><b>Link to download:</b></i> <a href="${program.link}" target="_blank">${program.link}</a>
			</td>
		</tr>
	</table>
	<table class="middleLetter">
		<tr>
			<td>
				<i><b>Operation systems:</b></i> ${program.opSystems}
			</td>
		</tr>
	</table>
	
	<div class="document8">
		<h2>${program.name} ${program.version}</h2>
		<b><i>Short Description:</i></b><br /><br /> ${program.shortDescription}<hr>
		<b><i>All Description:</i></b> ${program.allDescription}<hr>
		<b><i>What's new in latest version:</i></b><br /><br /> ${program.newInform}<hr>
	</div>

	<a class="design yellow" href="<c:url value='/admin/program/editprog/${program.id}' />">Edit</a>&nbsp;
	<a class="design yellow" href="<c:url value='/admin/program/listPrograms' />">Back</a>&nbsp;
	<a class="design yellow" href="<c:url value='/admin/program/deleteprog/${program.id}' />" onclick="return confirm('Are you sure?')">Delete</a><br />
</body>
</html>