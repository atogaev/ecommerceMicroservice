package api.ecommerce.ecommerce.customer.customerDTO;

import org.springframework.validation.annotation.Validated;

/**
 * @author Abduhoshim
 * @since 23/12/2025
 */
@Validated
public record AddressResponse(
        String id,
        String street,
        String city,
        String houseNumber,
        String zip
) {
}
