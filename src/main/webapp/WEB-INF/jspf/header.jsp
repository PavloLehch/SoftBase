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
	<script type="text/javascript"><%@include file="/script/active.js"%></script>
</head>
<body>

	<h1 class="header">Hello!!! This is SoftBase!</h1>
	<h4 class="header">Find and download the most popular programs</h4>

<div class="activelink">
	<a href="<c:url value='/common/start' />" class="programs">PROGRAMS</a>
	<a href="<c:url value='/common/news' />" class="news">NEWS</a>
	<a href="<c:url value='/common/search' />"class="search" >SEARCH</a>
	<a href="<c:url value='/common/contact' />"class="contact" >CONTACT</a>
<a href="<c:url value='/admin/login' />"class="admin" >ADMIN</a>

<!-- urls to style main page - look at active.js --> 
<a href="<c:url value='/common/listprogramscategory' />" class="categ" ></a>
<a href="<c:url value='/common/findprog' />" class="prog" ></a>
<a href="<c:url value='/common/news' />" class="new" ></a>

</div>

<ul><i>Categories:</i>
	<c:forEach items="${categories}" var="category">
		<li><a class="category" href="<c:url value='/common/listprogramscategory/${category.id}' />"><b>${category.categoryName}</b></a></li>
	</c:forEach>
</ul>
<img src="<c:url value = "/images/soft1.jpg"/>" class="decoration-1">
<img src="<c:url value = "/images/soft2.png"/>" class="decoration-2">
<img src="<c:url value = "/images/soft3.jpg"/>" class="decoration-3">
<img src="<c:url value = "/images/soft4.png"/>" class="decoration-4">
<img src="<c:url value = "/images/soft5.png"/>" class="decoration-5">
