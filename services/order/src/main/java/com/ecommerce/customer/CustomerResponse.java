package com.ecommerce.customer;

/**
 * @author Abduhoshim
 * @since 04/01/2026
 */
public record CustomerResponse(
        String id,
        String firstName,
        String lastName,
        String email
) {
}
