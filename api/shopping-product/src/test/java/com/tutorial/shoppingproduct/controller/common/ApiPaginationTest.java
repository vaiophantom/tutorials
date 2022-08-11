package com.tutorial.shoppingproduct.controller.common;

import org.junit.jupiter.api.Test;
import org.springframework.util.Assert;

public class ApiPaginationTest {

    @Test
    public void testApiPagination() {
        ApiPagination apiPagination = new ApiPagination();
        apiPagination.getPageCount();
        apiPagination.getRecordCount();
        apiPagination.getSortOrder();
        apiPagination.setSortOrder("");

        Assert.notNull(apiPagination, "");
    }
}
