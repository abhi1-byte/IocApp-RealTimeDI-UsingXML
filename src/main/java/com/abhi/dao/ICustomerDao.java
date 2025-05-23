package com.abhi.dao;

import com.abhi.bo.CustomerBO;

public interface ICustomerDao{
    int save(CustomerBO customerBO) throws Exception;
}
