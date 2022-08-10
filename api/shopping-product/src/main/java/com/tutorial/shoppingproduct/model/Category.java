package com.tutorial.shoppingproduct.model;

import com.tutorial.shoppingproduct.model.base.BaseModel;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;

@Entity
@Table(name = "CATEGORY")
@Getter
@Setter
public class Category extends BaseModel implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "native")
    @GenericGenerator(name = "native", strategy = "native")
    private Long id;

    @Column
    private String name;

    @OneToMany(
            mappedBy = "category",
            cascade = CascadeType.PERSIST,
            fetch = FetchType.LAZY,
            orphanRemoval = true
    )
    private Set<Product> product;

    @Override
    public String toString() {
        return "Category{" +
                "categoryId=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
