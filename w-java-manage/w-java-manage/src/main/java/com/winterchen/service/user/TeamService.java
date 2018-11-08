package com.winterchen.service.user;

import com.winterchen.dao.TeamDao;
import com.winterchen.model.AccountDomain;
import com.winterchen.model.DictDomain;
import com.winterchen.model.TeamDomain;
import com.winterchen.model.dto.UserDto;

import java.util.List;

public interface TeamService {

    boolean insertAndUpdate(TeamDomain teamDomain);

    TeamDomain show();

    List<DictDomain> dict_show(String code);


    List<UserDto> searchTeachers();

}
