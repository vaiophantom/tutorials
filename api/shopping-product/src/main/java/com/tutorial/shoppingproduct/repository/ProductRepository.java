package com.tutorial.shoppingproduct.repository;

import com.tutorial.shoppingproduct.controller.request.ProductRequest;
import com.tutorial.shoppingproduct.model.Product;
import com.tutorial.shoppingproduct.model.ProductDetails;
import com.tutorial.shoppingproduct.utils.Pagination;

import java.math.BigDecimal;

public interface ProductRepository{
    ProductDetails getAllProductByPage(int pageSize, int pageNo, Long productId);

    Pagination<ProductDetails> searchProducts(ProductRequest productRequest, Integer selectPage, Integer pageSize);

    Product searchProductById(Long id);
}
