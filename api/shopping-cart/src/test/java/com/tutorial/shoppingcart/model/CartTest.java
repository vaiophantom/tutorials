package com.tutorial.shoppingcart.model;

import com.tutorial.shoppingcart.model.Cart;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;

import java.math.BigDecimal;

@RunWith(MockitoJUnitRunner.class)
public class CartTest {

    @Test
    public void test(){
        Cart cart = new Cart("A",1,BigDecimal.ZERO);
        cart.setId(12L);
        cart.setTotalPrice(BigDecimal.ZERO);
        cart.setProductQuantity(1);
        cart.setProductIds("a");
        cart.setCreatedBy(12L);
        cart.setCreatedDatetime(12L);
        cart.setStatus(true);
        cart.setUpdatedBy(12L);
        cart.setUpdatedDatetime(12L);
        Assert.assertNotNull(cart.getId());
        Assert.assertNotNull(cart.getTotalPrice());
        Assert.assertNotNull(cart.getProductQuantity());
        Assert.assertNotNull(cart.getProductIds());
        Assert.assertNotNull(cart.getCreatedBy());
        Assert.assertNotNull(cart.getCreatedDatetime());
        Assert.assertNotNull(cart.getStatus());
        Assert.assertNotNull(cart.getUpdatedBy());
        Assert.assertNotNull(cart.getUpdatedDatetime());
    }
}
