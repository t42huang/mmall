package com.portal.service;

import com.portal.common.ServerResponse;
import com.portal.pojo.Shipping;

/**
 * @Author: tina.huanght
 * @Date: 13/02/25 17:53
 */
public interface IShippingService {
    ServerResponse addShipping(Integer userId, Shipping shipping);

    ServerResponse delShipping(Integer userId, Integer shippingId);

    ServerResponse updateShipping(Integer userId, Shipping shipping);

    ServerResponse getShippingList(Integer userId, Integer shippingId);

    ServerResponse list(Integer userId, Integer pageNum, Integer pageSize);
}
