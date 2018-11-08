package com.winterchen.model;



import java.util.Date;
import java.math.BigDecimal;


/**
 * Title: CapitalDetail
 * Description: 资金明细表查询条件
 * Company: 写手项目
 * @author: fy
 * @date:   2018-10-31
 */
public class CapitalDetailCode implements java.io.Serializable {

	private static final long serialVersionUID = 1L;
	
    private Integer id;

    /**
     * 总金额
     **/
    private Double amountTotal;

    /**
     * 类型（收入(0)还是支出(1)）
     **/
    private Integer inOut;

    /**
     * 订单号
     **/
    private String orderNo;

    /**
     * 所属总监
     **/
    private String ownerInspector;

    /**
     * 所属老师
     **/
    private String ownerTeacher;

    /**
     * 代理
     **/
    private String proxy;

    /**
     * 总监分成金额
     **/
    private Double inspectorDivide;

    /**
     * 老师分成金额
     **/
    private Double teacherDivide;

    /**
     * 平台分成金额
     **/
    private Double platDivide;

    /**
     * 状态
     **/
    private Integer status;

    /**
     * 说明
     **/
    private String remarks;

    /**
     * 创建(结算)时间
     **/
    private Date createTime;

    public CapitalDetailCode() {
    }

    public CapitalDetailCode(Integer id, Double amountTotal, Integer inOut, String orderNo, String ownerInspector, String ownerTeacher, String proxy, Double inspectorDivide, Double teacherDivide, Double platDivide, Integer status, String remarks, Date createTime) {
        this.id = id;
        this.amountTotal = amountTotal;
        this.inOut = inOut;
        this.orderNo = orderNo;
        this.ownerInspector = ownerInspector;
        this.ownerTeacher = ownerTeacher;
        this.proxy = proxy;
        this.inspectorDivide = inspectorDivide;
        this.teacherDivide = teacherDivide;
        this.platDivide = platDivide;
        this.status = status;
        this.remarks = remarks;
        this.createTime = createTime;
    }

  
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

  
    public Double getAmountTotal() {
        return amountTotal;
    }

    public void setAmountTotal(Double amountTotal) {
        this.amountTotal = amountTotal;
    }

  
    public Integer getInOut() {
        return inOut;
    }

    public void setInOut(Integer inOut) {
        this.inOut = inOut;
    }

  
    public String getOrderNo() {
        return orderNo;
    }

    public void setOrderNo(String orderNo) {
        this.orderNo = orderNo;
    }

  
    public String getOwnerInspector() {
        return ownerInspector;
    }

    public void setOwnerInspector(String ownerInspector) {
        this.ownerInspector = ownerInspector;
    }

  
    public String getOwnerTeacher() {
        return ownerTeacher;
    }

    public void setOwnerTeacher(String ownerTeacher) {
        this.ownerTeacher = ownerTeacher;
    }

  
    public String getProxy() {
        return proxy;
    }

    public void setProxy(String proxy) {
        this.proxy = proxy;
    }

  
    public Double getInspectorDivide() {
        return inspectorDivide;
    }

    public void setInspectorDivide(Double inspectorDivide) {
        this.inspectorDivide = inspectorDivide;
    }

  
    public Double getTeacherDivide() {
        return teacherDivide;
    }

    public void setTeacherDivide(Double teacherDivide) {
        this.teacherDivide = teacherDivide;
    }

  
    public Double getPlatDivide() {
        return platDivide;
    }

    public void setPlatDivide(Double platDivide) {
        this.platDivide = platDivide;
    }

  
    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

  
    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

  
    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

   
    /*
     *--------------------------------------------------
     * 常用自定义字段
     *--------------------------------------------------
     */
   
    /**
     * 排序
     */
     private String orderBy     = null;  
    
	 /**
     * 订单号(全模糊)
     */
     private String orderNoLike;
     
    /**
     * 订单号 (模糊查询%)
     */
     private String orderNoLeftLike;
     
    /**
     * %模糊查询 订单号
     */
     private String orderNoRightLike;
     
     /**
     * 订单号(不等于<>)
     */
     private String orderNoNotEqual;
     
	 /**
     * 所属总监(全模糊)
     */
     private String ownerInspectorLike;
     
    /**
     * 所属总监 (模糊查询%)
     */
     private String ownerInspectorLeftLike;
     
    /**
     * %模糊查询 所属总监
     */
     private String ownerInspectorRightLike;
     
     /**
     * 所属总监(不等于<>)
     */
     private String ownerInspectorNotEqual;
     
	 /**
     * 所属老师(全模糊)
     */
     private String ownerTeacherLike;
     
    /**
     * 所属老师 (模糊查询%)
     */
     private String ownerTeacherLeftLike;
     
    /**
     * %模糊查询 所属老师
     */
     private String ownerTeacherRightLike;
     
     /**
     * 所属老师(不等于<>)
     */
     private String ownerTeacherNotEqual;
     
	 /**
     * 代理(全模糊)
     */
     private String proxyLike;
     
    /**
     * 代理 (模糊查询%)
     */
     private String proxyLeftLike;
     
    /**
     * %模糊查询 代理
     */
     private String proxyRightLike;
     
     /**
     * 代理(不等于<>)
     */
     private String proxyNotEqual;
     
	 /**
     * 说明(全模糊)
     */
     private String remarksLike;
     
    /**
     * 说明 (模糊查询%)
     */
     private String remarksLeftLike;
     
    /**
     * %模糊查询 说明
     */
     private String remarksRightLike;
     
     /**
     * 说明(不等于<>)
     */
     private String remarksNotEqual;
     
	 /**
     * 创建(结算)时间(起始日期)
     */
     private String createTimeBegin;
     
     /**
     * 创建(结算)时间(结束日期)
     */
     private String createTimeEnd;
     
	public void setOrderBy(String orderBy) {
        this.orderBy = orderBy;
    }
    public String getOrderBy() {
        return orderBy;
    }
    
    public String getOrderNoLike() {
        return orderNoLike;
    }
    public void setOrderNoLike(String orderNoLike) {
        this.orderNoLike = orderNoLike;
    }
    
    public String getOrderNoLeftLike() {
        return orderNoLeftLike;
    }
    public void setOrderNoLeftLike(String orderNoLeftLike) {
        this.orderNoLeftLike = orderNoLeftLike;
    }
    
    public String getOrderNoRightLike() {
        return orderNoRightLike;
    }
    public void setOrderNoRightLike(String orderNoRightLike) {
        this.orderNoRightLike = orderNoRightLike;
    }
    
    public String getOrderNoNotEqual() {
        return orderNoNotEqual;
    }
    public void setOrderNoNotEqual(String orderNoNotEqual) {
        this.orderNoNotEqual = orderNoNotEqual;
    }
    
    public String getOwnerInspectorLike() {
        return ownerInspectorLike;
    }
    public void setOwnerInspectorLike(String ownerInspectorLike) {
        this.ownerInspectorLike = ownerInspectorLike;
    }
    
    public String getOwnerInspectorLeftLike() {
        return ownerInspectorLeftLike;
    }
    public void setOwnerInspectorLeftLike(String ownerInspectorLeftLike) {
        this.ownerInspectorLeftLike = ownerInspectorLeftLike;
    }
    
    public String getOwnerInspectorRightLike() {
        return ownerInspectorRightLike;
    }
    public void setOwnerInspectorRightLike(String ownerInspectorRightLike) {
        this.ownerInspectorRightLike = ownerInspectorRightLike;
    }
    
    public String getOwnerInspectorNotEqual() {
        return ownerInspectorNotEqual;
    }
    public void setOwnerInspectorNotEqual(String ownerInspectorNotEqual) {
        this.ownerInspectorNotEqual = ownerInspectorNotEqual;
    }
    
    public String getOwnerTeacherLike() {
        return ownerTeacherLike;
    }
    public void setOwnerTeacherLike(String ownerTeacherLike) {
        this.ownerTeacherLike = ownerTeacherLike;
    }
    
    public String getOwnerTeacherLeftLike() {
        return ownerTeacherLeftLike;
    }
    public void setOwnerTeacherLeftLike(String ownerTeacherLeftLike) {
        this.ownerTeacherLeftLike = ownerTeacherLeftLike;
    }
    
    public String getOwnerTeacherRightLike() {
        return ownerTeacherRightLike;
    }
    public void setOwnerTeacherRightLike(String ownerTeacherRightLike) {
        this.ownerTeacherRightLike = ownerTeacherRightLike;
    }
    
    public String getOwnerTeacherNotEqual() {
        return ownerTeacherNotEqual;
    }
    public void setOwnerTeacherNotEqual(String ownerTeacherNotEqual) {
        this.ownerTeacherNotEqual = ownerTeacherNotEqual;
    }
    
    public String getProxyLike() {
        return proxyLike;
    }
    public void setProxyLike(String proxyLike) {
        this.proxyLike = proxyLike;
    }
    
    public String getProxyLeftLike() {
        return proxyLeftLike;
    }
    public void setProxyLeftLike(String proxyLeftLike) {
        this.proxyLeftLike = proxyLeftLike;
    }
    
    public String getProxyRightLike() {
        return proxyRightLike;
    }
    public void setProxyRightLike(String proxyRightLike) {
        this.proxyRightLike = proxyRightLike;
    }
    
    public String getProxyNotEqual() {
        return proxyNotEqual;
    }
    public void setProxyNotEqual(String proxyNotEqual) {
        this.proxyNotEqual = proxyNotEqual;
    }
    
    public String getRemarksLike() {
        return remarksLike;
    }
    public void setRemarksLike(String remarksLike) {
        this.remarksLike = remarksLike;
    }
    
    public String getRemarksLeftLike() {
        return remarksLeftLike;
    }
    public void setRemarksLeftLike(String remarksLeftLike) {
        this.remarksLeftLike = remarksLeftLike;
    }
    
    public String getRemarksRightLike() {
        return remarksRightLike;
    }
    public void setRemarksRightLike(String remarksRightLike) {
        this.remarksRightLike = remarksRightLike;
    }
    
    public String getRemarksNotEqual() {
        return remarksNotEqual;
    }
    public void setRemarksNotEqual(String remarksNotEqual) {
        this.remarksNotEqual = remarksNotEqual;
    }
    
 	public String getCreateTimeBegin() {
        return createTimeBegin;
    }
    public void setCreateTimeBegin(String createTimeBegin) {
        this.createTimeBegin = createTimeBegin;
    }
    
    public String getCreateTimeEnd() {
        return createTimeEnd;
    }
    public void setCreateTimeEnd (String createTimeEnd ){
        this.createTimeEnd = createTimeEnd;
    }
    

}
