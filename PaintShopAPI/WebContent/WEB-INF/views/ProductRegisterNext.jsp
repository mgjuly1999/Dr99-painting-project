<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
  <meta charset="utf-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <title>Selelct Product Data</title>
  <!-- Tell the browser to be responsive to screen width -->
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <!-- Font Awesome -->
  <link rel="stylesheet" href="<c:url value="resources/admin/plugins/fontawesome-free/css/all.min.css"/>">
  <!-- Ionicons -->
  <link rel="stylesheet" href="<c:url value="https://code.ionicframework.com/ionicons/2.0.1/css/ionicons.min.css"/>">
  <!-- Tempusdominus Bbootstrap 4 -->
  <link rel="stylesheet" href="<c:url value="resources/admin/plugins/tempusdominus-bootstrap-4/css/tempusdominus-bootstrap-4.min.css"/>">
  <!-- iCheck -->
  <link rel="stylesheet" href="<c:url value="resources/admin/plugins/icheck-bootstrap/icheck-bootstrap.min.css"/>">
  <!-- JQVMap -->
  <link rel="stylesheet" href="<c:url value="resources/admin/plugins/jqvmap/jqvmap.min.css"/>">
  <!-- Theme style -->
  <link rel="stylesheet" href="<c:url value="resources/admin/dist/css/adminlte.min.css"/>">
  <!-- overlayScrollbars -->
  <link rel="stylesheet" href="<c:url value="resources/admin/plugins/overlayScrollbars/css/OverlayScrollbars.min.css"/>">
  <!-- Daterange picker -->
  <link rel="stylesheet" href="<c:url value="resources/admin/plugins/daterangepicker/daterangepicker.css"/>">
  <!-- summernote -->
  <link rel="stylesheet" href="<c:url value="resources/admin/plugins/summernote/summernote-bs4.css"/>">
  <!-- Google Font: Source Sans Pro -->
  <link href="https://fonts.googleapis.com/css?family=Source+Sans+Pro:300,400,400i,700" rel="stylesheet">
</head>
<body class="hold-transition sidebar-mini layout-fixed">
<div class="wrapper">

<%@ include file="/resources/admin/headerAndSlideBar/HeaderAndMainSlider.jsp" %>
  <div class="content-wrapper">
  <section class="content">
    <!-- Content Header (Page header) -->
    <section class="content-header">
      <div class="container-fluid">
        <div class="row mb-2">
          <div class="col">
            <h1>Selelct Product Data</h1>
           </div>
          <div class="col-sm-6">
            <ol class="breadcrumb float-sm-right">
              <li class="breadcrumb-item"><a href="#">Admin Home</a></li>
              <li class="breadcrumb-item active">Selelct Product Data</li>
            </ol>
          </div>
        </div>
      </div><!-- /.container-fluid -->
    </section>
            <section class="content">
      <div class="row">
    
	
	 <form:form action="productRegisterNextSubmit" modelAttribute="productNextForm" method="POST" enctype="multipart/form-data" >
          	
        <form:input type="text" id="productId" path="productId" 
        name="productId" value="${productRegisterNextForm.product.productId}"  hidden="hidden"/>
              
        <div class="col-15">
           <div class="card card-success">
                <div class="card-header">
                <h3 class="card-title">Select Product Feature</h3>
              </div>
        <div class="card-body">
              <table id="example1" class="table table-bordered table-striped">
                <thead>
                <tr>
			<th>No</th>
			<th>Name</th>
			<th>Select</th>
			
		        </tr>
                </thead>
                <tbody>
                <c:forEach var="featureLanguage" items="${productRegisterNextForm.featureLanguages}" varStatus="s">
			<tr>
				<td>${s.index+1}</td>
			    <td>${featureLanguage.featureName}</td>
			    <th>
			    <form:checkbox path="features" 
			    value="${featureLanguage.id.featureId}"/>
			    </th>
			</tr>		
		    </c:forEach>
              
                </tbody>
                <tfoot>
                 </tfoot>
              </table>
            </div>
            <!-- /.card-body -->
          </div>
          <!-- /.card -->
        </div>
        <!-- /.col -->
      
          <div class="col-15">
           <div class="card card-success">
                <div class="card-header">
                <h3 class="card-title">Select Product Tools</h3>
              </div>
        <div class="card-body">
              <table id="example1" class="table table-bordered table-striped">
                <thead>
                <tr>
			<th>No</th>
			<th>Name</th>
			<th>Select</th>
			
		        </tr>
                </thead>
                <tbody>
                <c:forEach var="toolLanguage" items="${productRegisterNextForm.toolLanguages}" varStatus="s">
			<tr>
				<td>${s.index+1}</td>
			    <td>${toolLanguage.toolName}</td>
			  
			    <th>
			    <form:checkbox path="tools" 
			    value="${toolLanguage.id.toolId}"/>
			    </th>
			</tr>		
		    </c:forEach>
              
                </tbody>
                <tfoot>
                 </tfoot>
              </table>
            </div>
            <!-- /.card-body -->
          </div>
          <!-- /.card -->
        </div>
        <!-- /.col -->
      
	
        <div class="col-15">
           <div class="card card-success">
                <div class="card-header">
                <h3 class="card-title">Select Product Guide</h3>
              </div>
        <div class="card-body">
              <table id="example1" class="table table-bordered table-striped">
                <thead>
                <tr>
			<th>No</th>
			<th>Name</th>
			<th>Select</th>
			
		        </tr>
                </thead>
                <tbody>
                <c:forEach var="guideLanguage" items="${productRegisterNextForm.guideLanguages}" varStatus="s">
			<tr>
				<td>${s.index+1}</td>
			    <td>${guideLanguage.guideType}</td>
			    <td>${guideLanguage.guideValue}</td>
			    <th> <form:checkbox path="guides" 
			    value="${guideLanguage.id.guideId}"/>
			    </th>
			</tr>		
		    </c:forEach>
              
                </tbody>
                <tfoot>
                 </tfoot>
              </table>
            </div>
            <!-- /.card-body -->
          </div>
          <!-- /.card -->
        </div>
        <!-- /.col -->
      </form:form>
      
      </div>
      <!-- /.row -->
    </section>
    <!-- /.content -->
    </section>
  </div>
  <!-- /.content-wrapper -->
<!-- /.content-wrapper -->
  <%@ include file="/resources/admin/footer/AdminFooter.jsp" %>

  <!-- Control Sidebar -->
  <aside class="control-sidebar control-sidebar-dark">
    <!-- Control sidebar content goes here -->
  </aside>
  <!-- /.control-sidebar -->
</div>
<!-- ./wrapper -->

<!-- jQuery -->
<script src="<c:url value="resources/admin/plugins/jquery/jquery.min.js"/>"></script>
<!-- jQuery UI 1.11.4 -->
<script src="<c:url value="resources/admin/plugins/jquery-ui/jquery-ui.min.js"/>"></script>
<!-- Resolve conflict in jQuery UI tooltip with Bootstrap tooltip -->
<script>
  $.widget.bridge('uibutton', $.ui.button)
</script>
<!-- Bootstrap 4 -->
<script src="<c:url value="resources/admin/plugins/bootstrap/js/bootstrap.bundle.min.js"/>"></script>
<!-- ChartJS -->
<script src="<c:url value="resources/admin/plugins/chart.js/Chart.min.js"/>"></script>
<!-- Sparkline -->
<script src="<c:url value="resources/admin/plugins/sparklines/sparkline.js"/>"></script>
<!-- JQVMap -->
<script src="<c:url value="resources/admin/plugins/jqvmap/jquery.vmap.min.js"/>"></script>
<script src="<c:url value="resources/admin/plugins/jqvmap/maps/jquery.vmap.usa.js"/>"></script>
<!-- jQuery Knob Chart -->
<script src="<c:url value="resources/admin/plugins/jquery-knob/jquery.knob.min.js"/>"></script>
<!-- daterangepicker -->
<script src="<c:url value="resources/admin/plugins/moment/moment.min.js"/>"></script>
<script src="<c:url value="resources/admin/plugins/daterangepicker/daterangepicker.js"/>"></script>
<!-- Tempusdominus Bootstrap 4 -->
<script src="<c:url value="resources/admin/plugins/tempusdominus-bootstrap-4/js/tempusdominus-bootstrap-4.min.js"/>"></script>
<!-- Summernote -->
<script src="<c:url value="resources/admin/plugins/summernote/summernote-bs4.min.js"/>"></script>
<!-- overlayScrollbars -->
<script src="<c:url value="resources/admin/plugins/overlayScrollbars/js/jquery.overlayScrollbars.min.js"/>"></script>
<!-- AdminLTE App -->
<script src="<c:url value="resources/admin/dist/js/adminlte.js"/>"></script>
<!-- AdminLTE dashboard demo (This is only for demo purposes) -->
<script src="<c:url value="resources/admin/dist/js/pages/dashboard.js"/>"></script>
<!-- AdminLTE for demo purposes -->
<script src="<c:url value="resources/admin/dist/js/demo.js"/>"></script>
<script src="<c:url value="resources/admin/plugins/datatables/jquery.dataTables.js"/>"></script>
<script src="<c:url value="resources/admin/plugins/datatables-bs4/js/dataTables.bootstrap4.js"/>"></script>
<script>
  $(function () {
    $("#example1").DataTable();
    $('#example2').DataTable({
      "paging": true,
      "lengthChange": false,
      "searching": false,
      "ordering": true,
      "info": true,
      "autoWidth": false,
    });
  });
</script>
</body>
</html>
