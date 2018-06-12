<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<!DOCTYPE html>
<html>
<head>
    <title></title>
</head>
<body>
    <h1>Access Denied!</h1>
	<input type="button" value="Back" onClick='location.href="<c:url value='/common/start' />"'><br />
   
</body>
</html>