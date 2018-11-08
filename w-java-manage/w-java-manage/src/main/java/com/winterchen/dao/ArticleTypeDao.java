package com.winterchen.dao;

import com.winterchen.model.ArticleTypeDomain;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ArticleTypeDao {

    List<ArticleTypeDomain> select(@Param("code") String code);

}
