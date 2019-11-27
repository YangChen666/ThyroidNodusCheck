package controller;
/**
 * ������ϴ�ͼ��Ŀ�����
 */
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import Dao.ImagesDeal;
import Dao.ImgDeal;
import entity.Images;
import entity.Img;

@Controller
public class uploadImage {
	
//�ϴ�ͼƬ
	//ȥ�ϴ�ҳ��
	@RequestMapping("/toup.do")
	protected String Toup(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		//û������
		return "home_index_shang";
	}
	
	//�����ϴ�����
	@RequestMapping("/toupimages.do")
	public String toupimages(HttpServletRequest req,@RequestParam("descr") String descr,@RequestParam("file") MultipartFile file) throws IllegalStateException, IOException{
		//ת�����ڸ�ʽ
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//Date��ʽתΪ�ַ���
		//��ȡsession
		HttpSession session = req.getSession();

		//�ж��ļ��Ƿ���ڣ����ڷ��ص��ϴ�չʾҳ�������ڷ��ش���
		if(!file.isEmpty()){
			//ͼƬ����λ��
			String path=req.getServletContext().getRealPath("/Thyroid_images/");
			//
			String filename=file.getOriginalFilename();
			File filepath=new File(path,filename);
			//
			if(!filepath.getParentFile().exists()){
				filepath.getParentFile().mkdirs();
			}
			//
			file.transferTo(new File(path+File.separator+ filename));

			if(session.getAttribute("radio").equals("a")){
				Images image=new Images();
				//image.setName(req.getParameter("name"));//�ļ���
				image.setName(filename);
				image.setPart(req.getParameter("part"));
				image.setResult(req.getParameter("result"));
				image.setDescr(req.getParameter("descr"));
				image.setInst(req.getParameter("inst"));
				//��ҳ���ݶ�ȡ���--���ڼ��ز�����ҳ��ʾ����������
				image.setPath("/Thyroid_images/");//�洢·��
				image.setUser(session.getAttribute("userName").toString());
				image.setSet_time(sdf.format(new Date()));
				//д�����ݿ�
				ImagesDeal imgdeal=new ImagesDeal();
				imgdeal.insert_image(image);
				session.setAttribute("image", image);
			}else if(session.getAttribute("radio").equals("b")){
				Img image=new Img();
				//image.setName(req.getParameter("name"));//�ļ���
				image.setName(filename);
				image.setPart(req.getParameter("part"));
				image.setResult(req.getParameter("result"));
				image.setDescr(req.getParameter("descr"));
				image.setInst(req.getParameter("inst"));
				//��ҳ���ݶ�ȡ���--���ڼ��ز�����ҳ��ʾ����������
				image.setPath("/Thyroid_images/");//�洢·��
				image.setUser(session.getAttribute("userName").toString());
				image.setSet_time(sdf.format(new Date()));
				//д�����ݿ�
				ImgDeal imagesdeal=new ImgDeal();
				imagesdeal.insert_img(image);
				session.setAttribute("image", image);
			}
			else{
				Img image=new Img();
				//image.setName(req.getParameter("name"));//�ļ���
				image.setName(filename);
				image.setPart(req.getParameter("part"));
				image.setResult(req.getParameter("result"));
				image.setDescr(req.getParameter("descr"));
				image.setInst(req.getParameter("inst"));
				session.setAttribute("image", image);
			}
			//��session�д�����//����ͼƬ��-���ϴ�ͼƬչʾҳ����ʾ
			session.setAttribute("image_name", filename);
			session.setAttribute("name", filename);
			session.setAttribute("name_qian", filename);
			//�ϴ��ɹ�֮�󣬵���ʾҳ
			return "home_index_shang_show";
		}else{
			//�ϴ�ʧ�ܣ�������ҳ
			return "error";
		}
		
	}
	//���û�õ�
	@RequestMapping("/home_index_shang_show.do")
	protected String home_index_shang_show(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		//��ʱû������
		return "home_index_shang_show";
	}
	
	
//	@RequestMapping("/toupimages.do")
//	public String toupimages(HttpServletRequest req){
//		//����������
//		System.out.println("/toimage.do");
//		return "upimages";
//	}
	
//���ݿ��ȡͼƬ
		//�����ϴ�����
		@RequestMapping("/mysql.do")
		public String mysql(HttpServletRequest req,@RequestParam("description") String description,@RequestParam("file") MultipartFile file) throws IllegalStateException, IOException{
			//����������
			
				return "home_mysql";
			
			
		}
// images  		
		
		//����ͼ�������--images�������ϴ�
		//ȥ�ϴ�ҳ��
		@RequestMapping("/guanli_upimages.do")
		protected String guanli_images(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
			//û������
			return "home_guanli_upimages";
		}
		
		//�����ϴ�����
		@RequestMapping("/toguanli_upimages.do")
		public void toguanli_upimages(HttpServletRequest req,HttpServletResponse res,@RequestParam("descr") String descr,@RequestParam("file") MultipartFile file) throws IllegalStateException, IOException{
			//ת�����ڸ�ʽ
			SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//Date��ʽתΪ�ַ���
			//��ȡsession
			HttpSession session = req.getSession();
			//System.out.println("descr");
			//�ж��ļ��Ƿ���ڣ����ڷ��ص��ϴ�չʾҳ�������ڷ��ش���
			if(!file.isEmpty()){
				//ͼƬ����λ��
				String path=req.getServletContext().getRealPath("/Thyroid_images/");
				System.out.println(path);
				//
				String filename=file.getOriginalFilename();
				File filepath=new File(path,filename);
				//
				if(!filepath.getParentFile().exists()){
					filepath.getParentFile().mkdirs();
				}
				//
				file.transferTo(new File(path+File.separator+ filename));
				//����ҳ��������
				Images image=new Images();
				//image.setName(req.getParameter("name"));//�ļ���
				image.setName(filename);
				image.setPart(req.getParameter("part"));
				image.setResult(req.getParameter("result"));
				image.setDescr(req.getParameter("descr"));
				image.setInst(req.getParameter("inst"));
				//��ҳ���ݶ�ȡ���--���ڼ��ز�����ҳ��ʾ����������
				image.setPath("/Thyroid_images/");//�洢·��
				image.setUser(session.getAttribute("userName").toString());
				image.setSet_time(sdf.format(new Date()));
				//д�����ݿ�
				ImagesDeal imagesdeal=new ImagesDeal();
				imagesdeal.insert_image(image);
				//��session�д�����//����ͼƬ��-���ϴ�ͼƬչʾҳ����ʾ
				session.setAttribute("image_name", filename);
				session.setAttribute("name", filename);
				session.setAttribute("name_qian", filename);
				System.out.println(session.getAttribute("image_name"));
				//�ϴ��ɹ�֮�󣬵���ʾҳ
				res.sendRedirect("mysql_adminer.do");
//				res.sendRedirect("/Thyroid/mysql_adminer.do");//ת������ѯҲ
				//return "home_mysql_adminer";
			}else{
				//�ϴ�ʧ�ܣ�������ҳ
				//return "error";
			}
			
		}
		
		
		
		
// img  		
		
				//����ͼ�������--images�������ϴ�
				//ȥ�ϴ�ҳ��
				@RequestMapping("/guanli_upimg.do")
				protected String guanli_upimg(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
					//û������
					return "home_guanli_upimg";
				}		
		

			//�����ϴ�����
			@RequestMapping("/toguanli_upimg.do")
			public void toguanli_upimg(HttpServletRequest req,HttpServletResponse res,@RequestParam("descr") String descr,@RequestParam("file") MultipartFile file) throws IllegalStateException, IOException{
				//ת�����ڸ�ʽ
				SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");//Date��ʽתΪ�ַ���
				//��ȡsession
				HttpSession session = req.getSession();
				//System.out.println("descr");
				//�ж��ļ��Ƿ���ڣ����ڷ��ص��ϴ�չʾҳ�������ڷ��ش���
				if(!file.isEmpty()){
					//ͼƬ����λ��
					String path=req.getServletContext().getRealPath("/Thyroid_images/");
					System.out.println(path);
					//
					String filename=file.getOriginalFilename();
					File filepath=new File(path,filename);
					//
					if(!filepath.getParentFile().exists()){
						filepath.getParentFile().mkdirs();
					}
					//
					file.transferTo(new File(path+File.separator+ filename));
					//����ҳ��������
					Img image=new Img();
					//image.setName(req.getParameter("name"));//�ļ���
					image.setName(filename);
					image.setPart(req.getParameter("part"));
					image.setResult(req.getParameter("result"));
					image.setDescr(req.getParameter("descr"));
					image.setInst(req.getParameter("inst"));
					//��ҳ���ݶ�ȡ���--���ڼ��ز�����ҳ��ʾ����������
					image.setPath("/Thyroid_images/");//�洢·��
					image.setUser(session.getAttribute("userName").toString());
					Date date=new Date();
					System.out.println(date);
					image.setSet_time(sdf.format(new Date()));
					//д�����ݿ�
					ImgDeal imgdeal=new ImgDeal();
					imgdeal.insert_img(image);
					//��session�д�����//����ͼƬ��-���ϴ�ͼƬչʾҳ����ʾ
					session.setAttribute("image_name", filename);
					session.setAttribute("name", filename);
					session.setAttribute("name_qian", filename);
					System.out.println(session.getAttribute("image_name"));
					//�ϴ��ɹ�֮�󣬵���ʾҳ
					res.sendRedirect("mysql_user.do");
//					res.sendRedirect("/Thyroid/mysql_user.do");//ת������ѯҲ
					//return "home_mysql_adminer";
				}else{
					//�ϴ�ʧ�ܣ�������ҳ
					//return "error";
				}
				
			}
}
