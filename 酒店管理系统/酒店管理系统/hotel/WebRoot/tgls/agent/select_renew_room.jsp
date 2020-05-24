<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page import="javabean.Room"%>
<%@page import="javabean.customer"%>
<%@page import="javax.servlet.http.HttpSession"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
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
		<script type="text/javascript" src="../../framework/jquery-1.11.3.min.js"></script>
		<link rel="stylesheet" type="text/css" href="../../layui/css/layui.css">
		<link rel="stylesheet" type="text/css" href="/hotel/css/motai.css">
		<script type="text/javascript" src="../../layui/layui.js"></script>
		<!-- 滚动条插件 -->
		<link rel="stylesheet" type="text/css" href="../../css/jquery.mCustomScrollbar.css">
		<script src="../../framework/jquery-ui-1.10.4.min.js"></script>
		<script src="../../framework/jquery.mousewheel.min.js"></script>
		<script src="../../framework/jquery.mCustomScrollbar.min.js"></script>
		<script src="../../framework/cframe.js"></script><!-- 仅供所有子页面使用 -->
		<!-- 公共样式 结束 -->

	</head>

	<body>

		<div class="cBody">
			<div class="console">
				<form class="layui-form" action="/hotel/select_renew_roomServlet.do">
					<div class="layui-form-item">
						<div class="layui-input-inline">
							<input type="text" name="customer_information" required lay-verify="required" placeholder="输入关键词" autocomplete="off" class="layui-input">
						</div>
						<button class="layui-btn" lay-submit lay-filter="formDemo">搜索</button>
				
				</form>
				
				<a class="layui-btn" lay-submit lay-filter="formDemo" href="/hotel/renew_roomServlet.do" >返回</a>
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
						<th>操作</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach var="cust3" items="${cust3.list}">				
			  
					<tr>
						<td>${cust3.username}</td>						
						<td>${cust3.sex}</td>
						<td>${cust3.phone}</td>
						<td>${cust3.id_card}</td>
						<td>${cust3.in_time}</td>
						<td>${cust3.in_day}</td>
						<td>${cust3.room_num}</td>	
						<td>	
						<form action="/hotel/renew1_roomServlet.do">
						<input  type="hidden" name=room_num value ="${cust3.room_num}">
						<input  type="hidden" name=in_day value ="${ cust3.in_day}" >
						<p>续房天数：<select  name="renew_day">
					  <option value="1">1</option>
					  <option value="2">2</option>
					  <option value="3">3</option>
					  <option value="4">4</option>
					  <option value="5">5</option>
					  <option value="6">6</option>
					  <option value="7">7</option>
					  </select></p>
						<button  class="layui-btn layui-btn-xs" onclick="if(confirm('确定续房？')==false) return false;" >续房</button></form>	</td>									
					</tr>
	
			</c:forEach>
				</tbody>
			</table>
		<style>
ul.pagination {
    display: inline-block;
   
    	position: absolute;
	top: 390px;
	right: 500px;
}

ul.pagination li {display: inline;}

ul.pagination li a,span {
    color: black;
    float: left;
    padding: 6px 14px;
    text-decoration: none;
    transition: background-color .2s;
    border: 1px solid #ddd;
    font-size: 13px;
}


ul.pagination li a:hover:not(.active) {background-color: #ddd;}
</style>
	
					
	<ul class="pagination">
	<!-- 显示上一页 -->

	<c:choose>
     <c:when test="${cust3.currentPage<=1}">
          <li><a>上一页</a></li> 
       		 </c:when>
        	<c:otherwise>  
	<li><a href="${pageContext.request.contextPath}/renew_roomServlet.do?&page=${cust3.currentPage-1}">上一页</a></li>
		 </c:otherwise>
	    	</c:choose>
	    
	<li><span >第${cust3.currentPage}页/共 ${cust3.totalpage}页</span> 	</li>								
	<!-- 显示下一页 -->
	<c:choose>
     <c:when test="${cust3.currentPage>=cust3.totalpage}">
         <li><a>下一页</a></li>
       		 </c:when>
        	<c:otherwise>
	<li><a href="${pageContext.request.contextPath}/renew_roomServlet.do?&page=${cust3.currentPage+1}">下一页</a></li>
	 </c:otherwise>
	    	</c:choose>
											
	</ul>	

		
	</body>
	</html>

