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
				<h3 class="content-header-title mb-0">Danh sách sản phẩm</h3>
				<div class="row breadcrumbs-top">
					<div class="breadcrumb-wrapper col-xs-12">
						<ol class="breadcrumb">
							<li class="breadcrumb-item"><a
								href='<c:url value="/Admin" />'>Trang chủ</a></li>
							<li class="breadcrumb-item active">Danh sách sản phẩm</li>
						</ol>
						<a class="btn btn-info" href="<c:url value='/Admin/QuanLyDuLieu/HangHoa/them' />">Thêm sản phẩm <i class="fa fa-plus"></i></a>
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

							</div>
						</div>
						<div class="card-body collapse in">
							<div class="card-block card-dashboard">
								<div class="table-responsive">
									<table id="datatable"
										class="table table-striped table-bordered dataex-res-constructor">
										<c:forEach var="tempHangHoa" items="${HangHoa}">
											<tr>
												<td>${tempHangHoa.maHang}</td>
												<td>${tempHangHoa.tenHang}</td>
												<td>${tempHangHoa.donGia}</td>
												<td>${tempHangHoa.donViTinh}</td>
												<td>${tempHangHoa.soLuong}</td>
												<td><img
													src="<c:url value='/resources/client/image/item/${tempHangHoa.filePath}'/>"
													class="rounded" width="50" height="50" /></td>
												<td><a
													href="<c:url value='/Admin/QuanLyDuLieu/HangHoa/xem/${tempHangHoa.maHang}' />"><i
														class="fa fa-eye"></i></a> <a
													href="<c:url value='/Admin/QuanLyDuLieu/HangHoa/duyet/${tempHangHoa.maHang}' />"><i
														class="fa fa-edit"></i></a> <a
													href="<c:url value='/Admin/QuanLyDuLieu/HangHoa/huy/${tempHangHoa.maHang}' />">
														<i class="fa fa-minus-square"></i>
												</a></td>
											</tr>
										</c:forEach>
										<thead>
											<tr style="color: #005500; background-color: #99FFCC;">
												<td>ID</td>
												<td>Tên hàng</td>
												<td>Đơn giá</td>
												<td>Đơn vị Tính</td>
												<td>Số lượng</td>
												<td>Hình ảnh</td>
												<td></td>
											</tr>
										</thead>
									</table>
									<c:if test="${crPage != null}">

										<ul class="pagination">
											<c:if test="${crPage != 1}">
												<li class="page-item"><a class="page-link"
													href="/DoAn/Admin/QuanLyDuLieu/HangHoa/list/1">Trang
														đầu</a></li>
												<li class="page-item"><a class="page-link"
													href="/DoAn/Admin/QuanLyDuLieu/HangHoa/list/${crPage-1}">Trang
														trước</a></li>
											</c:if>

											<c:choose>
												<c:when test="${crPage eq 1}">
													<c:choose>
														<c:when test="${totalPage gt 2}">
															<li class="page-item active"><a class="page-link"
																href="/DoAn/Admin/QuanLyDuLieu/HangHoa/list/${crPage}">${crPage}</a></li>
															<li class="page-item"><a class="page-link"
																href="/DoAn/Admin/QuanLyDuLieu/HangHoa/list/${crPage+1}">${crPage+1}</a></li>
															<li class="page-item"><a class="page-link"
																href="/DoAn/Admin/QuanLyDuLieu/HangHoa/list/${crPage+2}">${crPage+2}</a>
														</c:when>
														<c:when test="${totalPage gt 1}">
															<li class="page-item active"><a class="page-link"
																href="/DoAn/Admin/QuanLyDuLieu/HangHoa/list/${crPage}">${crPage}</a></li>
															<li class="page-item"><a class="page-link"
																href="/DoAn/Admin/QuanLyDuLieu/HangHoa/list/${crPage+1}">${crPage+1}</a></li>
														</c:when>
														<c:when test="${totalPage gt 0}">
															<li class="page-item active"><a class="page-link"
																href="/DoAn/Admin/QuanLyDuLieu/HangHoa/list/${crPage}">${crPage}</a></li>
														</c:when>
													</c:choose>
												</c:when>
												<c:when test="${crPage eq totalPage}">
													<c:choose>
														<c:when test="${totalPage gt 2}">
															<li class="page-item"><a class="page-link"
																href="/DoAn/Admin/QuanLyDuLieu/HangHoa/list/${crPage-2}">${crPage-2}</a></li>
															<li class="page-item"><a class="page-link"
																href="/DoAn/Admin/QuanLyDuLieu/HangHoa/list/${crPage-1}">${crPage-1}</a></li>
															<li class="page-item active"><a class="page-link"
																href="/DoAn/Admin/QuanLyDuLieu/HangHoa/list/${crPage}">${crPage}</a>
														</c:when>
														<c:when test="${totalPage gt 1}">
															<li class="page-item"><a class="page-link"
																href="/DoAn/Admin/QuanLyDuLieu/HangHoa/list/${crPage-1}">${crPage-1}</a></li>
															<li class="page-item active"><a class="page-link"
																href="/DoAn/Admin/QuanLyDuLieu/HangHoa/list/${crPage}">${crPage}</a>
														</c:when>
														<c:when test="${totalPage gt 1}">
															<li class="page-item active"><a class="page-link"
																href="/DoAn/Admin/QuanLyDuLieu/HangHoa/list/${crPage}">${crPage}</a>
														</c:when>
													</c:choose>
												</c:when>
												<c:otherwise>
													<li class="page-item"><a class="page-link"
														href="/DoAn/Admin/QuanLyDuLieu/HangHoa/list/${crPage-1}">${crPage-1}</a></li>
													<li class="page-item active"><a class="page-link"
														href="/DoAn/Admin/QuanLyDuLieu/HangHoa/list/${crPage}">${crPage}</a></li>
													<li class="page-item"><a class="page-link"
														href="/DoAn/Admin/QuanLyDuLieu/HangHoa/list/${crPage+1}">${crPage+1}</a></li>
												</c:otherwise>
											</c:choose>

											<c:if test="${crPage lt totalPage}">
												<li class="page-item"><a class="page-link"
													href="/DoAn/Admin/QuanLyDuLieu/HangHoa/list/${crPage+1}">Trang
														sau</a></li>
												<li class="page-item"><a class="page-link"
													href="/DoAn/Admin/QuanLyDuLieu/HangHoa/list/${totalPage}">Trang
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