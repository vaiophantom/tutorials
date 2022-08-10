package com.tutorial.shoppingproduct.controller.response;

public class ApiResponse {
  private ApiResponseStatus status;
  private Object data;

  public ApiResponse(Object data, ApiResponseStatus status) {
    this.status = status;
    this.data = data;
  }

  public ApiResponse() {
    status = ApiResponseConstants.SUCCESS;
    data = "";
  }

  public ApiResponse(Object data) {
    status = ApiResponseConstants.SUCCESS;
    this.data = data;
  }

  public Object getData() {
    return data;
  }

  public void setData(Object data) {
    this.data = data;
  }

  public ApiResponseStatus getStatus() {
    return status;
  }

  public void setStatus(ApiResponseStatus status) {
    this.status = status;
  }
}
