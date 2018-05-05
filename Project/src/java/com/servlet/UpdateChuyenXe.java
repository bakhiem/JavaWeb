/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.servlet;

import com.entity.ChuyenXe;
import com.modal.ChuyenXeModel;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Tung
 */
public class UpdateChuyenXe extends HttpServlet {

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
               ChuyenXeModel model = new ChuyenXeModel();
               request.setCharacterEncoding("UTF-8");
                  HttpSession session = request.getSession();
           
            session.removeAttribute("UpdateChuyenXeError");
               String machuyen = request.getParameter("MaChuyen");
            String tgxuatphat = request.getParameter("TGXuatPhat");
            String tgden = request.getParameter("TGDen");
            String diemxuatphat = request.getParameter("DiemXuatPhat");
            String diemden = request.getParameter("DiemDen");
            String manhaxe = request.getParameter("MaNhaXe");
            int sochoconlai = Integer.parseInt(request.getParameter("SochoConLai"));
          
           float giave = Float.parseFloat(request.getParameter("GiaVe"));
         
           int i = model.updateChuyenxe("Update ChuyenXe set TGXuatPhat ='"+tgxuatphat+"'"+", TGDen='"+tgden+"'"+",DiemXuatPhat=N'"+diemxuatphat+"'"+", DiemDen=N'"+diemden+"'"+", SoChoConLai="+sochoconlai+",GiaVe ="+giave+", MaNhaXe='"+manhaxe+"'"+" where MaChuyen='"+machuyen+"'"+" ");
            if(i==1){
                 List<ChuyenXe> chuyenxe = model.select("");
            
          
          
           
            
     
            request.setAttribute("ChuyenXe", chuyenxe);
            request.getRequestDispatcher("/admin/ListChuyenXe.jsp").forward(request, response);// de view that setattibute
            }
            else{
                
                 session.setAttribute("UpdateChuyenXeError", "Add failed pls add again");
               response.sendRedirect("/FilterSample/admin/UpdateChuyenXe.jsp");
            }
          
        }
         catch(Exception e){
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
