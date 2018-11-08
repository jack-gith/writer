package com.winterchen.dao;

import com.winterchen.model.AccountDomain;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface AccountDao {
    int insert(AccountDomain accountDomain);

    int updatePwd(AccountDomain accountDomain);

    List<AccountDomain> allAccount(AccountDomain accountDomain);


    int delAccount(int id);

    int deleteAccount(String id);


    Object ilogin(@Param("name") String name,@Param("password") String password);

    int changePwd(@Param("password") String password,@Param("newPwd") String newPwd,@Param("token") String token);

    Object checkUser(@Param("name") String name);
}
