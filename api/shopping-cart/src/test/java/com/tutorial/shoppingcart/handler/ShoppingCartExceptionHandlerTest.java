package com.tutorial.shoppingcart.handler;


import com.tutorial.shoppingcart.exception.ShoppingCartApplicationException;
import com.tutorial.shoppingcart.exception.ShoppingCartSystemException;
import org.junit.Assert;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentMatchers;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;
import org.mockito.Spy;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.web.context.request.WebRequest;

import static org.mockito.Mockito.mock;

@RunWith(MockitoJUnitRunner.class)
public class ShoppingCartExceptionHandlerTest {

    @Spy @InjectMocks
    ShoppingCartExceptionHandler shoppingCartExceptionHandler;

    @BeforeEach
    public void init(){
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void test(){
        ShoppingCartSystemException exception = new ShoppingCartSystemException("as");
        ShoppingCartApplicationException exception1 = new ShoppingCartApplicationException("ex");
        WebRequest request = mock(WebRequest.class);
        Assert.assertNotNull(shoppingCartExceptionHandler.handlCartSystemException(
                exception, request));
        Assert.assertNotNull(shoppingCartExceptionHandler.handleCartApplicationException(
                exception1,request));
        Assert.assertNotNull(shoppingCartExceptionHandler.handleAllExceptions(
                exception,request
        ));
    }
}
