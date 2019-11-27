package controller;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class logFilter implements Filter {

	/*public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain)
			throws IOException, ServletException {
		// TODO Auto-generated method stub

	}*/
	
	
	
	public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain)
			throws IOException, ServletException {
		//从session中尝试获取账号
		//根据账号判断用户是否登录
		//转换类型
		HttpServletRequest request=(HttpServletRequest)req;
		HttpServletResponse response=(HttpServletResponse)res;
		//把不需要过滤的请求排除在外
		String[] paths=new String[]{"/index.do","/dengluyanzheng.do","/youke.do","/registered.do","/forgotPassword.do","/zhuce.do","/mima.do","/reindex.do"};
		//获取当前路径
		String path=request.getServletPath();
		for(String pa:paths){
			if(path.equals(pa)){
				//不过滤，继续执行,此语句
				chain.doFilter(request, response);
				//下面的检查代码就不用执行了，直接结束，用return语句暂停
				return ;
			}
		}
		//获取账号

		HttpSession session= request.getSession();
		String Name=(String)session.getAttribute("userName");
		//判断是否有账号
		if(Name==null){
			//未登录，重定向到登录页面
			response.sendRedirect("/Thyroid/index.do");
		}else{
			//以登陆，请求继续执行
			chain.doFilter(request, response);//这里传request与req是一样的，因为里面存的都是一个，只是一个是父类型存，一个是爷爷类型存。
		}
		
	}

	public void destroy() {
		
	}

	public void init(FilterConfig filterConfig) throws ServletException {
		
	}
}
