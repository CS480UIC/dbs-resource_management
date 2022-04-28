<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

</head>
<body>
	<h3 align="center"> Available Resource </h3>
	<table border="1" width="70%" align="center">
	<tr>
		<th>ID</th>
		<th>Resource name</th>
		<th>Available capacity</th>
	</tr>
<c:forEach items="${ResourceList}" var="resource">
	<tr>
		<td>${resource.id}</td>
		<td>${resource.resource_name}</td>
		<td>${resource.available_capacity}</td>
	</tr>
</c:forEach>
</table>
</body>
</html>
