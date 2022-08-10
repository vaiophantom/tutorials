package com.tutorial.shoppingcart.controller;

import com.tutorial.shoppingcart.controller.request.CartRequest;
import com.tutorial.shoppingcart.controller.response.ApiResponse;
import com.tutorial.shoppingcart.controller.response.utils.ApiResponseUtil;
import com.tutorial.shoppingcart.model.Cart;
import com.tutorial.shoppingcart.service.CartService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.lang.invoke.MethodHandles;
import java.util.List;

@RequestMapping("/cart")
@RestController
public class CartController {
    @Autowired
    private CartService cartService;

    private  static final Logger logger = LoggerFactory.getLogger((MethodHandles.lookup().lookupClass()));

    @PostMapping(value = "/add")
    public void addToCart(@RequestBody CartRequest cartRequest) {
        logger.info("CartController.addToCart: " + cartRequest.getProductIds());
        cartService.addToCard(cartRequest.getProductIds(), cartRequest.getTotalPrice());
    }

    @GetMapping("/search")
    public List<Cart> searchAll() {
        logger.info(
                "CartService.search");
        return cartService.searchAll();
    }

    @GetMapping("/search/{id}")
    public ResponseEntity<ApiResponse> searchDetail(@PathVariable Long id) {
        logger.info(
                "CartService.searchDetail: - id = " +id);
        return ApiResponseUtil.successResponse(cartService.searchById(id));
    }
}
