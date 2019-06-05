<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<jsp:include page="/WEB-INF/jsp/client/templates/header.jsp" />

<div class="container">
	<ul class="breadcrumb">
		<li><a href="index.html"><i class="fa fa-home"></i></a></li>
		<li><a href="category.html">Electronics</a></li>
	</ul>
	<div class="row">
		<div id="column-left" class="col-sm-3 hidden-xs column-left">
			<div class="column-block">
				<div class="columnblock-title">Categories</div>
				<div class="category_block">
					<ul class="box-category treeview-list treeview">
						<li><a href="#" class="activSub">Desktops</a>
							<ul>
								<li><a href="#">PC</a></li>
								<li><a href="#">MAC</a></li>
							</ul></li>
						<li><a href="#" class="activSub">Laptops &amp; Notebooks</a>
							<ul>
								<li><a href="#">Macs</a></li>
								<li><a href="#">Windows</a></li>
							</ul></li>
						<li><a href="#" class="activSub">Components</a>
							<ul>
								<li><a href="#">Mice and Trackballs</a></li>
								<li><a href="#" class="activSub">Monitors</a>
									<ul>
										<li><a href="#">test 1</a></li>
										<li><a href="#">test 2</a></li>
									</ul></li>
								<li><a href="#">Windows</a></li>
							</ul></li>
						<li><a href="#">Tablets</a></li>
						<li><a href="#">Software</a></li>
						<li><a href="#">Phones & PDAs</a></li>
						<li><a href="#">Cameras</a></li>
						<li><a href="#">MP3 Players</a></li>
					</ul>
				</div>
			</div>
			<div class="panel panel-default filter">
				<div class="panel-heading columnblock-title">Refine Search</div>
				<div class="filter-block">
					<div class="list-group">
						<a class="list-group-item">Color</a>
						<div class="list-group-item">
							<div id="filter-group1">
								<label class="checkbox"> <input name="filter[]"
									type="checkbox" value="1" /> Black (7)
								</label> <label class="checkbox"> <input name="filter[]"
									type="checkbox" value="2" /> Blue (6)
								</label> <label class="checkbox"> <input name="filter[]"
									type="checkbox" value="3" /> Red (6)
								</label>
							</div>
						</div>
						<a class="list-group-item">Price</a>
						<div class="list-group-item">
							<div id="filter-group2">
								<label class="checkbox"> <input name="filter[]"
									type="checkbox" value="4" /> $100-$300 (6)
								</label> <label class="checkbox"> <input name="filter[]"
									type="checkbox" value="5" /> $301-$1000 (6)
								</label>
							</div>
						</div>
						<a class="list-group-item">Size</a>
						<div class="list-group-item">
							<div id="filter-group3">
								<label class="checkbox"> <input name="filter[]"
									type="checkbox" value="6" /> Big (3)
								</label> <label class="checkbox"> <input name="filter[]"
									type="checkbox" value="7" /> Medium (3)
								</label> <label class="checkbox"> <input name="filter[]"
									type="checkbox" value="8" /> Small (1)
								</label>
							</div>
						</div>
					</div>
					<div class="panel-footer text-right">
						<button type="button" id="button-filter" class="btn btn-primary">Refine
							Search</button>
					</div>
				</div>
			</div>
			<div class="banner">
				<div class="item">
					<a href="#"><img
						src="<c:url value='/resources/client/image/banners/LeftBanner.jpg'/>"
						alt="Left Banner" class="img-responsive" /></a>
				</div>
			</div>
			
		</div>
		<div id="content" class="col-sm-9">
			<h2 class="category-title">Desktops</h2>
			<div class="row category-banner">
				<div class="col-sm-12 category-image">
					<img
						src="<c:url value='/resources/client/image/banners/bannerReal4.png'/>"
						alt="Desktops" title="Desktops" class="img-thumbnail" />
				</div>
				<div class="col-sm-12 category-desc">Để có sức khỏe dồi dào,
					cơ thể chúng ta cần nạp tối đa nguồn dưỡng chất thực vật quý giá từ
					các loại rau củ quả. Theo khuyến nghị của Tổ chức Y tế thế giới
					(WHO) , bạn nên ăn tối thiểu 400 gr rau củ quả mỗi ngày với đa dạng
					sắc màu. Tuy nhiên tại VN, 80% người trưởng thành không đảm bảo
					được lượng eau củ quả tối thiểu này.</div>
			</div>
			<div class="category-page-wrapper">
				<div class="col-md-6 list-grid-wrapper">
					<div class="btn-group btn-list-grid">
						<button type="button" id="list-view" class="btn btn-default list"
							data-toggle="tooltip" title="List">
							<i class="fa fa-th-list"></i>
						</button>
						<button type="button" id="grid-view" class="btn btn-default grid"
							data-toggle="tooltip" title="Grid">
							<i class="fa fa-th"></i>
						</button>
					</div>			
				</div>
				<div class="col-md-1 text-right page-wrapper">
					<label class="control-label" for="input-limit">Show :</label>
					<div class="limit">
						<select id="input-limit" class="form-control">
							<option value="8" selected="selected">8</option>
							<option value="25">25</option>
							<option value="50">50</option>
							<option value="75">75</option>
							<option value="100">100</option>
						</select>
					</div>
				</div>
				<div class="col-md-2 text-right sort-wrapper">
					<label class="control-label" for="input-sort">Sort By :</label>
					<div class="sort-inner">
						<select id="input-sort" class="form-control">
							<option value="ASC" selected="selected">Default</option>
							<option value="ASC">Name (A - Z)</option>
							<option value="DESC">Name (Z - A)</option>
							<option value="ASC">Price (Low &gt; High)</option>
							<option value="DESC">Price (High &gt; Low)</option>
							<option value="DESC">Rating (Highest)</option>
							<option value="ASC">Rating (Lowest)</option>
							<option value="ASC">Model (A - Z)</option>
							<option value="DESC">Model (Z - A)</option>
						</select>
					</div>
				</div>
			</div>
			<br />
			<div class="grid-list-wrapper">
				<c:forEach var="tempHangHoa" items="${HangHoa}">
					<div class="product-layout product-list col-xs-12"
						style="float: left;">
						<div class="product-thumb">
							<div class="image product-imageblock" style="height: 250px;">
								<a href="product.html"> <img class="hangHoa"
									src="<c:url value='/resources/client/image/item/${tempHangHoa.file}'/>"
									alt="women's clothing stores" title="lorem ippsum dolor dummy"
									class="img-responsive" />
								</a>
								<div class="button-group">
									<a href="/Client/TrangRau/ThemVaoGio" class="addtocart-btn">Thêm Vào
										Giỏ</a>
								</div>
							</div>
							<div class="caption product-detail">
								<h4 class="product-name">
									<a href="product.html" title="lorem ippsum dolor dummy">
										${tempHangHoa.tenHang} </a>
								</h4>
								<p class="product-desc">${tempHangHoa.thongTin}</p>
								<p class="product-desc">${tempHangHoa.nguonGoc}</p>
								<p class="price product-price">${tempHangHoa.donGia}
									VNĐ/${tempHangHoa.donViTinh}</p>

							</div>
							<div class="button-group">

								<button type="button" class="addtocart-btn">Thêm Vào
									Giỏ</button>

							</div>
						</div>
					</div>
				</c:forEach>
			</div>
			<div class="category-page-wrapper">
				<div class="result-inner">Showing 1 to 8 of 10 (2 Pages)</div>
				<div class="pagination-inner">
					<ul class="pagination">
						<li class="active"><span>1</span></li>
						<li><a href="category.html">2</a></li>
						<li><a href="category.html">&gt;</a></li>
						<li><a href="category.html">&gt;|</a></li>
					</ul>
				</div>
			</div>
		</div>
	</div>
</div>

<jsp:include page="/WEB-INF/jsp/client/templates/footer.jsp" />