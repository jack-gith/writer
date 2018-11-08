package com.winterchen.dao;

import com.winterchen.model.Bulletin;
import java.util.List;
import java.util.Map;

/**
 * Title:BulletinService
 * Description:留言表Map DAO层
 * Company:写手项目
 * @author fy
 * @date 2018-11-02
 */
public interface BulletinDao {
    List<Bulletin> getListPrmMapRtnBean(Map<String, Object> params) throws Exception;

    boolean getInsert(Bulletin bulletin) throws Exception;

    boolean getUpdate(Bulletin bulletin) throws Exception;

    Object getBeanById(String WithdrawNum) throws Exception;

}
