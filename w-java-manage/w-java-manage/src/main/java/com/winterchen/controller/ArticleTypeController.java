package com.winterchen.controller;


import com.winterchen.model.ArticleTypeDomain;
import com.winterchen.service.user.ArticleTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping(value="/article")
public class ArticleTypeController {

    @Autowired
    private ArticleTypeService articleTypeService;

    @GetMapping("/getList")
    public List<ArticleTypeDomain> getList(String code){
        return articleTypeService.selectAll(code);
    }

}
