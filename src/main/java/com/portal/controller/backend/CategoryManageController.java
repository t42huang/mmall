package com.portal.controller.backend;

import com.portal.common.ServerResponse;
import com.portal.service.ICategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @Author: tina.huanght
 * @Date: 08/02/25 10:14
 */

@Controller
@RequestMapping("/manage/category")
public class CategoryManageController {

    @Autowired
    private ICategoryService iCategoryService;

    @RequestMapping(value = "add_category.do", method = RequestMethod.POST)
    @ResponseBody //是返回值使用jackson的序列化
    public ServerResponse addCategory(String categoryName, @RequestParam(value = "parentId", defaultValue = "0") int parentId) {
        // TODO 可以判断 user 是否login
        // TODO 判断user 是不是admin
        if (parentId == 0) {
            return ServerResponse.createByErrorMessage("parentId is null");
        }
        return iCategoryService.addCategory(categoryName, parentId);
//        return ServerResponse.createBySuccessMessage("success");
    }

    @RequestMapping(value = "set_category_name.do", method = RequestMethod.POST)
    @ResponseBody
    public ServerResponse setCategoryName(Integer categoryId, String categoryName) {
        // todo 判断user是否登陆，是都是admin
        return iCategoryService.updateCategoryName(categoryId, categoryName);
    }

    @RequestMapping(value = "get_category.do", method = RequestMethod.GET)
    @ResponseBody
    public ServerResponse getChildrenParallelCategory(@RequestParam(value = "categoryId", defaultValue = "0")
                                                      Integer categoryId) {
        // todo 判断user是否登陆，是都是admin
        return iCategoryService.getChildrenParallelCategory(categoryId); //查询子节点，不递归，保持平级

    }

    @RequestMapping(value = "get_deep_children_category.do", method = RequestMethod.GET)
    @ResponseBody
    public ServerResponse getCategoryAndDeepChildrenCategory(Integer categoryId) {

        return iCategoryService.selectCategoryAndChildrenById(categoryId);
    }

}
