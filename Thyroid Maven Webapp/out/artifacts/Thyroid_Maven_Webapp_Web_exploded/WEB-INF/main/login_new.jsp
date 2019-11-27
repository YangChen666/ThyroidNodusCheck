<%@page pageEncoding="utf-8"%>
<%@page isELIgnored="false" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=gb2312" />

<link rel="stylesheet" type="text/css" href="css/bootstrap.min.css">	
<link rel="stylesheet" type="text/css" href="css/index.css">
	
<title>网站登录</title>


<!-- 现在的登录直接在index。do页上弹出窗口登录了，此页暂时没有用了 -->



<style>
*{padding:0px; margin:0px; list-style:none;}
body{width:100%;margin:0px;padding:0px;background:url(pic/bg03.jpg);width:100%;height:100%}
.top{width:960px;height:336px;margin:0 auto; background:url(pic/bg01s.jpg) no-repeat; position:relative}
.bottom{width:960px;height:305px;margin:0 auto; background:url(pic/bg02.jpg) no-repeat; position:relative}
#username,#p_t,#userpwd,#validatecode{ position:absolute;top:206px;left:187px;width:193px;height:34px;border:0px;font-size:14px;line-height:30px;color:#666}
#p_t,#userpwd{left:402px; z-index:2}
#validatecode{left:618px; z-index:2;width:113px}
#vcodesrc{ position:absolute;top:165px;left:616px; font-family:Arial}
#userpwd{z-index:1;color:#333}
#login_bt{position:absolute;top:207px;left:751px;width:102px;height:33px; background:transparent; z-index:3;border:0px; cursor:pointer}
.forget{color:#94adc3;position:absolute;top:247px;left:805px;font-size:12px; text-decoration:none}
.forget1{color:#ff6600;position:absolute;top:247px;left:745px;font-size:12px; text-decoration:none}
.item_list{position:absolute;top:70px;left:505px;width:300px;padding-top:20px;}
ul,li{padding:0;margin:0; font-size:12px;list-style:none; border:0;font-weight:normal;}
.item_list ul{width:100%}
.item_list li{width:100%;line-height:24px;color:#fff;}
</style>
</head>
<body>
<div class="top">
<form name="userLoginActionForm" id="userLoginActionForm" method="post" action="tologin.do" target="_parent" >
	<input type="text" autofocus="true" id="username" name="username" value="账户" maxlength="20" onfocus="userInter('F','username',this);"onblur="userInter('B','username',this)"  />
    <input type="text" id="p_t" name="p_t" value="密码" onfocus="hide_pw()" />
    
    <input type="password" id="userpwd" name="userpwd" maxlength="20" onblur="check_pw();"/>
    <input type="text" id="validatecode" name="validatecode" value="登录类型" maxlength="20" onfocus="check_yzm(1)" onblur="check_yzm(2);">
    <a href="javaScript:getVcode2()" title="点击，换一张！"><img src="/include/captcha/captcha.php" id="vcodesrc" name="vcodesrc" border="0" width="116" height="38" style="float:left;display:none" alt="点击，换一张！"  /></a>
    <input type="submit" value="登录" id="login_bt" name="login_bt" onclick="logincheck()"/>
    <a href="" class="forget">忘记密码？</a>
   
   
    <input type="hidden"  id="is_cs" name="is_cs" value="0" />
    <input type="hidden"  id="is_get" name="is_get" value="1" />
    <input type="hidden"  id="show_msg" name="show_msg" value="" />
    <input type="hidden"  id="jz" name="jz" value="0" />
    <input type="hidden"  id="no_new" name="no_new" value="0" />
</form>
</div>
<div class="bottom">
	
	<div class="item_list">
    <ul>
    	<li>一、手机版、微信网站上线</li>
        </ul>
    </div>
   
</div> 
<div >   <!--下面的这些是弹出的部分  -->
	<a class="a globalLoginBtn">登录</a>
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
                        <form action="tologin.do" id="login_form"  method="post" autocomplete="off">
                            
                            <ul>
                                <li class="form-group"><input class="form-control" id="id_account_l" maxlength="50" name="account_l" placeholder="请输入邮箱账号/手机号" type="text"></li>
                                <li class="form-group"><input class="form-control" id="id_password_l" name="password_l" placeholder="请输入密码" type="password"></li>
                                
                            </ul>
                        
	                        <p class="good-tips marginB10"><a id="btnForgetpsw" class="fr">忘记密码？</a>还没有账号？<a href="javascript:;" target="_blank" id="btnRegister">立即注册</a></p>
	                          <span class="login-box marginB10" style="display: none;">
	                            <input id="login_btn"  onclick="logincheck()" type="submit" class="btn btn-micv5 btn-block globalLogin" value="登录">
	                       	  </span>
	                       <input id="login_btn"  onclick="logincheck()" type="submit" class="btn btn-micv5 btn-block globalLogin" value="登录">
						</form>
                        
                        <div class="threeLogin"><span>其他方式登录</span><a class="nqq" href="javascript:;"></a><a class="nwx" href="javascript:;"></a><!--<a class="nwb"></a>--></div>
                        
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

</div><!--弹出的部分结束  -->
</div>

</body>
</html>