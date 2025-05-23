package com.abhi.service;

import com.abhi.bo.CustomerBO;
import com.abhi.dao.CustomerDaoImpl;
import com.abhi.dto.CustomerDTO;

public class CustomerServiceImpl implements ICustomerService {
    private CustomerDaoImpl customerDao;

    public CustomerServiceImpl(CustomerDaoImpl customerDao) {
        this.customerDao = customerDao;
        System.out.println("CustomerServiceImpl :: One param--->"+customerDao.getClass().getName());
    }

    @Override
    public String calculateSimpleInterest(CustomerDTO customerDTO) throws Exception {
        float interestAmt = (customerDTO.getPamt() * customerDTO.getTime() * customerDTO.getRate())/100.0f;
        CustomerBO bo = new CustomerBO();
        bo.setCustomerName(customerDTO.getCustomerName());
        bo.setCustomerAddress(customerDTO.getCustomerAddress());
        bo.setPamt(customerDTO.getPamt());
        bo.setRate(customerDTO.getRate());
        bo.setTime(customerDTO.getTime());
        bo.setInterestAmt(interestAmt);
        int rowsInserted = customerDao.save(bo);
        /*if(rowsInserted>=1){
            return "Insertion Successful";
        }else
            return "Insertion Failed";*/

        return rowsInserted == 0?"Customer registration Failed":"Customer registration Successful,---->SimpleInterestAmount::"+interestAmt;
    }
}
