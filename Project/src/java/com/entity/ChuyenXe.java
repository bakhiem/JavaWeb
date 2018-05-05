/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.entity;

import java.util.Date;

/**
 *
 * @author WIN8.1X64
 */
public class ChuyenXe {
    private String maChuyen,diemXuatPhat,diemDen,maNhaXe,tenNhaXe;
    private String tgXuatPhat,tgDen; // sao lai la String ???
    private int soChoConLai;
    private float giaVe;
    
    public ChuyenXe() {
    }

    public ChuyenXe(String maChuyen, String diemXuatPhat, String diemDen, String maNhaXe, String tgXuatPhat, String tgDen, int soChoConLai, float giaVe) {
        this.maChuyen = maChuyen;
        this.diemXuatPhat = diemXuatPhat;
        this.diemDen = diemDen;
        this.maNhaXe = maNhaXe;
        this.tgXuatPhat = tgXuatPhat;
        this.tgDen = tgDen;
        this.soChoConLai = soChoConLai;
        this.giaVe = giaVe;
    }

    public ChuyenXe(String maChuyen, String diemXuatPhat, String diemDen, String maNhaXe, String tenNhaXe, String tgXuatPhat, String tgDen, int soChoConLai, float giaVe) {
        this.maChuyen = maChuyen;
        this.diemXuatPhat = diemXuatPhat;
        this.diemDen = diemDen;
        this.maNhaXe = maNhaXe;
        this.tenNhaXe = tenNhaXe;
        this.tgXuatPhat = tgXuatPhat;
        this.tgDen = tgDen;
        this.soChoConLai = soChoConLai;
        this.giaVe = giaVe;
    }

    public String getTenNhaXe() {
        return tenNhaXe;
    }

    public void setTenNhaXe(String tenNhaXe) {
        this.tenNhaXe = tenNhaXe;
    }
    
    public String getMaChuyen() {
        return maChuyen;
    }

    public void setMaChuyen(String maChuyen) {
        this.maChuyen = maChuyen;
    }

    public String getDiemXuatPhat() {
        return diemXuatPhat;
    }

    public void setDiemXuatPhat(String diemXuatPhat) {
        this.diemXuatPhat = diemXuatPhat;
    }

    public String getDiemDen() {
        return diemDen;
    }

    public void setDiemDen(String diemDen) {
        this.diemDen = diemDen;
    }

    public String getMaNhaXe() {
        return maNhaXe;
    }

    public void setMaNhaXe(String maNhaXe) {
        this.maNhaXe = maNhaXe;
    }

    public String getTgXuatPhat() {
        return tgXuatPhat;
    }

    public void setTgXuatPhat(String tgXuatPhat) {
        this.tgXuatPhat = tgXuatPhat;
    }

    public String getTgDen() {
        return tgDen;
    }

    public void setTgDen(String tgDen) {
        this.tgDen = tgDen;
    }

    public int getSoChoConLai() {
        return soChoConLai;
    }

    public void setSoChoConLai(int sochoConLai) {
        this.soChoConLai = sochoConLai;
    }

    public float getGiaVe() {
        return giaVe;
    }

    public void setGiaVe(float giaVe) {
        this.giaVe = giaVe;
    }

    
    
}
