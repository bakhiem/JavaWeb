/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.servlet;

import com.entity.Booking;
import com.modal.ConfirmBookingModel;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.entity.randomIdBooking;
import java.util.ArrayList;
import java.util.List;
/**
 *
 * @author Luxury
 */
public class BookingAdd extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            String maChuyen = request.getParameter("maChuyen");
            String date = request.getParameter("bday1");
            String sdt = request.getParameter("sdt");
            //int soghecuaxe = Integer.parseInt(request.getParameter("SoChoCuaXe"));
            int soghecan = Integer.parseInt(request.getParameter("soghecan"));
            ConfirmBookingModel model = new ConfirmBookingModel();
            int sochodabook = model.sochodabook(maChuyen, date);
            //int sogheconlai = soghecuaxe - sochodabook;
            List <Integer> list = new ArrayList<>();
            String bookingID = randomIdBooking.randomID();
            model.insertBooking("INSERT INTO Booking VALUES ('" + bookingID + "','" + maChuyen +
                    "','"+date+"','"+sdt+"',"+soghecan+")");
            List<Booking> booking = model.select("where ID = '"+bookingID+"'");
            request.setAttribute("ListBooking", booking);
            //request.setAttribute("sogheconlai", sogheconlai);
            request.getRequestDispatcher("InfoOfBooking.jsp").forward(request, response);
        }catch (Exception e) {
            response.getWriter().println();
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
