package com.abhi.service;

import com.abhi.bo.CustomerBO;
import com.abhi.dao.CustomerDaoImpl;
import com.abhi.dto.CustomerDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service(value = "service")
public class CustomerServiceImpl implements ICustomerService {
    static {
        System.out.println("CustomerServiceImpl.class file is loaded..");
    }

    public CustomerServiceImpl() {
        System.out.println("CustomerServiceImpl.class object is instantiated...");
    }

    @Autowired
    private CustomerDaoImpl customerDao;

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
