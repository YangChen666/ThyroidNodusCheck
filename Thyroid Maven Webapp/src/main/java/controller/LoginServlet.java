package controller;
/**
 * 这个登录控制文件 只是针对打开登陆页的
 * 对于在index.do 弹出的登录 的控制在loginNew.java文件中
 */
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class LoginServlet{
	@RequestMapping("/login.do")
	protected String service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		//登录
		return "login_new";
	}
	
	//处理登录页
	@RequestMapping("/tologin.do")
	protected String tologin(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		//登录
		return "home";
	}
}
