package com.modal;

import com.entity.NhaXe;
import java.sql.Connection;
import java.sql.Date;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Tung
 */
public class NhaXeModel {
     public List<NhaXe> select(String criteria) throws Exception {
        List<NhaXe> nhaxe = new ArrayList<>();
        String query = "select * from NhaXe "+criteria;
        Connection conn = new DBContext().getConnection();
        ResultSet rs = conn.prepareStatement(query).executeQuery();
        while (rs.next()) {
           
            String tennhaxe = rs.getString("TenNhaXe");
            String manhaxe = rs.getString("MaNhaXe");
             String maben = rs.getString("MaBen");
            
            
            nhaxe.add(new NhaXe(tennhaxe, manhaxe, maben));
        }
        rs.close();
        conn.close();
        return nhaxe;
    }
    
}
