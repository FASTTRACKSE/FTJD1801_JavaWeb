<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<jsp:include page="/WEB-INF/jsp/client/templates/header.jsp" />

<div class="container">
	<ul class="breadcrumb">
		<li><a href="index.html"><i class="fa fa-home"></i></a></li>
		<li><a href="cart.html">Chi tiết giỏ hàng</a></li>
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
					
		<div class="col-sm-9" id="content">
			<h1>Giỏ hàng của bạn</h1>
			<div class="table-responsive">
				<table class="table table-bordered">

					<thead>
						<tr>
							<td class="text-center">Hình ảnh</td>
							<td class="text-left">Tên sản phẩm</td>
							<td class="text-left">Loại sản phẩm</td>
							<td class="text-left">Số lượng</td>
							<td class="text-right">Đơn giá</td>
							<td class="text-right">Tổng cộng</td>
						</tr>
					</thead>
					<c:forEach var="tempGioHang" items="${gioHang}">
						<tbody>
							<tr>
								<td class="text-center"><a href="<c:url value='/Client/ChiTietHang/xem/${tempGioHang.maHang}'/>"><img
										style="width: 80px;" class="img-thumbnail"
										title="women's clothing" alt="women's clothing"
										src="<c:url value='/resources/client/image/item/${tempGioHang.file}'/>"></a></td>
								<td class="text-left"><a href="<c:url value='/Client/ChiTietHang/xem/${tempGioHang.maHang}'/>">${tempGioHang.tenHang}</a></td>
								<td class="text-left">${tempGioHang.nhomHang}</td>
								<td class="text-left"><div style="max-width: 200px;"
										class="input-group btn-block">
										<form:form method="POST" enctype="multipart/form-data"
											modelAttribute="hangHoa" action="">
											<form:input type="hidden" value="${tempGioHang.maHang}"
												path="maHang" id="maHang" />
											<form:input type="text" class="form-control quantity"
												size="1" value="${tempGioHang.soLuong}" name="quantity"
												path="soLuong" />

											<span class="input-group-btn">
												<button class="btn btn-primary" title=""
													data-toggle="tooltip" type="submit"
													data-original-title="Update">
													<i class="fa fa-refresh"></i>
												</button> <a style="padding: 8px;" class="btn btn-danger" data-toggle="tooltip"
												href="<c:url value='/Client/GioHang/xoa/${tempGioHang.maHang}'/>"
												data-original-title="Remove"> <i
													class="fa fa-times-circle"></i>
											</a>
											</span>
										</form:form>
									</div></td>
								<td class="text-right">${tempGioHang.donGia} VNĐ</td>
								<td class="text-right">${tempGioHang.donGia * tempGioHang.soLuong}</td>
							</tr>
						</tbody>
					</c:forEach>
				</table>
			</div>

			
			<div class="row">
				<div class="col-sm-5 col-sm-offset-7">
					<table class="table table-bordered">
						<tbody>
							<tr>
								<td class="text-right"><strong>Tổng tiền sản phẩm:</strong></td>
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
								<td class="text-right"><strong>Tổng thành tiền:</strong></td>
								<td class="text-right">${tongTien + tongTien/10 + 30000}
									VNĐ</td>
							</tr>
						</tbody>
					</table>
				</div>
			</div>
			<div class="buttons">
				<div class="pull-left">
					<a class="btn btn-default" href="<c:url value='/Client/TrangChu'/>">Tiếp tục chọn hàng</a>
				</div>
				<div class="pull-right">
					<a class="btn btn-primary" href="<c:url value='/Client/DatHang'/>">Đặt hàng</a>
				</div>
			</div>
		</div>
	</div>
</div>

<jsp:include page="/WEB-INF/jsp/client/templates/footer.jsp" />