<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Add Employee</title>
</head>
<body>

<jsp:include page="index.jsp"></jsp:include>

<div class="container">

<form action="add-employee-details" method="post" >

<label>Employee Name</label>
<input type="text" name="name">
<br> <br>

<label>Employee Email</label>
<input type="email" name="email">
<br> <br>

<label>Employee DOB</label>
<input type="date" name="DOB">
<br> <br>

<label>Employee Salary</label>
<input type="number" name="salary">
<br> <br>

<label>Employee Status</label>
<label for="active">Active</label>
<input type="radio" id="active" name="employeeStatus" value="Active">

<label for="inactive">Inactive</label>
<input type="radio" id="inactive" name="employeeStatus" value="Inactive">

<input type="submit" value="ADD">

</form>

</div>


</body>
</html>