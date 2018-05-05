/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.modal;

import com.entity.Users;
import java.sql.Connection;
import java.sql.Date;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Tung
 */
public class UserModel {
     public String select(String criteria) throws Exception {
        String password="";
        String query = "select * from SignAcc "+criteria;
        Connection conn = new DBContext().getConnection();
        ResultSet rs = conn.prepareStatement(query).executeQuery();
        while (rs.next()) {
           password = rs.getString("Password");  
        }
        rs.close();
        conn.close();
         
        return password;
    }
}
