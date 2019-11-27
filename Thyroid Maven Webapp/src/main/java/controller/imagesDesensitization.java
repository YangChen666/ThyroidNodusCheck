package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * ����ʶ������������
 * @author hcx
 *
 */

@Controller
public class imagesDesensitization {


	@RequestMapping("/roi.do")
	protected String Toup(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		//û������
		return "home_ROI_tuo";
	}

	@RequestMapping("/imgClip.do")
	protected String Clip(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		//û������
		return "home_img_clip";
	}
	@RequestMapping("/clipShow.do")
	protected String clipShow(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		//û������
		return "clipImageFrame";
	}
	//����--�������������ʾ�����ϴ��ɹ�ҳ--���������ʾ��ҳ
	//�����ϴ�����ʾ�ϴ��ɹ�-��ʾ�ϴ�ͼ��--ͼ�����������ύǰ��ʾͼ���ϴ��ɹ�ҳ�������������ʾ����Ҳ
	@RequestMapping("/home_ROI_tuo.do")
	protected String Index(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException, InterruptedException {
		//��ȡsession
		HttpSession session = req.getSession();
		String image_name=(String)session.getAttribute("image_name");
		session.setAttribute("name_qian", image_name);
		String clipParameter=(String)req.getParameter("clipParameter");
		System.out.println("�ü�����"+clipParameter);
		try {
			String[] args1 = new String[] { "E:/IntelliJ Projects/Thyroid/batchFiles/ROI_tuo.bat",image_name,clipParameter};
            Process process = Runtime.getRuntime().exec(args1);
            process.waitFor();
            String newimage_name="ROI_tuo"+image_name;
            session.setAttribute("image_name",newimage_name);
            session.setAttribute("name_ROI_tuo",newimage_name);
        } catch (IOException e) {
        	System.out.println("imagesDesensitization����������");
        }
		return "home_ROI_tuo";
	}
}
