<%@page language="java" import="java.util.*" pageEncoding="UTF-8" %>
<%pageContext.setAttribute("basePath",request.getContextPath());%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>网上订餐后台菜品管理</title>
</head>
	<frameset rows="100px,*,19px" framespacing="0" border="0" frameborder="0">
		<frame src="${basePath}/sys/public/top.jsp" scrolling="no" noresize />
		<frameset cols="178px,*">
			<frame noresize src="${basePath}/sys/public/left.jsp" scrolling="yes" />
			<frame noresize name="right" src="${basePath}/sys/public/right.jsp" scrolling="yes" />
		</frameset>
		<frame noresize name="status_bar" scrolling="no" src="${basePath}/sys/public/bottom.jsp" />
	</frameset>
</html>