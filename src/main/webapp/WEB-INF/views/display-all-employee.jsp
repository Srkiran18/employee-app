<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<jsp:include page="index.jsp"></jsp:include>
<hr>
<c:choose>
<c:when test="${msg.getClass().getSimpleName().equals(\"String\")} }">
<h2> ${ msg  }</h2>
</c:when>
<c:otherwise>
<table border="2" align="center">
	
<tr>
<th>Employee ID</th>
<th>Employee Name</th>
<th>Email-ID</th>
<th>Date of Birth</th>
<th>Age</th>
<th>Salary</th>
<th>Status</th>
<th colspan="2">Actions</th>
</tr>
<c:forEach var=allEmployee  items="${ msg }">
<tr>
<td>${ allEmployee.id }</td>
<td>${ allEmployee.name } </td>
<td>${ allEmployee.email }</td>
<td>${ allEmployee.DOB }</td>
<td>${ allEmployee.age }</td>
<td>${ allEmployee.salary }</td>
<td>${ allEmployee.employeeStatus }</td>
<td><a href='./edit/${ allEmployee.id }'>EDIT</a></td>
<td><a href='./delete/${ allEmployee.id }'>DELETE</a></td>
</tr>

</c:forEach>
</table>
</c:otherwise>
</c:choose>
</body>
</html>