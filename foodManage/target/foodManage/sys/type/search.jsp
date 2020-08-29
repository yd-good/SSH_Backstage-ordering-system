<%@page language="java" import="java.util.*" pageEncoding="UTF-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
</head>
<body>
<!-- 页面标题 -->
<div id="TitleArea">
    <div id="TitleArea_Head"></div>
    <div id="TitleArea_Title">
        <div id="TitleArea_Title_Content">
            <img border="0" width="13" height="13"
                 src="${pageContext.request.contextPath}/sys/style/images/title_arrow.gif" /> 菜系列表
        </div>
    </div>
    <div id="TitleArea_End"></div>
</div>
<!-- 过滤条件 -->
<div id="QueryArea">
    <form action="${pageContext.request.contextPath}/foodType?"method="get">
        <input type="hidden" name="method" value="search">
        <input type="text" name="keyword" title="请输入菜系名称">
        <input type="submit" value="搜索">
    </form>
</div>

<!-- 主内容区域（数据列表或表单显示） -->
<div id="MainArea">
    <table class="MainArea_Content" align="center" cellspacing="0" cellpadding="0">
        <!-- 表头-->
        <thead>
        <tr align="center" valign="middle" id="TableTitle">
            <td>菜系编号</td>
            <td>菜系名称</td>
            <td>操作</td>
        </tr>
        </thead>
        <!--显示数据列表 -->
        <tbody id="TableData">
        <c:choose>
            <c:when test="${not empty requestScope.foodTypeList}">
                <c:forEach items="${requestScope.foodTypeList}" var="foodtype">
                    <tr>
                        <td>${foodtype.id}</td>
                        <td>${foodtype.typeName}</td>
                        <td>
                            <a href="${pageContext.request.contextPath}/foodType?id=${foodtype.id}&method=viewUpdate" class="FunctionButton">更新</a>
                            <a href="${pageContext.request.contextPath}/foodType?id=${foodtype.id}&method=delete" class="FunctionButton">删除</a>
                        </td>
                    </tr>
                </c:forEach>
            </c:when>
            <c:otherwise>
                <tr>
                    <td colspan="3">并未找到数据，请先保存数据</td>
                </tr>
            </c:otherwise>
        </c:choose>
        </tbody>
    </table>
    <!-- 其他功能超链接 -->
    <div id="TableTail" align="center">
        <div class="FunctionButton">
            <a href="${pageContext.request.contextPath}/sys/type/foodtype_sava.jsp">添加</a>
        </div>
        <div class="FunctionButton">
            <a href="${pageContext.request.contextPath}/foodType?method=list">返回</a>
        </div>
    </div>
</div>
</body>
</html>
