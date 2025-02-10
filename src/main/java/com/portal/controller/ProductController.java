package com.portal.controller;

import com.github.pagehelper.PageInfo;
import com.portal.common.ServerResponse;
import com.portal.dao.ProductMapper;
import com.portal.pojo.Product;
import com.portal.service.IProductService;
import com.portal.vo.ProductDetailVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import static net.sf.jsqlparser.parser.feature.Feature.orderBy;

/**
 * @Author: tina.huanght
 * @Date: 10/02/25 14:50
 */
@Controller
@RequestMapping("/product/")
public class ProductController {

    @Autowired
    private IProductService iProductService;

    @RequestMapping(value = "detail.do", method = RequestMethod.GET)
    @ResponseBody
    public ServerResponse<ProductDetailVo> detail(Integer productId) {
        return iProductService.getProductDetail(productId);
    }

    @RequestMapping(value = "search.do", method = RequestMethod.GET)
    @ResponseBody
    public ServerResponse<PageInfo> list(@RequestParam(value = "pageNum",defaultValue = "1") int pageNum,
                                         @RequestParam(value = "pageSize",defaultValue = "10") int pageSize,
                                         @RequestParam(value ="keyword", required = false) String keyword,
                                         @RequestParam(value ="categoryId", required = false) Integer categoryId,
                                         @RequestParam(value ="orderBy", required = false) String orderBy
                                         ){
        return iProductService.getProductByKeywordCategory(keyword,categoryId,pageNum,pageSize,orderBy);
    }
}
