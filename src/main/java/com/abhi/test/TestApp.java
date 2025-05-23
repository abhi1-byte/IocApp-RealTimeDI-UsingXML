package com.abhi.test;

import com.abhi.controller.CustomerController;
import com.abhi.vo.CustomerVO;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Scanner;

public class TestApp {
    public static void main(String[] args) {
        // Reading the inputs
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the customerName:: ");
        String customerName = scanner.next();

        System.out.print("Enter the customerAddress:: ");
        String customerAddress = scanner.next();

        System.out.print("Enter the principalAmount:: ");
        String pamt = scanner.next();

        System.out.print("Enter the RateOfInterest:: ");
        String rate = scanner.next();

        System.out.print("Enter the TimePeriod:: ");
        String time = scanner.next();

        CustomerVO customerVO = new CustomerVO();
        customerVO.setCustomerName(customerName);
        customerVO.setCustomerAddress(customerAddress);
        customerVO.setPamt(pamt);
        customerVO.setRate(rate);
        customerVO.setTime(time);

        ClassPathXmlApplicationContext factory = new ClassPathXmlApplicationContext("applicationContext.xml");
        System.out.println("****Container Started****");
        CustomerController custCtrl = factory.getBean("custCtrl", CustomerController.class);
        try {
            String result = custCtrl.processResult(customerVO);
            System.out.println(result);
        } catch (Exception e) {
            e.printStackTrace();
        }

        System.out.println("****Container Stopped*****");
    }
}
