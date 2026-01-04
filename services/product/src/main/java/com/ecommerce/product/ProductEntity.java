package com.ecommerce.product;

import com.ecommerce.category.CategoryEntity;
import jakarta.persistence.*;
import lombok.Data;

import java.math.BigDecimal;

/**
 * @author Abduhoshim
 * @since 23/12/2025
 */
@Data
@Entity
@Table(name = "product")
public class ProductEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String description;
    private Double availableQuantity;
    private BigDecimal price;
    @Column(name = "category_id")
    private Integer categoryId;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "categoty_id",updatable = false,insertable = false)
    private CategoryEntity category;

}
