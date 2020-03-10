<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<div class="k-aside-menu-wrapper k-grid__item k-grid__item--fluid" id="k_aside_menu_wrapper">
   <div id="k_aside_menu" class="k-aside-menu k-scroll ps ps--active-y" data-kmenu-vertical="1" data-kmenu-scroll="1" data-kmenu-dropdown-timeout="500" style="height: 788px; overflow: hidden;">
     <ul class="k-menu__nav ">
       <li class="parent_li_class k-menu__item  k-menu__item--submenu k-menu__item--open k-menu__item--here " aria-haspopup="true" data-kmenu-submenu-toggle="hover">
         <a href="javascript:;" class="k-menu__link k-menu__toggle">
           <i class="k-menu__link-icon ">
           	<img style="height:16px;width:16px;" src="index/ic_dh_xtgl01@2x.png"/>
           </i>
           <span class="k-menu__link-text">系统管理</span>
           <i class="k-menu__ver-arrow ">
           	<img style="height:16px;width:16px;" src="images/select@2x.png"/>
           </i>
         </a>
         <div class="k-menu__submenu ">
           <span class="k-menu__arrow"></span>
           <ul class="k-menu__subnav">
             <li class="menu_class_click k-menu__item  k-menu__item--active" url="user/show_user_list" aria-haspopup="true">
              <a href="javascript:void(0);"  class="k-menu__link ">
                 <i class="k-menu__link-bullet k-menu__link-bullet--dot">
                   <span></span>
                 </i>
                 <span class="k-menu__link-text">用户管理</span>
              </a>
             </li>
             <li class="menu_class_click k-menu__item"  url="movie/show_movie_list" aria-haspopup="true">
               <a href="javascript:void(0);"  class="k-menu__link ">
                 <i class="k-menu__link-bullet k-menu__link-bullet--dot">
                   <span></span>
                 </i>
                 <span class="k-menu__link-text">角色管理</span></a>
             </li>
           </ul>
         </div>
       </li>
       
       <li class="k-menu__item  k-menu__item--submenu " aria-haspopup="true" data-kmenu-submenu-toggle="hover">
         <a href="javascript:;" class="k-menu__link k-menu__toggle">
           <i class="k-menu__link-icon ">
           	<img style="height:16px;width:16px;" src="index/logo_k_baibiao@2x.png"/>
           </i>
           <span class="k-menu__link-text">素材管理</span>
           <i class="k-menu__ver-arrow ">
           	<img style="height:16px;width:16px;" src="images/select@2x.png"/>
           </i>
         </a>
         <div class="k-menu__submenu ">
           <span class="k-menu__arrow"></span>
           <ul class="k-menu__subnav">
             
             <li class="menu_class_click k-menu__item"  aria-haspopup="true" url="/videoSource/toList">
              <a href="javascript:void(0);"  class="k-menu__link" >
                 <i class="k-menu__link-bullet k-menu__link-bullet--dot" >
                   <span></span>
                 </i>
                 <span class="k-menu__link-text">素材库</span>
              </a>
             </li>
             
             <li class="menu_class_click k-menu__item"   aria-haspopup="true"  url="/video/toList">
              	<a href="javascript:void(0);"  class="k-menu__link">
	                 <i class="k-menu__link-bullet k-menu__link-bullet--dot">
	                   <span></span>
	                 </i>
	                 <span class="k-menu__link-text">成品库</span></a>
                 </a>
             </li>
             
             
              <li class="menu_class_click k-menu__item"   aria-haspopup="true"  url="/news/index">
              	<a href="javascript:void(0);"  class="k-menu__link">
	                 <i class="k-menu__link-bullet k-menu__link-bullet--dot">
	                   <span></span>
	                 </i>
	                 <span class="k-menu__link-text">资讯管理</span></a>
                 </a>
             </li>
             
              <li class="menu_class_clic k k-menu__item"   aria-haspopup="true"  url="/activity/index">
              	<a href="javascript:void(0);"  class="k-menu__link">
	                 <i class="k-menu__link-bullet k-menu__link-bullet--dot">
	                   <span></span>
	                 </i>
	                 <span class="k-menu__link-text">活动管理</span></a>
                 </a>
             </li>
             
             
              <li class="menu_class_click k-menu__item"   aria-haspopup="true"  url="/tag/index">
              	<a href="javascript:void(0);"  class="k-menu__link">
	                 <i class="k-menu__link-bullet k-menu__link-bullet--dot">
	                   <span></span>
	                 </i>
	                 <span class="k-menu__link-text">标签管理</span></a>
                 </a>
             </li>
             
           </ul>
         </div>
       </li>
     </ul>
     
     <div class="ps__rail-x" style="left: 0px; bottom: 0px;">
       <div class="ps__thumb-x" tabindex="0" style="left: 0px; width: 0px;"></div>
     </div>
     <div class="ps__rail-y" style="top: 0px; height: 788px; right: 2px;">
       <div class="ps__thumb-y" tabindex="0" style="top: 0px; height: 300px;"></div>
     </div>
   </div>
 </div>