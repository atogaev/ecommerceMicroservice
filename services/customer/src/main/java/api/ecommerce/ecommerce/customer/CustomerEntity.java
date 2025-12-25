package api.ecommerce.ecommerce.customer;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * @author Abduhoshim
 * @since 6/13/2025
 */
@Getter
@Setter
@Document
public class CustomerEntity {
    @Id
    private String id;
    private String name;
    private String lastName;
    private String email;
    private Address address;
    private Boolean visible;
}
