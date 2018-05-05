/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.servlet;

import com.entity.ChuyenXe;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Luxury
 */
public class GetAllBooking {

    private List<ChuyenXe> items;

    public GetAllBooking() {
        items = new ArrayList<>();
    }

    public void addBookingItem(ChuyenXe cx) {
        //items.removeAll(items);
        items.add(cx);
    }

    public List<ChuyenXe> getItems() {
        return items;
    }

    public void setItems(List<ChuyenXe> items) {
        this.items = items;
    }

}
