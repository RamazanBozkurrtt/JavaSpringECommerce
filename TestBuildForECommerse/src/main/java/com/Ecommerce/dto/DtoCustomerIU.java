package com.Ecommerce.dto;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class DtoCustomerIU {
	
	private String firstName;
	private String lastName;
	private Date dateOfBirth;

}
