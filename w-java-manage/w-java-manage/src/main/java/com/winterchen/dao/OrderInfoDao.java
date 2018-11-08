package com.winterchen.dao;

import com.winterchen.model.OrderInfoDomain;
import com.winterchen.model.RoleDomain;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface OrderInfoDao {

    int insertData(OrderInfoDomain orderInfoDomain);

    Object findOne(@Param("openid") String openid,@Param("creatTime") String creatTime);

    Object orderDetail(@Param("orderID") String orderID);

    int closeOrder(@Param("orderID") String orderID);

    int updatEvaluate(String orderID);

    int returnOrder(@Param("orderID") String orderID,@Param("status") int status,@Param("orderPool") int orderPool);

    int fpTeacher(@Param("fpopenid") String fpopenid,@Param("orderID") String orderID);


    int robOrder(@Param("orderID") String orderID,@Param("team") String  team);

    int getStatus(@Param("team") String team,@Param("status") int status);
    int getStatus7();

    int user_num(@Param("openid") String openid);
    int user_money(@Param("openid") String openid);
    int getIntegral(@Param("openid") String openid);

    int getMoney(@Param("openid") String openid);

    int confirmOrder(@Param("orderID") String orderID,@Param("openid") String  openid);


    List<RoleDomain> getTeacher(@Param("team") String team);

//    移动端获取订单列表
    List<OrderInfoDomain> getAllOrderList(OrderInfoDomain orderInfoDomain);
}
