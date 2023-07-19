package com.jsp.employee1.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.jsp.employee1.dao.EmployeeDao;
import com.jsp.employee1.dto.Employeee;
import com.jsp.employee1.util.ResponseStructure;

@Service
public class EmployeeService {
	@Autowired
	private EmployeeDao dao;
	
	ResponseStructure<Employeee> responseStructure=new ResponseStructure<>();

	public ResponseStructure<Employeee> saveEmploye(Employeee employee) {
		if (employee.getSalary() >= 0 && employee.getSalary() <= 10000) {

			employee.setGrade('D');

		} else if (employee.getSalary() > 10000 && employee.getSalary() <= 20000) {
			employee.setGrade('C');
		} else if (employee.getSalary() > 20000 && employee.getSalary() <= 40000) {
			employee.setGrade('B');
		} else {
			employee.setGrade('A');
		}
		responseStructure.setMessage("saved Successfully");
		responseStructure.setStatus(HttpStatus.CREATED.value());
		responseStructure.setData(dao.saveEmployee(employee));
		return responseStructure;
	}

	public ResponseStructure<Employeee> updateEmployee(Employeee employee, int id) {
		if (employee.getSalary() >= 0 && employee.getSalary() <= 10000) {

			employee.setGrade('D');

		} else if (employee.getSalary() > 10000 && employee.getSalary() <= 20000) {
			employee.setGrade('C');
		} else if (employee.getSalary() > 20000 && employee.getSalary() <= 40000) {
			employee.setGrade('B');
		} else {
			employee.setGrade('A');
		}
		return responseStructure;
	}

	public Employeee findByEmail(String email)
	{
		return dao.findByEmail(email);
	}
	
	
}
