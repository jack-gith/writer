package com.winterchen.service.user.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.winterchen.dao.CapitalDetailDao;
import com.winterchen.dao.OrderInfoDao;
import com.winterchen.dao.ProportionDao;
import com.winterchen.dao.RoleDao;
import com.winterchen.model.CapitalDetail;
import com.winterchen.model.OrderInfoDomain;
import com.winterchen.model.ProportionDomain;
import com.winterchen.model.RoleDomain;
import com.winterchen.service.user.OrderInfoService;
import com.winterchen.util.utils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


@Service(value = "OrderInfoService")
public class OrderInfoServiceImpl implements OrderInfoService {

    @Autowired
    private OrderInfoDao orderInfoDao;

    @Autowired
    ProportionDao proportionDao;

    @Autowired
    RoleDao roleDao;

    @Autowired
    CapitalDetailDao capitalDetailDao;

    @Override
    public boolean insertInfo(OrderInfoDomain orderInfoDomain) {
        String str =  utils.getNo(4);
        String rsdomStr =  orderInfoDomain.getTeam() + str;
        orderInfoDomain.setOrderID(rsdomStr);

        int integral = orderInfoDomain.getIntegral() / 1000 * 100;
        orderInfoDomain.setIntegral(integral);

        int effectNum = orderInfoDao.insertData(orderInfoDomain);
        if(effectNum>0){
            return true;
        }else{
            throw new RuntimeException("失败！");
        }
    }

    @Override
    public  Object getOrder(String openid,String creatTime){

       return orderInfoDao.findOne(openid,creatTime);
    }

    @Override
    public Object getOderDetail(String orderID) {
        return  orderInfoDao.orderDetail(orderID);
    }

    @Override
    public boolean close(String orderID) {
        if(orderID==null || orderID == ""){
            throw new RuntimeException("订单id不能为空！");
        }

        int effectNum = orderInfoDao.closeOrder(orderID);
        if(effectNum > 0 ){
            return  true;
        }else{
            throw new RuntimeException("订单取消失败！");
        }

    }

    @Override
    public boolean returno(String orderID,int status,int orderPool) {
        if(orderID==null || orderID == ""){
            throw new RuntimeException("订单id不能为空！");
        }

        int effectNum = orderInfoDao.returnOrder(orderID,status,orderPool);
        if(effectNum > 0 ){
            return  true;
        }else{
            throw new RuntimeException("订单取消失败！");
        }
    }

    @Override
    public boolean fpTeacher(String fpopenid, String orderID) {

        int effectNum = orderInfoDao.fpTeacher(fpopenid,orderID);
        if(effectNum>0){
            return  true;
        }else{
            throw new RuntimeException("分配失败！");
        }
    }

    @Override
    public boolean robOrder(String orderID, String team) {
        int effectNum = orderInfoDao.robOrder(orderID,team);
        if(effectNum>0){
            return  true;
        }else{
            throw new RuntimeException("分配失败！");
        }
    }

    @Override
    public int getMoney(String openid) {
       ProportionDomain pro =  proportionDao.list();
       RoleDomain roleDomain = roleDao.getInfo(openid);
       String role = roleDomain.getRole();
       int rl = Integer.parseInt(role);

       int totalMoney =  orderInfoDao.getMoney(openid);
       
       int result = 0;

       System.err.println(rl);
       if(rl == 3){
            int tc = pro.getTeacher()/100;
            result = totalMoney * tc;

       }
       if(rl == 4){
           int dc = pro.getDirector();
           System.err.println("比例："+dc);
           result = totalMoney * dc;
           System.err.println("结果："+result);
          
       }

        return result;


    }

    @Override
    public int getStatus(String team, int status) {
        return orderInfoDao.getStatus(team,status);
    }

    @Override
    public int getStatus7() {
        return orderInfoDao.getStatus7();
    }

    @Override
    public Object user_total(String openid) {
        Map<String,Integer> map = new HashMap<String,Integer>();
        map.put("num",orderInfoDao.user_num(openid));
        map.put("money",orderInfoDao.user_money(openid));
        return map;
    }

    @Override
    public Object agent_total(String openid) {
        Map<String,Integer> map = new HashMap<String,Integer>();
        map.put("num",orderInfoDao.user_num(openid));
        map.put("integral",orderInfoDao.getIntegral(openid));
        return map;
    }

    @Override
    public List<RoleDomain> teachList(String team) {

        return orderInfoDao.getTeacher(team);
    }

    @Override
    public PageInfo<OrderInfoDomain> selectAll(int pageNum, int pageSize, int status, String openid, String team, int thasfp, String fpopenid) {
        PageHelper.startPage(pageNum,pageSize);
        OrderInfoDomain query = new OrderInfoDomain();
        query.setStatus(status);
        if(team==null || team==""){
            query.setOpenid(openid);
        }

        query.setTeam(team);
        query.setThasfp(thasfp);
        query.setFpopenid(fpopenid);
//        query.setOrderID(openid);
        List<OrderInfoDomain> orderManageDtos =   orderInfoDao.getAllOrderList(query);


        return new PageInfo(orderManageDtos);
    }

    @Override
    public boolean confirm(String openid, String orderID) throws Exception {
        // 订单明细
        Object obj = orderInfoDao.orderDetail(orderID);
        OrderInfoDomain orderInfoDomain = (OrderInfoDomain)obj;
        // 订单不存在或不是待验收状态
        if(null == orderInfoDomain || !"4".equals(orderInfoDomain.getStatus())){
            return false;
        }
        // 更新订单表为已完成
        orderInfoDao.confirmOrder(orderID,openid);
        ProportionDomain proportionDomain = proportionDao.list();
        // 总监分成比例
        int directPropo = proportionDomain.getDirector();
        // 老师分成比例
        int teacherPropo = proportionDomain.getTeacher();
        String fpopentid = orderInfoDomain.getFpopenid();
        // 团队
        String team = orderInfoDomain.getTeam();
        int pool = orderInfoDomain.getOrderPool();
        // 订单金额
        Double totalMoney = orderInfoDomain.getTotalMoney();
        CapitalDetail capitalDetail = new CapitalDetail();
        // 收入
        capitalDetail.setInOut(0);
        // 现金
        capitalDetail.setCashPoint(0);
        capitalDetail.setAmountTotal(totalMoney);
        capitalDetail.setOrderNo(orderID);
        capitalDetail.setOwnerTeacher(fpopentid);
        capitalDetail.setTeacherDivide(totalMoney*teacherPropo/100);
        capitalDetail.setProxy(openid);
        // 根据团队查角色
        Object object = roleDao.ifHaveSame("","",team);
        RoleDomain rd = (RoleDomain)object;
        capitalDetail.setOwnerInspector(rd.getOpenid());
        capitalDetail.setInspectorDivide(totalMoney*directPropo/100);
        capitalDetail.setPlatDivide(totalMoney-capitalDetail.getInspectorDivide()-capitalDetail.getTeacherDivide());
        // 交易完成
        capitalDetail.setStatus(0);
        capitalDetail.setCreateTime(new Date());
        capitalDetail.setRemarks("订单收入");
        capitalDetailDao.getInsert(capitalDetail);
        roleDao.updateBlance(capitalDetail.getOwnerTeacher(),capitalDetail.getTeacherDivide(),0);
        roleDao.updateBlance(capitalDetail.getOwnerInspector(),capitalDetail.getInspectorDivide(),0);
        RoleDomain roleDomain = roleDao.getInfo(openid);
        String role = roleDomain.getRole();
        // 如果是代理发放积分
        if("2".equals(role)){
            CapitalDetail cd = new CapitalDetail();
            // 是订单池订单100%
            if(pool == 0){
                roleDao.updateBlance(openid,0d, totalMoney.intValue());
                cd.setAmountTotal((double)totalMoney.intValue());
                // 50%
            } else if(pool == 1){
                roleDao.updateBlance(openid,0d, totalMoney.intValue()/2);
                cd.setAmountTotal((double)totalMoney.intValue()/2);
            }
            cd.setInOut(0);
            //积分
            cd.setCashPoint(1);
            cd.setRemarks("订单收入积分奖励");
            cd.setOrderNo(orderID);
            cd.setProxy(openid);
            // 交易完成
            cd.setStatus(0);
            cd.setCreateTime(new Date());
            capitalDetailDao.getInsert(cd);
        }
        return true;
    }

    @Override
    public Double getUserStatisticsBalance(String openid) throws Exception {
        RoleDomain roleDomain = roleDao.getInfo(openid);
        String role = roleDomain.getRole();
        Map map = new HashMap();
        BigDecimal result = new BigDecimal(0);
        if("3".equals(role)){
            map = capitalDetailDao.getUserStatisticsBalance(null,openid);
            if(null != map.get("totalTeacherDivide")){
                result = (BigDecimal)map.get("totalTeacherDivide");
            }
        }else if("4".equals(role)){
            map = capitalDetailDao.getUserStatisticsBalance(openid,null);
            result = (BigDecimal)map.get("totalInspectorDivide");
        }
        return result.doubleValue();
    }
}
