package com.jsp.employee1.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.jsp.employee1.dto.Employeee;
import com.jsp.employee1.repository.EmployeeRepo;

@Repository
public class EmployeeDao {
	@Autowired
	private EmployeeRepo employeerepo;

	public Employeee saveEmployee(Employeee employee) {
		return employeerepo.save(employee);

	}

	public Employeee getEmployee(int id) {
//		return employeerepo.findById(id).get();

		// to avoid no such element found exception
		Optional<Employeee> opt = employeerepo.findById(id);
		if (opt.isPresent()) {
			return opt.get();
		}
		return null;
	}

	public Employeee updateEmployee(Employeee employee) {

		return null;

	}

	public List<Employeee> getAll() {
		// TODO Auto-generated method stub
		return employeerepo.findAll();
	}

	public Employeee deleteEmployee(int id) {
		Optional<Employeee> optional = employeerepo.findById(id);
		if (optional.isEmpty()) {
			return null;
		}
		employeerepo.deleteById(id);
		return optional.get();
	}

	public Employeee updateSalary(int id, int salary) {
		Optional<Employeee> optional = employeerepo.findById(id);
		if (optional.isPresent()) {
			Employeee employeee = optional.get();
			employeee.setSalary(salary);
			return employeerepo.save(employeee);
		}
		return null;
	}

	public Employeee updateEmployee(Employeee employee, int id) {
		Optional<Employeee> dbemp = employeerepo.findById(id);
		if (dbemp.isPresent()) { // if data is present then only it will updte

			employee.setId(id);
			return employeerepo.save(employee);
		}
		return null;
	}

	public Employeee findByEmail(String email) {
		return employeerepo.findByEmail(email);

	}

	public Employeee findByPhone(long phone) {

		return employeerepo.employeeByPhone(phone);
	}

}
