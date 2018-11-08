package com.winterchen.service.user;

import com.winterchen.model.FileDomain;

import java.util.List;

public interface FileUploadService {
        boolean upload(String orderID,String openid,String file,String size);
        Object list(String file);

        boolean upload1(String orderID,String openid,String file,String size);
        Object list1(String file);


        List getFiles(String orderID);

        List getFiles_user(String orderID);


}
