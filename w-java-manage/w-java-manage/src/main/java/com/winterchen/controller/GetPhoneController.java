package com.winterchen.controller;
import com.winterchen.model.JsonResult;
import com.winterchen.util.HttpRequest;
import org.apache.tomcat.util.codec.binary.Base64;
import org.springframework.web.bind.annotation.*;
import net.sf.json.JSONObject;
import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import java.security.spec.AlgorithmParameterSpec;






@RestController
@RequestMapping(value = "/account")
public class GetPhoneController {
    //获取手机号
    @PostMapping("/getPhone")
    public Object JsonResult(String code, String encryptedData, String iv) {

        if (code == null || code.length() == 0) {
            return new JsonResult("Conde 不能为空");
        }		// 小程序唯一标识 (在微信小程序管理后台获取)
        String wxspAppid = "wx864093399739afc9";
        // 小程序的 app secret (在微信小程序管理后台获取)
        String wxspSecret = "1519a060c3b121a4368a0aba06e447a5";		// 授权（必填）
        String grant_type = "authorization_code";		// 请求参数
        String params = "appid=" + wxspAppid + "&secret=" + wxspSecret + "&js_code=" + code + "&grant_type="+ grant_type;		// 发送请求
        String sr = HttpRequest.sendGet("https://api.weixin.qq.com/sns/jscode2session", params);		// 解析相应内容（转换成json对象）
        JSONObject json = JSONObject.fromObject(sr);		// 获取会话密钥（session_key）
        String session_key = json.get("session_key").toString();		// 用户的唯一标识（openid）
        String openid = (String) json.get("openid");
        try {
            System.out.println(encryptedData);
            System.out.println(session_key);
            System.out.println(iv);
            byte[] encrypData = Base64.decodeBase64(encryptedData);
            byte[] ivData = org.apache.tomcat.util.codec.binary.Base64.decodeBase64(iv);
            byte[] sessionKey = Base64.decodeBase64(session_key);
            System.out.println(decrypt(sessionKey, ivData, encrypData));
            String result = decrypt(sessionKey, ivData, encrypData);
            if (null != result && result.length() > 0) {
                return new JsonResult(result);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return new JsonResult("解密失败");


    }
    public static String decrypt(byte[] key, byte[] iv, byte[] encData) throws Exception {
        AlgorithmParameterSpec ivSpec = new IvParameterSpec(iv);
        Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
        SecretKeySpec keySpec = new SecretKeySpec(key, "AES");
        cipher.init(Cipher.DECRYPT_MODE, keySpec, ivSpec);		// 解析解密后的字符串
        return new String(cipher.doFinal(encData), "UTF-8");
    }











}
