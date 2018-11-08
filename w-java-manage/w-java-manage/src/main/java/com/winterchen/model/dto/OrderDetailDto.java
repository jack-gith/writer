package com.winterchen.model.dto;


import lombok.Data;

import java.util.List;

@Data
public class OrderDetailDto {
    private String nickName;
    private  String phone;
    private String role;
    private  String superName;
    private String superPhone;
    private String zjName;
    private String zjPhone;


    private String orderID;
    private String status;
    private  String title;
    private int artLen;
    private String finishTime;
    private  String direct;
    private String  style;
    private  String email;
    private  String userUploadStatus;




}
