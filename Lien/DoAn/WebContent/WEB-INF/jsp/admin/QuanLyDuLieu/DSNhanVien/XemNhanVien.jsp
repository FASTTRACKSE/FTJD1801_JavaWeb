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
				<h3 class="content-header-title mb-0">Xem thông tin nhân viên</h3>
				<div class="row breadcrumbs-top">
					<div class="breadcrumb-wrapper col-xs-20">
						<ol class="breadcrumb">
							<li class="breadcrumb-item"><a
								href='<c:url value="/Admin" />'>Trang chủ</a></li>
							<li class="breadcrumb-item"><a
								href='<c:url value="/Admin/QuanLyDuLieu/NhanVien" />'>Danh
									sách nhân viên</a></li>
							<li class="breadcrumb-item active">Xem thông tin nhân viên</li>
						</ol>
					</div>
				</div>
			</div>
		</div>
		<!-- End Path -->

		<div class="content-body">
			<div class="main-content">
				<div class="row">
					<form:form method="POST" enctype="multipart/form-data"
						modelAttribute="nhanVien" action="">
						<div class="form-group col-sm-4">
							<label>Mã nhân viên</label>
							<form:input class="form-control" path="maNhanVien"
								placeholder="mã nhân viên" readonly="true" />
						</div>
						<div class="form-group col-sm-4">
							<label>Tên nhân viên</label>
							<form:input class="form-control" path="tenNhanVien"
								placeholder="tên nhân viên" readonly="true" />
						</div>
						<div class="form-group col-sm-3">
							<label>Chức vụ</label>
							<form:input class="form-control" path="chucVu"
								placeholder="chức vụ" readonly="true" />
						</div>
						<div class="form-group col-sm-4">
							<label>Số điện thoại</label>
							<form:input class="form-control" path="soDienThoai"
								placeholder="số điện thoại" readonly="true" />
						</div>
						<div class="form-group col-sm-4">
							<label>Users</label>
							<form:input class="form-control" path="users"
								placeholder="tài khoản" readonly="true" />
						</div>

						<div class="form-group col-sm-3">
							<label>Mật khẩu</label>
							<form:input class="form-control" path="matKhau"
								placeholder="matKhau" readonly="true" />
						</div>

						<div class="form-group col-sm-4">
							<label style="margin-right: 10px;">Giới tính: </label>${nhanVien.gioiTinh}
						</div>

						<div class="col-sm-12 text-center">
							<a class="btn btn-info"
								href="<c:url value='/Admin/QuanLyDuLieu/NhanVien' />">Quay
								lại </a>
						</div>
					</form:form>
				</div>
			</div>
		</div>
	</div>
</div>

<jsp:include page="/WEB-INF/jsp/admin/templates/footer.jsp" />