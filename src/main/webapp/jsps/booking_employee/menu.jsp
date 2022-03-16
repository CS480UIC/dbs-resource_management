<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="">
    
    <title>body</title>
    
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
    <h1>CRUD operations for Booking Employee </h1>
    <br>
	<a href="<c:url value='/jsps/booking_employee/booking_employeecreate.jsp'/>" target="_parent">Create Booking Employee</a> |&nbsp; 
	<a href="<c:url value='/jsps/booking_employee/booking_employeeread.jsp'/>" target="_parent">Read Booking Employee</a> |&nbsp;
	<a href="<c:url value='/jsps/booking_employee/booking_employeeupdate.jsp'/>" target="_parent">Update Booking Employee</a> |&nbsp;	 
	<a href="<c:url value='/jsps/booking_employee/booking_employeedelete.jsp'/>" target="_parent">Delete Booking Employee</a>	
	    
  </body>
</html>
