package com.ecommerce.customer;

import com.ecommerce.customer.customerDTO.CustomerRequest;
import com.ecommerce.customer.customerDTO.CustomerResponse;
import org.mapstruct.Mapper;

/**
 * @author Abduhoshim
 * @since 6/18/2025
 */
@Mapper(componentModel = "spring",uses = {AddressMapper.class} )
public interface CustomerMapper {
    CustomerEntity toCustomer(CustomerRequest customer);
    CustomerResponse toCustomerResponse(CustomerEntity customer);
}
