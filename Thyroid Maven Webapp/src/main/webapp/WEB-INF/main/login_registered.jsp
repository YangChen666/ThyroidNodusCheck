<%@page pageEncoding="utf-8"%>
<%@page isELIgnored="false" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%String path = request.getContextPath();%>
<!-- 这个是用户注册页面 -->

<!doctype html>
<html class="no-js">
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="keywords" content="form">
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no">
    <meta name="renderer" content="webkit">
    <meta http-equiv="Cache-Control" content="no-siteapp" />
    <meta name="apple-mobile-web-app-title" content="Amaze UI" />
    <link rel="stylesheet" href="assets/css/amazeui.min.css"/>
    <link rel="stylesheet" href="assets/css/admin.css">
    <style>
  		body {background:url(assets/images/backgrounds/1.jpg)}
  		.bimg{
  			background:url(assets/images/backgrounds/1.jpg)
  			}
  			
  		.inwidth{
  			width:300px;
  		}
  		.color{
  			color:#ffffff;
  		}
  		.radio{
  			float:reft;
  		}
  		#border{
  			border:1px solid #C0C0C0;
  			border-width:1px;
  			float: left;
  			width:46%;
  		}
  		.size{
  			width:45%;
  		}
  		.tou{
  			margin:20px;
  		}
    </style>
</head>
<body>

<header class="am-topbar admin-header">

<div class="am-cf am-padding  bimg">
	<div class="am-fl am-cf"><strong class="am-text-primary am-text-lg color tou">用户注册</strong></small></div>
	<div class="am-fl am-cf"><strong class="am-text-primary am-text-lg color tou"><a href="index.do" class="color" style="color:#ffffff">|首页|</a></strong></small></div>
	<div class="am-fl am-cf"><strong class="am-text-primary am-text-lg tou"><a href="reindex.do" class="color" style="color:#ffffff">|已有账号，登录|</a></strong></small></div>
</div>

<!-- content start -->
<div class="admin-content bimg">
	<div class="am-tabs am-margin" data-am-tabs>
	<!-- 注册开始 -->
	<!-- 表单开始 -->
		<form class="am-form" action="zhuce.do" enctype="multipart/form-data" method="post">
          	<div class="am-g am-margin-top">
	            <div class="am-u-sm-2 am-text-right color">
	             	用户名
	            </div>
	            <div class="am-u-sm-4 inwidth">
	            	<input type="text" name="name" class="am-input-sm"/></td>
	            </div>
            	<div class="color"> *必填</div>
          	</div>

          	<div class="am-g am-margin-top">
	            <div class="am-u-sm-2 am-text-right color">
	             	 密码
	            </div>
	            <div class="am-u-sm-4 inwidth">
	            	<input type="password" name="password" class="am-input-sm"/>
	            </div>
            	<div class="color"> *必填</div>
          	</div>

			<div class="am-g am-margin-top">
				<div class="am-u-sm-2 am-text-right color">
					确认密码
				</div>
				<div class="am-u-sm-4 inwidth">
					<input type="password" name="confirm_psw" class="am-input-sm"/>
				</div>
				<div class="color"> *必填</div>
			</div>


			<div class="am-g am-margin-top">
				<div class="am-u-sm-2 am-text-right color">
					性别
				</div>
				<div class="color">
					<span style="margin:20px;">男：<input type="radio" name="sex" class="radio" value="m"></span>
					<span>女：<input type="radio" name="sex" class="radio" value="w"></span>
					<span class="color" style="margin:170px;">*必填</span>
				</div>

			</div>
          	
          	
          	<div class="am-g am-margin-top">
	            <div class="am-u-sm-2 am-text-right color">
	             	 手机号
	            </div>
	            <div class="am-u-sm-4 inwidth">
	            	<input type="text" name="mobile" class="am-input-sm"/>
	            </div>
            	<div class="color"> </div>
          	</div>
          	
          	
          	<div class="am-g am-margin-top">
	            <div class="am-u-sm-2 am-text-right color">
	             	 邮箱
	            </div>
	            <div class="am-u-sm-4 inwidth">
	            	<input type="text" name="email" class="am-input-sm"/>
	            </div>
            	<div class="color"> </div>
          	</div>

          	<div class="am-g am-margin-top">
	            <div class="am-u-sm-2 am-text-right color">
	             	出生日期
	            </div>
	            <div class="am-u-sm-4 inwidth">
	            	<input type="text" name="birt" class="am-input-sm"/>
	            </div>
            	<div class="color"> *格式为: xxxx-xx-xx</div>
          	</div>
        	<div class="am-u-sm-offset-2 am-u-sm-4">
          		<input type="submit" style="background:#C0C0C0;" value="注册提交" class="am-btn am-btn-primary am-btn-xs"/>
  				<span style="color:#ffff00;text-align:center;"><h2> ${zhuce} </h2></span>
  			</div>
        </form><!-- 表单结束 -->
	</div>
</div>

<script src="assets/js/jquery.min.js"></script>
<script src="assets/js/amazeui.min.js"></script>
<script src="assets/js/app.js"></script>
</body>
</html>
