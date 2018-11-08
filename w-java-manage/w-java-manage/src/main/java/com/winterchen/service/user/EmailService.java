package com.winterchen.service.user;

import javax.mail.MessagingException;
public interface EmailService {


    /**
     * 发送HTML邮件
     * @param to
     * @param subject
     * @param content
     * @throws MessagingException
     */
    void sendHtmlMail(String to, String subject, String content) throws MessagingException;

    void sendHtmlMail(String to, String subject, String content, String... cc) throws MessagingException;
}
