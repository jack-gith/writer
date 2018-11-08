package com.winterchen.dao;

import com.winterchen.model.DictDomain;
import com.winterchen.model.TeamDomain;
import com.winterchen.model.dto.UserDto;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface TeamDao {

    int insert(TeamDomain teamDomain);

    int update(TeamDomain teamDomain);

    TeamDomain showData();

    List<DictDomain> dict_show(@Param("code") String code);

    List<UserDto> searchTeacher();
}
