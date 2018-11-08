package com.winterchen.model;

import org.joda.time.DateTime;

public class OrderInfoDomain {
    private int id;
    private  String orderID;
    private  String email;
    private  String artType;
    private  String subject;
    private  int artLen;
    private  String  finishTime;
    private  String  team;
    private  String  title;
    private  String  direct;
    private  String  style;
    private  int status;
    private  double totalMoney;
    private String openid;
    private String creatTime;
    private int evaluate;
    private int thasfp;
    private String fpopenid;
    private int orderPool;
    private  int integral;

    public int getIntegral() {
        return integral;
    }

    public void setIntegral(int integral) {
        this.integral = integral;
    }

    public int getOrderPool() {
        return orderPool;
    }

    public void setOrderPool(int orderPool) {
        this.orderPool = orderPool;
    }

    public int getThasfp() {
        return thasfp;
    }

    public void setThasfp(int thasfp) {
        this.thasfp = thasfp;
    }

    public String getFpopenid() {
        return fpopenid;
    }

    public void setFpopenid(String fpopenid) {
        this.fpopenid = fpopenid;
    }

    public int getEvaluate() {
        return evaluate;
    }

    public void setEvaluate(int evaluate) {
        this.evaluate = evaluate;
    }

    public String getOpenid() {
        return openid;
    }

    public void setOpenid(String openid) {
        this.openid = openid;
    }



    public String getCreatTime() {
        return creatTime;
    }

    public void setCreatTime(String creatTime) {
        this.creatTime = creatTime;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getOrderID() {
        return orderID;
    }

    public void setOrderID(String orderID) {
        this.orderID = orderID;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getArtType() {
        return artType;
    }

    public void setArtType(String artType) {
        this.artType = artType;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public int getArtLen() {
        return artLen;
    }

    public void setArtLen(int artLen) {
        this.artLen = artLen;
    }

    public String getFinishTime() {
        return finishTime;
    }

    public void setFinishTime(String finishTime) {
        this.finishTime = finishTime;
    }

    public String getTeam() {
        return team;
    }

    public void setTeam(String team) {
        this.team = team;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDirect() {
        return direct;
    }

    public void setDirect(String direct) {
        this.direct = direct;
    }

    public String getStyle() {
        return style;
    }

    public void setStyle(String style) {
        this.style = style;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public double getTotalMoney() {
        return totalMoney;
    }

    public void setTotalMoney(double totalMoney) {
        this.totalMoney = totalMoney;
    }
}
