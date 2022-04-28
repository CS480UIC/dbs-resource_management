<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    
    <title>Create School</title>
    
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
  <h1>Create School</h1>
<form action="<c:url value='/SchoolServletCreate'/>" method="post">
	School Code: <input type="text" name="code" value="${form.code }"/>
	<span style="color: red; font-weight: 900">${errors.code }</span>
	<br/>
	Name：<input type="text" name="name" value="${form.name }"/>
	<span style="color: red; font-weight: 900">${errors.name }</span>
	<br/>
	Address：<input type="text" name="address" value="${form.address }"/>
	<span style="color: red; font-weight: 900">${errors.address }</span>
	<br/>
	Head：<input type="text" name="head" value="${form.head }"/>
	<span style="color: red; font-weight: 900">${errors.head }</span>
	<br/>
	LoginID：<input type="text" name="login_id" value="${form.login_id }"/>
	<span style="color: red; font-weight: 900">${errors.login_id }</span>
	<br/>
	Password：<input type="password" name="password" value="${form.password }"/>
	<span style="color: red; font-weight: 900">${errors.password }</span>
	<br/>
	<input type="submit" value="Create School"/>
</form>
  </body>
</html>
