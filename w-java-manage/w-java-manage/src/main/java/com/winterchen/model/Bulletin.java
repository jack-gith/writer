package com.winterchen.model;



import java.util.Date;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * Title:Bulletin
 * Description:留言表实体类
 * Company:写手项目
 * Table: w_bulletin
 * @author fy
 * @date 2018-11-02
 */

public class Bulletin implements java.io.Serializable {

    private static final long serialVersionUID = 1L;


    @ApiModelProperty(value = "主键", name = "id")
    private Integer id;

    @ApiModelProperty(value = "内容", name = "content")
    private String content;

    @ApiModelProperty(value = "文章id", name = "articleId")
    private String articleId;

    @ApiModelProperty(value = "留言者用户id", name = "userId")
    private String userId;

    @ApiModelProperty(value = "回复内容", name = "reply")
    private String reply;

    @ApiModelProperty(value = "创建时间", name = "createTime")
    private Date createTime;

    @ApiModelProperty(value = "回复时间", name = "replyTime")
    private Date replyTime;

    public Integer getId()
    {
        return id;
    }

    public void setId(Integer id)
    {
        this.id = id;
    }

    public String getContent()
    {
        return content;
    }

    public void setContent(String content)
    {
        this.content = content;
    }

    public String getArticleId() {
        return articleId;
    }

    public void setArticleId(String articleId) {
        this.articleId = articleId;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getReply()
    {
        return reply;
    }

    public void setReply(String reply)
    {
        this.reply = reply;
    }

    public Date getCreateTime()
    {
        return createTime;
    }

    public void setCreateTime(Date createTime)
    {
        this.createTime = createTime;
    }

    public Date getReplyTime()
    {
        return replyTime;
    }

    public void setReplyTime(Date replyTime)
    {
        this.replyTime = replyTime;
    }
}
