package com.winterchen.model.dto;

import lombok.Data;

@Data
public class OrderManageDto {

    private  String openid;

    private String orderID;
    private  String  email;
    private  String team;
    private int totalMoney;
    private  String title;
    private String artType;
    private int userUploadStatus;
    private int teacherUploadStatus;
    private int status;
    private String subject;
    private  String creatTime;
    private  int evaluate;
    private  int thasfp;


    private  String nickName;
    private String role;
    private String superName;
    private String avatarUrl;

    private int fpNum;



}
