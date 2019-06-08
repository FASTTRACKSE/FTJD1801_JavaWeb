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
				<c:if test="${edit eq false}">
					<h3 class="content-header-title mb-0">Thêm mới nhân viên</h3>
				<div class="row breadcrumbs-top">
					<div class="breadcrumb-wrapper col-xs-20">
						<ol class="breadcrumb">
							<li class="breadcrumb-item"><a
								href='<c:url value="/Admin" />'>Trang chủ</a></li>
							<li class="breadcrumb-item"><a
								href='<c:url value="/Admin/QuanLyDuLieu/NhanVien" />'>Danh
									sách nhân viên</a></li>
							<li class="breadcrumb-item active">Thêm mới nhân viên</li>
						</ol>
					</div>
				</div>
				</c:if>
				<c:if test="${edit eq true}">
					<h3 class="content-header-title mb-0">Cập nhật thông tin nhân viên</h3>
				<div class="row breadcrumbs-top">
					<div class="breadcrumb-wrapper col-xs-25">
						<ol class="breadcrumb">
							<li class="breadcrumb-item"><a
								href='<c:url value="/Admin" />'>Trang chủ</a></li>
							<li class="breadcrumb-item"><a
								href='<c:url value="/Admin/QuanLyDuLieu/NhanVien" />'>Danh
									sách nhân viên</a></li>
							<li class="breadcrumb-item active">Cập nhật thông tin nhân viên</li>
						</ol>
					</div>
				</div>
				</c:if>
				
			</div>
		</div>
		<!-- End Path -->

		<div class="content-body">
			<div class="main-content">
				<div class="row">
					<form:form method="POST" enctype="multipart/form-data"
						modelAttribute="nhanVien" action="">
						<form:input type="hidden" path="maNhanVien" id="maNhanVien"
							name="maNhanVien" />
						<div class="form-group col-sm-4">
							<label>Tên nhân viên</label>
							<form:input class="form-control" path="tenNhanVien"
								id="tenNhanVien" name="tenNhanVien" placeholder="tên nhân viên"
								required="required" />
						</div>
						<div class="form-group col-sm-3">
							<label>Chức vụ</label>
							<form:input class="form-control" path="chucVu" id="chucVu"
								name="chucVu" placeholder="chức vụ" required="required" />
						</div>
						<div class="form-group col-sm-4">
							<label>Số điện thoại</label>
							<form:input class="form-control" path="soDienThoai"
								id="soDienThoai" name="soDienThoai" placeholder="số điện thoại"
								required="required" />
							<form:errors path="soDienThoai" cssClass="error" />
						</div>
						<div class="form-group col-sm-4">
							<label>Users</label>
							<form:input class="form-control" path="users" id="users"
								name="users" placeholder="tài khoản" required="required" />
						</div>

						<div class="form-group col-sm-3">
							<label>Mật khẩu</label>
							<form:input class="form-control" path="matKhau" id="matKhau"
								name="matKhau" placeholder="matKhau" required="required" />
						</div>

						<div class="form-group col-sm-4">
							<label style="margin-right: 10px;">Giới tính: </label><br>
							<form:radiobutton path="gioiTinh" value="Nam" />
							Nam
							<form:radiobutton path="gioiTinh" value="Nữ" />
							Nữ
							<form:radiobutton path="gioiTinh" value="Khác" />
							Giới tính thứ 3
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
			</div>
		</div>
	</div>
</div>

<jsp:include page="/WEB-INF/jsp/admin/templates/footer.jsp" />