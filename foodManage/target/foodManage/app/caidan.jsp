﻿<%@page import="java.util.*" pageEncoding="UTF-8" language="java" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
	<!-- 包含公共的JSP代码片段 -->
	
<title>无线点餐平台</title>



<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<script type="text/javascript" src="${pageContext.request.contextPath}/app/style/js/jquery.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/app/style/js/page_common.js"></script>
<link href="style/css/common_style_blue.css" rel="stylesheet" type="text/css">
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/app/style/css/index_1.css" />
	<link href="${pageContext.request.contextPath}/app/style/css/index.css" rel="stylesheet" type="text/css" />
</head>
<body style="text-align: center">
	<div id="all">
		<div id="menu">
			<!-- 显示菜品的div -->
			<div id="top">
				<ul>
					<!-- 循环列出餐品 -->
					
						<li>
							<dl>
								<dt>
									<a href="${pageContext.request.contextPath}/app/caixiangxi.jsp">
										<img width="214px" height="145px" src="${pageContext.request.contextPath}/app/style/images/baizhuoxia.jpg" />
									</a>
								</dt>
								<dd class="f1">
									<a href="${pageContext.request.contextPath}/app/caixiangxi.jsp">白灼虾</a>
								</dd>
								<dd class="f2">
									<a href="${pageContext.request.contextPath}/app/caixiangxi.jsp">&yen;36.0</a>
								</dd>
							</dl>
						</li>
					
						<li>
							<dl>
								<dt>
									<a href="${pageContext.request.contextPath}/app/caixiangxi.jsp">
										<img width="214px" height="145px" src="${pageContext.request.contextPath}/app/style/images/baiqieji.jpg" />
									</a>
								</dt>
								<dd class="f1">
									<a href="${pageContext.request.contextPath}/app/caixiangxi.jsp">白切鸡</a>
								</dd>
								<dd class="f2">
									<a href="${pageContext.request.contextPath}/app/caixiangxi.jsp">&yen;68.0</a>
								</dd>
							</dl>
						</li>
					
						<li>
							<dl>
								<dt>
									<a href="${pageContext.request.contextPath}/app/caixiangxi.jsp">
										<img width="214px" height="145px" src="${pageContext.request.contextPath}/app/style/images/kaoruzhu.JPG" />
									</a>
								</dt>
								<dd class="f1">
									<a href="${pageContext.request.contextPath}/app/caixiangxi.jsp">烤乳猪</a>
								</dd>
								<dd class="f2">
									<a href="${pageContext.request.contextPath}/app/caixiangxi.jsp">&yen;68.0</a>
								</dd>
							</dl>
						</li>
					
						<li>
							<dl>
								<dt>
									<a href="${pageContext.request.contextPath}/app/caixiangxi.jsp">
										<img width="214px" height="145px" src="style/images/shaoe.jpg" />
									</a>
								</dt>
								<dd class="f1">
									<a href="${pageContext.request.contextPath}/app/caixiangxi.jsp">烧鹅</a>
								</dd>
								<dd class="f2">
									<a href="${pageContext.request.contextPath}/app/caixiangxi.jsp">&yen;68.0</a>
								</dd>
							</dl>
						</li>
					
						<li>
							<dl>
								<dt>
									<a href="${pageContext.request.contextPath}/app/caixiangxi.jsp">
										<img width="214px" height="145px" src="${pageContext.request.contextPath}/app/style/images/helandou.jpg" />
									</a>
								</dt>
								<dd class="f1">
									<a href="${pageContext.request.contextPath}/app/caixiangxi.jsp">猪肉荷兰豆</a>
								</dd>
								<dd class="f2">
									<a href="${pageContext.request.contextPath}/app/caixiangxi.jsp">&yen;68.0</a>
								</dd>
							</dl>
						</li>
					
						<li>
							<dl>
								<dt>
									<a href="${pageContext.request.contextPath}/app/caixiangxi.jsp">
										<img width="214px" height="145px" src="${pageContext.request.contextPath}/app/style/images/huangbuchaodan.jpg" />
									</a>
								</dt>
								<dd class="f1">
									<a href="${pageContext.request.contextPath}/app/caixiangxi.jsp">黄埔炒蛋</a>
								</dd>
								<dd class="f2">
									<a href="${pageContext.request.contextPath}/app/caixiangxi.jsp">&yen;68.0</a>
								</dd>
							</dl>
						</li>
					
				</ul>
			</div>
			
			<!-- 底部分页导航条div -->
			<div id="foot">
				
					
					
						<span
							style="float:left; line-height:53PX; margin-left:-50px; font-weight:bold; ">
							<span style="font-weight:bold">&lt;&lt;</span>
						</span>
					
				
				<div id="btn">
					<ul>
						<!-- 参看 百度, 谷歌是 左 5 右 4 -->
						
							<li><a
								href="#">1</a></li>
						
							<li><a
								href="#">2</a></li>
						
					</ul>
				</div>
				
					
						<span style="float:right; line-height:53px; margin-right:10px;  ">
							<a
							href="#"
							style=" text-decoration:none;color:#000000; font-weight:bold">&gt;&gt;</a>
						</span>
					
					
				
			</div>
			
		</div>

		<!-- 右边菜系列表，菜品搜索框  -->
		<div id="dish_class">
			<div id="dish_top">
				<ul>
				<li class="dish_num"></li>
					<li>
						<a href="${pageContext.request.contextPath}/app/clientOrderList.jsp">
							<img src="${pageContext.request.contextPath}/app/style/images/call2.gif" />
						</a>
					</li>
				</ul>
			</div>

			<div id="dish_2">
				<ul>
					
						<li>
							<a href="${pageContext.request.contextPath}/app/caidan.jsp">粤菜</a>
						</li>
					
						<li>
							<a href="${pageContext.request.contextPath}/app/chuancai.jsp">川菜</a>
						</li>
					
						<li>
							<a href="${pageContext.request.contextPath}/app/chuancai.jsp">湘菜</a>
						</li>
					
						<li>
							<a href="${pageContext.request.contextPath}/app/chuancai.jsp">东北菜</a>
						</li>
					
				</ul>
			</div>
			<div id="dish_3">
				<!-- 搜索菜品表单  -->
				<form action="#" method="post">
					<table width="166px">
						<tr>
							<td>
								<input type="text" id="dish_name" name="foodName" class="select_value" /> 
								<input type="hidden" value="selectFood" name="method">
							</td>
						</tr>
						<tr>
							<td><input type="submit" id="sub" value="" /></td>
						</tr>
						<tr>
							<td>
								<a href="#">
									<img src="${pageContext.request.contextPath}/app/style/images/look.gif" />
								</a>
							</td>
						</tr>
					</table>
				</form>
			</div>
		</div>
		
	</div>
</body>
</html>
