package com.tutorial.shoppingcart.utils;

import java.util.ArrayList;
import java.util.List;

public class Pagination<E> {
    private int pageSize;
    private int recordCount;
    private int currentPage;
    private List<E> items = new ArrayList<>();

    public Pagination() {}

    public Pagination(int recordCount, int currentPage, int pageSize) {
        this.pageSize = pageSize;
        this.recordCount = recordCount;
        setCurrentPage(currentPage);
    }

    public Pagination(int recordCount, int pageSize) {
        this(recordCount, 1, pageSize);
    }

    public int getPageCount() {
        if (pageSize != 0) {
            int size = recordCount / pageSize;
            int mod = recordCount % pageSize;
            if (mod != 0) size++;
            return recordCount == 0 ? 1 : size;
        }
        return 0;
    }

    public int getFromIndex() {

        return (currentPage - 1) * pageSize;
    }

    public int getToIndex() {

        return Math.min(recordCount, currentPage * pageSize);
    }

    public int getCurrentPage() {
        return currentPage;
    }

    public void setCurrentPage(int currentPage) {
        int validPage = currentPage <= 0 ? 1 : currentPage;
        validPage = validPage > getPageCount() ? getPageCount() : validPage;
        this.currentPage = validPage;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public int getRecordCount() {
        return recordCount;
    }

    public void setRecordCount(int recordCount) {
        this.recordCount = recordCount;
    }

    public List<E> getItems() {
        return items;
    }

    public void setItems(List<E> items) {
        this.items = items;
    }
}
