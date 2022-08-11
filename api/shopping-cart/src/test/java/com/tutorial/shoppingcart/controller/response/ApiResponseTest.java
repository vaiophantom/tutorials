package com.tutorial.shoppingcart.controller.response;


import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class ApiResponseTest {

    @Test
    public void test(){
        ApiResponseStatus apiResponseStatus = new ApiResponseStatus("a","a");
        apiResponseStatus.setCode("b");
        apiResponseStatus.setMessage("b");
        Assert.assertNotNull(apiResponseStatus.getMessage());
        Assert.assertNotNull(apiResponseStatus.getCode());
        Object o = new Object();
        ApiResponse apiResponse = new ApiResponse(o,apiResponseStatus);
        apiResponse.setData(o);
        apiResponse.setStatus(apiResponseStatus);
        Assert.assertNotNull(apiResponse.getData());
        Assert.assertNotNull(apiResponse.getStatus());

    }
}
