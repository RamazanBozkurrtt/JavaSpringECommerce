package com.Ecommerce.controller.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.Ecommerce.controller.abstracts.ICustomerController;
import com.Ecommerce.dto.DtoCustomer;
import com.Ecommerce.dto.DtoCustomerIU;
import com.Ecommerce.entitites.Customer;
import com.Ecommerce.service.concretes.CustomerServiceImpl;

@RestController
@RequestMapping("/rest/api/customer")
public class CustomerControllerImpl implements ICustomerController {
	
	@Autowired
	CustomerServiceImpl customerService;

	@PostMapping(path="/save")
	@Override
	public DtoCustomer saveCustomer(@RequestBody DtoCustomerIU dtoCustomerIU) {
		return customerService.saveCustomer(dtoCustomerIU);
	}
	
	
	@GetMapping(path = "/get/{id}")
	public DtoCustomer getCustomerById(@PathVariable(name = "id",required = true) int id) {
		return customerService.getCustomerById(id);
		
	}
	
	@PostMapping(path = "/delete/{id}")
	public String deleteCustomerById(@PathVariable(name = "id",required = true) int id) {
		return customerService.deleteCustomerById(id);
	}


	@Override
	@GetMapping(path = "/get-list")
	public List<DtoCustomer> getCustomerList() {
		
		return customerService.getCustomerList();
	}


	@Override
	@PutMapping(path = "/update/{id}")
	public DtoCustomer updateCustomerById(@PathVariable(name = "id")int id,@RequestBody(required = true) DtoCustomerIU customerUpdate) {
		return customerService.updateCustomerById(id, customerUpdate);
	}

}







