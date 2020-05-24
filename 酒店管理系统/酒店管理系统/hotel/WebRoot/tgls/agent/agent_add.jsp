<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page import="javabean.Room"%>
<%@page import="javax.servlet.http.HttpSession"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.util.Date"%>
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
 <%
        Date date = new Date();
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd,HH:mm:ss");
        String s = df.format(date);

    %>

		<div class="cBody">
			<table class="layui-table">
				<thead>
					<tr>
						<th>客房类型</th>				
						<th>房间号</th>
						<th>客房价格</th>
						<th>操作</th>
						<th>操作</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach var="list1" items="${list1.list}">				
			<c:choose>
       		 <c:when test="${ empty list1}">
           	   无数据
       		 </c:when>
        	<c:otherwise>   
					<tr>
						<td>${list1.type}</td>					
						<td>${list1.room_num}</td>
						<td>${list1.price}</td>						
						<td>			
						<input class="layui-btn layui-btn-xs"  type="button" onclick="location='#modal-one'" value="入住" /> 				
						</td>
						<td>
						<input class="layui-btn layui-btn-xs" type="button" onclick="javascript:window.open('${list1.img}')" value="房间信息" /> 
						</td>	
<div class="modal" id="modal-one" aria-hidden="false">
    <div class="modal-dialog">
        <div class="modal-header">
            <h2>添加入住信息</h2>
        </div>
        <div class="modal-body">
            <form action="/hotel/customer_in_Servlet.do" method="get"/>			
           <p><input  type="hidden" name=room_num3 value = "${list1.room_num}" ></p>
			<p>姓名：<input type="text"  name="username"/></p>
			<p>性别：<input type="radio" name="sex" value="男" maxlength = "16"/>男
					<input type="radio" name="sex" value="女"  maxlength = "16"/>女</p>
			<input type="text"  name="id_card" placeholder="输入身份证">
			<p>电话：<input type="text"  name="phone"></p>

			<p>入住时间：<input type="text"  name="in_time" value=<%=s%>></p>
			<p>入住天数：<select  name="in_day">
					  <option value="1">1</option>
					  <option value="2">2</option>
					  <option value="3">3</option>
					  <option value="4">4</option>
					  <option value="5">5</option>
					  <option value="6">6</option>
					  <option value="7">7</option>
					  </select></p>
					 <input  type="text" name=room_num placeholder="输入房间号验证" >
		
        </div>
        <div class="modal-footer">
<button class="btn">确定</button> 
	</form>
        </div>
    </div>
    
   
    
</div>

					</tr>
					
			 </c:otherwise>
	    	</c:choose>
			</c:forEach>
			
				</tbody>
			</table>
		<style>
ul.pagination {
    display: inline-block;
   
    	position: absolute;
	top: 330px;
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
     <c:when test="${list1.currentPage<=1}">
          <li><a>上一页</a></li> 
       		 </c:when>
        	<c:otherwise>  
	<li><a href="${pageContext.request.contextPath}/add_roomServlet.do?&page=${list1.currentPage-1}">上一页</a></li>
		 </c:otherwise>
	    	</c:choose>
	    
	<li><span >第${list1.currentPage}页/共 ${list1.totalpage}页</span> 	</li>								
	<!-- 显示下一页 -->
	<c:choose>
     <c:when test="${list1.currentPage>=list1.totalpage}">
         <li><a>下一页</a></li>
       		 </c:when>
        	<c:otherwise>
	<li><a href="${pageContext.request.contextPath}/add_roomServlet.do?&page=${list1.currentPage+1}">下一页</a></li>
	 </c:otherwise>
	    	</c:choose>
											
	</ul>	

		
	</body>
	</html>
