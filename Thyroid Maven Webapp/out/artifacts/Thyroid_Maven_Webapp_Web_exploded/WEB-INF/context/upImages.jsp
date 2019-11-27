<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
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
</head>
<body>

<header class="am-topbar admin-header">

<!-- sidebar end -->

<!-- content start -->
<div class="admin-content">
	<div class="am-tabs am-margin" data-am-tabs>
	<!-- 表单开始 -->
		<div class="am-cf am-padding">
   			 <div class="am-fl am-cf"><strong class="am-text-primary am-text-lg">上传</strong> / <small>图像上传</small></div>
  		</div>	
		<form class="am-form" action="toupimages.do" enctype="multipart/form-data" method="post">
          	<div class="am-g am-margin-top">
	            <%--<div class="am-u-sm-2 am-text-right">--%>
	             	 <%--文件名称--%>
	            <%--</div>--%>
	            <%--<div class="am-u-sm-4">--%>
	            	<%--<input type="text" name="name" value="" class="am-input-sm"/></td>--%>
	            <%--</div>--%>
            	<%--<div class="am-u-sm-6"> 此处请填写上传之后存入的图片名称</div>--%>
          	<%--</div>--%>
          	
          	
          	
          	<div class="am-g am-margin-top">
	            <div class="am-u-sm-2 am-text-right">
	             	 部位信息
	            </div>
	            <div class="am-u-sm-4">
	            	<input type="text" name="part" class="am-input-sm"/>
	            </div>
            	<div class="am-u-sm-6"> 此处填写上传的图片是那个部位的，如 甲状腺</div>
          	</div>
          	
          	
          	<div class="am-g am-margin-top">
	            <div class="am-u-sm-2 am-text-right">
	             	 图片描述
	            </div>
	            <div class="am-u-sm-4">
	            	<input type="text" name="descr" class="am-input-sm"/>
	            </div>
            	<div class="am-u-sm-6"> 此处写图像中对图像内容的描述信息</div>
          	</div>
          	
          	
          	<div class="am-g am-margin-top">
	            <div class="am-u-sm-2 am-text-right">
	             	 诊断结果
	            </div>
	            <div class="am-u-sm-4">
	            	<input type="text" name="result" class="am-input-sm"/>
	            </div>
            	<div class="am-u-sm-6"> 此处请填写对病症的诊断结果，如甲状腺良性结节</div>
          	</div>
          	
          	
          	<div class="am-g am-margin-top">
	            <div class="am-u-sm-2 am-text-right">
	             	 图像说明
	            </div>
	            <div class="am-u-sm-4">
	            	<input type="text" name="inst" class="am-input-sm"/>
	            </div>
            	<div class="am-u-sm-6"> 此处写对图像的备注说明</div>
          	</div>
          	
          	
          	<div class="am-g am-margin-top">
	            <div class="am-u-sm-2 am-text-right">
	             	 选择文件
	            </div>
	            <div class="am-u-sm-4">
	            	<input type="file" name="file" class="am-input-sm">
	            </div>
            	<div class="am-u-sm-6"> 选择要上传的文件</div>
          	</div>
          	
          	<div class="am-margin">
          		<input type="submit" value="提交保存" class="am-btn am-btn-primary am-btn-xs"/>
  				</div>
        </form>
        <!-- 表单结束 -->
</div>
</div>
<script src="assets/js/jquery.min.js"></script>
<script src="assets/js/amazeui.min.js"></script>
<script src="assets/js/app.js"></script>
</body>
</html>

<%--<html>--%>
	<%--<head class="shangchuan">--%>
		<%--<title class="shangchuan">文件上传</title>--%>
	<%--</head>--%>
	