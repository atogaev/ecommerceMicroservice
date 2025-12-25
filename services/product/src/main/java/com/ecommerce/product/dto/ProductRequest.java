package com.ecommerce.product.dto;

import jakarta.validation.constraints.NotNull;

import java.math.BigDecimal;

/**
 * @author Abduhoshim
 * @since 23/12/2025
 */
public record ProductRequest(
        Long id,
        @NotNull(message = "Product name is required")
        String name,
        String description,
        Double available_quantity,
        @NotNull(message = "Price is required")
        BigDecimal price,
        Integer categoryId
) {
}
