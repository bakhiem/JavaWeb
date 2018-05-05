/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.servlet;

import com.entity.ChuyenXe;
import com.modal.ConfirmBookingModel;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author WIN8.1X64
 */
public class AddBooking extends HttpServlet {

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
        request.setCharacterEncoding("UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            //request.getRequestDispatcher("ConfirmBooking.jsp").forward(request, response);
            String code = request.getParameter("maChuyen");
            String origin = request.getParameter("diemXuatPhat");
            String destination = request.getParameter("diemDen");
            String codeCoach = request.getParameter("maNhaXe");
            String departureTime = request.getParameter("tgXuatPhat");
            String arrivalTime = request.getParameter("tgDen");
            int remaining = Integer.parseInt(request.getParameter("soChoConLai"));
            float price = Float.parseFloat(request.getParameter("giaVe"));
            ChuyenXe cx = new ChuyenXe(code, origin, destination, codeCoach, departureTime, arrivalTime, remaining, price);
            String dateTime[] = departureTime.split(":");
            int hourStart = Integer.parseInt(dateTime[0]);
            int minStart = Integer.parseInt(dateTime[1]);
            Calendar c = Calendar.getInstance();
            int hour = c.get(Calendar.HOUR_OF_DAY);
            int minutes = c.get(Calendar.MINUTE);
            int isLate = 0;
            if (hour > hourStart) {
                isLate = 1;
            } else if (hour == hourStart) {
                if (minutes >= minStart) {
                    isLate = 1;
                }

            }
            String day="";
            if (isLate == 1) {
                SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
                Date date = new Date();
                Calendar calendar = Calendar.getInstance();
                calendar.setTime(date);
                calendar.add(Calendar.DAY_OF_YEAR, 1);
                 day = format.format(calendar.getTime());
            } else {
                Date date = new Date();
                SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
                 day = formatter.format(date);
            }

            HttpSession session = request.getSession();
             session.setAttribute("minDay", day);
            request.getRequestDispatcher("ConfirmBooking.jsp").forward(request, response);
        } catch (Exception e) {
            
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
