package com.winterchen.service.user.impl;

import com.winterchen.dao.OrderDetailDao;
import com.winterchen.model.dto.OrderDetailDto;
import com.winterchen.service.user.OrderDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service(value = "OrderDetailService")
public class OrderDetailServiceImpl implements OrderDetailService {

    @Autowired
    private OrderDetailDao orderDetailDao;

    @Override
    public Object showOne(String openid,String orderID) {
        return orderDetailDao.show(openid,orderID);
    }

}
