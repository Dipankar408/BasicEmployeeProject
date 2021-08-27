<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
	<%@ page import="java.util.*" import="basic.crud.app.enitity.Employee" %>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>  
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset="UTF-8">
<style type="text/css">
form{
	border:2px solid black;
	margin:0px 20%;
	padding:10px
}
body{
	background-color:skyblue;
	font-size:20px;
	overflow:auto;
	text-align:center;
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
<title>Log In</title>
</head>
<body>
	<h3>Login</h3>
	<div>
		<a href="/EmployeeBook">Home</a>
		<a href="/EmployeeBook/employeeList">List of Employee</a><br><br>
		<form action="/EmployeeBook/authentication/${task}/${id}" method="post">
			<h4>${msg}</h4>
			Employee Id:<input type="text" name="id" value="${id}"/><br>
			Password:<input type="text" name="pass" /><br>
			<input type="submit" value="Login"/>
		</form>
	</div>
</body>
</html>