package com.winterchen.service.user.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.winterchen.dao.OrderManageDao;
import com.winterchen.model.dto.OrderManageDto;
import com.winterchen.service.user.OrderManageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service(value = "OrderManageService")
public class OrderManageServiceImpl implements OrderManageService {

    @Autowired
    private OrderManageDao orderManageDao;

    @Override
    public PageInfo<OrderManageDto> selectAll(int pageNum, int pageSize, int status, String role, int userUploadStatus, int teacherUploadStatus, String orderID, String nickName,String openid) {

        PageHelper.startPage(pageNum,pageSize);
        OrderManageDto query = new OrderManageDto();
        query.setStatus(status);
        query.setRole(role);
        query.setUserUploadStatus(userUploadStatus);
        query.setTeacherUploadStatus(teacherUploadStatus);
        query.setOrderID(orderID);
        query.setNickName(nickName);
       List<OrderManageDto> orderManageDtos =   orderManageDao.select(query);


        return new PageInfo(orderManageDtos);
    }


    @Override
    public PageInfo<OrderManageDto> selectAll7(int pageNum, int pageSize,  String orderID, String nickName,String openid) {

        PageHelper.startPage(pageNum,pageSize);
        OrderManageDto query = new OrderManageDto();

        query.setOrderID(orderID);
        query.setNickName(nickName);
        List<OrderManageDto> orderManageDtos =   orderManageDao.select7(query);


        return new PageInfo(orderManageDtos);
    }

    /**
     * 获取老师信息
     * @param openid
     * @return
     */

    @Override
    public Object getInfo(String openid) {
        return orderManageDao.getTeacherInfo(openid);
    }
}
