<%@ page language="java" import="java.util.*"
	contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>
	<title>Order Page</title>
	<!-- 
		<link rel="stylesheet" type="text/css"
			href="jq/themes/default/easyui.css">
		<link rel="stylesheet" type="text/css" href="jq/themes/icon.css">
		<script type="text/javascript" src="jq/jquery-1.4.4.min.js"></script>
		<script type="text/javascript" src="jq/jquery.easyui.min.js"></script>
		
		-->
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
			function check(type){	
				if(type=="rechoose"){
					var myform  = document.getElementById("rechooseCourse");
					myform.action="rechooseCourse.action";
					myform.method="post";
					myform.submit();
				}
			
				if(type=="choose"){
					var myform  = document.getElementById("chooseCourse");
					myform.action="chooseCourse.action";
					myform.method="post";
					myform.submit();
				}
				
				if(type=="pass"){
					var myform  = document.getElementById("rechooseCourse");
					myform.action="passCourse.action";
					myform.method="post";
					myform.submit();
				}
				
				if(type=="unpass"){
					var myform  = document.getElementById("rechooseCourse");
					myform.action="unpassCourse.action";
					myform.method="post";
					myform.submit();
				}
				if(type=="addcourse"){
					window.location="";
				}
			}
		</script>
	</head>

	<body>
		<br>
		<c:if test="${sessionScope.user.role == 'admin'}"><a href="admin.jsp">返回主页</a></c:if>
		<c:if test="${sessionScope.user.role == 'user'}"><a href="user.jsp">返回主页</a></c:if>
		<center>
		<i>
	        <h3><font color="#4f6b72">我的课程：</font></h3>
	    </i>
		</center>
		<br>
		<br>
		<form action="rechooseCourse.action" id="rechooseCourse" method="post">
			<table id="mytable" cellspacing="0">
				<caption>已修读的课程
				</caption>
				<caption>

				<c:if test="${sessionScope.user.role == 'admin'}"><input type="button" value="&nbsp;&nbsp;合&nbsp;&nbsp;格&nbsp;&nbsp;" onClick="check('pass')">
				<input type="button" value="&nbsp;不&nbsp;合&nbsp;格&nbsp;" onClick="check('unpass')"></c:if>
				<c:if test="${sessionScope.user.role == 'user'}"><input type="button" value="&nbsp;&nbsp;重&nbsp;&nbsp;修&nbsp;&nbsp;" onClick="check('rechoose')"></c:if>
				</caption>
				<tr>
					<th scope="col">
						选择
					</th>
					<th scope="col">
						序号
					</th>
					<c:if test="${sessionScope.user.role == 'admin'}">
					<th scope="col">
						学生姓名
					</th>
					</c:if>
					<th scope="col">
						课程名
					</th>
					<th scope="col">
						学分
					</th>
					<th scope="col">
						状态
					</th>
				</tr>
				
				<!-- JSTL c:forEach标签的 varStatus属性的含义  说明如下：
				
				不论是对整数还是对集合进行迭代， c:forEach 的varStatus属性  所起的作用相同。
				和 var 属性一样， varStatus 用于创建限定了作用域的变量。不过，varStatus 属性命
				名的变量并不存储当前索引值或当前元素，而是存储于
				javax.servlet.jsp.jstl.core.LoopTagStatus 类的实例中。该类定义了一组特性，
				它们描述了迭代的当前状态，下面列出了这些特性:


				特性 			Getter 			描述 
				current 	getCurrent() 	当前这次迭代的（集合中的）项 
				index 		etIndex() 		当前这次迭代从 0 开始的迭代索引，如：0、1、2、3、4、5、6、7。。。
				count 		getCount() 		当前这次迭代从 1 开始的迭代计数 ，如：1、2、3、4、5、6、7、8。。。
				first 		isFirst() 		用来表明当前这轮迭代是否为第一次迭代的标志 
				last 		isLast() 		用来表明当前这轮迭代是否为最后一次迭代的标志 
				begin 		getBegin() 		begin 属性值 
				end 		getEnd() 		end 属性值 
				step 		getStep() 		step 属性值 				
			    -->
				 
				<c:forEach items="${courselist}" var="uc" varStatus="status">
					<tr>
						<td class="row">
							<input type="checkbox" name="course_key" value="${uc.key}"
								id="${status.count}">
						</td>
						<td class="row">
							&nbsp;${status.count}&nbsp;
						</td>
						<c:if test="${sessionScope.user.role == 'admin'}">
						<td class="row">
							&nbsp;${uc.username}&nbsp;
						</td>
						</c:if>
						<td class="row">
							&nbsp;${uc.course}&nbsp;
						</td>
						<td class="row">
							&nbsp;${uc.credit}&nbsp;
						</td>
						<td class="row">
							<c:if test="${uc.state == 0}">在读</c:if>
							<c:if test="${uc.state == 1}">重修</c:if>
							<c:if test="${uc.state == 2}">合格</c:if>
							<c:if test="${uc.state == 3}">不合格</c:if>
						</td>
					</tr>
				</c:forEach>
			</table>
			<br>
		</form>
		<br>
		<br>
		<form action="chooseCourse.action" id="chooseCourse" method="post">
			<table id="mytable" cellspacing="0">
				<caption>可修读的课程
					</caption>
				<caption>
					<c:if test="${sessionScope.user.role == 'admin'}"><input type="button" value="&nbsp;增&nbsp;加&nbsp;课&nbsp;程&nbsp;"
						onClick="check('addcourse')"></c:if>
					<c:if test="${sessionScope.user.role == 'user'}"><input type="button" value="&nbsp;&nbsp;选&nbsp;&nbsp;修&nbsp;&nbsp;"
						onClick="check('choose')"></c:if>
				</caption>
				<tr>
					<th scope="col">
						选择
					</th>
					<th scope="col">
						课程
					</th>
					<th scope="col">
						学分
					</th>
					<th scope="col">
						课程性质
					</th>
					<th scope="col">
						考核方式
					</th>
					<th scope="col">
						任课教师
					</th>
				</tr>
				
				<tr>
					<td class="row">
						<input type="checkbox" name="course_key" value="大学英语_3">
					</td>
					<td class="row">
						&nbsp;大学英语&nbsp;
					</td>
					<td class="row">
						&nbsp;3&nbsp;
					</td>
					<td class="row">
						&nbsp;公共必修&nbsp;
					</td>
					<td class="row">
						&nbsp;考试&nbsp;
					</td>
					<td class="row">
						&nbsp;邹碧娟&nbsp;
					</td>
				</tr>
				
				<tr>
					<td class="row">
						<input type="checkbox" name="course_key" value="高等数学_4">
					</td>
					<td class="row">
						&nbsp;高等数学&nbsp;
					</td>
					<td class="row">
						&nbsp;4&nbsp;
					</td>
					<td class="row">
						&nbsp;公共必修&nbsp;
					</td>
					<td class="row">
						&nbsp;考试&nbsp;
					</td>
					<td class="row">
						&nbsp;王乐天&nbsp;
					</td>
				</tr>
				<tr>
					<td class="row">
						<input type="checkbox" name="course_key" value="影视鉴赏_1">
					</td>
					<td class="row">
						&nbsp;影视鉴赏&nbsp;
					</td>
					<td class="row">
						&nbsp;1&nbsp;
					</td>
					<td class="row">
						&nbsp;公共选修&nbsp;
					</td>
					<td class="row">
						&nbsp;考查&nbsp;
					</td>
					<td class="row">
						&nbsp;谭思琴&nbsp;
					</td>
				</tr>
				<tr>
					<td class="row">
						<input type="checkbox" name="course_key" value="艺术表演_1">
					</td>
					<td class="row">
						&nbsp;艺术表演&nbsp;
					</td>
					<td class="row">
						&nbsp;1&nbsp;
					</td>
					<td class="row">
						&nbsp;公共选修&nbsp;
					</td>
					<td class="row">
						&nbsp;考查&nbsp;
					</td>
					<td class="row">
						&nbsp;王小玲&nbsp;
					</td>
				</tr>
				<tr>
					<td class="row">
						<input type="checkbox" name="course_key" value="软件工程_5">
					</td>
					<td class="row">
						&nbsp;软件工程&nbsp;
					</td>
					<td class="row">
						&nbsp;5&nbsp;
					</td>
					<td class="row">
						&nbsp;专业必修&nbsp;
					</td>
					<td class="row">
						&nbsp;实操&nbsp;
					</td>
					<td class="row">
						&nbsp;洛锋明&nbsp;
					</td>
				</tr>
				<tr>
					<td class="row">
						<input type="checkbox" name="course_key" value="数据库应用_2">
					</td>
					<td class="row">
						&nbsp;数据库应用&nbsp;
					</td>
					<td class="row">
						&nbsp;2&nbsp;
					</td>
					<td class="row">
						&nbsp;专业选修&nbsp;
					</td>
					<td class="row">
						&nbsp;考试&nbsp;
					</td>
					<td class="row">
						&nbsp;杨思明&nbsp;
					</td>
				</tr>
				
				
			</table>
			<br>
		</form>

	</body>
</html>
