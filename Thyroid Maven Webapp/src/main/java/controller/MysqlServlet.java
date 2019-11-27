package controller;
/**
 * �����дͼ��Ĳ�ѯ/����ȵĲ�����
 */
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import Dao.ImagesDeal;
import Dao.ImgDeal;
import entity.Images;
import entity.Img;

@Controller
public class MysqlServlet{
	
	//��������ݿ��ȡ���ݽ��н�ڷ�����Ǹ�������
	@RequestMapping("/mysql_select.do")
	protected String mysql_select(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		//���շ��صĴ򿪵�Spring�������ļ����ҵ���ҳ�ĵ�ַ
		String str=null;
		//��ȡsession
		HttpSession session=req.getSession();
		//��֧---a/b
		if(session.getAttribute("radio").toString().equals("a")){
			List<Images> list=new ArrayList<Images>();
			//���ղ�ѯ������
			ImagesDeal imd=new ImagesDeal();
			String sr=session.getAttribute("userName").toString();
			list=imd.findAll_users(sr);
			session.setAttribute("list", list);
			session.setAttribute("listNo", 1);

		}else if(session.getAttribute("radio").equals("b")){
			List<Img> list=new ArrayList<Img>();
			ImgDeal imde=new ImgDeal();
			list=imde.findAll();
			session.setAttribute("list", list);
			session.setAttribute("listNo", 2);
		}else{
			//�����ǻ���Ҳ���ǹ���Ա�����ܲ�ѯ���ο�Ҳ���ܲ�ѯ��
			session.setAttribute("listNo", 0);
			System.out.println("�ο�mysql_select.do");
		}
		return "home_mysql";
	}
	
//images    ��ʼ
	//����Ƕ� /mysql_select.do  �е�����ѡ�У�Ȼ����������
	//ͼ���ȡ�У������ݿ�ķ�ʽ��ȡ�����ʹ�ø�ͼ�󣬻�ȡ��ͼ�����Ϣ��Ȼ�����ϴ�ͼ������ʾҵ��ʾ
	@RequestMapping("/select_shiyong.do")
	protected String select_shiyong(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		//��ȡ��ͼ���ID�ţ������ҵ���Ӧ��ͼ����
		//��ȡ���ݵı��루��ȡ��¼ҳ����Ϣ��
		req.setCharacterEncoding("utf-8");
		//��������-������ҳ����������(��ȡ��ҳ��Ϣ)--�˴���ͼ��id(images��)
		int id=Integer.parseInt(req.getParameter("tupianid"));//Integer.parseInt(s):Stringתint
//		String str=req.getParameter("tupianname");
//		System.out.println(str);
		//ͨ�����ݿ��ȡͼ������
		ImgDeal imagesdeal=new ImgDeal();
		Img image=imagesdeal.findOne_Id(id);//���ݿ��ѯ
		//��ȡsession
		HttpSession session=req.getSession();
		session.setAttribute("image", image);
		session.setAttribute("name", image.getName());
		session.setAttribute("image_name", image.getName());
		//System.out.println(image.getName());
		return "home_index_shang_show";
	}
	
	
	
	//����Ƕ����ݿ����ݽ��й����     images
	//����Ա�����ݿ�Ĺ���--ҽԺ����
	@RequestMapping("/mysql_adminer.do")
	protected String mysql_adminer(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		//��ȡsession
		HttpSession session=req.getSession();
		//�ж��Ƿ�Ϊ������
		List<Img> list=new ArrayList<Img>();
		//�ǹ�����--��ѯ��������
		ImgDeal imde=new ImgDeal();
		list=imde.findAll();
		session.setAttribute("list", list);
		session.setAttribute("listNo", 2);
		return "home_mysql_adminer";
	}
	
	//Ԥ����  images
	//����Ƕ�   ����ͼ����� �� ��images���е����ݽ��и��µ�    �е�����ѡ�У�Ȼ����������
		@RequestMapping("/guanli_xuigai_images.do")
		protected String guanli_xuigai_images(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
			//��ȡ��ͼ���ID�ţ������ҵ���Ӧ��ͼ����
			//��ȡ���ݵı��루��ȡ��¼ҳ����Ϣ��
			req.setCharacterEncoding("utf-8");
			//��������-������ҳ����������(��ȡ��ҳ��Ϣ)--�˴���ͼ��id(images��)
			int id=Integer.parseInt(req.getParameter("tupianid"));//Integer.parseInt(s):Stringתint
			//ͨ�����ݿ��ȡͼ������
			ImagesDeal imagesdeal=new ImagesDeal(); 
			Images image=imagesdeal.findOne_Id(id);//���ݿ��ѯ
			System.out.println("��ȡһ������");
			//��ȡsession
			HttpSession session=req.getSession();
			session.setAttribute("image", image);
			return "home_guanli_xuigai_images";
		}
		//����  images
		//����ǶԳ���ͼ������е�images���е����ݽ��и��µ��������֮��ĸ������ݿ��е������е�����ѡ�У�Ȼ����������
				@RequestMapping("/guanli_xuigai_images_update.do")
				protected void guanli_xuigai_images_update(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
					//��ȡ��ͼ���ID�ţ������ҵ���Ӧ��ͼ����
					//��ȡ���ݵı��루��ȡ��¼ҳ����Ϣ��
					req.setCharacterEncoding("utf-8");

					String path=req.getServletContext().getRealPath("/Thyroid_images/");
					ImagesDeal imageSearch=new ImagesDeal();
					Images imageSource=imageSearch.findOne_Id(Integer.parseInt(req.getParameter("id")));//���ݿ��ѯ
					String originalName=imageSource.getName();
					String newName=req.getParameter("name");
					String originalPath = path+originalName;
					String newPath=path+newName;
					File file = new File(originalPath);
					File newFile = new File(newPath);
					file.renameTo(newFile);

					Images image=new Images();
					ImagesDeal imagesdeal=new ImagesDeal();
					//��������-������ҳ����������(��ȡ��ҳ��Ϣ)--�˴���ͼ��id(images��)
					image.setName(req.getParameter("name"));
					image.setPart(req.getParameter("part"));
					image.setDescr(req.getParameter("descr"));
					image.setResult(req.getParameter("result"));
					image.setInst(req.getParameter("inst"));
					image.setId(Integer.parseInt(req.getParameter("id")));
					//ͨ�����ݿ��ȡͼ������
					 
					imagesdeal.update_image(image);//���ݿ��ѯ
					//��ȡsession
					//HttpSession session=req.getSession();
					//session.setAttribute("image", image);
					//res.sendRedirect("/Thyroid/mysql_user.do");//ת������ѯҲ
					res.sendRedirect("mysql_user.do");
					//return "home_mysql_user";
				}
				
				//ɾ��  images
				//����Ƕ�   ����ͼ����� �� ��images���е����ݽ���ɾ��
						@RequestMapping("/guanli_xuigai_images_delete.do")
						protected void guanli_xuigai_images_delete(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
							//��ȡ��ͼ���ID�ţ������ҵ���Ӧ��ͼ����
							//��ȡ���ݵı��루��ȡ��¼ҳ����Ϣ��
							req.setCharacterEncoding("utf-8");
							ImagesDeal imagesdeal=new ImagesDeal();
							//��������-������ҳ����������(��ȡ��ҳ��Ϣ)--�˴���ͼ��id(images��)
							int id=Integer.parseInt(req.getParameter("tupianid"));
							//ͨ�����ݿ��ȡͼ������
							imagesdeal.delete_image(id);//���ݿ��ѯ
							//��ȡsession

							res.sendRedirect("mysql_user.do");
//							res.sendRedirect("/Thyroid/mysql_user.do");//ת������ѯҲ
							//return "home_mysql_user";
						}
						
						//����ͼƬ������    images
						//����Ƕ�   ����ͼ����� �� ��images���е����ݽ���ɾ��
								@RequestMapping("/guanli_xuigai_images_so.do")
								protected void guanli_xuigai_images_so(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
									//��ȡ��ͼ���ID�ţ������ҵ���Ӧ��ͼ����
									//��ȡ���ݵı��루��ȡ��¼ҳ����Ϣ��
									req.setCharacterEncoding("utf-8");
									ImagesDeal imagesdeal=new ImagesDeal();
									List<Images> list=new ArrayList<Images>();
									//��������-������ҳ����������(��ȡ��ҳ��Ϣ)--�˴���ͼ��id(images��)
									String name=req.getParameter("name");
									Images image=imagesdeal.findOne_Name(name);
									
									list.add(image);
									
									//ͨ�����ݿ��ȡͼ������
									//��ȡsession
									HttpSession session=req.getSession();
									session.setAttribute("image",image);

									//res.sendRedirect("/Thyroid/mysql_user.do");//ת������ѯҲ
									res.sendRedirect("mysql_user.do");
									//return "home_mysql_user";
								}
		
	
	
//img  ��ʼ	
	
		//����Ƕ����ݿ����ݽ��й����
		@RequestMapping("/mysql_user.do")
		protected String mysql_user(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
			//��ȡsession
			HttpSession session=req.getSession();
			List<Images> list=new ArrayList<Images>();
			//�ж��Ƿ�Ϊ������
			//�ǻ���--��ѯ�Լ���������
			ImagesDeal imd=new ImagesDeal();
			String sr=session.getAttribute("userName").toString();
			list=imd.findAll_users(sr);
			session.setAttribute("list", list);
//			session.setAttribute("listNo", 1);
			return "home_mysql_user";
		}
		
		
		//����Ƕ� �����
		//ͼ���ȡ�У������ݿ�ķ�ʽ��ȡ�����ʹ�ø�ͼ�󣬻�ȡ��ͼ�����Ϣ��Ȼ�����ϴ�ͼ������ʾҵ��ʾ
		@RequestMapping("/select_shiyong_user.do")
		protected String select_shiyong_user(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
			//��ȡ��ͼ���ID�ţ������ҵ���Ӧ��ͼ����
			//��ȡ���ݵı��루��ȡ��¼ҳ����Ϣ��
			req.setCharacterEncoding("utf-8");
			//��������-������ҳ����������(��ȡ��ҳ��Ϣ)--�˴���ͼ��id(images��)
			int id=Integer.parseInt(req.getParameter("tupianid"));//Integer.parseInt(s):Stringתint
//			String str=req.getParameter("tupianname");
//			System.out.println(str);
			//ͨ�����ݿ��ȡͼ������
			ImagesDeal imgdeal=new ImagesDeal();
			Images image=imgdeal.findOne_Id(id);//���ݿ��ѯ
			//��ȡsession
			HttpSession session=req.getSession();
			session.setAttribute("image", image);
			session.setAttribute("name", image.getName());
			session.setAttribute("image_name", image.getName());
			//System.out.println(image.getName());
			return "home_index_shang_show";
		}
		
		//Ԥ����  img
		//����Ƕ�   ����ͼ����� �� ��images���е����ݽ��и��µ�    �е�����ѡ�У�Ȼ����������
			@RequestMapping("/guanli_xuigai_img.do")
			protected String guanli_xuigai_img(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
				//��ȡ��ͼ���ID�ţ������ҵ���Ӧ��ͼ����
				//��ȡ���ݵı��루��ȡ��¼ҳ����Ϣ��
				req.setCharacterEncoding("utf-8");
				//��������-������ҳ����������(��ȡ��ҳ��Ϣ)--�˴���ͼ��id(images��)
				int id=Integer.parseInt(req.getParameter("tupianid"));//Integer.parseInt(s):Stringתint
				//ͨ�����ݿ��ȡͼ������
				ImgDeal imgdeal=new ImgDeal(); 
				Img image=imgdeal.findOne_Id(id);//���ݿ��ѯ
				//System.out.println("��ȡһ������");
				//��ȡsession
				HttpSession session=req.getSession();
				session.setAttribute("image", image);
				return "home_guanli_xuigai_img";
			}
		//����  img
				//����Ƕ�   ����ͼ����� �� ��images���е����ݽ��и��µ��������֮��� �������ݿ��е�����    �е�����ѡ�У�Ȼ����������
						@RequestMapping("/guanli_xuigai_img_update.do")
						protected void guanli_xuigai_img_update(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
							//��ȡ��ͼ���ID�ţ������ҵ���Ӧ��ͼ����
							//��ȡ���ݵı��루��ȡ��¼ҳ����Ϣ��
							req.setCharacterEncoding("utf-8");

							String path=req.getServletContext().getRealPath("/Thyroid_images/");
							ImgDeal imgSearch=new ImgDeal();
							Img imgSource=imgSearch.findOne_Id(Integer.parseInt(req.getParameter("id")));//���ݿ��ѯ
							String originalName=imgSource.getName();
							String newName=req.getParameter("name");
							String originalPath = path+originalName;
							String newPath=path+newName;
							File file = new File(originalPath);
							File newFile = new File(newPath);
							file.renameTo(newFile);

							Img image=new Img();
							ImgDeal imgdeal=new ImgDeal();
							//��������-������ҳ����������(��ȡ��ҳ��Ϣ)--�˴���ͼ��id(images��)
							image.setName(req.getParameter("name"));
							image.setPart(req.getParameter("part"));
							image.setDescr(req.getParameter("descr"));
							image.setResult(req.getParameter("result"));
							image.setInst(req.getParameter("inst"));
							image.setId(Integer.parseInt(req.getParameter("id")));
							//ͨ�����ݿ��ȡͼ������
							 
							imgdeal.update_image(image);//���ݿ��ѯ
							//��ȡsession
							HttpSession session=req.getSession();
							session.setAttribute("image", image);
							//res.sendRedirect("/Thyroid/mysql_adminer.do");//ת������ѯҲ
							res.sendRedirect("mysql_adminer.do");
							//return "home_mysql_adminer";
						}
		
		
		
		//ɾ��  img
		//����Ƕ�   ����ͼ����� �� ��images���е����ݽ���ɾ��
				@RequestMapping("/guanli_xuigai_img_delete.do")
				protected void guanli_xuigai_img_delete(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
					//��ȡ��ͼ���ID�ţ������ҵ���Ӧ��ͼ����
					//��ȡ���ݵı��루��ȡ��¼ҳ����Ϣ��
					req.setCharacterEncoding("utf-8");
					ImgDeal imgdeal=new ImgDeal();
					//��������-������ҳ����������(��ȡ��ҳ��Ϣ)--�˴���ͼ��id(images��)
					int id=Integer.parseInt(req.getParameter("tupianid"));
					//System.out.println("ɾ��"+id);
					//ͨ�����ݿ��ȡͼ������
					imgdeal.delete_image(id);//���ݿ��ѯ
					//��ȡsession
					res.sendRedirect("mysql_adminer.do");
//					res.sendRedirect("/Thyroid/mysql_user.do");//ת������ѯҲ
					//return "home_mysql_adminer";
				}
}