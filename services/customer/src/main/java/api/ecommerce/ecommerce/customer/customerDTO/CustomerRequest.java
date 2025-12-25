package api.ecommerce.ecommerce.customer.customerDTO;

import api.ecommerce.ecommerce.customer.Address;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;

/**
 * @author Abduhoshim
 * @since 6/13/2025
 */
public record CustomerRequest(
        String id,
        @NotNull(message = "Customer name is required")
        String name,
        @NotNull(message = "Customer lastName is required")
        String lastName,
        @Email(message = "Customer email is not a valid email address")
        String email,
        Address address
) {
}
