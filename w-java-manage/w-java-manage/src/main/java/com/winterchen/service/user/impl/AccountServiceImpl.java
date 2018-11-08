package com.winterchen.service.user.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.winterchen.dao.AccountDao;
import com.winterchen.model.AccountDomain;
import com.winterchen.service.user.AccountService;
import org.joda.time.DateTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.UUID;


@Service(value = "AccountService")
public class AccountServiceImpl implements AccountService {

    @Autowired
    private AccountDao accountDao;

    @Override
    public boolean addAndUpdateAccount(AccountDomain accountDomain) {

        if(accountDomain.getName() == null || accountDomain.getName()==""){
            throw new RuntimeException("账号不能为空！");
        }else if(accountDomain.getTeam()==null || accountDomain.getTeam()==""){
            throw new RuntimeException("团队不能为空！");
        }else{
            if(accountDomain.getPassword()==null || accountDomain.getPassword()==""){
                accountDomain.setPassword("123456");
            }

        }
        if(accountDomain.getToken() == null || accountDomain.getToken()==""){

          // Object eff =   accountDao.checkUser(accountDomain.getName());
            System.out.println("================");
          // System.out.println(eff);
            System.out.println("================");

            SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式
            String strTime = df.format(new Date());

          //  System.out.println(strTime);// new Date()为获取当前系统时间


            accountDomain.setCreat_time(strTime);
            String uuid = UUID.randomUUID().toString().replaceAll("-", "");
            accountDomain.setToken(uuid);

            accountDomain.setIdentifying(1);

            int effectNum = accountDao.insert(accountDomain);
            if(effectNum>0){
                return  true;
            }else{
                throw new RuntimeException("新增账号失败！");
            }
        }else{
            int effectNum  = accountDao.updatePwd(accountDomain);
            if(effectNum>0){
                return  true;
            }else {
                throw new RuntimeException("修改账号失败！");
            }
        }

    }

    @Override
    public boolean delAccount(int id) {
            int effectNum = accountDao.delAccount(id);
            if(effectNum>0){
                return  true;
            }else{
                throw new RuntimeException("删除失败！");
            }
    }

    @Override
    public  boolean deleteAccount(String id){
        int effectNum = accountDao.deleteAccount(id);
        if(effectNum>0){
            return  true;
        }else{
            throw new RuntimeException("删除失败！");
        }
    }

    @Override
    public PageInfo<AccountDomain> findAllAccound(int pageNum, int PageSize) {
        PageHelper.startPage(pageNum, PageSize);

        AccountDomain query = new AccountDomain();

        List<AccountDomain> accountDomains = accountDao.allAccount(query);

        return  new PageInfo(accountDomains);
    }

    @Override
    public Object login(String name, String password) {

          return accountDao.ilogin(name,password);
    }

    @Override
    public boolean updatePwd(String newPwd,String oldPwd,String token){
        int effectNum = accountDao.changePwd(newPwd,oldPwd,token);
        if(effectNum>0){
            return  true;
        }else{
            throw new RuntimeException("更新密码失败！");
        }
    }

    @Override
    public  Object getName(String name){
        return accountDao.checkUser(name);
    }

}
