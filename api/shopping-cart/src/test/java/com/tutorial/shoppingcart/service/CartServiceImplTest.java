package com.tutorial.shoppingcart.service;


import com.tutorial.shoppingcart.exception.ShoppingCartApplicationException;
import com.tutorial.shoppingcart.model.Cart;
import com.tutorial.shoppingcart.repository.CartRepository;
import com.tutorial.shoppingcart.service.impl.CartServiceImpl;
import org.junit.Assert;
import org.junit.function.ThrowingRunnable;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.*;
import org.mockito.junit.MockitoJUnitRunner;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Optional;

@RunWith(MockitoJUnitRunner.class)
public class CartServiceImplTest {

    @Spy
    @InjectMocks
    CartServiceImpl cartService;

    @Mock
    CartRepository cartRepository;

    @BeforeEach
    public void init(){
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void searchAll_test(){
        List<Cart> list = new ArrayList<>();
        Cart cart = new Cart();
        list.add(cart);
        Mockito.doReturn(list).when(cartRepository).findAll();
        Assert.assertNotNull(cartService.searchAll());
    }

    @Test
    public void addToCard_test(){
        Cart cart = new Cart();
        Mockito.doReturn(cart).when(cartRepository).save(ArgumentMatchers.nullable(Cart.class));
        Collection<Long> collection = new ArrayList<>();
        collection.add(12L);
        cartService.addToCard(collection, BigDecimal.ZERO);

    }

    @Test
    public void searchById_test(){
        Cart cart = new Cart();
        Mockito.doReturn(Optional.of(cart)).when(cartRepository).findById(12L);
        Assert.assertNotNull(cartService.searchById(12L));
    }
}
