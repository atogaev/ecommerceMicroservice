package com.ecommerce.product.dto;

import java.math.BigDecimal;
/**
 * @author Abduhoshim
 * @since 25/12/2025
 */
public record ProductPurchaseResponse(
        Integer productId,
        String name,
        String description,
        BigDecimal price,
        double quantity
) {
}
