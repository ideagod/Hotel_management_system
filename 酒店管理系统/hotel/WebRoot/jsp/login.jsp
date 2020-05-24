<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" href="/hotel/css/login.css">
<title>-登录-</title>
</head>
<body id="body">

	<div id="login_div1">
		<div id="login_div2">
			<form action="/hotel/login.do" method=post>
				<table id="login_table">
					<center>
						<font face="楷体" size="5" color="#000">登录界面</font>

						<tr>

							<td class="l_td3">账号</td>
							<td><input type="text" class="l_input1" name="user_name"></td>
							<td></td>
						</tr>

						<tr>

							<td class="l_td3">密码</td>
							<td><input type="password" class="l_input1" name="passwd"></td>
							<td></td>
						</tr>

						<tr>

							<td></td>


							<td>&nbsp;&nbsp;&nbsp;<input type="reset"
								value=" 重       置    " name="reset">
								&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; <input type="submit"
								value=" 登       录    "></td>
							<td></td>
						</tr>
						<tr>

							<td></td>

							<td></td>
						</tr>

						</form>
						</div>
						</div>
					</center>
</body>
</html>