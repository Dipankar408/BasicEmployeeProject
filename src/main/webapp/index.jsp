<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
	<%@ page import="java.util.*" import="basic.crud.app.enitity.Employee" %>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>  
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset="UTF-8">
<link rel="stylesheet" href="style.css">
<title>HomePage</title>
</head>
<body>
<div>
	<a href="/EmployeeBook">Home</a>
	<a href="/EmployeeBook/employeeList">List of Employee</a><br><br>
	<form action="/EmployeeBook/createEmp" method="post" align="center">
		<fieldset>
			<legend>Employee-Details</legend>
				Name:
				<input type="text" name="ename"/><br>
				Salary:
				<input type="text" name="salary"/><br>
				Position:
				<input type="text" name="position"/><br>
				Contact:
				<input type="text" name="contact"/><br>
				City:
				<input type="text" name="city"/><br>
				District:
				<input type="text" name="district"/><br>
				State:
				<input type="text" name="state"/><br>
				Pincode:
				<input type="text" name="pin"/><br>
				<input type="submit" style="width:70px"/><br>
		</fieldset>
	</form>
</div>
</body>
</html>