package com.jsp.employee1.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.jsp.employee1.dto.Employeee;

public interface EmployeeRepo extends JpaRepository<Employeee, Integer>{
	
	//for fetching employee using FindBy keyword
	public Employeee findByEmail(String email);
	
	//fetching employee without using keywords
	@Query("select e from Employeee e where phone=?1")
	public Employeee employeeByPhone(long phone);
	
	public List<Employeee> findBySalaryGreaterThan(int salary); 
	//if we are using findBy keyword sprig will create query by itself
}
