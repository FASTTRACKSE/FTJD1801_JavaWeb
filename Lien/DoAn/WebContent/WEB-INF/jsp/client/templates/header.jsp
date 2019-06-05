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
<meta name="description" content="e-commerce site well design with responsive view." />
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<link href="<c:url value='/resources/client/bootstrap/css/bootstrap.min.css'/>" rel="stylesheet" media="screen" />
<link href="<c:url value='/resources/client/font-awesome/css/font-awesome.min.css'/>" rel="stylesheet" type="text/css" />
<link href="<c:url value='/resources/client/https://fonts.googleapis.com/css?family=Roboto:300,400,500,700'/>" rel="stylesheet">
<link href="<c:url value='/resources/client/css/stylesheet.css'/>" rel="stylesheet">
<link href="<c:url value='/resources/client/css/responsive.css'/>" rel="stylesheet">
<link href="<c:url value='/resources/client/owl-carousel/owl.carousel.css" type="text/css'/>" rel="stylesheet" media="screen" />
<link href="<c:url value='/resources/client/owl-carousel/owl.transitions.css" type="text/css'/>" rel="stylesheet" media="screen" />
<script src="<c:url value='/resources/client/javascript/jquery-2.1.1.min.js'/>" type="text/javascript"></script>
<script src="<c:url value='/resources/client/bootstrap/js/bootstrap.min.js'/>" type="text/javascript"></script>
<script src="<c:url value='/resources/client/javascript/jstree.min.js'/>" type="text/javascript"></script>
<script src="<c:url value='/resources/client/javascript/template.js'/>" type="text/javascript" ></script>
<script src="<c:url value='/resources/client/javascript/common.js'/>" type="text/javascript"></script>
<script src="<c:url value='/resources/client/javascript/global.js'/>" type="text/javascript"></script>
<script src="<c:url value='/resources/client/owl-carousel/owl.carousel.min.js'/>" type="text/javascript"></script>
<style type="text/css">
.hangHoa {
	height: 250px;
	width: 220px;
	padding: 0px;
}
</style>
</head>
<body>
<div class="preloader loader" style="display: block; background:#f2f2f2;"> <img src="<c:url value='/resources/client/image/loader.gif'/>"  alt="#"/></div>
<header>
  <div class="header-top">
    <div class="container">
      <div class="row">
        <div class="col-sm-12">
          <div class="top-left pull-left">
            <div class="language">
              <form action="#" method="post" enctype="multipart/form-data" id="language">
                <div class="btn-group">
                  <button class="btn btn-link dropdown-toggle" data-toggle="dropdown" aria-expanded="false"> <img src="<c:url value='/resources/client/image/flags/gb.png'/>" alt="English" title="English">English <i class="fa fa-caret-down"></i></button>
                  <ul class="dropdown-menu">
                    <li><a href="#"><img src="<c:url value='/resources/client/image/flags/lb.png'/>" alt="Arabic" title="Arabic"> Arabic</a></li>
                    <li><a href="#"><img src="<c:url value='/resources/client/image/flags/gb.png'/>" alt="English" title="English"> English</a></li>
                  </ul>
                </div>
              </form>
            </div>
            <div class="currency">
              <form action="#" method="post" enctype="multipart/form-data" id="currency">
                <div class="btn-group">
                  <button class="btn btn-link dropdown-toggle" data-toggle="dropdown"> <strong>$</strong> <i class="fa fa-caret-down"></i> </button>
                  <ul class="dropdown-menu">
                    <li>
                      <button class="currency-select btn btn-link btn-block" type="button" name="EUR">€ Euro</button>
                    </li>
                    <li>
                      <button class="currency-select btn btn-link btn-block" type="button" name="GBP">£ Pound Sterling</button>
                    </li>
                    <li>
                      <button class="currency-select btn btn-link btn-block" type="button" name="USD">$ US Dollar</button>
                    </li>
                  </ul>
                </div>
              </form>
            </div>
          </div>
          <div class="top-right pull-right">
            <div id="top-links" class="nav pull-right">
              <ul class="list-inline">
                <li class="dropdown"><a href="#" title="My Account" class="dropdown-toggle" data-toggle="dropdown"> <i class="fa fa-user"></i><span>${user.tenKhachHang}</span> <span class="caret"></span></a>
                  <ul class="dropdown-menu dropdown-menu-right">
                    <li><a href="register.html">Register</a></li>
                    <li><a href="<c:url value='/Client/Account'/>">Login</a></li>
                  </ul>
                </li>
                <li><a href="#" id="wishlist-total" title="Wish List (0)"><i class="fa fa-heart"></i><span>Wish List</span><span> (0)</span></a></li>
              </ul>
              <div class="search-box">
                          <input class="input-text" placeholder="search.." type="text">
                          <button class="search-btn"><i class="fa fa-search"></i></button>
                        </div>
              
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
          <div class="shipping-text">+84 (07) 9698-2626<span class="shipping-detail">Cửa hàng phục vụ từ 9:00 Đến 19:00</span></div>
        </div>
      </div>
      <div class="col-sm-4 col-xs-12 header-middle">
        <div class="header-middle-top">
          <div id="logo"> <a href="index.html"><img src="<c:url value='/resources/client/image/logo.png'/>" title="E-Commerce" alt="E-Commerce" class="img-responsive" /></a> </div>
        </div>
      </div>
      <div class="col-sm-4 col-xs-12 header-right">
        <div id="cart" class="btn-group btn-block">
          <button type="button" class="btn btn-inverse btn-block btn-lg dropdown-toggle cart-dropdown-button"> <span id="cart-total"><span class="cart-title">Giỏ Hàng</span><br>
          0 item(s) - $0.00</span> </button>
          <ul class="dropdown-menu pull-right cart-dropdown-menu">
            <li>
              <table class="table table-striped">
                <tbody>
                  <tr>
                    <td class="text-center"><a href="#"><img class="img-thumbnail" title="lorem ippsum dolor dummy" alt="lorem ippsum dolor dummy" src="<c:url value='/resources/client/image/product/7product50x59.jpg'/>"></a></td>
                    <td class="text-left"><a href="#">lorem ippsum dolor dummy</a></td>
                    <td class="text-right">x 1</td>
                    <td class="text-right">$254.00</td>
                    <td class="text-center"><button class="btn btn-danger btn-xs" title="Remove" type="button"><i class="fa fa-times"></i></button></td>
                  </tr>
                </tbody>
              </table>
            </li>
            <li>
              <div>
                <table class="table table-bordered">
                  <tbody>
                    <tr>
                      <td class="text-right"><strong>Sub-Total</strong></td>
                      <td class="text-right">$210.00</td>
                    </tr>
                    <tr>
                      <td class="text-right"><strong>Eco Tax (-2.00)</strong></td>
                      <td class="text-right">$2.00</td>
                    </tr>
                    <tr>
                      <td class="text-right"><strong>VAT (20%)</strong></td>
                      <td class="text-right">$42.00</td>
                    </tr>
                    <tr>
                      <td class="text-right"><strong>Total</strong></td>
                      <td class="text-right">$254.00</td>
                    </tr>
                  </tbody>
                </table>
                <p class="text-right"> <span class="btn-viewcart"><a href="cart.html"><strong><i class="fa fa-shopping-cart"></i> Xem giỏ hàng</strong></a></span> <span class="btn-checkout"><a href="checkout.html"><strong><i class="fa fa-share"></i> Quy trình</strong></a></span> </p>
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
    <div class="navbar-header"><span id="category" class="visible-xs">Categories</span>
      <button type="button" class="btn btn-navbar navbar-toggle" ><i class="fa fa-bars"></i></button>
    </div>
    <div class="navbar-collapse">
      <ul class="main-navigation">
        <li><a href="<c:url value='/Client'/>"   class="parent"  >Trang Chủ</a> </li>
        <li><a href="<c:url value='/Client/TrangRau'/>"   class="parent"  >Rau</a> </li>
        <li><a href="<c:url value='/Client/TrangRau'/>"   class="parent"  >Củ</a> </li>
        <li><a href="<c:url value='/Client/TrangRau'/>"   class="parent"  >Quả</a> </li>
        <li><a href="<c:url value='/Client/TrangRau'/>"   class="parent"  >Hạt</a> </li>
        <li><a href="<c:url value='/Client/TrangRau'/>"   class="parent"  >Sức khỏe và sắc đẹp</a> </li>
        <li><a href="#" class="active parent">Page</a>
          <ul>
            <li><a href="category.html">Category Page</a></li>
            <li><a href="cart.html">Cart Page</a></li>
            <li><a href="checkout.html">Checkout Page</a></li>
            <li><a href="blog.html" >Blog Page</a></li>
            <li><a href="singale-blog.html" >Singale Blog Page</a></li>
            <li><a href="register.html">Register Page</a></li>
            <li><a href="contact.html">Contact Page</a></li>
          </ul>
        </li>
        <li><a href="blog.html" class="parent"  >Blog</a></li>
        <li><a href="about-us.html" >About us</a></li>
        <li><a href="contact.html" >Contact Us</a> </li>
      </ul>
    </div>
  </div>
</nav>