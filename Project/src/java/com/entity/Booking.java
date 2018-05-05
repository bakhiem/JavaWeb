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
public class Booking {
    private String id;
    private int soChoBook;
    private String maChuyen, sdt;
      private String ngayBook;

    public Booking() {
    }

    public Booking(String ID, int soChoBook, String maChuyen, String SDT, String ngayBook) {
        this.id = ID;
        this.soChoBook = soChoBook;
        this.maChuyen = maChuyen;
        this.sdt= SDT;
        this.ngayBook = ngayBook;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getSdt() {
        return sdt;
    }

    public void setSdt(String sdt) {
        this.sdt = sdt;
    }

    

   

    public int getSoChoBook() {
        return soChoBook;
    }

    public void setSoChoBook(int soChoBook) {
        this.soChoBook = soChoBook;
    }

    public String getMaChuyen() {
        return maChuyen;
    }

    public void setMaChuyen(String maChuyen) {
        this.maChuyen = maChuyen;
    }

    

    public String getNgayBook() {
        return ngayBook;
    }

    public void setNgayBook(String ngayBook) {
        this.ngayBook = ngayBook;
    }
      
    
    
    
}
