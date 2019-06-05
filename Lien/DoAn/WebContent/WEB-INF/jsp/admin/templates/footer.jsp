<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!-- script-for sticky-nav -->
		<script>
		$(document).ready(function() {
			 var navoffeset=$(".header-main").offset().top;
			 $(window).scroll(function(){
				var scrollpos=$(window).scrollTop(); 
				if(scrollpos >=navoffeset){
					$(".header-main").addClass("fixed");
				}else{
					$(".header-main").removeClass("fixed");
				}
			 });
			 
		});
		</script>
		<!-- /script-for sticky-nav -->
<!--inner block start here-->
<div class="inner-block">
	<div ></div>
<!--climate end here-->
</div>
<!--inner block end here-->
<!--copy rights start here-->
<div class="copyrights">
	 <p>© 2016 Shoppy. All Rights Reserved | Design by  <a href="http://w3layouts.com/" target="_blank">Truong Thi My Lien</a> </p>
</div>	
<!--COPY rights end here-->
</div>
</div>
<!--slider menu-->
    <div class="sidebar-menu">
		  	<div class="logo"> <a href="#" class="sidebar-icon"> <span class="fa fa-bars"></span> </a> <a href="#"> <span id="logo" ></span> 
			      <!--<img id="logo" src="" alt="Logo"/>--> 
			  </a> </div>		  
		    <div class="menu">
		      <ul id="menu" >
		        <li id="menu-home" ><a href="<c:url value='/Admin'/>"><i class="glyphicon glyphicon-home"></i><span>Trang chủ</span></a></li>
		        <li><a href="<c:url value='/Admin/QuanLyDonHang/DuyetDon'/>"><i class="glyphicon glyphicon-list-alt"></i><span>Quản Lý Đơn Hàng</span></a>
		        </li>
		        <li id="menu-comunicacao" ><a href="#"><i class="glyphicon glyphicon-th-list"></i><span>Quản lý dữ lệu</span><span class="fa fa-angle-right" style="float: right"></span></a>
		          <ul id="menu-comunicacao-sub" >
		            <li id="menu-mensagens" ><a href="<c:url value='/Admin/QuanLyDuLieu/KhachHang'/>">Danh sách khách hàng</a>		              
		            </li>
		            <li id="menu-arquivos" ><a href="<c:url value='/Admin/QuanLyDuLieu/NhanVien'/>">Hồ sơ nhân viên</a></li>
		            <li id="menu-arquivos" ><a href="<c:url value='/Admin/QuanLyDuLieu/HangHoa'/>">Danh sách sản phẩm</a></li>
		            <li id="menu-arquivos" ><a href="<c:url value='/Admin/QuanLyDuLieu/NhomHang'/>">Nhóm sản phẩm</a></li>
		          </ul>
		        </li>		     
		        <li id="menu-academico" ><a href="#"><i class="glyphicon glyphicon-th-large"></i><span>Quản lý kho</span><span class="fa fa-angle-right" style="float: right"></span></a>
		          <ul id="menu-academico-sub" >
		          	 <li id="menu-academico-boletim" ><a href="<c:url value='/Admin/QuanLyKhoo/XuatKho'/>">Xuất kho</a></li>
		            <li id="menu-academico-avaliacoes" ><a href="<c:url value='/Admin/QuanLyKho/NhapKho'/>">Nhập kho</a></li>		
		            <li id="menu-academico-avaliacoes" ><a href="<c:url value='/Admin/QuanLyKho/NhaCungCap'/>">Nhà cung cấp</a></li>	           
		          </ul>
		        </li>	        	     
		        <li><a href="#"><i class="glyphicon glyphicon-file"></i><span>Báo cáo thống kê</span><span class="fa fa-angle-right" style="float: right"></span></a>
		        	 <ul id="menu-academico-sub" >
			            <li id="menu-academico-avaliacoes" ><a href="<c:url value='/Admin/BaoCaoThongKe/DoanhThu'/>">Doanh thu theo kỳ</a></li>
			            <li id="menu-academico-boletim" ><a href="<c:url value='/Admin/BaoCaoThongKe/ThongKeBanHang'/>">Thống kê bán hàng</a></li>
		             </ul>
		        </li>
		         
		      </ul>
		    </div>
	 </div>
	<div class="clearfix"> </div>
</div>
<!--slide bar menu end here-->
<script>
var toggle = true;
            
$(".sidebar-icon").click(function() {                
  if (toggle)
  {
    $(".page-container").addClass("sidebar-collapsed").removeClass("sidebar-collapsed-back");
    $("#menu span").css({"position":"absolute"});
  }
  else
  {
    $(".page-container").removeClass("sidebar-collapsed").addClass("sidebar-collapsed-back");
    setTimeout(function() {
      $("#menu span").css({"position":"relative"});
    }, 400);
  }               
                toggle = !toggle;
            });
</script>
<!--scrolling js-->
		<script src="<c:url value='/resources/admin/js/jquery.nicescroll.js'/>"></script>
		<script src="<c:url value='/resources/admin/js/scripts.js'/>"></script>
		<!--//scrolling js-->
<script src="<c:url value='/resources/admin/js/bootstrap.js'/>"> </script>
<!-- mother grid end here-->
</body>
</html>