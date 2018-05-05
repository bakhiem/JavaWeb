/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.entity;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 *
 * @author Luxury
 */
public class randomIdBooking {
    static List id = new ArrayList();
    public static int rand(int min, int max) {
        try {
            Random rn = new Random();
            int range = max - min + 1;
            int randomNum = min + rn.nextInt(range);
            return randomNum;
        } catch (Exception e) {
            e.printStackTrace();
            return -1;
        }
    }
    public static char randomUpper () {
        int Decimal = rand(65, 90);
        return (char)Decimal;
    }
    public static char randomLower () {
        int Decimal = rand(97, 122);
        return (char)Decimal;
    }
    public static String randomID () {
        String idRandome = "";
        for (int i = 0; i < 3; i++) {
            int type = rand(0,1);
            if (type==0) {
                idRandome += randomUpper();
            } else {
                idRandome += randomLower();
            }
            if (i==2) {
                idRandome+=rand(0,9);
            }
        }
        boolean kt = true;
        while (kt) {
            if (id.contains(idRandome)) {
                randomID();
            } else {
                id.add(idRandome);
                kt = false;
            }
        }
        return idRandome;
    }
}
