package com.jsp.employee1.employeecontroller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.jsp.employee1.dao.EmployeeDao;
import com.jsp.employee1.dto.Employeee;
import com.jsp.employee1.service.EmployeeService;
import com.jsp.employee1.util.ResponseStructure;

@RestController
public class EmployeeController {
	@Autowired
	private EmployeeDao dao;
	
	@Autowired
	private EmployeeService service;

	@PostMapping("/save")
	public ResponseStructure<Employeee> saveEmployee(@RequestBody Employeee employee) {

		return service.saveEmploye(employee);
	}

	@GetMapping("/fetch")
	public Employeee getEmployee(@RequestParam int id) {
		return dao.getEmployee(id);

	}

	@GetMapping("/fetchall")
	public List<Employeee> getAll() {
		return dao.getAll();

	}
//	@PutMapping("/update")
//	public Employeee updateEmployee(@RequestBody Employeee employee)
//	{
//		return 
//		
//	}

	@DeleteMapping("/delete/{id}")
	public Employeee deleteEmployee(@PathVariable int id) {
		return dao.deleteEmployee(id);
	}

	@PutMapping("/update/{id}")
	public ResponseStructure<Employeee> updateEmployee(@RequestBody Employeee employee, @PathVariable int id) {
		return service.updateEmployee(employee, id);
	}
	@PatchMapping("/updatesalary/{id}/{salary}")
	public Employeee updateSalary(@PathVariable int id,@PathVariable int salary)
	{
		return dao.updateSalary(id, salary);
	}
	
	@GetMapping("/findbyemail/{email}")
	public Employeee findEmpByEmail(@PathVariable String email)
	{
		return service.findByEmail( email);
		
	}
	
	@GetMapping("/findbyphone/{phone}")
	public Employeee findByPhone(@PathVariable long phone)
	{
		return dao.findByPhone(phone);
	}
}
