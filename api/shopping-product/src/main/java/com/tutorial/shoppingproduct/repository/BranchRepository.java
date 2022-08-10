package com.tutorial.shoppingproduct.repository;

import com.tutorial.shoppingproduct.model.Branch;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BranchRepository {
    List<Branch> listAllBranchByPage(int pageSize, int pageNo);
}
