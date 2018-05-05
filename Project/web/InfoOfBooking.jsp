<%-- 
    Document   : InfoOfBooking
    Created on : Nov 4, 2017, 4:05:38 PM
    Author     : WIN8.1X64
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" type="text/css" href="css/bootstrap.min.css">


        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
        <title>Thông tin vé</title>
    </head>
    <body>
        <jsp:include page="Menu.jsp"/>
        <table class="table">
            <tr>
                <th>Mã vé</th>

                <th>Ngày đặt vé</th>
                <th>Số điện thoại</th>
                <th>Số chỗ đặt</th>
                
            </tr>
            <c:forEach  var="r" items="${ListBooking}">

                <tr>
                    <td>${r.id}</td>

                    <td>${r.ngayBook}</td>
                    <td>${r.sdt}</td>
                    <td>${r.soChoBook}</td>
                    
                    <td> </td>
                    

                        <c:url var="delete" value="DeleteBookingServlet">
                            <c:param name="id" value="${r.id}"/>
                            <c:param name="sdt" value="${r.sdt}"/>
                        </c:url>
                        <a href="${delete}" onclick="return confirm('Confirm to delete the Ticket?')" style="margin-left: 20px;">Hủy Vé</a>
                    </td>
                </tr>
            </c:forEach>
        </table>
        <div style="margin-bottom: 400px"></div>
        <jsp:include page="Footer.jsp"/> 
    </body>
</html>
