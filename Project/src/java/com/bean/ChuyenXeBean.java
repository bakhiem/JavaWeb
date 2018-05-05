/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bean;

import com.entity.ChuyenXe;
import com.modal.DBContext;
import java.io.Serializable;
import java.sql.Connection;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.List;

/**
 *
 * @author WIN8.1X64
 */
public class ChuyenXeBean implements Serializable {

    private String diemDi;
    private String diemDen;
    private int thoiGian, giaVe;

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
    
    public int getThoiGian() {
        return thoiGian;
    }

    public void setThoiGian(int thoiGian) {
        this.thoiGian = thoiGian;

    }

    public int getGiaVe() {
        return giaVe;
    }

    public void setGiaVe(int giaVe) {
        this.giaVe = giaVe;

    }

    public ChuyenXeBean() {
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
             ChuyenXe c = new ChuyenXe(maChuyen, diemXuatPhat, diemDen, maNhaXe, tgXuatPhat, tgDen, soChoConLai, giaVe);
             c.setTenNhaXe(getTenNhaXe(maNhaXe));
             list.add(c);
        }
        rs.close();
        return list;
    }
    public List<ChuyenXe> getChuyenXe() throws Exception {
        List<ChuyenXe> chuyenXe = new ArrayList<>();
        String query = "select * from ChuyenXe";

        Connection con = new DBContext().getConnection();
        ResultSet rs = con.prepareStatement(query).executeQuery();
        while (rs.next()) {
            String maChuyen = rs.getString(1);
            String tgXuatPhat = rs.getString(2);
            String tgDen = rs.getString(3);
            String diemXuatPhat = rs.getString(4);
            String diemDen = rs.getString(5);
            String maNhaXe = rs.getString(8);
            int sochoConLai = rs.getInt(6);
            float giaVe = rs.getFloat(7);
            ChuyenXe c = new ChuyenXe(maChuyen, diemXuatPhat, diemDen, maNhaXe, tgXuatPhat, tgDen, sochoConLai, giaVe);
            c.setTenNhaXe(getTenNhaXe(maNhaXe));
            chuyenXe.add(c);

        }
        rs.close();
        con.close();
        if (thoiGian == 21 || thoiGian == 22) {
            thoiGian(chuyenXe);

        }
        if (giaVe == 11 || giaVe == 12) {
            giaVe(chuyenXe);

        }
        return chuyenXe;
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

    public void giaVe(List<ChuyenXe> chuyenXe) {
        if (giaVe == 11) {
            Collections.sort(chuyenXe, new Comparator<ChuyenXe>() {
                @Override
                public int compare(ChuyenXe t, ChuyenXe t1) {

                    if (t.getGiaVe() > t1.getGiaVe()) {
                        return 1;
                    } else if (t.getGiaVe() < t1.getGiaVe()) {
                        return -1;
                    } else {
                        return 0;
                    }
                }

            });
        } else {
            Collections.sort(chuyenXe, new Comparator<ChuyenXe>() {
                @Override
                public int compare(ChuyenXe t, ChuyenXe t1) {

                    if (t.getGiaVe() < t1.getGiaVe()) {
                        return 1;
                    } else if (t.getGiaVe() > t1.getGiaVe()) {
                        return -1;
                    } else {
                        return 0;
                    }
                }

            });
        }
    }

    public void thoiGian(List<ChuyenXe> chuyenXe) {
        if (thoiGian == 21) {
            Collections.sort(chuyenXe, new Comparator<ChuyenXe>() {
                @Override
                public int compare(ChuyenXe t, ChuyenXe t1) {

                    try {
                        SimpleDateFormat formatter = new SimpleDateFormat("HH:mm");
                        Date tgXuatPhat1 = formatter.parse(t.getTgXuatPhat());
                        Date tgXuatPhat2 = formatter.parse(t1.getTgXuatPhat());
                        return tgXuatPhat1.compareTo(tgXuatPhat2);
                    } catch (Exception e) {
                    }
                    return 0;
                }

            });
        } else {
            Collections.sort(chuyenXe, new Comparator<ChuyenXe>() {
                @Override
                public int compare(ChuyenXe t, ChuyenXe t1) {

                    try {

                        SimpleDateFormat formatter = new SimpleDateFormat("HH:mm");
                        Date tgXuatPhat1 = formatter.parse(t.getTgXuatPhat());
                        Date tgXuatPhat2 = formatter.parse(t1.getTgXuatPhat());
                        return tgXuatPhat2.compareTo(tgXuatPhat1);
                    } catch (Exception e) {
                    }
                    return 0;
                }

            });
        }
    }

}
