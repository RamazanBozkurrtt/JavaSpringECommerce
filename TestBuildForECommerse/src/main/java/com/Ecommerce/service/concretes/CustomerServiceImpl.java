package com.Ecommerce.service.concretes;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Ecommerce.Configuration.CustomerMapper;
import com.Ecommerce.dto.DtoCustomer;
import com.Ecommerce.dto.DtoCustomerIU;
import com.Ecommerce.entitites.Customer;
import com.Ecommerce.exceptions.ObjectDoesntExistException;
import com.Ecommerce.repository.CustomerRepository;
import com.Ecommerce.service.abstracts.ICustomerService;

@Service
public class CustomerServiceImpl implements ICustomerService {

	@Autowired
	CustomerRepository customerRepository;

	 @Autowired
	 private CustomerMapper customerMapper;

	@Override
	public DtoCustomer saveCustomer(DtoCustomerIU dtoCustomerIU) {
		Customer customer = new Customer();
		BeanUtils.copyProperties(dtoCustomerIU, customer);
		
		DtoCustomer dtoCustomer = new DtoCustomer();
		Customer dbCustomer = customerRepository.save(customer);
		BeanUtils.copyProperties(dbCustomer, dtoCustomer);
		
		return dtoCustomer;
	}
	
	
	public DtoCustomer getCustomerById(int id) {
		DtoCustomer dtoCustomer = new DtoCustomer();
		Customer dbCustomer = customerRepository.findById(id).orElseThrow(()-> new ObjectDoesntExistException("Hata!["+id+"] id'sine sahip Kullanıcı bulunamadı!"));
		
		BeanUtils.copyProperties(dbCustomer, dtoCustomer);
		
		return dtoCustomer;
	}

	
	public String deleteCustomerById(int id) {
		if(customerRepository.existsById(id)){
			customerRepository.deleteById(id);
			return "İşlem Başarılı.["+id+"] id'li kullanıcı silinmiştir !";
		}else {
			throw new ObjectDoesntExistException("HATA! ["+id+"] id'sine sahip bir kayıt bulunamadı !");
		}
	}

	@Override
	public List<DtoCustomer> getCustomerList() {
		
		List<Customer> customers = customerRepository.findAll();
        return customerMapper.toDtoList(customers);

	}

	@Override
	public DtoCustomer updateCustomerById(int id, DtoCustomerIU customer) {
		DtoCustomer dto = new DtoCustomer();
		
		Optional<Customer> optional = customerRepository.findById(id);
		
		if(optional.isPresent()) {
			Customer dbCustomer = optional.get();
			
			if(customer.getFirstName() != null) {
				dbCustomer.setFirstName(customer.getFirstName());
			}
			
			if(customer.getLastName() != null) {
				dbCustomer.setLastName(customer.getLastName());
			}
			
			Customer updatedCustomer = customerRepository.save(dbCustomer);
			
			BeanUtils.copyProperties(updatedCustomer, dto);
			return dto;
		}
		
		return null;
		
	}
	
	

}
