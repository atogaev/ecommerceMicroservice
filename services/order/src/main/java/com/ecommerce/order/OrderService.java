package com.ecommerce.order;

import com.ecommerce.customer.CustomerClient;
import com.ecommerce.exceptions.BusinessException;
import com.ecommerce.order.dto.OrderRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

/**
 * @author Abduhoshim
 * @since 03/01/2026
 */
@Service
@RequiredArgsConstructor
public class OrderService {

    private final CustomerClient customerClient;

    public String createOrder(OrderRequest orderRequest) {
        var customer = customerClient.getCustomer(orderRequest.customerId()).orElseThrow(() -> new BusinessException("Customer not found"));
        return null;
    }
}
