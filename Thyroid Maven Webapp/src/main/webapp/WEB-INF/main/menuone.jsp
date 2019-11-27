<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page pageEncoding="utf-8"%>
<%@page isELIgnored="false" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<head>
</head>
<body>
<!-- 左边和上边导航 -->
<!-- Branding   网站商标-->
          <div class="navbar-header col-md-2">
            <%--<a class="navbar-brand" href="/Thyroid/index">     <!--这里有连接已解决 -->--%>
              <%--<strong></strong>--%>
            <%--</a>--%>
            <div class="sidebar-collapse">
              <a href="#">
                <i class="fa fa-bars"></i>
              </a>
            </div>
          </div>
          <!-- Branding end  网站商标结束-->
          <div class="copyrights">Collect from <a href="/Thyroid/index"  title="网站主页">网站主页</a></div>


          <!-- .nav-collapse -->
          <div class="navbar-collapse">
                        
            <!-- Page refresh  页面刷新-顶部横条-->
            <ul class="nav navbar-nav refresh">
              <li class="divided">
                <a href="#" class="page-refresh"><i class="fa fa-refresh"></i></a>
              </li>
            </ul>
            <!-- /Page refresh 页面刷新-顶部横条结束-->

            <!-- Search  搜索-->
            <div class="search" id="main-search">
              <!-- <i class="fa fa-search"></i> <input type="text" placeholder="Search..."> -->
            </div>
            <!-- Search end  搜索结束-->

            <!-- Quick Actions   快速的行动-搜索后面的部分-->
            <ul class="nav navbar-nav quick-actions">
              
              <li class="dropdown divided">
                
                <a class="dropdown-toggle button" data-toggle="dropdown" href="#">
                  <i class="fa fa-tasks"></i>
                  <span class="label label-transparent-black"><!-- 显示 --></span>
                </a>
<!-- 个人信息显示 -->
                <ul class="dropdown-menu wide arrow nopadding bordered">
                  <li><h1 style="color:#fffff;">个人信息 <strong></strong> /不允许修改</h1></li>
                  <li>
                    
                  </li>
                  <li>用户名：${yonghu.name }</li>
                  <li>性别：${yonghu.sex }</li>
                  <li>手机号：${yonghu.mobile }</li>
                  <li>邮箱：${yonghu.email }</li>
                  <li>出生日期：${yonghu.birt }</li>
                  <li>创建时间：${yonghu.set_time }</li>
                  <li >以上信息不允许用户自主修改，如需修改请联系首页管理员！</li>
                  
                  
                  
                  
                </ul>

              </li>
 

              <li class="dropdown divided user" id="current-user">
                <div class="profile-photo">
                  <img src="assets/images/profile-photo.jpg" alt />
                </div>
                <a class="dropdown-toggle options" data-toggle="dropdown" href="#">
                   <strong>${userName}</strong><i class="fa fa-caret-down"></i>
                </a>
                
                <ul class="dropdown-menu arrow settings">

                  <li>
                    
                    <h3>背景颜色:</h3>
                    <ul id="color-schemes">
                      <li><a href="#" class="bg-1"></a></li>
                      <li><a href="#" class="bg-2"></a></li>
                      <li><a href="#" class="bg-3"></a></li>
                      <li><a href="#" class="bg-4"></a></li>
                      <li><a href="#" class="bg-5"></a></li>
                      <li><a href="#" class="bg-6"></a></li>
                    </ul>

                  

                  <li>
                    <a href="zhuxiao.do"><i class="fa fa-power-off"></i> 注销</a>
                  </li>
                </ul>
              </li>
              <li style="width:65px;"></li>
              <li style="display:none;"><!-- 此标签以隐藏，这是用户后面的小信息（即home的右侧边栏奥） -->
                <a href="#mmenu"><i class="fa fa-comments"></i></a>
              </li>
              
            </ul>
            <!-- /Quick Actions  快速的行动-搜索后面的部分结束-->



<!-- Sidebar 侧边栏-->
            <ul class="nav navbar-nav side-nav" id="sidebar">
              
              <li class="collapsed-content"> 
                <ul>
                  <li class="search">Collapsed search pasting here at 768px</li>
                </ul>
              </li>
<!-- 左边下拉开始 -->
              <li class="navigation" id="navigation">
                <a href="#" class="sidebar-toggle" data-toggle="#navigation" style="color:#ffffff;">业务处理 <i class="fa fa-angle-up"></i></a>
                
                <ul class="menu">
<!--主页     系统主页-->
                  <li class="active">
                    <a href="index.do">
                      <i class="fa fa-tachometer"></i> 主页
                      <span class="badge badge-red"><!--小标题上的数字--></span> 
                    </a>
                  </li>
<!--Home   用户主页-->
                  <li> 
                    <a href="home.do">
                      <i class="fa fa-tachometer"></i> Home
                    </a>
                  </li>
<!--图像获取-->
                  <li class="dropdown">
                  	<a href="#" class="dropdown-toggle" data-toggle="dropdown">
                      <i class="fa fa-th-large"></i> 图像获取 <b class="fa fa-plus dropdown-plus"></b>
                    </a>
                    <ul class="dropdown-menu">
                      <li>  <!--一级下拉1-6 中的小下拉-->
                        <a href="toup.do">
                          	<i class="fa fa-caret-right"></i> 上传
                        </a>
                      </li>
                      <c:if test="${radio=='a'||radio=='b'}">
                        <li>  <!--一级下拉1-6 中的小下拉-->
                          <a href="mysql_select.do">
                            <i class="fa fa-caret-right"></i> 已上传
                          </a>
                        </li>
                      </c:if>

                    </ul> 
                  </li>
<%--<!-- 裁剪 -->--%>
                  <%--<li class="dropdown">--%>
                    <%--<a href="#" class="dropdown-toggle" data-toggle="dropdown">--%>
                      <%--<i class="fa fa-list"></i> 图像裁剪 <b class="fa fa-plus dropdown-plus"></b>--%>
                    <%--</a>--%>
                    <%--<ul class="dropdown-menu">--%>
                    <%----%>
                     <%----%>
                      <%--<li>--%>
                        <%--<a href="roi.do">--%>
                          <%--<i class="fa fa-caret-right"></i> 图像裁剪--%>
                        <%--</a>--%>
                      <%--</li>--%>

                      <%----%>
                    <%--</ul>--%>
                  <%--</li>--%>
<!--图像预处理-->
                  <li class="dropdown">
                  	<a href="#" class="dropdown-toggle" data-toggle="dropdown">
                      <i class="fa fa-desktop"></i> 图像处理 <b class="fa fa-plus dropdown-plus"></b>
                      <span class="label label-greensea"><!-- 后标 --></span>
                    </a>
                    <ul class="dropdown-menu">
                      <li>
                        <a href="roi.do">
                          <i class="fa fa-caret-right"></i> 图像裁剪
                        </a>
                      </li>
                      <li>  <!--一级下拉1-7 中的小下拉-->
                        <a href="toquzao.do">
                          <i class="fa fa-caret-right"></i> 去噪
                        </a>
                      </li>
                      <li>  <!--一级下拉1-7 中的小下拉-->
                        <a href="tozeng_liang.do">
                          <i class="fa fa-caret-right"></i> 亮度
                        </a>
                      </li>
                      <li>  <!--一级下拉1-7 中的小下拉-->
                        <a href="tozeng_dui.do">
                          <i class="fa fa-caret-right"></i> 对比度
                        </a>
                      </li>
                      <%--<li>  <!--一级下拉1-7 中的小下拉-->--%>
                        <%--<a href="tozeng_se.do">--%>
                          <%--<i class="fa fa-caret-right"></i> 色度--%>
                        <%--</a>--%>
                      <%--</li>--%>
                      <%--<li>  <!--一级下拉1-7 中的小下拉-->--%>
                        <%--<a href="tozeng_rui.do">--%>
                          <%--<i class="fa fa-caret-right"></i> 锐度--%>
                        <%--</a>--%>
                      <%--</li>--%>
                    </ul> 
                  </li>
<!-- 结节分类 -->             
                  <li class="dropdown">
                    <a href="#" class="dropdown-toggle" data-toggle="dropdown">
                      <i class="fa fa-pencil"></i> 诊断 <b class="fa fa-plus dropdown-plus"></b>
                    </a>
                    <ul class="dropdown-menu">
                      <li>  <!--一级下拉1-3 中的小下拉-->
                        <a href="tojiejie.do">
                          <i class="fa fa-caret-right"></i> 综合诊断
                        </a>
                      </li>
                      <li>  <!--一级下拉1-3 中的小下拉-->
                        <a href="tojiejie_zc.do">
                          <i class="fa fa-caret-right"></i> 正常---结节
                        </a>
                      </li>
                      <li>  <!--一级下拉1-3 中的小下拉-->
                        <a href="tojiejie_le.do">
                          <i class="fa fa-caret-right"></i> 良---恶
                        </a>
                      </li>
                      <li>  <!--一级下拉1-3 中的小下拉-->
                        <a href="tojiejie_ee.do">
                          <i class="fa fa-caret-right"></i> 恶化---高度恶化
                        </a>
                      </li>
                    </ul>
                  </li>
<!--超声图像管理-->
                  <li class="dropdown">
                    <a href="#" class="dropdown-toggle" data-toggle="dropdown">
                      <i class="fa fa-list"></i> 超声图像管理 <b class="fa fa-plus dropdown-plus"></b>
                    </a>
                      <ul class="dropdown-menu">
                        <c:choose>
                          <c:when test="${radio=='b'}">
                            <li>  <!-- 一级下拉1-2 中的小下拉 -->
                              <a href="mysql_adminer.do">
                                <i class="fa fa-caret-right"></i> 医院数据
                              </a>
                            </li>
                          </c:when>
                          <c:when test="${radio=='a'}">
                            <li>
                              <a href="mysql_user.do">
                                <i class="fa fa-caret-right"></i> 患者上传
                              </a>
                            </li>
                          </c:when>
                          <c:otherwise>
                            <li>
                              <a href="#">
                                <i class="fa fa-caret-right"></i> 游客无访问权限
                              </a>
                            </li>
                          </c:otherwise>
                        </c:choose>

                      </ul>
                  </li>
               
<!-- 切换用户-->
                  <%--<li>--%>
                    <%--<a href="reindex.do">--%>
                      <%--<i class="fa fa-bar-chart-o"></i> 切换用户--%>
                    <%--</a>--%>
                  <%--</li>--%>
                </ul>

              </li>

              
            </ul>
<!-- Sidebar end 侧边栏结束-->

          </div>
          <!--/.nav-collapse  侧标栏大框-->
</body>