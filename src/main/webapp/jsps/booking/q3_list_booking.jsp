<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

</head>
<body>
	<h3 align="center"> Max hours Booking </h3>
	<table border="1" width="70%" align="center">
	<tr>
		<th>resource_id</th>
		<th>number_of_hours</th>
	</tr>
<c:forEach items="${MaxBookingList}" var="booking">
	<tr>
		<td>${booking.resource_id}</td>
		<td>${booking.number_of_hours}</td>
	</tr>
</c:forEach>
</table>
</body>
</html>
