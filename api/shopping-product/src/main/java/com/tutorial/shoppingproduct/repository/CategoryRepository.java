package com.tutorial.shoppingproduct.repository;

import com.tutorial.shoppingproduct.model.Category;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CategoryRepository {
    List<Category> listAllCategoryByPage(int pageSize, int pageNo);
}
