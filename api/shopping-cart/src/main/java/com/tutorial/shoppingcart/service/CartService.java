package com.tutorial.shoppingcart.service;

import com.tutorial.shoppingcart.model.Cart;

import java.math.BigDecimal;
import java.util.Collection;
import java.util.List;

public interface CartService {
    List<Cart> searchAll();

    void addToCard(Collection<Long> productIds, BigDecimal totalPrice);

    Cart searchById(Long cartId);
}
