package com.ecommerce.exceptions;

/**
 * @author Abduhoshim
 * @since 23/12/2025
 */
public class CustomNotFoundException extends RuntimeException {
    public CustomNotFoundException(String message) {
        super(message);
    }
}
