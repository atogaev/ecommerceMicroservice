package com.ecommerce.category;

import com.ecommerce.product.ProductEntity;
import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

/**
 * @author Abduhoshim
 * @since 23/12/2025
 */
@Entity
@Data
@Table(name = "category")
public class CategoryEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;
    private String description;
    @OneToMany(mappedBy = "category",cascade = CascadeType.REMOVE)
    private List<ProductEntity> products;
}
