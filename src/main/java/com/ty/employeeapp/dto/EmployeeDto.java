package com.ty.employeeapp.dto;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GeneratorType;

@Entity
@Table(name="employee_tab")
public class EmployeeDto {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="employee_id")
	private int id;
    
	@Column(name="employee_name")
	private String name;
	
	@Column(name="employee_mail")
	private String email;
	
	@Column(name="employee_DOB")
	private LocalDate DOB;
	
	@Column(name="employee_age")
	private int age;
	
	@Column(name="employee_salary")
	private double salary;
	
	@Column(name="employee_employeeStatus")
	private String employeeStatus;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

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

	public LocalDate getDOB() {
		return DOB;
	}

	public void setDOB(LocalDate dOB) {
		DOB = dOB;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
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
		return "EmployeeDto [id=" + id + ", name=" + name + ", email=" + email + ", DOB=" + DOB + ", age=" + age
				+ ", salary=" + salary + ", employeeStatus=" + employeeStatus + "]";
	}
}
