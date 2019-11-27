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
		//��session�г��Ի�ȡ�˺�
		//�����˺��ж��û��Ƿ��¼
		//ת������
		HttpServletRequest request=(HttpServletRequest)req;
		HttpServletResponse response=(HttpServletResponse)res;
		//�Ѳ���Ҫ���˵������ų�����
		String[] paths=new String[]{"/index.do","/dengluyanzheng.do","/youke.do","/registered.do","/forgotPassword.do","/zhuce.do","/mima.do","/reindex.do"};
		//��ȡ��ǰ·��
		String path=request.getServletPath();
		for(String pa:paths){
			if(path.equals(pa)){
				//�����ˣ�����ִ��,�����
				chain.doFilter(request, response);
				//����ļ�����Ͳ���ִ���ˣ�ֱ�ӽ�������return�����ͣ
				return ;
			}
		}
		//��ȡ�˺�

		HttpSession session= request.getSession();
		String Name=(String)session.getAttribute("userName");
		//�ж��Ƿ����˺�
		if(Name==null){
			//δ��¼���ض��򵽵�¼ҳ��
			response.sendRedirect("/Thyroid/index.do");
		}else{
			//�Ե�½���������ִ��
			chain.doFilter(request, response);//���ﴫrequest��req��һ���ģ���Ϊ�����Ķ���һ����ֻ��һ���Ǹ����ʹ棬һ����үү���ʹ档
		}
		
	}

	public void destroy() {
		
	}

	public void init(FilterConfig filterConfig) throws ServletException {
		
	}
}
