package api.ecommerce.ecommerce.customer;

import api.ecommerce.ecommerce.customer.customerDTO.CustomerRequest;
import api.ecommerce.ecommerce.customer.customerDTO.CustomerResponse;
import api.ecommerce.ecommerce.exception.CustomException;
import jakarta.validation.constraints.NotNull;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Abduhoshim
 * @since 6/13/2025
 */
@Service
@RequiredArgsConstructor
public class CustomerService {

    private final CustomerRepository repository;
    private final CustomerMapper mapper;

    public String createCustomer(CustomerRequest customerRequest) {
        var customer = repository.save(mapper.toCustomer(customerRequest));
        return customer.getId();
    }

    public void updateCustomer(@NonNull CustomerRequest customerRequest) {
        var customer = getCustomerById(customerRequest.id());
        mergeCustomers(customerRequest, customer);
        repository.save(customer);

    }

    private void mergeCustomers(@NonNull CustomerRequest customerRequest, @NonNull CustomerEntity customerEntity) {
        customerEntity.setName(customerRequest.name() != null && !customerRequest.name().isEmpty() ? customerRequest.name().trim() : customerEntity.getName());
        customerEntity.setEmail(customerRequest.email() != null && !customerRequest.email().isEmpty() ? customerRequest.email().trim() : customerEntity.getEmail());
        customerEntity.setAddress(customerRequest.address() != null ? customerRequest.address() : customerEntity.getAddress());
    }

    public List<CustomerResponse> findAllCustomer() {
        return repository.getAllByVisibleIsTrue(true).stream().map(mapper::toCustomerResponse).toList();
    }

    public CustomerResponse getById(String customerId) {
        return mapper.toCustomerResponse(getCustomerById(customerId));
    }

    private CustomerEntity getCustomerById(String customerId) {
        return repository.findById(customerId).orElseThrow(() -> new CustomException(String.format("This user is not found by ID: %s", customerId)));
    }
}
