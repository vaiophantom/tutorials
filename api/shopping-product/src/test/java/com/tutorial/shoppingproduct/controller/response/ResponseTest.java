package com.tutorial.shoppingproduct.controller.response;

import com.tutorial.shoppingproduct.controller.common.ApiPagination;
import org.junit.jupiter.api.Test;
import org.springframework.util.Assert;

import java.util.ArrayList;

public class ResponseTest {

    @Test
    public void testResponse(){
        ApiPaginationResponse apiPaginationResponse = new ApiPaginationResponse(new ApiPagination());
        apiPaginationResponse.setPagination(new ApiPagination());

        ApiResponse apiResponse = new ApiResponse(new Object(), new ApiResponseStatus("",""));
        ApiResponse apiResponse2 = new ApiResponse(new Object());

        apiResponse.getData();
        apiResponse.getStatus();
        apiResponse.setStatus(new ApiResponseStatus("",""));

        ProductResponse productResponse = new ProductResponse();
        productResponse.setPagingInfo(new ApiPagination());
        productResponse.getPagingInfo();
        productResponse.setProductList(new ArrayList());
        productResponse.getProductList();

        ApiResponseStatus apiResponseStatus = new ApiResponseStatus("", "");
        apiResponseStatus.setCode("");
        apiResponseStatus.getCode();
        apiResponseStatus.getMessage();
        apiResponseStatus.setMessage("");

        Assert.notNull(apiResponse, "");
    }
}
