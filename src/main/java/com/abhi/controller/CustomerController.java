package com.abhi.controller;

import com.abhi.dto.CustomerDTO;
import com.abhi.service.CustomerServiceImpl;
import com.abhi.vo.CustomerVO;

public class CustomerController {
    private CustomerServiceImpl customerService;

    public CustomerController(CustomerServiceImpl customerService) {
        this.customerService = customerService;
        System.out.println("CustomerController :: One param--->"+customerService.getClass().getName());
    }

    public String processResult(CustomerVO customerVO) throws Exception{
        CustomerDTO customerDTO = new CustomerDTO();
        customerDTO.setCustomerName(customerVO.getCustomerName());
        customerDTO.setCustomerAddress(customerVO.getCustomerAddress());
        customerDTO.setPamt(Float.parseFloat(customerVO.getPamt()));
        customerDTO.setRate(Float.parseFloat(customerVO.getRate()));
        customerDTO.setTime(Float.parseFloat(customerVO.getTime()));

        return customerService.calculateSimpleInterest(customerDTO);
    }


}
