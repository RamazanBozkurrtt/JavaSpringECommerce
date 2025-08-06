package com.Ecommerce.Configuration;

import com.Ecommerce.dto.DtoCustomer;
import com.Ecommerce.entitites.Customer;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2025-07-29T23:39:58+0300",
    comments = "version: 1.5.5.Final, compiler: Eclipse JDT (IDE) 3.40.0.v20241112-0530, environment: Java 21.0.5 (Eclipse Adoptium)"
)
@Component
public class CustomerMapperImpl implements CustomerMapper {

    @Override
    public DtoCustomer toDto(Customer customer) {
        if ( customer == null ) {
            return null;
        }

        DtoCustomer dtoCustomer = new DtoCustomer();

        dtoCustomer.setFirstName( customer.getFirstName() );
        dtoCustomer.setLastName( customer.getLastName() );

        return dtoCustomer;
    }

    @Override
    public List<DtoCustomer> toDtoList(List<Customer> customers) {
        if ( customers == null ) {
            return null;
        }

        List<DtoCustomer> list = new ArrayList<DtoCustomer>( customers.size() );
        for ( Customer customer : customers ) {
            list.add( toDto( customer ) );
        }

        return list;
    }
}
