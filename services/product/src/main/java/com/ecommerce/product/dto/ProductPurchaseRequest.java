package com.ecommerce.product.dto;

import jakarta.validation.constraints.NotNull;

import java.math.BigDecimal;

/**
 * @author Abduhoshim
 * @since 25/12/2025
 */
public record ProductPurchaseRequest(
        @NotNull(message = "Product id is mandatory")
        Long productId,
        @NotNull(message = "Quantity is mandatory")
        double quantity
) {
}
