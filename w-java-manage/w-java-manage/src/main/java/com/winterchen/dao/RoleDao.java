package com.winterchen.dao;

import com.winterchen.model.RoleDomain;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface RoleDao {

    int insert(RoleDomain roleDomain);

    List<RoleDomain> selectAll(RoleDomain roleDomain);

    List<RoleDomain> teacherList(RoleDomain roleDomain);


    int update(@Param("openid") String openid, @Param("role") String role,@Param("team") String team);

    Object ifHaveSame(@Param("openid") String openid,@Param("role") String  role,@Param("team") String team);

    int updatePhone(@Param("openid") String openid,@Param("phone") String phone);

    RoleDomain getInfo(@Param("openid") String openid);

    int updateMoney(@Param("openid") String openid);

    int updateBlance(@Param("openid") String openid,@Param("blance") Double blance,@Param("integral") int integral);

}
