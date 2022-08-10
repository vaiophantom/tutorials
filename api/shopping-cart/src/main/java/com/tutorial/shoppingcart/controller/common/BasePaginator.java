package com.tutorial.shoppingcart.controller.common;

public class BasePaginator {
    private ApiPagination paginator = new ApiPagination();

    public ApiPagination getPaginator() {
        return paginator;
    }

    public void setPaginator(ApiPagination paginator) {
        this.paginator = paginator;
    }

    @Override
    public String toString() {
        return "BasePaginator{" + "paginator=" + paginator + '}';
    }
}
