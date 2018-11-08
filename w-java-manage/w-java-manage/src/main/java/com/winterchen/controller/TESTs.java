package com.winterchen.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;

@Controller
public class TESTs {



    @GetMapping("/index")
    public String index(){
        return "home"; //当浏览器输入/index时，会返回 /static/home.html的页面
    }

}
