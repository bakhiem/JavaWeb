/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.modal;

import com.entity.Booking;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Tung
 */
public class BookingModel {
       public List<Booking> select(String criteria) throws Exception {
        List<Booking> bookings = new ArrayList<>();
        String query = "select * from Booking " + criteria;
        Connection conn = new DBContext().getConnection();
        ResultSet rs = conn.prepareStatement(query).executeQuery();
        while (rs.next()) {
            String id = rs.getString("ID");
            String maChuyen = rs.getString("MaChuyen");
            String ngayBook = rs.getString("NgayBook");
            String sdt = rs.getString("SDT");
            int soChoBook = rs.getInt("SoChoBook");
            bookings.add(new Booking(id, soChoBook, maChuyen, sdt, ngayBook));
        }
        rs.close();
        conn.close();
        return bookings;
    }
      public boolean isValidTicket (String maVe, String sdt) throws Exception {
        String query = "select * from Booking" ;
        ResultSet rs = new DBContext().getConnection().prepareStatement(query).executeQuery();
        boolean found = false;
        while(rs.next()) {
            String txtMaVe = rs.getString("ID");
            String txtSdt = rs.getString("SDT");
            if(txtMaVe.equalsIgnoreCase(maVe) && txtSdt.equals(sdt)) {
                found = true;
                break;
            }
        }
        return found;
    }
      public void deleteTicket(String id)throws Exception {
           String sql = "Delete From booking where id= ?";
           Connection conn = new DBContext().getConnection();
           
        PreparedStatement pstm = conn.prepareStatement(sql);
 
        pstm.setString(1, id);
 
        pstm.executeUpdate();
       
    }
    
}
