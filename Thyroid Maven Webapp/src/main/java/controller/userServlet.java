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
 * ע���û����һ�����
 * @author hcx
 *
 */
@Controller
public class userServlet {
	
	
	//�û�ע��
			@RequestMapping("/registered.do")   //��ע��
			protected String registered(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
				HttpSession session=req.getSession();
				return "login_registered";
			}

	//��������
	@RequestMapping("/forgotPassword.do")   //��������
	protected String forgotPassword(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		HttpSession session=req.getSession();
		return "forgot_password";
	}
	
	//ע��ҳ��
	@RequestMapping("/zhuce.do")
	protected String zhuce(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		HttpSession session=req.getSession();
		req.setCharacterEncoding("utf-8");
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");//Date��ʽתΪ�ַ���
		try{
			Users user=new Users();
			UsersDeal usersd=new UsersDeal();
			user.setName(req.getParameter("name"));
			if(req.getParameter("password").equals(req.getParameter("confirm_psw"))){
				user.setPassword(req.getParameter("password"));
			}
			else{
				session.setAttribute("zhuce", "�������벻һ�£����������룡");
				return "login_registered";
			}
			if(req.getParameter("sex").equals("m")){  //mΪ�У�wΪŮ
				user.setSex("��");
			}else if(req.getParameter("sex").equals("w")){
				user.setSex("Ů");
			}
			user.setMobile(req.getParameter("mobile"));
			user.setEmail(req.getParameter("email"));
			user.setBirt(req.getParameter("birt"));
			user.setSet_time(sdf.format(new Date()));
			//д���
			usersd.insert_user(user);
			session.setAttribute("zhuce", "ע��ɹ����¼��");
			
		} catch (Exception e) {
			session.setAttribute("zhuce", "ע��ʧ�ܣ�������ע�ᣡ");
			//throw new RuntimeException("��ѯʧ��",e);
		}finally{	
		}
		return "login_registered";
		
	}
	
	
	
	//�һ�����ҳ��
		@RequestMapping("/mima.do")
		protected String mima(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
			HttpSession session=req.getSession();
			req.setCharacterEncoding("utf-8");
			SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");//Date��ʽתΪ�ַ���
			try{
				Users user=new Users();//�����ҳ��ȡ����
				UsersDeal usersd=new UsersDeal();
				//��ȡ����
				user.setName(req.getParameter("name").toString());
				if(req.getParameter("sex").toString().equals("m")){  //mΪ�У�wΪŮ
					user.setSex("��");
				}else if(req.getParameter("sex").toString().equals("w")){
					user.setSex("Ů");
				}
				user.setMobile(req.getParameter("mobile"));
				user.setEmail(req.getParameter("email").toString());
				user.setBirt(req.getParameter("birt").toString());
				//��ѯ��������--�����û���
				Users usercha = usersd.findOne_Name(user.getName());//������ݿ��ѯ����
				//�Ա� ��ȷ��������  ������ʾ����
				System.out.println(usercha.getName());
				if(user.getName().equals(usercha.getName())){
					if(user.getSex().equals(usercha.getSex())){
						if(user.getMobile().equals(usercha.getMobile())){
							if(user.getEmail().equals(usercha.getEmail())){
								if(user.getBirt().equals(usercha.getBirt())){
									session.setAttribute("mima", "����Ϊ��"+usercha.getPassword());
								}else{
									session.setAttribute("mima", "�û��������ڴ���");
								}
							}else{
								session.setAttribute("mima", "�û��������");
							}
						}else{
							session.setAttribute("mima", "�û��ֻ��Ŵ���");
						}
					}else{
						session.setAttribute("mima", "�û��Ա����");
					}
				}else{
					session.setAttribute("mima", "�û������ڣ�");
				}

				
				
			} catch (Exception e) {
				session.setAttribute("mima", "�û������ڣ�");
			}finally{	
			}
			return "login_registered";
			
		}
}
