package com.winterchen.model;



public class ReturnCode {
    private int status;
    private String code;



    private UserDomain data;

    public UserDomain getData() {
        return data;
    }

    public void setData(UserDomain data) {
        this.data = data;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }
}
