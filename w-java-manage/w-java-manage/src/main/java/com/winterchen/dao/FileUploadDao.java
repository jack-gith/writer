package com.winterchen.dao;

import com.winterchen.model.FileDomain;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface FileUploadDao {
    int fileUpload(@Param("orderID") String orderID,@Param("openid") String openid, @Param("file") String file,@Param("size") String size);
    List<FileDomain> findFile(@Param("file") String file);

    int fileUpload1(@Param("orderID") String orderID,@Param("openid") String openid, @Param("file") String file,@Param("size") String size);
    List<FileDomain> findFile1(@Param("file") String file);


    List<FileDomain> orderDown(@Param("orderID") String orderID);
    List<FileDomain> orderDown_user(@Param("orderID") String orderID);

}
