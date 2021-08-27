<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
	<%@ page import="java.util.*" import="basic.crud.app.enitity.Employee" %>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>  
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="style.css">
<title>List of Employees</title>
<style type="text/css">
h2,h4{
	text-align:center;
	text-decoration:underline;
}
</style>
</head>
<body>
<div class="btn">
<a href="/EmployeeBook">Home</a>
<a href="/EmployeeBook/employeeList">List of Employee</a><br>
		<h3>Find Employee</h3>
		Order By Salary:-  
		<a href="/EmployeeBook/sortFromHigh">High To Low</a>
		<a href="/EmployeeBook/sortFromLow">Low To High</a><br>

		<form action="/EmployeeBook/search" method="post" class="search">
			Enter Value:<input type="text" name="val"><br>
			<input type="radio" name="search_category" value="searchById" required class="input">
			<label for="searchById">Search By ID</label><br>
			<input type="radio" name="search_category" value="searchByName" class="input">
			<label for="searchByName">Search By Name</label><br>
			<input type="radio" name="search_category" value="searchByPosition" class="input">
			<label for="searchByPosition">Search By Position</label><br>
			<input type="submit" value="Search">
		</form>
	</div>
	<h3>Employee List</h3>
	<h4>${message}</h4>
<table border="1" align="center">
	<tr>
		<th>Employee ID</th>
		<th>Employee Name</th>
		<th>Salary</th>
		<th>Job Role</th>
		<th>Contact No</th>
		<th>City</th>
		<th>District</th>
		<th>State</th>
		<th>Pincode</th>
	</tr>
 <c:forEach items="${empList}" var="employee">
		<tr>
			<td>${employee.eid}</td>
			<td>${employee.ename}</td>
			<td>${employee.salary}</td>
			<td>${employee.position}</td>
			<td>${employee.contact}</td>
			<td>${employee.getAdr().city}</td>
			<td>${employee.getAdr().district}</td>
			<td>${employee.getAdr().state}</td>
			<td>${employee.getAdr().pincode}</td>
			<td colspan="2">
			<a href="/EmployeeBook/edit/${employee.eid}">Edit</a> 
			<a href="/EmployeeBook/delete/${employee.eid}">Delete</a>
			</td>
		</tr>
	</c:forEach> 	
</table> 
</body>
</html>