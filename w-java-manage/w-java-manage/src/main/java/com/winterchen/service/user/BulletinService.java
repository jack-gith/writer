package com.winterchen.service.user;

import com.github.pagehelper.PageInfo;
import com.winterchen.model.Bulletin;

import java.util.Map;

/**
 * Title:BulletinService
 * Description:Service层
 * Company:装修项目
 * @author fc
 * @date 2018-10-03
 */
public interface BulletinService
{

    PageInfo<Bulletin> getBulletinList(Map<String, Object> params) throws Exception;

    boolean addBulletin(Bulletin bulletin) throws Exception;

    boolean updateBulletin(Bulletin bulletin) throws Exception;

    Object findBulletin(String bulletinNum) throws Exception;

}
