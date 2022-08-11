package com.tutorial.shoppingcart.controller.response;


import com.tutorial.shoppingcart.controller.common.ApiPagination;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class ApiPaginationResponseTest {

    @Test
    public void test(){
        ApiPagination apiPagination = new ApiPagination();
        apiPagination.setCurrentPage(1);
        apiPagination.setPageCount(1);
        apiPagination.setRecordCount(1);
        apiPagination.setSortOrder("asc");
        apiPagination.setPageSize(1);
        ApiPaginationResponse apiPaginationResponse = new ApiPaginationResponse();
        apiPaginationResponse = new ApiPaginationResponse(apiPagination);
        apiPaginationResponse.setPagination(apiPagination);
        Assert.assertNotNull(apiPaginationResponse.getPagination());
    }

}
