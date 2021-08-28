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
		<h3>Employee Details</h3>
		<h5 style="color:red;">${msg}</h5>
		<fieldset>
			<legend>Personal Information</legend>
				
				<input type="text" name="ename" placeholder="Enter Your Name" required/><br>
				
				<input type="text" name="salary" placeholder="Enter Your Salary" required/><br>
				
				<input type="text" name="position" placeholder="Enter Your Job Role" required/><br>
				
				<input type="text" name="contact" placeholder="Enter Your Contact Number" required/><br>

				<input type="text" name="pass" placeholder="Enter Your PassWord" required/><br>
				
		</fieldset>	
		<fieldset>
		<legend>Address</legend>
				<input type="text" name="city" placeholder="Enter Your City" required/><br>
				
				<input type="text" name="district" placeholder="Enter Your District" required/><br>
	
				<input type="text" name="state" placeholder="Enter Your State" required/><br>
			
				<input type="text" name="pin" placeholder="Enter Your Pincode" required/><br>
		</fieldset>
		<input type="submit" value="Register" style="width:70px"/><br>
	</form>
</div>
</body>
</html>