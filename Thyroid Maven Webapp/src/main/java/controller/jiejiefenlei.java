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
 * ���ǽ�ڵ���������     ����-���   ��-��   ��-�߶ȶ�
 * @author hcx
 *
 */
@Controller
public class jiejiefenlei {
	
	//��ڷ���--���ܷ���ҳ��     ��ֻ�Ǵ�ҳ���url,�س�ת��---�򿪷���ҳ��ɹ�ҳ��
		@RequestMapping("/tojiejie.do")
		protected String jiejie(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException, InterruptedException {
					HttpSession session = req.getSession();
					//��ȡҪԤ���ͼ������-����1
					String image_name=(String)session.getAttribute("image_name");
					//����������
					try {
						String[] args1 = new String[] {"E:/IntelliJ Projects/Thyroid/batchFiles/fenlei.bat", "danzhang_fenleia.py",image_name};//�ļ���ַһ��Ҫ�Ժ�
			            Process process = Runtime.getRuntime().exec(args1);
			            process.waitFor();
			            System.out.println("�����������1");
			            //��ȡ����1�Ľ��--��args1�ķ�����=���������ļ�fenleia.txt��
			            try { 
							File file = new File("E:/IntelliJ Projects/Thyroid/fenleia.txt");
					        System.out.println("���ַ�Ϊ��λ��ȡ�ļ����ݣ�һ�ζ�һ���ֽڣ�");  
					        // һ�ζ�һ���ַ�  
					        Reader reader = new InputStreamReader(new FileInputStream(file));  
					        int tempchar;  
					        while ((tempchar = reader.read()) != -1) {  
					            // ����windows�£�\r\n�������ַ���һ��ʱ����ʾһ�����С�  
					            // ������������ַ��ֿ���ʾʱ���ỻ�����С�  
					            // ��ˣ����ε�\r����������\n�����򣬽������ܶ���С�  
					            if (((char) tempchar) != '\r') {  
					                if((char) tempchar=='z'){
					                	session.setAttribute("zc", "����");
										session.setAttribute("ls", "----");
										session.setAttribute("ee", "----");
					                }else{
					                	session.setAttribute("zc", "���");
					                	//��ʼ��������2
					                	String[] args2 = new String[] { "E:/IntelliJ Projects/Thyroid/batchFiles/fenlei.bat", "danzhang_fenleib.py",image_name};
							            Process process2 = Runtime.getRuntime().exec(args2);
							            process2.waitFor();
							            System.out.println("�����������2");
							          //��ȡ����2�Ľ��--��args1�ķ�����=���������ļ�fenleib.txt��
							            try { 
											File fileb = new File("E:/IntelliJ Projects/Thyroid/fenleib.txt");
									        Reader readerb = new InputStreamReader(new FileInputStream(fileb));  
									        int tempcharb;  
									        while ((tempcharb = readerb.read()) != -1) {    
									            if (((char) tempcharb) != '\r') {  
									                if((char) tempcharb=='l'){
									                	session.setAttribute("ls", "����");
														session.setAttribute("ee", "----");
									                }else{
									                	session.setAttribute("ls", "����");
									                	//��ʼ��������3
									                	String[] args3 = new String[] { "E:/IntelliJ Projects/Thyroid/batchFiles/fenlei.bat", "danzhang_fenleic.py",image_name};
											            Process process3 = Runtime.getRuntime().exec(args3);
											            process3.waitFor();
											            System.out.println("�����������3");
											          //��ȡ����3�Ľ��--��args1�ķ�����=���������ļ�fenleic.txt��
											            try { 
															File filec = new File("E:/IntelliJ Projects/Thyroid/fenleic.txt");
													        Reader readerc = new InputStreamReader(new FileInputStream(filec));  
													        int tempcharc;  
													        while ((tempcharc = readerc.read()) != -1) {   
													            if (((char) tempcharc) != '\r') {  
													                if((char) tempcharc=='e'){
													                	session.setAttribute("ee", "������");
													                }else{
													                	session.setAttribute("ee", "�߶ȶ�");
													                }
									                }
									            }
													        readerc.close();
													    } catch (Exception e) {  
													        e.printStackTrace();  
													    }finally{
													    }
											            //��ȡ����3����	        
									                }
									            }
									        }
									        readerb.close();  
									    } catch (Exception e) {  
									        e.printStackTrace();  
									    }
							            //��ȡ����2����
					                	
					                }
					            }  
					        }  
					        reader.close();  
					    } catch (Exception e) {  
					    	System.out.println("");  
					    }finally{
					    }              
			            //��ȡ����1����
					} catch (Exception e) {  
				    	System.out.println("�����������г���");  
				    }finally{
				    }
					return "home_jiejie_zong";
				}
		
		
		@RequestMapping("/tojiejie_zc.do")
		protected String tojiejie_zc(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException, InterruptedException {
					HttpSession session = req.getSession();
					//��ȡҪԤ���ͼ������
					String image_name=(String)session.getAttribute("image_name");
					try {
						System.out.println("ͼƬ���ƣ�"+image_name);
						String[] args1 = new String[] { "E:/IntelliJ Projects/Thyroid/batchFiles/fenlei.bat", "danzhang_fenleia.py",image_name};//�ļ���ַһ��Ҫ���ں�
			            Process process = Runtime.getRuntime().exec(args1);
			            process.waitFor();
			            System.out.println("�����������1");
			            //��args1�ķ�����
			            try { 
			            	File file = new File("E:/IntelliJ Projects/Thyroid/fenleia.txt");
					        Reader reader = new InputStreamReader(new FileInputStream(file));  
					        int tempchar;  
					        while ((tempchar = reader.read()) != -1) {    
					            if (((char) tempchar) != '\r') {  
					                if((char) tempchar=='z'){
					                	session.setAttribute("zc", "����");
					                }else{
					                	session.setAttribute("zc", "���");
					                }
	                }
	            }
					        reader.close();
					    } catch (Exception e) {  
					        e.printStackTrace();  
					    }finally{
					    }
			          
			        } catch (IOException e) {
			        	System.out.println("�����������г���");
			        }
			
					return "home_jiejie_zc";
				}
		
		
		@RequestMapping("/tojiejie_le.do")
		protected String tojiejie_le(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException, InterruptedException {
			HttpSession session = req.getSession();
			//��ȡҪԤ���ͼ������
			String image_name=(String)session.getAttribute("image_name");
			try {
				String[] args1 = new String[] { "E:/IntelliJ Projects/Thyroid/batchFiles/fenlei.bat", "danzhang_fenleib.py",image_name};//�ļ���ַһ��Ҫ���ں�
			            Process process = Runtime.getRuntime().exec(args1);
			            process.waitFor();
			            System.out.println("�����������2");
			            //��args2�ķ�����
			            try { 
			            	File file = new File("E:/IntelliJ Projects/Thyroid/fenleib.txt");
					        Reader reader = new InputStreamReader(new FileInputStream(file));  
					        int tempchar;  
					        while ((tempchar = reader.read()) != -1) {    
					            if (((char) tempchar) != '\r') {  
					                if((char) tempchar=='l'){
					                	session.setAttribute("ls", "����");
					                }else{
					                	session.setAttribute("ls", "����");
					                }
	                }
	            }
					        reader.close();
					    } catch (Exception e) {  
					        e.printStackTrace();  
					    }finally{
					    }
	        } catch (IOException e) {
	        	System.out.println("�����������г���");
	        }
			return "home_jiejie_le";
		}
		
		
		@RequestMapping("/tojiejie_ee.do")
		protected String tojiejie_ee(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException, InterruptedException {
			HttpSession session = req.getSession();
			//��ȡҪԤ���ͼ������
			String image_name=(String)session.getAttribute("image_name");
			try {
				String[] args1 = new String[] { "E:/IntelliJ Projects/Thyroid/batchFiles/fenlei.bat", "danzhang_fenleic.py",image_name};//�ļ���ַһ��Ҫ���ں�
	            Process process = Runtime.getRuntime().exec(args1);
	            process.waitFor();
	            System.out.println("�����������3");
	            //��args2�ķ�����
	            try { 
	            	File file = new File("E:/IntelliJ Projects/Thyroid/fenleic.txt");
			        Reader reader = new InputStreamReader(new FileInputStream(file));  
			        int tempchar;  
			        while ((tempchar = reader.read()) != -1) {    
			            if (((char) tempchar) != '\r') {  
			                if((char) tempchar=='e'){
			                	session.setAttribute("ee", "������");
			                }else{
			                	session.setAttribute("ee", "�߶ȶ�");
			                }
            }
        }
			        reader.close();
			    } catch (Exception e) {  
			        e.printStackTrace();  
			    }finally{
			    }
	        } catch (IOException e) {
	        	System.out.println("�����������г���");
	        }
			return "home_jiejie_ee";
		}
}
