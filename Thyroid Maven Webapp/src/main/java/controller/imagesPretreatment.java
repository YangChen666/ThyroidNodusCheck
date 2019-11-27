package controller;
/**
 * ����ͼ��Ԥ����
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
	
	//ȥ��Ĳ���--��ȥ��ҳ��
	@RequestMapping("/toquzao.do")
	protected String toquzao(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException, InterruptedException {
				//û������
				return "home_toquzao";
			}
	
	
		//ȥ��Ĳ���--��ȥ��ɹ�ҳ��
		@RequestMapping("/quzao.do")
		protected String quzao(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException, InterruptedException {
			
					//��ȡsession
					HttpSession session = req.getSession();
					String image_name=(String)session.getAttribute("image_name");
					session.setAttribute("name_qian",image_name);
					String name=(String)session.getAttribute("name");
					System.out.println("���뿴һ�£�"+name);
					try {
						String[] args1 = new String[] {"E:/IntelliJ Projects/Thyroid/batchFiles/quzao.bat",image_name,name};
			            Process process = Runtime.getRuntime().exec(args1);
			            process.waitFor();
			            System.out.println("���");
			            String newimage_name="quzao"+name;
			            session.setAttribute("image_name",newimage_name);
			            session.setAttribute("name_quzao",newimage_name);
			        } catch (IOException e) {
			        	System.out.println("imagesPretreatment��ȥ�����");
			        }
					return "home_quzao";
				}


		//��ǿ����--����ǿ ���� ҳ��
		@RequestMapping("/tozeng_liang.do")
		protected String tozengqiang(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException, InterruptedException {
			//û������
					return "home_tozeng_liang";
				}
		
		
			//��ǿ����--����ǿ ���� �ɹ�ҳ��
			@RequestMapping("/zeng_liang.do")
			protected String zengqiang(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException, InterruptedException {
				
						//��ȡsession
						HttpSession session = req.getSession();
						String image_name=(String)session.getAttribute("image_name");
						session.setAttribute("name_qian",image_name);
						String name=(String)session.getAttribute("name");
						System.out.println(image_name);
						try {
							String[] args1 = new String[] { "E:/IntelliJ Projects/Thyroid/batchFiles/zengqiang.bat", "zeng_liang.py",image_name,name};
				            Process process = Runtime.getRuntime().exec(args1);
				            process.waitFor();
				            System.out.println("���");
				            String newimage_name="liang"+name;
				            session.setAttribute("image_name",newimage_name);
				            session.setAttribute("name_zeng_liang",newimage_name);
				        } catch (IOException e) {
				        	System.out.println("imagesPretreatment����ǿ���ȳ���");
				        }
						return "home_zeng_liang";
					}
			
			//��ǿ����--����ǿ �Աȶ� ҳ��
			@RequestMapping("/tozeng_dui.do")
			protected String tozeng_dui(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException, InterruptedException {
				//û������
						return "home_tozeng_dui";
					}
			
			
				//��ǿ����--����ǿ �Աȶ� �ɹ�ҳ��
				@RequestMapping("/zeng_dui.do")
				protected String zeng_dui(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException, InterruptedException {
					
							//��ȡsession
							HttpSession session = req.getSession();
							String image_name=(String)session.getAttribute("image_name");
							session.setAttribute("name_qian",image_name);
							String name=(String)session.getAttribute("name");
							System.out.println(image_name);
							try {
								String[] args1 = new String[] { "E:/IntelliJ Projects/Thyroid/batchFiles/zengqiang.bat", "zeng_dui.py",image_name,name};
					            Process process = Runtime.getRuntime().exec(args1);
					            process.waitFor();
					            System.out.println("���");
					            String newimage_name="dui"+name;
					            session.setAttribute("image_name",newimage_name);
					            session.setAttribute("name_zeng_dui",newimage_name);
					        } catch (IOException e) {
					        	System.out.println("imagesPretreatment��Աȶȳ���");
					        }
							return "home_zeng_dui";
						}
			
			//��ǿ����--����ǿ ɫ�� ҳ��
			@RequestMapping("/tozeng_se.do")
			protected String tozeng_se(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException, InterruptedException {
				//û������
						return "home_tozeng_se";
					}
			
			
				//��ǿ����--����ǿ ɫ�� �ɹ�ҳ��
				@RequestMapping("/zeng_se.do")
				protected String zeng_se(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException, InterruptedException {
					
							//��ȡsession
							HttpSession session = req.getSession();
							String image_name=(String)session.getAttribute("image_name");
							session.setAttribute("name_qian",image_name);
							String name=(String)session.getAttribute("name");
							System.out.println(image_name);
							try {
								String[] args1 = new String[] { "E:/IntelliJ Projects/Thyroid/batchFiles/zengqiang.bat", "zeng_se.py",image_name,name};
					            Process process = Runtime.getRuntime().exec(args1);
					            process.waitFor();
					            System.out.println("���");
					            String newimage_name="se"+name;
					            session.setAttribute("image_name",newimage_name);
					            session.setAttribute("name_zeng_se",newimage_name);
					        } catch (IOException e) {
					        	System.out.println("imagesPretreatment��ɫ�ȳ���");
					        }
							return "home_zeng_se";
						}
				
				//��ǿ����--����ǿ ��� ҳ��
				@RequestMapping("/tozeng_rui.do")
				protected String tozeng_rui(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException, InterruptedException {
					//û������
							return "home_tozeng_rui";
						}
				
				
					//��ǿ����--����ǿ ��� �ɹ�ҳ��
					@RequestMapping("/zeng_rui.do")
					protected String zeng_rui(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException, InterruptedException {
						
								//��ȡsession
								HttpSession session = req.getSession();
								String image_name=(String)session.getAttribute("image_name");
								session.setAttribute("name_qian",image_name);
								String name=(String)session.getAttribute("name");
								System.out.println(image_name);
								try {
									String[] args1 = new String[] { "E:/IntelliJ Projects/Thyroid/batchFiles/zengqiang.bat", "zeng_rui.py",image_name,name};
						            Process process = Runtime.getRuntime().exec(args1);
						            process.waitFor();
						            System.out.println("���");
						            String newimage_name="rui"+name;
						            System.out.println(newimage_name);
						            session.setAttribute("image_name",newimage_name);
						            session.setAttribute("name_zeng_rui",newimage_name);
						        } catch (IOException e) {
						        	System.out.println("imagesPretreatment����ȳ���");
						        }
								return "home_zeng_rui";
							}



}




