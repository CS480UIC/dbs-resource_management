<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    
    <title>Create Resource</title>
    
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
  <h1>Create Resource </h1>
<form action="<c:url value='/ResourceServletCreate'/>" method="post">
	ID:<input type="text" name="id" value="${form.id }"/>
	<span style="color: red; font-weight: 900">${errors.id }</span>
	<br/>
	School code:<input type="text" name="code" value="${form.code }"/>
	<span style="color: red; font-weight: 900">${errors.code }</span>
	<br/>
	Resource Name：<input type="text" name="resource_name" value="${form.resource_name }"/>
	<span style="color: red; font-weight: 900">${errors.resource_name }</span>
	<br/>
	Resource Location：<input type="text" name="resource_location" value="${form.resource_location }"/>
	<span style="color: red; font-weight: 900">${errors.resource_location }</span>
	<br/>
	Full Capacity：<input type="text" name="full_capacity" value="${form.full_capacity }"/>
	<span style="color: red; font-weight: 900">${errors.full_capacity }</span>
	<br/>
	Available Capacity：<input type="text" name="available_capacity" value="${form.available_capcity }"/>
	<span style="color: red; font-weight: 900">${errors.available_capacity }</span>
	<br/>
	<input type="submit" value="Create Resource"/>
</form>
  </body>
</html>
