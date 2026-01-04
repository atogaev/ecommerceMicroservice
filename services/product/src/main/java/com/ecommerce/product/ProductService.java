package com.ecommerce.product;

import com.ecommerce.exceptions.CustomNotFoundException;
import com.ecommerce.exceptions.ProductPurchaseException;
import com.ecommerce.product.dto.ProductPurchaseRequest;
import com.ecommerce.product.dto.ProductPurchaseResponse;
import com.ecommerce.product.dto.ProductRequest;
import com.ecommerce.product.dto.ProductResponse;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**
 * @author Abduhoshim
 * @since 23/12/2025
 */
@Service
@RequiredArgsConstructor
public class ProductService {

    private final ProductRepository productRepository;
    private final ProductMapper productMapper;

    public String createProduct(ProductRequest productRequest) {
        ProductEntity productEntity = productMapper.productRequestToProductEntity(productRequest);
        productRepository.save(productEntity);
        return String.valueOf(productEntity.getId());
    }

    public ProductResponse getProductById(Long productId) {
        return productMapper.productEntityToProductResponse(getProductEntityById(productId));
    }

    private ProductEntity getProductEntityById(Long productId) {
        return productRepository.findById(productId).orElseThrow(() -> new CustomNotFoundException("Product not found"));
    }

    public PageImpl<ProductResponse> getAllProduct(Integer page, Integer size) {
        Pageable pageable = PageRequest.of(page-1, size);
        Page<ProductEntity> all = productRepository.findAll(pageable);
        List<ProductResponse> productResponses = productMapper.productEntityToProductResponseList(all.getContent());
        return new PageImpl<>(productResponses,pageable,all.getTotalElements());
    }

    @Transactional(rollbackOn =  ProductPurchaseException.class)
    public List<ProductPurchaseResponse> purchaseProducts(
            List<ProductPurchaseRequest> request
    ) {
        var productIds = request
                .stream()
                .map(ProductPurchaseRequest::productId)
                .toList();
        var storedProducts = productRepository.findAllById(productIds);
        if (productIds.size() != storedProducts.size()) {
            throw new ProductPurchaseException("One or more products does not exist");
        }
        var sortedRequest = request
                .stream()
                .sorted(Comparator.comparing(ProductPurchaseRequest::productId))
                .toList();
        var purchasedProducts = new ArrayList<ProductPurchaseResponse>();
        for (int i = 0; i < storedProducts.size(); i++) {
            var product = storedProducts.get(i);
            var productRequest = sortedRequest.get(i);
            if (product.getAvailableQuantity() < productRequest.quantity()) {
                throw new ProductPurchaseException("Insufficient stock quantity for product with ID:: " + productRequest.productId());
            }
            var newAvailableQuantity = product.getAvailableQuantity() - productRequest.quantity();
            product.setAvailableQuantity(newAvailableQuantity);
            productRepository.save(product);
            purchasedProducts.add(productMapper.toproductPurchaseResponse(product, productRequest.quantity()));
        }
        return purchasedProducts;
    }
}
