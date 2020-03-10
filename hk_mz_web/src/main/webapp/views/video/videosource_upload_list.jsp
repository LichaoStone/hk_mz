<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<!DOCTYPE>
<html>
	<head>
		<title>上传管理</title>
		<%@ include file="../common/import.jsp" %>
		<script type="text/javascript" src="${basePath}/uppy/uppy.min.js"></script>
		<link href="${basePath}/uppy/uppy.min.css" rel="stylesheet">
		<style type="text/css">
			.select-classify{
				width:430px;
				height:40px;
				background:rgba(255,255,255,1);
				border-radius:4px;
				border:1px solid rgba(231,231,243,1);
			}
			.uppy-Dashboard-poweredByUppy{
				display:none;
			}
			.uppy-DashboardContent-bar{
				    display: -ms-flexbox!important;
				    display: flex!important;
				    -ms-flex-align: center!important;
				    align-items: center!important;
				    -ms-flex-pack: justify!important;
				    justify-content: space-between!important;
				    height: 40px!important;
				    width: 100%!important;
				    border-bottom: none !important;
				    z-index: 1004!important;
				    background-color: #fafafa!important;
				    padding: 0 10px!important;
			}
			
		
			.btn-uppy-upload{
				width:80px;
				height:40px;
				float:right;
				background-color: #5868DD;
			}
			
			.uppy-size--md .uppy-DashboardContent-addMore{
				 width: 0px!important;
    		     height: 0px!important;
			}
			
			.btn-uppy-upload-span::before{
				content:"上传"
			}
			
			.uppy-DashboardContent-back::before{
				content:"返回";
			}
		 </style>
	</head>
	<script type="text/javascript">
		var classifyId="${bean.classifyId}";
		$(".UppyIcon").attr("visibility","hidden");
	    $(".uppy-DashboardContent-addMore").html("<div style='width:80px;height:40px;border:1px solid red;'></div>");
	</script>
<body>
	 <!--  
     <div>
		 <select  class="select-classify">
			 <option value="publish">分类1</option>
			 <option value="disable">分类2</option>
		 </select>
		 <span style="font-size:14px;font-family:PingFangSC-Regular;font-weight:400;color:rgba(0,0,0,0.6);line-height:40px;margin-left: 10px;">分类选中后不能更改</span>
	 </div>
	 -->
	 <div id="classify">
	 	<span>分类:</span>
	 	<span>${bean.classifyName}</span>
	 </div>
	 
	 <div>
	 	<span style="color:rgba(0,0,0,0.4);line-height:24px;font-weight:400;font-family:PingFangSC-Regular;font-size:14px;">您可以选择多个视频上传，上传视频文件格式要求如下:视频文件avi、mov、rmvb、rm、FLV、mp4、3GP,小于1G</span>
	 </div>
</body>
</html>
<script type="text/javascript">
	 const uppy = Uppy.Core({
    			  id: 'uppy',
    			  autoProceed: false, //是否自动上传,默认false
    			  allowMultipleUploads:true, //是否允许多个上传批次
    			  debug: true, 
    			  restrictions: {
    				    maxFileSize: 5000000000,   //每个文件最大字节
    				    maxNumberOfFiles: 3, //可以选择的文件总数
    				    minNumberOfFiles: 1, //上载前必须选择的文件最少数量
    				    allowedFileTypes: null  //允许上传的文件类型（通配符）
    				    
    				  },
   				  meta: {},
   				  onBeforeFileAdded: (currentFile, files) => {
   				  		$(".UppyIcon").attr("visibility","hidden !important");
	    				$(".uppy-DashboardContent-addMore").html("<div style='width:80px;height:40px;border:1px solid red;float:right;'></div>");   
   				  },
   				  onBeforeUpload: (files) => {}
   				  //locale: defaultLocale,
   				  //store:  new DefaultStore()
    		   })
        .use(Uppy.Dashboard, {
            id: 'Dashboard',
            //target: 'body',
            //metaFields: [],
            trigger: '#drag-drop-area',
            inline: true,
            width: 750,
            height: 550,
            thumbnailWidth: 280,
            //defaultTabIcon: defaultTabIcon,
            showLinkToFileUploadResult: true,
            showProgressDetails: false,
            hideUploadButton: false,
            hideRetryButton: false,
            hidePauseResumeButton: false,
            hideCancelButton: false,
            hideProgressAfterFinish: false,
            note: null,
            closeModalOnClickOutside: false,
            closeAfterFinish: false,
            disableStatusBar: false,
            disableInformer: false,
            disableThumbnailGenerator: false,
            disablePageScrollWhenModalOpen: true,
            animateOpenClose: true,
            proudlyDisplayPoweredByUppy: true,
            onRequestCloseModal: () => this.closeModal(),
            showSelectedFiles: true,
            //locale: defaultLocale,
            browserBackButtonClose: false
          })
        //.use(Uppy.Instagram, { target: Uppy.Dashboard, serverUrl: 'http://localhost:3020' })
        //.use(Uppy.GoogleDrive, { target: Uppy.Dashboard, serverUrl: 'http://localhost:3020' })
        //uppy.use(Uppy.FileInput, { target: '.UppyForm', replaceTargetContent: true })
        
        
        .use(Uppy.XHRUpload, 
        		{ 
        			endpoint: 'http://192.168.90.130:8080/test',
        			method: 'post',
        			formData: true,
        			fieldName: 'files[]',
        			metaFields: ['size'],
                                bundle: false,
                                withCredentials: true
        		})
		
        
        //uppy.use(Uppy.ProgressBar, {
		//   target: 'body',
		//   fixed: true,
		//   hideAfterFinish: false
		//})
        		
        		
        //uppy.setMeta({username:"ceshi"});                 //全局内容
        //uppy.setFileMeta('oneFile',{resize:1500});        //特定文件属性
    
        
     // uppy.use(Uppy.StatusBar,{
     //    id: 'StatusBar',
     //    target: 'body',
     //    hideAfterFinish: true,
     //    showProgressDetails: false,
     //    hideUploadButton: false,
     //    hideRetryButton: false,
    //     hidePauseResumeButton: false,
      //   hideCancelButton: false,
     //    locale: {}
    // })      

 
        
      uppy.on('success', (fileCount) => {
        console.log(`${fileCount} files uploaded`)
       
      })
      
      var fileId="";
       uppy.on('file-added', (file) => {
    	     console.log('Added fileID', file.id);
			fileId=file.id;
			console.log("Added fileID then "+fileId);	 
			
			
		})
	
	
	
</script>