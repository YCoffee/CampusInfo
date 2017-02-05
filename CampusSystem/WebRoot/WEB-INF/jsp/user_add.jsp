<%@ page language="java" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">

<html>
	<head>
		<style type="text/css">
body {
	background: #fff;
	font-size: 12px;
	line-height: 160%;
	font-family: Arial, Helvetica, sans-serif;
	color: #333;
}

body,dl,dt,dd,ul,ol,li,h1,h2,h3,h4,h5,h6,form,fieldset,legend,input,button,textarea,p,th,td
	{
	margin: 0px;
	padding: 0px;
}

a {
	color: #c75f3e;
}

#mytable {
	width: 1200px;
	padding: 0;
	margin: 0;
}

caption {
	padding: 0 0 5px 0;
	width: 900px;
	font: italic 11px "Trebuchet MS", Verdana, Arial, Helvetica, sans-serif;
	text-align: right;
}

th {
	font: bold 11px "Trebuchet MS", Verdana, Arial, Helvetica, sans-serif;
	color: #4f6b72;
	border-right: 1px solid #C1DAD7;
	border-bottom: 1px solid #C1DAD7;
	border-top: 1px solid #C1DAD7;
	letter-spacing: 2px;
	text-transform: uppercase;
	text-align: left;
	padding: 6px 6px 6px 12px;
	background: #CAE8EA no-repeat;
}

th.nobg {
	border-top: 0;
	border-left: 0;
	border-right: 1px solid #C1DAD7;
	background: none;
}

td {
	border-top: 1px solid #C1DAD7;
	border-right: 1px solid #C1DAD7;
	border-bottom: 1px solid #C1DAD7;
	background: #fff;
	font-size: 11px;
	padding: 6px 6px 6px 12px;
	color: #4f6b72;
}

td.alt {
	background: #F5FAFA;
	color: #797268;
}

th.spec {
	border-left: 1px solid #C1DAD7;
	border-top: 0;
	background: #fff no-repeat;
	font: bold 10px "Trebuchet MS", Verdana, Arial, Helvetica, sans-serif;
}

th.specalt {
	border-left: 1px solid #C1DAD7;
	border-top: 0;
	background: #f5fafa no-repeat;
	font: bold 10px "Trebuchet MS", Verdana, Arial, Helvetica, sans-serif;
	color: #797268;
}

/*---------for IE 5.x bug*/
html>body td {
	font-size: 11px;
}

body,td,th {
	font-family: 宋体, Arial;
	font-size: 12px;
}
</style>
<script type="text/javascript">
	function checkform(){
	//检验用户名是否为空
	var username = document.getElementById("username").Value;
	if (username == null || username == "") {
		alert("用户名不能为空!");
		return false;
	}
	//检验密码是否为空
	var password = document.getElementById("password").Value;
	if (password == null || password == "") {
		alert("密码不能为空!");
		return false;
	}
	}
	function checkuname(){
		var username = document.getElementById("username").value;
		var span1 = document.getElementById("span1");
		if (username == null || username == "") {
			span1.innerHTML = "<font color='red'>用户名不能为空</font>";
		}else{
		var xhr = creatXmlHttp();
		//设置监听
		xhr.onreadystatechange = function(){
			if (xhr.readyState == 4) {
				if (xhr.status == 200) {
					span1.innerHTML = xhr.responseText;
				}
				
			}
		}
	   )
		//打开链接)
		xhr.open("GET","${pageContext.request.contextPath}/user_findByName.action?time="+new Date().getTime()+"&username="+username,true);
		//发送
		xhr.send(null);
		}
	}
	//创建异步交互对象
	function creatXmlHttp(){
		var xmlHttp;
		try {
			xmlHttp = new XMLHttpRequest;
		} catch (e) {
			// TODO: handle exception
			try {
				xmlHttp = new ActiveXobject("Msxml12.XMLHTTP"); 
			} catch (e) {
				// TODO: handle exception
				try {
					xmlHttp = new ActiveXobject("Microsoft.XMLHTTP"); 
				} catch (e) {
					// TODO: handle exception
				}
			}
		}
		return xmlHttp;
	}
</script>
	</head>
	<body link="#000066" vlink="#0066FF" alink="#99FF00">
		<a href="admin.jsp"><small>返回</small>
		</a>
		<center>
			<h1>
				创建用户
			</h1>
			<br>
			<form action="userAdd.action" method="post" onsubmit="return checkform">
				<table>
					<tr>
						<td>
							<small>姓名：</small>
						</td>
						<td>
							<input id="username" name="username" type="text" onblur="checkuname()">
							<span id="span1"></span>
						</td>
						
					</tr>
					<tr>
						<td>
							<small>密码：</small>
						</td>
						<td>
							<input id="password" name="password" type="password">
						</td>
					</tr>
					<tr>
						<td>
							<small>类型：</small>
						</td>
						<td align="center">
							<select name="type">
								<option value="user">
									普&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;通&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;用&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;户&nbsp;
								</option>
								<option value="admin">
									管&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;理&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;人&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;员&nbsp;
								</option>
							</select>
						</td>
					</tr>
					<tr>
						<td>
							&nbsp;&nbsp;&nbsp;
						</td>
						<td>
							&nbsp;&nbsp;&nbsp;
						</td>
					</tr>
					<tr>
						<td></td>
						<td align="center">
							<input type="submit" name="method" value="创  建  用  户" />
						</td>
					</tr>
				</table>
			</form>
		</center>
	</body>
</html>
