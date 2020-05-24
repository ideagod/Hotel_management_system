<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
 
<meta  charset="utf-8">
 
<title>客房预订</title> 
<link rel="stylesheet" type="text/css" href="/hotel/css/Checkin.css">
<!-- 新 Bootstrap4 核心 CSS 文件 -->
<link rel="stylesheet"
	href="https://cdn.staticfile.org/twitter-bootstrap/4.3.1/css/bootstrap.min.css">
<!-- jQuery文件。务必在bootstrap.min.js 之前引入 -->
<script src="https://cdn.staticfile.org/jquery/3.2.1/jquery.min.js"></script>
<!-- bootstrap.bundle.min.js 用于弹窗、提示、下拉菜单，包含了 popper.min.js -->
<script
	src="https://cdn.staticfile.org/popper.js/1.15.0/umd/popper.min.js"></script>
<!-- 最新的 Bootstrap4 核心 JavaScript 文件 -->
<script
	src="https://cdn.staticfile.org/twitter-bootstrap/4.3.1/js/bootstrap.min.js"></script>
<!-- 日期选择文件 -->
<link href="https://cdn.bootcss.com/bootstrap/3.3.7/css/bootstrap.min.css" rel="stylesheet">
<link href="https://cdn.bootcss.com/bootstrap-datetimepicker/4.17.47/css/bootstrap-datetimepicker.min.css" rel="stylesheet">
<script src="https://cdn.bootcss.com/jquery/3.3.1/jquery.js"></script>
<script src="https://cdn.bootcss.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<script src="https://cdn.bootcss.com/moment.js/2.24.0/moment-with-locales.js"></script>
<script src="https://cdn.bootcss.com/bootstrap-datetimepicker/4.17.47/js/bootstrap-datetimepicker.min.js"></script>
</head>
<body>
	<div class="backimage">
		<div class="center">
			<form action="servlet/checkin_servlet" method="get">
				<div class="form-group">
					<label for="text">姓名:</label> <input type="text"
						class="form-control" name="username" id="name"
						placeholder="Enter name">
				</div>
				<div class="form-group">
					<label for="id_card">身份证号码:</label> <input type="text"
						class="form-control" name="id_card" placeholder="Enter IdNumber">
				</div>
				<div class="form-group">
					性别:<br> <label class="radio-inline"><input
						type="radio" name="sex" value="男">男</label> <label
						class="radio-inline"><input type="radio" name="sex"
						value="女">女</label>
				</div>
				<div class="form-group">
					<label for="phone">电话号码:</label> <input type="text"
						class="form-control" name="phone" placeholder="Enter Phone Number">
				</div>
				<div class="form-group">
					<label for="room">房间类型:</label> <select class="form-control"
						name="room">
						<option value="2">单人客房</option>
						<option value="3">双人客房</option>
						<option value="4">商务套房</option>
						<option value="5">总统套房</option>
					</select>
				</div>
				<div class="row">
					<div class='col-sm-6'>
						<div class="form-group">
							<label>入住日期：</label>
							<!--指定 date标记-->
							<div class='input-group date' id='datetimepicker1'>
								<input type='text' name='datetimepicker1' class="form-control" />
								<span class="input-group-addon"> <span
									class="glyphicon glyphicon-calendar"></span>
								</span>
							</div>
						</div>
					</div>
					<div class='col-sm-6'>
					<div class="form-group">
						<label>退房日期：</label>
						<!--指定 date标记-->
						<div class='input-group date' id='datetimepicker2'>
							<input type='text' name='datetimepicker2' class="form-control" />
							<span class="input-group-addon"> <span
								class="glyphicon glyphicon-calendar"></span>
							</span>
						</div>
					</div>
					</div>
				</div>
				<p id="demo"></p>
				<br> <br> <br> <br> <br> <br> <br>
				<div style="text-align:center">
					<button type="submit" class="btn btn-primary">Submit</button>
				</div>

			</form>
		</div>
	</div>
</body>
<script type="text/javascript">
$(function () {

    $('#datetimepicker1').datetimepicker({
		minDate: new Date(),
        format: 'YYYY-MM-DD,HH:MM:SS',
        locale: moment.locale('zh-cn')
    });

    $('#datetimepicker2').datetimepicker({
		minDate: new Date(),
        format: 'YYYY-MM-DD,HH:MM:SS',
        locale: moment.locale('zh-cn')
    });
});
 </script>
 <script type="text/javascript">
 function countDay(){
var b = new Date(datetimepicker1);
var e = new Date(datetimepicker2);
var dif = e.getTime() - b.getTime();
var day = Math.floor(dif / (1000 * 60 * 60 * 24));
day+=1;
document.getElementById("demo").innerHTML=day*20;
}
</script>
</html>
