/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.modal;

import com.entity.Booking;
import com.entity.ChuyenXe;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Luxury
 */
public class ConfirmBookingModel {

    public List<Booking> select(String criteria) throws Exception {
        List<Booking> booking = new ArrayList<>();
        String query = "select * from Booking "+criteria;
        Connection conn = new DBContext().getConnection();
        ResultSet rs = conn.prepareStatement(query).executeQuery();
        while (rs.next()) {
            String id = rs.getString("ID");
            String d = rs.getString("NgayBook");
            String machuyen = rs.getString("MaChuyen");
            String sdt = rs.getString("SDT");
            int sochobook = rs.getInt("SoChoBook");
            
            booking.add(new Booking(id, sochobook, machuyen, sdt, d));
        }
        rs.close();
        conn.close();
        return booking;
    }
    public int sochodabook (String code, String NgayBook) throws Exception {
       String query = "select SoChoBook from Booking where maChuyen = '"+code+"' and NgayBook = '"+NgayBook+"'";
        Connection conn = new DBContext().getConnection();
        ResultSet rs = conn.prepareStatement(query).executeQuery();
        int sochodabook = 0; 
        while (rs.next()) {
            
            sochodabook += rs.getInt("SoChoBook");
           
        }
        rs.close();
        conn.close();
        return sochodabook;
    }
    public void insertBooking (String query) throws Exception {
        String sql = query;
        Connection conn = new DBContext().getConnection();
        PreparedStatement pstm = conn.prepareStatement(sql);
        pstm.executeUpdate();
    }
}
