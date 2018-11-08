package com.winterchen.controller;


import com.winterchen.model.TeamDesDomain;
import com.winterchen.service.user.TeamDesService;
import com.winterchen.service.user.TeamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping(value = "/teamDes")
public class TeamDesController {

    @Autowired
    private TeamDesService teamDesService;

    @GetMapping("/findOne")
    public Map<String,Object> findOne(String team){
        Map<String,Object> modelMap = new HashMap<String, Object>();
        modelMap.put("data",teamDesService.selectOne(team));
        modelMap.put("success",true);
        return modelMap;
    }

}
