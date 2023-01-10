package com.ty.employeeapp.service;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ty.employeeapp.bean.Employee;
import com.ty.employeeapp.dao.EmployeeDao;
import com.ty.employeeapp.dto.EmployeeDto;

@Service
public class EmployeeService {
	
	@Autowired
	private EmployeeDao employeeDao;

	public EmployeeDto addEmployee(Employee employee) {
		// TODO Auto-generated method stub
		
		EmployeeDto dto =new EmployeeDto();
		
		dto.setName(employee.getName());
		dto.setEmail(employee.getEmail());
		LocalDate DOB=LocalDate.parse(employee.getDOB());
		dto.setDOB(DOB);
		int age=LocalDate.now().getYear()-DOB.getYear();
		dto.setAge(age);
//		dto.setName(employee.getName());
//		dto.setEmail(employee.getEmail());
//		LocalDate DOB=LocalDate.parse(employee.getDOB());
//		dto.setDOB(DOB);
//		Integer age=LocalDate.now().getYear()-DOB.getYear();
//		dto.setAge(age);
		dto.setSalary(employee.getSalary());
		dto.setemployeeStatus(employee.getemployeeStatus());
		System.out.println("Inside service");
		return employeeDao.insertEmployee(dto);
		
	}

	public List<EmployeeDto> getAllEmployee() {
		// TODO Auto-generated method stub
		
		return employeeDao.getAllEmployee();
	}

	public EmployeeDto searchEmployee(int id) {
		// TODO Auto-generated method stub
		return employeeDao.findEmployee(id);
	}

	public EmployeeDto updateEmployee(Employee employee, int empid) {
	
		EmployeeDto dto =new EmployeeDto();
		
		dto.setId(empid);
		System.out.println(empid);
		dto.setName(employee.getName());
		dto.setEmail(employee.getEmail());
		LocalDate DOB=LocalDate.parse(employee.getDOB());
		dto.setDOB(DOB);
		Integer age=LocalDate.now().getYear()-DOB.getYear();
		dto.setAge(age);
		dto.setSalary(employee.getSalary());
		dto.setemployeeStatus(employee.getemployeeStatus());
		return employeeDao.updateEmployee(dto);
	}

	public EmployeeDto deleteEmployee(int id) {
		// TODO Auto-generated method stub
		EmployeeDto employeeDto=employeeDao.findEmployee(id);
		return employeeDao.removeEmployee(employeeDto);
	}
}
