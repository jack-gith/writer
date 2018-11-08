package com.winterchen.service.user;

import com.github.pagehelper.PageInfo;
import com.winterchen.model.Withdraw;
import java.util.Map;

/**
 * Title:WithdrawService
 * Description:Service层
 * Company:装修项目
 * @author fc
 * @date 2018-10-03
 */
public interface WithdrawService {

    PageInfo<Withdraw> getWithdrawList(Map<String, Object> params) throws Exception;

    boolean addWithdraw(Withdraw withdraw) throws Exception;

    boolean updateWithdraw(Withdraw withdraw) throws Exception;

    Object findWithdraw(String WithdrawNum) throws Exception;

}
