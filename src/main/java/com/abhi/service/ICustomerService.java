package com.abhi.service;

import com.abhi.dto.CustomerDTO;

public interface ICustomerService{
    String calculateSimpleInterest(CustomerDTO customerDTO) throws Exception;
}
