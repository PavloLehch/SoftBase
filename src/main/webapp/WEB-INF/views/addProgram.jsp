<?xml version="1.0" encoding="UTF-8" ?>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" isELIgnored="false" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Soft Base - add new Program</title>
	<style><%@include file="/css/style.css"%></style>
	<script src="https://cdn.ckeditor.com/4.9.2/standard/ckeditor.js"></script>
	<!--<script src="//cdn.ckeditor.com/4.9.2/full/ckeditor.js"></script> -->
	<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
	<script type="text/javascript"><%@include file="/script/counter.js"%></script>
</head>
<body>
	<h3>Add new Program</h3>
	<form:form method="post" modelAttribute="program">
		<div>
			Name:<br />
				<form:input path="name"  size="30" />
				<form:errors path="name" />
		</div>
		<br />
		<div>
			Version:<br />
				<form:input path="version"  size="30"/>
				<form:errors path="version" />
		</div>
		<br />
		<div>
			Web-Site:<br />
				<form:input path="site"  size="30"/>
				<form:errors path="site" />
		</div>
		<br />
		<div>
			Link:<br />
			<form:input path="link"  size="30"/>
			<form:errors path="link" />
		</div>
		<!--<div>
			 Data update:
				<form:input type = "date" path="dataUpdate" />
				<form:errors path="dataUpdate" />
		</div> -->
		<div class="document7">
			Operation Systems:
				<form:select path = "opSystems" items = "${opSystems}" multiple="true" size="6" itemValue="id" itemLabel="systemName"/>
				<form:errors path="opSystems" />
			<br /><br />
			Developer:
				<form:select path = "developer" items = "${developers}" itemValue="id" itemLabel="devName"/>
				<form:errors path="developer" />
			<br />	<br />				
			Category:
				<form:select path="category" items="${categories}" itemValue="id" itemLabel="categoryName"/>
				<form:errors path="category" />
			<br /><br />
			Data add:
				<form:input type = "date" path="dataCreate" />
				<form:errors path="dataCreate" />
		</div>
		<!-- <div>
			What's in latest version :
				<form:textarea path="newInform" cols="70" rows="9"/>
				<form:errors path="newInform" />
		</div> -->
		<div class="document6">
			Short Description <span class="smallLetter">(number of signs
								<span class="counter1">0</span><span>/255)</span>
							</span>:<br />
				<form:textarea path="shortDescription" cols="80" rows="6" class="textAreaShot"/>
				<form:errors path="shortDescription" />
			<br /><br />
			All Description:
				<form:textarea path="allDescription" />
				<script>CKEDITOR.replace("allDescription", {width:['650px'],height:['250px']});</script>
				<form:errors path="allDescription" />
				<br />
			<input class="design yellow" type="submit" value="Add">
		</form:form>
		<br /><br />
		<a class="design yellow" href="<c:url value='/admin/program/listPrograms' />">Back To Programs List</a>
	</div>
</body>
</html>