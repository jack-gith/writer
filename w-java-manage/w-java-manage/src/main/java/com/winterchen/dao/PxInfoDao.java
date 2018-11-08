package com.winterchen.dao;

import org.apache.ibatis.annotations.Param;

public interface PxInfoDao {

    Object selectAll(@Param("orderID") String orderID);
}
