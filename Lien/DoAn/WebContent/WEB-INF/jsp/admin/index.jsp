<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<jsp:include page="/WEB-INF/jsp/admin/templates/header.jsp"/>
	<div class="login-page">
    <div class="login-main">  	
    	 <div class="login-head">
				<h1>Đăng nhập</h1>
			</div>
			<div class="login-block">
				<form>
					<input type="text" name="email" placeholder="Tài khoản" required="required">
					<input type="password" name="password" class="lock" placeholder="Mật khẩu">
					<div class="forgot-top-grids">
						<div class="forgot-grid">
							<ul>
								<li>
									<input type="checkbox" id="brand1" value="">
									<label for="brand1"><span></span>Lưu mật khẩu</label>
								</li>
							</ul>
						</div>
						<div class="forgot">
							<a href="#">Quên mật khẩu?</a>
						</div>
						<div class="clearfix"> </div>
					</div>
					<input type="submit" name="Sign In" value="Đăng nhập">	
					
			</div>
      </div>
</div>
<jsp:include page="/WEB-INF/jsp/admin/templates/footer.jsp"/>