package com.tutorial.shoppingcart.controller;

import com.tutorial.shoppingcart.controller.request.CartRequest;
import com.tutorial.shoppingcart.model.Cart;
import com.tutorial.shoppingcart.service.CartService;
import com.tutorial.shoppingcart.service.impl.CartServiceImpl;
import org.junit.Assert;
import org.junit.Before;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.*;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Optional;

@RunWith(MockitoJUnitRunner.class)
public class CartControllerTest {

    @Spy @InjectMocks CartController cartController;

    @Mock
    CartServiceImpl cartService;

    List<Cart> cartList = new ArrayList<>();
    @BeforeEach
    public void init(){
        MockitoAnnotations.openMocks(this);
        Cart cart = new Cart();
        cart.setProductIds("123");
        cart.setProductQuantity(1);
        cart.setTotalPrice(BigDecimal.ZERO);
        cartList.add(cart);

    }

    @Test
    public void searchAll_test(){
        Mockito.doReturn(cartList).when(cartService).searchAll();
        Assert.assertNotNull(cartController.searchAll());
    }

    @Test
    public void addToCart_test(){
        Collection<Long> collection = new ArrayList<>();
        collection.add(12L);
        CartRequest cartRequest = new CartRequest();
        cartRequest.setProductIds(collection);
        cartRequest.setTotalPrice(BigDecimal.ZERO);
        cartRequest.setProductQuantity(13L);
        Mockito.doNothing().when(cartService).addToCard(collection,BigDecimal.ZERO);
        Assert.assertNotNull(cartController.addToCart(cartRequest));
        Assert.assertNotNull(cartRequest.getProductQuantity());
    }

    @Test
    public void searchDetail_test(){
        Cart cart = new Cart();
        cart.setId(1L);
        Mockito.doReturn(cart).when(cartService).searchById(1L);
        Assert.assertNotNull(cartController.searchDetail(1L));
    }
}
