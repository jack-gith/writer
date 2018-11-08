package com.winterchen.dao;

import com.winterchen.model.TeamDesDomain;
import org.apache.ibatis.annotations.Param;

public interface TeamDesDao {

    TeamDesDomain select(@Param("team") String team);
}
