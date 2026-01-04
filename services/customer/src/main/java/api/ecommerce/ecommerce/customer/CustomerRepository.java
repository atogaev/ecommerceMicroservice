package api.ecommerce.ecommerce.customer;

import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

/**
 * @author Abduhoshim
 * @since 6/13/2025
 */
public interface CustomerRepository extends MongoRepository<CustomerEntity, String> {
    List<CustomerEntity> getAllByVisibleIsTrue(Boolean visible);
}
