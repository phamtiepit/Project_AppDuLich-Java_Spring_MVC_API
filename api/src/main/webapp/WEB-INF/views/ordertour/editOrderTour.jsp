<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<jsp:include page="/WEB-INF/views/header.jsp">
        <jsp:param name="title" value="Cập nhật đặt tour" />
    </jsp:include>
<body class="hold-transition sidebar-mini layout-fixed">

    <%@include file="/WEB-INF/views/menubar.jsp" %>
    
    <div class="content-wrapper">
    <!-- Content Header (Page header) -->
    <section class="content-header">
      <div class="container-fluid">
        <div class="row mb-2">
          <div class="col-sm-6">
            <h1>Cập nhật đặt tour</h1>
          </div>
          <div class="col-sm-6">
            <ol class="breadcrumb float-sm-right">
              <li class="breadcrumb-item"><a href="#">Home</a></li>
              <li class="breadcrumb-item active">Cập nhật đặt tour</li>
            </ol>
          </div>
        </div>
      </div><!-- /.container-fluid -->
    </section>

    <!-- Main content -->
    <section class="content">
      <div class="container-fluid">
        <div class="row">
          <div class="col-12">
			 <div class="card card-primary">
              <!-- form start -->
              <form:form modelAttribute="ordertourDTO" method="post" action="${pageContext.request.contextPath}/admin/ordertour/process-edit">
                <div class="card-body">
                  <input type="hidden" name="id" value="${ordertourDTO.id}">
                  <div class="form-group">
                    <label>Họ tên</label>
                    <input type="text" class="form-control" name="hoten" value="${ordertourDTO.hoten}">
                  </div>
                  <div class="form-group">
                    <label>Số điện thoại</label>
                    <input type="text" class="form-control" name="phone" value="${ordertourDTO.phone}">
                  </div>
                  <div class="form-group">
                    <label>Địa chỉ</label>
                    <input type="text" class="form-control" name="diachi" value="${ordertourDTO.diachi}">
                  </div>
                  <div class="form-group">
                    <label>Email</label>
                    <input type="text" class="form-control" name="email" value="${ordertourDTO.email}">
                  </div>
                  <div class="form-group">
                    <label>Tour</label>
                    <input type="text" class="form-control" name="tourid" value="${ordertourDTO.tourid}">
                  </div>
                  <div class="form-group">
	                  <label>Trang thái</label>
	                  <select class="form-control" name="status">
	                    <option selected="selected" value="0">Đang xử lí</option>
		                <option value="1">Đã hoàn thành</option>
	                  </select>
                  </div>              
                </div>
                <!-- /.card-body -->

                <div class="card-footer">
                  <button type="submit" class="btn btn-primary">Cập nhật</button>
                </div>
              </form:form>
            </div>
          </div>
          <!-- /.col -->
        </div>
        <!-- /.row -->
      </div>
      <!-- /.container-fluid -->
    </section>
    <!-- /.content -->
  </div>
  <%@include file="/WEB-INF/views/footer.jsp" %>
<script src="<c:url value="/resources/assets/plugins/jquery/jquery.min.js" />"></script>
<!-- Bootstrap 4 -->
<script src="<c:url value="/resources/assets/plugins/bootstrap/js/bootstrap.bundle.min.js" />"></script>
<!-- bs-custom-file-input -->
<script src="<c:url value="/resources/assets/plugins/bs-custom-file-input/bs-custom-file-input.min.js" />"></script>
<!-- AdminLTE App -->
<script src="<c:url value="/resources/assets/dist/js/adminlte.min.js" />"></script>
<!-- AdminLTE for demo purposes -->
<script src="<c:url value="/resources/assets/dist/js/demo.js" />"></script>
<!-- Page specific script -->
<script>
$(function () {
	  bsCustomFileInput.init();
	});
</script>
</body>
</html>