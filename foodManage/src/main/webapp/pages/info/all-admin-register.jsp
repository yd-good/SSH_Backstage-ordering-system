<%@ taglib prefix="s" uri="/struts-tags" %>
<%@page language="java" import="java.util.*" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>

<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">


    <title>Register</title>

    <style type="text/css">
        #yes{
            position: absolute;
            top: 8px;
            right: 42px;
            display: none;
            width: 20px;
            height: 20px;
            border-radius: 50%;
            background-color: #00ca6d;
        }
        #no{
            position: absolute;
            top: 8px;
            right: 42px;
            display: none;
            width: 20px;
            height: 20px;
            border-radius: 50%;
            background-color: red;
        }
    </style>
    <!-- Tell the browser to be responsive to screen width -->
    <meta content="width=device-width,initial-scale=1,maximum-scale=1,user-scalable=no" name="viewport">
    <!-- Bootstrap 3.3.6 -->
    <!-- Font Awesome -->
    <!-- Ionicons -->
    <!-- Theme style -->
    <!-- iCheck -->
    <!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
    <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
    <!--[if lt IE 9]>
  <![endif]-->
    <script type="text/javascript" src="${pageContext.request.contextPath}/sys/style/js/jquery.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/sys/style/js/page_common.js"></script>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/pages/plugins/bootstrap/css/bootstrap.min.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/pages/plugins/font-awesome/css/font-awesome.min.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/pages/plugins/ionicons/css/ionicons.min.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/pages/plugins/adminLTE/css/AdminLTE.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/pages/plugins/iCheck/square/blue.css">
    <script type="text/javascript">
        //校验账号唯一
        var  fResult=true;
        function addDiVerify(){
            var yes=document.getElementById("yes");
            var no=document.getElementById("no");
            var account=$("#emails").val();
            if (account!=""&&account!=null){
                //2.校验 get post getJson ajax
                $.ajax({
                    url:"user_verifyAccount.action",
                    data:{"user.email":account},
                    type:"post",
                    async:false,//非异步
                    success:function (msg) {
                        if ("true"==msg&&account!="") {
                            no.style.display="block";
                            yes.style.display="none";
                            fResult=false;
                        }else {
                            no.style.display="none";
                            yes.style.display="block";
                            fResult=true;
                        }
                    }
                });
            }
        }
        //提交表单
        function addSubmit(){
            addDiVerify()
            if (fResult){
                document.forms[0].submit();
            } else {
                alert("账号已经存在，请重新输入")
                return false;
            }
        }
    </script>
</head>

<body class="hold-transition register-page">
    <div class="register-box">
        <div class="register-logo">


            <a href="all-admin-index.html"><b>后台数据</b>管理系统</a>


        </div>

        <div class="register-box-body">
            <p class="login-box-msg">新用户注册</p>

            <form action="user_register.action" method="post">
                <div class="form-group has-feedback">
                    <input type="text" class="form-control" placeholder="全名" name="userName">
                    <span class="glyphicon glyphicon-user form-control-feedback"></span>
                </div>
                <div class="form-group has-feedback">
                    <input type="email" class="form-control" placeholder="Email" name="email" id="emails" onchange="addDiVerify()"><div id="no"></div><div id="yes"></div>
                    <span class="glyphicon glyphicon-envelope form-control-feedback"></span>
                </div>
                <div class="form-group has-feedback">
                    <input type="password" class="form-control" placeholder="密码" name="passWord">
                    <span class="glyphicon glyphicon-lock form-control-feedback"></span>
                </div>
                <div class="form-group has-feedback">
                    <s:checkboxlist list="roles" listKey="role_Id" listValue="role_Name" name="roleIds"/>
                    <span class="glyphicon glyphicon-log-in form-control-feedback"></span>
                </div>
                <div class="row">
                    <div class="col-xs-8">
                        <div class="checkbox icheck">
                            <label>
            </label>
                        </div>
                    </div>
                    <!-- /.col -->
                    <div class="col-xs-4">
                        <button type="button" onclick="addSubmit()"  class="btn btn-primary btn-block btn-flat">注册</button>
                    </div>
                    <!-- /.col -->
                </div>
            </form>
    <!-- /.register-box -->

    <!-- jQuery 2.2.3 -->
    <!-- Bootstrap 3.3.6 -->
    <!-- iCheck -->
    <script src="../plugins/jQuery/jquery-2.2.3.min.js"></script>
    <script src="../plugins/bootstrap/js/bootstrap.min.js"></script>
    <script src="../plugins/iCheck/icheck.min.js"></script>
    <script>
        $(function() {
            $('input').iCheck({
                checkboxClass: 'icheckbox_square-blue',
                radioClass: 'iradio_square-blue',
                increaseArea: '20%' // optional
            });
        });
    </script>
</body>

</html>