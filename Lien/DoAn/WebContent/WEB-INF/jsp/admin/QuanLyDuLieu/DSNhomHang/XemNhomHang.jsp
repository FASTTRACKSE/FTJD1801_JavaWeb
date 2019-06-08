<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<jsp:include page="/WEB-INF/jsp/admin/templates/header.jsp" />
<div class="app-content content container-fluid">
	<div style="margin: 100px 50px;">
		<!-- Path -->
		<div class="content-header row">
			<div class="content-header-left col-md-6 col-xs-12 mb-2">
				<h3 class="content-header-title mb-0">Xem chi tiết nhóm hàng</h3>
				<div class="row breadcrumbs-top">
					<div class="breadcrumb-wrapper col-xs-20">
						<ol class="breadcrumb">
							<li class="breadcrumb-item"><a
								href='<c:url value="/Admin" />'>Trang chủ</a></li>
							<li class="breadcrumb-item"><a
								href='<c:url value="/Admin/QuanLyDuLieu/NhomHang" />'>Danh
									sách nhóm hàng</a></li>
							<li class="breadcrumb-item active">Xem chi tiết nhóm hàng</li>
						</ol>
					</div>
				</div>
			</div>
		</div>
		<!-- End Path -->

		<div class="content-body">
			<div class="main-content">
				<div class="row">
					<form:form method="POST" modelAttribute="nhomHang" action="">
						<div class="form-group col-sm-4">
							<label>Mã nhóm sản phẩm</label>
							<form:input class="form-control" path="maNhom"
								placeholder="mã nhóm sản phẩm" readonly="true" />
						</div>
						<div class="form-group col-sm-4">
							<label>Tên nhóm sản phẩm</label>
							<form:input class="form-control" path="tenNhom"
								placeholder="tên nhóm sản phẩm" readonly="true" />
						</div>
						<div class="form-group col-sm-12">
							<label>Ghi chú</label>
							<form:textarea class="form-control" path="ghiChu"
								placeholder="chú thích" readonly="true" />
						</div>

						<div class="col-sm-12 text-center">
							<c:if test="${edit eq false}">
								<button type="submit" class="btn btn-success">Lưu</button>
							</c:if>
							<c:if test="${edit eq true}">
								<button type="submit" class="btn btn-success">Cập nhật</button>
							</c:if>
						</div>
					</form:form>

				</div>
				<div class="col-sm-12 text-center">
					<a class="btn btn-info"
						href="<c:url value='/Admin/QuanLyDuLieu/NhomHang' />">Quay lại
					</a>
				</div>
			</div>
		</div>
	</div>
</div>

<jsp:include page="/WEB-INF/jsp/admin/templates/footer.jsp" />