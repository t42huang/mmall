package com.portal.controller;

import com.portal.common.ServerResponse;
import com.portal.pojo.Shipping;
import com.portal.service.IShippingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @Author: tina.huanght
 * @Date: 13/02/25 17:52
 */
@Controller
public class ShippingController {

    @Autowired
    private IShippingService iShippingService;

    @RequestMapping(value = "add_shipping.do")
    @ResponseBody
    public ServerResponse addShipping(Integer userId, Shipping shipping){
        return iShippingService.addShipping(userId, shipping);
    }

    @RequestMapping(value = "del_shipping.do")
    @ResponseBody
    public ServerResponse delShipping(Integer userId, Integer shippingId){
        return iShippingService.delShipping(userId, shippingId);
    }

    @RequestMapping(value = "update_shipping.do")
    @ResponseBody
    public ServerResponse updateShipping(Integer userId, Shipping shipping){
        return iShippingService.updateShipping(userId, shipping);
    }

    @RequestMapping(value = "select_shipping.do")
    @ResponseBody
    public ServerResponse<Shipping> getShipping(Integer userId, Integer shippingId){
        return iShippingService.getShippingList(userId, shippingId);
    }

    @RequestMapping(value = "list_shipping.do")
    @ResponseBody
    public ServerResponse list(@RequestParam(value = "pageNum", defaultValue = "1") Integer pageNum,
                               @RequestParam(value = "pageSize", defaultValue = "10") Integer pageSize,
                               @RequestParam(value = "userId", defaultValue = "") Integer userId){
        return iShippingService.list(userId, pageNum, pageSize);
    }

}
