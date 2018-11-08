package com.winterchen.service.user;

import com.winterchen.model.ProportionDomain;

public interface ProportionService {

    boolean update(ProportionDomain proportionDomain);
    ProportionDomain list();
}
