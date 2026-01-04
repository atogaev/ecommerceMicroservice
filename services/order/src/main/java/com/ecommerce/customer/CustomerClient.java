package com.ecommerce.customer;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.Optional;

/**
 * @author Abduhoshim
 * @since 03/01/2026
 */
@FeignClient(name = "customer-service",
            url = "${application.config.customer-url}")
public interface CustomerClient {

    @GetMapping(path = "/{customerId}")
    Optional<CustomerResponse> getCustomer(@PathVariable String customerId);
}
