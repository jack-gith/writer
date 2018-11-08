package com.winterchen.service.user.impl;

import com.winterchen.dao.OrderInfoDao;
import com.winterchen.dao.OrderPxDao;
import com.winterchen.model.OrderPxDomain;
import com.winterchen.service.user.OrderPxService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service(value = "OrderPxService")
public class OrderPxServiceImpl implements OrderPxService {

    @Autowired
    private OrderPxDao orderPxDao;

    @Autowired
    OrderInfoDao orderInfoDao;

    @Override
    public boolean insertPx(OrderPxDomain orderPxDomain) {
        if(orderPxDomain.getOrderID()==null || orderPxDomain.getOrderID()==""){
            throw new RuntimeException("订单id不能为空！");
        }else if(orderPxDomain.getScore()==0){
            throw new RuntimeException("评分不能为空！");
        }
        int effectNum = orderPxDao.insert(orderPxDomain);
        String orderID = orderPxDomain.getOrderID();
        if(effectNum>0){
            int updateStatus = orderInfoDao.updatEvaluate(orderID);
            if(updateStatus>0){
                return  true;
            }else{
                throw new RuntimeException("评分失败！");
            }

        }else{
            throw new RuntimeException("评分失败！");
        }
//        return false;
    }
}
