<%@page pageEncoding="utf-8"%>
<%@page isELIgnored="false" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

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
</head>
<body>

<header class="am-topbar admin-header">

<div class="admin-content">
	<div class="am-cf am-padding">
   			 <div class="am-fl am-cf"><strong class="am-text-primary am-text-lg">分类</strong> / <small>第二层</small></div>
  	</div>
	<div class="am-tabs am-margin" data-am-tabs>
	
		
		<div> <!-- 这个是主div -->
			<div style="border:2px solid #C0C0C0;padding:10px;width:50%;float:left;"> <!-- 这个是放图像的 -->
				<img src="Thyroid_images/${image_name }">
			</div>
			
			<div style="border:2px solid #C0C0C0;padding:10px;width:49%;float:left;height:48%;margin-left:2px;height:450px;"> <!-- 这个是放信息的 -->
				<!-- 这里是图像信息 -->
	          	<div class="am-g am-margin-top" style="width:100%;">
		            <div>
		             	<span style="font-weight:bold">甲状腺超声图像分类介绍：</span>
		            </div>
		            <div style="margin:20px;">
			        	<p>
							有三个分类方式即三级分类，三级分类分别是由广到细，具有层次：
							<p>1.第一个层次：正常与结节 预测</p>
							<p>2.第二个层次：良性结节与恶性结节 预测</p>
							<p>3.第三个层次：初步恶化与高度恶化 预测</p>	
						</p>
		        	</div>
		        </div>
		        <div class="am-g am-margin-top" style="width:100%;">
		            <div>
		             	<span style="font-weight:bold;margin:0;">分类结果：</span>
		            </div>
		            <div style="margin:20px;">
			        	<p>
							<p>您只对第三层次做了预测</p>
							<p>结果：${ls }</p>
							<p>注：以上分类结果仅供参考，请以医生诊断结果为主。</p>	
						</p>
						
		        	</div>
		        </div>
		        
			</div>
		
		</div>
	</div>
</div>
<script src="assets/js/jquery.min.js"></script>
<script src="assets/js/amazeui.min.js"></script>
<script src="assets/js/app.js"></script>
</body>
</html>

