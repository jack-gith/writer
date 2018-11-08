package com.winterchen.service.user.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.winterchen.dao.CapitalDetailDao;
import com.winterchen.dao.RoleDao;
import com.winterchen.model.CapitalDetail;
import com.winterchen.model.RoleDomain;
import com.winterchen.service.user.CapitalDetailService;
import com.winterchen.util.StringUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

@Service
public class CapitalDetailServiceImpl implements CapitalDetailService
{

    @Autowired
    CapitalDetailDao capitalDetailDao;

    @Autowired
    private RoleDao roleDao;

    @Override
    public PageInfo<CapitalDetail> getCapitalDetailList(Map<String, Object> params) throws Exception {
        int pageNum = StringUtil.nullToInteger(params.get("pageNumber"));
        pageNum = pageNum == 0 ? 1 : pageNum;
        int pageSize = StringUtil.nullToInteger(params.get("pageSize"));
        pageSize = pageSize == 0 ? 10 : pageSize;
        PageHelper.startPage(pageNum, pageSize);
        String openId = StringUtil.nullToString(params.get("openId"));
        List<CapitalDetail> resultList = new ArrayList<>();
        String role = null;
        if(!StringUtil.isEmpty(openId)){
            RoleDomain roleDomain = roleDao.getInfo(openId);
            if(null != roleDomain){
                role = roleDomain.getRole();
                if("3".equals(role)){
                    params.put("ownerTeacher",openId);
                }else if("4".equals(role)){
                    params.put("ownerInspector",openId);
                }
            }
        }

        List<CapitalDetail> list = capitalDetailDao.getListPrmMapRtnBean(params);
        PageInfo<CapitalDetail> pageInfo = new PageInfo<>();
        if(null != role && "3".equals(role)){
            for(CapitalDetail cd3 : list){
                CapitalDetail cdl3 = new CapitalDetail();
                cdl3.setId(cd3.getId());
                cdl3.setInOut(cd3.getInOut());
                cdl3.setTeacherDivide(cd3.getTeacherDivide());
                cdl3.setCreateTime(cd3.getCreateTime());
                cdl3.setRemarks(cd3.getRemarks());
                resultList.add(cdl3);
            }
            pageInfo = new PageInfo<>(resultList);
        }else if(null != role && "4".equals(role)){
            for(CapitalDetail cd4 : list){
                CapitalDetail cdl4 = new CapitalDetail();
                cdl4.setId(cd4.getId());
                cdl4.setInOut(cd4.getInOut());
                cdl4.setTeacherDivide(cd4.getInspectorDivide());
                cdl4.setCreateTime(cd4.getCreateTime());
                cdl4.setRemarks(cd4.getRemarks());
                resultList.add(cdl4);
            }
            pageInfo = new PageInfo<>(resultList);
        } else {
            pageInfo = new PageInfo<>(list);
        }

        return pageInfo;
    }

    @Override
    public boolean addCapitalDetail(CapitalDetail capitalDetail) throws Exception {
        capitalDetail.setCreateTime(new Date());
        capitalDetailDao.getInsert(capitalDetail);
        return true;
    }

    @Override
    public Object findWithdraw(String withdrawNum) throws Exception
    {
        return capitalDetailDao.getBeanById(withdrawNum);
    }


}
