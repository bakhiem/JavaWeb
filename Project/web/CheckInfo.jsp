<%-- 
    Document   : CheckInfo
    Created on : Oct 24, 2017, 1:18:11 PM
    Author     : Khanh KuDo
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="com.entity.Booking" %>
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
        <div class="container">
               <p style="color: red;">${sessionScope.CheckError}</p>
            <h1>Nhập thông tin vé</h1>
            <form action="CheckBookingServlet" method="POST">
                <p>
                    <input type="text" required="" placeholder="Mã Vé" name="txtMaVe" value="${param.txtMaVe}"/>
                </p>
                <p>
                    <input type="text" required="" placeholder="SĐT" name="txtSdt"value="${param.txtSdt}"/>
                </p>
                <p>
                    <input type="submit" value="Kiểm Tra Vé" name="btnCheck" />
                </p>
            </form>
        </div>
        <c:if test="${ListBooking != null}">
            <table class="table">
                <tr>
                    <th>Mã vé</th>

                    <th>Ngày đặt vé</th>
                    <th>Số điện thoại</th>
                    <th>Số chỗ đặt</th>
                    <th>Tổng số tiền</th>
                </tr>
                <c:forEach  var="r" items="${ListBooking}">

                    <tr>
                        <td>${r.id}</td>

                        <td>${r.ngayBook}</td>
                        <td>${r.sdt}</td>
                        <td>${r.soChoBook}</td>
                        <td>${tongTien}</td>


                        <c:url var="delete" value="DeleteBookingServlet">
                            <c:param name="id" value="${r.id}"/>
                            <c:param name="sdt" value="${r.sdt}"/>
                        </c:url>
                    <a href="${delete}" onclick="return confirm('Confirm to delete the Ticket?')" style="margin-left: 20px;">Hủy Vé</a>
                </td>
            </tr>
        </c:forEach>
    </table>
</c:if>
<div style="margin-bottom: 400px"></div>
<jsp:include page="Footer.jsp"/>

</body>
</html>
