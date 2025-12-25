package com.ecommerce.product;

import com.ecommerce.product.dto.ProductRequest;
import com.ecommerce.product.dto.ProductResponse;
import org.mapstruct.Mapper;

import java.util.List;

/**
 * @author Abduhoshim
 * @since 23/12/2025
 */
@Mapper(componentModel = "spring")
public interface ProductMapper {

    ProductEntity productRequestToProductEntity(ProductRequest productRequest);
    ProductResponse productEntityToProductResponse(ProductEntity productEntity);
    List<ProductResponse> productEntityToProductResponseList(List<ProductEntity> productEntityList);
}
