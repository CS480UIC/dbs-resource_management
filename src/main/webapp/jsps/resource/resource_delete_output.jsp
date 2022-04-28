<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    
    <title>Delete Resource</title>
    
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
  <h1>Delete Resource</h1>
<p style="color: red; font-weight: 900">${msg }</p>
<form action="<c:url value='/ResourceServletDelete'/>" method="post">
	<input type="hidden" name="method" value="delete"/>
		<input type="hidden" name="id" value="${resource.id }"/>
		
	ID    :<input type="text" name="id" value="${resource.id }" disabled/>
	<br/>
	School code：<input type="text" name="school_code" value="${resource.school_code }" disabled/>
	<br/>
	Resource Name	：<input type="text" name="resource_name" value="${resource.resource_name }" disabled/>
	<br/>
	Resource Location    :<input type="text" name="resource_location" value="${resource.resource_location }" disabled/>
	<br/>
	Full Capacity：<input type="text" name="full_capacity" value="${resource.full_capacity }" disabled/>
	<br/>
	Available Capacity	：<input type="text" name="available_capacity" value="${resource.available_capacity }" disabled/>
	<br/>
	
	<input type="submit" value="Delete Resource"/>
</form>

</body>
</html>
