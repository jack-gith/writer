package com.winterchen.dao;

import com.winterchen.model.dto.OrderDetailDto;
import org.apache.ibatis.annotations.Param;

public interface OrderDetailDao {

    Object show(@Param("openid") String openid,@Param("orderID") String orderID);
}
