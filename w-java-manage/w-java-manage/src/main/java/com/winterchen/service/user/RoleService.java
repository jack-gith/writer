package com.winterchen.service.user;

import com.github.pagehelper.PageInfo;
import com.winterchen.model.RoleDomain;

import java.util.List;

public interface RoleService {

    boolean insertRole(RoleDomain roleDomain);

    boolean updateRole(String openid, String role,String team);

    PageInfo<RoleDomain> selectRole(int pageNum,int pageSize,String nickName,String role,String openid);

    Object hasHaveSame(String openid,String role,String team);

    boolean updateData(String openid, String phone);

    List<RoleDomain> list(String team);

    RoleDomain getInfo(String openid);

}
