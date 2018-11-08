package com.winterchen.service.user.impl;

import com.winterchen.dao.TeamDao;
import com.winterchen.model.AccountDomain;
import com.winterchen.model.DictDomain;
import com.winterchen.model.TeamDomain;
import com.winterchen.model.dto.UserDto;
import com.winterchen.service.user.TeamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;


@Service(value = "TeamService")
public class TeamServiceImpl implements TeamService {


    @Autowired
    private  TeamDao teamDao;

    @Override
    public boolean insertAndUpdate(TeamDomain teamDomain) {
        if(teamDomain.getId()==null || teamDomain.getId()==""){
            String uuid = UUID.randomUUID().toString().replaceAll("-", "");
            teamDomain.setId(uuid);
            int effectNum =  teamDao.insert(teamDomain);
            if(effectNum>0){
                return  true;
            }else {
                throw new RuntimeException("新增失败!");
            }
        }else{

            int effectNum =  teamDao.update(teamDomain);
            if(effectNum>0){
                return  true;
            }else{
                throw new RuntimeException("更新失败!");
            }
        }
    }

    @Override
    public TeamDomain show() {
        return teamDao.showData();
    }

    @Override
    public List<DictDomain> dict_show(String code) {
        return teamDao.dict_show(code);
    }

    @Override
    public List<UserDto> searchTeachers() {
        return  teamDao.searchTeacher();
    }


}
