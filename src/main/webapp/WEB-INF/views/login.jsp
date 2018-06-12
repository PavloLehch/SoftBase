<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	ADMIN MODE:
	<br />
	<br />
	<form action="j_security_check" method="post">
    Input username:<br>
    <input name="j_username" type="text"><br>
    Input password:<br>
    <input name="j_password" type="password"><br>
    <input type="submit" value="Login"><br />
    <input type="button" value="Back" onClick='location.href="<c:url value='/common/start' />"'><br />
</form>
</body>
</html>