package com.winterchen.service.user.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.winterchen.dao.RoleDao;
import com.winterchen.model.RoleDomain;
import com.winterchen.service.user.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service(value = "RoleService")
public class RoleServiceImpl implements RoleService {
    @Autowired
    private RoleDao roleDao;
    @Override
    public boolean insertRole(RoleDomain roleDomain) {
        int effectNum = roleDao.insert(roleDomain);
        if(effectNum>0){
            return true;
        }else{
            throw new RuntimeException("保存用户信息失败！");

        }
    }

    @Override
    public PageInfo<RoleDomain> selectRole(int pageNum, int pageSize, String nickName, String role,String openid) {
        PageHelper.startPage(pageNum,pageSize);

        RoleDomain roleDomain = new RoleDomain();
        roleDomain.setNickName(nickName);
        roleDomain.setRole(role);
        roleDomain.setOpenid(openid);
        List<RoleDomain> roleDomains = roleDao.selectAll(roleDomain);

        return new PageInfo(roleDomains);


    }

    @Override
    public boolean updateRole(String openid, String role,String team){
        int effectNum =  roleDao.update(openid, role,team);
        if(effectNum>=0){
            return true;
        }else{
            throw new RuntimeException("修改失败！");
        }
    }

    //判断是否有指定的总监
    @Override
    public  Object hasHaveSame(String openid,String role,String team){
        return  roleDao.ifHaveSame(openid,role,team);
    }


    @Override
    public  boolean updateData(String openid,String phone){
        int effectNum = roleDao.updatePhone(openid,phone);
        if(effectNum>0){
            return  true;
        }else{
            throw new RuntimeException("操作失败！");
        }
    }

    @Override
    public List<RoleDomain> list(String team) {

        RoleDomain query =  new RoleDomain();
        query.setTeam(team);

        return roleDao.teacherList(query);
    }

    @Override
    public RoleDomain getInfo(String openid) {
        return roleDao.getInfo(openid);
    }

}
