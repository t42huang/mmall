package com.portal.service;

import com.portal.common.ServerResponse;
import com.portal.vo.CartVo;

/**
 * @Author: tina.huanght
 * @Date: 11/02/25 10:24
 */
public interface ICartService {
    ServerResponse add(Integer userId, Integer productId, Integer count);
    ServerResponse<CartVo> update(Integer userId, Integer productId, Integer count);
    ServerResponse<CartVo> delete(Integer userId, String productIds);
}
