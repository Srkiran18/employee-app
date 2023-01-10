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
	<c:choose>
	<c:when test="${msg.getClass().getSimpleName().equals(\"String\")}">
	<h2>${ msg } }</h2>
	</c:when>
	<c:when test="${msg.getClass().getSimpleName().equals(\"EmployeeDto\")}">
	<div class="container">
	<form action="../../employee-app/update-employee" method="post">
	
<label>Employee Name</label>
<input type="text" name="name" value="$(employee.id)" readonly="readonly">
<br> <br>

<label>Employee Email</label>
<input type="email" name="email" value="${ employee.name }">
<br> <br>

<label>Employee DOB</label>
<input type="date" name="DOB"  value="${ employee.DOB }">
<br> <br>

<label>Employee Salary</label>
<input type="number" name="salary"  value="${ employee.salary }">
<br> <br>

<label>Employee Status</label>
<c:choose>
<c:when test="${employee.status.equals(\"Active\")}">
<label for="active">Active</label>
<input type="radio" id="active" name="status" value="Active" checked="checked">
<label for="inactive">Inactive</label>
<input type="radio" id="inactive" name="status" value="Inactive">
</c:when>


<c:when test="${employee.status.equals(\"Inactive\")}">
<label for="active">Active</label>
<input type="radio" id="active" name="status" value="Active" >
<label for="inactive">Inactive</label>
<input type="radio" id="inactive" name="status" value="Inactive" checked="checked">
</c:when>

<c:otherwise>

<label for="active">Active</label>
<input type="radio" id="active" name="status" value="Active" >
<label for="inactive">Inactive</label>
<input type="radio" id="inactive" name="status" value="Inactive" checked="checked">

</c:otherwise>


</c:choose>
<br> <br>
<input type="submit" value="ADD">
	
	</form>
	</div>
	</c:when>
	</c:choose>
</body>
</html>