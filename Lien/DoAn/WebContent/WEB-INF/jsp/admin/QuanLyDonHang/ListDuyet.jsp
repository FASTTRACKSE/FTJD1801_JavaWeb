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
				<h3 class="content-header-title mb-0">Thông tin đơn hàng</h3>
				<div class="row breadcrumbs-top">
					<div class="breadcrumb-wrapper col-xs-12">
						<ol class="breadcrumb">
							<li class="breadcrumb-item"><a
								href='<c:url value="/Admin" />'>Trang chủ</a></li>
							<li class="breadcrumb-item active">Thông tin đơn hàng</li>
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
						<div class="card-header">
							<div class="heading-elements" style="margin-bottom: 10px;">
								<a class="btn btn-info" href="<c:url value='/Admin/QuanLyDonHang/DuyetDon/TatCaDon' />">Tất cả</a>
								<a class="btn btn-info" href="<c:url value='/Admin/QuanLyDonHang/DuyetDon/DonChuaDuyet' />">Chưa duyệt</a>
								<a class="btn btn-info" href="<c:url value='/Admin/QuanLyDonHang/DuyetDon/DonDaDuyet' />">Đã duyệt</a>
								<a class="btn btn-info" href="<c:url value='/Admin/QuanLyDonHang/DuyetDon/DonDangGiao' />">Đang giao</a>
								<a class="btn btn-info" href="<c:url value='/Admin/QuanLyDonHang/DuyetDon/DonDaGiao' />">Đã giao</a>
								<a class="btn btn-info" href="<c:url value='/Admin/QuanLyDonHang/DuyetDon/DonDaHuy' />">Đã hủy</a>
							</div>
						</div>
						<div class="card-body collapse in">
							<div class="card-block card-dashboard">
								<div class="table-responsive">
									<table id="datatable"
										class="table table-striped table-bordered dataex-res-constructor">
										<c:forEach var="tempDonHang" items="${DonHang}">
											<tr>
												<td>${tempDonHang.maDonHang}</td>
												<td>${tempDonHang.ngayDatHang}</td>
												<td>${tempDonHang.ngayGiaoHang}</td>
												<td>${tempDonHang.tongThanhTien}</td>												
												<td>${tempDonHang.trangThai}</td>									
												<td><a
													href="<c:url value='/Admin/QuanLyDonHang/DuyetDon/xem/${tempDonHang.maDonHang}' />"><i
														class="fa fa-eye"></i></a> <a
													href="<c:url value='/Admin/QuanLyDonHang/DuyetDon/duyet/${tempDonHang.maDonHang}' />"><i
														class="fa fa-check-square"></i></a> <a
													href="<c:url value='/Admin/QuanLyDonHang/DuyetDon/huy/${tempDonHang.maDonHang}' />">
														<i class="fa fa-minus-square"></i>
												</a></td>
											</tr>
										</c:forEach>
										<thead>
											<tr style="color: #005500; background-color: #99FFCC;">
												<td>ID</td>
												<td>Ngày đặt hàng</td>
												<td>Ngày giao hàng</td>
												<td>Tổng thành tiền</td>
												<td>Trạng thái</td>
												<td></td>
											</tr>
										</thead>
									</table>
									<c:if test="${crPage != null}">

										<ul class="pagination">
											<c:if test="${crPage != 1}">
												<li class="page-item"><a class="page-link"
													href="/DoAn/Admin/QuanLyDonHang/DuyetDon/list/1">Trang
														đầu</a></li>
												<li class="page-item"><a class="page-link"
													href="/DoAn/Admin/QuanLyDonHang/DuyetDon/list/${crPage-1}">Trang
														trước</a></li>
											</c:if>

											<c:choose>
												<c:when test="${crPage eq 1}">
													<c:choose>
														<c:when test="${totalPage gt 2}">
															<li class="page-item active"><a class="page-link"
																href="/DoAn/Admin/QuanLyDonHang/DuyetDon/list/${crPage}">${crPage}</a></li>
															<li class="page-item"><a class="page-link"
																href="/DoAn/Admin/QuanLyDonHang/DuyetDon/list/${crPage+1}">${crPage+1}</a></li>
															<li class="page-item"><a class="page-link"
																href="/DoAn/Admin/QuanLyDonHang/DuyetDon/list/${crPage+2}">${crPage+2}</a>
														</c:when>
														<c:when test="${totalPage gt 1}">
															<li class="page-item active"><a class="page-link"
																href="/DoAn/Admin/QuanLyDonHang/DuyetDon/list/${crPage}">${crPage}</a></li>
															<li class="page-item"><a class="page-link"
																href="/DoAn/Admin/QuanLyDonHang/DuyetDon/list/${crPage+1}">${crPage+1}</a></li>
														</c:when>
														<c:when test="${totalPage gt 0}">
															<li class="page-item active"><a class="page-link"
																href="/DoAn/Admin/QuanLyDonHang/DuyetDon/list/${crPage}">${crPage}</a></li>
														</c:when>
													</c:choose>
												</c:when>
												<c:when test="${crPage eq totalPage}">
													<c:choose>
														<c:when test="${totalPage gt 2}">
															<li class="page-item"><a class="page-link"
																href="/DoAn/Admin/QuanLyDonHang/DuyetDon/list/${crPage-2}">${crPage-2}</a></li>
															<li class="page-item"><a class="page-link"
																href="/DoAn/Admin/QuanLyDonHang/DuyetDon/list/${crPage-1}">${crPage-1}</a></li>
															<li class="page-item active"><a class="page-link"
																href="/DoAn/Admin/QuanLyDonHang/DuyetDon/list/${crPage}">${crPage}</a>
														</c:when>
														<c:when test="${totalPage gt 1}">
															<li class="page-item"><a class="page-link"
																href="/DoAn/Admin/QuanLyDonHang/DuyetDon/list/${crPage-1}">${crPage-1}</a></li>
															<li class="page-item active"><a class="page-link"
																href="/DoAn/Admin/QuanLyDonHang/DuyetDon/list/${crPage}">${crPage}</a>
														</c:when>
														<c:when test="${totalPage gt 1}">
															<li class="page-item active"><a class="page-link"
																href="/DoAn/Admin/QuanLyDonHang/DuyetDon/list/${crPage}">${crPage}</a>
														</c:when>
													</c:choose>
												</c:when>
												<c:otherwise>
													<li class="page-item"><a class="page-link"
														href="/DoAn/Admin/QuanLyDonHang/DuyetDon/list/${crPage-1}">${crPage-1}</a></li>
													<li class="page-item active"><a class="page-link"
														href="/DoAn/Admin/QuanLyDonHang/DuyetDon/list/${crPage}">${crPage}</a></li>
													<li class="page-item"><a class="page-link"
														href="/DoAn/Admin/QuanLyDonHang/DuyetDon/list/${crPage+1}">${crPage+1}</a></li>
												</c:otherwise>
											</c:choose>

											<c:if test="${crPage lt totalPage}">
												<li class="page-item"><a class="page-link"
													href="/DoAn/Admin/QuanLyDonHang/DuyetDon/list/${crPage+1}">Trang
														sau</a></li>
												<li class="page-item"><a class="page-link"
													href="/DoAn/Admin/QuanLyDonHang/DuyetDon/list/${totalPage}">Trang
														cuối</a></li>
											</c:if>
										</ul>
									</c:if>
								</div>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
</div>

<jsp:include page="/WEB-INF/jsp/admin/templates/footer.jsp" />