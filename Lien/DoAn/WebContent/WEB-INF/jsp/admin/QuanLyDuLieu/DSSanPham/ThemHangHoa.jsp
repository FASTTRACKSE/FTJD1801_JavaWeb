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
				<h3 class="content-header-title mb-0">Thêm mới hàng hóa</h3>
				<div class="row breadcrumbs-top">
					<div class="breadcrumb-wrapper col-xs-12">
						<ol class="breadcrumb">
							<li class="breadcrumb-item"><a
								href='<c:url value="/Admin" />'>Trang chủ</a></li>
							<li class="breadcrumb-item"><a
								href='<c:url value="/Admin/QuanLyDuLieu/HangHoa" />'>Danh
									sách hàng hóa</a></li>
							<li class="breadcrumb-item active">Thêm mới hàng hóa</li>
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
						modelAttribute="hangHoa" action="">
						<form:input type="hidden" path="maHang" id="maHang" />
						<div class="form-group col-sm-4">
							<label>Tên sản phẩm</label>
							<form:input class="form-control" path="tenHang"
								placeholder="tên sản phẩm" />
						</div>
						<div class="form-group col-sm-3">
							<label>Đơn giá</label>
							<form:input class="form-control" path="donGia"
								placeholder="0 VNĐ" />
						</div>
						<div class="form-group col-sm-3">
							<label>Đơn vị tính</label>
							<form:input class="form-control" path="donViTinh"
								placeholder="Đơn vị tính" />
						</div>
						<div class="form-group col-sm-3">
							<label>Số lượng</label>
							<form:input class="form-control" path="soLuong" placeholder="0" />
							<br>
						</div>
						<div class="form-group col-sm-3">
							<label>Nhóm hàng</label> <select class="form-control" id="nhomHang" name="nhomHang">
								<c:forEach var="tempNhomHang" items="${nhomHang}">
									<option value="${tempNhomHang.maNhom}">${tempNhomHang.tenNhom}</option>
								</c:forEach>
							</select>
						</div>
						<div class="form-group col-sm-4">
							<label>Hình ảnh</label> <input type="file" name="file"
								id="stuClass" class="btn btn-primary" />
							<form:errors path="file" cssClass="error" />
						</div>
						<div class="form-group col-sm-12">
							<label>Thông tin</label>
							<form:textarea class="form-control" path="thongTin"
								placeholder="Thông tin" />
						</div>

						<div class="form-group col-sm-12">
							<label>Nguồn gốc</label>
							<form:textarea class="form-control" path="nguonGoc"
								placeholder="Nguồn gốc" />
						</div>						
						<div class="col-sm-12 text-center">
							<button type="submit" class="btn btn-success">Lưu</button>
						</div>
					</form:form>
				</div>
			</div>
		</div>
	</div>
</div>

<jsp:include page="/WEB-INF/jsp/admin/templates/footer.jsp" />