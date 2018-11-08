package com.winterchen.controller;


import com.winterchen.model.ProportionDomain;
import com.winterchen.service.user.ProportionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/money")
public class ProportionController {
    @Autowired
    ProportionService proportionService;

    @PostMapping("/fp")
    public Map<String,Object> fp(ProportionDomain proportionDomain){
        Map<String,Object> map = new HashMap<String, Object>();
        map.put("success",proportionService.update(proportionDomain));
        return map;
    }

    @GetMapping("/list")
    public Map<String,Object> list(){
        Map<String,Object> map = new HashMap<String, Object>();
        map.put("datas",proportionService.list());
        map.put("success",true);
        return map;
    }
}
