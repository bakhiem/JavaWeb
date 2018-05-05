<%-- 
    Document   : Menu
    Created on : Nov 4, 2017, 9:56:29 AM
    Author     : WIN8.1X64
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
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
        <title>JSP Page</title>
    </head>
    <body>
        <div id="banner-group">Hệ thống đặt xe chất lượng cao-Một sản phẩm của nhóm <a href=#>Say-oh-yeah</a></div>
        <header>
            <div class="header-bg">
                <div class="container">
                    <div class="row">
                        <div class="col-sm-4 col-md-3">
                            <div class="logo fix-thumbnail">
                                <a  class="home" href="#">
                                    <img src="img/logo.png" width="280px" height="100px">
                                </a>
                            </div>
                        </div>
                        <div class="col-sm-8 col-md-9">
                            <nav class="nav-menu primary-menu ">


                                <div class="menu-container clearfix">
                                    <ul id="menu-top-menu">
                                        <li><a href="TrangChu.jsp">Trang chủ</a></li>
                                        <li><a href="#">Bạn cần biết gì</a></li>
                                        <li><a href="#">Thông tin tuyến xe</a></li>
                                        <li><a href="CheckInfo.jsp">Thông tin vé xe</a></li>
                                        <li><a href="#" data-toggle="modal" data-target="#myModal1">Quản trị viên</a></li>
                                        <div class="modal fade" id="myModal1" role="dialog">
                                            <div class="modal-dialog">

                                                <!-- Modal content-->
                                                <div class="modal-content">
                                                    <div class="modal-header">
                                                        <button type="button" class="close" data-dismiss="modal">&times;</button>
                                                        <h4 class="modal-title">Quản trị viên đăng nhập</h4>
                                                    </div>
                                                    <div class="modal-body">
                                                        <form class="form-horizontal" action="LoginServlet" method="POST">
                                                            <div class="form-group">
                                                                <label for="inputEmail3" class="col-sm-3 control-label">Tên đăng nhập</label>
                                                                <div class="col-sm-9">
                                                                    <input type="text" class="form-control" id="inputEmail3" name="txtName" placeholder="Tên đăng nhập">
                                                                </div>
                                                            </div>
                                                            <div class="form-group">
                                                                <label for="inputPassword3" class="col-sm-3 control-label">Mật khẩu</label>
                                                                <div class="col-sm-9">
                                                                    <input type="password" class="form-control" id="inputPassword3" name="txtPassword" placeholder="Mật khẩu">
                                                                </div>
                                                            </div>

                                                            <div class="form-group">
                                                                <div class="col-sm-offset-2 col-sm-10">
                                                                    <button type="submit" class="btn btn-default">Đăng nhập</button>
                                                                </div>
                                                            </div>
                                                        </form>


                                                    </div>
                                                    <div class="modal-footer">
                                                        <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
                                                    </div>
                                                </div>

                                            </div>
                                        </div>
                                    </ul>
                                </div>


                            </nav>
                        </div>
                    </div>
                </div>
            </div>

            <!-- menu -->

            <!-- end menu -->
        </header>
    </body>
</html>
