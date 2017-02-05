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
    </head>
    <body link="#000066" vlink="#0066FF" alink="#99FF00">
    	<a href="admin.jsp"><small>返回</small></a>
    	<center>
	        <h1>更新用户</h1>
	        <br>
           <form action="userUpdate.action" method="post">
		        <table>
			        <tr><td><small>姓名：</small></td><td><input name = "username" type="text" value="${sessionScope.userLoad.username}"></td></tr>
			        <tr><td><small>密码：</small></td><td><input name = "password" type="password" value="${sessionScope.userLoad.password}"></td></tr>
			        <tr><td><small>类型：</small></td><td align="center"><select name="type"><option value="user">普&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;通&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;用&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;户&nbsp;</option><option value="admin">管&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;理&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;人&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;员&nbsp;</option></select></td></tr>
			        <tr><td>&nbsp;&nbsp;&nbsp;</td><td><input name = "id_key" type="hidden" value="${sessionScope.userLoad.id}"></td></tr>
			        <tr><td></td><td align="center"><input type="submit" name="method" value="更  新 用  户"/></td></tr> 
	        	</table>
           </form>
        </center> 
    </body>
</html>
