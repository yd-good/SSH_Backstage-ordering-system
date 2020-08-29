<%@ taglib prefix="s" uri="/struts-tags" %>
<%@page language="java" import="java.util.*" pageEncoding="UTF-8" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3c.org/TR/1999/REC-html401-19991224/loose.dtd">
<html>
<head>
 	<!-- 包含公共的JSP代码片段 -->
	
<title>无线点餐平台</title>
<style>
	#yes{
		display:none;
		position: absolute;
		left: 360px;
		top: 95px;
	}
	#error{
		display:none;
		position: absolute;
		left: 360px;
		top: 95px;
	}
</style>


<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<script type="text/javascript" src="${pageContext.request.contextPath}/sys/style/js/jquery.js"></script>
<script type="text/javascript" src="s${pageContext.request.contextPath}/sys/tyle/js/page_common.js"></script>
<link href="${pageContext.request.contextPath}/sys/style/css/common_style_blue.css" rel="stylesheet" type="text/css">
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/sys/style/css/index_1.css" />
    <script type="text/javascript">
	function openWin(){
		window.open('common_page_list.html');
		this.close();
	}
	</script>
	<script type="text/javascript">
		var rfsult="true";
		function uniqueName(){
			var tableName=$("#tableName").val();
			if (tableName!=""){
				$.ajax({
				url:"${pageContext.request.contextPath}/table_uniqueName.action",
				data:{"table.tableName":tableName},
				type:"post",
				async:false,
				success:function (mgs) {
					if ("true"==mgs){
						document.getElementById("yes").style.display="block";
						document.getElementById("error").style.display="none";
						rfsult="true";
					}else {
						document.getElementById("yes").style.display="none";
						document.getElementById("error").style.display="block";
						rfsult="false";
					}
				}
				});
			}
		}
      function addSubmit(){
			uniqueName();
			if (rfsult=="true"){
				document.forms[0].submit();
			}else {
				alert("名字已经存在，不能添加");
				return false;
			}
	  }
	</script>
</head>

<body>
<!-- 页面标题 -->
<div id="TitleArea">
	<div id="TitleArea_Head"></div>
	<div id="TitleArea_Title">
		<div id="TitleArea_Title_Content">
			<img border="0" width="13" height="13" src="${pageContext.request.contextPath}/sys/style/images/title_arrow.gif"/>  添加新桌
		</div>
    </div>
	<div id="TitleArea_End"></div>
</div>


<!-- 主内容区域（数据列表或表单显示） -->
<div id="MainArea">
	<!-- 表单内容 -->
	<form action="table_add.action">
		<!-- 本段标题（分段标题） -->
		<div class="ItemBlock_Title">
        	<img width="4" height="7" border="0" src="${pageContext.request.contextPath}/sys/style/images/item_point.gif"> 新桌信息&nbsp;
        </div>
		<!-- 本段表单字段 -->
        <div class="ItemBlockBorder">
            <div class="ItemBlock">
				<div class="ItemBlock2">
					<table cellpadding="0" cellspacing="0" class="mainForm">
						<tr>
							<td width="80px">新桌名字</td>
							<td><s:textfield name="table.tableName" onchange="uniqueName()" id="tableName"/><div id="yes"><img src="${pageContext.request.contextPath}/comImg/yes.jpg" width="20px" height="20px"></div><div id="error"><img src="${pageContext.request.contextPath}/comImg/error.jpg" width="20px" height="20px"></div></td>
						</tr>
						<tr>
							<td width="80px">新桌状态</td>
							<td><s:select name="table.tableStatus" list="#{'1':'约定','0':'未预定'}"/></td>
						</tr>
						<tr>
							<td width="80px">预订时间</td>
							<td><s:textfield name="table.date"/></td>
						</tr>
					</table>
				</div>
            </div>
        </div>
		
		<!-- 表单操作 -->
		<div id="InputDetailBar">
			<input type="button" value="添加" class="FunctionButtonInput" onclick="addSubmit()">
            <a href="javascript:history.go(-1);" class="FunctionButton">返回</a>
        </div>
	</form>
	
</div>

</body>
</html>
