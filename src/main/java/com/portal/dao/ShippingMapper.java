package com.portal.dao;

import com.portal.pojo.Shipping;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ShippingMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Shipping record);

    int insertSelective(Shipping record);

    Shipping selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Shipping record);

    int updateByPrimaryKey(Shipping record);

    int deleteByShippingIdAndUserId(@Param("shippingId") Integer shippingId,
                                    @Param("userId") Integer userId);
    int updateByshipping(Shipping record);

    Shipping selectByShippingIdAndUserId(@Param("userId")Integer userId,
                                    @Param("shippingId") Integer shippingId);

    List<Shipping> selectShippingByUserId(Integer userId);
}