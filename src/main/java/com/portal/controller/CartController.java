package com.portal.controller;

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

    @RequestMapping(value = "add.do")
    @ResponseBody
    public ServerResponse add(@RequestParam (value = "userId") Integer userId,
                              @RequestParam (value = "productId") Integer productId,
                              @RequestParam (value = "count") Integer count){
        //需要用户登陆
        return iCartService.add(userId, productId, count);
    }


    @RequestMapping(value = "update.do")
    @ResponseBody
    public ServerResponse update(@RequestParam (value = "userId") Integer userId,
                                 @RequestParam (value = "productId") Integer productId,
                                 @RequestParam(value = "count") Integer count){
        return iCartService.update(userId, productId, count);
    }
}
