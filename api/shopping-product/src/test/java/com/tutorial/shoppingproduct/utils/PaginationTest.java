package com.tutorial.shoppingproduct.utils;

import org.junit.jupiter.api.Test;
import org.springframework.util.Assert;

public class PaginationTest {

    @Test
    public void testPagination(){
        Pagination pagination = new Pagination(1,1,1);
        pagination.getPageCount();
        pagination.getFromIndex();
        pagination.getToIndex();
        pagination.setCurrentPage(1);
        pagination.setPageSize(1);
        pagination.setRecordCount(1);

        Pagination pagination2 = new Pagination(1,1);
        Assert.notNull(pagination,"");
    }
}
