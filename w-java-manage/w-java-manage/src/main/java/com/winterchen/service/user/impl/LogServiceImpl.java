package com.winterchen.service.user.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.winterchen.dao.LogDao;
import com.winterchen.model.Log;
import com.winterchen.service.user.LogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service(value = "logService")
public class LogServiceImpl implements LogService {

    @Autowired
    private LogDao logDao;//这里会报错，但是并不会影响

    @Override
    public boolean insertLog(Log log) {
        logDao.insertLog(log);
        return true;
    }

    @Override
    public PageInfo<Log> findAllLog(int pageNum,int pageSize){
        PageHelper.startPage(pageNum,pageSize);

        Log log = new Log();
        List<Log> logs = logDao.selectAllLog(log);

        PageInfo result = new PageInfo(logs);

        return  result;


    }
}
