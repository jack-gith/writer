package com.winterchen.service.user.impl;

import com.winterchen.dao.ProportionDao;
import com.winterchen.model.ProportionDomain;
import com.winterchen.service.user.ProportionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProportionServiceImpl implements ProportionService {
    @Autowired
    ProportionDao proportionDao;

    @Override
    public boolean update(ProportionDomain proportionDomain) {
        int effNum = proportionDao.update(proportionDomain);
        if(effNum>0){
            return  true;
        }else{
            throw new RuntimeException("分配失败");
        }
    }

    @Override
    public ProportionDomain list() {
        return proportionDao.list();
    }
}
