<?xml version="1.0" encoding="UTF-8" ?>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" isELIgnored="false" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<style><%@include file="/css/style.css"%></style>
	<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
	<script type="text/javascript"><%@include file="/script/activeAdmin.js"%></script>
</head>
<body>

	<h1>ADMIN MODE</h1>
	<div class="activelink">
		<a class="design" href="<c:url value='/'/>">START PAGE</a>
		<a class="design" href="<c:url value='/admin/program/listPrograms' />">PROGRAMS</a>
		<a class="design" href="<c:url value='/admin/news/listNewses' />">NEWS</a>
		<a class="design" href="<c:url value='/admin/system/listSystems' />">OPERATION SYSTEMS</a>
		<a class="design" href="<c:url value='/admin/category/listCategories' />">CATEGORIES</a>
		<a class="design" href="<c:url value='/admin/developer/listDevelopers' />">DEVELOPERS</a>
		<a class="design" href="<c:url value='/admin/logout' />">LOG OUT</a>
	</div>
</body>
</html>
