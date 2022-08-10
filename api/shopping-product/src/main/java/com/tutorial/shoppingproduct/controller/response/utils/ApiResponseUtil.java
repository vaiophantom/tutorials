package com.tutorial.shoppingproduct.controller.response.utils;

import com.tutorial.shoppingproduct.controller.common.ApiPagination;
import com.tutorial.shoppingproduct.controller.response.ApiPaginationResponse;
import com.tutorial.shoppingproduct.controller.response.ApiResponse;
import com.tutorial.shoppingproduct.controller.response.ApiResponseConstants;
import com.tutorial.shoppingproduct.controller.response.ApiResponseStatus;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

public final class ApiResponseUtil {

  private ApiResponseUtil() {}

  public static ResponseEntity<ApiResponse> successResponse(Object data) {
    return ResponseEntity.status(HttpStatus.OK).body(new ApiResponse(data));
  }

  public static ResponseEntity<ApiResponse> successResponse(Object data, ApiResponseStatus status) {
    return ResponseEntity.status(HttpStatus.OK).body(new ApiResponse(data, status));
  }

  public static ResponseEntity<ApiResponse> successResponseWithPagination(
      Object data, ApiPagination pagination) {
    ApiPaginationResponse apiPaginationResponse = new ApiPaginationResponse();
    apiPaginationResponse.setData(data);
    apiPaginationResponse.setPagination(pagination);
    apiPaginationResponse.setStatus(ApiResponseConstants.SUCCESS);
    return ResponseEntity.status(HttpStatus.OK).body(apiPaginationResponse);
  }
}
