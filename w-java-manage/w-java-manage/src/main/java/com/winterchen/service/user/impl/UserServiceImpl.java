package com.winterchen.service.user.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
//import com.winterchen.dao.LogDao;
import com.winterchen.dao.UserDao;
import com.winterchen.model.Log;
import com.winterchen.model.UserDomain;
import com.winterchen.service.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


//实现UserService接口（）   ,implements可以实现多个接口。  server层主要实现业务逻辑

@Service(value = "userService")
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;


    /**
     * 新增数据|编辑数据
     * @param user
     * @return
     */
    @Override
    public boolean addUser(UserDomain user) {

        if(user.getUserId() != null){
            int effectedNum = userDao.updateOne(user);
            if(effectedNum>0){
                return  true;
            }else{
                throw new RuntimeException("更新记录失败!");
            }
        }else{
            int effectedNum = userDao.insert(user);
            if(effectedNum>0){
                return  true;
            }else{
                throw new RuntimeException("新增记录失败!");
            }
        }
    }

    /**
     * 查询单条记录
     * @param
     * @return
     */
    @Override
    public UserDomain selectOneUser(int userId) {

        return userDao.selectOne(userId);


    }

    @Override
    public boolean delOneUser(int areaId){
        if (areaId > 0) {
            try {
                // 删除区域信息
                int effectedNum = userDao.delOne(areaId);
                if (effectedNum > 0) {
                    return true;
                } else {
                    throw new RuntimeException("删除记录失败!");
                }
            } catch (Exception e) {
                throw new RuntimeException("删除记录失败:" + e.toString());
            }
        } else {
            throw new RuntimeException("记录Id不能为空！");
        }
    }



    /*
    * 这个方法中用到了我们开头配置依赖的分页插件pagehelper
    * 很简单，只需要在service层传入参数，然后将参数传递给一个插件的一个静态方法即可；
    * pageNum 开始页数
    * pageSize 每页显示的数据条数
    * */
    @Override
    public PageInfo<UserDomain> findAllUser(int pageNum, int pageSize, String name, String phone) {

//        System.out.println("-----------------");
//        System.out.println(name);
//        System.out.println(phone);
//        System.out.println("-----------------");

        //将参数传给这个方法就可以实现物理分页了，非常简单。
        PageHelper.startPage(pageNum, pageSize);

        UserDomain query = new UserDomain();

//        System.out.println("+++++");
//        System.out.println(query);
//        System.out.println("+++++");
        query.setUserName(name);
        query.setPhone(phone);
        List<UserDomain> userDomains = userDao.selectUsers(query);


        PageInfo result = new PageInfo(userDomains);
        return result;
    }
}
