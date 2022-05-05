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
    <h1>List of queries</h1>
    <br>
    <a href="<c:url value='/findAll'/>" target="body">Please list all the user in the table</a>&nbsp;&nbsp;
 	<br>
 	<h2>Simple queries</h2>
    <a href="<c:url value='/AvailableResource'/>" target="body">Please list all the available resource</a>&nbsp;&nbsp;
 	<br>
    <a href="<c:url value='/findUserBooking'/>" target="body">Please list all the booking for a user</a>&nbsp;&nbsp;
    <br>
    <h2>Complex queries</h2>
    <a href="<c:url value='/findBookedResources'/>" target="body">Please list all the employee name for the resources</a>&nbsp;&nbsp;
    <br>
    <a href="<c:url value='/findSchoolName'/>" target="body">Please list all the school name</a>&nbsp;&nbsp;
    <br>
    <h2>Aggregrate queries</h2>
    <a href="<c:url value='/findCount'/>" target="body">Please list the count of schools</a>&nbsp;&nbsp;
  	<br>
    <a href="<c:url value='/findMax'/>" target="body">Please list the resource boooked for maximum hours</a>&nbsp;&nbsp;
 
    
  </body>
</html>
