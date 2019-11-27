<%@page pageEncoding="utf-8"%>
<%@page isELIgnored="false" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
<head>
  <meta charset="utf-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <meta name="keywords" content="table">
  <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no">
  <meta name="renderer" content="webkit">
  <meta http-equiv="Cache-Control" content="no-siteapp" />
  <!-- <link rel="icon" type="image/png" href="assets/i/favicon.png"> -->
  <!-- <link rel="apple-touch-icon-precomposed" href="assets/i/app-icon72x72@2x.png"> -->
  <meta name="apple-mobile-web-app-title" content="Amaze UI" />
  <link rel="stylesheet" href="assets/css/amazeui.min.css"/>
  <link rel="stylesheet" href="assets/css/admin.css">
</head>
<body>



<div class="am-cf admin-main">
  <!-- sidebar start -->
  <div class="admin-sidebar">
    
  </div>
  <!-- sidebar end -->

  <!-- content start -->
  <div class="admin-content">

    <div class="am-cf am-padding">
      <div class="am-fl am-cf"><strong class="am-text-primary am-text-lg">数据库</strong> / <small>用户上传</small></div>
    </div>

    <div class="am-g">
      <div class="am-u-md-6 am-cf">
        <div class="am-fl am-cf">
          <div class="am-btn-toolbar am-fl">
            <div class="am-btn-group am-btn-group-xs">
            	<form action="guanli_upimages.do" style="float: left;">
					<input style="color:Black;" class="am-btn am-btn-default am-btn-xs am-text-secondary" type="submit" value="+新增"/>
				</form>
            </div>
			
          </div>
        </div>
      </div>
      <div class="am-u-md-3 am-cf">
        <div class="am-fr">
          <div class="am-input-group am-input-group-sm">
          
          </div>
        </div>
      </div>
    </div>
<!-- 表格开始 -->
    <div class="am-g">
      <div class="am-u-sm-12"  >
        <div class="am-form">
          <table class="am-table am-table-striped am-table-hover table-main">
            <thead>
              <tr>
               <th class="table-id" style="width:3%;">ID</th>
               <th class="table-type" style="width:12%;">名称</th>
               <th class="table-title" style="width:8%;">部位</th>
               <th style="width:12%;">结果</th>
               <th class="table-author" style="width:13%;">说明</th>
               <th class="table-date" style="width:20%;">描述</th>
               <th class="table-date" style="width:5%;">用户</th>
               <th class="table-set">操作</th>
              </tr>
          </thead>
          <tbody>
          <c:forEach items="${list}" var="li">
              <tr>
                  <td>${li.id }</td>
                  <td>${li.name }</td>
                  <td>${li.part }</td>
                  <td>${li.result }</td>
                  <td>${li.inst }</td>
                  <td>${li.descr }</td>
                  <td>${li.user }</td>
                      <%--  <td>${li.set_time }</td> --%>
                  <td>
                      <div class="am-btn-toolbar">
                          <div class="am-btn-group am-btn-group-xs">
                              <form action="select_shiyong_user.do" style="float: left;">
                                  <input name="tupianid" type="text" value="${li.id}" style="display:none;"/>
                                  <input style="color:Black;" class="am-btn am-btn-default am-btn-xs am-text-secondary" type="submit" value="使用"/>
                              </form>
                              <form action="guanli_xuigai_images.do" style="float: left;">
                                  <input name="tupianid" type="text" value="${li.id}" style="display:none;"/>
                                  <input style="color:Black;" class="am-btn am-btn-default am-btn-xs am-text-secondary" type="submit" value="修改"/>
                              </form>
                              <form action="guanli_xuigai_images_delete.do" style="float: left;">
                                  <input name="tupianid" type="text" value="${li.id}" style="display:none;"/>
                                  <input style="color:Black;" class="am-btn am-btn-default am-btn-xs am-text-secondary" type="submit" value="删除"/>
                              </form>
                          </div>
                      </div>
                  </td>
              </tr>
          </c:forEach>
          </tbody>
        </table>
         
          <hr />
          <p>注：.....</p>
        </div>
      </div>

    </div>
  </div>
  <!-- content end -->
</div>

<footer>
</footer>

<script src="assets/js/jquery.min.js"></script>
<script src="assets/js/amazeui.min.js"></script>
<!--<![endif]-->
<script src="assets/js/app.js"></script>
</body>
</html>




