<%@ taglib prefix="s" uri="/struts-tags" %>
<%@page language="java" import="java.util.*" pageEncoding="UTF-8" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3c.org/TR/1999/REC-html401-19991224/loose.dtd">
<html>
<head>
 	<!-- 包含公共的JSP代码片段 -->
	
<title>无线点餐平台</title>



<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<script type="text/javascript" src="${pageContext.request.contextPath}/sys/style/js/jquery.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/sys/style/js/page_common.js"></script>
<link href="${pageContext.request.contextPath}/sys/style/css/common_style_blue.css" rel="stylesheet" type="text/css">
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/sys/style/css/index_1.css" />
</head>
<body>
<!-- 页面标题 -->
<div id="TitleArea">
	<div id="TitleArea_Head"></div>
	<div id="TitleArea_Title">
		<div id="TitleArea_Title_Content">
			<img border="0" width="13" height="13" src="${pageContext.request.contextPath}/sys/style/images/title_arrow.gif"/> 餐桌列表
		</div>
    </div>
	<div id="TitleArea_End"></div>
</div>


<!-- 过滤条件 -->
<div id="QueryArea">
	<form action="${pageContext.request.contextPath}/sys//wirelessplatform/board.jsp" method="get">
		<input type="hidden" name="method" value="search">
		<input type="text" name="keyword" title="请输入餐桌名称">
		<input type="submit" value="搜索">
	</form>
</div>


<!-- 主内容区域（数据列表或表单显示） -->
<div id="MainArea">
    <table class="MainArea_Content" cellspacing="0" cellpadding="0">
        <!-- 表头-->
        <thead>
            <tr align="center" valign="middle" id="TableTitle">
				<td>编号</td>
				<td>桌名</td>
				<td>状态</td>
				<td>预定时间</td>
				<td>操作</td>
			</tr>
		</thead>	
		<!--显示数据列表 -->
        <tbody id="TableData">
		<s:iterator value="tables" status="st">
			<tr class="TableDetail1" <s:if test="#st.odd">bgcolor="gray"</s:if>>
<%--				使用status的index来排序--%>
				<td align="center"><s:property value="#st.index+1"/></td>
				<td align="center"><s:property value="tableName"/></td>
				<td align="center"><s:if test='%{tableStatus==0}'>未预定</s:if><s:else>已约定</s:else></td>
				<td align="center"><s:date name="date" format="yyyy-MM-hh HH:mm:ss"/></td>
				<td>
					<a href="${pageContext.request.contextPath}/table_retreat.action?table.id=<s:property value="id"/>" class="FunctionButton">退桌</a>
					<a href="${pageContext.request.contextPath}/table_order.action?table.id=<s:property value="id"/>" class="FunctionButton">订桌</a>
					<a href="${pageContext.request.contextPath}/table_delete.action?table.id=<s:property value="id"/>" onClick="return delConfirm();"class="FunctionButton">删除</a>
				</td>
			</tr>
		</s:iterator>
        </tbody>
    </table>
	
   <!-- 其他功能超链接 -->
	<div id="TableTail" align="center">
		<div class="FunctionButton"><a href="${pageContext.request.contextPath}/sys/saveBoard.jsp">添加</a></div>
    </div> 
</div>
</body>
</html>
