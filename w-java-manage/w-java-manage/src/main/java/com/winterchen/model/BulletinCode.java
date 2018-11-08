package com.winterchen.model;



import java.util.Date;


/**
 * Title: Bulletin
 * Description: 留言表查询条件
 * Company: 写手项目
 * @author: fy
 * @date:   2018-11-02
 */
public class BulletinCode implements java.io.Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 主键
     **/
    private Integer id;

    /**
     * 内容
     **/
    private String content;

    /**
     * 文章id
     **/
    private Integer articleId;

    /**
     * 留言者用户id
     **/
    private Integer userId;

    /**
     * 回复内容
     **/
    private String reply;

    /**
     * 创建时间
     **/
    private Date createTime;

    /**
     * 回复时间
     **/
    private Date replyTime;

    public BulletinCode() {
    }

    public BulletinCode(Integer id, String content, Integer articleId, Integer userId, String reply, Date createTime, Date replyTime) {
        this.id = id;
        this.content = content;
        this.articleId = articleId;
        this.userId = userId;
        this.reply = reply;
        this.createTime = createTime;
        this.replyTime = replyTime;
    }


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }


    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }


    public Integer getArticleId() {
        return articleId;
    }

    public void setArticleId(Integer articleId) {
        this.articleId = articleId;
    }


    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }


    public String getReply() {
        return reply;
    }

    public void setReply(String reply) {
        this.reply = reply;
    }


    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }


    public Date getReplyTime() {
        return replyTime;
    }

    public void setReplyTime(Date replyTime) {
        this.replyTime = replyTime;
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
     * 内容(全模糊)
     */
    private String contentLike;

    /**
     * 内容 (模糊查询%)
     */
    private String contentLeftLike;

    /**
     * %模糊查询 内容
     */
    private String contentRightLike;

    /**
     * 内容(不等于<>)
     */
    private String contentNotEqual;

    /**
     * 回复内容(全模糊)
     */
    private String replyLike;

    /**
     * 回复内容 (模糊查询%)
     */
    private String replyLeftLike;

    /**
     * %模糊查询 回复内容
     */
    private String replyRightLike;

    /**
     * 回复内容(不等于<>)
     */
    private String replyNotEqual;

    /**
     * 创建时间(起始日期)
     */
    private String createTimeBegin;

    /**
     * 创建时间(结束日期)
     */
    private String createTimeEnd;

    /**
     * 回复时间(起始日期)
     */
    private String replyTimeBegin;

    /**
     * 回复时间(结束日期)
     */
    private String replyTimeEnd;

    public void setOrderBy(String orderBy) {
        this.orderBy = orderBy;
    }
    public String getOrderBy() {
        return orderBy;
    }

    public String getContentLike() {
        return contentLike;
    }
    public void setContentLike(String contentLike) {
        this.contentLike = contentLike;
    }

    public String getContentLeftLike() {
        return contentLeftLike;
    }
    public void setContentLeftLike(String contentLeftLike) {
        this.contentLeftLike = contentLeftLike;
    }

    public String getContentRightLike() {
        return contentRightLike;
    }
    public void setContentRightLike(String contentRightLike) {
        this.contentRightLike = contentRightLike;
    }

    public String getContentNotEqual() {
        return contentNotEqual;
    }
    public void setContentNotEqual(String contentNotEqual) {
        this.contentNotEqual = contentNotEqual;
    }

    public String getReplyLike() {
        return replyLike;
    }
    public void setReplyLike(String replyLike) {
        this.replyLike = replyLike;
    }

    public String getReplyLeftLike() {
        return replyLeftLike;
    }
    public void setReplyLeftLike(String replyLeftLike) {
        this.replyLeftLike = replyLeftLike;
    }

    public String getReplyRightLike() {
        return replyRightLike;
    }
    public void setReplyRightLike(String replyRightLike) {
        this.replyRightLike = replyRightLike;
    }

    public String getReplyNotEqual() {
        return replyNotEqual;
    }
    public void setReplyNotEqual(String replyNotEqual) {
        this.replyNotEqual = replyNotEqual;
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

    public String getReplyTimeBegin() {
        return replyTimeBegin;
    }
    public void setReplyTimeBegin(String replyTimeBegin) {
        this.replyTimeBegin = replyTimeBegin;
    }

    public String getReplyTimeEnd() {
        return replyTimeEnd;
    }
    public void setReplyTimeEnd (String replyTimeEnd ){
        this.replyTimeEnd = replyTimeEnd;
    }


}
