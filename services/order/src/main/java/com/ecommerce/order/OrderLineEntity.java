package com.ecommerce.order;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
@Entity
@Table(name = "order_line")
public class OrderLineEntity {

    @Id
    private Long id;
    private Long orderId;
    @ManyToOne
    @JoinColumn(name = "order_id")
    private OrderEntity order;
    private double quantity;
}