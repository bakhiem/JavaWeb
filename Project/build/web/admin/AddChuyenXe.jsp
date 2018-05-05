<%-- 
    Document   : AddChuyenXe
    Created on : Oct 22, 2017, 9:54:24 PM
    Author     : Tung
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
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
         <jsp:include page="../MenuAdmin.jsp"/>
         <p style="color: red;">${sessionScope.ChuyenXeError}</p>
        <form class="form" action="../admin/AddChuyenXe" method="POST">
             <div class="form-group">
                <label>Mã chuyến</label>
                <input type="text" class="form-control" name="MaChuyen" placeholder="">
             </div>
             <div class="form-group">
                <label>Thời gian xuất phát</label>
                <input type="text" class="form-control" name="TGXuatPhat" placeholder="">
             </div>
             <div class="form-group">
                <label>Thời gian đến</label>
                <input type="text" class="form-control" name="TGDen" placeholder="">
             </div>
             <div class="form-group">
                <label>Điểm xuất phát</label>
                <input type="text" class="form-control" name="DiemXuatPhat" placeholder="">
             </div>
            
           
             <div class="form-group">
                <label>Điểm đến</label>
                <input type="text" class="form-control" name="DiemDen" placeholder="">
             </div>
             <div class="form-group">
                <label>Số chỗ còn lại</label>
                <input type="text" class="form-control" name="SochoConLai" placeholder="">
             </div>
             <div class="form-group">
                <label>Giá vé</label>
                <input type="text" class="form-control" name="GiaVe" placeholder="">
             </div>
              <div class="form-group">
                <label>Mã nhà xe</label>
                <input type="text" class="form-control" name="MaNhaXe" placeholder="">
             </div>
             
              
               
               
            
            <button class="btn btn-primary" type="submit">Add</button>
            
        </form>
    </body>
</html>
