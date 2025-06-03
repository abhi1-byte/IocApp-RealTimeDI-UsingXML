package com.abhi.controller;

import com.abhi.dto.CustomerDTO;
import com.abhi.service.CustomerServiceImpl;
import com.abhi.vo.CustomerVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component(value = "controller")
//default reference is camel case convention of classname
public class CustomerController {

    @Autowired
    private CustomerServiceImpl customerService;

    static {
        System.out.println("CustomerController.class file is loaded..");
    }

    public CustomerController() {
        System.out.println("CustomerController.class object is instantiated...");
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
