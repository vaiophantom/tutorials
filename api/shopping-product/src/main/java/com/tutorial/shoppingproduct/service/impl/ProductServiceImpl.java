package com.tutorial.shoppingproduct.service.impl;

import com.tutorial.shoppingproduct.controller.common.ApiPagination;
import com.tutorial.shoppingproduct.controller.request.ProductRequest;
import com.tutorial.shoppingproduct.controller.response.ProductResponse;
import com.tutorial.shoppingproduct.model.Product;
import com.tutorial.shoppingproduct.model.ProductDetails;
import com.tutorial.shoppingproduct.repository.ProductRepository;
import com.tutorial.shoppingproduct.service.ProductService;
import com.tutorial.shoppingproduct.utils.Pagination;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Objects;

@Transactional
@Service
public class ProductServiceImpl implements ProductService {
    private static final Logger logger = LoggerFactory.getLogger(ProductServiceImpl.class);

    @Autowired
    private ProductRepository productRepository;

    @Value("${ProductPageSize}")
    private int pageSize;

    @Override
    public ProductResponse getAllProductByPage(int pageNo, Long productId) {
        ProductResponse productResponse = new ProductResponse();
        ApiPagination pagingInfo = new ApiPagination();
        ProductDetails productDetails = productRepository.getAllProductByPage(pageSize, pageNo, productId);

        int totalRecordCount = productDetails.getRecordCount();
        logger.info("pageSize: " + pageSize);
        logger.info("totalRecordCount: " + totalRecordCount);

        int numberOfPage = 0;

        if (pageSize != 0) {
            numberOfPage = (totalRecordCount + pageSize - 1) / pageSize;
        }

        pagingInfo.setPageCount(numberOfPage);
        pagingInfo.setPageSize(pageSize);
        pagingInfo.setCurrentPage(pageNo);
        pagingInfo.setRecordCount(totalRecordCount);
        productResponse.setPagingInfo(pagingInfo);
        productResponse.setProductList(productDetails.getProductList());
        return productResponse;
    }

    @Override
    public Pagination<ProductDetails> searchProducts(ProductRequest productRequest, Integer selectPage, Integer pageSize) {
        return productRepository.searchProducts(productRequest, selectPage, pageSize);
    }

    @Override
    public Product searchById(Long id) {
        if(Objects.isNull(id)) {
            throw new RuntimeException("Product ID could not be null.");
        }
        return productRepository.searchProductById(id);
    }
}
