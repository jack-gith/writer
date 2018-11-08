package com.winterchen.controller;

import com.battcn.swagger.properties.ApiDataType;
import com.battcn.swagger.properties.ApiParamType;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.winterchen.model.ReturnCode;
import com.winterchen.model.UserDomain;
import com.winterchen.service.user.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

/**
 * Created by Administrator on 2018/9/10.
 */


//controller  获取从页面传来的数据，然后处理或者不处理，直接交给server层去实现其逻辑。从service层获取数据，发送给前端

@RestController
@RequestMapping(value = "/user")
@Api(tags = "1.1", description = "用户管理", value = "用户管理")
public class UserController {


    private static final Logger log = LoggerFactory.getLogger(UserController.class);

    @Autowired
    private UserService userService;


    /**
     * 新增
     * @param user
     * @return
     *
     */

    @PostMapping("/add")
    @ApiOperation(value = "添加用户（DONE）")
    @ApiImplicitParam(name = "userId", value = "用户ID，新增为0，编辑时必填", dataType = ApiDataType.LONG, paramType = ApiParamType.PATH)
    public  Map<String, Object> addUser(UserDomain user){

        log.info(user.getUserName()+user.getPassword()+user.getPhone());

        Map<String,Object> modelMap = new HashMap<String, Object>();
        if(user.getPhone()==null || user.getPhone()==""){
            modelMap.put("success",false);
            modelMap.put("msg","手机号不能为空！");

        }else{
            modelMap.put("success",userService.addUser(user));
        }

        return modelMap;

    }


//    @PostMapping("/login")
//    public Map<String, Object> login()


    /**
     * 分页和模糊查询数据
     * @param pageNum
     * @param pageSize
     * @param name
     * @param phone
     * @return
     */

    @GetMapping("/all")
    @ApiOperation(value = "条件查询（DONE）")
//    @ApiImplicitParams({
//            @ApiImplicitParam(name = "name", value = "用户名", dataType = ApiDataType.STRING, paramType = ApiParamType.QUERY),
//            @ApiImplicitParam(name = "phone", value = "手机号", dataType = ApiDataType.STRING, paramType = ApiParamType.QUERY),
//            @ApiImplicitParam(name = "pageNum", value = "第几页", dataType = ApiDataType.INT, paramType = ApiParamType.QUERY),
//            @ApiImplicitParam(name = "pageSize", value = "每页显示数量", dataType = ApiDataType.INT, paramType = ApiParamType.QUERY),
//    })
    public Object findAllUser(
            @RequestParam(name = "pageNum", required = false, defaultValue = "1") int pageNum,
            @RequestParam(name = "pageSize", required = false, defaultValue = "5") int pageSize,
             String name,
            String phone){ //获取参数
        return userService.findAllUser(pageNum,pageSize,name,phone);
    }






    /**
     * 获取单条记录
     * @param id
     * @return
     */

    @PostMapping("/alone")
    @ApiOperation(value = "回显单条记录（DONE）")
    public Map<String, Object> alone(Integer userId)  {
        Map<String, Object> modelMap = new HashMap<String, Object>();

        if(userId==null){
            modelMap.put("success",false);
            modelMap.put("msg", "用户id不能为空！");
        }else{
            UserDomain userDomain = userService.selectOneUser(userId);
            modelMap.put("data", userDomain);
        }


        return modelMap;
    }

    /**
     * 删除
     * @param id
     * @return
     */

    @PostMapping("/del")
    @ApiOperation(value = "删除单条记录（DONE）")
    public Map<String, Object> removeArea(Integer userId) {
        Map<String, Object> modelMap = new HashMap<String, Object>();
        if(userId==null){
            modelMap.put("success",false);
            modelMap.put("msg", "用户id不能为空！");
        }else{
            modelMap.put("success", userService.delOneUser(userId));
        }

        return modelMap;
    }







}
