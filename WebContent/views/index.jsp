<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h1>Hello JSP</h1>
<c:out value="${book.id}" /><br />
<c:out value="${book.name}" /><br />
<c:out value="${book.address}" /><br />
<!--<c:forEach var="i" begin="0" end="100" step="3">
   ${100 - i} ...<br />
</c:forEach>-->
</body>
</html>