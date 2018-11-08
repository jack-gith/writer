package com.winterchen.controller;


import com.winterchen.service.user.EmailService;
import com.winterchen.util.email.result.ServerResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * ┏┓　　　┏┓
 * ┏┛┻━━━┛┻┓
 * ┃　　　　　　　┃
 * ┃　　　━　　　┃
 * ┃　┳┛　┗┳　┃
 * ┃　　　　　　　┃
 * ┃　　　┻　　　┃
 * ┃　　　　　　　┃
 * ┗━┓　　　┏━┛
 * 　　┃　　　┃神兽保佑
 * 　　┃　　　┃代码无BUG！
 * 　　┃　　　┗━━━┓
 * 　　┃　　　　　　　┣┓
 * 　　┃　　　　　　　┏┛
 * 　　┗┓┓┏━┳┓┏┛
 * 　　　┃┫┫　┃┫┫
 * 　　　┗┻┛　┗┻┛
 * */


@RestController
@RequestMapping("email")
public class EmailController {

    @Autowired
    private EmailService mailService;//注入发送邮件的各种实现方法


    /**
     * 发送HTMl邮件
     * @return
     */
    @RequestMapping("/htmlEmail")
    public ServerResponse htmlEmail(String email,String nickName,String openid,String orderID){
//        String a = "957275165@qq.com";
        System.err.println(email);
        try {
            mailService.sendHtmlMail(email,"W论文辅导平台","<body style=\"text-align: center;margin-left: auto;margin-right: auto;\">\n"
                    + " <div id=\"welcome\" style=\"text-align: center;position: absolute;\" >\n"
                    +"      <h3>W论文辅导平台</h3>\n"
                    +"      <span style=\"display:block;text-align:left;\">亲爱的用户 :"+nickName +"</span>"
                    + "     <div style=\"text-align: left; padding: 10px 0px;text-indent:2em;\">\n"
                    + "您可以点击下面的链接后，进入上传资料的页面，此链接有效时长为36小时，请您尽快上传资料。\n</div>\n"
                    +"<a href=\"http://www.baidu.com\" style='display:block;text-indent:2em;text-align: left; '>http://192.168.1.82:8099/uploads/index.html?openid="+openid+"&orderID="+orderID+"</a>"
                    + "     <div\n" + "         style=\" padding: 4px 0; text-indent:2em;text-align: left;\">如果您有任何问题，欢迎您关注微信小程序——<strong>W论文辅导平台</strong>。\n</div>\n"

                    + " </div>\n" + "</body>");
        }catch (Exception ex){
            ex.printStackTrace();
            return ServerResponse.createByError(-1,"邮件发送失败!!");
        }
        return ServerResponse.createBySuccess();
    }

}
