<%-- 
    Document   : TrangChu
    Created on : Oct 16, 2017, 9:00:09 PM
    Author     : WIN8.1X64
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<% request.setCharacterEncoding("UTF-8");%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" type="text/css" href="css/bootstrap.min.css">
        <link rel="stylesheet" type="text/css" href="css/main1.css">

        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
        <title>Trang chủ</title>
    </head>
    <body>

        <jsp:include page="Menu.jsp"/>
        <!--end header -->

        <!-- body -->
        <div class="container-fluid" id="slide-search">
            <div class="slider-content">



                <div id="myCarousel" class="carousel slide" data-ride="carousel">
                    <!-- Indicators -->
                    <ol class="carousel-indicators">
                        <li data-target="#myCarousel" data-slide-to="0" class="active">

                        </li>
                        <li data-target="#myCarousel" data-slide-to="1"></li>
                        <li data-target="#myCarousel" data-slide-to="2"></li>
                    </ol>
                    <div class="carousel-caption">
                        <div class="search-content">


                            <jsp:useBean id="chuyenxe" class="com.bean.ChuyenXeBean" scope="request" />
                            <jsp:setProperty name="chuyenxe" property="diemDi" param="txtDiemDi"/>
                            <jsp:setProperty name="chuyenxe" property="diemDen" param="txtDiemDen"/>

                            <form action="TrangChu.jsp" class="font-form" style="color: black">
                                <div class="text-search fix">Tìm tuyến xe</div>
                                <div class="fix-vt fix blackcolor"><span style="color:white">Nơi đi</span>
                                    <select name="txtDiemDi" onchange="this.form.submit()" >              
                                        <c:forEach var="p" items="${chuyenxe.listDiemDi}">
                                            <c:choose>
                                                <c:when test="${param.txtDiemDi eq p}">
                                                    <option value="${p}" selected>${p}</option>
                                                </c:when>
                                                <c:otherwise>
                                                    <option value="${p}">${p}</option>
                                                </c:otherwise>
                                            </c:choose>
                                        </c:forEach>               
                                    </select>
                                </div>
                                <div class="fix-vt fix blackcolor"><span style="color:white">Nơi đến</span>   
                                    <select name="txtDiemDen" style="width: 217px; margin-right: 8px;">

                                        <c:forEach var="p" items="${chuyenxe.listDiemDen}">
                                            <c:choose>
                                                <c:when test="${param.txtDiemDen eq p}">
                                                    <option value="${p}" selected>${p}</option>
                                                </c:when>
                                                <c:otherwise>
                                                    <option value="${p}">${p}</option>
                                                </c:otherwise>
                                            </c:choose>
                                        </c:forEach>
                                    </select>
                                </div>
                                <div class="btnSUbmit fix">

                                    <input type="submit" class="btn btn-warning" name="btnSubmit" value="Tìm Kiếm"/>
                                </div>

                            </form>


                        </div>
                    </div>
                    <!-- Wrapper for slides -->
                    <div class="carousel-inner">
                        <div class="item active">

                            <img src="img/travel1.png" alt="Los Angeles" style="width:110%; height: 500px">
                        </div>

                        <div class="item">

                            <img src="img/travel2.jpg" alt="Chicago" style="width:110%;height: 500px">
                        </div>

                        <div class="item">

                            <img src="img/travel3.jpg" alt="New york" style="width:110%;height: 500px">
                        </div>
                    </div>

                    <!-- Left and right controls -->
                    <a class="left carousel-control" href="#myCarousel" data-slide="prev">
                        <span class="glyphicon glyphicon-chevron-left"></span>
                        <span class="sr-only">Previous</span>
                    </a>
                    <a class="right carousel-control" href="#myCarousel" data-slide="next">
                        <span class="glyphicon glyphicon-chevron-right"></span>
                        <span class="sr-only">Next</span>
                    </a>
                </div>



            </div>
        </div>
        <div class="container-fluid ListChuyen">
            <table class="table" style="margin-top: 100px;<c:if test="${chuyenxe.diemDen == null}">display:none</c:if>">
                    <tr>
                        <th>Tên nhà xe</th>
                        <th>Điểm xuất phát</th>
                        <th>Điểm đến</th>
                        <th>Thời gian xuất phát</th>
                        <th>Thời gian đến</th>
                        <th>Giá vé</th>

                    </tr>

                <c:forEach var="p" items="${chuyenxe.listChuyenXe}">
                    <tr>
                        <td>${p.tenNhaXe}</td>
                        <td>${p.diemXuatPhat} <i class="fa fa-arrow-right" aria-hidden="true" ></i></td>
                        <td>${p.diemDen}</td>
                        <td>${p.tgXuatPhat} <i class="fa fa-arrow-right" aria-hidden="true"></i></td>
                        <td>${p.tgDen}</td>
                        <td>${p.giaVe}</td>

                        <td>
                            <c:url var="AddBooking" value="AddBooking">
                                <c:param name="maChuyen" value="${p.maChuyen}"/>
                                <c:param name="maNhaXe" value="${p.maNhaXe}"/>
                                <c:param name="soChoConLai" value="${p.soChoConLai}"/>
                                <c:param name="diemXuatPhat" value="${p.diemXuatPhat}"/>
                                <c:param name="diemDen" value="${p.diemDen}"/>
                                <c:param name="tgXuatPhat" value="${p.tgXuatPhat}"/>
                                <c:param name="tgDen" value="${p.tgDen}"/>
                                <c:param name="giaVe" value="${p.giaVe}"/>
                            </c:url>
                            <a href="${AddBooking}"><button class="btn btn-danger" name="btnSubmit">Đặt vé</button></a></td>
                    </tr>
                </c:forEach>

            </table>
        </div>
        <div id="content" style="<c:if test="${chuyenxe.diemDen != null}">display:none</c:if>">
                <div style="margin-top: 100px; text-align: center; font-size: 16px">
                    <form action="TrangChu.jsp">
                        Sắp xếp theo    <select name="txtGiaVe" onchange="document.forms[1].submit()" style="margin-left: 60px;">
                            <option Selected disabled>Giá vé</option>
                            <option value="11" <c:if test="${param.txtGiaVe == 11 && param.txtThoiGian == 0}">Selected</c:if>>Giá vé tăng dần</option>
                        <option value="12" <c:if test="${param.txtGiaVe == 12 && param.txtThoiGian == 0}">Selected</c:if>>Giá vé giảm dần</option>          
                        </select>
                        <select name="txtThoiGian" onchange="document.forms[1].submit()" style="margin-left: 60px;">
                            <option Selected disabled>Thời gian</option>
                            <option value="21"<c:if test="${param.txtThoiGian == 21 && param.txtGiaVe == 0}">Selected</c:if>>Thời gian tăng dần</option>
                        <option value="22"<c:if test="${param.txtThoiGian == 22 && param.txtGiaVe == 0}">Selected</c:if>>Thời gian giảm dần</option>
                        </select>
                    </form>
                </div>

            <c:if test="${param.txtThoiGian != 0}">
                <jsp:setProperty name="chuyenxe" property="thoiGian" param="txtThoiGian"/>
            </c:if>

            <c:if test="${param.txtGiaVe != 0}">
                <jsp:setProperty name="chuyenxe" property="giaVe" param="txtGiaVe"/>
            </c:if>
            <div class="container-fluid ListChuyen">
                <table class="table">
                    <tr>
                        <th>Tên nhà xe</th>
                        <th>Điểm xuất phát</th>
                        <th>Điểm đến</th>
                        <th>Thời gian xuất phát</th>
                        <th>Thời gian đến</th>
                        <th>Giá vé</th>
                        <th>Sochoconlai</th>
                    </tr>
                    <c:forEach var="p" items="${chuyenxe.chuyenXe}">
                        <tr>
                            <td>${p.tenNhaXe}</td>
                            <td>${p.diemXuatPhat} <i class="fa fa-arrow-right" aria-hidden="true" ></i></td>
                            <td>${p.diemDen}</td>
                            <td>${p.tgXuatPhat} <i class="fa fa-arrow-right" aria-hidden="true"></i></td>
                            <td>${p.tgDen}</td>
                            <td>${p.giaVe}</td>
                            <td>${p.soChoConLai}</td>
                            <td>
                                <c:url var="AddBooking1" value="AddBooking">
                                    <c:param name="maChuyen" value="${p.maChuyen}"/>
                                    <c:param name="maNhaXe" value="${p.maNhaXe}"/>
                                    <c:param name="soChoConLai" value="${p.soChoConLai}"/>
                                    <c:param name="diemXuatPhat" value="${p.diemXuatPhat}"/>
                                    <c:param name="diemDen" value="${p.diemDen}"/>
                                    <c:param name="tgXuatPhat" value="${p.tgXuatPhat}"/>
                                    <c:param name="tgDen" value="${p.tgDen}"/>
                                    <c:param name="giaVe" value="${p.giaVe}"/>
                                </c:url>
                                <a href="${AddBooking1}"><button class="btn btn-danger" name="btnSubmit">Đặt vé</button></a></td>
                        </tr>
                    </c:forEach>
                </table>   
            </div>
        </div>


        <!-- end body -->
        <script type="text/javascript" <source src="js/bootstrap.min.js" type="">></script>
    <script type="text/javascript" <source src="js/main.js" type=""></script>
    <jsp:include page="Footer.jsp"/>
</body>
</html>
