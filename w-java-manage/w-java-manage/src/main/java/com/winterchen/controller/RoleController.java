package com.winterchen.controller;

import com.winterchen.model.RoleDomain;
import com.winterchen.service.user.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/wx/user")
public class RoleController {
    @Autowired
    private RoleService roleService;

    @PostMapping("/baseInfo")
    public Map<String,Object> baseInfo(@RequestBody RoleDomain roleDomain){
        Map<String,Object> modelMap = new HashMap<String, Object>();

        modelMap.put("success",roleService.insertRole(roleDomain));
        return  modelMap;
    }

    @GetMapping("/allRole")
    public Map<String,Object> allRole(
            @RequestParam(name = "pageNum", required=false, defaultValue = "1") int pgNum,
            @RequestParam(name = "pageSize",required = false,defaultValue = "10") int pgSize,
            String nickName,
            String role,
            String openid
    ){
        Map<String , Object> modelMap = new HashMap<String, Object>();
        modelMap.put("data",roleService.selectRole(pgNum,pgSize,nickName,role,openid));

        return  modelMap;
    }

    //角色设置
    @PostMapping("/setRole")
    public Map<String,Object> setRole(
            String openid,
            @RequestParam(name = "role") String role,
            @RequestParam(name = "team",required = false) String team
    ){
        Map<String,Object> modelMap = new HashMap<String, Object>();

            Object result = roleService.hasHaveSame(openid, role, team);

            if(result == null){
                modelMap.put("success",roleService.updateRole(openid,role,team));
            }else{
                throw new RuntimeException("该团队已有总监");
            }

        return  modelMap;
    }

    @PostMapping("/update")
    public Map<String,Object> update(@RequestBody RoleDomain roleDomain){
        Map<String,Object> modeMap = new HashMap<String, Object>();
        String openid = roleDomain.getOpenid();
        String phone = roleDomain.getPhone();
        if(openid==null || openid == ""){
            throw new RuntimeException("openid不能为空！");
        }else if(phone == null || phone==""){
            throw new RuntimeException("手机号不能为空！");
        }

        modeMap.put("success",roleService.updateData(openid,phone));
        return  modeMap;
    }

    @GetMapping("/list")
    public List<RoleDomain> list(String team){
        return roleService.list(team);

    }

    /**
     * 获取用户信息
     * @param openid
     * @return
     */
    @GetMapping("/getInfo")
    public RoleDomain getInfo(String openid){
        return roleService.getInfo(openid);
    }










}
