package com.tutorial.shoppingproduct.controller.response;


import com.tutorial.shoppingproduct.controller.common.ApiPagination;

public class ApiPaginationResponse extends ApiResponse {
  private ApiPagination pagination;

  public ApiPaginationResponse() {
    pagination = new ApiPagination();
  }

  public ApiPaginationResponse(ApiPagination pagination) {
    this.pagination = pagination;
  }

  public ApiPagination getPagination() {
    return pagination;
  }

  public void setPagination(ApiPagination pagination) {
    this.pagination = pagination;
  }
}
