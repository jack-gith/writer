package com.winterchen.controller;


import com.winterchen.model.AccountDomain;
import com.winterchen.service.user.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.HashMap;
import java.util.Map;







@RestController
@RequestMapping(value = "/account")
public class AccountController {


    /**
     * 账号相关操作
     * @author:Miicty
     * @time:2018-9-18
     */

    @Autowired
    private AccountService accountService;


    //物理删除
    @PostMapping("/delAccount")
    public Map<String,Object> delAccount(Integer id){
        Map<String,Object> modelMap = new HashMap<String, Object>();
        if((id == null) || (id<=0)){
            throw new RuntimeException("传入的id有误!");
        }else{
            modelMap.put("success",accountService.delAccount(id));
        }
        return modelMap;
    }
    //逻辑删除
    @PostMapping("/deleteAccount")
    public Map<String,Object> deleteAccount(String token){
        Map<String,Object> modelMap = new HashMap<String, Object>();
        if(token==null || token==""){
            throw new RuntimeException("传入的id有误");
        }else{
            modelMap.put("success",accountService.deleteAccount(token));
        }

        return  modelMap;

    }




    //新增记录
    @PostMapping("/AddEditAccount")
    public Map<String,Object> AddEditAccount(AccountDomain accountDomain){
        Map<String,Object> modelMap = new HashMap<String, Object>();

        Object result = accountService.getName(accountDomain.getName());


        System.out.println(result);
        if(result == null){
            modelMap.put("success",accountService.addAndUpdateAccount(accountDomain));
        }else{
            throw new RuntimeException("该用户名已注册");
        }


        return modelMap;
    }

    //查询所有
    @GetMapping("/allAccount")
    public Object allAccount(
            @RequestParam(name = "pageNum", required = false, defaultValue = "1") int pageNum,
            @RequestParam(name = "pageSize", required = false, defaultValue = "10") int pageSize){

        return accountService.findAllAccound(pageNum,pageSize);

    }

    //用户登录
    @PostMapping("/vlogin")
    public Map<String,Object> ilogin(String name,String password){
        Map<String,Object> modelMap =  new HashMap<String,Object>();
        if(name == null || name == ""){

            throw new RuntimeException("用户名不能为空！");
        }else if(password == null || password == ""){
            throw new RuntimeException("密码不能为空！");

        }else{
            Object resultObject = accountService.login(name,password);
            if(resultObject == null){
                throw new RuntimeException("用户名或密码错误！");
            }else{
                modelMap.put("success",true);
                modelMap.put("data",resultObject);
            }

        }
        return modelMap;
    }

    //修改密码
    @PostMapping ("/updatePwd")
    public Map<String,Object> updatePwd(String password,String newPwd,String token){
        Map<String,Object> modelMap =  new HashMap<String,Object>();
        if(password==null || password == ""){
            throw new RuntimeException("请输入原密码！");
        }else if(newPwd == null || newPwd=="" ){
            throw new RuntimeException("请输入新密码！");
        }
        modelMap.put("success",accountService.updatePwd(password,newPwd,token));

        return  modelMap;
    }









}
