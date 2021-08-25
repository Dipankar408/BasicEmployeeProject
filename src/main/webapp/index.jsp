<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
	<%@ page import="java.util.*" import="basic.crud.app.enitity.Employee" %>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>  
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset="UTF-8">
<title>HomePage</title>
</head>
<body>

<form action="/EmployeeBook/createEmp" method="post">
Name:<br>
<input type="text" name="ename"/><br>
Salary:<br>
<input type="text" name="salary"/><br>
Position:<br>
<input type="text" name="position"/><br>
COntact:<br>
<input type="text" name="contact"/><br>
<input type="submit"/><br>
</form>


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
		</tr>
	</c:forEach> 	
</table>
</body>
</html>