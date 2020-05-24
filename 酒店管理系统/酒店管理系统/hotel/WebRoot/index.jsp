<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@page import="Servlet.LoginServlet"%>
<html><head>
    <meta charset="UTF-8"> 
    <meta http-equiv="X-UA-Compatible" content="IE=edge,Chrome=1">
    <!-- Google Chrome Frame也可以让IE用上Chrome的引擎: -->
    <meta name="renderer" content="webkit">
    <!--国产浏览器高速模式-->
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- 定义页面的最新版本 -->
    <meta name="description" content="网站简介">
    <!-- 网站简介 --> 
    <meta name="keywords" content="搜索关键字，以半角英文逗号隔开">
    <title>酒店管理系统</title>


    <link rel="stylesheet" type="text/css" href="/hotel/css/base.css">
    <link rel="stylesheet" type="text/css" href="/hotel/css/frame_sys.css">
    <link rel="stylesheet" type="text/css" href="/hotel/css/iconfont.css">
    <script type="text/javascript" src="/hotel/framework/jquery-1.11.3.min.js"></script>
    <script type="text/javascript" src="/hotel/js/frame.js"></script>
    <!--分页插件-->
    <link rel="stylesheet" type="text/css" href="/hotel/css/jquery.page.css">
    <script type="text/javascript" src="/hotel/framework/jquery.page.js"></script>

    <!--自定义滚动条-->
    <script type="text/javascript" src="/hotel/framework/jquery-ui-1.10.4.min.js"></script>
    <script type="text/javascript" src="/hotel/framework/jquery.mousewheel.min.js"></script>
    <script type="text/javascript" src="/hotel/framework/jquery.mCustomScrollbar.min.js"></script>
    <link rel="stylesheet" type="text/css" href="/hotel/css/jquery.mCustomScrollbar.css">


</head>
<body>

<div class="top">
    <p>吉林大学珠海酒店</p>
    <div>
	    <span>
	    	<a class="a1" href="javascript:void(0)"><img src="img/yonghu.jpg"><font>管理员</font></a>
	    	<ul style="display: none;">
	    		<li><a href="javascript:menu_ajax('/hotel/adm_informationServlet.do', '个人中心')"><i class="iconfont icon-yonghu1"></i>个人中心</a></li>
	    		<li><a href="javascript:menu_ajax('/hotel/jsp/re_password.jsp', '修改密码')"><i class="iconfont icon-xiugaimima"></i>修改密码</a></li>
	    		    
	    		<li><a href="/hotel/exitServlet.do" onclick="if(confirm('确定退出？')==false) return false;" ><i class="iconfont icon-zhuxiaologout11"></i>退出登录</a></li>
	    	</ul>
	    </span>
    </div>
</div>

<div class="main" style="width: 1200px; height: 623px;">

    <div class="menu mCustomScrollbar _mCS_1 mCS_no_scrollbar" style="height: 708px;"><div id="mCSB_1" class="mCustomScrollBox mCS-light mCSB_vertical mCSB_inside" style="max-height: none;" tabindex="0"><div id="mCSB_1_container" class="mCSB_container mCS_y_hidden mCS_no_scrollbar_y" style="position:relative; top:0; left:0;" dir="ltr">
    
        <div class="menuList">
            <ul class="menu1">
                <li class="menuli1">
                    <a class="menua1" href="javascript:menu_ajax('tgls/index.html', '后台主页')"><i class="iconfont icon-shouye left"></i>
                        <p>后台主页</p></a>
                </li>
                <li class="menuli1">
                    <a class="menua1" href="javascript:void(0)"><i class="iconfont icon-wodeyewuyuan left"></i>
                        <p>入住登记</p><i class="iconfont icon-jiantou_zuo right"></i></a>
                    <ul class="menu2">
                        <li class="menuli2"><a class="menua2" href="javascript:menu_ajax('/hotel/customer_information_Servlet.do', '入住登记,已入住信息')"><i class="menua2_ico"><span></span></i>已入住信息</a></li>
                        <li class="menuli2"><a class="menua2" href="javascript:menu_ajax('/hotel/add_roomServlet.do', '入住登记,添加入住信息')"><i class="menua2_ico"><span></span></i>添加入住信息</a></li>
                    </ul>
                </li>
                <li class="menuli1">
                    <a class="menua1" href="javascript:void(0)"><i class="iconfont icon-shangpin left"></i>
                        <p>续/退房管理</p><i class="iconfont icon-jiantou_zuo right"></i></a>
                    <ul class="menu2">
                        <li class="menuli2"><a class="menua2" href="javascript:menu_ajax('/hotel/renew_roomServlet.do', '续/退房管理,续房')"><i class="menua2_ico"><span></span></i>续房</a></li>
                        <li class="menuli2"><a class="menua2" href="javascript:menu_ajax('/hotel/check_out_roomServlet.do', '续/退房管理,退房')"><i class="menua2_ico"><span></span></i>退房</a></li>
                    </ul>
                </li>
               
                <li class="menuli1">
                    <a class="menua1" href="javascript:menu_ajax('/hotel/adm_informationServlet.do', '管理员信息')"><i class="iconfont icon-yingyongzhongxin left"></i>
                        <p>管理员信息</p></a>
                </li>
                <li class="menuli1">
                    <a class="menua1" href="javascript:menu_ajax('/hotel/old_customerServlet.do', '已退房信息')"><i class="iconfont icon-zhishi left"></i>
                        <p>已退房信息</p></a>
                </li>
            </ul>
        </div>
    </div><div id="mCSB_1_scrollbar_vertical" class="mCSB_scrollTools mCSB_1_scrollbar mCS-light mCSB_scrollTools_vertical" style="display: none;"><div class="mCSB_draggerContainer"><div id="mCSB_1_dragger_vertical" class="mCSB_dragger" style="position: absolute; min-height: 30px; height: 0px; top: 0px;"><div class="mCSB_dragger_bar" style="line-height: 30px;"></div></div><div class="mCSB_draggerRail"></div></div></div></div></div>

    <div class="main_body" style="width: 1000px; height: 708px;">
        <div class="main_body_title"><font>后台主页</font></div>
        <div class="main_body_con mCustomScrollbar _mCS_2" style="height: 608px;"><div id="mCSB_2" class="mCustomScrollBox mCS-light mCSB_vertical mCSB_inside" tabindex="0" style="max-height: none;"><div id="mCSB_2_container" class="mCSB_container" style="position:relative; top:0; left:0;" dir="ltr">
        	<iframe id="mainIframe" src="tgls/index.html" scrolling="no" style="height: 2075px; pointer-events: auto;"></iframe>
        </div><div id="mCSB_2_scrollbar_vertical" class="mCSB_scrollTools mCSB_2_scrollbar mCS-light mCSB_scrollTools_vertical" style="display: block;"><div class="mCSB_draggerContainer"><div id="mCSB_2_dragger_vertical" class="mCSB_dragger" style="position: absolute; min-height: 30px; height: 178px; top: 0px; display: block; max-height: 598px;"><div class="mCSB_dragger_bar" style="line-height: 30px;"></div></div><div class="mCSB_draggerRail"></div></div></div></div></div>
		
    </div>

</div>



<script>
    $(".menu").mCustomScrollbar({
        scrollButtons:{
            enable:false,
            scrollType:"continuous",
            scrollSpeed:20,
            scrollAmount:40
        },
        horizontalScroll:false
    });
    $(".main_body_con").mCustomScrollbar({
        scrollButtons:{
            enable:false,
            scrollType:"continuous",
            scrollSpeed:20,
            scrollAmount:40
        },
        horizontalScroll:false
    });
</script>

<div id="qb-sougou-search" style="display: none; opacity: 0;"><p>搜索</p><p class="last-btn">复制</p><iframe src=""></iframe></div></body></html>
