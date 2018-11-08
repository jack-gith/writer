package com.winterchen.dao;

import com.winterchen.model.Log;

import java.util.List;

public interface LogDao {


    int insertLog(Log log);

    List<Log> selectAllLog(Log log);
}
