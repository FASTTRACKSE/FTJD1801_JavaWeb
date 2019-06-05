<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<footer>
  <div class="container">
    <div class="row">
      <div class="footer-top-cms">
        <div class="col-sm-7">
          <div class="newslatter">
            <form>
              <h5>Newsletter</h5>
              <div class="input-group">
                <input type="text" class=" form-control" placeholder="Email Here......">
                <button type="submit" value="Sign up" class="btn btn-large btn-primary">Subscribe</button>
              </div>
            </form>
          </div>
        </div>
        <div class="col-sm-5">
          <div class="footer-social">
            <h5>Social</h5>
            <ul>
              <li class="facebook"><a href="#"><i class="fa fa-facebook"></i></a></li>
              <li class="linkedin"><a href="#"><i class="fa fa-linkedin"></i></a></li>
              <li class="twitter"><a href="#"><i class="fa fa-twitter"></i></a></li>
              <li class="gplus"><a href="#"><i class="fa fa-google-plus"></i></a></li>
              <li class="youtube"><a href="#"><i class="fa fa-youtube-play"></i></a></li>
            </ul>
          </div>
        </div>
      </div>
    </div>
    <div class="row">
      <div class="col-sm-3 footer-block">
        <h5 class="footer-title">Information</h5>
        <ul class="list-unstyled ul-wrapper">
          <li><a href="about-us.html">About Us</a></li>
          <li><a href="checkout.html">Delivery Information</a></li>
          <li><a href="#">Privacy Policy</a></li>
          <li><a href="#">Terms &amp; Conditions</a></li>
        </ul>
      </div>
      <div class="col-sm-3 footer-block">
        <h5 class="footer-title">Customer Service</h5>
        <ul class="list-unstyled ul-wrapper">
          <li><a href="contact.html">Contact Us</a></li>
          <li><a href="#">Returns</a></li>
          <li><a href="#">Site Map</a></li>
          <li><a href="#">Wish List</a></li>
        </ul>
      </div>
      <div class="col-sm-3 footer-block">
        <h5 class="footer-title">Extras</h5>
        <ul class="list-unstyled ul-wrapper">
          <li><a href="#">Brands</a></li>
          <li><a href="gift.html">Gift Vouchers</a></li>
          <li><a href="affiliate.html">Affiliates</a></li>
          <li><a href="#">Specials</a></li>
        </ul>
      </div>
      <div class="col-sm-3 footer-block">
        <div class="content_footercms_right">
          <div class="footer-contact">
            <h5 class="contact-title footer-title">Contact Us</h5>
            <ul class="ul-wrapper">
              <li><i class="fa fa-map-marker"></i><span class="location2"> Warehouse & Offices,<br>
                12345 Street name, California<br>
                USA</span></li>
              <li><i class="fa fa-envelope"></i><span class="mail2"><a href="#">info@localhost.com</a></span></li>
              <li><i class="fa fa-mobile"></i><span class="phone2">+91 0987-654-321</span></li>
            </ul>
          </div>
        </div>
      </div>
    </div>
  </div>
  <a id="scrollup">Scroll</a> </footer>
<div class="footer-bottom">
  <div class="container">
    <div class="copyright">Powered By &nbsp;<a class="yourstore" href="http://www.lionode.com/">lionode &copy; 2017 </a> </div>
    <div class="footer-bottom-cms">
      <div class="footer-payment">
        <ul>
          <li class="mastero"><a href="#"><img alt="" src="<c:url value='/resources/client/image/payment/mastero.jpg'/>"></a></li>
          <li class="visa"><a href="#"><img alt="" src="<c:url value='/resources/client/image/payment/visa.jpg'/>"></a></li>
          <li class="currus"><a href="#"><img alt="" src="<c:url value='/resources/client/image/payment/currus.jpg'/>"></a></li>
          <li class="discover"><a href="#"><img alt="" src="<c:url value='/resources/client/image/payment/discover.jpg'/>"></a></li>
          <li class="bank"><a href="#"><img alt="" src="<c:url value='/resources/client/image/payment/bank.jpg'/>"></a></li>
        </ul>
      </div>
    </div>
  </div>
</div>
<script src="<c:url value='/resources/client/javascript/parally.js'/>"></script> 
<script>
$('.parallax').parally({offset: -40});
</script>
</body>
</html>