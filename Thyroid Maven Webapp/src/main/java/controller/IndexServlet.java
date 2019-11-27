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
		//û������	����һ��
		HttpSession session=req.getSession();
		return "index";
	}

	//��������ο���ݵ�½��
	@RequestMapping("/youke.do")
	protected String youke(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		HttpSession session=req.getSession();
		//����session(�����û���������key��
		session.setAttribute("userName","�ο�");
		session.setAttribute("radio", "c");//c��ʾ�ο�
		session.setAttribute("scc", "1");//sccΪ1��ʾ��¼�ɹ�
		Users user=new Users();
		user.setName("�ο�");
		user.setSex("--");
		user.setMobile("--");
		user.setEmail("--");
		user.setBirt("--");
		user.setSet_time("--");
		session.setAttribute("yonghu", user);//��home�еĸ�����Ϣ����ʾ
		return "home";
	}

	//��������µ�¼��
	@RequestMapping("/reindex.do")
	protected String reIndex(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		HttpSession session=req.getSession();
		return "Reindex";
	}
	
	//�����ע����½��
		@RequestMapping("/zhuxiao.do")
		protected String zhuxiao(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
			HttpSession session=req.getSession();
			//����session(�����û���������key��
			session.invalidate();//����session����
//			session.setAttribute("userName",null);
//			session.setAttribute("scc", null);//sccΪ1��ʾ��¼�ɹ�
			return "index";
		}
	
	
	@RequestMapping("/home.do")
	protected String Home(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		//û������	����һ��
		HttpSession session=req.getSession();
		return "home";
	}
	
	
	@RequestMapping("/dengluyanzheng.do")  // ��¼/��֤---Ȼ������̨��ҳ
	protected String dengluyanzheng(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		try{
				String fanhui="";
				//�÷����ǵڶ�����ϵģ��˺ŵ�½��֤��
				//��ȡ���ݵı��루��ȡ��¼ҳ����Ϣ��
				req.setCharacterEncoding("utf-8");
				//��������-������ҳ����������(��ȡ��ҳ��Ϣ)
				String userName=req.getParameter("userName");
				String password=req.getParameter("password");
				String radiotype=req.getParameter("radio1");
				//��ȡsession
				HttpSession session=req.getSession();
				//�������ݿ������ݿ����ݶԱȣ�����˺�/������ȷ���
				//�����˺������Ƿ���ȷ
				if(radiotype.equals("a")){  //a Ϊ������
						UsersDeal userd=new UsersDeal();
						Users user=userd.findUsers_name(userName);   //���ݿ��ѯ
						if(user==null){
							session.setAttribute("error","�û��˺Ų�����,�����µ�½��ע��");
							fanhui= "index";
							session.setAttribute("scc", null);//sccΪ0��ʾ��¼ʧ��
						}else if(!user.getPassword().equals(password)){   //�������
							session.setAttribute("error", "�û��������");
							fanhui= "index";
							session.setAttribute("scc", null);//sccΪ0��ʾ��¼ʧ��
						}else if(user.getPassword().equals(password)){
							//���ͨ��
							//����session(�����û���������key��
							session.setAttribute("userName",userName);
							session.setAttribute("password", password);
							session.setAttribute("radio", radiotype);
							session.removeAttribute("error");
							session.setAttribute("scc", "1");//sccΪ1��ʾ��¼�ɹ�
							session.setAttribute("yonghu", user);//��home�еĸ�����Ϣ����ʾ
							fanhui= "home";
						}
					}else if(radiotype.equals("b"))
					{  //b Ϊ�������ߣ�ҽ����
						System.out.println("���");
						AdminsDeal adminsd=new AdminsDeal();
						Admins admin=adminsd.findAdmins_name(userName);
						if(admin==null){
							session.setAttribute("error","�û��˺Ų�����,�����µ�½��ע��");
							fanhui= "index";
							session.setAttribute("scc", null);//sccΪ0��ʾ��¼ʧ��
						}else if(!admin.getPassword().equals(password)){   //�������
							session.setAttribute("error", "�û��������");
							fanhui= "index";
							session.setAttribute("scc", null);//sccΪ0��ʾ��¼ʧ��
						}else if(admin.getPassword().equals(password)){
							//���ͨ��--��¼//����Cookie
							/*//Ҫ����--��Ч·��/�����ڴ棿/����
							Cookie cookie=new Cookie("Code",code);
							res.addCookie(cookie);
							//��session��дһ�������е�Cookie��
							HttpSession session=req.getSession();
							session.setAttribute("Code", code);
							//�ض�����ҳindex.jsp  */
							
							//���ͨ��
							session.setAttribute("userName",userName);
							session.setAttribute("password", password);
							session.setAttribute("radio", radiotype);
							session.removeAttribute("error");
							session.setAttribute("scc", "1");//sccΪ1��ʾ��¼�ɹ�
							session.setAttribute("yonghu", admin);//��home�еĸ�����Ϣ����ʾ
							fanhui= "home";
							System.out.println("���"+fanhui);
						}
					}
					return fanhui;	
				} catch (Exception e) {
					//һ�㲶���쳣֮��Ĳ���
					//1.��¼��־
					//e.printStackTrace();
					//�׳��쳣
					res.sendRedirect("/Thyroid/index.do");
					//throw new RuntimeException("��ѯʧ��",e);
				}finally{
					
				}
		return null;
	}
}