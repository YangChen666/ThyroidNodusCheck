package controller;
/**
 * �����¼�����ļ� ֻ����Դ򿪵�½ҳ��
 * ������index.do �����ĵ�¼ �Ŀ�����loginNew.java�ļ���
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
		//��¼
		return "login_new";
	}
	
	//�����¼ҳ
	@RequestMapping("/tologin.do")
	protected String tologin(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		//��¼
		return "home";
	}
}
