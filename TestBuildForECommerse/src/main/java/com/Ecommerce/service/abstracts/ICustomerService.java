package com.Ecommerce.service.abstracts;

import java.util.List;

import com.Ecommerce.dto.DtoCustomer;
import com.Ecommerce.dto.DtoCustomerIU;
import com.Ecommerce.entitites.Customer;


public interface ICustomerService {
	
	public DtoCustomer saveCustomer(DtoCustomerIU customer);
	
	public DtoCustomer getCustomerById(int id);
	
	public String deleteCustomerById(int id);
	
	public List<DtoCustomer> getCustomerList();
	
	public DtoCustomer updateCustomerById(int id,DtoCustomerIU customerUpdate);

}
