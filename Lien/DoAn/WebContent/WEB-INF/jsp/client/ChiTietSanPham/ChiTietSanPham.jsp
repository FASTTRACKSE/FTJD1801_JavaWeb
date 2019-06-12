<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<jsp:include page="/WEB-INF/jsp/client/templates/header.jsp" />

<div class="container">
	<ul class="breadcrumb">
		<li><a href="index.html"><i class="fa fa-home"></i></a></li>
		<li><a href="category.html">Chi tiết sản phẩm</a></li>
	</ul>
	<div class="row">
		<div id="column-left" class="col-sm-3 hidden-xs column-left" style="width: 250px;">
			<div class="panel panel-default filter">
				<div class="panel-heading columnblock-title">Lọc sản phẩm</div>
				<div class="filter-block">
					<div class="list-group">
						<a class="list-group-item">Bán chạy</a>
						<div class="list-group-item">
							<div id="filter-group1">
								<label class="checkbox"> <input name="filter[]"
									type="checkbox" value="1" /> Ngày (7)
								</label> <label class="checkbox"> <input name="filter[]"
									type="checkbox" value="2" /> Tuần (6)
								</label> <label class="checkbox"> <input name="filter[]"
									type="checkbox" value="3" /> Tháng (6)
								</label>
							</div>
						</div>
						<a class="list-group-item">Giá</a>
						<div class="list-group-item">
							<div id="filter-group2">
								<label class="checkbox"> <input name="filter[]"
									type="checkbox" value="4" /> 10.000Đ-50.000Đ (21)
								</label> <label class="checkbox"> <input name="filter[]"
									type="checkbox" value="5" /> 51.000Đ-100.000Đ (11)
								</label><label class="checkbox"> <input name="filter[]"
									type="checkbox" value="6" /> 101.000Đ-200.000Đ (2)
								</label><label class="checkbox"> <input name="filter[]"
									type="checkbox" value="7" /> Trên 200.000Đ (0)
								</label>
							</div>
						</div>						
					</div>
					<div class="panel-footer text-right">
						<button type="button" id="button-filter" class="btn btn-primary">Tra cứu</button>
					</div>
				</div>
			</div>
			<div class="banner">
				<div class="item">
					<a href="#"><img
						src="<c:url value='/resources/client/image/banners/bannerGIF.gif'/>"
						alt="Left Banner" class="img-responsive" /></a>
				</div>
			</div>

		</div>
		<div id="content" class="col-sm-9">
			<div class="row">
				<div class="col-sm-6">
					<div class="thumbnails">
						<div>
							<a class="thumbnail" href="image/product/product8.jpg"
								title="lorem ippsum dolor dummy"><img
								src="<c:url value='/resources/client/image/item/${hangHoa.file}'/>"
								title="lorem ippsum dolor dummy" alt="lorem ippsum dolor dummy" /></a>
						</div>
						<div id="product-thumbnail" class="owl-carousel"></div>
					</div>
				</div>
				<div class="col-sm-6">
					<h1 class="productpage-title">${hangHoa.tenHang}</h1>
					<div class="rating product">
						<hr>
						<!-- AddThis Button BEGIN -->
						<div class="addthis_toolbox addthis_default_style"></div>
						<!-- AddThis Button END -->
					</div>
					<ul class="list-unstyled productinfo-details-top">
						<li>
							<h2 class="productpage-price">${hangHoa.donGia} VNĐ</h2>
						</li>
						<li><span class="productinfo-tax">Tính thuế:
								${hangHoa.donGia + hangHoa.donGia/10} VNĐ</span></li>
					</ul>
					<hr>
					<ul class="list-unstyled product_info">
						<li><label>Nhóm sản phẩm:</label> <span> <a
								href="<c:url value='/Client/TrangChu/nhom/${hangHoa.nhomHang}'/>">${hangHoa.nhomHang}</a></span></li>
						<li><label>Mã sản phẩm:</label> <span> sản phẩm
								${hangHoa.maHang}</span></li>
						<li><label>Số lượng có:</label> <span>
								${hangHoa.soLuong}&nbsp${hangHoa.donViTinh}</span></li>
					</ul>

					<div id="product">
						<div class="form-group">
							<label class="control-label qty-label" for="input-quantity">Số lượng mua</label>
							<form:form method="POST" enctype="multipart/form-data"
											modelAttribute="hangHoaNull" action="">
											<form:input type="hidden" value="${hangHoa.maHang}"
												path="maHang" id="maHang" />
							<form:input type="text" name="quantity" value="1" size="2"
								id="input-quantity" class="form-control productpage-qty" path="soLuong"/> 
							<div class="btn-group">							
								<button type="submit" id="button-cart"
									data-loading-text="Loading..."
									class="btn btn-primary btn-lg btn-block addtocart">Thêm vào giỏ</button>								
							</div>
							</form:form>
						</div>
					</div>
				</div>
			</div>
			<div class="productinfo-tab">
				<ul class="nav nav-tabs">
					<li class="active"><a href="#tab-description"
						data-toggle="tab">Thông tin</a></li>
					<li><a href="#tab-review" data-toggle="tab">Nguồn gốc</a></li>
				</ul>
				<div class="tab-content">
					<div class="tab-pane active" id="tab-description">
						<div class="cpt_product_description ">
							<div>
								<p>
									<strong>Thông tin sản phẩm</strong>
								</p>
								<p>${hangHoa.thongTin}</p>
								
							</div>
						</div>
						<!-- cpt_container_end -->
					</div>
					<div class="tab-pane" id="tab-review">
						<div class="cpt_product_description ">
							<div>
								<p>
									<strong>Nguồn gốc sản phẩm</strong>
								</p>
								<p>${hangHoa.nguonGoc}</p>
								
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
</div>

<jsp:include page="/WEB-INF/jsp/client/templates/footer.jsp" />