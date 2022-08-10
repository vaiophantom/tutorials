package com.tutorial.shoppingcart.service.impl;

import com.tutorial.shoppingcart.exception.ShoppingCartApplicationException;
import com.tutorial.shoppingcart.model.Cart;
import com.tutorial.shoppingcart.repository.CartRepository;
import com.tutorial.shoppingcart.service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.math.BigDecimal;
import java.util.Collection;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Service
public class CartServiceImpl implements CartService {
    @Autowired
    private CartRepository cartRepository;

    @Override
    public List<Cart> searchAll() {
        return cartRepository.findAll();
    }

    @Override
    public void addToCard(Collection<Long> productIds, BigDecimal totalPrice) {
        if (CollectionUtils.isEmpty(productIds)) {
            return;
        }
        String strProductIds = productIds.stream()
                .map(Object::toString)
                .collect(Collectors.joining(","));
        cartRepository.save(new Cart(strProductIds, productIds.size(), totalPrice));
    }

    @Override
    public Cart searchById(Long cartId) {
        if(Objects.isNull(cartId)) {
            throw new ShoppingCartApplicationException("Cart ID could not be null.");
        }
        return cartRepository.findById(cartId).orElseThrow(() -> new ShoppingCartApplicationException("Cannot find any carts"));
    }
}
