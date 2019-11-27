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

<!-- sidebar end -->

<!-- content start -->
<div class="admin-content">
	<div class="am-cf am-padding">
   			 <div class="am-fl am-cf"><strong class="am-text-primary am-text-lg">调整对比度之后</strong> / <small>图像展示</small></div>
  		</div>
	<div class="am-tabs am-margin" data-am-tabs>
	
		
		<div> <!-- 这个是主div -->
			<div style="border:2px solid #C0C0C0;padding:10px;width:50%;float:left;"> <!-- 这个是放图像的 -->
				<p>调整对比度后图像</p>
				<img src="Thyroid_images/${image_name }">
			</div>
			<div style="border:2px solid #C0C0C0;padding:10px;width:50%;float:left;"> <!-- 这个是放图像的 -->
				<p>调整对比度前图像</p>
				<img src="Thyroid_images/${name_qian }">
			</div>
		
		</div>

</div>
</div>
<script src="assets/js/jquery.min.js"></script>
<script src="assets/js/amazeui.min.js"></script>
<script src="assets/js/app.js"></script>
</body>
</html>
