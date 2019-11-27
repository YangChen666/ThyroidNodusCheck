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
   			 <div class="am-fl am-cf"><strong class="am-text-primary am-text-lg">去噪</strong> / <small>图像展示</small></div>
  		</div>
	<div class="am-tabs am-margin" data-am-tabs>
	
		
		<div> <!-- 这个是主div -->
			<div style="border:2px solid #C0C0C0;padding:10px;width:50%;float:left;"> <!-- 这个是放图像的 -->
				<img src="Thyroid_images/${image_name }">
			</div>
			<div style="border:2px solid #C0C0C0;padding:10px;width:49%;float:left;height:48%;margin-left:2px;"> <!-- 这个是放信息的 -->
				<!-- 这里是图像信息 -->
				
				<div class="am-g am-margin-top" style="width:100%;">
		            <div>
		             	 <span style="font-weight:bold">文件名称:</span><span>${image.name}</span>
		            </div>
          		</div>
          	
          	
          	
          	<div class="am-g am-margin-top" style="width:100%;">
	            <div>
	             	<span style="font-weight:bold">部位信息:</span> <span>${image.part}</span>
	            </div>
          	</div>
          	
          	
          	<div class="am-g am-margin-top" style="width:100%;">
	            <div>
	             	<span style="font-weight:bold">图片描述:</span> <span>${image.descr}</span>
	            </div>
          	</div>
          	
          	
          	<div class="am-g am-margin-top" style="width:100%;">
	            <div>
	             	<span style="font-weight:bold">诊断结果:</span> <span>${image.result}</span>
	            </div>
	        </div>
          	
          	
          	<div class="am-g am-margin-top" style="width:100%;">
	            <div>
	             	<span style="font-weight:bold">图像说明:</span> <span>${image.inst}</span>
	            </div>
          	</div>	
          		<form action="quzao.do">
					<input type="submit" value="去噪处理"/>
				</form> 
			</div>
		
		</div>

</div>
</div>
<script src="assets/js/jquery.min.js"></script>
<script src="assets/js/amazeui.min.js"></script>
<script src="assets/js/app.js"></script>
</body>
</html>

