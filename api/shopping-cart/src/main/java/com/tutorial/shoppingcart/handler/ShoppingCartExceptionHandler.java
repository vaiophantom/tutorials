package com.tutorial.shoppingcart.handler;

import com.tutorial.shoppingcart.controller.response.ApiResponseConstants;
import com.tutorial.shoppingcart.controller.response.ApiResponseStatus;
import com.tutorial.shoppingcart.controller.response.CartErrorResponse;
import com.tutorial.shoppingcart.exception.ShoppingCartApplicationException;
import com.tutorial.shoppingcart.exception.ShoppingCartSystemException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.lang.invoke.MethodHandles;

public class ShoppingCartExceptionHandler extends ResponseEntityExceptionHandler {
    private static final Logger logger =
            LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());

    @ExceptionHandler
    public final ResponseEntity<CartErrorResponse> handleAllExceptions(
            Exception ex, WebRequest webRequest) {
        logger.error(ex.getMessage(), ex);
        CartErrorResponse spErrorResponse =
                new CartErrorResponse(ApiResponseConstants.INTERNAL_SERVER_ERROR_MESSAGE);
        return new ResponseEntity<>(spErrorResponse, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler
    public final ResponseEntity<CartErrorResponse> handlCartSystemException(
            ShoppingCartSystemException ex, WebRequest webRequest) {
        logger.error(ex.getMessage(), ex);
        ApiResponseStatus errorStatus =
                new ApiResponseStatus(ApiResponseConstants.SYSTEM_EXCEPTION_ERROR_CODE, ex.getLocalizedMessage());
        CartErrorResponse spErrorResponse = new CartErrorResponse(errorStatus);
        return new ResponseEntity<>(spErrorResponse, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler
    public final ResponseEntity<CartErrorResponse> handleCartApplicationException(
            ShoppingCartApplicationException ex, WebRequest webRequest) {
        logger.error(ex.getMessage(), ex);
        ApiResponseStatus errorStatus =
                new ApiResponseStatus(
                        ApiResponseConstants.APPLICATION_EXCEPTION_ERROR_CODE, ex.getMessage());
        CartErrorResponse spErrorResponse = new CartErrorResponse(errorStatus);
        return new ResponseEntity<>(spErrorResponse, HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
