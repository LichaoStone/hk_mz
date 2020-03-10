<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
   	pageContext.setAttribute("path",path);
   	pageContext.setAttribute("basePath",basePath);
%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta http-equiv="keywords" content="海看媒资">
<meta http-equiv="description" content="海看媒资">
<link href="${basePath}/bootstrap/css/bootstrap.css" rel="stylesheet">
<link href="${basePath}/bootstrap/css/bootstrap-table.css" rel="stylesheet">
<link href="${basePath}/css/page_list.css" rel="stylesheet">
<link href="${basePath}/css/common.css" rel="stylesheet">
<link href="${basePath}/bootstrap/css/select2.css" rel="stylesheet">
<link href="${basePath}/bootstrap/css/select2.min.css" rel="stylesheet">
<link href="${basePath}/bootstrap/css/bootstrap-datetimepicker.min.css" rel="stylesheet">
<link href="${basePath}/bootstrap/css/bootstrapValidator.min.css" rel="stylesheet">
<link href="${basePath}/css/daterangepicker.css" rel="stylesheet">
<link href="${basePath}/css/page_modify.css" rel="stylesheet">
<link href="${ basePath}bootstrap/css/fileinput.min.css" rel="stylesheet">
<link href="${ basePath}bootstrap/css/bootstrap-table.css" rel="stylesheet">
<script type="text/javascript" src="${basePath}/page/jquery-2.1.4.min.js"></script>
<script type="text/javascript" src="${basePath}/page/jquery.transit.js"></script>
<script type="text/javascript" src="${basePath}/bootstrap/js/bootstrap.js"></script>
<script type="text/javascript" src="${basePath}/bootstrap/js/bootstrap-table.js"></script>
<script type="text/javascript" src="${basePath}/bootstrap/js/bootstrap-table-zh-CN.js"></script>
<script type="text/javascript" src="${basePath}/bootstrap/js/bootstrap-paginator.min.js"></script>
<script type="text/javascript" src="${basePath}/bootstrap/js/bootstrapValidator.min.js"></script>


<link href="${basePath}/bootstrap/css/select2.css" rel="stylesheet">
<link href="${basePath}/bootstrap/css/select2.min.css" rel="stylesheet">
<link href="${basePath}/bootstrap/css/bootstrapValidator.css" rel="stylesheet">


<script type="text/javascript" src="${basePath}/bootstrap/js/select2.min.js"></script>
<script type="text/javascript" src="${basePath}/bootstrap/js/fileinput.min.js"></script>
<script type="text/javascript" src="${basePath}/page/moment.min.js"></script>
<script type="text/javascript" src="${basePath}/page/daterangepicker.js"></script>
<script type="text/javascript" src="${basePath}/page/common.js"></script>
<script type="text/javascript" src="${basePath}/page/page_init.js"></script>
<script type="text/javascript" src="${basePath}/page/index.js"></script>
<script type="text/javascript" src="${basePath}/page/toast.js"></script>
<script type="text/javascript">
	var basePath = "${basePath}";
	var checkindexs = 0;
	var userJsoinString = <%=session.getAttribute("userJsoinString")%>;
	console.log(userJsoinString);
</script>
<style>
/**日期高度*/
   .select2-container .select2-selection--single{  
     	height:40px;  
   }  
   .select2-container--default .select2-selection--single .select2-selection__rendered{line-height:38px}
   .select2-container--default .select2-selection--single .select2-selection__arrow{top:6px;}
   .search-lable-title{
   		height:40px;line-height:40px;padding-right:0px;
   }
   .form-control{
   		height:40px;	
   }
</style>