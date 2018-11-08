package com.winterchen.service.user.impl;

import com.winterchen.dao.PxInfoDao;
import com.winterchen.service.user.PxInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service(value = "PxInfoService")
public class PxInfoServiceImpl implements PxInfoService {

    @Autowired
    private PxInfoDao pxInfoDao;

    @Override
    public Object info(String orderID) {
        return pxInfoDao.selectAll(orderID);
    }
}
