<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    
    <title>Create Booking</title>
    
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
  <h1>Create Booking </h1>
<form action="<c:url value='/BookingServletCreate'/>" method="post">
	
	Booking ID:<input type="text" name="booking_id" value="${form.booking_id }"/>
	<span style="color: red; font-weight: 900">${errors.booking_id }</span>
	<br/>
	Employee User ID:<input type="text" name="employee_user_id" value="${form.employee_user_id }"/>
	<span style="color: red; font-weight: 900">${errors.employee_user_id }</span>
	<br/>
	Resource ID:<input type="text" name="resource_id" value="${form.resource_id }"/>
	<span style="color: red; font-weight: 900">${errors.resource_id }</span>
	<br/>
	Booked Capacity：<input type="text" name="booked_capacity" value="${form.booked_capacity }"/>
	<span style="color: red; font-weight: 900">${errors.booked_capacity }</span>
	<br/>
	Booking Slot：<input type="text" name="booking_slot" value="${form.booking_slot }"/>
	<span style="color: red; font-weight: 900">${errors.booking_slot }</span>
	<br/>
	Number of hours：<input type="text" name="number_of_hours" value="${form.number_of_hours }"/>
	<span style="color: red; font-weight: 900">${errors.number_of_hours }</span>
	<br/>
	Notes：<input type="text" name="notes" value="${form.notes }"/>
	<span style="color: red; font-weight: 900">${errors.notes }</span>
	<br/>
	<input type="submit" value="Create Booking"/>
</form>
  </body>
</html>
