package com.tutorial.shoppingproduct.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.tutorial.shoppingproduct.model.base.BaseModel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Objects;

@Entity
@Table(name = "PRODUCT")
@Getter
@Setter
@NoArgsConstructor
public class Product extends BaseModel implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "native")
    @GenericGenerator(name = "native", strategy = "native")
    private Long id;

    @Column
    private String name;

    @Column
    private String description;

    @Column
    private BigDecimal price;

    @Column
    private String color;

    @ManyToOne(fetch = FetchType.EAGER)
    @JsonIgnore
    private Category category;

    @ManyToOne(fetch = FetchType.EAGER)
    @JsonIgnore
    private Branch branch;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Product product = (Product) o;
        return Objects.equals(id, product.id) && Objects.equals(name, product.name) && Objects.equals(price, product.price) && Objects.equals(category, product.category);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, price, category);
    }

    @Override
    public String toString() {
        return "Product{" +
                "productId=" + id +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", color='" + color + '\'' +
                ", price=" + price +
                ", category=" + category +
                ", branch=" + branch +
                '}';
    }
}
