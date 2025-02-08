package com.portal.service;

import com.portal.common.ServerResponse;
import com.portal.pojo.Category;

import java.util.List;

/**
 * @Author: tina.huanght
 * @Date: 08/02/25 10:20
 */
public interface ICategoryService {
    ServerResponse addCategory(String categoryName, Integer parentId);

    ServerResponse updateCategoryName(Integer categoryId, String categoryName);

    ServerResponse<List<Category>> getChildrenParallelCategory(Integer categoryId);

    ServerResponse selectCategoryAndChildrenById(Integer categoryId);
}
