<%@page pageEncoding="utf-8"%>
<%@page isELIgnored="false" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
  <head>
      <title>Thyroid-主页</title>
      <meta name="viewport" content="width=device-width, initial-scale=1.0">
      <meta charset="UTF-8" />

      <script type="text/javascript" src="assets/js/image_clip/jquery-3.4.1.min.js"></script>
      <script type="text/javascript" src="assets/js/image_clip/jquery-ui.min.js"></script>

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
            <%--<header class="am-topbar admin-header">--%>
                <%--<div class="admin-content">--%>
                    <%--<div class="am-cf am-padding">--%>
                        <%--<div class="am-fl am-cf"><strong class="am-text-primary am-text-lg">图像裁剪</strong> / <small>图像展示</small></div>--%>
                    <%--</div>--%>
                    <%--<div class="am-tabs am-margin" data-am-tabs>--%>
                        <%--<div class="row">--%>
                            <%--<div class="col-md-12">--%>
                                <%--<iframe src="/clipShow.do" width="100%" height="500px" frameborder="0"></iframe>--%>
                            <%--</div>--%>
                        <%--</div>--%>
                    <%--</div>--%>
                <%--</div>--%>
            <%--</header>--%>
        	<c:import url="../context/clip_image.jsp"></c:import>
        </div>
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
