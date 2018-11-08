package com.winterchen.service.user;

import com.github.pagehelper.PageInfo;
import com.winterchen.model.AccountDomain;
import org.apache.ibatis.annotations.Param;

public interface AccountService {



    boolean addAndUpdateAccount(AccountDomain accountDomain);

    boolean delAccount(int id);

    boolean deleteAccount(String id);

    PageInfo<AccountDomain> findAllAccound(int pageNum,int PageSize);


    Object login(String name ,  String password);


    boolean updatePwd(String newPwd,String oldPwd,String token);

    //判断用户名
    Object getName(String name);


}
