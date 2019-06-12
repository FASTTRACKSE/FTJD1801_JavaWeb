<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<jsp:include page="/WEB-INF/jsp/client/templates/header.jsp"/>

<div class="container">
  <ul class="breadcrumb">
    <li><a href="index.html"><i class="fa fa-home"></i></a></li>
    <li><a href="#">Account</a></li>
    <li><a href="login.html">Login</a></li>
  </ul>
  <div class="row">
    <div class="col-sm-3 hidden-xs column-left" id="column-left">
      <div class="column-block">
        <div class="columnblock-title">Tài khoản</div>
        <div class="account-block">
          <div class="list-group"> <a class="list-group-item" href="login.html">Đăng nhập</a> <a class="list-group-item" href="register.html">Đăng ký</a> <a class="list-group-item" href="forgetpassword.html">Quên mật khẩu</a> <a class="list-group-item" href="#">Tài khoản của tôi</a> <a class="list-group-item" href="#">Lịch sử đặt hàng</a> <a class="list-group-item" href="#">Order History</a> <a class="list-group-item" href="#">Điểm tích lũy</a> <a class="list-group-item last" href="#">Đăng xuất</a> </div>
        </div>
      </div>
    </div>
    <div class="col-sm-9" id="content">
      <div class="row">
        <div class="col-sm-6">
          <div class="well">
            <h2>Khách hàng mới</h2>
            <p><strong>Đăng ký tài khoản</strong></p>
            <p>Bằng cách tạo tài khoản, bạn sẽ có thể mua sắm nhanh hơn, cập nhật trạng thái của đơn hàng và theo dõi các đơn hàng bạn đã thực hiện trước đó.</p>
            <a class="btn btn-primary" href="register.html">Tiếp tục</a></div>
        </div>
        <div class="col-sm-6">
          <div class="well">
            <h2>Phản hồi của khách hàng</h2>
            <p><strong>Tôi là một khách hàng cũ</strong></p>
            <p style="color: red;">${thongBao}</p>
            <form  method="post" action="/DoAn/Client/Account/Login">
              <div class="form-group">
                <label for="input-email" class="control-label">Tên tài khoản</label>
                <input type="text" class="form-control" id="input-email" placeholder="Tên đăng nhập.." value="${taikhoan}" name="email">
              </div>
              <div class="form-group">
                <label for="input-password" class="control-label">Mật khẩu</label>
                <input type="password" class="form-control" id="input-password" placeholder="mật khẩu.." value="" name="password" >
                <a href="forgetpassword.html">Quên mật khẩu</a></div>
              <input type="submit" class="btn btn-primary" value="Đăng nhập">
            </form>
          </div>
        </div>
      </div>
    </div>
  </div>
</div>

<jsp:include page="/WEB-INF/jsp/client/templates/footer.jsp"/>