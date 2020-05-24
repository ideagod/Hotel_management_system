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
	<div class="reg_div1">管 理 员 信 息</div>

	<div class="reg_div2">
		<a href="/hotel/jsp/re_information.jsp">修改</a>

		<form
			action="${pageContext.request.contextPath}/re_passwordServlet.do"
			method="post" >
			<table id="customers">

				<!-- get:有大小要求，不能超过4kb -->
				<tr>
					<td>*账号:</td>
					<td>141414 <input type="hidden" name="user_name" value=141414
						readonly class="reg_td1" id="username"></td>
				</tr>

				<tr>
					<td>*原密码</td>
					<td><input type="password" name="fir_password" class="reg_td1"
						id="fir_password"></td>
				</tr>

				<tr>
					<td class="reg_div1_infor">*新密码</td>
					<td><input type="password" name="password3" class="reg_td1"
						id="password3"></td>
					<span class="reg_sp3" id="reg_sp3"></span>
				</tr>

				<tr>
					<td>*确认密码</td>
					<td><input type="password" name="password4" class="reg_td1"
						id="password4"></td>
					<span class="reg_sp3" id="reg_sp3"></span>
				</tr>

				<tr>
					<td></td>
					<td><input type="submit" value=" 确认修改"></td>
				</tr>

			</table>
		</form>

	</div>
</body>
</html>
