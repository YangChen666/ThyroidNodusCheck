package controller;
/**
 * 这个是上传图像的控制类
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
	
//上传图片
	//去上传页面
	@RequestMapping("/toup.do")
	protected String Toup(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		//没有数据
		return "home_index_shang";
	}
	
	//具体上传处理
	@RequestMapping("/toupimages.do")
	public String toupimages(HttpServletRequest req,@RequestParam("descr") String descr,@RequestParam("file") MultipartFile file) throws IllegalStateException, IOException{
		//转换日期格式
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//Date格式转为字符串
		//获取session
		HttpSession session = req.getSession();

		//判断文件是否存在，存在返回到上传展示页，不存在返回错误
		if(!file.isEmpty()){
			//图片保存位置
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
				//image.setName(req.getParameter("name"));//文件名
				image.setName(filename);
				image.setPart(req.getParameter("part"));
				image.setResult(req.getParameter("result"));
				image.setDescr(req.getParameter("descr"));
				image.setInst(req.getParameter("inst"));
				//网页数据读取完成--现在加载不再网页显示的其他数据
				image.setPath("/Thyroid_images/");//存储路径
				image.setUser(session.getAttribute("userName").toString());
				image.setSet_time(sdf.format(new Date()));
				//写入数据库
				ImagesDeal imgdeal=new ImagesDeal();
				imgdeal.insert_image(image);
				session.setAttribute("image", image);
			}else if(session.getAttribute("radio").equals("b")){
				Img image=new Img();
				//image.setName(req.getParameter("name"));//文件名
				image.setName(filename);
				image.setPart(req.getParameter("part"));
				image.setResult(req.getParameter("result"));
				image.setDescr(req.getParameter("descr"));
				image.setInst(req.getParameter("inst"));
				//网页数据读取完成--现在加载不再网页显示的其他数据
				image.setPath("/Thyroid_images/");//存储路径
				image.setUser(session.getAttribute("userName").toString());
				image.setSet_time(sdf.format(new Date()));
				//写入数据库
				ImgDeal imagesdeal=new ImgDeal();
				imagesdeal.insert_img(image);
				session.setAttribute("image", image);
			}
			else{
				Img image=new Img();
				//image.setName(req.getParameter("name"));//文件名
				image.setName(filename);
				image.setPart(req.getParameter("part"));
				image.setResult(req.getParameter("result"));
				image.setDescr(req.getParameter("descr"));
				image.setInst(req.getParameter("inst"));
				session.setAttribute("image", image);
			}
			//往session中存数据//存入图片名-在上传图片展示页中显示
			session.setAttribute("image_name", filename);
			session.setAttribute("name", filename);
			session.setAttribute("name_qian", filename);
			//上传成功之后，到显示页
			return "home_index_shang_show";
		}else{
			//上传失败，到错误页
			return "error";
		}
		
	}
	//这个没用到
	@RequestMapping("/home_index_shang_show.do")
	protected String home_index_shang_show(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		//暂时没有数据
		return "home_index_shang_show";
	}
	
	
//	@RequestMapping("/toupimages.do")
//	public String toupimages(HttpServletRequest req){
//		//读请求数据
//		System.out.println("/toimage.do");
//		return "upimages";
//	}
	
//数据库获取图片
		//具体上传处理
		@RequestMapping("/mysql.do")
		public String mysql(HttpServletRequest req,@RequestParam("description") String description,@RequestParam("file") MultipartFile file) throws IllegalStateException, IOException{
			//读请求数据
			
				return "home_mysql";
			
			
		}
// images  		
		
		//超声图像管理中--images表数据上传
		//去上传页面
		@RequestMapping("/guanli_upimages.do")
		protected String guanli_images(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
			//没有数据
			return "home_guanli_upimages";
		}
		
		//具体上传处理
		@RequestMapping("/toguanli_upimages.do")
		public void toguanli_upimages(HttpServletRequest req,HttpServletResponse res,@RequestParam("descr") String descr,@RequestParam("file") MultipartFile file) throws IllegalStateException, IOException{
			//转换日期格式
			SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//Date格式转为字符串
			//获取session
			HttpSession session = req.getSession();
			//System.out.println("descr");
			//判断文件是否存在，存在返回到上传展示页，不存在返回错误
			if(!file.isEmpty()){
				//图片保存位置
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
				//读网页请求数据
				Images image=new Images();
				//image.setName(req.getParameter("name"));//文件名
				image.setName(filename);
				image.setPart(req.getParameter("part"));
				image.setResult(req.getParameter("result"));
				image.setDescr(req.getParameter("descr"));
				image.setInst(req.getParameter("inst"));
				//网页数据读取完成--现在加载不再网页显示的其他数据
				image.setPath("/Thyroid_images/");//存储路径
				image.setUser(session.getAttribute("userName").toString());
				image.setSet_time(sdf.format(new Date()));
				//写入数据库
				ImagesDeal imagesdeal=new ImagesDeal();
				imagesdeal.insert_image(image);
				//往session中存数据//存入图片名-在上传图片展示页中显示
				session.setAttribute("image_name", filename);
				session.setAttribute("name", filename);
				session.setAttribute("name_qian", filename);
				System.out.println(session.getAttribute("image_name"));
				//上传成功之后，到显示页
				res.sendRedirect("mysql_adminer.do");
//				res.sendRedirect("/Thyroid/mysql_adminer.do");//转发到查询也
				//return "home_mysql_adminer";
			}else{
				//上传失败，到错误页
				//return "error";
			}
			
		}
		
		
		
		
// img  		
		
				//超声图像管理中--images表数据上传
				//去上传页面
				@RequestMapping("/guanli_upimg.do")
				protected String guanli_upimg(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
					//没有数据
					return "home_guanli_upimg";
				}		
		

			//具体上传处理
			@RequestMapping("/toguanli_upimg.do")
			public void toguanli_upimg(HttpServletRequest req,HttpServletResponse res,@RequestParam("descr") String descr,@RequestParam("file") MultipartFile file) throws IllegalStateException, IOException{
				//转换日期格式
				SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");//Date格式转为字符串
				//获取session
				HttpSession session = req.getSession();
				//System.out.println("descr");
				//判断文件是否存在，存在返回到上传展示页，不存在返回错误
				if(!file.isEmpty()){
					//图片保存位置
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
					//读网页请求数据
					Img image=new Img();
					//image.setName(req.getParameter("name"));//文件名
					image.setName(filename);
					image.setPart(req.getParameter("part"));
					image.setResult(req.getParameter("result"));
					image.setDescr(req.getParameter("descr"));
					image.setInst(req.getParameter("inst"));
					//网页数据读取完成--现在加载不再网页显示的其他数据
					image.setPath("/Thyroid_images/");//存储路径
					image.setUser(session.getAttribute("userName").toString());
					Date date=new Date();
					System.out.println(date);
					image.setSet_time(sdf.format(new Date()));
					//写入数据库
					ImgDeal imgdeal=new ImgDeal();
					imgdeal.insert_img(image);
					//往session中存数据//存入图片名-在上传图片展示页中显示
					session.setAttribute("image_name", filename);
					session.setAttribute("name", filename);
					session.setAttribute("name_qian", filename);
					System.out.println(session.getAttribute("image_name"));
					//上传成功之后，到显示页
					res.sendRedirect("mysql_user.do");
//					res.sendRedirect("/Thyroid/mysql_user.do");//转发到查询也
					//return "home_mysql_adminer";
				}else{
					//上传失败，到错误页
					//return "error";
				}
				
			}
}
