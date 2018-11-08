package com.winterchen.controller;


import com.winterchen.service.user.LogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/log")
public class LogController {

    @Autowired
    private LogService logService;


    @GetMapping("/list")
    public Object findAllLog(
            @RequestParam(name = "pageNum", required = false, defaultValue = "1") int pageNum,
            @RequestParam(name = "pageSize", required = false, defaultValue = "5") int pageSize
    ){
        return logService.findAllLog(pageNum,pageSize);
    }

}
