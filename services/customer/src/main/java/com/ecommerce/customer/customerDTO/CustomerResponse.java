package com.ecommerce.customer.customerDTO;

import com.ecommerce.customer.Address;

/**
 * @author Abduhoshim
 * @since 6/25/2025
 */
public record CustomerResponse(
        String id,
        String name,
        String lastName,
        String mail,
        Address address
) {
}
