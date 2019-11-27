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
   			     <div class="am-fl am-cf"><strong class="am-text-primary am-text-lg">图像裁剪</strong> / <small>展示</small></div>
  		    </div>
	        <div class="am-tabs am-margin" data-am-tabs>
				<div class="row">
				    <div class="col-md-12">
				        <iframe src="/clipShow.do" width="100%" height="500px" frameborder="0"></iframe>
				    </div>
				</div>
	        </div>
        </div>
    </header>
<script src="assets/js/jquery.min.js"></script>
<script src="assets/js/amazeui.min.js"></script>
<script src="assets/js/app.js"></script>
</body>
</html>
