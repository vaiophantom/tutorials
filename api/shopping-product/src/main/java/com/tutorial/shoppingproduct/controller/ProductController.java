package com.tutorial.shoppingproduct.controller;

import com.sun.istack.NotNull;
import com.tutorial.shoppingproduct.controller.request.ProductRequest;
import com.tutorial.shoppingproduct.controller.response.ApiPaginationResponse;
import com.tutorial.shoppingproduct.controller.response.ApiResponse;
import com.tutorial.shoppingproduct.controller.response.utils.ApiResponseUtil;
import com.tutorial.shoppingproduct.model.ProductDetails;
import com.tutorial.shoppingproduct.service.ProductService;
import com.tutorial.shoppingproduct.utils.Pagination;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.lang.invoke.MethodHandles;

@RequestMapping("/product")
@RestController
public class ProductController {
    private static final Logger logger =
            LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());

    @Autowired
    ProductService productService;

    @GetMapping(value = "/search/{id}")
    public ResponseEntity<ApiResponse> searchProductsById(@PathVariable Long id) {
        logger.info(
                "ProductController.searchProductsById: - id = " +id);

        return ApiResponseUtil.successResponse(productService.searchById(id));
    }

    @PostMapping(value = "/search")
    public ResponseEntity<ApiPaginationResponse> searchProducts(
            @RequestBody @NotNull ProductRequest productRequest) {
        logger.info(
                "ProductController.searchProducts: - productRequest = "
                        + productRequest);

        return getProductData(productRequest);
    }

    private ResponseEntity<ApiPaginationResponse> getProductData(
            ProductRequest productRequest) {
        ApiPaginationResponse apiPaginationResponse = new ApiPaginationResponse();
        Pagination<ProductDetails> productDetailsPagination = productService.searchProducts(productRequest,
                productRequest.getPaginator().getCurrentPage(), productRequest.getPaginator().getPageSize());
        apiPaginationResponse.setData(productDetailsPagination.getItems().get(0).getProductList());
        apiPaginationResponse.getPagination().setPagination(productDetailsPagination);
        logger.info("getProductData");

        return ResponseEntity.status(HttpStatus.OK).body(apiPaginationResponse);
    }
}
