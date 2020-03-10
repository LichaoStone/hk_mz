/**
 * Created by ThatWay
 * 18/6/1
 * 吐司提示
 */

function toast(msg,auto,sty,place,wid){

    if(msg){

        if(!auto && auto !== false){
            auto = true;
        }

        var p_wid = 600;
        //bottom/middle/top
        var p_place = 'bottom';
        //error/info
        var p_sty = 'error';

        if(wid){
            if(!(wid+'').endWith('%')){
                p_wid = wid+'px';
            }
        }

        if(place){
            p_place = place;
        }

        if(sty){
            p_sty = sty;
        }

        //搜索body下有没有toast标签
        var bodyNode = $('body');
        var toastNode = bodyNode.find('#toastNode');
        if(toastNode.length > 0){
            //已经有这个节点了
            toastNode.remove();
        }

        var iconCode = '';
        if(p_sty === 'error'){
            iconCode = '&times;';
        }else if(p_sty === 'info'){
            iconCode = '&iexcl;';
        }else if(p_sty === 'warn'){
            iconCode = '!';
        }else if(p_sty === 'succ'){
            iconCode = '';
        }

        //还没有这个节点
        var toastNodeHtml = '<div id="toastNode" class="toastWrapper">' +
                                '<div class="toastBox toastWrapper_'+sty+'" style="width: '+p_wid+';">';
        toastNodeHtml += '<span class="icon">'+iconCode+'</span>';
        toastNodeHtml += '<span class="text">'+msg+'</span>';
        toastNodeHtml += '<span class="close" onclick="toastHide()">&times;</span>';
        toastNodeHtml += '</div>' +
                        '</div>';

        toastNode = $(toastNodeHtml);
        bodyNode.append(toastNode);

        toastShow(p_place,auto);
    }

    //监听窗口变化
    $(window).resize(function(){
        var toastNode = $("#toastNode");
        if(toastNode > 0){
            setToastPosition(toastNode);
        }
    });

    //监听滚动条
    $(window).scroll(function() {
        var toastNode = $("#toastNode");
        if(toastNode && toastNode.length > 0){
            if(toastNode.is(':visible')){
                setToastPosition(toastNode);
            }
        }
    });
}

//显示toast
function toastShow(place,auto){

    var toastNode = $("#toastNode");
    var toastBoxNode = toastNode.children('.toastBox');

    if(toastBoxNode){
        setToastPosition(toastNode);

        if(toastBoxNode.hasClass('toastAni_top')){
            toastBoxNode.removeClass('toastAni_top')
        }else if(toastBoxNode.hasClass('toastAni_middle')){
            toastBoxNode.removeClass('toastAni_middle')
        }else if(toastBoxNode.hasClass('toastAni_bottom')){
            toastBoxNode.removeClass('toastAni_bottom')
        }

        toastNode.show();
        // toastBoxNode.addClass('toastAni_'+place);
        toastBoxNode.addClass('toastAni_top');

        if(auto){
            setTimeout(function(){
                toastNode.hide();
            },3000);
        }
    }
}

//隐藏toast
function toastHide(){
    var toastNode = $("#toastNode");
    toastNode.hide();
}

// //设置位置
function setToastPosition(obj){

    var containerNode = $(obj);
    if(containerNode){
        var scollTop = getPageScollTop();
        containerNode.css('top',scollTop);
    }
}
