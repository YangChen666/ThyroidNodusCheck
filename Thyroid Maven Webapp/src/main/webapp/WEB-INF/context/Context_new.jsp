<%@page pageEncoding="utf-8"%>
<%@page isELIgnored="false" %>

<!doctype html>
<html class="no-js">
<head>
  <meta charset="utf-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <meta name="description" content="这是一个form页面">
  <meta name="keywords" content="form">
  <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no">
  <meta name="renderer" content="webkit">
  <meta http-equiv="Cache-Control" content="no-siteapp" />
  <meta name="apple-mobile-web-app-title" content="Amaze UI" />
  <link rel="stylesheet" href="assets/css/amazeui.min.css"/>
  <link rel="stylesheet" href="assets/css/admin.css">
  <style type="text/css">
  		.context_s{
  			margin-left:4%;
  		}
  		
  		.div1{
  			font-size:18px;
  		}
  		.suo{
  			margin-left:4%;
  		}
  		.suo2{
  			margin-left:4%;
  		}
  </style>
</head>
<body>
	<header class="am-topbar admin-header">
		<div class="admin-content">
			<div class="am-tabs am-margin" data-am-tabs>
				<div class="am-cf am-padding">
		   			 <div class="am-fl am-cf"><strong class="am-text-primary am-text-lg">home</strong> / <small>使用导航</small></div>
		  		</div>	
		  	</div>
		  	<div>
				<p style="margin-left:30%;font-size:20px;font-weight:bold;">欢迎  ${userName} ,来到本系统！</p>
			</div>

			<!-- //使用 -->
			<div>
				<div style="margin-left:4%;" class="fl div1">
					<p>让我带你快速了解本系统的使用！</p>
					<p>一. 系统使用步骤：</p>
					<p class="suo">1. 获取你要预测的甲状腺超声图像
						<span class="suo2">两种方式：上传、数据库获取</span></p>
					<%--<p class="suo">2. 甲状腺超声图像裁剪--%>
						<%--<span class="suo2">除去冗余信息</span></p>--%>
					<p class="suo">2.甲状腺超声图像处理
						<span class="suo2">分别有 裁剪、去噪、亮度、对比度等处理方式</span></p>
					<p class="suo">3.结节诊断
						<span class="suo2">分为三步诊断，根据需要选择</span></p>
				</div>
				<div class="fl div2" style="margin-left:4%;" >
					<p class="div1">二. 功能结构：</p>
					<img src="img/gongn.png" alt="" class="img-responsive logo" class="div2">
					<img alt="" src="">
				</div>
			</div>
		</div>
	</header>
</body>
</html>
