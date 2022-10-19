<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>

  <!-- Navbar -->
  <nav class="main-header navbar navbar-expand navbar-white navbar-light">
    <!-- Left navbar links -->
    <ul class="navbar-nav">
      <li class="nav-item">
        <a class="nav-link" data-widget="pushmenu" href="#"><i class="fas fa-bars"></i></a>
      </li>
      <li class="nav-item d-none d-sm-inline-block">
        <a href="index3.html" class="nav-link">Home</a>
      </li>
      <li class="nav-item d-none d-sm-inline-block">
        <a href="#" class="nav-link">Contact</a>
      </li>
    </ul>

    <!-- SEARCH FORM -->
    <form class="form-inline ml-3">
      <div class="input-group input-group-sm">
        <input class="form-control form-control-navbar" type="search" placeholder="Search" aria-label="Search">
        <div class="input-group-append">
          <button class="btn btn-navbar" type="submit">
            <i class="fas fa-search"></i>
          </button>
        </div>
      </div>
    </form>

    <!-- Right navbar links -->
    <ul class="navbar-nav ml-auto">
      <!-- Messages Dropdown Menu -->
      <li class="nav-item dropdown">
        <a class="nav-link" data-toggle="dropdown" href="#">
          <i class="far fa-comments"></i>
          <span class="badge badge-danger navbar-badge">3</span>
        </a>
        <div class="dropdown-menu dropdown-menu-lg dropdown-menu-right">
          <a href="#" class="dropdown-item">
            <!-- Message Start -->
            <div class="media">
              <img src="dist/img/user1-128x128.jpg" alt="User Avatar" class="img-size-50 mr-3 img-circle">
              <div class="media-body">
                <h3 class="dropdown-item-title">
                  Brad Diesel
                  <span class="float-right text-sm text-danger"><i class="fas fa-star"></i></span>
                </h3>
                <p class="text-sm">Call me whenever you can...</p>
                <p class="text-sm text-muted"><i class="far fa-clock mr-1"></i> 4 Hours Ago</p>
              </div>
            </div>
            <!-- Message End -->
          </a>
          <div class="dropdown-divider"></div>
          <a href="#" class="dropdown-item">
            <!-- Message Start -->
            <div class="media">
              <img src="dist/img/user8-128x128.jpg" alt="User Avatar" class="img-size-50 img-circle mr-3">
              <div class="media-body">
                <h3 class="dropdown-item-title">
                  John Pierce
                  <span class="float-right text-sm text-muted"><i class="fas fa-star"></i></span>
                </h3>
                <p class="text-sm">I got your message bro</p>
                <p class="text-sm text-muted"><i class="far fa-clock mr-1"></i> 4 Hours Ago</p>
              </div>
            </div>
            <!-- Message End -->
          </a>
          <div class="dropdown-divider"></div>
          <a href="#" class="dropdown-item">
            <!-- Message Start -->
            <div class="media">
              <img src="dist/img/user3-128x128.jpg" alt="User Avatar" class="img-size-50 img-circle mr-3">
              <div class="media-body">
                <h3 class="dropdown-item-title">
                  Nora Silvester
                  <span class="float-right text-sm text-warning"><i class="fas fa-star"></i></span>
                </h3>
                <p class="text-sm">The subject goes here</p>
                <p class="text-sm text-muted"><i class="far fa-clock mr-1"></i> 4 Hours Ago</p>
              </div>
            </div>
            <!-- Message End -->
          </a>
          <div class="dropdown-divider"></div>
          <a href="#" class="dropdown-item dropdown-footer">See All Messages</a>
        </div>
      </li>
      <!-- Notifications Dropdown Menu -->
      <li class="nav-item dropdown">
        <a class="nav-link" data-toggle="dropdown" href="#">
          <i class="far fa-bell"></i>
          <span class="badge badge-warning navbar-badge">15</span>
        </a>
        <div class="dropdown-menu dropdown-menu-lg dropdown-menu-right">
          <span class="dropdown-item dropdown-header">15 Notifications</span>
          <div class="dropdown-divider"></div>
          <a href="#" class="dropdown-item">
            <i class="fas fa-envelope mr-2"></i> 4 new messages
            <span class="float-right text-muted text-sm">3 mins</span>
          </a>
          <div class="dropdown-divider"></div>
          <a href="#" class="dropdown-item">
            <i class="fas fa-users mr-2"></i> 8 friend requests
            <span class="float-right text-muted text-sm">12 hours</span>
          </a>
          <div class="dropdown-divider"></div>
          <a href="#" class="dropdown-item">
            <i class="fas fa-file mr-2"></i> 3 new reports
            <span class="float-right text-muted text-sm">2 days</span>
          </a>
          <div class="dropdown-divider"></div>
          <a href="#" class="dropdown-item dropdown-footer">See All Notifications</a>
        </div>
      </li>
      <li class="nav-item">
        <a class="nav-link" data-widget="control-sidebar" data-slide="true" href="#">
          <i class="fas fa-th-large"></i>
        </a>
      </li>
    </ul>
  </nav>
  <!-- /.navbar -->

  <!-- Main Sidebar Container -->
  <aside class="main-sidebar sidebar-dark-primary elevation-4">
    <!-- Brand Logo -->
    <a href="index3.html" class="brand-link">
      <img src="dist/img/AdminLTELogo.png" alt="AdminLTE Logo" class="brand-image img-circle elevation-3"
           style="opacity: .8">
      <span class="brand-text font-weight-light">AdminLTE 3</span>
    </a>

    <!-- Sidebar -->
    <div class="sidebar">
      <!-- Sidebar user panel (optional) -->
      <div class="user-panel mt-3 pb-3 mb-3 d-flex">
        <div class="image">
          <img src="dist/img/user2-160x160.jpg" class="img-circle elevation-2" alt="User Image">
        </div>
        <div class="info">
          <a href="#" class="d-block">Alexander Pierce</a>
        </div>
      </div>

      <!-- Sidebar Menu -->
      <nav class="mt-2">
        <ul class="nav nav-pills nav-sidebar flex-column" data-widget="treeview" role="menu" data-accordion="false">
          <!-- Add icons to the links using the .nav-icon class
               with font-awesome or any other icon font library -->
         
         
       	<li class="nav-item has-treeview">
            <a href="#" class="nav-link">
         
              <p>
              Product Register
                <i class="fas fa-angle-left right"></i>
              </p>
            </a>
           
            <ul class="nav nav-treeview">
             
              <li class="nav-item">
                <a href="productGroupRegisterPath" class="nav-link">
                  <i class="far fa-circle nav-icon"></i>
                  <p>Add New Group</p>
                </a>
              </li>
              
                <li class="nav-item">
                 <a href="productTypeRegisterPath" class="nav-link">
                  <i class="far fa-circle nav-icon"></i>
                  <p>Add New Type</p>
                </a>
                 </li>
                 <li class="nav-item">
                <a href="productQualityRegisterPath" class="nav-link">
                  <i class="far fa-circle nav-icon"></i>
                  <p>Add New Product Quality</p>
                </a>
              </li>
                <li class="nav-item">
                <a href="showAllProductGroupPath" class="nav-link">
                  <i class="far fa-circle nav-icon"></i>
                  <p>Add New Product</p>
                </a>
              </li>
              
              <li class="nav-item">
                 <a href="viewAllOrderPath" class="nav-link">
                  <i class="far fa-circle nav-icon"></i>
                  <p>View All Order</p>
                </a>
                 </li>
             
              
              <li class="nav-item">
                <a href="toolLanguageRegisterPath" class="nav-link">
                  <i class="far fa-circle nav-icon"></i>
                  <p>Add Tool</p>
                </a>
              </li>
              
               <li class="nav-item">
                <a href="featureLanguageRegisterPath" class="nav-link">
                  <i class="far fa-circle nav-icon"></i>
                  <p>Add Feature</p>
                </a>
              </li>
              
               <li class="nav-item">
                <a href="guideLanguageRegisterPath" class="nav-link">
                  <i class="far fa-circle nav-icon"></i>
                  <p>Add Guide</p>
                </a>
              </li>
               <li class="nav-item">
                <a href="showAllGroupForProductDetailPath" class="nav-link">
                  <i class="far fa-circle nav-icon"></i>
                  <p>View Products</p>
                </a>
              </li>
              <li class="nav-item">
                <a href="qtyUnitRegisterPath" class="nav-link">
                  <i class="far fa-circle nav-icon"></i>
                  <p>Add QtyUnit</p>
                </a>
              </li>
              
              <li class="nav-item">
                <a href="productStatusRegisterPath" class="nav-link">
                  <i class="far fa-circle nav-icon"></i>
                  <p>Add Status</p>
                </a>
              </li>
                  <li class="nav-item">
                <a href="languageRegisterPath" class="nav-link">
                  <i class="far fa-circle nav-icon"></i>
                  <p>Add Language</p>
                </a>
              </li>
              <li class="nav-item">
                <a href="folderRegisterPath" class="nav-link">
                  <i class="far fa-circle nav-icon"></i>
                  <p>Add New Folder</p>
                </a>
              </li>
              
               <li class="nav-item">
                <a href="verifyPhoneNumberPath" class="nav-link">
                  <i class="far fa-circle nav-icon"></i>
                  <p>Make Payment</p>
                </a>
              </li>
             
            </ul>
         
            </li>
            
              <li class="nav-item has-treeview">
            <a href="#" class="nav-link">
         
              <p>
              Color Register
                <i class="fas fa-angle-left right"></i>
              </p>
            </a>
           
            <ul class="nav nav-treeview">
             
              <li class="nav-item">
                <a href="colorGroupRegisterPath" class="nav-link">
                  <i class="far fa-circle nav-icon"></i>
                  <p>Color Group Register</p>
                </a>
              </li>
               <li class="nav-item">
                <a href="colorRegisterPath" class="nav-link">
                  <i class="far fa-circle nav-icon"></i>
                  <p>Color Register</p>
                </a>
              </li>
             
            </ul>
         
            </li>
            
             <li class="nav-item has-treeview">
            <a href="#" class="nav-link">
         
              <p>
             Personal Register
                <i class="fas fa-angle-left right"></i>
              </p>
            </a>
           
            <ul class="nav nav-treeview">
             
              <li class="nav-item">
                <a href="adminRegisterPath" class="nav-link">
                  <i class="far fa-circle nav-icon"></i>
                  <p>Add New Admin</p>
                </a>
              </li>
               <li class="nav-item">
                <a href="adminStatusRegisterPath" class="nav-link">
                  <i class="far fa-circle nav-icon"></i>
                  <p>Add New Admin Status</p>
                </a>
              </li>
             
               <li class="nav-item">
                <a href="memberRegisterPath" class="nav-link">
                  <i class="far fa-circle nav-icon"></i>
                  <p>Add New Member</p>
                </a>
              </li>
               <li class="nav-item">
                <a href="memberStatusRegisterPath" class="nav-link">
                  <i class="far fa-circle nav-icon"></i>
                  <p>Add Member Status</p>
                </a>
              </li>
              
             
            </ul>
         
            </li>
            
              <li class="nav-item has-treeview">
            <a href="#" class="nav-link">
         
              <p>
            Place Order
                <i class="fas fa-angle-left right"></i>
              </p>
            </a>
           
            <ul class="nav nav-treeview">
             
              <li class="nav-item">
                <a href="deliveryAddressRegisterPath" class="nav-link">
                  <i class="far fa-circle nav-icon"></i>
                  <p>Add Delivery Address</p>
                </a>
              </li>
              
               <li class="nav-item">
                <a href="orderStatusRegisterPath" class="nav-link">
                  <i class="far fa-circle nav-icon"></i>
                  <p>Add Order Status</p>
                </a>
              </li>
              
              <li class="nav-item">
                <a href="deliveryTypeRegisterPath" class="nav-link">
                  <i class="far fa-circle nav-icon"></i>
                  <p>Add Delivery Type</p>
                </a>
              </li>
             
               <li class="nav-item">
                <a href="paymentMethodRegisterPath" class="nav-link">
                  <i class="far fa-circle nav-icon"></i>
                  <p>Add Payment Method</p>
                </a>
              </li>
              
              <li class="nav-item">
                <a href="orderFormRegisterPath" class="nav-link">
                  <i class="far fa-circle nav-icon"></i>
                  <p>Add Order Form</p>
                </a>
              </li>
            </ul>
         
            </li>
            
        </ul>
      </nav>
      <!-- /.sidebar-menu -->
    </div>
    <!-- /.sidebar -->
  </aside>
     
   
