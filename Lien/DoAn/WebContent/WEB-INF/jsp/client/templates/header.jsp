<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Client</title>
<meta http-equiv="content-type" content="text/html;charset=utf-8" />
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta name="description"
	content="e-commerce site well design with responsive view." />
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<link
	href="<c:url value='/resources/client/bootstrap/css/bootstrap.min.css'/>"
	rel="stylesheet" media="screen" />
<link
	href="<c:url value='/resources/client/font-awesome/css/font-awesome.min.css'/>"
	rel="stylesheet" type="text/css" />
<link
	href="<c:url value='/resources/client/https://fonts.googleapis.com/css?family=Roboto:300,400,500,700'/>"
	rel="stylesheet">
<link href="<c:url value='/resources/client/css/stylesheet.css'/>"
	rel="stylesheet">
<link href="<c:url value='/resources/client/css/responsive.css'/>"
	rel="stylesheet">
<link
	href="<c:url value='/resources/client/owl-carousel/owl.carousel.css" type="text/css'/>"
	rel="stylesheet" media="screen" />
<link
	href="<c:url value='/resources/client/owl-carousel/owl.transitions.css" type="text/css'/>"
	rel="stylesheet" media="screen" />
<script
	src="<c:url value='/resources/client/javascript/jquery-2.1.1.min.js'/>"
	type="text/javascript"></script>
<script
	src="<c:url value='/resources/client/bootstrap/js/bootstrap.min.js'/>"
	type="text/javascript"></script>
<script
	src="<c:url value='/resources/client/javascript/jstree.min.js'/>"
	type="text/javascript"></script>
<script src="<c:url value='/resources/client/javascript/template.js'/>"
	type="text/javascript"></script>
<script src="<c:url value='/resources/client/javascript/common.js'/>"
	type="text/javascript"></script>
<script src="<c:url value='/resources/client/javascript/global.js'/>"
	type="text/javascript"></script>
<script
	src="<c:url value='/resources/client/owl-carousel/owl.carousel.min.js'/>"
	type="text/javascript"></script>
<style type="text/css">
.hangHoa {
	height: 240px;
	width: 205px;
	padding: 0px;
	border: solid 1px;;
}
</style>
</head>
<body>
	<div class="preloader loader"
		style="display: block; background: #f2f2f2;">
		<img src="<c:url value='/resources/client/image/loader.gif'/>" alt="#" />
	</div>
	<header>
		<div class="header-top">
			<div class="container">
				<div class="row">
					<div class="col-sm-12">
						<div class="top-left pull-left">
							<div class="language">
								<form action="#" method="post" enctype="multipart/form-data"
									id="language">
									<div class="btn-group">
										<button class="btn btn-link dropdown-toggle"
											data-toggle="dropdown" aria-expanded="false">
											<img
												src="<c:url value='/resources/client/image/flags/gb.png'/>"
												alt="English" title="English">English <i
												class="fa fa-caret-down"></i>
										</button>
										<ul class="dropdown-menu">
											<li><a href="#"><img
													src="<c:url value='/resources/client/image/flags/lb.png'/>"
													alt="Arabic" title="Arabic"> Arabic</a></li>
											<li><a href="#"><img
													src="<c:url value='/resources/client/image/flags/gb.png'/>"
													alt="English" title="English"> English</a></li>
										</ul>
									</div>
								</form>
							</div>
							<div class="currency">
								<form action="#" method="post" enctype="multipart/form-data"
									id="currency">
									<div class="btn-group">
										<button class="btn btn-link dropdown-toggle"
											data-toggle="dropdown">
											<strong>$</strong> <i class="fa fa-caret-down"></i>
										</button>
										<ul class="dropdown-menu">
											<li>
												<button class="currency-select btn btn-link btn-block"
													type="button" name="EUR">€ Euro</button>
											</li>
											<li>
												<button class="currency-select btn btn-link btn-block"
													type="button" name="GBP">£ Pound Sterling</button>
											</li>
											<li>
												<button class="currency-select btn btn-link btn-block"
													type="button" name="USD">$ US Dollar</button>
											</li>
										</ul>
									</div>
								</form>
							</div>
						</div>
						<div class="top-right pull-right">
							<div id="top-links" class="nav pull-right">
								<ul class="list-inline">
									<li class="dropdown"><a href="#" title="My Account"
										class="dropdown-toggle" data-toggle="dropdown"> <i
											class="fa fa-user"></i><span>${user.tenKhachHang}</span> <span
											class="caret"></span></a>
										<ul class="dropdown-menu dropdown-menu-right">
											<li><a href="register.html">Đăng ký</a></li>
											<li><a href="<c:url value='/Client/Account'/>">Đăng
													nhập</a></li>
										</ul></li>
									<li><a href="#" id="wishlist-total" title="Wish List (0)"></a></li>
								</ul>


							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
		<div class="container">
			<div class="header-inner">
				<div class="col-sm-4 col-xs-6 header-left">
					<div class="shipping">
						<div class="shipping-img"></div>
						<div class="shipping-text">
							+84 (07) 9698-2626<span class="shipping-detail">Cửa hàng
								phục vụ từ 9:00 Đến 19:00</span>
						</div>
					</div>
				</div>
				<div class="col-sm-4 col-xs-12 header-middle">
					<div class="header-middle-top">
						<div id="logo">
							<a href="index.html"><img
								src="<c:url value='/resources/client/image/logo.png'/>"
								title="E-Commerce" alt="E-Commerce" class="img-responsive" /></a>
						</div>
					</div>
				</div>
				<div class="col-sm-4 col-xs-12 header-right">
					<div id="cart" class="btn-group btn-block">
						<button type="button"
							class="btn btn-inverse btn-block btn-lg dropdown-toggle cart-dropdown-button">
							<span id="cart-total"><span class="cart-title">Giỏ
									Hàng</span><br> ${countCart} Sản phẩm - ${tongTien} VNĐ</span>
						</button>
						<ul class="dropdown-menu pull-right cart-dropdown-menu">
							<li>
								<table class="table table-striped">
									<c:forEach var="tempGioHang" items="${gioHang}">
										<tbody>
											<tr>
												<td class="text-center"><a href="<c:url value='/Client/ChiTietHang/xem/${tempGioHang.maHang}'/>"><img
														class="img-thumbnail" style="width: 40px; height: 40px;"
														title="${tempGioHang.tenHang}"
														alt="lorem ippsum dolor dummy"
														src="<c:url value='/resources/client/image/item/${tempGioHang.file}'/>"></a></td>
												<td class="text-left"><a href="<c:url value='/Client/ChiTietHang/xem/${tempGioHang.maHang}'/>">${tempGioHang.tenHang}</a></td>
												<td class="text-right">x ${tempGioHang.soLuong}</td>
												<td class="text-right">${tempGioHang.donGia}</td>
												<td class="text-center"><a
													class="btn btn-danger btn-xs"
													href="/DoAn/Client/TrangChu/XoaKhoiGio/${tempGioHang.maHang}">
														<i class="fa fa-times"></i>
												</a></td>
											</tr>
										</tbody>
									</c:forEach>
								</table>
							</li>
							<li>
								<div>
									<table class="table table-bordered">
										<tbody>
											<tr>
												<td class="text-right"><strong>Tổng tiền sản
														phẩm:</strong></td>
												<td class="text-right">${tongTien}VNĐ</td>
											</tr>
											<tr>
												<td class="text-right"><strong>Phí ship: (Toàn
														quốc)</strong></td>
												<td class="text-right">30000 VNĐ</td>
											</tr>
											<tr>
												<td class="text-right"><strong>Thuế (10%):</strong></td>
												<td class="text-right">${tongTien + tongTien/10}VNĐ</td>
											</tr>
											<tr>
												<td class="text-right"><strong>Tổng thành
														tiền:</strong></td>
												<td class="text-right">${tongTien + tongTien/10 + 30000}
													VNĐ</td>
											</tr>
										</tbody>
									</table>
									<p class="text-right">
										<span class="btn-viewcart"><a
											href="/DoAn/Client/GioHang/XemGio"><strong><i
													class="fa fa-shopping-cart"></i> Xem giỏ hàng</strong></a></span> <span
											class="btn-checkout"><a href="<c:url value='/Client/DatHang'/>"><strong><i
													class="fa fa-share"></i> Đặt hàng</strong></a></span>
									</p>
								</div>
							</li>
						</ul>
					</div>
				</div>
			</div>
		</div>
	</header>
	<nav id="menu" class="navbar">
		<div class="nav-inner container">

			<div class="navbar-collapse">
				<ul class="main-navigation">
					<li><a href="<c:url value='/Client'/>" class="parent">Trang
							Chủ</a></li>
					<li><a href="<c:url value='/Client/TrangChu'/>" class="parent">Rau</a>
					</li>
					<li><a href="<c:url value='/Client/TrangChu'/>" class="parent">Củ</a>
					</li>
					<li><a href="<c:url value='/Client/TrangChu'/>" class="parent">Quả</a>
					</li>
					<li><a href="<c:url value='/Client/TrangChu'/>" class="parent">Hạt</a>
					</li>
					<li><a href="<c:url value='/Client/TrangChu'/>" class="parent">Sức
							khỏe và sắc đẹp</a></li>
				</ul>
			</div>
		</div>
	</nav>