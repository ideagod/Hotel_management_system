<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
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
<title>用户权限信息</title>

<!-- 公共样式 开始 -->
<link rel="stylesheet" type="text/css" href="/hotel/css/base.css">
<link rel="stylesheet" type="text/css" href="/hotel/css/iconfont.css">
<script type="text/javascript"
	src="/hotel/framework/jquery-1.11.3.min.js"></script>
<link rel="stylesheet" type="text/css" href="../../layui/css/layui.css">
<script type="text/javascript" src="/hotel/layui/layui.js"></script>
<!-- 滚动条插件 -->
<link rel="stylesheet" type="text/css"
	href="/hotel/css/jquery.mCustomScrollbar.css">
<script src="/hotel/framework/jquery-ui-1.10.4.min.js"></script>
<script src="/hotel/framework/jquery.mousewheel.min.js"></script>
<script src="/hotel/framework/jquery.mCustomScrollbar.min.js"></script>
<script src="/hotel/framework/cframe.js"></script>
<!-- 仅供所有子页面使用 -->
<!-- 公共样式 结束 -->

</head>

<body>
	<div class="reg_div1">修 改 信 息</div>


	<div class="reg_div2">

		<form
			action="${pageContext.request.contextPath}/re_informationServlet.do"
			method="post" >
			<!-- get:有大小要求，不能超过4kb -->
			<table class="reg_table1">
				<br></br>


				<tr>
					<td class="reg_div1_infor">*账号:</td>
					<td class="reg_div1_infor">${rsUser.sno }</td>
				</tr>
				<tr></tr>
				<tr>
					<td class="reg_div1_infor">*姓名:</td>
					<td class="reg_div1_infor">${rsUser.name}</td>
				</tr>
				<tr></tr>

				<tr>
					<td class="reg_div1_infor">*性别:</td>
					<td class="reg_div1_infor">${rsUser.sex }</td>
				</tr>
				<tr></tr>

				<tr>
					<td class="reg_div1_infor">*地址:</td>
					<td class="reg_div1_infor"><input type="text" name="address"
						value="吉林大学珠海学院" class="reg_td1"></td>
					<td><span class="reg_sp6" id="reg_sp6"></span></td>
				</tr>
				<tr></tr>
				<tr>
					<td class="reg_div1_infor">*联系电话:</td>
					<td class="reg_div1_infor"><input type="text" name="phone"
						value=10086 class="reg_td1" id="phone"></td>
					<td><span class="reg_sp7" id="reg_sp7"></span></td>
				</tr>

				<tr>
					<td><input type="submit" name="submit" value="确认修改"></td>
				</tr>
			</table>
		</form>


		<div id="pages"></div>
		<script>
				layui.use(['laypage', 'layer'], function() {
					var laypage = layui.laypage,
						layer = layui.layer;
				
					//总页数大于页码总数
					laypage.render({
					    elem: 'pages'
					    ,count: 100
					    ,layout: ['count', 'prev', 'page', 'next', 'limit', 'skip']
					    ,jump: function(obj){
					      console.log(obj)
					    }
					});
				});
			</script>
	</div>
</body>

</html>

