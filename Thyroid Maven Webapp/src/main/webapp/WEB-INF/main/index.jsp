<%@page pageEncoding="utf-8"%>
<%@page isELIgnored="false" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%
String path = request.getContextPath();
%>

<!-- 前台主页 -->
<!DOCTYPE html>
<html lang="en"> 
<head>
	<meta charset="UTF-8">
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta name="description" content="">
    <meta name="author" content="">
	<title>Thyroid</title>
	<link rel="stylesheet" href="<%=path%>/css/font-awesome.min.css">
	<link rel="stylesheet" href="<%=path%>/css/bootstrap.min.css">
	<link rel="stylesheet" href="<%=path%>/css/style.css">
	<link href='http://fonts.googleapis.com/css?family=Open+Sans:600italic,400,800,700,300' rel='stylesheet' type='text/css'>
	<link href='http://fonts.googleapis.com/css?family=BenchNine:300,400,700' rel='stylesheet' type='text/css'>	
	<link rel="stylesheet" type="text/css" href="<%=path%>/css/index.css"><!-- 弹出登录的页面的css样式 -->
	<script src="js/modernizr.js"></script>
	<script>
		
	</script>
	<style>
	</style>
</head>
<body>
	
	<!-- ====================================================
	header section -->
	<header class="top-header">
		<div class="container">
			<div class="row">
				<div class="col-md-5 header-logo">
					<nav class="navbar navbar-default">
						<div class="nav-bar">
							<div class="collapse navbar-collapse">
								<%--<img src="img/logo.png"  alt="">--%>
							</div>
						</div>
					</nav>
					<%--<div class="row">--%>
						<%--<div class="col-md-12">--%>
							<%--<img src="img/logo.png"  alt="" class="center-block">--%>
						<%--</div>--%>
					<%--</div>--%>
						<%--<a href="index.do"><img src="img/logo.png"  alt=""  class="img-responsive logo menu"></a>--%>
				</div>

				<div class="col-md-7">
					<nav class="navbar navbar-default">
						  <div class="container-fluid nav-bar">
					    <!-- Brand and toggle get grouped for better mobile display -->
					    <div class="navbar-header">
					      <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1">
					        <span class="sr-only">切换导航</span>
					        <span class="icon-bar"></span>
					        <span class="icon-bar"></span>
					        <span class="icon-bar"></span>
					      </button>
					    </div>

					    <!-- Collect the nav links, forms, and other content for toggling -->
					    <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
					      
					      <!-- 登录回馈 开始 -->
								<div style="">
									<h1 style="color:red;font-size:10px;position: relative;left:40%;">
										<a href="home.do">${error}</a>
									</h1>
								</div>
						<!-- 登录回馈 结束 -->
					      
					      <ul class="nav navbar-nav navbar-right">
					        <li><a class="menu" href="index.do" >首页</a></li><!-- 在class中加上 active改变样式 -->
					        <li><a class="menu" href="#service">服务 </a></li>
					        <li><a class="menu" href="#team">团队</a></li>
					        <li><a class="menu" href="#contact"> 联系我们</a></li>
					        <c:if test="${empty scc}">
							        <li><a class="menu a globalLoginBtn" href="#about" id="zidong">登录</a>	<!--弹出部分开始  -->		
										<div class="modal fade" id="loginModal" tabindex="-1" role="dialog" aria-labelledby="mySmallModalLabel" aria-hidden="true" style="display: none;"><div style="display:table; width:100%; height:100%;"><div style="vertical-align:middle; display:table-cell;"><div class="modal-dialog modal-sm" style="width:540px;">
									        <div class="modal-content" style="border: none;">
									            <div class="col-left"></div>
									            <div class="col-right">
									                <div class="modal-header">
									                    <button type="button" id="login_close" class="close" data-dismiss="modal"><span aria-hidden="true">×</span><span class="sr-only">Close</span></button>
									                    <h4 class="modal-title" id="loginModalLabel" style="font-size: 18px;">登录</h4>
									                </div>
									                <div class="modal-body">
									                    <section class="box-login v5-input-txt" id="box-login">
									                        <form action="dengluyanzheng.do" id="login_form"  method="post" autocomplete="off">
									                            
									                            <ul>
									                                <li class="form-group"><input class="form-control" id="id_account_l" maxlength="50" name="userName" placeholder="请输入邮箱账号/手机号" type="text"></li>
									                                <li class="form-group"><input class="form-control" id="id_password_l" name="password" placeholder="请输入密码" type="password"></li>
									                                
									                            </ul>
									                        	<p class="good-tips marginB10"><!-- 判断是那种用户？患者？管理者？  开始-->
									                        		用户类型：
									                        		患者<input type="radio" name="radio1" value="a" checked/> <!-- 患者为：a;管理员为：b; -->
									                        		医生<input type="radio" name="radio1" value="b"/>
									                        	</p><!-- 判断是那种用户？患者？管理者？  结束-->
										                        <p class="good-tips marginB10"><a id="btnForgetpsw" class="fr" href="forgotPassword.do">忘记密码？</a>没有账号？<a href="registered.do" target="_blank" id="btnRegister">立即注册</a></p>
										                          <span class="login-box marginB10" style="display: none;">
										                            <input id="login_btn"  onclick="logincheck()" type="submit" class="btn btn-micv5 btn-block globalLogin" value="登录">
										                       	  </span>
										                       <input id="login_btn"  onclick="logincheck()" type="submit" class="btn btn-micv5 btn-block globalLogin" value="登录">
															</form>
									                        
									                        <p class="good-tips marginB10">不方便注册账号？<a href="youke.do" target="_blank" id="btnRegister">游客进入</a></p><!-- 游客进入后台链接 -->
									                        <!--  <div class="threeLogin"><span>其他方式登录</span><a class="nqq" href="javascript:;"></a><a class="nwx" href="javascript:;"></a><!--<a class="nwb"></a>--><!-- </div>  -->
									                        
									                    </section>
									                </div>
									            </div>
									        </div>
									    	</div>
												<script type="text/javascript" src="js/jquery2.2.2.min.js"></script>
												<script type="text/javascript" src="js/bootstrap.min.js"></script>
												<script type="text/javascript" src="js/common.js"></script>
												<script type="text/javascript" src="js/login.js"></script>
											<div style="text-align:center;">
									
										</div>  <!--弹出部分结束  -->
							        </li>
             				</c:if>
             				<c:if test="${scc=='1' }">
             					 <li><a class="menu active" href="home.do">用户：${userName}</a></li>
             				</c:if>
					      </ul>
					    </div><!-- /navbar-collapse -->
					  </div><!-- / .container-fluid -->
					</nav>
				</div>
			</div>
		</div>
		
	</header> <!-- end of header area -->

	<section class="slider" id="home">
		<div class="container-fluid">
			<div class="row">
			    <div id="carouselHacked" class="carousel slide carousel-fade" data-ride="carousel">
					<div class="header-backup"></div>
			        <!-- Wrapper for slides -->
			        <div class="carousel-inner" role="listbox">
			            <div class="item active">
			            	<img src="img/slide-one.jpg" alt="">
			                <div class="carousel-caption">
		               			
			                </div>
			            </div>
			            <div class="item">
			            	<img src="img/slide-two.jpg" alt="">
			                <div class="carousel-caption">
		               			<!-- 这里是图像上的显示的字 -->
			                </div>
			            </div>
			            <div class="item">
			            	<img src="img/slide-three.jpg" alt="">
			                <div class="carousel-caption">
		               			<!-- 这里是图像上的显示的字 -->
			                </div>
			            </div>
			            <div class="item">
			            	<img src="img/slide-four.jpg" alt="">
			                <div class="carousel-caption">
		               			<!-- 这里是图像上的显示的字 -->
			                </div>
			            </div>
			        </div>
			        <!-- Controls -->
			        <a class="left carousel-control" href="#carouselHacked" role="button" data-slide="prev">
			            <span class="glyphicon glyphicon-chevron-left" aria-hidden="true"></span>
			            <span class="sr-only">Previous</span>
			        </a>
			        <a class="right carousel-control" href="#carouselHacked" role="button" data-slide="next">
			            <span class="glyphicon glyphicon-chevron-right" aria-hidden="true"></span>
			            <span class="sr-only">Next</span>
			        </a>
			    </div>
			</div>
		</div>
	</section><!-- end of slider section -->
    <div class="copyrights">Collect from <a href="http://www.cssmoban.com/" ></a></div>

	


	<!-- service section starts here -->
	<section class="service text-center" id="service">
		<div class="container">
			<div class="row">
				<h2>服务</h2>
				<h4>本系统提供甲状腺超声图像的结节在线智能诊断服务</h4>
				
			
			 
				<div style="position: relative;left:12%;"> <!-- 定位三个功能的  开始 -->
					<div class="col-md-3 col-sm-6">
						<div class="single-service">
							<div class="single-service-img">
								<div class="service-img">
									<img class="brain img-responsive" src="img/service2.png" alt="">
								</div>
							</div>
							<h3>正常--结节 检测</h3>
						</div>
					</div>
					<div class="col-md-3 col-sm-6">
						<div class="single-service">
							<div class="single-service-img">
								<div class="service-img">
									<img class="knee img-responsive" src="img/service3.png" alt="">
								</div>
							</div>
							<h3>良性--恶性 检测</h3>
						</div>
					</div>
					<div class="col-md-3 col-sm-6">
						<div class="single-service">
							<div class="single-service-img">
								<div class="service-img">
									<img class="bone img-responsive" src="img/service4.png" alt="">
								</div>
							</div>
							<h3>初步恶化--高度恶化 检测</h3>
						</div>
					</div>
				</div>   <!-- 定位三个功能的  结束 -->
			</div>
		</div>
	</section><!-- end of service section -->




	<!-- team section -->
	<section class="team" id="team">
		<div class="container">
			<div class="row">
				<div class="team-heading text-center">
					<h2>团队</h2>
					<h4>自2017年9月以来，一直致力于超声甲状腺图像的结节检测研究</h4>
				</div>
				<div class="col-md-2 single-member col-sm-4">
					<div class="person">
						<img class="img-responsive" src="img/member1.jpg" alt="member-1">
					</div>
					<div class="person-detail">
						<div class="arrow-bottom"></div>
						<h3>---</h3>
						<p>自2017年9月以来，一直致力于超声甲状腺图像的结节检测研究</p>
					</div>
				</div>
				

				
			</div>
		</div>
	</section><!-- end of team section -->

	<!-- map section -->
	<div class="api-map" id="contact">
		<div class="container-fluid">
			<div class="row">
				<div class="col-md-12 map" id="map"></div>
			</div>
		</div>
	</div><!-- end of map section -->




	<!-- contact section starts here -->
	<section class="contact">
		<div class="container">
			<div class="row">
				<div class="contact-caption clearfix">
					<div class="contact-heading text-center">
						<h2>联系我们</h2>
					</div>
					<div class="col-md-5 contact-info text-left">
						<h3>联系信息</h3>
						<div class="info-detail">
							<ul><li><i class="fa fa-calendar"></i><span>周一 - 周五:</span> 9:00  to 18:00 </li></ul>
							<ul><li><i class="fa fa-map-marker"></i><span>地址:</span> 宁夏大学  信息工程学院实验楼 101室</li></ul>
							<ul><li><i class="fa fa-phone"></i><span>电话:</span> (+86) 17395044423</li></ul>
							<ul><li><i class="fa fa-fax"></i><span>传真:</span> (+86) Null</li></ul>
							<ul><li><i class="fa fa-envelope"></i><span>Email:</span> zb_zhengbin@163.com</li></ul>
						</div>
					</div>
					<div class="col-md-6 col-md-offset-1 contact-form">
						<h3>留言</h3>

						<form class="form">
							<input class="name" type="text" placeholder="称谓">
							<input class="email" type="email" placeholder="邮箱">
							<input class="phone" type="text" placeholder="电话">
							<textarea class="message" name="message" id="message" cols="30" rows="10" placeholder="建议"></textarea>
							<input class="submit-btn" type="submit" value="提交">
						</form>
					</div>
				</div>
			</div>
		</div>
	</section><!-- end of contact section -->

	<!-- footer starts here -->
	<footer class="footer clearfix">
		<div class="container">
			<div class="row">
				<div class="col-xs-6 footer-para">
					<p>&copy;版权所有     </p>
				</div>
				
			</div>
		</div>
	</footer>

	<!-- script tags
	============================================================= -->
	<script src="js/jquery-2.1.1.js"></script>

	<script src="js/gmaps.js"></script>
	<script src="js/smoothscroll.js"></script>
	<script src="js/bootstrap.min.js"></script>
	<script src="js/custom.js"></script>
</body>
</html>