package com.winterchen.controller;

import com.winterchen.exception.CustomException;
import io.swagger.annotations.Api;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

/**
 * 全局异常演示
 *
 * @author Levin
 * @since 2018/5/31 0031
 */

@Api(tags = "0.0", description = "测试..", value = "测试..")
@RestController
public class ExceptionController {


    //get接受参数1
    @GetMapping("/yf0")
    public int yf0(int id){
        int a = id;
        return a;
    }

    //get接受参数2
    @GetMapping("/yf1")
    public int yf1(@RequestParam int id){
        int a = id;
        return a;
    }

    //get接受参数3
    @GetMapping("/yf2")
    public int yf2(@RequestParam(name = "id" ) int ids){
        int a = ids;
        return a;
    }


    //get字符串拼接地址形式
    @GetMapping("/yf11/{id}")
    public int yf11(@PathVariable int id){
        int a = id;
        return a;
    }


    //post接受参数1
    @PostMapping("/post0")
    public int post0(int id){
        int a = id;
        return a;
    }

    //get接受参数2
    @PostMapping("/post1")
    public int post1(@RequestParam int id){
        int a = id;
        return a;
    }

    //get接受参数3
    @PostMapping("/post2")
    public int post2(@RequestParam(name = "id" ) int ids){
        int a = ids;
        return a;
    }



    @GetMapping("/test1")
    public String test1() {
        // TODO 这里只是模拟异常，假设业务处理的时候出现错误了，或者空指针了等等...
        int i = 10 / 0;
        return "test1";
    }

    @GetMapping("/test2")
    public Map<String, String> test2() {
        Map<String, String> result = new HashMap<>(16);
        // TODO 直接捕获所有代码块，然后在 cache
        try {
            int i = 10 / 0;
            result.put("code", "200");
            result.put("data", "具体返回的结果集");
        } catch (Exception e) {
            result.put("code", "500");
            result.put("message", "请求错误");
        }
        return result;
    }

    @GetMapping("/test3")
    public String test3(Integer num) {
        // TODO 演示需要，实际上参数是否为空通过 @RequestParam(required = true)  就可以控制
        if (num == null) {
            throw new CustomException(400, "num不能为空");
        }
        int i = 10 / num;
        return "result:" + i;
    }

    @GetMapping("/test4")
    public String test4(){
        String a = "11111";
        return a;
    }

}
