package com.ecommerce.product;

import com.ecommerce.product.dto.ProductPurchaseResponse;
import com.ecommerce.product.dto.ProductRequest;
import com.ecommerce.product.dto.ProductResponse;
import jakarta.validation.constraints.NotNull;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

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
    @Mapping(target = "quantity", source = "quantity")
    ProductPurchaseResponse toproductPurchaseResponse(ProductEntity product, @NotNull(message = "Quantity is mandatory") double quantity);
}
