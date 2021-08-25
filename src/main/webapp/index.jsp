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
				<input type="submit" style="width:70px"/><br>
		</fieldset>
	</form>
	<div class="btn">
		<h3>Employee List</h3>
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

<table border="1" align="center">
	<tr>
		<th>Employee ID</th>
		<th>Employee Name</th>
		<th>Salary</th>
		<th>Job Role</th>
		<th>Contact No</th>
	</tr>
 <c:forEach items="${empList}" var="employee">
		<tr>
			<td>${employee.eid}</td>
			<td>${employee.ename}</td>
			<td>${employee.salary}</td>
			<td>${employee.position}</td>
			<td>${employee.contact}</td>
			<td colspan="2">
			<a href="/EmployeeBook/edit/${employee.eid}">Edit</a> 
			<a href="/EmployeeBook/delete/${employee.eid}">Delete</a>
			</td>
		</tr>
	</c:forEach> 	
</table>
</div>
</body>
</html>