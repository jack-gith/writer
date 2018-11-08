package com.winterchen.controller;


import com.winterchen.model.OrderInfoDomain;
import com.winterchen.service.user.OrderInfoService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;



@Api(tags = "1.1", description = "订单管理", value = "订单管理")
@RestController
@RequestMapping(value = "/wx/api")
public class OrderInfoController {
    @Autowired
    private OrderInfoService orderInfoService;

    /**
     * 代理或用户下单
     * @param orderInfoDomain
     * @return
     */
    @PostMapping("/insert")
    @ApiOperation(value = "新增订单（DONE）")
    public Map<String,Object> insert(@RequestBody OrderInfoDomain orderInfoDomain){
        Map<String,Object> modeMap = new HashMap<String, Object>();
        long timeMill =  new Date().getTime() / 1000;
        String lS = Long.toString(timeMill);
        orderInfoDomain.setCreatTime(lS);

        modeMap.put("success",orderInfoService.insertInfo(orderInfoDomain));
        modeMap.put("openid",orderInfoDomain.getOpenid());
        modeMap.put("createTime",lS);
        return  modeMap;
    }

    @GetMapping("/getOrder")
    public Object getOrder(String openid,String creatTime){
       return orderInfoService.getOrder(openid,creatTime);

    }

    @GetMapping("/orderDetail")
    public Object orderDetail(String orderID){
        return orderInfoService.getOderDetail(orderID);

    }

    /**
     * 获取老师或用户的订单总金额【暂不需要】
     */
    @GetMapping("/getMoney")
    public Map<String,Integer> getMoney(String openid){
        Map<String,Integer> map = new HashMap<String, Integer>();
        map.put("totalMoney",orderInfoService.getMoney(openid));
        return map;
    }

    /**
     * 关闭订单
     * @param orderID
     * @return
     */
    @GetMapping("/closeOrder")
    public Map<String,Object> closeOrder(String orderID){
        Map<String,Object> modelMap = new HashMap<String, Object>();

        modelMap.put("success",orderInfoService.close(orderID));
        return  modelMap;
    }

    /**
     * 获取订单池订单
     * @param orderID
     * @param team
     * @return
     */
    @GetMapping("/robOrder")
    public Map<String,Object> robOrder(String orderID,String team){
        Map<String,Object> modelMap = new HashMap<String, Object>();

        modelMap.put("success",orderInfoService.robOrder(orderID,team));
        return  modelMap;
    }

    @GetMapping("/getStatus")
    public Map<String,Object> getStatus(String team){
        Map<String,Object> modelMap = new HashMap<String, Object>();

        modelMap.put("status1",orderInfoService.getStatus(team,1));
        modelMap.put("status2",orderInfoService.getStatus(team,2));
        modelMap.put("status3",orderInfoService.getStatus(team,3));
        modelMap.put("status4",orderInfoService.getStatus(team,4));
        modelMap.put("status5",orderInfoService.getStatus(team,5));
        modelMap.put("status6",orderInfoService.getStatus(team,6));
        modelMap.put("status7",orderInfoService.getStatus7());
        modelMap.put("list",orderInfoService.teachList(team));

        return  modelMap;
    }


    /**
     * 获取用户统计
     * @param openid
     * @return
     */
    @GetMapping("/getUserStatistics")
    public Object getUserStatistics(String openid){
        return orderInfoService.user_total(openid);
    }

    /**
     * 获取代理统计
     * @param openid
     * @return
     */
    @GetMapping("/getAgentStatistics")
    public Object getAgentStatistics(String openid){
        return orderInfoService.agent_total(openid);
    }








    @GetMapping("/returno")
    public Map<String,Object> returno(String orderID,int status,@RequestParam(name = "orderPool", required = false, defaultValue = "0") int orderPool){
        Map<String,Object> modelMap = new HashMap<String, Object>();

        modelMap.put("success",orderInfoService.returno(orderID,status,orderPool));
        return  modelMap;
    }


    @GetMapping("/list")
    public Map<String,Object> list(
            @RequestParam(name = "pageNum", required = false, defaultValue = "1") int pageNum,
            @RequestParam(name = "pageSize", required = false, defaultValue = "10") int pageSize,

             int status,
            @RequestParam(name = "openid", required = false) String openid,
            @RequestParam(name = "team", required = false) String team,
            @RequestParam(name = "thasfp", required = false, defaultValue = "0") int thasfp,
            @RequestParam(name = "fpopenid", required = false) String fpopenid


    ){
        Map<String,Object> modelMap = new HashMap<String, Object>();
        modelMap.put("data",orderInfoService.selectAll(pageNum,pageSize,status,openid,team,thasfp,fpopenid));

        return modelMap;
    }

    @GetMapping("/fpTeacher")
    public Map<String,Object> fpTeacher( String fpopenid,String orderID){
        Map<String,Object> modelMap  = new HashMap<String, Object>();
        modelMap.put("success",orderInfoService.fpTeacher(fpopenid,orderID));
        return modelMap;
    }

    /**
     * 代理或用户验收
     * @param openid
     * @param orderID
     * @return
     */
    @PostMapping("/confirm")
    @ApiOperation(value = "代理或用户验收订单")
    public Map<String,Object> confirm(String openid, String orderID) throws Exception {
        Map<String,Object> modelMap  = new HashMap<String, Object>();
        modelMap.put("success",orderInfoService.confirm(openid,orderID));
        return modelMap;
    }

    /**
     * 获取用户累计收入
     * @param openid
     * @return
     */
    @GetMapping("/getUserStatisticsBalance")
    @ApiOperation(value = "获取用户累计收入")
    public Double getUserStatisticsBalance(String openid) throws Exception{
        return orderInfoService.getUserStatisticsBalance(openid);
    }



}
