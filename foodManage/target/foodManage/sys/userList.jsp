<%@ taglib prefix="s" uri="/struts-tags" %>
<%@page language="java" import="java.util.*" pageEncoding="UTF-8" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
	<!-- 包含公共的JSP代码片段 -->
	
<title>无线点餐平台</title>



<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<script type="text/javascript" src="${pageContext.request.contextPath}/sys/style/js/jquery.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/sys/style/js/page_common.js"></script>
<link href="${pageContext.request.contextPath}/sys/style/css/common_style_blue.css" rel="stylesheet" type="text/css">
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/sys/style/css/index_1.css" />
	<script type="text/javascript">
		setInterval(function(){
			window.location.href = "${pageContext.request.contextPath}/sys/wirelessplatform/client.jsp?method=list";
		},1000 * 50);
	</script>
    <script type="text/javascript">
        function addUser() {

        }
    </script>
</head>
<body>
	<!-- 页面标题 -->
	<div id="TitleArea">
		<div id="TitleArea_Head"></div>
		<div id="TitleArea_Title">
			<div id="TitleArea_Title_Content">
				<img border="0" width="13" height="13"
					src="${pageContext.request.contextPath}/sys/style/images/title_arrow.gif" /> 餐厅订单列表
			</div>
		</div>
		<div id="TitleArea_End"></div>
	</div>

	<!-- 主内容区域（数据列表或表单显示） -->
	<div id="MainArea">
		<table class="MainArea_Content" align="center" cellspacing="0" cellpadding="0">
			<!-- 表头-->
			<thead>
				<tr align="center" valign="middle" id="TableTitle">
					<td>员工编号</td>
					<td>员工名称</td>
					<td>员工邮箱</td>
					<td>员工权限</td>
					<td>操作</td>
				</tr>
			</thead>
			<!--显示数据列表 -->
			<tbody id="TableData">
                 <s:if test="%{maps!=null}">
                     <s:iterator status="index"  value="maps" var="map" >
			 		<tr height="60" align="center" valign="middle" id="TableTitle">
				 		<td><s:property value="#index.index+1"/></td>
				 		<td><s:property value="#map.key.userName"/></td>
				 		<td><s:property value="#map.key.email"/></td>
				 		<td><s:property value="#map.value.role_Name"/></td>
				 		<td>
							  <input type="button" onclick="" value="修改权限">
				 		</td>
			 		</tr>
                     </s:iterator>
                 </s:if>
			</tbody>
		</table>
		<!-- 其他功能超链接 -->
		<div id="TableTail" align="center">
            <input type="button" onclick="javascript:window.location.href='${pageContext.request.contextPath}/user_inRegister.action'" value="添加管理员" style="color: green">
		</div>
	</div>
</body>
</html>
