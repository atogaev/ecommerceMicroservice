package com.ecommerce.product;

import com.ecommerce.product.dto.ProductRequest;
import com.ecommerce.product.dto.ProductResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.PageImpl;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

/**
 * @author Abduhoshim
 * @since 23/12/2025
 */
@Slf4j
@RestController
@RequestMapping(path = "api/v1/product")
@RequiredArgsConstructor
public class ProductController {

    private final ProductService productService;

    @PostMapping(path = "/create")
    public ResponseEntity<String>  createProduct(@RequestBody @Validated ProductRequest productRequest) {
        return ResponseEntity.ok(productService.createProduct(productRequest));
    }

    @GetMapping(path = "/{productId}")
    public ResponseEntity<ProductResponse>  getProduct(@PathVariable Long productId) {
        return ResponseEntity.ok(productService.getProductById(productId));
    }

    @GetMapping(path = "/get-all")
    public ResponseEntity<PageImpl<ProductResponse>> getAllProducts(@RequestParam(name = "page")  Integer page,
                                                                    @RequestParam(name = "size") Integer size) {
        return ResponseEntity.ok(productService.getAllProduct(page,size));
    }

}
