
<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
   	pageContext.setAttribute("path",path);
   	pageContext.setAttribute("basePath",basePath);
%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html >
  
  <head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>首页</title>
    <meta name="description" content="Latest updates and statistic charts">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">  
    <script type="text/javascript" async="" src="index/analytics.js"></script>
    <link href="index/font-awesome.min.css" rel="stylesheet" type="text/css">
    <link href="index/fullcalendar.bundle.css" rel="stylesheet" type="text/css">
    <link href="index/vendors.bundle.css" rel="stylesheet" type="text/css">
    <link href="index/style.bundle.css" rel="stylesheet" type="text/css">
    <link href="index/light.css" rel="stylesheet" type="text/css">
    <link href="index/light(1).css" rel="stylesheet" type="text/css">
    <link href="index/navy.css" rel="stylesheet" type="text/css">
    <link href="index/navy(1).css" rel="stylesheet" type="text/css">
    <link rel="shortcut icon" href="#">
    <style type="text/css">iframe#_hjRemoteVarsFrame {display: none !important; width: 1px !important; height: 1px !important; opacity: 0 !important; pointer-events: none !important;}</style>
    <style type="text/css">span.im-caret { -webkit-animation: 1s blink step-end infinite; animation: 1s blink step-end infinite; } @keyframes blink { from, to { border-right-color: black; } 50% { border-right-color: transparent; } } @-webkit-keyframes blink { from, to { border-right-color: black; } 50% { border-right-color: transparent; } } span.im-static { color: grey; } div.im-colormask { display: inline-block; border-style: inset; border-width: 2px; -webkit-appearance: textfield; -moz-appearance: textfield; appearance: textfield; } div.im-colormask > input { position: absolute; display: inline-block; background-color: transparent; color: transparent; -webkit-appearance: caret; -moz-appearance: caret; appearance: caret; border-style: none; left: 0; /*calculated*/ } div.im-colormask > input:focus { outline: none; } div.im-colormask > input::-moz-selection{ background: none; } div.im-colormask > input::selection{ background: none; } div.im-colormask > input::-moz-selection{ background: none; } div.im-colormask > div { color: black; display: inline-block; width: 100px; /*calculated*/ }</style>
    <style>
    	.help-span {
	display: inline-block;
	margin-left: 2px;
	cursor: pointer;
}
.help-span-arrow {
	width: 0;
	height: 0;
	font-size: 0;
	border: solid 10px;
	border-color: transparent transparent #ffffff transparent;
	z-index: 1003;
	position: absolute;
	margin-top: -11px;
	margin-left: 65px;
}
.help-span-arrow-border {
	width: 0;
	height: 0;
	font-size: 0;
	border: solid 11px;
	border-color: transparent transparent #e7e7eb transparent;
	z-index: 1002;
	position: absolute;
	margin-top: -14px;
	margin-left: 64px;
}
.help-span-content {
	width: 170px;
	height: 80px;
	font-family: "Helvetica Neue","Hiragino Sans GB","Microsoft YaHei","\5FAE\8F6F\96C5\9ED1",Arial,sans-serif;
	font-size: 14px;
	color:#222222;
	text-align:center;
	padding-top: 20px;
	padding-bottom: 20px;
	border: 1px solid #e7e7eb;
	background-color: #ffffff;
	z-index: 1001;
	position: absolute;
	word-wrap:break-word; 
	word-break: normal; 
	margin-top: 8px;
	margin-left: -50px;
}
.header-text{
			/**width:42px;**/
			height:25px;
			font-size:20px;
			font-family:PingFangSC-Medium;
			font-weight:500;
			color:rgba(0,0,0,0.85);
			line-height:32px;
			letter-spacing:1px;
		}
</style>
</head>
  <script type="text/javascript">
	var basePath = "${basePath}";
	var checkindexs = 0;
	var userJsoinString = <%=session.getAttribute("userJsoinString")%>;
	console.log(userJsoinString);
</script>
  <body class="k-header--fixed k-header-mobile--fixed k-aside--enabled k-aside--fixed" style="">
    <%@include file="common/menuLogo.jsp" %>
    <div class="k-grid k-grid--hor k-grid--root">
      <div class="k-grid__item k-grid__item--fluid k-grid k-grid--ver k-page">
        <button class="k-aside-close " id="k_aside_close_btn">
          <i class="la la-close"></i>
        </button>
        <div class="k-aside  k-aside--fixed  k-grid__item k-grid k-grid--desktop k-grid--hor-desktop" id="k_aside">
          <div class="k-aside__brand k-grid__item " id="k_aside_brand" k-hidden-height="75" style="">
            <div class="k-aside__brand-logo">
              <a href="#">
                <img alt="Logo" src="index/logo-6.png"></a>
            </div>
            <div class="k-aside__brand-tools">
              <button class="k-aside__brand-aside-toggler k-aside__brand-aside-toggler--left" id="k_aside_toggler">
                <span></span>
              </button>
            </div>
          </div>
          <%@include file="common/menu.jsp" %>
          
        
        </div>
        <!-- end:: Aside -->
        <div class="k-grid__item k-grid__item--fluid k-grid k-grid--hor k-wrapper" id="k_wrapper">
          <!-- begin:: Header -->
          <%@include file="common/head.jsp" %>
          <!-- end:: Header -->
          <!-- begin:: Content -->
          <div  class="k-content k-grid__item k-grid__item--fluid k-grid k-grid--hor" id="k_content">
            <!-- begin:: Content Head -->
           <div id="breadCrumb">
           	
           </div>
            
            <div class="k-content__body k-grid__item k-grid__item--fluid" id="k_content_body">
             	<iframe style="width:100%;height:100%;;border: none;" id="htmlContent" src="">
             	<!-- 
             	<iframe name="mainFrame" style="width:100%;height:700px;border: none;" id="htmlContent" src="">
             	 -->
             	</iframe>
            </div>
            
            
            <!-- 模态框 -->
			<div class="modal modal_align fade" id="openModal" tabindex="-1" role="dialog" aria-hidden="true" style="display: none;">
				<div class="modal-dialog">
					<div class="modal-content">
						<div class="modal-header">
							<span id="openModalHeader" class="header-text"></span>
							<span type="help" class="help-span" id="title-help" style="display: none;position: relative;top: -2px;"></span>
							<span id="openModalCloseBtn" style="opacity:1;" aria-hidden="true" onclick="closeModal('')"><img id="openModalCloseImg" src="<%=basePath%>images/bt_guanbi01.png"></img></span>
						</div>
						<div class="modal-body">
							 <iframe id="openFrame" name="openFrame" scrolling="auto" style="width:100%; height:100%;" frameborder="0" ></iframe>
						</div>
					</div>
				</div>
			</div>
			
			<!-- 模态框2 -->
			<div class="modal modal_align fade" id="openModal2" tabindex="-1" role="dialog" aria-hidden="true" style="display: none;">
				<div class="modal-dialog">
					<div class="modal-content">
						<div class="modal-header">
							<span id="openModalHeader2" class="header-text"></span>
							<span type="help" class="help-span" id="title-help2" style="display: none;position: relative;top: -2px;"></span>
							<span id="openModalCloseBtn" style="opacity:1;" aria-hidden="true" onclick="closeModal('2')"><img id="openModalCloseImg2" src="<%=basePath%>images/bt_guanbi01.png"></img></span>
						</div>
						<div class="modal-body">
							 <iframe id="openFrame2" name="openFrame2" scrolling="auto" style="width:100%; height:100%;" frameborder="0" ></iframe>
						</div>
					</div>
				</div>
			</div>
			<!-- 模态框3 -->
			<div class="modal modal_align fade" id="openModal3" tabindex="-1" role="dialog" aria-hidden="true" style="display: none;">
				<div class="modal-dialog">
					<div class="modal-content">
						<div class="modal-header">
							<span id="openModalHeader3" class="header-text"></span>
							<span type="help" class="help-span" id="title-help3" style="display: none;position: relative;top: -2px;"></span>
							<span id="openModalCloseBtn" style="opacity:1;" aria-hidden="true" onclick="closeModal('3')"><img id="openModalCloseImg3" src="<%=basePath%>images/bt_guanbi01.png"></img></span>
						</div>
						<div class="modal-body">
							 <iframe id="openFrame3" name="openFrame3" scrolling="auto" style="width:100%; height:100%;overflow-y:scroll;" frameborder="0" ></iframe>
						</div>
					</div>
				</div>
			</div>
			<!-- 模态框4 -->
			<div class="modal modal_align fade" id="openModal4" tabindex="-1" role="dialog" aria-hidden="true" style="display: none;">
				<div class="modal-dialog">
					<div class="modal-content">
						<div class="modal-header">
							<span id="openModalHeader4" class="header-text"></span>
							<span type="help" class="help-span" id="title-help4" style="display: none;position: relative;top: -2px;"></span>
							<span id="openModalCloseBtn" style="opacity:1;" aria-hidden="true" onclick="closeModal('4')"><img id="openModalCloseImg4" src="<%=basePath%>images/bt_guanbi01.png"></img></span>
						</div>
						<div class="modal-body">
							 <iframe id="openFrame4" name="openFrame4" scrolling="auto" style="width:100%; height:100%;overflow-y:scroll;" frameborder="0" ></iframe>
						</div>
					</div>
				</div>
			</div>
			<form id="modalForm" name="modalForm" action="" method="post" style="display: none;">
			</form>
          </div>
          </div>
      </div>
    </div>
 
    <div id="k_scrolltop" class="k-scrolltop">
      <i class="la la-arrow-up"></i>
    </div>
    <script>var KAppOptions = {
        "colors": {
          "state": {
            "brand": "#5d78ff",
            "metal": "#c4c5d6",
            "light": "#ffffff",
            "accent": "#00c5dc",
            "primary": "#5867dd",
            "success": "#34bfa3",
            "info": "#36a3f7",
            "warning": "#ffb822",
            "danger": "#fd3995",
            "focus": "#9816f4"
          },
          "base": {
            "label": ["#c5cbe3", "#a1a8c3", "#3d4465", "#3e4466"],
            "shape": ["#f0f3ff", "#d9dffa", "#afb4d4", "#646c9a"]
          }
        }
      };</script>
     
    
    <script src="index/vendors.bundle.js" type="text/javascript"></script>
    <script src="page/index.js" type="text/javascript"></script>
    <div id="ads"></div>
    <!--  -->
    <script src="index/scripts.bundle.js" type="text/javascript"></script>
    
  </body>

</html>