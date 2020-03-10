<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<div id="k_header" class="k-header k-grid__item  k-header--fixed ">
  <!-- begin: Header Menu -->
  <button class="k-header-menu-wrapper-close" id="k_header_menu_mobile_close_btn">
    <i class="la la-close"></i>
  </button>
  <div class="k-header-menu-wrapper" id="k_header_menu_wrapper">
    <div id="k_header_menu" class="k-header-menu k-header-menu-mobile ">
    </div>
  </div>
  <!-- end: Header Menu -->
  <!-- begin:: Header Topbar -->
  <div class="k-header__topbar">
   
    <!--begin: User bar -->
    <div class="k-header__topbar-item k-header__topbar-item--user">
      <div class="k-header__topbar-wrapper" data-toggle="dropdown" data-offset="10px -2px">
        <div class="k-header__topbar-user">
          <span class="k-header__topbar-welcome k-hidden-mobile">你好,</span>
          <span class="k-header__topbar-username k-hidden-mobile">任志超</span>
          <img alt="Pic" src="index/300_25.jpg">
          <!--use below badge element instead the user avatar to display username's first letter(remove k-hidden class to display it) -->
          <span class="k-badge k-badge--username k-badge--lg k-badge--brand k-hidden">A</span></div>
      </div>
      <div class="dropdown-menu dropdown-menu-fit dropdown-menu-right dropdown-menu-anim dropdown-menu-top-unround dropdown-menu-md">
        <ul class="k-nav k-margin-b-10">
          <li class="k-nav__item">
            <a href="https://keenthemes.com/keen/preview/default/custom/user/profile-v1.html" class="k-nav__link">
              <span class="k-nav__link-icon">
                <i class="flaticon2-calendar-3"></i>
              </span>
              <span class="k-nav__link-text">修改密码</span></a>
          </li>

          <li class="k-nav__item k-nav__item--custom k-margin-t-15">
            <a href="https://keenthemes.com/keen/preview/default/custom/user/login-v2.html" target="_blank" class="btn btn-outline-metal btn-hover-brand btn-upper btn-font-dark btn-sm btn-bold">退出</a></li>
        </ul>
      </div>
    </div>
    <!--end: User bar -->
   </div>
  <!-- end:: Header Topbar -->
</div>