package com.tutorial.shoppingproduct.model;

import com.tutorial.shoppingproduct.model.base.BaseModel;
import org.junit.jupiter.api.Test;
import org.springframework.util.Assert;

import java.math.BigDecimal;
import java.util.HashSet;

public class ModelTest {

    @Test
    public void testModel(){
        Branch branch = new Branch();
        branch.setId(1l);
        branch.getId();
        branch.setName("");
        branch.getName();
        branch.setProduct(new HashSet<>());
        branch.getProduct();
        branch.toString();

        Category category = new Category();
        category.setId(1l);
        category.getId();
        category.setName("");
        category.getName();
        category.setProduct(new HashSet<>());
        category.getProduct();
        category.toString();


        Product product = new Product();
        product.setId(1l);
        product.getId();
        product.setName("");
        product.getName();
        product.setDescription("");
        product.getDescription();
        product.setPrice(BigDecimal.valueOf(1l));
        product.getPrice();
        product.setColor("");
        product.getColor();
        product.setCategory(category);
        product.getCategory();
        product.setBranch(branch);
        product.getBranch();
        product.equals(new Product());
        product.hashCode();
        product.toString();

        BaseModel baseModel = new BaseModel();
        baseModel.setCreatedDatetime(1l);
        baseModel.getCreatedDatetime();
        baseModel.setCreatedBy(1l);
        baseModel.getCreatedBy();
        baseModel.setUpdatedDatetime(1l);
        baseModel.getUpdatedDatetime();
        baseModel.setUpdatedBy(1l);
        baseModel.getUpdatedBy();
        Assert.notNull(product,"");
    }

}
