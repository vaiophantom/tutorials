package com.tutorial.shoppingcart.model;

import com.tutorial.shoppingcart.model.base.BaseModel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;

@Entity
@Table(name = "CART")
@Getter
@Setter
@NoArgsConstructor
public class Cart extends BaseModel implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "native")
    @GenericGenerator(name = "native", strategy = "native")
    private Long id;

    @Column(name = "product_ids")
    private String productIds;

    @Column(name = "total_price")
    private BigDecimal totalPrice;

    @Column(name = "product_quantity")
    private Integer productQuantity;

    public Cart(String productIds, Integer productQuantity, BigDecimal totalPrice) {
        this.productIds = productIds;
        this.productQuantity = productQuantity;
        this.totalPrice = totalPrice;
    }
}
