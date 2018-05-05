/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.entity;

/**
 *
 * @author Tung
 */
public class NhaXe {
    private String tenNhaXe,maNhaXe,maBen;

    public NhaXe() {
    }

    public NhaXe(String tenNhaXe, String maNhaXe, String maBen) {
        this.tenNhaXe = tenNhaXe;
        this.maNhaXe = maNhaXe;
        this.maBen = maBen;
    }

    public String getTenNhaXe() {
        return tenNhaXe;
    }

    public void setTenNhaXe(String tenNhaXe) {
        this.tenNhaXe = tenNhaXe;
    }

    public String getMaNhaXe() {
        return maNhaXe;
    }

    public void setMaNhaXe(String maNhaXe) {
        this.maNhaXe = maNhaXe;
    }

    public String getMaBen() {
        return maBen;
    }

    public void setMaBen(String maBen) {
        this.maBen = maBen;
    }
    
}
