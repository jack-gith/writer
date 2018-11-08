package com.winterchen.service.user;

import com.github.pagehelper.PageInfo;
import com.winterchen.model.UserDomain;

import java.util.List;



//定义一个接口
public interface UserService {


    //新增
    boolean addUser(UserDomain user);


    //分页列表查询
    PageInfo<UserDomain> findAllUser(int pageNum, int pageSize, String name, String phone);



    //单条记录查询
    UserDomain selectOneUser(int userId);


    boolean delOneUser(int id);



}
