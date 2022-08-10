package com.tutorial.shoppingcart.controller.response;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.*;

import java.util.List;

@Getter
@Setter
public class CartErrorResponse {
    private ApiResponseStatus status;
    private List<String> detailsList;

    public CartErrorResponse(ApiResponseStatus status) {
        this.status = status;
    }
}
