package com.winterchen.dao;

import com.winterchen.model.dto.OrderManageDto;
import org.apache.ibatis.annotations.Param;


import java.util.List;

public interface OrderManageDao {
    List<OrderManageDto> select(OrderManageDto orderManageDto);
    List<OrderManageDto> select7(OrderManageDto orderManageDto);

    Object getTeacherInfo(@Param("openid") String openid);


}
