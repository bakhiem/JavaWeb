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
public class BenXe {
    private String maBen,tenBen,diaChi;

    public BenXe() {
    }

    public BenXe(String maBen, String tenBen, String diaChi) {
        this.maBen = maBen;
        this.tenBen = tenBen;
        this.diaChi = diaChi;
    }

    public String getMaBen() {
        return maBen;
    }

    public void setMaBen(String maBen) {
        this.maBen = maBen;
    }

    public String getTenBen() {
        return tenBen;
    }

    public void setTenBen(String tenBen) {
        this.tenBen = tenBen;
    }

    public String getDiaChi() {
        return diaChi;
    }

    public void setDiaChi(String diaChi) {
        this.diaChi = diaChi;
    }
    
    
}
