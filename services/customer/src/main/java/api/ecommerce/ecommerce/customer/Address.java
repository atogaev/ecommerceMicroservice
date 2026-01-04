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
public class Address {
    @Id
    private String id;
    private String street;
    private String city;
    private String houseNumber;
    private String zip;

}
