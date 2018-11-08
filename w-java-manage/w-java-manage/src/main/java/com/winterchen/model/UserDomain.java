package com.winterchen.model;

import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotBlank;

public class UserDomain {
    private Integer userId;

    private String userName;


   // @NotBlank(message = "password 不允许为空")
   // @Length(min = 2, max = 6, message = "password 长度必须在 {min} - {max} 之间")
    private String password;




    private String phone;





    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName == null ? null : userName.trim();

    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password == null ? null : password.trim();
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone == null ? null : phone.trim();
    }
}