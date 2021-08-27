<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
	<%@ page import="java.util.*" import="basic.crud.app.enitity.Employee" %>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>  
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset="UTF-8">
<style>
form{
	border:2px solid black;
	margin:0px 20%;
	padding:10px
}
body{
	background-color:skyblue;
	font-size:20px;
	overflow:auto;
}
div{
	margin:auto;
	padding:20px;
	margin:10px 20%;
}
a{
	text-decoration:none;
	border:1px solid blue;
	border-radius:2px;
	margin:10px;
	padding:3px;
	font-size:15px;
}
</style>
<title>Update</title>
</head>
<body>
	<div>
	<a href="/EmployeeBook">Home</a>
	<a href="/EmployeeBook/employeeList">List of Employee</a>
	<c:forEach items="${empList}" var="employee">
		<c:set var="id" scope="session" value="${employee.eid}"/>
		<form action="/EmployeeBook/update/${id}" method="post" align="center">
			<fieldset>
				<legend>Employee-Details</legend>
				Name:
				<input type="text" name="ename" value="${employee.ename}"/><br>
				Salary:
				<input type="text" name="salary" value="${employee.salary}"/><br>
				Position:
				<input type="text" name="position" value="${employee.position}"/><br>
				Contact:
				<input type="text" name="contact" value="${employee.contact}"/><br>
				<input type="submit" style="width:70px"/><br>
			</fieldset>
		</form>
	</c:forEach>
	</div>
</body>
</html>