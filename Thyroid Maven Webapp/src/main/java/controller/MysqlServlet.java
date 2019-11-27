package controller;
/**
 * 这个是写图像的查询/插入等的操作的
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
	
	//这个是数据库获取数据进行结节分类的那个操作的
	@RequestMapping("/mysql_select.do")
	protected String mysql_select(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		//接收返回的打开的Spring的配置文件中找到网页的地址
		String str=null;
		//获取session
		HttpSession session=req.getSession();
		//分支---a/b
		if(session.getAttribute("radio").toString().equals("a")){
			List<Images> list=new ArrayList<Images>();
			//接收查询出来的
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
			//即不是患者也不是管理员，则不能查询（游客也不能查询）
			session.setAttribute("listNo", 0);
			System.out.println("游客mysql_select.do");
		}
		return "home_mysql";
	}
	
//images    开始
	//这个是对 /mysql_select.do  中的数据选中，然后出来里分类
	//图像获取中，以数据库的方式获取，点击使用该图后，获取该图相关信息，然后再上传图像后的显示业显示
	@RequestMapping("/select_shiyong.do")
	protected String select_shiyong(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		//获取该图像的ID号，以来找到相应的图像名
		//获取数据的编码（获取登录页的信息）
		req.setCharacterEncoding("utf-8");
		//创建变量-接收网页传来的数据(获取网页信息)--此处是图像id(images的)
		int id=Integer.parseInt(req.getParameter("tupianid"));//Integer.parseInt(s):String转int
//		String str=req.getParameter("tupianname");
//		System.out.println(str);
		//通过数据库获取图像名称
		ImgDeal imagesdeal=new ImgDeal();
		Img image=imagesdeal.findOne_Id(id);//数据库查询
		//获取session
		HttpSession session=req.getSession();
		session.setAttribute("image", image);
		session.setAttribute("name", image.getName());
		session.setAttribute("image_name", image.getName());
		//System.out.println(image.getName());
		return "home_index_shang_show";
	}
	
	
	
	//这个是对数据库数据进行管理的     images
	//管理员对数据库的管理--医院数据
	@RequestMapping("/mysql_adminer.do")
	protected String mysql_adminer(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		//获取session
		HttpSession session=req.getSession();
		//判断是否为管理者
		List<Img> list=new ArrayList<Img>();
		//是管理者--查询所有数据
		ImgDeal imde=new ImgDeal();
		list=imde.findAll();
		session.setAttribute("list", list);
		session.setAttribute("listNo", 2);
		return "home_mysql_adminer";
	}
	
	//预更改  images
	//这个是对   超声图像管理 中 的images表中的数据进行更新的    中的数据选中，然后出来里分类
		@RequestMapping("/guanli_xuigai_images.do")
		protected String guanli_xuigai_images(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
			//获取该图像的ID号，以来找到相应的图像名
			//获取数据的编码（获取登录页的信息）
			req.setCharacterEncoding("utf-8");
			//创建变量-接收网页传来的数据(获取网页信息)--此处是图像id(images的)
			int id=Integer.parseInt(req.getParameter("tupianid"));//Integer.parseInt(s):String转int
			//通过数据库获取图像名称
			ImagesDeal imagesdeal=new ImagesDeal(); 
			Images image=imagesdeal.findOne_Id(id);//数据库查询
			System.out.println("获取一条数据");
			//获取session
			HttpSession session=req.getSession();
			session.setAttribute("image", image);
			return "home_guanli_xuigai_images";
		}
		//更改  images
		//这个是对超声图像管理中的images表中的数据进行更新的输入完成之后的更改数据库中的数据中的数据选中，然后出来里分类
				@RequestMapping("/guanli_xuigai_images_update.do")
				protected void guanli_xuigai_images_update(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
					//获取该图像的ID号，以来找到相应的图像名
					//获取数据的编码（获取登录页的信息）
					req.setCharacterEncoding("utf-8");

					String path=req.getServletContext().getRealPath("/Thyroid_images/");
					ImagesDeal imageSearch=new ImagesDeal();
					Images imageSource=imageSearch.findOne_Id(Integer.parseInt(req.getParameter("id")));//数据库查询
					String originalName=imageSource.getName();
					String newName=req.getParameter("name");
					String originalPath = path+originalName;
					String newPath=path+newName;
					File file = new File(originalPath);
					File newFile = new File(newPath);
					file.renameTo(newFile);

					Images image=new Images();
					ImagesDeal imagesdeal=new ImagesDeal();
					//创建变量-接收网页传来的数据(获取网页信息)--此处是图像id(images的)
					image.setName(req.getParameter("name"));
					image.setPart(req.getParameter("part"));
					image.setDescr(req.getParameter("descr"));
					image.setResult(req.getParameter("result"));
					image.setInst(req.getParameter("inst"));
					image.setId(Integer.parseInt(req.getParameter("id")));
					//通过数据库获取图像名称
					 
					imagesdeal.update_image(image);//数据库查询
					//获取session
					//HttpSession session=req.getSession();
					//session.setAttribute("image", image);
					//res.sendRedirect("/Thyroid/mysql_user.do");//转发到查询也
					res.sendRedirect("mysql_user.do");
					//return "home_mysql_user";
				}
				
				//删除  images
				//这个是对   超声图像管理 中 的images表中的数据进行删除
						@RequestMapping("/guanli_xuigai_images_delete.do")
						protected void guanli_xuigai_images_delete(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
							//获取该图像的ID号，以来找到相应的图像名
							//获取数据的编码（获取登录页的信息）
							req.setCharacterEncoding("utf-8");
							ImagesDeal imagesdeal=new ImagesDeal();
							//创建变量-接收网页传来的数据(获取网页信息)--此处是图像id(images的)
							int id=Integer.parseInt(req.getParameter("tupianid"));
							//通过数据库获取图像名称
							imagesdeal.delete_image(id);//数据库查询
							//获取session

							res.sendRedirect("mysql_user.do");
//							res.sendRedirect("/Thyroid/mysql_user.do");//转发到查询也
							//return "home_mysql_user";
						}
						
						//根据图片名搜索    images
						//这个是对   超声图像管理 中 的images表中的数据进行删除
								@RequestMapping("/guanli_xuigai_images_so.do")
								protected void guanli_xuigai_images_so(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
									//获取该图像的ID号，以来找到相应的图像名
									//获取数据的编码（获取登录页的信息）
									req.setCharacterEncoding("utf-8");
									ImagesDeal imagesdeal=new ImagesDeal();
									List<Images> list=new ArrayList<Images>();
									//创建变量-接收网页传来的数据(获取网页信息)--此处是图像id(images的)
									String name=req.getParameter("name");
									Images image=imagesdeal.findOne_Name(name);
									
									list.add(image);
									
									//通过数据库获取图像名称
									//获取session
									HttpSession session=req.getSession();
									session.setAttribute("image",image);

									//res.sendRedirect("/Thyroid/mysql_user.do");//转发到查询也
									res.sendRedirect("mysql_user.do");
									//return "home_mysql_user";
								}
		
	
	
//img  开始	
	
		//这个是对数据库数据进行管理的
		@RequestMapping("/mysql_user.do")
		protected String mysql_user(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
			//获取session
			HttpSession session=req.getSession();
			List<Images> list=new ArrayList<Images>();
			//判断是否为管理者
			//是患者--查询自己所有数据
			ImagesDeal imd=new ImagesDeal();
			String sr=session.getAttribute("userName").toString();
			list=imd.findAll_users(sr);
			session.setAttribute("list", list);
//			session.setAttribute("listNo", 1);
			return "home_mysql_user";
		}
		
		
		//这个是对 管理的
		//图像获取中，以数据库的方式获取，点击使用该图后，获取该图相关信息，然后再上传图像后的显示业显示
		@RequestMapping("/select_shiyong_user.do")
		protected String select_shiyong_user(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
			//获取该图像的ID号，以来找到相应的图像名
			//获取数据的编码（获取登录页的信息）
			req.setCharacterEncoding("utf-8");
			//创建变量-接收网页传来的数据(获取网页信息)--此处是图像id(images的)
			int id=Integer.parseInt(req.getParameter("tupianid"));//Integer.parseInt(s):String转int
//			String str=req.getParameter("tupianname");
//			System.out.println(str);
			//通过数据库获取图像名称
			ImagesDeal imgdeal=new ImagesDeal();
			Images image=imgdeal.findOne_Id(id);//数据库查询
			//获取session
			HttpSession session=req.getSession();
			session.setAttribute("image", image);
			session.setAttribute("name", image.getName());
			session.setAttribute("image_name", image.getName());
			//System.out.println(image.getName());
			return "home_index_shang_show";
		}
		
		//预更改  img
		//这个是对   超声图像管理 中 的images表中的数据进行更新的    中的数据选中，然后出来里分类
			@RequestMapping("/guanli_xuigai_img.do")
			protected String guanli_xuigai_img(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
				//获取该图像的ID号，以来找到相应的图像名
				//获取数据的编码（获取登录页的信息）
				req.setCharacterEncoding("utf-8");
				//创建变量-接收网页传来的数据(获取网页信息)--此处是图像id(images的)
				int id=Integer.parseInt(req.getParameter("tupianid"));//Integer.parseInt(s):String转int
				//通过数据库获取图像名称
				ImgDeal imgdeal=new ImgDeal(); 
				Img image=imgdeal.findOne_Id(id);//数据库查询
				//System.out.println("获取一条数据");
				//获取session
				HttpSession session=req.getSession();
				session.setAttribute("image", image);
				return "home_guanli_xuigai_img";
			}
		//更改  img
				//这个是对   超声图像管理 中 的images表中的数据进行更新的输入完成之后的 更改数据库中的数据    中的数据选中，然后出来里分类
						@RequestMapping("/guanli_xuigai_img_update.do")
						protected void guanli_xuigai_img_update(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
							//获取该图像的ID号，以来找到相应的图像名
							//获取数据的编码（获取登录页的信息）
							req.setCharacterEncoding("utf-8");

							String path=req.getServletContext().getRealPath("/Thyroid_images/");
							ImgDeal imgSearch=new ImgDeal();
							Img imgSource=imgSearch.findOne_Id(Integer.parseInt(req.getParameter("id")));//数据库查询
							String originalName=imgSource.getName();
							String newName=req.getParameter("name");
							String originalPath = path+originalName;
							String newPath=path+newName;
							File file = new File(originalPath);
							File newFile = new File(newPath);
							file.renameTo(newFile);

							Img image=new Img();
							ImgDeal imgdeal=new ImgDeal();
							//创建变量-接收网页传来的数据(获取网页信息)--此处是图像id(images的)
							image.setName(req.getParameter("name"));
							image.setPart(req.getParameter("part"));
							image.setDescr(req.getParameter("descr"));
							image.setResult(req.getParameter("result"));
							image.setInst(req.getParameter("inst"));
							image.setId(Integer.parseInt(req.getParameter("id")));
							//通过数据库获取图像名称
							 
							imgdeal.update_image(image);//数据库查询
							//获取session
							HttpSession session=req.getSession();
							session.setAttribute("image", image);
							//res.sendRedirect("/Thyroid/mysql_adminer.do");//转发到查询也
							res.sendRedirect("mysql_adminer.do");
							//return "home_mysql_adminer";
						}
		
		
		
		//删除  img
		//这个是对   超声图像管理 中 的images表中的数据进行删除
				@RequestMapping("/guanli_xuigai_img_delete.do")
				protected void guanli_xuigai_img_delete(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
					//获取该图像的ID号，以来找到相应的图像名
					//获取数据的编码（获取登录页的信息）
					req.setCharacterEncoding("utf-8");
					ImgDeal imgdeal=new ImgDeal();
					//创建变量-接收网页传来的数据(获取网页信息)--此处是图像id(images的)
					int id=Integer.parseInt(req.getParameter("tupianid"));
					//System.out.println("删除"+id);
					//通过数据库获取图像名称
					imgdeal.delete_image(id);//数据库查询
					//获取session
					res.sendRedirect("mysql_adminer.do");
//					res.sendRedirect("/Thyroid/mysql_user.do");//转发到查询也
					//return "home_mysql_adminer";
				}
}