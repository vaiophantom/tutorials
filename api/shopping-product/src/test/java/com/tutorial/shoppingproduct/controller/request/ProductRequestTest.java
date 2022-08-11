package com.tutorial.shoppingproduct.controller.request;

import org.junit.jupiter.api.Test;
import org.springframework.util.Assert;

import java.math.BigDecimal;

public class ProductRequestTest {
    @Test
    public void testProductRequest(){
        ProductRequest productRequest = new ProductRequest();
        productRequest.setCategory("123");
        productRequest.getCategory();
        productRequest.setName("123");
        productRequest.getName();
        productRequest.setPrice(BigDecimal.valueOf(1l));
        productRequest.getPrice();
        productRequest.setBranch("123");
        productRequest.getBranch();
        productRequest.setColor("123");
        productRequest.getColor();

        productRequest.setQueryConditions(null);
        productRequest.getQueryConditions();
        productRequest.setQueryParams(null);
        productRequest.getQueryParams();

        productRequest.buildQuery();

        Assert.notNull(productRequest,"");
    }
}
