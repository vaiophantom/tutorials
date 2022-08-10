package com.tutorial.shoppingproduct.controller.request;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.tutorial.shoppingproduct.controller.common.BasePaginator;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.util.StringUtils;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

@Getter
@Setter
@NoArgsConstructor
@JsonIgnoreProperties({"queryConditions", "queryParams"})
public class ProductRequest extends BasePaginator {
    String category;
    String name;
    BigDecimal price;
    String branch;
    String color;


    private static final String WHERE_SQL = " WHERE p.status = 1";
    private static final String CATEGORY_CONDITION = " AND p.category.name LIKE LOWER(:category)";
    private static final String NAME_CONDITION = " AND p.name LIKE LOWER(:name)";
    private static final String BRANCH_CONDITION = " AND p.branch.name LIKE LOWER(:branch)";
    private static final String COLOR_CONDITION = " AND p.color = :color";
    private static final String PRICE_CONDITION = " AND p.price = :price";

    @JsonIgnore
    protected StringBuilder queryConditions;
    @JsonIgnore
    protected Map<String, Object> queryParams;

    public void buildQuery() {
        if (Objects.nonNull(this.queryConditions) && Objects.nonNull(this.queryParams)) {
            return;
        }
        queryConditions = new StringBuilder(WHERE_SQL);
        queryParams = new HashMap<>();

        if (StringUtils.hasText(category)) {
            queryConditions.append(CATEGORY_CONDITION);
            queryParams.put("category", "%" + category + "%");
        }
        if (StringUtils.hasText(name)) {
            queryConditions.append(NAME_CONDITION);
            queryParams.put("name", "%" + name + "%");
        }
        if (StringUtils.hasText(branch)) {
            queryConditions.append(BRANCH_CONDITION);
            queryParams.put("branch", "%" + this.getBranch() + "%");
        }
        if (StringUtils.hasText(color)) {
            queryConditions.append(COLOR_CONDITION);
            queryParams.put("color", color);
        }
        if (Objects.nonNull(price)) {
            queryConditions.append(PRICE_CONDITION);
            queryParams.put("price", price);
        }
    }
}
