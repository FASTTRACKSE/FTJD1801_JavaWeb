<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<jsp:include page="/WEB-INF/jsp/client/templates/header.jsp" />

<div class="container">
	<ul class="breadcrumb">
		<li><a href="index.html"><i class="fa fa-home"></i></a></li>
		<li><a href="cart.html">Shopping Cart</a></li>
		<li><a href="checkout.html">Checkout</a></li>
	</ul>
	<div class="row">
		<div id="column-left" class="col-sm-3 hidden-xs column-left"
			style="width: 250px;">
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
						<button type="button" id="button-filter" class="btn btn-primary">Tra
							cứu</button>
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
			<h1>Đặt hàng</h1>

			<div id="accordion" class="panel-group">

				<div class="panel panel-default">
					<div class="panel-heading">
						<h4 class="panel-title">
							<a class="accordion-toggle collapsed" data-parent="#accordion"
								data-toggle="collapse" href="#collapse-shipping-method"
								aria-expanded="false">Bước 1: Tri ân khách hàng <i
								class="fa fa-caret-down"></i></a>
						</h4>
					</div>
					<div id="collapse-shipping-method" role="heading"
						class="panel-collapse collapse" aria-expanded="false"
						style="height: 0px;">
						<div class="panel-body">
							<p>
								<strong>*Lưu ý: </strong> Bạn hiện có <strong>${user.point}</strong>
								điểm tích lũy. Mỗi điểm tích lũy được sử dụng sẽ giảm trực tiếp
								1000 VNĐ vào hóa đơn.
							</p>
							<p>Bạn sẽ nhận được điểm tích lũy khi mua hàng với tỉ lệ
								10000 VNĐ/1 điểm.</p>
							<p style="color: red;">${loiPoint}</p>
							<div style="max-width: 200px;" class="input-group btn-block">
								<form method="POST" enctype="multipart/form-data"
									action="/DoAn/Client/DatHang/updatePoint">
									<input type="text" class="form-control quantity" size="1"
										value="${point}" name="point" id="point" /> <span
										class="input-group-btn">
										<button class="btn btn-primary" title="" data-toggle="tooltip"
											type="submit" data-original-title="Update">
											<i class="fa fa-refresh"></i>
										</button>
									</span>
								</form>
							</div>
						</div>
					</div>
				</div>
				<div style="margin-bottom: 5px;"></div>
				<form:form method="POST" enctype="multipart/form-data"
					modelAttribute="donHang" action="">
					<div class="panel panel-default">
						<div class="panel-heading">
							<h4 class="panel-title">
								<a class="accordion-toggle collapsed" data-parent="#accordion"
									data-toggle="collapse" href="#collapse-payment-address"
									aria-expanded="false">Bước 2: Xác nhận địa chỉ giao hàng <i
									class="fa fa-caret-down"></i></a>
							</h4>
						</div>
						<div id="collapse-payment-address" role="heading"
							class="panel-collapse collapse" aria-expanded="false"
							style="height: 0px;">
							<div class="panel-body">

								<div class="radio">
									<label> <input type="radio" checked="checked"
										value="existing" name="payment_address"
										data-id="payment-existing"> Bạn có muốn sử dụng địa chỉ này
									</label>
								</div>
								<div id="payment-existing">
									<form:input type="text" name="diaChi" value="${user.diaChi}"
										id="diaChi" class="form-control" 
										path="diaChi" />
								</div>
								

								<script type="text/javascript">
									$('input[name=\'payment_address\']').on(
											'change',
											function() {
												if (this.value == 'new') {
													$('#payment-existing')
															.hide();
													$('#payment-new').show();
												} else {
													$('#payment-existing')
															.show();
													$('#payment-new').hide();
												}
											});
								</script>
							</div>
						</div>
					</div>
					<div class="panel panel-default">
						<div class="panel-heading">
							<h4 class="panel-title">
								<a class="accordion-toggle collapsed" data-parent="#accordion"
									data-toggle="collapse" href="#collapse-shipping-address"
									aria-expanded="false">Bước 3: Xác nhận số điện thoại giao
									hàng <i class="fa fa-caret-down"></i>
								</a>
							</h4>
						</div>
						<div id="collapse-shipping-address" role="heading"
							class="panel-collapse collapse" aria-expanded="false"
							style="height: 0px;">
							<div class="panel-body">
								<div class="radio">
									<label> <input type="radio" checked="checked"
										value="existing" name="shipping_address"> Bạn có muốn sử dụng số điện thoại này
									</label>
								</div>
								<div id="shipping-existing">
									<form:input type="hidden" name="maDonHang" id="maDonHang"
										class="form-control" path="maDonHang" />
									<form:input type="text" name="soDienThoai"
										value="${user.soDienThoai}" id="soDienThoai"
										class="form-control" path="soDienThoai" />
								</div>

								<script type="text/javascript">
									$('input[name=\'shipping_address\']').on(
											'change',
											function() {
												if (this.value == 'new') {
													$('#shipping-existing')
															.hide();
													$('#shipping-new').show();
												} else {
													$('#shipping-existing')
															.show();
													$('#shipping-new').hide();
												}
											});
								</script>
							</div>
						</div>
					</div>

					<div class="panel panel-default">
						<div class="panel-heading">
							<h4 class="panel-title">
								<a class="accordion-toggle collapsed" data-parent="#accordion"
									data-toggle="collapse" href="#collapse-payment-method"
									aria-expanded="false">Bước 4: Phương thức thanh toán <i
									class="fa fa-caret-down"></i></a>
							</h4>
						</div>
						<div id="collapse-payment-method" role="heading"
							class="panel-collapse collapse" aria-expanded="false"
							style="height: 0px;">
							<div class="panel-body">
								<div class="radio">
									<label>Phí ship toàn quốc - 30000 VNĐ </label> <label>
										Thanh toán khi nhận hàng </label>
								</div>
								<p>
									<strong>*Lưu ý: </strong> Kiểm tra hàng trước khi nhận.
								</p>

							</div>
						</div>
					</div>
					<div class="panel panel-default">
						<div class="panel-heading">
							<h4 class="panel-title">
								<a class="accordion-toggle" data-parent="#accordion"
									data-toggle="collapse" href="#collapse-checkout-confirm"
									aria-expanded="true">Bước 5: Xác nhận đơn hàng <i
									class="fa fa-caret-down"></i></a>
							</h4>
						</div>
						<div id="collapse-checkout-confirm" role="heading"
							class="panel-collapse collapse in" aria-expanded="true" style="">
							<div class="panel-body">
								<div class="table-responsive">
									<table class="table table-bordered table-hover">
										<thead>
											<tr>
												<td class="text-left">Tên sản phẩm</td>
												<td class="text-left">Loại sản phẩm</td>
												<td class="text-right">Số lượng</td>
												<td class="text-right">Đơn giá</td>
												<td class="text-right">Tổng giá</td>
											</tr>
										</thead>
										<c:forEach var="tempGioHang" items="${gioHang}">
											<tbody>
												<tr>
													<td class="text-left"><a
														href="<c:url value='/Client/ChiTietHang/xem/${tempGioHang.maHang}'/>">${tempGioHang.tenHang}</a></td>
													<td class="text-left">${tempGioHang.nhomHang}</td>
													<td class="text-right">${tempGioHang.soLuong}</td>
													<td class="text-right">${tempGioHang.donGia}</td>
													<td class="text-right">${tempGioHang.soLuong * tempGioHang.donGia}</td>
												</tr>
											</tbody>
										</c:forEach>
										<tfoot>
											<tr>
												<td class="text-right" colspan="4"><strong>Tổng
														tiền sản phẩm:</strong></td>
												<td class="text-right">${tongTien}VNĐ</td>
											</tr>
											<tr>
												<td class="text-right" colspan="4"><strong>Phí
														vận chuyển: </strong></td>
												<td class="text-right">30000 VNĐ</td>
											</tr>
											<tr>
												<td class="text-right" colspan="4"><strong>Thuế:
												</strong></td>
												<td class="text-right">${tongTien/10}VNĐ</td>
											</tr>
											<tr>
												<td class="text-right" colspan="4"><strong>Khuyến
														mãi tích lũy: </strong></td>
												<td class="text-right">${point}điểm ~ ${point*1000} VNĐ</td>
											</tr>
											<tr>
												<td class="text-right" colspan="4"><strong>Tích
														lũy sau hóa đơn: </strong></td>
												<td class="text-right">${tongThanhTien}VNĐ ~
													${tongThanhTien/10000} Điểm</td>
											</tr>
											<tr>
												<td class="text-right" colspan="4"><strong>Tổng
														thành tiền:</strong></td>
												<td class="text-right">${tongThanhTien - point*1000}</td>
											</tr>
										</tfoot>
									</table>
								</div>
								<div class="buttons">
									<div class="pull-right">
										<input type="submit" data-loading-text="Loading..."
											class="btn btn-primary" id="button-confirm"
											value="Xác nhận đặt hàng">
									</div>
								</div>
							</div>
						</div>
					</div>
				</form:form>
			</div>

		</div>
	</div>
</div>

<jsp:include page="/WEB-INF/jsp/client/templates/footer.jsp" />