package com.tutorial.shoppingcart.model.base;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;

@Getter
@Setter
@MappedSuperclass
public class BaseModel {
    @Column
    private Long createdDatetime;

    @Column
    private Long createdBy;

    @Column
    private Long updatedDatetime;

    @Column
    private Long updatedBy;

    @Column
    private Boolean status = false;
}
