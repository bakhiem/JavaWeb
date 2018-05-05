/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bean;

import com.modal.DBContext;
import com.entity.ChuyenXe;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author AnhTu
 */
public class MainBean {

    private String diemDi;
    private String diemDen;

    public MainBean() {
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
        String query = "SELECT DiemDen FROM dbo.ChuyenXe WHERE DiemXuatPhat = N'" + diemDi + "'";
        ResultSet rs = new DBContext().getConnection().prepareStatement(query).executeQuery();
        while (rs.next()) {
            String name = rs.getString("DiemDen");
            list.add(name);
        }
        rs.close();
        return list;
    }

    public List<ChuyenXe> getListChuyenXe() throws Exception {
        List<ChuyenXe> list = new ArrayList<>();
        String query = "SELECT * FROM dbo.ChuyenXe WHERE DiemXuatPhat = N'" + diemDi + "' AND DiemDen = N'" + diemDen + "'";
        ResultSet rs = new DBContext().getConnection().prepareStatement(query).executeQuery();
        while (rs.next()) {
            String maChuyen = rs.getString("MaChuyen");
            String tgXuatPhat = rs.getString("TGXuatPhat");
            String tgDen = rs.getString("TGDen");
            String diemXuatPhat = rs.getString("DiemXuatPhat");
            String diemDen = rs.getString("DiemDen");
            int soChoConLai = rs.getInt("SochoConLai");
            float giaVe = rs.getFloat("GiaVe");
            String maNhaXe = rs.getString("MaNhaXe");
            list.add(new ChuyenXe(maChuyen, diemXuatPhat, diemDen, maNhaXe, tgXuatPhat, tgDen, soChoConLai, giaVe));
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

    public String getDiemDen() {
        return diemDen;
    }

    public void setDiemDen(String diemDen) {
        this.diemDen = diemDen;
    }

}
