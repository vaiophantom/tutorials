package com.tutorial.shoppingproduct.repository.impl;

import com.tutorial.shoppingproduct.controller.request.ProductRequest;
import com.tutorial.shoppingproduct.model.Product;
import com.tutorial.shoppingproduct.model.ProductDetails;
import com.tutorial.shoppingproduct.repository.ProductRepository;
import com.tutorial.shoppingproduct.utils.Pagination;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;
import org.springframework.util.CollectionUtils;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.*;

@Repository
public class ProductRepositoryImpl implements ProductRepository {
    private static final Logger logger = LoggerFactory.getLogger(ProductRepositoryImpl.class);

    private static final String PRODUCT_RECORDS_SQL = "SELECT p FROM Product p";
    private static final String PRODUCT_RECORDS_COUNT_SQL = "SELECT COUNT(*) FROM Product p";

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public ProductDetails getAllProductByPage(int pageSize, int pageNo, Long productId) {
        return null;
    }

    @Override
    public Pagination<ProductDetails> searchProducts(ProductRequest productRequest, Integer selectPage, Integer pageSize) {
        productRequest.buildQuery();

        Long totalRecord = getProductsRecordCount(productRequest);

        Query query = entityManager.createQuery(PRODUCT_RECORDS_SQL + productRequest.getQueryConditions());

        if (!CollectionUtils.isEmpty(productRequest.getQueryParams())) {
            productRequest.getQueryParams().forEach((k, v) -> query.setParameter(k, v));
        }

        Pagination<ProductDetails> productDetailsPagination =
                new Pagination<>(totalRecord.intValue(), selectPage, pageSize);

        if (productDetailsPagination.getFromIndex() != 0) {
            query.setFirstResult(productDetailsPagination.getFromIndex());
        }
        if (productDetailsPagination.getPageSize() != 0) {
            query.setMaxResults(productDetailsPagination.getPageSize());
        }

        List<Product> productList =query.getResultList();
        logger.info("productList: " + productList);

        ProductDetails productDetails = new ProductDetails(productList.size(), productList);
        productDetailsPagination.getItems().add(productDetails);

        return productDetailsPagination;
    }

    private Long getProductsRecordCount(ProductRequest productRequest) {
        Query query = entityManager.createQuery(PRODUCT_RECORDS_COUNT_SQL + productRequest.getQueryConditions());
        if (!CollectionUtils.isEmpty(productRequest.getQueryParams())) {
            productRequest.getQueryParams().forEach((k, v) -> query.setParameter(k, v));
        }

        Long totalRecord = (long)query.getSingleResult();
        logger.info("totalRecords: " + totalRecord);
        return totalRecord;
    }
}
