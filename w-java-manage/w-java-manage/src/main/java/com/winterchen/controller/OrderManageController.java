package com.winterchen.controller;


import com.winterchen.model.dto.OrderManageDto;
import com.winterchen.service.user.OrderDetailService;
import com.winterchen.service.user.OrderManageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping(value = "/order")
public class OrderManageController {
    @Autowired
    private OrderManageService orderManageService;

    @Autowired
    private OrderDetailService orderDetailService;

    @GetMapping("/show")
    public Map<String,Object> show(String openid,String orderID){
        Map<String,Object> modelMap = new HashMap<String, Object>();
        modelMap.put("data",orderDetailService.showOne(openid,orderID));
        modelMap.put("success",true);
        return modelMap;
    }

    @GetMapping("/list")
    public Map<String,Object> list(
            @RequestParam(name = "pageNum", required = false, defaultValue = "1") int pageNum,
            @RequestParam(name = "pageSize", required = false, defaultValue = "10") int pageSize,

            @RequestParam(name = "status", required = false, defaultValue = "-1") int status,
            @RequestParam(name = "role", required = false) String role,
            @RequestParam(name = "userUploadStatus", required = false, defaultValue = "-1") int userUploadStatus,
            @RequestParam(name = "teacherUploadStatus", required = false, defaultValue = "-1") int teacherUploadStatus,
            @RequestParam(name = "orderID", required = false) String orderID,
            @RequestParam(name = "nickName", required = false) String nickName,
            @RequestParam(name = "openid", required = false) String openid


    ){
        Map<String,Object> modelMap = new HashMap<String, Object>();
        modelMap.put("data",orderManageService.selectAll(pageNum,pageSize,status,role,userUploadStatus,teacherUploadStatus,orderID,nickName,openid));

        return modelMap;
    }

    @GetMapping("/list7")
    public Map<String,Object> list7(
            @RequestParam(name = "pageNum", required = false, defaultValue = "1") int pageNum,
            @RequestParam(name = "pageSize", required = false, defaultValue = "10") int pageSize,

            @RequestParam(name = "orderID", required = false) String orderID,
            @RequestParam(name = "nickName", required = false) String nickName,
            @RequestParam(name = "openid", required = false) String openid


    ){
        Map<String,Object> modelMap = new HashMap<String, Object>();
        modelMap.put("data",orderManageService.selectAll7(pageNum,pageSize,orderID,nickName,openid));

        return modelMap;
    }

    @GetMapping("/getTeachInfo")
    public Object getTeachInfo(String openid){
        return orderManageService.getInfo(openid);
    }

}
