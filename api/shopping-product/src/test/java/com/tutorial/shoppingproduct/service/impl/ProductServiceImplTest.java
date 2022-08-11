package com.tutorial.shoppingproduct.service.impl;

import com.tutorial.shoppingproduct.model.ProductDetails;
import com.tutorial.shoppingproduct.repository.ProductRepository;
import com.tutorial.shoppingproduct.repository.impl.ProductRepositoryImpl;
import com.tutorial.shoppingproduct.utils.Pagination;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.test.util.ReflectionTestUtils;
import org.springframework.util.Assert;

public class ProductServiceImplTest {

    ProductRepository productRepository = new ProductRepositoryImpl();

    @InjectMocks
    ProductRepository spyProductRepository = Mockito.spy(productRepository);


    ProductServiceImpl productServiceImpl = new ProductServiceImpl();

    @BeforeEach
    public void init() {
        MockitoAnnotations.openMocks(this);
        ReflectionTestUtils.setField(
                productServiceImpl,
                "productRepository",
                spyProductRepository);

        ReflectionTestUtils.setField(
                productServiceImpl,
                "pageSize",
                3);
    }

    @Test
    public void testGetAllProductByPage(){
        ProductDetails productDetails = new ProductDetails();
        productDetails.setRecordCount(1);

        Mockito.doReturn(productDetails).when(spyProductRepository).getAllProductByPage(3,1,1l);
        productServiceImpl.getAllProductByPage(1,1l);
        Assert.notNull(productServiceImpl,"");
    }

    @Test
    public void testSearchProducts(){
        Pagination<ProductDetails> result = new Pagination();
        Mockito.doReturn(result).when(spyProductRepository).searchProducts(null,1,1);
        productServiceImpl.searchProducts(null, 1, 1);
        Assert.notNull(productServiceImpl,"");
    }
}