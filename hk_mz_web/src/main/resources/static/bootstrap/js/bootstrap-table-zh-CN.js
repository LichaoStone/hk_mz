/**
 * Bootstrap Table Chinese translation
 * Author: Zhixin Wen<wenzhixin2010@gmail.com>
 */
(function ($) {
    'use strict';

    $.fn.bootstrapTable.locales['zh-CN'] = {
        formatLoadingMessage: function () {
            return '正在努力地加载数据中，请稍候……';
        },
        formatRecordsPerPage: function (pageNumber) {
            return '每页 ' + pageNumber + ' 条';
        },
        formatShowingRows: function (pageFrom, pageTo, totalRows) {
            // return '显示第 ' + pageFrom + ' 到第 ' + pageTo + ' 条记录，总共 ' + totalRows + ' 条记录';
        	return pageFrom + ' - ' + pageTo + '，共 ' + totalRows + ' 条';
        },
        formatSearch: function () {
            return '搜索';
        },
        formatNoMatches: function () {
            return '<span class="img-span"></span><span class="text-span">没有查询到符合条件的记录</span>';
        },
        formatPaginationSwitch: function () {
            return '隐藏/显示分页';
        },
        formatRefresh: function () {
            return '刷新';
        },
        formatToggle: function () {
            return '切换';
        },
        formatColumns: function () {
            return '列';
        }
    };

    $.extend($.fn.bootstrapTable.defaults, $.fn.bootstrapTable.locales['zh-CN']);

})(jQuery);