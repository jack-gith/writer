package com.winterchen.service.user.impl;


import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.winterchen.dao.RoleDao;
import com.winterchen.dao.WithdrawDao;
import com.winterchen.model.RoleDomain;
import com.winterchen.model.Withdraw;
import com.winterchen.service.user.WithdrawService;
import com.winterchen.util.StringUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Map;

@Service
public class WithdrawServiceImpl implements WithdrawService
{


    @Autowired
    WithdrawDao withdrawDao;

    @Autowired
    RoleDao roleDao;

    @Override
    public PageInfo<Withdraw> getWithdrawList(Map<String, Object> params) throws Exception {
        int pageNum = StringUtil.nullToInteger(params.get("pageNumber"));
        pageNum = pageNum == 0 ? 1 : pageNum;
        int pageSize = StringUtil.nullToInteger(params.get("pageSize"));
        pageSize = pageSize == 0 ? 10 : pageSize;
        PageHelper.startPage(pageNum, pageSize);
        List<Withdraw> list = withdrawDao.getListPrmMapRtnBean(params);
        PageInfo<Withdraw> pageInfo = new PageInfo<Withdraw>(list);
        return pageInfo;
    }


    @Override
    public boolean addWithdraw(Withdraw withdraw) throws Exception {

        String openid = withdraw.getOpenid();
        RoleDomain roleObj =  roleDao.getInfo(openid);
        withdraw.setUserName(roleObj.getNickName());
        withdraw.setRole(roleObj.getRole());
        withdraw.setPhone(roleObj.getPhone());



        withdraw.setUpdateTime(new Date());
        withdraw.setCreateTime(new Date());
         boolean effNum =  withdrawDao.getInsert(withdraw);
         if(effNum == true){

           int num =  roleDao.updateMoney(openid);
           if(num>0){
               return true;
           }
         }

        return true;
    }

    @Override
    public boolean updateWithdraw(Withdraw withdraw) throws Exception {
        withdrawDao.getUpdate(withdraw);
        return true;
    }

    @Override
    public Object findWithdraw(String WithdrawNum) throws Exception {
        return withdrawDao.getBeanById(WithdrawNum);
    }
}
