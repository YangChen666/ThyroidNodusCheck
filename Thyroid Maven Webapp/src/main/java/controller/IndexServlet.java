package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import Dao.AdminsDeal;
import Dao.UsersDeal;
import entity.Admins;
import entity.Users;
import mysql.mysqlTool;



@Controller
public class IndexServlet{
	
	@RequestMapping("/index.do")
	protected String Index(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		//没有数据	，第一版
		HttpSession session=req.getSession();
		return "index";
	}

	//这个是以游客身份登陆的
	@RequestMapping("/youke.do")
	protected String youke(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		HttpSession session=req.getSession();
		//存入session(设置用户名及密码key）
		session.setAttribute("userName","游客");
		session.setAttribute("radio", "c");//c表示游客
		session.setAttribute("scc", "1");//scc为1表示登录成功
		Users user=new Users();
		user.setName("游客");
		user.setSex("--");
		user.setMobile("--");
		user.setEmail("--");
		user.setBirt("--");
		user.setSet_time("--");
		session.setAttribute("yonghu", user);//在home中的个人信息中显示
		return "home";
	}

	//这个是重新登录的
	@RequestMapping("/reindex.do")
	protected String reIndex(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		HttpSession session=req.getSession();
		return "Reindex";
	}
	
	//这个是注销登陆的
		@RequestMapping("/zhuxiao.do")
		protected String zhuxiao(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
			HttpSession session=req.getSession();
			//存入session(设置用户名及密码key）
			session.invalidate();//销毁session对象
//			session.setAttribute("userName",null);
//			session.setAttribute("scc", null);//scc为1表示登录成功
			return "index";
		}
	
	
	@RequestMapping("/home.do")
	protected String Home(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		//没有数据	，第一版
		HttpSession session=req.getSession();
		return "home";
	}
	
	
	@RequestMapping("/dengluyanzheng.do")  // 登录/验证---然后进入后台主页
	protected String dengluyanzheng(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		try{
				String fanhui="";
				//该方法是第二版加上的（账号登陆验证）
				//获取数据的编码（获取登录页的信息）
				req.setCharacterEncoding("utf-8");
				//创建变量-接收网页传来的数据(获取网页信息)
				String userName=req.getParameter("userName");
				String password=req.getParameter("password");
				String radiotype=req.getParameter("radio1");
				//获取session
				HttpSession session=req.getSession();
				//连接数据库与数据库数据对比，检测账号/密码正确与否
				//检验账号密码是否正确
				if(radiotype.equals("a")){  //a 为：患者
						UsersDeal userd=new UsersDeal();
						Users user=userd.findUsers_name(userName);   //数据库查询
						if(user==null){
							session.setAttribute("error","用户账号不存在,请重新登陆或注册");
							fanhui= "index";
							session.setAttribute("scc", null);//scc为0表示登录失败
						}else if(!user.getPassword().equals(password)){   //密码错误
							session.setAttribute("error", "用户密码错误");
							fanhui= "index";
							session.setAttribute("scc", null);//scc为0表示登录失败
						}else if(user.getPassword().equals(password)){
							//检查通过
							//存入session(设置用户名及密码key）
							session.setAttribute("userName",userName);
							session.setAttribute("password", password);
							session.setAttribute("radio", radiotype);
							session.removeAttribute("error");
							session.setAttribute("scc", "1");//scc为1表示登录成功
							session.setAttribute("yonghu", user);//在home中的个人信息中显示
							fanhui= "home";
						}
					}else if(radiotype.equals("b"))
					{  //b 为：管理者（医生）
						System.out.println("最后：");
						AdminsDeal adminsd=new AdminsDeal();
						Admins admin=adminsd.findAdmins_name(userName);
						if(admin==null){
							session.setAttribute("error","用户账号不存在,请重新登陆或注册");
							fanhui= "index";
							session.setAttribute("scc", null);//scc为0表示登录失败
						}else if(!admin.getPassword().equals(password)){   //密码错误
							session.setAttribute("error", "用户密码错误");
							fanhui= "index";
							session.setAttribute("scc", null);//scc为0表示登录失败
						}else if(admin.getPassword().equals(password)){
							//检测通过--登录//创建Cookie
							/*//要考虑--有效路径/存在内存？/编码
							Cookie cookie=new Cookie("Code",code);
							res.addCookie(cookie);
							//用session重写一遍上两行的Cookie的
							HttpSession session=req.getSession();
							session.setAttribute("Code", code);
							//重定向到主页index.jsp  */
							
							//检查通过
							session.setAttribute("userName",userName);
							session.setAttribute("password", password);
							session.setAttribute("radio", radiotype);
							session.removeAttribute("error");
							session.setAttribute("scc", "1");//scc为1表示登录成功
							session.setAttribute("yonghu", admin);//在home中的个人信息中显示
							fanhui= "home";
							System.out.println("最后："+fanhui);
						}
					}
					return fanhui;	
				} catch (Exception e) {
					//一般捕获到异常之后的操作
					//1.记录日志
					//e.printStackTrace();
					//抛出异常
					res.sendRedirect("/Thyroid/index.do");
					//throw new RuntimeException("查询失败",e);
				}finally{
					
				}
		return null;
	}
}