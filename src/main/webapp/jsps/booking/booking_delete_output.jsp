<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    
    <title>Delete Booking</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<meta http-equiv="content-type" content="text/html;charset=utf-8">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

  </head>
  
  <body>
  <h1>Delete Booking</h1>
<p style="color: red; font-weight: 900">${msg }</p>
<form action="<c:url value='/BookingServletDelete'/>" method="post">
	<input type="hidden" name="method" value="delete"/>
		<input type="hidden" name="booking_id" value="${booking.booking_id }"/>
	Booking ID:<input type="text" name="booking_id" value="${booking.booking_id }" disabled/>
	<br/>
	Employee User ID:<input type="text" name="employee_user_id" value="${booking.employee_user_id }" disabled/>
	<br/>
	Resource ID:<input type="text" name="resource_id" value="${booking.resource_id }" disabled/>
	<br/>
	Booked Capacity：<input type="text" name="booked_capacity" value="${booking.booked_capacity }" disabled/>
	<br/>
	Booking Slot：<input type="text" name="booking_slot" value="${booking.booking_slot }" disabled/>
	<br/>
	Number of hours：<input type="text" name="number_of_hours" value="${booking.number_of_hours }" disabled/>
	<br/>
	Notes：<input type="text" name="notes" value="${booking.notes }" disabled/>
	<br/>
	<input type="submit" value="Delete Booking"/>
</form>

</body>
</html>
