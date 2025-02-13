package com.portal.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.google.common.collect.Maps;
import com.portal.common.ServerResponse;
import com.portal.dao.ShippingMapper;
import com.portal.pojo.Shipping;
import com.portal.service.IShippingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * @Author: tina.huanght
 * @Date: 13/02/25 17:53
 */
@Service("iShippingService")
public class ShippingServiceImpl implements IShippingService {

    @Autowired
    private ShippingMapper shippingMapper;

    public ServerResponse addShipping(Integer userId, Shipping shipping){
        shipping.setUserId(userId);
        int rowCount = shippingMapper.insert(shipping);
        if (rowCount > 0){
            Map result = Maps.newHashMap();
            result.put("shippingId", shipping.getId());
            return ServerResponse.createBySuccess("新建地址成功", result);
        }
        return ServerResponse.createByErrorMessage("新建地址失败");
    }

    public ServerResponse delShipping(Integer userId, Integer shippingId){
        int rowCount = shippingMapper.deleteByShippingIdAndUserId(userId, shippingId);
        if(rowCount > 0){
            return ServerResponse.createBySuccess("删除成功");
        }
        return ServerResponse.createByErrorMessage("删除失败" + shippingId);
    }

    public ServerResponse updateShipping(Integer userId, Shipping shipping){
        shipping.setUserId(userId);
        int rowCount = shippingMapper.updateByshipping(shipping);
        if(rowCount > 0){
            return ServerResponse.createBySuccess("update成功");
        }
        return ServerResponse.createByErrorMessage("update failed" );
    }

    public ServerResponse<Shipping> getShippingList(Integer userId, Integer shippingId){
        Shipping shipping = shippingMapper.selectByShippingIdAndUserId(userId, shippingId);
        if(shipping == null){
            return ServerResponse.createByErrorMessage("查询失败");
        }

        return ServerResponse.createBySuccess("查询成功", shipping);
    }

    public ServerResponse<PageInfo> list(Integer userId, Integer pageNum, Integer pageSize){
        PageHelper.startPage(pageNum, pageSize);
        //查询所有的地址
        List<Shipping> shippingList = shippingMapper.selectShippingByUserId(userId);
        if (shippingList == null){
            return ServerResponse.createByErrorMessage("查询失败");
        }
        PageInfo pageInfo = new PageInfo(shippingList);
        return ServerResponse.createBySuccess("查询成功", pageInfo);
    }
}
