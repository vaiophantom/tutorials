package com.tutorial.shoppingproduct.controller;

import com.tutorial.shoppingproduct.controller.common.ApiPagination;
import com.tutorial.shoppingproduct.controller.request.ProductRequest;
import com.tutorial.shoppingproduct.model.Product;
import com.tutorial.shoppingproduct.model.ProductDetails;
import com.tutorial.shoppingproduct.service.ProductService;
import com.tutorial.shoppingproduct.service.impl.ProductServiceImpl;
import com.tutorial.shoppingproduct.utils.Pagination;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.Spy;
import org.springframework.test.util.ReflectionTestUtils;
import org.springframework.util.Assert;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.doReturn;

public class ProductControllerTest {


    ProductService productService = new ProductServiceImpl();
    @InjectMocks
    ProductService spyProductService = Mockito.spy(productService);

    @Spy
    ProductController productController = new ProductController();

    @BeforeEach
    public void init() {
        MockitoAnnotations.openMocks(this);
        ReflectionTestUtils.setField(
                productController,
                "productService",
                spyProductService);
    }


    @Test
    public void testSearchProducts() {
        ProductRequest productRequest = new ProductRequest();
        ApiPagination apiPagination = new ApiPagination();
        apiPagination.setCurrentPage(1);
        apiPagination.setPageSize(1);
        productRequest.setPaginator(apiPagination);

        Pagination<ProductDetails> productDetailsPagination = new Pagination<>();
        List<ProductDetails> lstProductDetail = new ArrayList();
        ProductDetails productDetails = new ProductDetails();
        productDetails.setRecordCount(1);
        List<Product> productList = new ArrayList();
        productDetails.setProductList(productList);
        lstProductDetail.add(productDetails);
        productDetailsPagination.setItems(lstProductDetail);

        doReturn(productDetailsPagination).when(spyProductService).searchProducts(productRequest,
                productRequest.getPaginator().getCurrentPage(), productRequest.getPaginator().getPageSize());

        productController.searchProducts(productRequest);

        Assert.notNull(productController, "");
    }
}
