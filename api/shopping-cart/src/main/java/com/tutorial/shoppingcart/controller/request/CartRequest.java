package com.tutorial.shoppingcart.controller.request;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.tutorial.shoppingcart.controller.common.BasePaginator;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.Collection;

@NoArgsConstructor
@JsonIgnoreProperties
@Setter
@Getter
public class CartRequest extends BasePaginator {
    Collection<Long> productIds;
    BigDecimal totalPrice;
    Long productQuantity;
}
