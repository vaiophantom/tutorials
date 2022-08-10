package com.tutorial.shoppingproduct.controller.common;


import com.tutorial.shoppingproduct.utils.Pagination;

public class ApiPagination {

  private int pageCount;
  private int pageSize;
  private int currentPage;
  private int recordCount;
  private String sortOrder;

  public ApiPagination() {
    // No arg Constructor.
  }

  public int getPageCount() {
    return pageCount;
  }

  public void setPageCount(int pageCount) {
    this.pageCount = pageCount;
  }

  public int getPageSize() {
    return pageSize;
  }

  public void setPageSize(int pageSize) {
    this.pageSize = pageSize;
  }

  public int getCurrentPage() {
    return currentPage;
  }

  public void setCurrentPage(int currentPage) {
    this.currentPage = currentPage;
  }

  public int getRecordCount() {
    return recordCount;
  }

  public void setRecordCount(int recordCount) {
    this.recordCount = recordCount;
  }

  public String getSortOrder() {
    return sortOrder;
  }

  public void setSortOrder(String sortOrder) {
    this.sortOrder = sortOrder;
  }

  public void setPagination(Pagination<?> paginationBean) {
    currentPage = paginationBean.getCurrentPage();
    pageSize = paginationBean.getPageSize();
    pageCount = paginationBean.getPageCount();
    recordCount = paginationBean.getRecordCount();
  }

  @Override
  public String toString() {
    return "ApiPagination{"
        + "pageCount="
        + pageCount
        + ", pageSize="
        + pageSize
        + ", currentPage="
        + currentPage
        + ", recordCount="
        + recordCount
        + ", sortOrder='"
        + sortOrder
        + '\''
        + '}';
  }
}
