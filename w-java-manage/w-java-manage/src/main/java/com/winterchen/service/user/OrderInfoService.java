package com.winterchen.service.user;

import com.github.pagehelper.PageInfo;
import com.winterchen.model.OrderInfoDomain;
import com.winterchen.model.RoleDomain;

import java.util.List;

public interface OrderInfoService {

    boolean insertInfo(OrderInfoDomain orderInfoDomain);

    Object getOrder(String openid,String creatTime);

    Object getOderDetail(String orderID);

    boolean close(String orderID);

    boolean returno(String orderID,int status,int orderPool);

    boolean fpTeacher(String fpopenid,String orderID);

    boolean robOrder(String orderID,String team);

    int getMoney(String openid);

    boolean confirm(String openid,String orderID) throws Exception;

    Double getUserStatisticsBalance(String openid) throws Exception;



    int getStatus(String team,int status);
    int getStatus7();

    Object user_total(String openid);

    Object agent_total(String openid);

    List<RoleDomain> teachList(String team);

    PageInfo<OrderInfoDomain> selectAll(int pageNum, int pageSize, int status,String openid,String team,int thasfp,String fpopenid);
}
