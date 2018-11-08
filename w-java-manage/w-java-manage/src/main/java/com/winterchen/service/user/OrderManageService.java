package com.winterchen.service.user;

import com.github.pagehelper.PageInfo;
import com.winterchen.model.dto.OrderManageDto;

import java.util.List;

public interface OrderManageService {

    PageInfo<OrderManageDto> selectAll(int pageNum, int pageSize, int status, String role, int userUploadStatus, int teacherUploadStatus, String orderID, String nickName,String openid);

    PageInfo<OrderManageDto> selectAll7(int pageNum, int pageSize,  String orderID, String nickName,String openid);


    Object getInfo(String openid);


}
