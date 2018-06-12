<?xml version="1.0" encoding="UTF-8" ?>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" isELIgnored="false" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Soft Base - add news</title>
	<style><%@include file="/css/style.css"%></style>
	<script src="https://cdn.ckeditor.com/4.9.2/standard/ckeditor.js"></script> 
	<!--<script src="//cdn.ckeditor.com/4.9.2/full/ckeditor.js"></script> -->
	<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
	<script type="text/javascript"><%@include file="/script/counter.js"%></script>
	
</head>
<body>
	<h3>Add news</h3>
	<form:form method="post" modelAttribute="news">
		<div>
			Title <span class="smallLetter">(number of signs
								<span class="counter2">0</span><span>/255)</span>
							</span>:<br />
				<form:textarea path="newsTitle" cols="45" rows="4" class="textTitle"/>
				<form:errors path="newsTitle" />
		</div>
		<br />
		<div>
			Source:<br />
				<form:input type="url" path = "newsSource" size="30"/>
				<form:errors path="newsSource" />
		</div>
		<br />
		<div>
			Date add:<br />
				<form:input type = "date" path="newsDataCreate"/>
				<form:errors path="newsDataCreate" />
		</div>
		<br />
		<div>
			Category:<br />
				<form:select path="category" items="${categories}" itemValue="id" itemLabel="categoryName"/>
				<form:errors path="category" />
		</div> 
		
		<div class="document6">
			Short Description <span class="smallLetter">(number of signs
								<span class="counter1">0</span><span>/255)</span>
							</span>:<br />
				<form:textarea path="newsShortDescription" cols="90" rows="7" class="textAreaShot"/>
				<form:errors path="newsShortDescription" />
				
		<br />
		<br />
		All Description:<br />
				<form:textarea path="newsAllDescription"/>
				<script>CKEDITOR.replace("newsAllDescription", {width:['800px'],height:['250px']});</script>
				<form:errors path="newsAllDescription" />
		<br />
			<input class="design yellow" type="submit" value="Add">		
	</form:form>
	<br />
	<br />
	<a class="design yellow" href="<c:url value='/admin/news/listNewses' />">Back To News List</a><br />
	</div>
	
</body>
</html>