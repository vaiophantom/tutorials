package com.tutorial.shoppingcart.controller.common;


import com.tutorial.shoppingcart.utils.Pagination;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.ArrayList;
import java.util.List;

@RunWith(MockitoJUnitRunner.class)
public class ApiPaginationTest {

    @Test
    public void test(){
        ApiPagination apiPagination = new ApiPagination();
        apiPagination.setCurrentPage(1);
        apiPagination.setPageCount(1);
        apiPagination.setRecordCount(1);
        apiPagination.setSortOrder("asc");
        apiPagination.setPageSize(1);
        Pagination pagination = new Pagination<>(1,1,1);
        pagination = new Pagination<>();
        pagination = new Pagination<>(1,1);
        Assert.assertNotNull(pagination.getFromIndex());
        Assert.assertNotNull(pagination.getToIndex());
        pagination.setPageSize(1);
        pagination.setRecordCount(1);
        List list = new ArrayList();
        list.add("a");
        pagination.setItems(list);
        Assert.assertNotNull(pagination.getItems());
        apiPagination.setPagination(pagination);
        Assert.assertEquals(1,apiPagination.getPageCount());
        Assert.assertEquals(1,apiPagination.getCurrentPage());
        Assert.assertEquals(1,apiPagination.getPageSize());
        Assert.assertEquals(1,apiPagination.getRecordCount());
        Assert.assertNotNull(apiPagination.getSortOrder());
        Assert.assertNotNull(apiPagination.toString());

        BasePaginator basePaginator = new BasePaginator();
        basePaginator.setPaginator(apiPagination);
        Assert.assertNotNull(basePaginator.getPaginator());
        Assert.assertNotNull(basePaginator.toString());
    }
}
