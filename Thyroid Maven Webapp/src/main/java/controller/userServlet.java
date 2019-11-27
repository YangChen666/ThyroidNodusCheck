package controller;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import Dao.UsersDeal;
import entity.Users;

/**
 * 注册用户，找回密码
 * @author hcx
 *
 */
@Controller
public class userServlet {
	
	
	//用户注册
			@RequestMapping("/registered.do")   //打开注册
			protected String registered(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
				HttpSession session=req.getSession();
				return "login_registered";
			}

	//忘记密码
	@RequestMapping("/forgotPassword.do")   //忘记密码
	protected String forgotPassword(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		HttpSession session=req.getSession();
		return "forgot_password";
	}
	
	//注册页面
	@RequestMapping("/zhuce.do")
	protected String zhuce(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		HttpSession session=req.getSession();
		req.setCharacterEncoding("utf-8");
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");//Date格式转为字符串
		try{
			Users user=new Users();
			UsersDeal usersd=new UsersDeal();
			user.setName(req.getParameter("name"));
			if(req.getParameter("password").equals(req.getParameter("confirm_psw"))){
				user.setPassword(req.getParameter("password"));
			}
			else{
				session.setAttribute("zhuce", "密码输入不一致，请重新输入！");
				return "login_registered";
			}
			if(req.getParameter("sex").equals("m")){  //m为男，w为女
				user.setSex("男");
			}else if(req.getParameter("sex").equals("w")){
				user.setSex("女");
			}
			user.setMobile(req.getParameter("mobile"));
			user.setEmail(req.getParameter("email"));
			user.setBirt(req.getParameter("birt"));
			user.setSet_time(sdf.format(new Date()));
			//写入库
			usersd.insert_user(user);
			session.setAttribute("zhuce", "注册成功请登录！");
			
		} catch (Exception e) {
			session.setAttribute("zhuce", "注册失败，请重新注册！");
			//throw new RuntimeException("查询失败",e);
		}finally{	
		}
		return "login_registered";
		
	}
	
	
	
	//找回密码页面
		@RequestMapping("/mima.do")
		protected String mima(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
			HttpSession session=req.getSession();
			req.setCharacterEncoding("utf-8");
			SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");//Date格式转为字符串
			try{
				Users user=new Users();//存放网页获取对象
				UsersDeal usersd=new UsersDeal();
				//获取数据
				user.setName(req.getParameter("name").toString());
				if(req.getParameter("sex").toString().equals("m")){  //m为男，w为女
					user.setSex("男");
				}else if(req.getParameter("sex").toString().equals("w")){
					user.setSex("女");
				}
				user.setMobile(req.getParameter("mobile"));
				user.setEmail(req.getParameter("email").toString());
				user.setBirt(req.getParameter("birt").toString());
				//查询库中数据--根据用户名
				Users usercha = usersd.findOne_Name(user.getName());//存放数据库查询对象
				//对比 正确返回密码  错误提示错误
				System.out.println(usercha.getName());
				if(user.getName().equals(usercha.getName())){
					if(user.getSex().equals(usercha.getSex())){
						if(user.getMobile().equals(usercha.getMobile())){
							if(user.getEmail().equals(usercha.getEmail())){
								if(user.getBirt().equals(usercha.getBirt())){
									session.setAttribute("mima", "密码为："+usercha.getPassword());
								}else{
									session.setAttribute("mima", "用户出生日期错误！");
								}
							}else{
								session.setAttribute("mima", "用户邮箱错误！");
							}
						}else{
							session.setAttribute("mima", "用户手机号错误！");
						}
					}else{
						session.setAttribute("mima", "用户性别错误！");
					}
				}else{
					session.setAttribute("mima", "用户不存在！");
				}

				
				
			} catch (Exception e) {
				session.setAttribute("mima", "用户不存在！");
			}finally{	
			}
			return "login_registered";
			
		}
}
