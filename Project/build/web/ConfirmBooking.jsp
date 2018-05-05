<%-- 
    Document   : ConfirmBooking
    Created on : Oct 22, 2017, 4:19:22 PM
    Author     : Luxury
--%>

<%@page import="java.util.List"%>
<%@page import="java.time.LocalDate"%>
<%@page import="java.util.Calendar"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.util.Date"%>
<%@page import="com.entity.ChuyenXe"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<% request.setCharacterEncoding("UTF-8");%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" type="text/css" href="css/bootstrap.min.css">
        <link rel="stylesheet" type="text/css" href="css/main.css">

        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
        <title>Đặt vé</title>

    </head>
    <body>
        <jsp:include page="Menu.jsp"/>
        <h2>Confirm your booking</h2>
        <table class="table table-hover">
            <tr>
                <th>Điểm xuất phát </th>
                <td>${param.diemXuatPhat}</td>
            </tr>
            <tr>
                <th>Điểm đến </th>
                <td>${param.diemDen}</td>
            </tr>
            <tr>
                <th>Thời gian xuất phát </th>
                <td>${param.tgXuatPhat}</td>
            </tr>
            <tr>
                <th>Thời gian đến </th>
                <td>${param.tgDen}</td>
            </tr>
            <tr>
                <th>Giá vé </th>
                <td>${param.giaVe}</td>
            </tr>
            <tr>
                <th style="color: red">Bạn phải chọn ngày đi trước</th><td>
                    <form action="SoChoConLai">
                        <p><input name="maChuyen" hidden="true" value="${param.maChuyen}"/>
                        <p><input name="soChoConLai" hidden="true" value="${param.soChoConLai}"/>
                        <p><input name="diemXuatPhat" hidden="true" value="${param.diemXuatPhat}"/>
                        <p><input name="diemDen" hidden="true" value="${param.diemDen}"/>
                        <p><input name="tgXuatPhat" hidden="true" value="${param.tgXuatPhat}"/>
                        <p><input name="tgDen" hidden="true" value="${param.tgDen}"/>
                        <p><input name="giaVe" hidden="true" value="${param.giaVe}"/>
                        <p><input name="soGheConLai" hidden="true" value="${param.soGheConLai}"/>
                            <input required="true" value="${param.bday}" type="date" name="bday" min="${sessionScope.minDay}" onchange="this.form.submit()"/>
                    </form>
                </td></tr>
        </table>

        <c:if test="${param.bday != null}">
            <form  action="BookingAdd" onsubmit="return checkForm()">
                <p><input name="maChuyen" hidden="true" value="${param.maChuyen}"/>
                <p><input name="bday1" hidden="true" value="${param.bday}"/>
                <p style="text-align: center">Số điện thoại <input required="true" type="text" name="sdt"/>
                <h4 style="text-align: center">Còn lại ${sessionScope.soGheConLai} ghế</h4>
                <p  style="text-align: center"><select name="soghecan" id="soghe" onchange="returnMoney()">
                        <c:forEach var="i" begin="1" end="${sessionScope.soGheConLai}">
                            <option value="${i}">${i}</option>
                        </c:forEach>
                    </select>
                    <!--<p>so ghe can<input required="true" type="text" name="soghecan"/>  -->
                <h4 id="tongSoTien" style="text-align: center" >Tổng số tiền : ${param.giaVe}</h4>
                <p style="text-align: center"><a href="#" data-toggle="modal" data-target="#myModal" ><button class="btn btn-danger" onclick="getSove()">Đặt vé</button></a>
                <div class="modal fade" id="myModal" role="dialog">
                    <div class="modal-dialog">

                        <!-- Modal content-->
                        <div class="modal-content">
                            <div class="modal-header">
                                <button type="button" class="close" data-dismiss="modal">&times;</button>
                                <h4 class="modal-title">Xác nhận lại thông tin</h4>
                            </div>
                            <div class="modal-body">
                                <div class="form-horizontal" >

                                    <table class="table table-hover">
                                        <tr>
                                            <th>Điểm đi </th>
                                            <td>${param.diemXuatPhat}</td>
                                        </tr>
                                        <tr>
                                            <th>Điểm đế </th>
                                            <td>${param.diemDen}</td>
                                        </tr>
                                        <tr>
                                            <th>Thời gian đi </th>
                                            <td>${param.tgXuatPhat}</td>
                                        </tr>
                                        <tr>
                                            <th>Thời gian đến </th>
                                            <td>${param.tgDen}</td>
                                        </tr>
                                        <tr>
                                            <th>Ngày đi </th>
                                            <td>${param.bday}</td>
                                        </tr>
                                        <tr>
                                            <th>Số vé </th>
                                            <td id="getSoghe"></td>
                                        </tr>
                                        <tr>
                                            <th>Tổng số tiền  </th>
                                            <td id="getMoney"></td>
                                        </tr>
                                    </table>

                                    <div class="form-group">
                                        <div class="col-sm-offset-2 col-sm-10">
                                            <button type="submit" class="btn btn-danger">Đồng ý</button>
                                        </div>
                                    </div>
                                </div>


                            </div>
                            <div class="modal-footer">
                                <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
                            </div>
                        </div>

                    </div>
                </div>
            </form>

        </c:if>
        <div style="margin-bottom: 400px"></div>
        <jsp:include page="Footer.jsp"/>
    </body>
</html>
<script type="text/javascript">
    function checkForm() {
        var sdt = document.getElementsByName("sdt");

        if (sdt.value.trim() === "" || isNaN(sdt.value)) {

            window.alert("SDT cannot be empty or not a number..");
            sdt.focus();
            return false;
        }
        return true;
    }
    function getSove() {
        var soghe = document.getElementsByName("soghecan")[0].value;
        var giave = ${param.giaVe};
        console.log(soghe);
        if (soghe == 1) {
            document.getElementById("tongSoTien").innerHTML = "" + ${param.giaVe};
            document.getElementById("getMoney").innerHTML = "" + ${param.giaVe};
            document.getElementById("getSoghe").innerHTML = "1";
        }
    }
    function returnMoney() {
        var soghe = document.getElementsByName("soghecan")[0].value;
        var giave = ${param.giaVe};
        var stringin = "Tổng số tiền : " + (soghe * giave);
        document.getElementById("tongSoTien").innerHTML = stringin;
        document.getElementById("getMoney").innerHTML = stringin;
        document.getElementById("getSoghe").innerHTML = soghe;
    }
</script>
