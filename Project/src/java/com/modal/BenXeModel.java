/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.modal;

import com.entity.BenXe;
import com.entity.NhaXe;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Tung
 */
public class BenXeModel {
    public List<BenXe> select(String criteria) throws Exception {
        List<BenXe> benxe = new ArrayList<>();
        String query = "select * from BenXe "+criteria;
        Connection conn = new DBContext().getConnection();
        ResultSet rs = conn.prepareStatement(query).executeQuery();
        while (rs.next()) {
           
            String maben = rs.getString("MaBen");
            String tenben = rs.getString("TenBen");
             String diachi = rs.getString("DiaChi");
            
            
            benxe.add(new BenXe(maben, tenben, diachi));
        }
        rs.close();
        conn.close();
        return benxe;
    }
}
