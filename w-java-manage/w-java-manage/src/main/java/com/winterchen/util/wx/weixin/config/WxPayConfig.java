package com.winterchen.util.wx.weixin.config;

/**
 * @Description:
 * @Date: 2018/4/8
 * @Author: wcf
 */
public class WxPayConfig {
    //小程序appid
    public static final String appid = "wx864093399739afc9";
    //微信支付的商户id
    public static final String mch_id = "1516510551";
    //微信支付的商户密钥
    public static final String key = "K460584casasasasasasasasas123456";
    //支付成功后的服务器回调url
    public static final String notify_url = "https://??/weixin/wxNotify";
    //签名方式
    public static final String SIGNTYPE = "MD5";
    //交易类型
    public static final String TRADETYPE = "JSAPI";
    //微信统一下单接口地址
    public static final String pay_url = "https://api.mch.weixin.qq.com/pay/unifiedorder";
}
