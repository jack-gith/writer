package com.winterchen.service.user.impl;

import com.winterchen.dao.ArticleTypeDao;
import com.winterchen.model.ArticleTypeDomain;
import com.winterchen.service.user.ArticleTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service(value = "ArticleTypeService")
public class ArticleTypeServiceImpl implements ArticleTypeService {
    @Autowired
    private ArticleTypeDao articleTypeDao;

    @Override
    public List<ArticleTypeDomain> selectAll(String code) {
        if(code == null){
            throw new RuntimeException("code值不能为空！");
        }

        return  articleTypeDao.select(code);
    }
}
