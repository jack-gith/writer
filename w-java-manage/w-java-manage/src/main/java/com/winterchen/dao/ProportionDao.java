package com.winterchen.dao;

import com.winterchen.model.ProportionDomain;

public interface ProportionDao {

    int update(ProportionDomain proportionDomain);

    ProportionDomain list();
}
