<%@ taglib prefix="s" uri="/struts-tags" %>

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
			
				
					<img border="0" width="13" height="13" src="${pageContext.request.contextPath}/sys/style/images/title_arrow.gif"/> 更新新菜品
				
				
			
		</div>
    </div>
	<div id="TitleArea_End"></div>
</div>

<!-- 主内容区域（数据列表或表单显示） -->
<div id="MainArea">
	<!-- 表单内容 -->
	<form action="${pageContext.request.contextPath}/foodType_updateDishes.action" method="post" enctype="multipart/form-data">
		<!-- 本段标题（分段标题） -->
		<div class="ItemBlock_Title">
        	<img width="4" height="7" border="0" src="${pageContext.request.contextPath}/sys/style/images/item_point.gif"> 菜品信息&nbsp;
        </div>
		<!-- 本段表单字段 -->
<%--		private String id;--%>
<%--		private String foodName;--%>
<%--		private double foodPrice;--%>
<%--		private double memberPrice;--%>
<%--		private String introduction;--%>
<%--		private String img;--%>
<%--		private FoodType foodType;--%>
        <div class="ItemBlockBorder">
            <div class="ItemBlock">
				<div class="ItemBlock2">
					<table cellpadding="0" cellspacing="0" class="mainForm">
                    <tr>
							<td width="80px">菜系</td>
							<td>
<%--                                <s:select--%>
<%--                                        name="deptId"--%>
<%--                                        list="#request.deptList"--%>
<%--                                        listKey="id"--%>
<%--                                        listValue="name"--%>
<%--                                        value="dept.id"--%>
<%--                                ></s:select>--%>
                                <s:select list="foodTypes"
                                          name="foodType.id"
                                          listValue="foodName"
                                          listKey="id"
                                 ></s:select>
							</td>
						</tr>
						<tr>
							<td width="80px">菜名</td>
							<s:hidden name="dishes.id"></s:hidden>
							<td><s:textfield name="dishes.foodName"/></td>
						</tr>
						<tr>
							<td>价格</td>
							<td><s:textfield name="dishes.foodPrice"/></td>
						</tr>
                        <tr>
							<td>会员价格</td>
							<td><s:textfield name="dishes.memberPrice"/></td>
						</tr>
						
						<tr>
							<td>简介</td>
							<td><s:textarea name="dishes.introduction" rows="6" class="50"/></td>
						</tr>
						<tr>
							<td width="80px">菜品图片</td>
							<td>
								<s:if test="%{dishes.img!=null&&dishes.img!=''}">
									<img style='max-width:68px;width:68px;width:expression(width>68?"68px":width "px");max-width: 68px;' 
									src="${pageContext.request.contextPath}/upload/<s:property value="dishes.img"/>">
									<s:hidden name="dishes.img"></s:hidden>
								</s:if>
								<input type="file" name="headImg"/>
							</td>
						</tr>
					</table>
				</div>
            </div>
        </div>
		
		
		<!-- 表单操作 -->
		<div id="InputDetailBar">
            
				
					 <input type="submit" value="修改" class="FunctionButtonInput">
				
				
			
            
            <a href="javascript:history.go(-1);" class="FunctionButton">返回</a>
        </div>
	</form>
</div>
</body>
</html>
