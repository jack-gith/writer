package com.winterchen.service.user;

import com.github.pagehelper.PageInfo;
import com.winterchen.model.Log;

public interface LogService {


    boolean insertLog(Log log);


    PageInfo<Log> findAllLog(int pageNum, int pageSize);
}
