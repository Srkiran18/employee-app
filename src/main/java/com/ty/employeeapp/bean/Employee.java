package com.ty.employeeapp.bean;

public class Employee {
	

	private String name;
	private String email;
	private String DOB;
	private double salary;
	private String employeeStatus;
	
	
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getDOB() {
		return DOB;
	}
	public void setDOB(String dOB) {
		DOB = dOB;
	}
	public double getSalary() {
		return salary;
	}
	public void setSalary(double salary) {
		this.salary = salary;
	}
	public String getemployeeStatus() {
		return employeeStatus;
	}
	public void setemployeeStatus(String employeeStatus) {
		this.employeeStatus = employeeStatus;
	}
	@Override
	public String toString() {
		return "Employee [name=" + name + ", email=" + email + ", DOB=" + DOB + ", salary=" + salary + ", employeeStatus="
				+ employeeStatus + "]";
	}
	
	
	
	
}
