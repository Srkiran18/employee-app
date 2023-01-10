package com.ty.employeeapp.controller;

import java.util.List;

import org.apache.taglibs.standard.lang.jstl.test.beans.PublicBean1;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.ty.employeeapp.bean.Employee;
import com.ty.employeeapp.dto.EmployeeDto;
import com.ty.employeeapp.service.EmployeeService;


@Controller
public class EmployeeController {
	
	@Autowired
	private EmployeeService employeeService;
	
	
	@GetMapping("/home")
	public ModelAndView getHomePage(ModelAndView modelAndView) {
		modelAndView.setViewName("index");
		return modelAndView;

	}
	
	@GetMapping("/add-employee-form")
	public ModelAndView getEmloyee(ModelAndView modelAndView) {
		
		modelAndView.setViewName("add-employee");
		return modelAndView;
	}
	
	@PostMapping("/add-employee-details")
	public ModelAndView addEmployee(Employee employee, Model myModel, ModelAndView modelAndView) {
		System.out.println(employee);
		EmployeeDto savedEmployee= employeeService.addEmployee(employee);
		System.out.println("Inside controlleer");
		if (savedEmployee != null) {
			modelAndView.setViewName("redirect:/home");
		} else {
			modelAndView.setViewName("redirect:/add-employee-form");
		}
		return modelAndView;
    }
	@GetMapping("/display-all")
	public ModelAndView getAllEmployeeDetails(ModelAndView modelAndView, Model model) {
		List<EmployeeDto> allEmployee=employeeService.getAllEmployee();
		if (allEmployee.isEmpty()) {
			model.addAttribute("msg", "No Records");
		} else {
			model.addAttribute("msg", allEmployee);
		}
		modelAndView.setViewName("display-all-employee");
		return modelAndView;
		
	}
	
	@GetMapping("/edit/{employeeId}")
	public void getEditForm(ModelAndView modelAndView, @PathVariable("employeeId")int id, Model model) {
		EmployeeDto searchEmployee=employeeService.searchEmployee(id);
		if (searchEmployee!=null) {
			model.addAttribute("employee", searchEmployee);
			modelAndView.setViewName("edit-form");
		}else {
			model.addAttribute("employee", "No Records Found");
			modelAndView.setViewName("edit-form");
		}
	}
	@PostMapping("/update-employee")
	public ModelAndView updateEmployee(Employee employee, @RequestParam("id") int empid, ModelAndView modelAndView,Model model) {
		EmployeeDto updatedEmployee=employeeService.updateEmployee(employee, empid);
		if (updatedEmployee!=null) {
			modelAndView.setViewName("redirect:/display-all");
		} else {
			model.addAttribute("msg", "Record Not updated");
			modelAndView.setViewName("display-all-employee");
		}
		return modelAndView;
	}
	@GetMapping("/delete/{employeeId}")
	public void deleteEmployee(ModelAndView modelAndView,Model model, @PathVariable("employeeId")int id) {
		EmployeeDto deleteEmployee=employeeService.deleteEmployee(id);
		if (deleteEmployee!=null) {
			modelAndView.setViewName("redirect:/display-all");
		}else {
			model.addAttribute("msg", "Record Not updated");
			modelAndView.setViewName("display-all-employee");
		}
	}
}
