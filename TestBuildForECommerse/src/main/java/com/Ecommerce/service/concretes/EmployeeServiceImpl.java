package com.Ecommerce.service.concretes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Ecommerce.entitites.Employee;
import com.Ecommerce.exceptions.InvalidEmailException;
import com.Ecommerce.repository.EmployeeRepository;
import com.Ecommerce.service.abstracts.IEmployeeService;

@Service
public class EmployeeServiceImpl implements IEmployeeService {
	
	@Autowired
	EmployeeRepository employeeRepository;
	
	@Override
	public Employee saveEmployee(Employee employee) {

		return employeeRepository.save(employee);
	}
	
	private boolean isEmailValid(String email) {
		if(!email.matches("^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,}$")) {
			throw new InvalidEmailException("Geçersiz e-posta formatı!");
		}else if(email.matches(".*[çÇğĞıİöÖşŞüÜ].*")) {
			throw new InvalidEmailException("E-posta adresi Türkçe karakter içeremez!");
		}else {
			return true;
		}
	}


}
