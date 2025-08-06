package com.Ecommerce.controller.abstracts;

import java.util.List;

import com.Ecommerce.dto.DtoCustomer;
import com.Ecommerce.dto.DtoCustomerIU;
import com.Ecommerce.entitites.Customer;

public interface ICustomerController {
	
	public DtoCustomer saveCustomer(DtoCustomerIU dtoCustomerIU);
	
	public DtoCustomer getCustomerById(int id);
	
	public String deleteCustomerById(int id);
	
	public List<DtoCustomer> getCustomerList();
	
	public DtoCustomer updateCustomerById(int id,DtoCustomerIU customerUpdate);
}
