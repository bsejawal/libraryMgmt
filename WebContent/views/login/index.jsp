<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<form method="post" action="login/authencate">
	<fieldset>
		<legend><b>Login System</b></legend>
		<label for="username">Username: </label><input id="username" name="username"><br/>
		<label for="password">Password: </label><input id="password" name="password"><br/>
		<input type="submit" value="Login">
	</fieldset>
</form>


</body>
</html>