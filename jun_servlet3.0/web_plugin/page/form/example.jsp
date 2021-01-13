﻿<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="shiro" uri="http://shiro.apache.org/tags" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"  "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html>
  <head>
    <base href="<%=basePath%>">
    <title>表单管理</title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<jsp:include page="../../layout/script.jsp"></jsp:include>



    <style type="text/css">
        body {
            padding: 0px;
            margin: 0px;
            font-size: 12px;
        }

        .panel-container {
            padding: 0px 10px 10px 10px;
        }

        .panel-noborder {
            border-left-width: 0px;
            border-top-width: 0px;
            border-right-width: 0px;
        }
    </style>

    <script type="text/javascript">
        $.util.namespace("$.easyui");
        $.easyui.showSourceDialog = function (url, options) {
            var defaults = { title: $.string.format("查看页面\"{0}\"的源码", url), width: 800, height: 600, enableCloseButton: false, enableApplyButton: false },
                opts = typeof options == "string"
                    ? $.extend({}, defaults, { title: options, content: "<textarea></textarea>", topMost: false, maximizable: true })
                    : $.extend({}, defaults, options || {}, { content: "<textarea></textarea>", topMost: false });
            $.easyui.showDialog(opts).find("textarea").codemirror({
                fit: true, url: url, border: false, readOnly: true, bodyCls: "panel-noborder", fontSize: "13px", lineHeight: "15px"
            });
        };

        $(function () {
            var path = $.util.request["path"];

            $.ajaxSetup({
                statusCode: {
                    404: function (XMLHttpRequest, status, error) {
                        if ($.util.browser.chrome && !XMLHttpRequest.responseText) {
                            alert("IE11及WebKit核心的浏览器(包括 Chrome、搜狗/傲游/360等等的极速模式)浏览器下不支持 AJAX 本地访问，请选择其他浏览器或者将该项目部署至 WEB服务器(例如 IIS 或 Tomcat 等) 中进行浏览操作！");
                        }
                    }
                }
            });

            var containerTabs = $("#containerTabs"), tabsOpts = containerTabs.tabs("options"),
                onSelect = tabsOpts.onSelect, isLoaded = false,
                cookieTheme = $.cookie("themeName"), theme = cookieTheme ? cookieTheme : $.util.$.easyui.theme(),
                openNewPage = function (node) {
                    var n = node || {}, attrs = node.attributes || {}, opts = $.extend({}, n, { title: n.text }, attrs);
                    if (!opts.href) { return; }
                    window.open("../" + opts.href, "_blank");
                },
                addModuleTab = $.util.parent && $.util.parent.mainpage && $.isFunction($.util.parent.mainpage.addModuleTab) ? $.util.parent.mainpage.addModuleTab : openNewPage,
                t = $("#tt");

            $("#demo").each(function () {
                var p = $(this), opts = p.panel("options"), onLoad = opts.onLoad;
                opts.onLoad = function () {
                    if ($.isFunction(onLoad)) { onLoad.apply(this, arguments); }
                    p.find(":header:first").each(function () { document.title = $(this).text(); });
                };
                p.panel("refresh", path);

                $("#codemirror").codemirror({
                    fit: true, url: path, readOnly: true, border: true, bodyCls: "panel-noborder", fontSize: "13px", lineHeight: "15px"
                });
            });

            $.easyui.theme(theme);

            tabsOpts.onSelect = function (title, index) {
                if ($.isFunction(onSelect)) { onSelect.apply(this, arguments); }
                if (index == 2 && !isLoaded) {
                    t.tree({
                        animate: true,
                        lines: true,
                        toggleOnClick: true,
                        selectOnContextMenu: true,
                        dataPlain: false,
                        showOption: true,
                        url: "../common/nav-api-menu-data.json",
                        method: "get",
                        onClick: function (node) { addModuleTab(node); },
                        onLoadSuccess: function (node, data) { t.tree("collapseAll"); },
                        contextMenu: [
                            {
                                text: "打开/转到", hideDisabledMenu: true, iconCls: "icon-standard-application-add",
                                disabled: function (e, node) {
                                    return (!node.attributes || !node.attributes.href || openNewPage === addModuleTab) ? true : false;
                                },
                                handler: function (e, node) { addModuleTab(node); }
                            },
                            {
                                text: "在新页面中打开", iconCls: "icon-standard-shape-move-forwards", bold: openNewPage === addModuleTab,
                                disabled: function (e, node) {
                                    return (!node.attributes || !node.attributes.href) ? true : false;
                                },
                                handler: function (e, node) { openNewPage(node); }
                            },
                            "-",
                            { text: "刷新", iconCls: "icon-cologne-refresh", handler: function (e, node) { t.tree("reload"); } }
                        ],
                        onAfterEdit: function (node) { window.mainpage.nav.rename(node.id, node.text); }
                    });
                    isLoaded = true;
                }
            };
        });
    </script>
</head>
<body>
    <div id="containerTabs" class="easyui-tabs" data-options="fit: true, border: false, showOption: true, enableNewTabMenu: true, tabPosition: 'left', headerWidth: 100">
        <div id="ds" class="panel-container" data-options="title: '数据源管理', iconCls: 'icon-hamburg-advertising', selected: true" style="position: relative;">
            <p>demo</p>
        </div>
        
        <div id="ds" class="panel-container" data-options="title: '表结构管理', iconCls: 'icon-hamburg-advertising', selected: false" style="position: relative;">
            <p>demo</p>
        </div>
        
        <div id="demo" class="panel-container" data-options="title: '功能演示', iconCls: 'icon-hamburg-advertising', selected: false" style="position: relative;">
            <p>IE11及WebKit核心的浏览器(包括 Chrome、搜狗/傲游/360等等的极速模式)浏览器下不支持 AJAX 本地访问，请选择其他浏览器或者将该项目部署至 WEB服务器(例如 IIS 或 Tomcat 等) 中进行浏览操作！</p>
        </div>
        
        <div id="code" data-options="title: '查看源码', iconCls: 'icon-standard-script-code'">
            <div class="easyui-layout" data-options="fit: true">
                <div data-options="region: 'north', border: false" style="height: 40px; border-bottom-width: 1px; padding-left: 10px;">
                    <p>
                        若要查看整站源码，请跳转至 <a href="#" target="_blank" style="text-decoration: none;">http://jqext.sinaapp.com/</a>，并点击
                        其<b>“主页”</b>选项卡中的<b>“<a href="#" target="_blank" style="text-decoration: none;">源码下载</a>”</b>所示链接。
                    </p>
                </div>
                <div data-options="region: 'center', title: '此处仅显示“功能演示”选项卡所示功能基于本插件集合的实现源码', border: false">
                    <textarea id="codemirror"></textarea>
                </div>
            </div>
        </div>
        
        <div id="view" class="panel-container" data-options="title: '关于...', iconCls: 'icon-hamburg-library'">
            <p>
                jQuery && jEasyUI 扩展功能集合<br />
                	该扩展功能基于 jQuery 1.9.x/2.x 和 jQuery EasyUI 1.3.6 实现<br />
                <br />
                jqueyr-extensions<br />
                	二次开发：流云<br />
                <br />
                	Copyright (c) 2013-2014 ChenJianwei personal All rights reserved.<br />
                <a href="#" target="_blank"></a>
            </p>
            <hr />
            <p>更多信息请点击 <a href="#" target="_blank" style="text-decoration: none;">此处</a> 进行查看；或者操作下面的菜单以查看本插件集合中的其他示例。</p>
            <hr />
<!--             <ul id="tt"></ul> -->
        </div>
    </div>
    <div style="display: none;">
        <script type="text/javascript">
            var cnzz_protocol = (("https:" == document.location.protocol) ? " https://" : " http://");
            document.write(unescape("%3Cspan id='cnzz_stat_icon_5654850'%3E%3C/span%3E%3Cscript src='" + cnzz_protocol + "s9.cnzz.com/stat.php%3Fid%3D5654850%26show%3Dpic' type='text/javascript'%3E%3C/script%3E"));
        </script>
    </div>
</body>
</html>
