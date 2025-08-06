package com.Ecommerce.controller.concretes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.Ecommerce.controller.abstracts.IEmployeeController;
import com.Ecommerce.entitites.Employee;
import com.Ecommerce.service.concretes.EmployeeServiceImpl;

@RestController
@RequestMapping(path = "/rest/api/employee")
public class EmployeeControllerImpl implements IEmployeeController {
	
	@Autowired
	private EmployeeServiceImpl employeeService;

	@Override
	@PostMapping(path = "/save")
	public Employee saveEmployee(@RequestBody Employee employee) {

		return employeeService.saveEmployee(employee);
	}

}
