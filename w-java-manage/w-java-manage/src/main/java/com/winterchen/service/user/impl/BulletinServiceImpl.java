package com.winterchen.service.user.impl;


import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.winterchen.dao.BulletinDao;
import com.winterchen.model.Bulletin;
import com.winterchen.service.user.BulletinService;
import com.winterchen.util.StringUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Map;

@Service
public class BulletinServiceImpl implements BulletinService
{


    @Autowired
    private BulletinDao bulletinDao;

    @Override
    public PageInfo<Bulletin> getBulletinList(Map<String, Object> params) throws Exception {
        int pageNum = StringUtil.nullToInteger(params.get("pageNumber"));
        pageNum = pageNum == 0 ? 1 : pageNum;
        int pageSize = StringUtil.nullToInteger(params.get("pageSize"));
        pageSize = pageSize == 0 ? 10 : pageSize;
        PageHelper.startPage(pageNum, pageSize);
        // todo
        List<Bulletin> list = bulletinDao.getListPrmMapRtnBean(params);
        PageInfo<Bulletin> pageInfo = new PageInfo<Bulletin>(list);
        return pageInfo;
    }


    @Override
    public boolean addBulletin(Bulletin bulletin) throws Exception {
        bulletin.setCreateTime(new Date());
        return bulletinDao.getInsert(bulletin);
    }

    @Override
    public boolean updateBulletin(Bulletin bulletin) throws Exception {
        bulletin.setReplyTime(new Date());
        return bulletinDao.getUpdate(bulletin);
    }

    @Override
    public Object findBulletin(String bulletinNum) throws Exception {
        return bulletinDao.getBeanById(bulletinNum);
    }
}
