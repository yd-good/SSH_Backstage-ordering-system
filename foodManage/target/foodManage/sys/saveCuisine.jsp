<%@ taglib prefix="s" uri="/struts-tags" %>
<%@page import="java.util.*" language="java" contentType="text/html;charset=utf-8" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
    <!-- 包含公共的JSP代码片段 -->
	
<title>无线点餐平台</title>

<style type="text/css">
    #showFood{
        width: 100px;
        height: 200px;
        display: none;
    }
     #yes{
         display:none;
         position: absolute;
         left: 335px;
         top: 95px;
     }
    #error{
        display:none;
        position: absolute;
        left: 335px;
        top: 95px;
    }
    .addFood{
        display: none;
    }
</style>

<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<script type="text/javascript" src="${pageContext.request.contextPath}/sys/style/js/jquery.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/sys/style/js/page_common.js"></script>
<link href="${pageContext.request.contextPath}/sys/style/css/common_style_blue.css" rel="stylesheet" type="text/css">
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/sys/style/css/index_1.css" />
    <script type="text/javascript">
        var rfsult=null;
        function uniqueTypeName() {
            var typeName = $("#foodTypeName").val();
            if (typeName!=""){
                $.ajax({
                    url:"${pageContext.request.contextPath}/foodType_uniqueName.action",
                    data:{"foodType.foodName":typeName},
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

                })
            }
        }
        function addFoodType() {
              uniqueTypeName();
            if (rfsult=="true"){
             document.forms[0].submit();
            }else{
                alert("所添加菜系已经存在");
                return false;
            }
        }
        function confirmFood() {
            $(".addFood").show();
        }
    </script>
</head>
<body>


<!-- 页面标题 -->
<div id="TitleArea">
	<div id="TitleArea_Head"></div>
	<div id="TitleArea_Title">
		<div id="TitleArea_Title_Content">
			
				
				
					<img border="0" width="13" height="13" src="style/images/title_arrow.gif"/>  添加菜系
				
			
		</div>
    </div>
	<div id="TitleArea_End"></div>
</div>


<!-- 主内容区域（数据列表或表单显示） -->
<div id="MainArea">
	<!-- 表单内容 -->
	<form action="${pageContext.request.contextPath}/foodType_saveFoodType.action" method="post" enctype="multipart/form-data">
	
		<!-- 本段标题（分段标题） -->
		<div class="ItemBlock_Title">
        	<img width="4" height="7" border="0" src="style/images/item_point.gif"> 菜系信息&nbsp;
        </div>
		<!-- 本段表单字段 -->
        <div class="ItemBlockBorder">
            <div class="ItemBlock">
				<div class="ItemBlock2">
					<table cellpadding="0" cellspacing="0" class="mainForm" align="center">
						<tr>
							<td width="80px">菜系名称</td>
							<td>
								<s:textfield name="foodType.foodName" id="foodTypeName" onchange="uniqueTypeName()"/><div id="yes"><img src="${pageContext.request.contextPath}/comImg/yes.jpg" width="20px" height="20px"></div><div id="error"><img src="${pageContext.request.contextPath}/comImg/error.jpg" width="20px" height="20px"></div>
							</td>
                            <td><input type="button" value="添加" class="FunctionButtonInput" onclick="addFoodType()">
                                <a href="javascript:history.go(-1);" class="FunctionButton">返回</a>
                            </td>
                            <td><input type="button"class="FunctionButton" value="添加菜品"style="height: 20px;color:blue;" onclick="confirmFood()"></td>
						</tr>
                        <tbody class="addFood">
                          <tr>
                              <td width="80px">菜品名称</td>
                              <td >
                                  <s:textfield name="dishes.foodName"/>
                              </td>
                          </tr>
                            <tr>
                                <td width="80px">菜品价格</td>
                                <td>
                                    <s:textfield name="dishes.foodPrice"/>
                                </td>
                            </tr>
                            <tr>
                                <td width="80px">会员价格</td>
                                <td>
                                    <s:textfield name="dishes.memberPrice"/>
                                </td>
                            </tr>
                            <tr>
                                <td width="80px">菜品简介</td>
                                <td>
                                    <s:textfield name="dishes.introduction"/>
                                </td>
                            </tr>
                            <tr>
                                <td width="80px">样式图片</td>
                                <td>
                                   <input type="file" name="headImg">
                                </td>
                            </tr>
                        </tbody>
					</table>
				</div>
            </div>
		<!-- 表单操作 -->
		<div id="InputDetailBar">

        </div>
	</form>
</div>
</body>
</html>
