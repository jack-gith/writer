package com.winterchen.controller;


import com.winterchen.model.DictDomain;
import com.winterchen.model.TeamDomain;
import com.winterchen.model.dto.UserDto;
import com.winterchen.service.user.TeamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/team")
public class TeamController {


    @Autowired
    private TeamService teamService;

    @PostMapping("/add")
    public Map<String,Object> add(TeamDomain teamDomain){
        Map<String,Object> modelMap = new HashMap<String, Object>();

        modelMap.put("success",teamService.insertAndUpdate(teamDomain));
        return modelMap;
    }


    @GetMapping("/show")
    public Map<String,Object> show(){
        Map<String,Object> modelMap = new HashMap<String, Object>();

         modelMap.put("data",teamService.show());
         modelMap.put("success",true);

         return modelMap;

    }

    //获取数据字典
    @GetMapping("/dict")
    public Map<String, Object> dict(String code){
       Map<String,Object> modelMap = new HashMap<String, Object>();
       modelMap.put("list",teamService.dict_show(code));
       modelMap.put("success",true);
       return  modelMap;


    }



    //获取多表信息
    @GetMapping("/more")
    public List<UserDto> more(){
        return  teamService.searchTeachers();
    }

}
