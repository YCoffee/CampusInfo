<%@ page language="java" pageEncoding="gbk"%>
<%@page   import="java.util.*"%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
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
	        <h1>系统日志</h1>
	        <br>
		        <table id="mytable" cellspacing="0" align="center" rules="all">
			    <!--
			        <tr><td align="center"><b><big>日志时间</big></b></td><td align="center"><b><big>级别</big></b></td><td align="center"><b><big>触发代码行数</big></b></td><td align="center"><b><big>日志具体内容</big></b></td></tr>
			       -->
			       <tr>
					<th scope="col">
						日志时间
					</th>
					<th scope="col">
						级别
					</th>
					<th scope="col">
						触发代码行数
					</th>
					<th scope="col">
						日志具体内容
					</th>
				</tr>
				<c:forEach items="${logList}" var="ll" varStatus="status">
					<tr>
					<td class="row" align="left" width="160" height="0">
					${ll.logDate}
					</td><td class="row" align="center" width="50" height="0">
					${ll.logLevel}
					</td><td class="row" align="left" width="250" height="0">
					${ll.location}
					</td><td class="row" align="left" width="330" height="0">
					${ll.message}
					</td>
					</tr>     
			    </c:forEach>                                                          
	           </table>
        </center> 
    </body>
</html>
