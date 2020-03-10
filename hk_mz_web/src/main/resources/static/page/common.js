(function() {
    $.MsgBox = {
        Alert: function(title, msg) {
            GenerateHtml("alert", title, msg);
            btnOk(); //alert只是弹出消息，因此没必要用到回调函数callback
            btnNo();
        },
        Confirm: function(title, msg, callback,data) {
            GenerateHtml("confirm", title, msg);
            btnOk(callback,data);
            btnNo();
        }
    }
    /** 扩展js end 方法 */
    String.prototype.endWith=function(s){
	  if(s==null||s==""||this.length==0||s.length>this.length){
		  return false;
	  }
	  if(this.substring(this.length-s.length)==s){
		  return true;
	  }
	  else{
		  return false;
	  }
	  return true;
	}
    /** 扩展js start 方法 */
	String.prototype.startWith=function(s){
	  if(s==null||s==""||this.length==0||s.length>this.length){
		  return false;
	  }
	  if(this.substr(0,s.length)==s){
		  return true;
	  }
	  else{
		  return false;
	  }
	  return true;
	}
	
	/**
	 * 数组indexOf 
	 */
	Array.prototype.indexOf = function (val) {
	    for (var i = 0; i < this.length; i++) {
	        if (this[i] == val) return i;
	    }
	    return -1;
	};

	/**
	 * 数组remove 
	 */
	Array.prototype.remove = function (val) {
	    var index = this.indexOf(val);
	    if (index > -1) {
	        this.splice(index, 1);
	    }
	};
    
    //生成Html
    var GenerateHtml = function(type, title, msg) {
        var _html = "";
        _html += '<div id="mb_box"></div><div id="mb_con"><span id="mb_tit">' + title + '</span>';
        _html += '<a id="mb_ico">x</a><div id="mb_msg">' + msg + '</div><div id="mb_btnbox">';
        if (type == "alert") {
            _html += '<input id="mb_btn_ok" type="button" value="确定" />';
        }
        if (type == "confirm") {
            _html += '<input id="mb_btn_ok" type="button" value="确定" />';
            _html += '<input id="mb_btn_no" type="button" value="取消" />';
        }
        _html += '</div></div>';
        //必须先将_html添加到body，再设置Css样式
        $("body").append(_html);
        //生成Css
        GenerateCss();
    }

    //生成Css
    var GenerateCss = function() {
        $("#mb_box").css({
            width: '100%',
            height: '100%',
            zIndex: '99999',
            position: 'fixed',
            filter: 'Alpha(opacity=60)',
            backgroundColor: 'black',
            top: '0',
            left: '0',
            opacity: '0.6'
        });
        $("#mb_con").css({
            zIndex: '999999',
            width: '500px',
            height: '200px',
            position: 'fixed',
            backgroundColor: 'White'
        });
        $("#mb_tit").css({
            display: 'block',
            fontSize: '14px',
            color: '#444',
            padding: '10px 15px',
            fontWeight: 'bold'
        });
        $("#mb_msg").css({
            padding: '20px',
            lineHeight: '20px',
            fontSize: '13px',
            height: '55px'
        });
        $("#mb_ico").css({
            display: 'block',
            position: 'absolute',
            right: '10px',
            top: '9px',
            width: '18px',
            height: '18px',
            textAlign: 'center',
            lineHeight: '16px',
            cursor: 'pointer',
            fontFamily: '微软雅黑'
        });
        $("#mb_btnbox").css({
            margin: '15px 0 10px 0',
            textAlign: '-webkit-right'
        });
        $("#mb_btn_ok,#mb_btn_no").css({
            marginRight: '20px',
            width: '80px',
            height: '40px',
            borderRadius: '4px',
            border: 'none'
        });
        $("#mb_btn_ok").css({
        	color: 'white',
            backgroundColor: '#5868DD'
        });
        $("#mb_btn_no").css({
        	color: '#262626',
            backgroundColor: '#F7F8FA'
        });
        //右上角关闭按钮hover样式
//        $("#mb_ico").hover(function() {
//            $(this).css({
//                backgroundColor: 'Red',
//                color: 'White'
//            });
//        }, function() {
//            $(this).css({
//                backgroundColor: '#DDD',
//                color: 'black'
//            });
//        });
        var _widht = document.documentElement.clientWidth; //屏幕宽
        var _height = document.documentElement.clientHeight; //屏幕高
        var boxWidth = $("#mb_con").width();
        var boxHeight = $("#mb_con").height();
        //让提示框居中
        $("#mb_con").css({
            top: (_height - boxHeight) / 2 + "px",
            left: (_widht - boxWidth) / 2 + "px"
        });
    }
    //确定按钮事件
    var btnOk = function(callback,data) {
        $("#mb_btn_ok").click(function() {
            $("#mb_box,#mb_con").remove();
            if (typeof(callback) == 'function') {
                callback(data);
            }
        });
    }
    //取消按钮事件
    var btnNo = function() {
        $("#mb_btn_no,#mb_ico").click(function() {
            $("#mb_box,#mb_con").remove();
        });
    }
})();