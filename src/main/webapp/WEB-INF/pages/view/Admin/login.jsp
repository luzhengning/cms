<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>登录</title>
<script src="../static/jQuery/jquery-1.11.1.min.js" type="text/javascript"></script>
</head>
<body>
<a href="/cms/user/login">请登录</a>
 <div id="loginpanelwrap">
        <div>
            <div>登录</div>
        </div>
        <form action="/cms/user/login">
            <div>
                <div>
                    <label>用户名:</label>
                    <input type="text" name="username" />
                </div>
            </div>
            <div>
                <label>密码：</label>
                <input type="password" name="password" />
            </div>
            <div>
                <label>验证码:</label>
                <input type="text" name="validationCode"/>
                <img id="validationCode_img"  src="validateCode">
            </div>
            <div>
                <span></span>
                <input type="submit" id="loginform_submit" value="登录" />
            </div>
        </form>
    </div>
    <script type="text/javascript">
    $(function(){
        $("#loginform_submit").click(function(){
                $("form").action("/cms/user/login");
        }
        );
    });
    $("#validationCode_img").click(function(){
        $("#validationCode_img").attr("src","/cms/open/validate/code?"+Math.random());
    }
    );
    function checkInput(){
        //判断用户名
        if($("input[name=username]").val()==null || $("input[name=username]").val()==""){
            alert("用户名不能等于空");
            $("input[name=username]").focus();
            return false;
        }
        //判断密码
        if($("input[name=password]").val()==null || $("input[name=password]").val()==""){
            alert("密码不能等于空");
            $("input[name=password]").focus();
            return false;
        }
        //判断验证码
        if($("input[name=validationCode]").val()==null || $("input[name=validationCode]").val()==""){
            alert("验证码不能为空");
            $("input[name=validationCode]").focus();
            return false;
        }
        return false;
    }
    </script>
</body>
</html>