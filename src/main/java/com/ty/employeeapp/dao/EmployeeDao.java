package com.ty.employeeapp.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.servlet.ModelAndView;

import com.ty.employeeapp.dto.EmployeeDto;
import com.ty.employeeapp.service.EmployeeService;

@Repository
public class EmployeeDao {

	@Autowired
	private EntityManagerFactory factory;
	
	public EmployeeDto insertEmployee(EmployeeDto newEmployeeDto) {
		EntityManager manager=factory.createEntityManager();
		EntityTransaction transaction =manager.getTransaction();
		try {
		transaction.begin();
		System.out.println("Inside dao");
		manager.persist(newEmployeeDto);
		transaction.commit();
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			transaction.rollback();
		}
		return newEmployeeDto;
	}

	public List<EmployeeDto> getAllEmployee() {
		// TODO Auto-generated method stub
		EntityManager manager=factory.createEntityManager();
		String jpql="FROM EmployeeDto";
		Query query=manager.createQuery(jpql);
		return query.getResultList();
	}

	public EmployeeDto findEmployee(int id) {
		// TODO Auto-generated method stub
		EntityManager manager=factory.createEntityManager();
		EmployeeDto employeeDto=manager.find(EmployeeDto.class, id);
		return employeeDto;
	}

	public EmployeeDto updateEmployee(EmployeeDto dto) {
		// TODO Auto-generated method stub
		EntityManager manager=factory.createEntityManager();
		EntityTransaction transaction =manager.getTransaction();
		try {
			transaction.begin();
			manager.merge(dto);
			transaction.commit();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			transaction.rollback();
		}
		return dto;
	}

	public EmployeeDto removeEmployee(EmployeeDto employeeDto) {
		// TODO Auto-generated method stub
		EntityManager manager=factory.createEntityManager();
		EntityTransaction transaction =manager.getTransaction();
		try {
			transaction.begin();
			EmployeeDto deleteEmloyee=manager.merge(employeeDto);
			manager.remove(deleteEmloyee);
			transaction.commit();
		} catch (Exception e) {
			// TODO: handle exception
			
			transaction.commit();
		}
		return null;
	}
	
	
	
	
}
