package controller;
/**
 * 这是图像预处理
 */
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class imagesPretreatment {
	
	//去噪的操作--打开去噪页面
	@RequestMapping("/toquzao.do")
	protected String toquzao(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException, InterruptedException {
				//没有数据
				return "home_toquzao";
			}
	
	
		//去噪的操作--打开去噪成功页面
		@RequestMapping("/quzao.do")
		protected String quzao(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException, InterruptedException {
			
					//获取session
					HttpSession session = req.getSession();
					String image_name=(String)session.getAttribute("image_name");
					session.setAttribute("name_qian",image_name);
					String name=(String)session.getAttribute("name");
					System.out.println("我想看一下："+name);
					try {
						String[] args1 = new String[] {"E:/IntelliJ Projects/Thyroid/batchFiles/quzao.bat",image_name,name};
			            Process process = Runtime.getRuntime().exec(args1);
			            process.waitFor();
			            System.out.println("完成");
			            String newimage_name="quzao"+name;
			            session.setAttribute("image_name",newimage_name);
			            session.setAttribute("name_quzao",newimage_name);
			        } catch (IOException e) {
			        	System.out.println("imagesPretreatment类去噪出错");
			        }
					return "home_quzao";
				}


		//增强操作--打开增强 亮度 页面
		@RequestMapping("/tozeng_liang.do")
		protected String tozengqiang(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException, InterruptedException {
			//没有数据
					return "home_tozeng_liang";
				}
		
		
			//增强操作--打开增强 亮度 成功页面
			@RequestMapping("/zeng_liang.do")
			protected String zengqiang(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException, InterruptedException {
				
						//获取session
						HttpSession session = req.getSession();
						String image_name=(String)session.getAttribute("image_name");
						session.setAttribute("name_qian",image_name);
						String name=(String)session.getAttribute("name");
						System.out.println(image_name);
						try {
							String[] args1 = new String[] { "E:/IntelliJ Projects/Thyroid/batchFiles/zengqiang.bat", "zeng_liang.py",image_name,name};
				            Process process = Runtime.getRuntime().exec(args1);
				            process.waitFor();
				            System.out.println("完成");
				            String newimage_name="liang"+name;
				            session.setAttribute("image_name",newimage_name);
				            session.setAttribute("name_zeng_liang",newimage_name);
				        } catch (IOException e) {
				        	System.out.println("imagesPretreatment类增强亮度出错");
				        }
						return "home_zeng_liang";
					}
			
			//增强操作--打开增强 对比度 页面
			@RequestMapping("/tozeng_dui.do")
			protected String tozeng_dui(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException, InterruptedException {
				//没有数据
						return "home_tozeng_dui";
					}
			
			
				//增强操作--打开增强 对比度 成功页面
				@RequestMapping("/zeng_dui.do")
				protected String zeng_dui(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException, InterruptedException {
					
							//获取session
							HttpSession session = req.getSession();
							String image_name=(String)session.getAttribute("image_name");
							session.setAttribute("name_qian",image_name);
							String name=(String)session.getAttribute("name");
							System.out.println(image_name);
							try {
								String[] args1 = new String[] { "E:/IntelliJ Projects/Thyroid/batchFiles/zengqiang.bat", "zeng_dui.py",image_name,name};
					            Process process = Runtime.getRuntime().exec(args1);
					            process.waitFor();
					            System.out.println("完成");
					            String newimage_name="dui"+name;
					            session.setAttribute("image_name",newimage_name);
					            session.setAttribute("name_zeng_dui",newimage_name);
					        } catch (IOException e) {
					        	System.out.println("imagesPretreatment类对比度出错");
					        }
							return "home_zeng_dui";
						}
			
			//增强操作--打开增强 色度 页面
			@RequestMapping("/tozeng_se.do")
			protected String tozeng_se(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException, InterruptedException {
				//没有数据
						return "home_tozeng_se";
					}
			
			
				//增强操作--打开增强 色度 成功页面
				@RequestMapping("/zeng_se.do")
				protected String zeng_se(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException, InterruptedException {
					
							//获取session
							HttpSession session = req.getSession();
							String image_name=(String)session.getAttribute("image_name");
							session.setAttribute("name_qian",image_name);
							String name=(String)session.getAttribute("name");
							System.out.println(image_name);
							try {
								String[] args1 = new String[] { "E:/IntelliJ Projects/Thyroid/batchFiles/zengqiang.bat", "zeng_se.py",image_name,name};
					            Process process = Runtime.getRuntime().exec(args1);
					            process.waitFor();
					            System.out.println("完成");
					            String newimage_name="se"+name;
					            session.setAttribute("image_name",newimage_name);
					            session.setAttribute("name_zeng_se",newimage_name);
					        } catch (IOException e) {
					        	System.out.println("imagesPretreatment类色度出错");
					        }
							return "home_zeng_se";
						}
				
				//增强操作--打开增强 锐度 页面
				@RequestMapping("/tozeng_rui.do")
				protected String tozeng_rui(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException, InterruptedException {
					//没有数据
							return "home_tozeng_rui";
						}
				
				
					//增强操作--打开增强 锐度 成功页面
					@RequestMapping("/zeng_rui.do")
					protected String zeng_rui(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException, InterruptedException {
						
								//获取session
								HttpSession session = req.getSession();
								String image_name=(String)session.getAttribute("image_name");
								session.setAttribute("name_qian",image_name);
								String name=(String)session.getAttribute("name");
								System.out.println(image_name);
								try {
									String[] args1 = new String[] { "E:/IntelliJ Projects/Thyroid/batchFiles/zengqiang.bat", "zeng_rui.py",image_name,name};
						            Process process = Runtime.getRuntime().exec(args1);
						            process.waitFor();
						            System.out.println("完成");
						            String newimage_name="rui"+name;
						            System.out.println(newimage_name);
						            session.setAttribute("image_name",newimage_name);
						            session.setAttribute("name_zeng_rui",newimage_name);
						        } catch (IOException e) {
						        	System.out.println("imagesPretreatment类锐度出错");
						        }
								return "home_zeng_rui";
							}



}




