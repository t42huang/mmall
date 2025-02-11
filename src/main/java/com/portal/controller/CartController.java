package com.portal.controller;

import com.portal.common.Const;
import com.portal.common.ServerResponse;
import com.portal.service.ICartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @Author: tina.huanght
 * @Date: 11/02/25 10:22
 */
@Controller
@RequestMapping(value = "/cart/")
public class CartController {

    @Autowired
    private ICartService iCartService;

    @RequestMapping(value = "list_product.do")
    @ResponseBody
    public ServerResponse getProduct(@RequestParam(value = "userId") Integer userId) {
        return iCartService.list(userId);
    }

    @RequestMapping(value = "add.do")
    @ResponseBody
    public ServerResponse addProduct(@RequestParam(value = "userId") Integer userId,
                                     @RequestParam(value = "productId") Integer productId,
                                     @RequestParam(value = "count") Integer count) {
        //需要用户登陆
        return iCartService.add(userId, productId, count);
    }


    @RequestMapping(value = "update.do")
    @ResponseBody
    public ServerResponse updateProduct(@RequestParam(value = "userId") Integer userId,
                                        @RequestParam(value = "productId") Integer productId,
                                        @RequestParam(value = "count") Integer count) {
        return iCartService.update(userId, productId, count);
    }

    @RequestMapping(value = "delete_product.do")
    @ResponseBody
    public ServerResponse deleteProduct(@RequestParam(value = "userId") Integer userId,
                                        @RequestParam(value = "productIds") String productIds) {
        return iCartService.delete(userId, productIds);
    }

    //全选
    @RequestMapping(value = "select_product.do")
    @ResponseBody
    public ServerResponse selectAll(@RequestParam(value = "userId") Integer userId) {
        return iCartService.selectOrUnSelect(userId, null, Const.Cart.CHECKED);
    }

    //全反选
    @RequestMapping(value = "unSelect_product.do")
    @ResponseBody
    public ServerResponse unSelectAll(@RequestParam(value = "userId") Integer userId) {
        return iCartService.selectOrUnSelect(userId, null, Const.Cart.UN_CHECKED);
    }

    //dandu
    @RequestMapping(value = "unSelect_product.do")
    @ResponseBody
    public ServerResponse select(@RequestParam(value = "userId") Integer userId,
                                 Integer productId) {
        return iCartService.selectOrUnSelect(userId, productId, Const.Cart.CHECKED);
    }

    //单独反选
    @RequestMapping(value = "unSelect_product.do")
    @ResponseBody
    public ServerResponse unSelect(@RequestParam(value = "userId") Integer userId,
                                   Integer productId) {
        return iCartService.selectOrUnSelect(userId, productId, Const.Cart.UN_CHECKED);
    }

    //查询当前用户的购物车里面的产品数量，如果一个产品有10个，那么数量就是10

}
