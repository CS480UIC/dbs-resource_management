<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    
    <title>Read School Output</title>
    
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
  <h1>Read School Output</h1>
<p style="color: red; font-weight: 900">${msg }</p>
<form>
	Code    :<input type="text" name="code" value="${school.code }" disabled/>
	<br/>
	Name：<input type="text" name="name" value="${school.name }" disabled/>
	<br/>
	Address	：<input type="text" name="address" value="${school.address }" disabled/>
	<br/>
	Head    :<input type="text" name="head" value="${school.head }" disabled/>
	<br/>
	LoginID ：<input type="text" name="login_id" value="${school.login_id }" disabled/>
	<br/>
	Password	：<input type="text" name="password" value="${school.password }" disabled/>
	<br/>
</form>

<button onclick="window.location.href='<c:url value='/jsps/main.jsp'/>'">Continue</button>
</body>
</html>
