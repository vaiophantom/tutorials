package com.tutorial.shoppingcart.controller.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class ApiResponseStatus {
    private String code;
    private String message;
}
