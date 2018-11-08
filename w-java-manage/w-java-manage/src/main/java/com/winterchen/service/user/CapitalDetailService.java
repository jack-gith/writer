package com.winterchen.service.user;

import com.github.pagehelper.PageInfo;
import com.winterchen.model.CapitalDetail;

import java.util.Map;

/**
 * Title:CapitalDetailService
 * Description:Service层
 * Company:装修项目
 * @author fc
 * @date 2018-10-03
 */
public interface CapitalDetailService {
    PageInfo<CapitalDetail> getCapitalDetailList(Map<String, Object> params) throws Exception;

    boolean addCapitalDetail(CapitalDetail capitalDetail) throws Exception;

    Object findWithdraw(String WithdrawNum) throws Exception;



   
}
