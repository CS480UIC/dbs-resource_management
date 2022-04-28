<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    
    <title>Update Booking Employee</title>
    
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
  <h1>Update Booking Employee</h1>
<p style="color: red; font-weight: 900">${msg }</p>
<form>
	User ID:<input type="text" name="user_id" value="${booking_employee.user_id }" disabled/>
	<br/>
	School Code：<input type="text" name="school_code" value="${booking_employee.school_code }" disabled/>
	<br/>
	Employee Name：<input type="text" name="employee_name" value="${booking_employee.employee_name }" disabled/>
	<br/>
	Password：<input type="text" name="password" value="${booking_employee.password }" disabled/>
	<br/>
</form>
<h1>Update the values below</h1>
<form action="<c:url value='/Booking_EmployeeServletUpdate'/>" method="post">
		<input type="hidden" name="method" value="update"/>
				<input type="hidden" name="user_id" value="${booking_employee.user_id }"/>
	Employee Name：<input type="text" name="employee_name" value="${form.employee_name }"/>
	<span style="color: red; font-weight: 900">${errors.employee_name }</span>
	<br/>
	Password：<input type="password" name="password" value="${form.password }"/>
	<span style="color: red; font-weight: 900">${errors.password }</span>
	<br/>
	<input type="submit" value="Update Booking Employee"/>
</form>

</body>
</html>
