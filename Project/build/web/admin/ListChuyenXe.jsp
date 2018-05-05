<%-- 
    Document   : ListChuyenXe
    Created on : Oct 22, 2017, 7:40:54 PM
    Author     : Tung
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="com.entity.ChuyenXe"%>
<%@page import="java.util.List"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
         <link rel="stylesheet" type="text/css" href="css/bootstrap.min.css">
        

        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
        <title>JSP Page</title>
    </head>
    <body>
        <div class="container-fluid">
                
                <ul class="nav nav-tabs">
                    <li role="presentation"><a href="/Project/admin/Index.jsp">Home</a></li>
                    <li role="presentation"><a href="/Project/admin/BookingServlet">List Booking</a></li>
                    <li role="presentation" class="active"><a href="/Project/admin/ChuyenXeServlet">List Chuyen Xe</a></li>
                    <li role="presentation"><a href="/Project/admin/NhaXeServlet">List Nha Xe</a></li>
                     <li role="presentation"  ><a href="/Project/admin/BenXeServlet">List Ben Xe</a></li>
                       <%
                            if (session.getAttribute("LoginUser") != null) {
                        %>
                    <li role="presentation"><a href="/Project/LogoutServlet">Đăng xuất</a>
                    </li> <%}%>
                </ul>
                
            </div>
         <a href="/Project/admin/AddChuyenXe.jsp">Them Chuyen Xe</a>
          <table class="table table-hover">
            <tr>
                
                <th>Ma Chuyen</th>
                <th>Tg Xuat Phat</th>
                <th>TG Den</th>
                <th>Diem Xuat Phat</th>
                <th>Diem Den</th>
                <th>So Cho con lai</th>
                <th>Gia Ve</th>
                <th>Ma Nha Xe</th>
            </tr>
            <c:forEach var="cx" items="${ChuyenXe}">
                <tr>
                  
                    <td>${cx.maChuyen}</td>
                    <td>${cx.tgXuatPhat}</td>
                    <td>${cx.tgDen}</td>
                    <td>${cx.diemXuatPhat}</td>
                    <td>${cx.diemDen}</td>
                    <td>${cx.soChoConLai}</td>
                    <td>${cx.giaVe}</td>
                    <td>${cx.maNhaXe}</td>
                   <td>
                         <c:url var="update" value="ChuyenXeServlet">
                             <c:param name="id" value="${cx.maChuyen}"/>
                             <c:param name="action" value="update"/>
                         </c:url>
                         <c:url var="delete" value="DeleteChuyenXe">
                             <c:param name="id" value="${cx.maChuyen}"/>
                             <c:param name="action" value="delete"/>
                         </c:url>
                         <a href="${update}" >Update</a>
                         <a href="${delete}" id="deletez" onclick="return confirm('WTFFFFFFF!! Are you sure')">Delete</a>
                         
                     </td>
                </tr>
            </c:forEach>
        </table>
           <p style="text-align: center;font-size: 16px">
                Found ${ChuyenXe.size()} ChuyenXe(s) in total
            </p>
           
    </body>
</html>
