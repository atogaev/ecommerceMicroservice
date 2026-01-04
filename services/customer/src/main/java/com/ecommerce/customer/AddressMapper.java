package com.ecommerce.customer;

import com.ecommerce.customer.customerDTO.CustomerRequest;
import org.mapstruct.Mapper;

/**
 * @author Abduhoshim
 * @since 6/26/2025
 */
@Mapper(componentModel = "spring")
public interface AddressMapper {
    Address toAddress(CustomerRequest customer);
    CustomerRequest toCustomerRequest(Address address);
}
