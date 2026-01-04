package com.ecommerce.product;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author Abduhoshim
 * @since 23/12/2025
 */
@Repository
public interface ProductRepository extends JpaRepository<ProductEntity,Long> {
}
