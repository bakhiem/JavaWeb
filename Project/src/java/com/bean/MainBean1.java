/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bean;

import com.modal.DBContext;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author AnhTu
 */
public class MainBean1 {

    private String diemDi;

    public MainBean1() {
    }

    public List<String> getListDiemDi() throws Exception {
        List<String> list = new ArrayList<>();
        String query = "SELECT DiemXuatPhat FROM dbo.ChuyenXe GROUP BY DiemXuatPhat";
        ResultSet rs = new DBContext().getConnection().prepareStatement(query).executeQuery();
        while (rs.next()) {
            String name = rs.getString(1);
            list.add(name);
        }
        rs.close();
        return list;
    }

    public List<String> getListDiemDen() throws Exception {
        List<String> list = new ArrayList<>();
        String query = "SELECT DiemDen FROM dbo.ChuyenXe WHERE DiemXuatPhat = N'"+diemDi+"'";
        ResultSet rs = new DBContext().getConnection().prepareStatement(query).executeQuery();
        while (rs.next()) {
            String name = rs.getString("DiemDen");
            list.add(name);
        }
        rs.close();
        return list;
    }

    public String getDiemDi() {
        return diemDi;
    }

    public void setDiemDi(String diemDi) {
        this.diemDi = diemDi;
    }

}
