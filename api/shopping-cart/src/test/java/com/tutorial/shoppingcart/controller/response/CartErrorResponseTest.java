package com.tutorial.shoppingcart.controller.response;


import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.ArrayList;
import java.util.List;

@RunWith(MockitoJUnitRunner.class)
public class CartErrorResponseTest {

    @Test
    public void test(){
        ApiResponseStatus apiResponseStatus = new ApiResponseStatus("a","A");
        CartErrorResponse cartErrorResponse = new CartErrorResponse(apiResponseStatus);
        List<String> list = new ArrayList<>();
        list.add("a");
        cartErrorResponse.setStatus(apiResponseStatus);
        cartErrorResponse.setDetailsList(list);
        Assert.assertNotNull(cartErrorResponse.getStatus());
        Assert.assertNotNull(cartErrorResponse.getDetailsList());
    }
}
