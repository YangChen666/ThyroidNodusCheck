package controller;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 这是结节的三级分类     正常-结节   良-恶   恶-高度恶化
 * @author hcx
 *
 */
@Controller
public class jiejiefenlei {
	
	//结节分类--打开总分类页面     （只是打开页面的url,回车转入---打开分类页面成功页）
		@RequestMapping("/tojiejie.do")
		protected String jiejie(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException, InterruptedException {
					HttpSession session = req.getSession();
					//获取要预测的图像名称-网络1
					String image_name=(String)session.getAttribute("image_name");
					//运行神经网络
					try {
						String[] args1 = new String[] {"E:/IntelliJ Projects/Thyroid/batchFiles/fenlei.bat", "danzhang_fenleia.py",image_name};//文件地址一定要对好
			            Process process = Runtime.getRuntime().exec(args1);
			            process.waitFor();
			            System.out.println("网络运行完成1");
			            //读取分类1的结果--读args1的分类结果=分类结果在文件fenleia.txt中
			            try { 
							File file = new File("E:/IntelliJ Projects/Thyroid/fenleia.txt");
					        System.out.println("以字符为单位读取文件内容，一次读一个字节：");  
					        // 一次读一个字符  
					        Reader reader = new InputStreamReader(new FileInputStream(file));  
					        int tempchar;  
					        while ((tempchar = reader.read()) != -1) {  
					            // 对于windows下，\r\n这两个字符在一起时，表示一个换行。  
					            // 但如果这两个字符分开显示时，会换两次行。  
					            // 因此，屏蔽掉\r，或者屏蔽\n。否则，将会多出很多空行。  
					            if (((char) tempchar) != '\r') {  
					                if((char) tempchar=='z'){
					                	session.setAttribute("zc", "正常");
										session.setAttribute("ls", "----");
										session.setAttribute("ee", "----");
					                }else{
					                	session.setAttribute("zc", "结节");
					                	//开始运行网络2
					                	String[] args2 = new String[] { "E:/IntelliJ Projects/Thyroid/batchFiles/fenlei.bat", "danzhang_fenleib.py",image_name};
							            Process process2 = Runtime.getRuntime().exec(args2);
							            process2.waitFor();
							            System.out.println("网络运行完成2");
							          //读取分类2的结果--读args1的分类结果=分类结果在文件fenleib.txt中
							            try { 
											File fileb = new File("E:/IntelliJ Projects/Thyroid/fenleib.txt");
									        Reader readerb = new InputStreamReader(new FileInputStream(fileb));  
									        int tempcharb;  
									        while ((tempcharb = readerb.read()) != -1) {    
									            if (((char) tempcharb) != '\r') {  
									                if((char) tempcharb=='l'){
									                	session.setAttribute("ls", "良性");
														session.setAttribute("ee", "----");
									                }else{
									                	session.setAttribute("ls", "恶性");
									                	//开始运行网络3
									                	String[] args3 = new String[] { "E:/IntelliJ Projects/Thyroid/batchFiles/fenlei.bat", "danzhang_fenleic.py",image_name};
											            Process process3 = Runtime.getRuntime().exec(args3);
											            process3.waitFor();
											            System.out.println("网络运行完成3");
											          //读取分类3的结果--读args1的分类结果=分类结果在文件fenleic.txt中
											            try { 
															File filec = new File("E:/IntelliJ Projects/Thyroid/fenleic.txt");
													        Reader readerc = new InputStreamReader(new FileInputStream(filec));  
													        int tempcharc;  
													        while ((tempcharc = readerc.read()) != -1) {   
													            if (((char) tempcharc) != '\r') {  
													                if((char) tempcharc=='e'){
													                	session.setAttribute("ee", "初步恶化");
													                }else{
													                	session.setAttribute("ee", "高度恶化");
													                }
									                }
									            }
													        readerc.close();
													    } catch (Exception e) {  
													        e.printStackTrace();  
													    }finally{
													    }
											            //读取分类3结束	        
									                }
									            }
									        }
									        readerb.close();  
									    } catch (Exception e) {  
									        e.printStackTrace();  
									    }
							            //读取分类2结束
					                	
					                }
					            }  
					        }  
					        reader.close();  
					    } catch (Exception e) {  
					    	System.out.println("");  
					    }finally{
					    }              
			            //读取分类1结束
					} catch (Exception e) {  
				    	System.out.println("分类网络运行出错");  
				    }finally{
				    }
					return "home_jiejie_zong";
				}
		
		
		@RequestMapping("/tojiejie_zc.do")
		protected String tojiejie_zc(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException, InterruptedException {
					HttpSession session = req.getSession();
					//获取要预测的图像名称
					String image_name=(String)session.getAttribute("image_name");
					try {
						System.out.println("图片名称："+image_name);
						String[] args1 = new String[] { "E:/IntelliJ Projects/Thyroid/batchFiles/fenlei.bat", "danzhang_fenleia.py",image_name};//文件地址一定要对于好
			            Process process = Runtime.getRuntime().exec(args1);
			            process.waitFor();
			            System.out.println("网络运行完成1");
			            //读args1的分类结果
			            try { 
			            	File file = new File("E:/IntelliJ Projects/Thyroid/fenleia.txt");
					        Reader reader = new InputStreamReader(new FileInputStream(file));  
					        int tempchar;  
					        while ((tempchar = reader.read()) != -1) {    
					            if (((char) tempchar) != '\r') {  
					                if((char) tempchar=='z'){
					                	session.setAttribute("zc", "正常");
					                }else{
					                	session.setAttribute("zc", "结节");
					                }
	                }
	            }
					        reader.close();
					    } catch (Exception e) {  
					        e.printStackTrace();  
					    }finally{
					    }
			          
			        } catch (IOException e) {
			        	System.out.println("分类网络运行出错");
			        }
			
					return "home_jiejie_zc";
				}
		
		
		@RequestMapping("/tojiejie_le.do")
		protected String tojiejie_le(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException, InterruptedException {
			HttpSession session = req.getSession();
			//获取要预测的图像名称
			String image_name=(String)session.getAttribute("image_name");
			try {
				String[] args1 = new String[] { "E:/IntelliJ Projects/Thyroid/batchFiles/fenlei.bat", "danzhang_fenleib.py",image_name};//文件地址一定要对于好
			            Process process = Runtime.getRuntime().exec(args1);
			            process.waitFor();
			            System.out.println("网络运行完成2");
			            //读args2的分类结果
			            try { 
			            	File file = new File("E:/IntelliJ Projects/Thyroid/fenleib.txt");
					        Reader reader = new InputStreamReader(new FileInputStream(file));  
					        int tempchar;  
					        while ((tempchar = reader.read()) != -1) {    
					            if (((char) tempchar) != '\r') {  
					                if((char) tempchar=='l'){
					                	session.setAttribute("ls", "良性");
					                }else{
					                	session.setAttribute("ls", "恶性");
					                }
	                }
	            }
					        reader.close();
					    } catch (Exception e) {  
					        e.printStackTrace();  
					    }finally{
					    }
	        } catch (IOException e) {
	        	System.out.println("分类网络运行出错");
	        }
			return "home_jiejie_le";
		}
		
		
		@RequestMapping("/tojiejie_ee.do")
		protected String tojiejie_ee(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException, InterruptedException {
			HttpSession session = req.getSession();
			//获取要预测的图像名称
			String image_name=(String)session.getAttribute("image_name");
			try {
				String[] args1 = new String[] { "E:/IntelliJ Projects/Thyroid/batchFiles/fenlei.bat", "danzhang_fenleic.py",image_name};//文件地址一定要对于好
	            Process process = Runtime.getRuntime().exec(args1);
	            process.waitFor();
	            System.out.println("网络运行完成3");
	            //读args2的分类结果
	            try { 
	            	File file = new File("E:/IntelliJ Projects/Thyroid/fenleic.txt");
			        Reader reader = new InputStreamReader(new FileInputStream(file));  
			        int tempchar;  
			        while ((tempchar = reader.read()) != -1) {    
			            if (((char) tempchar) != '\r') {  
			                if((char) tempchar=='e'){
			                	session.setAttribute("ee", "初步恶化");
			                }else{
			                	session.setAttribute("ee", "高度恶化");
			                }
            }
        }
			        reader.close();
			    } catch (Exception e) {  
			        e.printStackTrace();  
			    }finally{
			    }
	        } catch (IOException e) {
	        	System.out.println("分类网络运行出错");
	        }
			return "home_jiejie_ee";
		}
}
