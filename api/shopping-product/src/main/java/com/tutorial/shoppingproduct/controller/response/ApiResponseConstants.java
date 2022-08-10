package com.tutorial.shoppingproduct.controller.response;

public final class ApiResponseConstants {

  private ApiResponseConstants() {
    // No arg constructor.
  }

  public static final ApiResponseStatus SUCCESS = new ApiResponseStatus("000000", "Success");

  public static final ApiResponseStatus RECORD_NOT_FOUND_ERROR_MESSAGE =
      new ApiResponseStatus("000216", "No record available.");
  public static final ApiResponseStatus INTERNAL_SERVER_ERROR_MESSAGE =
      new ApiResponseStatus("000540", "An internal error occurred");

  public static final String SYSTEM_EXCEPTION_ERROR_CODE = "000542";
  public static final String SYSTEM_EXCEPTION_ERROR_MESSAGE = "System Exception Occurred";
  public static final String APPLICATION_EXCEPTION_ERROR_CODE = "000543";
  public static final String APPLICATION_EXCEPTION_ERROR_MESSAGE =
      "Application Exception Occurred";
}
