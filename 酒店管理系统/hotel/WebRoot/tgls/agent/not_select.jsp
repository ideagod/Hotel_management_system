<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page import="javabean.Room"%>
<%@page import="javabean.customer"%>
<%@page import="javax.servlet.http.HttpSession"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.util.Date"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>

<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge,Chrome=1">
<!-- Google Chrome Frame也可以让IE用上Chrome的引擎: -->
<meta name="renderer" content="webkit">
<!--国产浏览器高速模式-->
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta name="author" content="Mr. Yao" />
<!-- 作者 -->
<meta name="revised" content="Yao.v1, 2018/02/27" />
<!-- 定义页面的最新版本 -->
<meta name="description" content="网站简介" />
<!-- 网站简介 -->
<meta name="keywords" content="搜索关键字，以半角英文逗号隔开" />
<title>已入住信息</title>

<!-- 公共样式 开始 -->
<link rel="stylesheet" type="text/css" href="../../css/base.css">
<link rel="stylesheet" type="text/css" href="../../css/iconfont.css">
<script type="text/javascript"
	src="../../framework/jquery-1.11.3.min.js"></script>
<link rel="stylesheet" type="text/css" href="../../layui/css/layui.css">
<link rel="stylesheet" type="text/css" href="/hotel/css/motai.css">
<script type="text/javascript" src="../../layui/layui.js"></script>
<!-- 滚动条插件 -->
<link rel="stylesheet" type="text/css"
	href="../../css/jquery.mCustomScrollbar.css">
<script src="../../framework/jquery-ui-1.10.4.min.js"></script>
<script src="../../framework/jquery.mousewheel.min.js"></script>
<script src="../../framework/jquery.mCustomScrollbar.min.js"></script>
<script src="../../framework/cframe.js"></script>
<!-- 仅供所有子页面使用 -->
<!-- 公共样式 结束 -->

</head>

<body>

	<div class="cBody">
		<div class="console">
			<form class="layui-form" action="/hotel/select_customerServlet.do">
				<div class="layui-form-item">
					<div class="layui-input-inline">
						<input type="text" name="customer_information" required
							lay-verify="required" placeholder="输入姓名" autocomplete="off"
							class="layui-input">
					</div>

					<button class="layui-btn" lay-submit lay-filter="formDemo">搜索</button>
			</form>
			<button class="layui-btn" lay-submit lay-filter="formDemo">返回</button>
		</div>



	</div>



	<table class="layui-table">
		<thead>
			<tr>
				<th>入住人</th>
				<th>性别</th>
				<th>电话</th>
				<th>身份证</th>
				<th>入住时间</th>
				<th>入住天数</th>
				<th>房间号</th>
			</tr>
		</thead>
		<tbody>


			<h1>无数据</h1>


		</tbody>
	</table>

</body>