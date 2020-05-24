//定义一个全局变量：作来标记具体的是什么错误，如果这个变量 是0说明没有信息问题，可以注册
var a = "0";
var b = "0";
var c = "0";
var d = "0";
var e= "0";
$(function() {
	// 用户名正则
	$("#username").blur(
			function() {
				// 定义一个变量，用来存放输入框中的值 ：可以试试这个：$("#username").val(),
				var email = jQuery("#username").val();
				// 定义一个变量，判断手机的正则
				var reg = /^\w+([-+.]\w+)*@\w+([-.]\w+)*\.\w+([-.]\w+)*$/;
				var message = "";
				var flag = false;
				// 完成正则匹配
				if (!reg.test(email)) {
					a = "1";// 修改全局变量
					message = "你输入的账号不合法！";
				} else {
					a = "0";
					flag = true;
					message = "格式正确!";
				}
				if (flag) {
					$("#reg_sp1").text(message).css('color', '#0000ff');

					// 判断是否可以正常注册

					//json数据：key:value,$("#username").val():用户名输入框的内容
					var json = {
						"username" : $("#username").val()
					};
				
					$.get("http://localhost:8080/big_job/RegisterAjaxServlet",
							json, function(data, suss) {
								if (data == "true") {
									$("#reg_sp1").text("该账号已经被注册").css('color',
											'#F53808');a="1";

								} else {
									$("#reg_sp1").text("可以正常注册").css('color',
											'#2A00FF');a="0";
								}
							});
				} else {
					$("#reg_sp1").text(message).css('color', '#f53808');
				}
		


			});

	/**
	 * 2.密码不能少于6位数
	 */

	$("#password").blur(function() {
		var len = $("#password").val();
		var message = "";
		var flag = false;
		if (len.length < 6) {
			b = "2";// 修改全局变量
			message = "密码不能少于6位！";
		} else {
			b = "0";// 修改全局变量
			flag = true;
			message = "格式正确!"
		}
		if (flag) {
			$("#reg_sp2").text(message).css('color', '#0000ff');
		} else {
			$("#reg_sp2").text(message).css('color', '#f53808');
		}

	});

	$("#password2").blur(function() {
		var p1 = $("#password").val();
		var p2 = $("#password2").val();
		var message = "";
		var flag = false;
		if (p1 != p2) {
			c = "3";// 修改全局变量
			message = "两次密码不一样！";
		} else {
			c = "0";// 修改全局变量
			flag = true;
			message = "格式正确!"
		}
		if (flag) {
			$("#reg_sp3").text(message).css('color', '#0000ff');
		} else {
			$("#reg_sp3").text(message).css('color', '#f53808');
		}
	});

	
	
	
	$("#password3").blur(function() {
		var len = $("#password3").val();
		var message = "";
		var flag = false;
		if (len.length < 6) {
			b = "2";// 修改全局变量
			message = "密码不能少于6位！";
		} else {
			b = "0";// 修改全局变量
			flag = true;
			message = "格式正确!"
		}
		if (flag) {
			$("#reg_sp2").text(message).css('color', '#0000ff');
		} else {
			$("#reg_sp2").text(message).css('color', '#f53808');
		}

	});
	/**
	 * 3.判断两次密码是否一样
	 */
	$("#password4").blur(function() {
		var p1 = $("#password3").val();
		var p2 = $("#password4").val();
		var message = "";
		var flag = false;
		if (p1 != p2) {
			c = "3";// 修改全局变量
			message = "两次密码不一样！";
		} else {
			c = "0";// 修改全局变量
			flag = true;
			message = "格式正确!"
		}
		if (flag) {
			$("#reg_sp3").text(message).css('color', '#0000ff');
		} else {
			$("#reg_sp3").text(message).css('color', '#f53808');
		}
	});
	
	
	$("#phone").blur(function() {
		var phone = $("#phone").val();
		var reg_phone = /^1[345678][0-9]{9}$/;
		var message = "";
		var flag = false;
		if (!reg_phone.test(phone)) {
			d = "4";// 修改全局变量
			message = "手机号格式错误!"
		} else {
			d = "0";// 修改全局变量
			flag = true;
			message = "格式正确!"
		}
		if (flag) {
			$("#reg_sp7").text(message).css('color', '#0000ff');
		} else {
			$("#reg_sp7").text(message).css('color', '#f53808');
		}

	});
	
	

});

/**
 * 编写一个show方法处理看不清换一张的功能
 */
function show() {

	$("#reg_imgid").attr("src",
			"/big_job/CheckCode?time=" + new Date().getTime())
}
/**
 * 编写一个方法 ：判断所有的输入框内容是否合法
 * 
 * @returns
 */
function check() {
	if (a == 1) {
		alert("用户信息有误!请检查后重新输入!")
		return false;
	}
	if (b == 2) {
		alert("密码信息有误!请检查后重新输入!")
		return false;
	}
	if (c == 3) {
		alert("第二次密码有误!请检查后重新输入!")
		return false;
	}
	if (d == 4) {
		alert("手机信息有误!请检查后重新输入!")
		return false;
	}


}
