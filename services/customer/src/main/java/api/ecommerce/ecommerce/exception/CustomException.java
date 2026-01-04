package api.ecommerce.ecommerce.exception;

import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @author Abduhoshim
 * @since 6/26/2025
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class CustomException extends RuntimeException {
    private final String message;
}
