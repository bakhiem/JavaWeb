<%-- 
    Document   : UpdateChuyenXe
    Created on : Oct 22, 2017, 8:37:16 PM
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
           <style>
            .form{
                display: flex;
                flex-direction: column;
                align-items: center;
            }
            .form-group{
                width: 50%;
            }
            .btn{
                width: 50%;
            }
        </style>
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
        <p style="color: red;">${sessionScope.UpdateChuyenXeError}</p>
       
        <form class="form" action="UpdateChuyenXe" method="POST">
            <c:forEach var="cx" items="${ChuyenXe}">
                <div class="form-group">
                <label>Mã chuyến</label>
                <input type="text" class="form-control" value="${cx.maChuyen}" readonly name="MaChuyen" placeholder="">
             </div>
               <div class="form-group">
                <label>Thời gian xuất phát</label>
                <input type="text" class="form-control" value="${cx.tgXuatPhat}" name="TGXuatPhat" placeholder="">
             </div>
                <div class="form-group">
                <label>Thời gian đến</label>
                <input type="text" class="form-control" value="${cx.tgDen}" name="TGDen" placeholder="">
             </div>
                 <div class="form-group">
                <label>Điểm xuất phát</label>
                <input type="text" class="form-control" value="${cx.diemXuatPhat}" name="DiemXuatPhat" placeholder="">
             </div>
              <div class="form-group">
                  <label>Điểm đến</label>
                <input type="text" class="form-control" value="${cx.diemDen}" name="DiemDen" placeholder="">
             </div>
             <div class="form-group">
                <label>Số chỗ còn lại</label>
                <input type="text" class="form-control" value="${cx.soChoConLai}" name="SochoConLai" placeholder="">
             </div>
             <div class="form-group">
                <label>Giá vé</label>
                <input type="text" class="form-control" value="${cx.giaVe}" name="GiaVe" placeholder="">
             </div>
              <div class="form-group">
                <label>Mã nhà xe</label>
                <input type="text" class="form-control" value="${cx.maNhaXe}" name="MaNhaXe" placeholder="">
             </div>
             
              
               
               
            
           

                </c:forEach>
                <button class="btn btn-primary" type="submit">Update</button>
        </form>

    </body>
</html>
