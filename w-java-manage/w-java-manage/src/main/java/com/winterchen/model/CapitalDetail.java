package com.winterchen.model;


import io.swagger.annotations.ApiModelProperty;

import java.util.Date;

/**
 * Title:CapitalDetail
 * Description:资金明细表实体类
 * Company:写手项目
 * Table: w_capital_detail
 * DataBase: taoke_db
 * @author fy
 * @date 2018-10-31
 */
public class CapitalDetail implements java.io.Serializable {

	private static final long serialVersionUID = 1L;


    @ApiModelProperty(value = "", name = "id")
    private Integer id;

    @ApiModelProperty(value = "总金额", name = "amountTotal")
    private Double amountTotal;

    @ApiModelProperty(value = "类型（收入(0)还是支出(1)）", name = "inOut")
    private Integer inOut;

    @ApiModelProperty(value = "种类（现金(0)还是积分(1)）", name = "cashPoint")
    private Integer cashPoint;

    @ApiModelProperty(value = "订单号", name = "orderNo")
    private String orderNo;

    @ApiModelProperty(value = "所属总监", name = "ownerInspector")
    private String ownerInspector;

    @ApiModelProperty(value = "所属老师", name = "ownerTeacher")
    private String ownerTeacher;

    @ApiModelProperty(value = "代理", name = "proxy")
    private String proxy;

    @ApiModelProperty(value = "所属总监", name = "ownerInspectorName")
    private String ownerInspectorName;

    @ApiModelProperty(value = "所属老师", name = "ownerTeacherName")
    private String ownerTeacherName;

    @ApiModelProperty(value = "代理", name = "proxyName")
    private String proxyName;

    @ApiModelProperty(value = "总监分成金额", name = "inspectorDivide")
    private Double inspectorDivide;

    @ApiModelProperty(value = "老师分成金额", name = "teacherDivide")
    private Double teacherDivide;

    @ApiModelProperty(value = "平台分成金额", name = "platDivide")
    private Double platDivide;

    @ApiModelProperty(value = "状态", name = "status")
    private Integer status;

    @ApiModelProperty(value = "说明", name = "remarks")
    private String remarks;

    @ApiModelProperty(value = "创建(结算)时间", name = "createTime")
    private Date createTime;


    public Integer getId()
    {
        return id;
    }

    public void setId(Integer id)
    {
        this.id = id;
    }

    public Double getAmountTotal()
    {
        return amountTotal;
    }

    public void setAmountTotal(Double amountTotal)
    {
        this.amountTotal = amountTotal;
    }

    public Integer getInOut()
    {
        return inOut;
    }

    public void setInOut(Integer inOut)
    {
        this.inOut = inOut;
    }

    public String getOrderNo()
    {
        return orderNo;
    }

    public void setOrderNo(String orderNo)
    {
        this.orderNo = orderNo;
    }

    public String getOwnerInspector()
    {
        return ownerInspector;
    }

    public void setOwnerInspector(String ownerInspector)
    {
        this.ownerInspector = ownerInspector;
    }

    public String getOwnerTeacher()
    {
        return ownerTeacher;
    }

    public void setOwnerTeacher(String ownerTeacher)
    {
        this.ownerTeacher = ownerTeacher;
    }

    public String getProxy()
    {
        return proxy;
    }

    public void setProxy(String proxy)
    {
        this.proxy = proxy;
    }

    public Double getInspectorDivide()
    {
        return inspectorDivide;
    }

    public void setInspectorDivide(Double inspectorDivide)
    {
        this.inspectorDivide = inspectorDivide;
    }

    public Double getTeacherDivide()
    {
        return teacherDivide;
    }

    public void setTeacherDivide(Double teacherDivide)
    {
        this.teacherDivide = teacherDivide;
    }

    public Double getPlatDivide()
    {
        return platDivide;
    }

    public void setPlatDivide(Double platDivide)
    {
        this.platDivide = platDivide;
    }

    public Integer getStatus()
    {
        return status;
    }

    public void setStatus(Integer status)
    {
        this.status = status;
    }

    public String getRemarks()
    {
        return remarks;
    }

    public void setRemarks(String remarks)
    {
        this.remarks = remarks;
    }

    public Date getCreateTime()
    {
        return createTime;
    }

    public void setCreateTime(Date createTime)
    {
        this.createTime = createTime;
    }

    public String getOwnerInspectorName() {
        return ownerInspectorName;
    }

    public void setOwnerInspectorName(String ownerInspectorName) {
        this.ownerInspectorName = ownerInspectorName;
    }

    public String getOwnerTeacherName() {
        return ownerTeacherName;
    }

    public void setOwnerTeacherName(String ownerTeacherName) {
        this.ownerTeacherName = ownerTeacherName;
    }

    public String getProxyName() {
        return proxyName;
    }

    public void setProxyName(String proxyName) {
        this.proxyName = proxyName;
    }

    public Integer getCashPoint() {
        return cashPoint;
    }

    public void setCashPoint(Integer cashPoint) {
        this.cashPoint = cashPoint;
    }
}
