<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<jsp:include page="/WEB-INF/views/header.jsp">
        <jsp:param name="title" value="Quản lí danh mục" />
    </jsp:include>
<body class="hold-transition sidebar-mini layout-fixed">

    <%@include file="/WEB-INF/views/menubar.jsp" %>
    
    <div class="content-wrapper">
    <!-- Content Header (Page header) -->
    <section class="content-header">
      <div class="container-fluid">
        <div class="row mb-2">
          <div class="col-sm-6">
            <h1>Quản lí danh mục</h1>
          </div>
          <div class="col-sm-6">
            <ol class="breadcrumb float-sm-right">
              <li class="breadcrumb-item"><a href="#">Home</a></li>
              <li class="breadcrumb-item active">Quản lí danh mục</li>
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
            <div class="card">
              <div class="card-header">
                <h3 class="card-title">Danh sách danh mục</h3>
                <a class="btn btn-info float-right" href="add"><i class="fas fa-plus"></i> Thêm danh mục</a>
              </div>
              <!-- /.card-header -->
              <div class="card-body">
                <table id="example1" class="table table-bordered table-striped">
                  <thead>
                  <tr>
                    <th>ID</th>
                    <th>Tên danh mục</th>
                    <th>Mô tả</th>
                    <th>Hình ảnh</th>
                    <th>Thao tác</th>
                  </tr>
                  </thead>
                  <tbody>
                  <c:set var="list" value="${requestScope.listCategory}" />
			        <c:forEach var="category" items="${list}">
			             <tr>
		                    <td>${category.id}</td>
		                    <td>${category.categoryname}</td>
		                    <td>${category.descriptions}</td>
		                    <td>${category.images}</td>
		                    <td class="text-right">
	                          <a class="btn btn-info btn-sm" href="edit/${category.id}">
	                              <i class="fas fa-pencil-alt"></i>
	                              Sửa
	                          </a>
	                          <a class="btn btn-danger btn-sm" href="delete/${category.id}">
	                              <i class="fas fa-trash"></i>
	                              Xóa
	                          </a>
                      		</td>                  
                  		</tr>	
			        </c:forEach>
                  </tbody>
                  <tfoot>
                  <tr>
                    <th>ID</th>
                    <th>Tên danh mục</th>
                    <th>Mô tả</th>
                    <th>Hình ảnh</th>
                    <th>Thao tác</th>
                  </tr>
                  </tfoot>
                </table>
              </div>
              <!-- /.card-body -->
            </div>
            <!-- /.card -->
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
<!-- DataTables  & Plugins -->
<script src="<c:url value="/resources/assets/plugins/datatables/jquery.dataTables.min.js" />"></script>
<script src="<c:url value="/resources/assets/plugins/datatables-bs4/js/dataTables.bootstrap4.min.js" />"></script>
<script src="<c:url value="/resources/assets/plugins/datatables-responsive/js/dataTables.responsive.min.js" />"></script>
<script src="<c:url value="/resources/assets/plugins/datatables-responsive/js/responsive.bootstrap4.min.js" />"></script>
<script src="<c:url value="/resources/assets/plugins/datatables-buttons/js/dataTables.buttons.min.js" />"></script>
<script src="<c:url value="/resources/assets/plugins/datatables-buttons/js/buttons.bootstrap4.min.js" />"></script>
<script src="<c:url value="/resources/assets/plugins/jszip/jszip.min.js" />"></script>
<script src="<c:url value="/resources/assets/plugins/pdfmake/pdfmake.min.js" />"></script>
<script src="<c:url value="/resources/assets/plugins/pdfmake/vfs_fonts.js" />"></script>
<script src="<c:url value="/resources/assets/plugins/datatables-buttons/js/buttons.html5.min.js" />"></script>
<script src="<c:url value="/resources/assets/plugins/datatables-buttons/js/buttons.print.min.js" />"></script>
<script src="<c:url value="/resources/assets/plugins/datatables-buttons/js/buttons.colVis.min.js" />"></script>
<!-- AdminLTE App -->
<script src="<c:url value="/resources/assets/dist/js/adminlte.min.js" />"></script>
<!-- AdminLTE for demo purposes -->
<script src="<c:url value="/resources/assets/dist/js/demo.js" />"></script>
<!-- Page specific script -->
<script>
  $(function () {
    $("#example1").DataTable({
      "responsive": true, "lengthChange": false, "autoWidth": false,
      "buttons": ["copy", "csv", "excel", "pdf", "print", "colvis"]
    }).buttons().container().appendTo('#example1_wrapper .col-md-6:eq(0)');
    $('#example2').DataTable({
      "paging": true,
      "lengthChange": false,
      "searching": false,
      "ordering": true,
      "info": true,
      "autoWidth": false,
      "responsive": true,
    });
  });
</script>
</body>
</html>