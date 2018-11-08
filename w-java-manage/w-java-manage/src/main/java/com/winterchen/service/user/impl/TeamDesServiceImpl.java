package com.winterchen.service.user.impl;

import com.winterchen.dao.TeamDesDao;
import com.winterchen.model.TeamDesDomain;
import com.winterchen.service.user.TeamDesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service(value = "TeamDesService")
public class TeamDesServiceImpl implements TeamDesService {

    @Autowired
    private TeamDesDao teamDesDao;

    @Override
    public TeamDesDomain selectOne(String team) {
        if(team == null || team == ""){
            throw new RuntimeException("team不能为空");
        }

        return teamDesDao.select(team);
    }
}
