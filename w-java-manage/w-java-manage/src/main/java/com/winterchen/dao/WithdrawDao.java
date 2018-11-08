package com.winterchen.dao;

import com.winterchen.model.Withdraw;
import java.util.List;
import java.util.Map;

/**
 * Title:WithdrawService
 * Description:提现记录表Map DAO层
 * Company:写手项目
 * @author fy
 * @date 2018-10-30
 */
public interface WithdrawDao
{
    List<Withdraw> getListPrmMapRtnBean(Map<String, Object> params) throws Exception;

    boolean getInsert(Withdraw withdraw) throws Exception;

    boolean getUpdate(Withdraw withdraw) throws Exception;

    Object getBeanById(String WithdrawNum) throws Exception;
   
}
