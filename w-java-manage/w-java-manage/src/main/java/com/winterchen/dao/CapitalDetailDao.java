package com.winterchen.dao;

import com.winterchen.model.CapitalDetail;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * Title:CapitalDetailService
 * Description:资金明细表Map DAO层
 * Company:写手项目
 * @author fy
 * @date 2018-10-30
 */
public interface CapitalDetailDao
{
    List<CapitalDetail> getListPrmMapRtnBean(Map<String, Object> params) throws Exception;

    boolean getInsert(CapitalDetail capitalDetail) throws Exception;

    Object getBeanById(String WithdrawNum) throws Exception;

    Map getUserStatisticsBalance(@Param("ownerInspector") String ownerInspector, @Param("ownerTeacher") String ownerTeacher) throws Exception;
   
}
