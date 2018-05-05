/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.modal;

import com.entity.ChuyenXe;
import java.nio.charset.Charset;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;

/**
 *
 * @author Tung
 */
public class ChuyenXeModel {
       public List<ChuyenXe> select(String criteria) throws Exception {
        List<ChuyenXe> chuyenxe = new ArrayList<>();
        String query = "select * from ChuyenXe "+criteria;
        Connection conn = new DBContext().getConnection();
        ResultSet rs = conn.prepareStatement(query).executeQuery();
        while (rs.next()) {
          
            int sochoconlai = rs.getInt("SochoConLai");
          
            String machuyen = rs.getString("MaChuyen");
            String tgxuatphat = rs.getString("TGXuatPhat");
            String tgden = rs.getString("TGDen");
            String diemxuatphat = rs.getString("DiemXuatPhat");
            String diemden = rs.getString("DiemDen");
            String manhaxe = rs.getString("MaNhaXe");
            
           float giave = rs.getFloat("GiaVe");
            String tennhaxe = getTenNhaXe(manhaxe);
            chuyenxe.add(new ChuyenXe(machuyen, diemxuatphat, diemden, manhaxe, tennhaxe, tgxuatphat, tgden, sochoconlai, giave));
        }
        rs.close();
        conn.close();
        return chuyenxe;
    }
       public String getTenNhaXe(String id) throws Exception {
        String query = "select * from NhaXe where MaNhaXe like '%" + id + "%'";
        Connection con = new DBContext().getConnection();
        ResultSet rs = con.prepareStatement(query).executeQuery();
        String tenNhaXe = "";
        while (rs.next()) {
            tenNhaXe = rs.getString("TenNhaXe");
        }
        rs.close();
        con.close();
        return tenNhaXe;
    }
        public void deleteChuyenXe(String code) throws SQLException, Exception {
         String sql = "Delete From ChuyenXe where MaChuyen= ?";
           Connection conn = new DBContext().getConnection();
           
        PreparedStatement pstm = conn.prepareStatement(sql);
 
        pstm.setString(1, code);
 
        pstm.executeUpdate();
    }
       
        
      public int updateChuyenxe(String query) throws SQLException, Exception {
      
      try{
           String sql = query;
           
           
        Connection conn = new DBContext().getConnection();
        PreparedStatement pstm = conn.prepareStatement(sql);
          
         
       int i = pstm.executeUpdate();
        System.out.println(i);
           return i;
      }catch(SQLException e){
          System.out.println("Sai");
          e.printStackTrace();
          return 0;
      }
    }
       public int insertChuyenxe(String query) throws SQLException, Exception {
      try{
           String sql = query;
           
           
        Connection conn = new DBContext().getConnection();
        PreparedStatement pstm = conn.prepareStatement(sql);
          
         
       int i = pstm.executeUpdate();
        System.out.println(i);
           return i;
      }catch(SQLException e){
          System.out.println("Sai");
          e.printStackTrace();
          return 0;
      }
          
    
      
    }
}
