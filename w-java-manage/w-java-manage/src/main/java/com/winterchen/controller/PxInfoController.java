package com.winterchen.controller;


import com.winterchen.service.user.PxInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RequestMapping("/evaluate")
@RestController
public class PxInfoController {

    @Autowired
    private PxInfoService pxInfoService;

    @GetMapping("/info")
    public Object info(String orderID){
        return  pxInfoService.info(orderID);
    }
}
