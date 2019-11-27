<%@page pageEncoding="utf-8"%>
<%@page isELIgnored="false" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
  <head>
    <title>Home-主页</title>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta charset="UTF-8" />

    <link rel="icon" type="image/ico" href="http://tattek.com/minimal/assets/images/favicon.ico" />
    <!-- Bootstrap -->
    <link href="assets/css/vendor/bootstrap/bootstrap.min.css" rel="stylesheet">
    <link href="http://netdna.bootstrapcdn.com/font-awesome/4.0.3/css/font-awesome.css" rel="stylesheet">
    <link rel="stylesheet" href="assets/css/vendor/animate/animate.min.css">
    <link type="text/css" rel="stylesheet" media="all" href="assets/js/vendor/mmenu/css/jquery.mmenu.all.css" />
    <link rel="stylesheet" href="assets/js/vendor/videobackground/css/jquery.videobackground.css">
    <link rel="stylesheet" href="assets/css/vendor/bootstrap-checkbox.css">

    <link rel="stylesheet" href="assets/js/vendor/rickshaw/css/rickshaw.min.css">
    <link rel="stylesheet" href="assets/js/vendor/morris/css/morris.css">
    <link rel="stylesheet" href="assets/js/vendor/tabdrop/css/tabdrop.css">
    <link rel="stylesheet" href="assets/js/vendor/summernote/css/summernote.css">
    <link rel="stylesheet" href="assets/js/vendor/summernote/css/summernote-bs3.css">
    <link rel="stylesheet" href="assets/js/vendor/chosen/css/chosen.min.css">
    <link rel="stylesheet" href="assets/js/vendor/chosen/css/chosen-bootstrap.css">

    <link href="assets/css/minimal.css" rel="stylesheet">
    
	<script type="text/javascript" src="js/jquery-1.11.1.js"></script>
    <script type="text/javascript" >
    				
    </script>

  </head>
  <body class="bg-1">

<!-- Preloader   预紧器-->
   

<!-- 页面所有内容开始 -->
    <div id="wrap">
<!-- 页面内容-->
      <div class="row">

<!--第一部分-  -->
<!--导航- 上边和左边导航导航  menuone.jsp-->
        <div class="navbar navbar-default navbar-fixed-top navbar-transparent-black mm-fixed-top" role="navigation" id="navbar">
          <c:import url="menuone.jsp"></c:import>
        </div>
<!--导航- 上边和左边导航结束-->
        
<!--第二部分-  -->
<!-- 页面主体内容 -->      
        <div id="content" class="col-md-12">
        <!-- 写内容... -->
        	<!-- Home -->
        	<c:import url="../context/showImages.jsp"></c:import>
        	
        </div>    
<!-- 页面主体内容结束-->

<!--第三部分-  -->
<!--右侧隐藏栏  menutwo.jsp-->
        <div id="mmenu" class="right-panel">
          <c:import url="menutwo.jsp"></c:import>
        </div>
<!--右侧隐藏栏结束-->

      </div>
<!-- 页面内容结束 -->
    </div>
<!-- 页面所有内容结束 -->


    <section class="videocontent" id="video"></section>

<!--jQuery插件 - jQuery (Bootstrap JavaScript插件必备) -->
<c:import url="undercontext.jsp"></c:import>
<!--jQuery插件结束 - jQuery (Bootstrap JavaScript插件必备) -->
  </body>
</html>