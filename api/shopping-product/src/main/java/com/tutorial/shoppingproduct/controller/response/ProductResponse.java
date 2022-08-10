package com.tutorial.shoppingproduct.controller.response;

import com.tutorial.shoppingproduct.controller.common.ApiPagination;
import com.tutorial.shoppingproduct.model.Product;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.List;

@Setter
@Getter
public class ProductResponse implements Serializable {
    private ApiPagination pagingInfo;
    private List<Product> productList;

}
