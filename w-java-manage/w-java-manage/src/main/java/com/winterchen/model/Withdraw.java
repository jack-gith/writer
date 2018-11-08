package com.winterchen.model;


import io.swagger.annotations.ApiModelProperty;

import java.util.Date;

/**
 * Title:Withdraw
 * Description:提现记录表实体类
 * Company:写手项目
 * Table: t_withdraw
 * DataBase: taoke_db
 * @author fy
 * @date 2018-10-30
 */
public class Withdraw implements java.io.Serializable {

	private static final long serialVersionUID = 1L;


    @ApiModelProperty(value = "", name = "id")
    private Integer id;

    @ApiModelProperty(value = "提现金额", name = "amount")
    private Double amount;

    @ApiModelProperty(value = "用户名", name = "userName")
    private String userName;

    @ApiModelProperty(value = "角色", name = "role")
    private String role;

    @ApiModelProperty(value = "审核状态（0:待审核 1:通过 2:驳回）", name = "status")
    private Integer status;

    @ApiModelProperty(value = "提现(申请)时间", name = "createTime")
    private Date createTime;

    @ApiModelProperty(value = "更新时间", name = "updateTime")
    private Date updateTime;


    private String openid;

    private String phone;

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getOpenid() {
        return openid;
    }

    public void setOpenid(String openid) {
        this.openid = openid;
    }

    public Integer getId()
    {
        return id;
    }

    public void setId(Integer id)
    {
        this.id = id;
    }

    public Double getAmount()
    {
        return amount;
    }

    public void setAmount(Double amount)
    {
        this.amount = amount;
    }

    public String getUserName()
    {
        return userName;
    }

    public void setUserName(String userName)
    {
        this.userName = userName;
    }

    public String getRole()
    {
        return role;
    }

    public void setRole(String role)
    {
        this.role = role;
    }

    public Integer getStatus()
    {
        return status;
    }

    public void setStatus(Integer status)
    {
        this.status = status;
    }

    public Date getCreateTime()
    {
        return createTime;
    }

    public void setCreateTime(Date createTime)
    {
        this.createTime = createTime;
    }

    public Date getUpdateTime()
    {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime)
    {
        this.updateTime = updateTime;
    }
}
