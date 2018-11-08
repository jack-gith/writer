package com.winterchen.controller;

import com.winterchen.model.FileDomain;
import com.winterchen.service.user.FileUploadService;
import io.swagger.annotations.Api;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.Base64Utils;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 图片上传的几种方式
 *
 * @author Micity
 * @since 2018/5/31 0031
 */
@Api(tags = "0.0", description = "测试..", value = "测试..")
@CrossOrigin
@Controller
@RequestMapping("/uploads")
public class FileUploadController {

    @Autowired
    private FileUploadService fileUploadService;



    private static final Logger log = LoggerFactory.getLogger(FileUploadController.class);

    /**
     * 用户上传
     * @return
     */
    @GetMapping("/index.html")
    public String index() {
        return "index";
    }

    /**
     * 老师上传
     * @return
     */
    @GetMapping("/teacher.html")
    public String teacher() {
        return "teacher";
    }

    /**
     * 用户下载
     * @return
     */
    @GetMapping("/down.html")
    public String down() {
        return "down";
    }



    /**
     * 用户上传资料
     * @param file
     * @param openid
     * @param orderID
     * @param request
     * @return
     * @throws IOException
     */
    @PostMapping("/upload1")
    @ResponseBody
    public Map<String, String> upload1(@RequestParam("file") MultipartFile file,String openid,String orderID, HttpServletRequest request) throws IOException {
        System.err.println(openid);
        System.err.println(orderID);

        log.info("[文件类型] - [{}]", file.getContentType());
        log.info("[文件名称] - [{}]", file.getOriginalFilename());
        log.info("[文件大小] - [{}]", file.getSize());
        String url =  System.getProperty("user.dir")+"/src/main/resources/public/1/";


        Object list =  fileUploadService.list(file.getOriginalFilename());

        Field[] fields = list.getClass().getDeclaredFields();
        String varName = fields[2].getName();
        // 获取原来的访问控制权限
        boolean accessFlag = fields[2].isAccessible();
//        // 修改访问控制权限
        fields[2].setAccessible(true);
        try {
            int value =  (int)fields[2].get(list);
            System.err.println(value);

            if(value==0){
                fileUploadService.upload(orderID,openid,file.getOriginalFilename(),file.getSize()+"");
            }


        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        // 恢复访问控制权限
        fields[3].setAccessible(accessFlag);



        // TODO 将文件写入到指定目录（具体开发中有可能是将文件写入到云存储/或者指定目录通过 Nginx 进行 gzip 压缩和反向代理，此处只是为了演示故将地址写成本地电脑指定目录）
        file.transferTo(new File(url + file.getOriginalFilename()));
        Map<String, String> result = new HashMap<>(16);


        result.put("contentType", file.getContentType());
        result.put("fileName", file.getOriginalFilename());
        result.put("fileSize", file.getSize() + "");
        return result;
    }

    /**
     * 老师上传资料
     * @param file
     * @param openid
     * @param orderID
     * @param request
     * @return
     * @throws IOException
     */

    @PostMapping("/upload_1")
    @ResponseBody
    public Map<String, String> upload_1(@RequestParam("file") MultipartFile file,String openid,String orderID, HttpServletRequest request) throws IOException {


        log.info("[文件类型] - [{}]", file.getContentType());
        log.info("[文件名称] - [{}]", file.getOriginalFilename());
        log.info("[文件大小] - [{}]", file.getSize());
        String url =  System.getProperty("user.dir")+"/src/main/resources/public/2/";


        Object list =  fileUploadService.list1(file.getOriginalFilename());

        Field[] fields = list.getClass().getDeclaredFields();
        String varName = fields[2].getName();
        // 获取原来的访问控制权限
        boolean accessFlag = fields[2].isAccessible();
//        // 修改访问控制权限
        fields[2].setAccessible(true);
        try {
            int value =  (int)fields[2].get(list);
            System.err.println(value);

            if(value==0){
                fileUploadService.upload1(orderID,openid,file.getOriginalFilename(),file.getSize()+"");
            }


        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        // 恢复访问控制权限
        fields[3].setAccessible(accessFlag);



        // TODO 将文件写入到指定目录（具体开发中有可能是将文件写入到云存储/或者指定目录通过 Nginx 进行 gzip 压缩和反向代理，此处只是为了演示故将地址写成本地电脑指定目录）
        file.transferTo(new File(url + file.getOriginalFilename()));
        Map<String, String> result = new HashMap<>(16);


        result.put("contentType", file.getContentType());
        result.put("fileName", file.getOriginalFilename());
        result.put("fileSize", file.getSize() + "");
        return result;
    }


    /**
     * 获取老师上传的资料
     * @param openid
     * @param orderID
     * @param request
     * @return
     * @throws IOException
     */
    @PostMapping("/userDownLoad")
    @ResponseBody
    public Map<String, Object> userDownLoad(String openid,String orderID, HttpServletRequest request) throws IOException {

        Map<String,Object> modelMap = new HashMap<String, Object>();
        List list = fileUploadService.getFiles(orderID);
        String url =  "http://localhost:8099/2/";
        Object[] objs = list.toArray();
        for (int x = 0; x < objs.length; x++){
            FileDomain s = (FileDomain)objs[x];
            System.out.println(s.getFile());
            s.setFile(url+s.getFile());

        }
        modelMap.put("data",list);
        modelMap.put("success",true);

        return  modelMap;
    }

    /**
     * 获取用户上传的资料
     * @param openid
     * @param orderID
     * @param request
     * @return
     * @throws IOException
     */
    @PostMapping("/getUserFile")
    @ResponseBody
    public Map<String, Object> getUserFile(String openid,String orderID, HttpServletRequest request) throws IOException {

        Map<String,Object> modelMap = new HashMap<String, Object>();
        List list = fileUploadService.getFiles_user(orderID);
        String url =  "http://localhost:8099/1/";
        Object[] objs = list.toArray();
        for (int x = 0; x < objs.length; x++){
            FileDomain s = (FileDomain)objs[x];
            System.out.println(s.getFile());
            s.setFile(url+s.getFile());

        }
        modelMap.put("data",list);
        modelMap.put("success",true);

        return  modelMap;
    }

    @PostMapping("/upload2")
    @ResponseBody
    public List<Map<String, String>> upload2(@RequestParam("file") MultipartFile[] files) throws IOException {
        if (files == null || files.length == 0) {
            return null;
        }
        List<Map<String, String>> results = new ArrayList<>();
        for (MultipartFile file : files) {
            // TODO Spring Mvc 提供的写入方式
            file.transferTo(new File("/Users/yangfeng/work/test_img/" + file.getOriginalFilename()));
            Map<String, String> map = new HashMap<>(16);
            map.put("contentType", file.getContentType());
            map.put("fileName", file.getOriginalFilename());
            map.put("fileSize", file.getSize() + "");
            results.add(map);
        }
        return results;
    }

    @PostMapping("/upload3")
    @ResponseBody
    public void upload2(String base64) throws IOException {
        // TODO BASE64 方式的 格式和名字需要自己控制（如 png 图片编码后前缀就会是 data:image/png;base64,）
        final File tempFile = new File("/Users/yangfeng/work/test_img/node1.jpg");
        // TODO 防止有的传了 data:image/png;base64, 有的没传的情况
        String[] d = base64.split("base64,");
        final byte[] bytes = Base64Utils.decodeFromString(d.length > 1 ? d[1] : d[0]);
        FileCopyUtils.copy(bytes, tempFile);

    }


}
