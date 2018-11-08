package com.winterchen.controller;


import com.winterchen.model.OrderPxDomain;
import com.winterchen.service.user.OrderPxService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RequestMapping("/wx/api")
@RestController
public class OrderPxController {

    @Autowired
    private OrderPxService orderPxService;


    @PostMapping("/evaluate")
    public Map<String,Object> evaluate(@RequestBody OrderPxDomain orderPxDomain){
        Map<String,Object> modelMap = new HashMap<String, Object>();
        modelMap.put("success",orderPxService.insertPx(orderPxDomain));
        return modelMap;
    }

}
