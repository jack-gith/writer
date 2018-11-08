package com.winterchen.service.user;


import com.winterchen.model.ArticleTypeDomain;

import java.util.List;

public interface ArticleTypeService {
    List<ArticleTypeDomain> selectAll(String code);
}
