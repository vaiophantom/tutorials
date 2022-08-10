package com.tutorial.shoppingproduct.model;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;

@Entity
@Table(name = "BRANCH")
@Getter
@Setter
public class Branch implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "native")
    @GenericGenerator(name = "native", strategy = "native")
    private Long id;

    @Column
    private String name;

    @OneToMany(
            mappedBy = "branch",
            cascade = CascadeType.PERSIST,
            fetch = FetchType.LAZY,
            orphanRemoval = true
    )
    private Set<Product> product;

    @Override
    public String toString() {
        return "Branch{" +
                "branchId=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
