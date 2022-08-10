package com.tutorial.shoppingproduct.service;

import com.tutorial.shoppingproduct.controller.request.ProductRequest;
import com.tutorial.shoppingproduct.controller.response.ProductResponse;
import com.tutorial.shoppingproduct.model.Product;
import com.tutorial.shoppingproduct.model.ProductDetails;
import com.tutorial.shoppingproduct.utils.Pagination;

import java.util.List;

public interface ProductService {
    ProductResponse getAllProductByPage(int pageNo, Long productId);

    Pagination<ProductDetails> searchProducts(ProductRequest productRequest, Integer selectPage, Integer pageSize);

    Product searchById(Long id);
}
