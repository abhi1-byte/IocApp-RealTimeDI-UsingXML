package com.abhi.dao;

import com.abhi.bo.CustomerBO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

@Repository(value = "dao")
public class CustomerDaoImpl implements ICustomerDao {
    static {
        System.out.println("CustomerDaoImpl.class file is loaded..");
    }

    public CustomerDaoImpl() {
        System.out.println("CustomerDaoImpl.class object is instantiated...");
    }

    @Autowired
    private DataSource dataSource;

    @Override
    public int save(CustomerBO customerBO) throws Exception {
        int rowsInserted = 0;
        String insertQuery = "insert into customertbl(`custName`,`custAddr`,`pamt`,`rate`,`time`,`interestAmount`) VALUES(?,?,?,?,?,?)";
        System.out.println(insertQuery);
        try (Connection conn = dataSource.getConnection(); PreparedStatement pstmt = conn.prepareStatement(insertQuery)) {
            if (conn != null && pstmt != null) {
                pstmt.setString(1, customerBO.getCustomerName());
                pstmt.setString(2, customerBO.getCustomerAddress());
                pstmt.setFloat(3, customerBO.getPamt());
                pstmt.setFloat(4, customerBO.getRate());
                pstmt.setFloat(5, customerBO.getTime());
                pstmt.setFloat(6, customerBO.getInterestAmt());
                rowsInserted = pstmt.executeUpdate();
            }
        } catch (SQLException e) {
            e.printStackTrace();
            throw e;
        } catch (Exception e) {
            e.printStackTrace();
            throw e;
        }
        return rowsInserted;
    }
}
/*DataSource(I) ===> javax.sql.DataSource;
        |
        |
  DriverManagerDataSource ===> org.springframework.jdbc.datasource.DriverManagerDataSource
        |
        |
   HikariDataSource(c) ====> com.zaxxer.hikari.HikariDataSource
* */
