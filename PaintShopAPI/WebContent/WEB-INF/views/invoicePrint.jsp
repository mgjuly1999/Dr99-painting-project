<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
  <meta charset="utf-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <title>Paint Shop | Invoice</title>
  <!-- Tell the browser to be responsive to screen width -->
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <!-- Bootstrap 4 -->

  <!-- Font Awesome -->
  <link rel="stylesheet" href="<c:url value="resources/admin/plugins/fontawesome-free/css/all.min.css"/>">
  <!-- Ionicons -->
  <link rel="stylesheet" href="<c:url value="https://code.ionicframework.com/ionicons/2.0.1/css/ionicons.min.css"/>">
  <!-- Theme style -->
  <link rel="stylesheet" href="<c:url value="resources/admin/dist/css/adminlte.min.css"/>">

  <!-- Google Font: Source Sans Pro -->
  <link href="<c:url value="https://fonts.googleapis.com/css?family=Source+Sans+Pro:300,400,400i,700"/>" rel="stylesheet">
</head>
<body>
<div class="wrapper">
  <!-- Main content -->
  <section class="invoice">




   <c:set var="orderItems" value="${invoiceDetailsForm.orderItems}"></c:set>    
   
   
    <!-- title row -->
    <div class="row">
      <div class="col-12">
        <h2 class="page-header">
          <i class="fas fa-globe"></i>Dr.99 Painting Group
          <small class="float-right">Date: ${invoiceDetailsForm.currentDate}</small>
        </h2>
      </div>
      <!-- /.col -->
    </div>
    <!-- info row -->
    
   
    
    <div class="row invoice-info">
      <div class="col-sm-4 invoice-col">
        From
        <address>
          <strong>Dr.99 Painting Group </strong><br>
         -99-Middlee Road,Oloke Quarter.Dawei<br>
          -1252-1253 Anawyahtar Road,7x8 Junction<br> 
          (5)Quater North Dagon<br>
          Phone: (09) 5177 4316<br>
          Phone: (09) 49 360 999<br>
          Email: info@dr99painting.com
        </address>
      </div>
      <!-- /.col -->
      <div class="col-sm-4 invoice-col">
        To
        <address>
          <strong>John Doe</strong><br>
          ${invoiceDetailsForm.addressDetails}<br>
          (${invoiceDetailsForm.deliveryAddress})<br>
          Phone:${invoiceDetailsForm.phone}<br>
         
        </address>
      </div>
      <!-- /.col -->
      <div class="col-sm-4 invoice-col">
        <b>Invoice #00${invoiceDetailsForm.orderFormId}</b><br>
        <br>
        <b>Order ID :</b> 032${invoiceDetailsForm.orderFormId}<br>
        <b>Payment Due :</b>${invoiceDetailsForm.paymentDue}<br>
       	<b>Order Type :</b>${invoiceDetailsForm.deliveryType}
      </div>
      <!-- /.col -->
    </div>
    <!-- /.row -->

    <!-- Table row -->
    <div class="row">
      <div class="col-12 table-responsive">
        <table class="table table-striped">
          <thead>
          <tr>
           	<th>No</th>
            <th>Product</th>
            <th>Color</th>
            <th>Qty</th>
            <th>Unit price</th>
            <th>Subtotal</th>
          </tr>
          </thead>
          <tbody>
        <c:forEach var="orderItem" items="${orderItems}" varStatus="s">
          <tr>

			<th>${s.index+1}</th>
          	<th>
          	${orderItem.productName}
          	${orderItem.litreage}
          	</th>
            <th>${orderItem.color}</th>
            <th>${orderItem.qty}</th>
            <th>${orderItem.unitPrice} mmk</th>
            <th>${orderItem.subTotal} mmk</th>
              
          </tr>
       </c:forEach>
          </tbody>
        </table>
      </div>
      <!-- /.col -->
    </div>
    <!-- /.row -->

    <div class="row">
      <!-- accepted payments column -->
      <div class="col-6">
        <p class="lead">Payment Methods:</p>
        <img src="<c:url value="resources/admin/dist/img/credit/visa.png"/>" alt="Visa">
        <img src="<c:url value="resources/admin/dist/img/credit/mastercard.png"/>" alt="Mastercard">
        <img src="<c:url value="resources/admin/dist/img/credit/american-express.png"/>" alt="American Express">
        <img src="<c:url value="resources/admin/dist/img/credit/paypal2.png"/>" alt="Paypal">

        <p class="text-muted well well-sm shadow-none" style="margin-top: 10px;">
          Online Banking Service များကို အသုံးပြု၍လည်းငွေ ပေးချေနိုင်ပါသည်။
        </p>
      </div>
      <!-- /.col -->
      <div class="col-6">
        <p class="lead">Amount Due : ${invoiceDetailsForm.currentDate}</p>
        <div class="table-responsive">
          <table class="table">
            <tr>
              <th style="width:50%">Subtotal:</th>
              <td>${invoiceDetailsForm.totalPrice} mmk</td>
            </tr>
             <tr>
              <th style="width:50%">Total Discount Rate:</th>
              <td>${invoiceDetailsForm.totalDicountRate}%</td>
            </tr>
            
            <tr>
              <th>Tax (0.0%)</th>
              <td>0.0 %</td>
            </tr>
            <tr>
              <th>Shipping:</th>
              <td>Free (${invoiceDetailsForm.deliveryAddress})</td>
            </tr>
            <tr>
              <th>Total:</th>
              <td>${invoiceDetailsForm.totalPrice} mmk (${invoiceDetailsForm.orderStatus})</td>
            </tr>
          </table>
        </div>
      </div>
      <!-- /.col -->
    </div>
    <!-- /.row -->
  </section>
  <!-- /.content -->
</div>
<!-- ./wrapper -->

<script type="text/javascript"> 
  window.addEventListener("load", window.print());
</script>
</body>
</html>
