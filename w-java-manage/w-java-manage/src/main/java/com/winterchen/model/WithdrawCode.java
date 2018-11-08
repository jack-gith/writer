package com.winterchen.model;



import java.util.Date;


/**
 * Title: Withdraw
 * Description: 提现记录表查询条件
 * Company: 写手项目
 * @author: fy
 * @date:   2018-10-30
 */
public class WithdrawCode implements java.io.Serializable {

	private static final long serialVersionUID = 1L;
	
    private Integer id;

    /**
     * 提现金额
     **/
    private Double amount;

    /**
     * 用户名
     **/
    private String userName;

    /**
     * 角色
     **/
    private String role;

    /**
     * 审核状态（0:待审核 1:通过 2:驳回）
     **/
    private Integer status;

    /**
     * 提现(申请)时间
     **/
    private Date createTime;

    /**
     * 更新时间
     **/
    private Date updateTime;

    public WithdrawCode() {
    }

    public WithdrawCode(Integer id, Double amount, String userName, String role, Integer status, Date createTime, Date updateTime) {
        this.id = id;
        this.amount = amount;
        this.userName = userName;
        this.role = role;
        this.status = status;
        this.createTime = createTime;
        this.updateTime = updateTime;
    }

  
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

  
    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

  
    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

  
    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

  
    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

  
    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

  
    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
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
     * 用户名(全模糊)
     */
     private String userNameLike;
     
    /**
     * 用户名 (模糊查询%)
     */
     private String userNameLeftLike;
     
    /**
     * %模糊查询 用户名
     */
     private String userNameRightLike;
     
     /**
     * 用户名(不等于<>)
     */
     private String userNameNotEqual;
     
	 /**
     * 角色(全模糊)
     */
     private String roleLike;
     
    /**
     * 角色 (模糊查询%)
     */
     private String roleLeftLike;
     
    /**
     * %模糊查询 角色
     */
     private String roleRightLike;
     
     /**
     * 角色(不等于<>)
     */
     private String roleNotEqual;
     
	 /**
     * 提现(申请)时间(起始日期)
     */
     private String createTimeBegin;
     
     /**
     * 提现(申请)时间(结束日期)
     */
     private String createTimeEnd;
     
	 /**
     * 更新时间(起始日期)
     */
     private String updateTimeBegin;
     
     /**
     * 更新时间(结束日期)
     */
     private String updateTimeEnd;
     
	public void setOrderBy(String orderBy) {
        this.orderBy = orderBy;
    }
    public String getOrderBy() {
        return orderBy;
    }
    
    public String getUserNameLike() {
        return userNameLike;
    }
    public void setUserNameLike(String userNameLike) {
        this.userNameLike = userNameLike;
    }
    
    public String getUserNameLeftLike() {
        return userNameLeftLike;
    }
    public void setUserNameLeftLike(String userNameLeftLike) {
        this.userNameLeftLike = userNameLeftLike;
    }
    
    public String getUserNameRightLike() {
        return userNameRightLike;
    }
    public void setUserNameRightLike(String userNameRightLike) {
        this.userNameRightLike = userNameRightLike;
    }
    
    public String getUserNameNotEqual() {
        return userNameNotEqual;
    }
    public void setUserNameNotEqual(String userNameNotEqual) {
        this.userNameNotEqual = userNameNotEqual;
    }
    
    public String getRoleLike() {
        return roleLike;
    }
    public void setRoleLike(String roleLike) {
        this.roleLike = roleLike;
    }
    
    public String getRoleLeftLike() {
        return roleLeftLike;
    }
    public void setRoleLeftLike(String roleLeftLike) {
        this.roleLeftLike = roleLeftLike;
    }
    
    public String getRoleRightLike() {
        return roleRightLike;
    }
    public void setRoleRightLike(String roleRightLike) {
        this.roleRightLike = roleRightLike;
    }
    
    public String getRoleNotEqual() {
        return roleNotEqual;
    }
    public void setRoleNotEqual(String roleNotEqual) {
        this.roleNotEqual = roleNotEqual;
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
    
 	public String getUpdateTimeBegin() {
        return updateTimeBegin;
    }
    public void setUpdateTimeBegin(String updateTimeBegin) {
        this.updateTimeBegin = updateTimeBegin;
    }
    
    public String getUpdateTimeEnd() {
        return updateTimeEnd;
    }
    public void setUpdateTimeEnd (String updateTimeEnd ){
        this.updateTimeEnd = updateTimeEnd;
    }
    

}
