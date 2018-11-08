package com.winterchen.service.user.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.winterchen.dao.FileUploadDao;
import com.winterchen.model.FileDomain;
import com.winterchen.model.OrderInfoDomain;
import com.winterchen.service.user.FileUploadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service(value = "FileUploadService")
public class FileUploadServiceImpl implements FileUploadService {

    @Autowired
    private FileUploadDao fileUploadDao;

    @Override
    public boolean upload(String orderID, String openid, String file,String size) {

        int effectNum = fileUploadDao.fileUpload(orderID, openid, file,size);
        if (effectNum > 0) {
            return true;
        } else {
            throw new RuntimeException("文件上传失败！");
        }
    }

    @Override
    public Object list(String file) {
        PageHelper.startPage(1,10);
        OrderInfoDomain query = new OrderInfoDomain();
        List<FileDomain> orderManageDtos =   fileUploadDao.findFile(file);
        return new PageInfo(orderManageDtos);
    }

    @Override
    public boolean upload1(String orderID, String openid, String file,String size) {

        int effectNum = fileUploadDao.fileUpload1(orderID, openid, file,size);
        if (effectNum > 0) {
            return true;
        } else {
            throw new RuntimeException("文件上传失败！");
        }
    }

    @Override
    public Object list1(String file) {
        PageHelper.startPage(1,10);
//        OrderInfoDomain query = new OrderInfoDomain();
        List<FileDomain> orderManageDtos =   fileUploadDao.findFile1(file);
        return new PageInfo(orderManageDtos);
    }

    @Override
    public List<FileDomain> getFiles(String orderID) {
        return  fileUploadDao.orderDown(orderID);
    }

    @Override
    public List<FileDomain> getFiles_user(String orderID) {
        return  fileUploadDao.orderDown_user(orderID);
    }
}
