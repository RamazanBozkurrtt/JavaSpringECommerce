package com.Ecommerce.Configuration;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import com.Ecommerce.dto.DtoCustomer;
import com.Ecommerce.entitites.Customer;

import java.util.List;

@Mapper(componentModel = "spring")
public interface CustomerMapper {

    CustomerMapper INSTANCE = Mappers.getMapper(CustomerMapper.class);

    DtoCustomer toDto(Customer customer);

    List<DtoCustomer> toDtoList(List<Customer> customers);
}
