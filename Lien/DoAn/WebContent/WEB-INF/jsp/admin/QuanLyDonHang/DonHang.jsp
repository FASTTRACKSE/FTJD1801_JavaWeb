<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<jsp:include page="/WEB-INF/jsp/admin/templates/header.jsp" />

<style>
.tbl_actions a {
	color: #333;
	font-size: 13px;
	display: inline-block;
	padding: 2px 5px;
	border: 1px solid #ccc;
	border-radius: 5px;
	background-color: #FFF;
}

.tbl_actions a i {
	margin-right: 3px;
}

.green {
	color: #5cb85c;
}

.blue {
	color: #337ab7;
}

.red {
	color: #d9534f;
}

#datatable tr td:last-child {
	letter-spacing: 15px;
	min-width: 100px;
	text-align: center !important;
}

#datatable>thead>tr>th:last-child[class*="sort"]::after {
	content: ""
}

#datatable>thead>tr>th:last-child[class*="sort"]::before {
	content: ""
}

img {
	width: 50px;
	height: 60px;
}
</style>
<div class="app-content content container-fluid">
	<div style="margin: 100px 50px;">

		<!-- Path -->
		<div class="content-header row">
			<div class="content-header-left col-md-9 col-xs-12 mb-2">
				<h3 class="content-header-title mb-0">Danh sách đơn hàng</h3>
				<div class="row breadcrumbs-top">
					<div class="breadcrumb-wrapper col-xs-12">
						<ol class="breadcrumb">
							<li class="breadcrumb-item"><a
								href='<c:url value="/Admin" />'>Trang chủ</a></li>
							<li class="breadcrumb-item active">Danh sách đơn hàng</li>
						</ol>
					</div>
				</div>
			</div>
		</div>
		<!-- End Path -->

		<div class="content-body">

			<!-- Show message -->
			<c:if test="${messageSuccess ne null}">
				<div class="alert alert-success alert-dismissable" role="alert">
					<button type="button" class="close" data-dismiss="alert">
						<span aria-hidden="true">&times;</span><span class="sr-only">Close</span>
					</button>
					${messageSuccess}
				</div>
			</c:if>
			<c:if test="${messageError ne null}">
				<div class="alert alert-danger alert-dismissable" role="alert">
					<button type="button" class="close" data-dismiss="alert">
						<span aria-hidden="true">&times;</span><span class="sr-only">Close</span>
					</button>
					${messageError}
				</div>
			</c:if>
			<!-- End Show message -->

			<div class="row">
				<div class="col-xs-12">
					<div class="card">
						
						<div class="card-body collapse in">
							<div class="card-block card-dashboard">
								<div class="table-responsive">
									<label>Mã đơn hàng: ${donHang.maDonHang}</label><br>
									<label>Khách hàng: ${khachHang.tenKhachHang}</label><br>
									<label>Địa chỉ giao: ${donHang.diaChi}</label><br>
									<label>Ngày đặt hàng: ${donHang.ngayDatHang}</label><br>
									<label>Ngày giao hàng: ${donHang.ngayGiaoHang}</label><br>
									<label>Thuế: ${donHang.vat}/1</label><br>
									<label>Tổng thành tiền: ${donHang.tongThanhTien} VNĐ</label><br>
									<label>Nhân viên: ${nhanVien.tenNhanVien}</label><br>																	
									<label>Trạng thái: ${donHang.trangThai}</label><br>								
								</div>
								<div class="table-responsive" style="margin-top: 40px;">
									<ol class="breadcrumb">																	
										<li class="breadcrumb-item active">Thông tin hàng hóa đơn hàng</li>
									</ol>
									<table id="datatable"
										class="table table-striped table-bordered dataex-res-constructor">
										
										<thead>
											<tr style="color: #005500; background-color: #99FFCC;">
												<td>Mã đơn hàng</td>
												<td>Sản phẩm</td>
												<td>Số lượng</td>
												<td>Đơn giá</td>
												<td>Thành tiền</td>
												<td></td>
											</tr>
										</thead>
									</table>									
								</div>
								<a class="btn btn-info" href="<c:url value='/Admin/QuanLyDonHang/DuyetDon' />">Quay Lại</a>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
</div>

<jsp:include page="/WEB-INF/jsp/admin/templates/footer.jsp" />