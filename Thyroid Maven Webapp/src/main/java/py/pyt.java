package py;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class pyt {
	public static void main(String[] args) throws IOException, InterruptedException {
//		try{  
//            Runtime rt = Runtime.getRuntime();  
//            System.out.println("start"); 
//            String[] args1=new String[]{"python","outfile.py"};
//            Process proc = Runtime.getRuntime().exec("python outfile.py");  
//            proc.waitFor();  
//            System.out.println("end");  
//            } catch (Exception e){  
//            e.printStackTrace();  
//            }
		
//		try {
//			
//            System.out.println("start");
//            //String[] args1 = new String[] {"E:/myeclipseWorkspaces/.metadata/.me_tcat85/webapps/Thyroid/Thyroid_images/outfile.py"};
//            //String[] args1=new String[]{"python","E:/myeclipseWorkspaces/.metadata/.me_tcat85/webapps/Thyroid/Thyroid_images/outfile.py"};
//            //Process pr=Runtime.getRuntime().exec(args1);
//            
//            String[] args1 = new String[] { "E:\\ruanjian\\it\\Anaconda\\python.exe E:\\myeclipseWorkspaces\\.metadata\\.me_tcat85\\webapps\\Thyroid\\Thyroid_images\\outfile.py", "" };
//            Process pr = Runtime.getRuntime().exec(args1);
//
//            
//            BufferedReader in = new BufferedReader(new InputStreamReader(
//                    pr.getInputStream()));
//            String line;
//            while ((line = in.readLine()) != null) {
//                System.out.println(line);
//            }
//            in.close();
//            pr.waitFor();
//            System.out.println("end");
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
		
		
//		ArrayList<String> list=new ArrayList<String>();
//		try {
//			  Process pr = Runtime.getRuntime().exec(
//					  "python E:\\myeclipseWorkspaces\\.metadata\\.me_tcat85\\webapps\\Thyroid\\Thyroid_images\\outfile.py "
//                           );
//			  BufferedReader in = new BufferedReader(new InputStreamReader(pr.getInputStream()));
//			  String line;
//			  while ((line = in.readLine()) == null) {
//				  System.out.println("line:" + line);
//			  }
//			  in.close();
//			  pr.waitFor();
//			  System.out.println("结束");
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
		
		

//		 try {//这个是可以了的
//			 	//String str="1.jpg";
//			 	String[] args1 = new String[] { "python", "E:/myeclipseWorkspaces/thyroid/RO_tuo.py","1.jpg"};
//	            Process process = Runtime.getRuntime().exec(args1);
//	        
//	            process.waitFor();
//	            System.out.println("完成");
//	            InputStreamReader ir = new InputStreamReader(process.getInputStream());
//	            LineNumberReader input = new LineNumberReader(ir);
//	            String result = input.readLine();
//	            input.close();
//	            ir.close();
//	            process.waitFor();
//	        } catch (IOException e) {
//	           
//	        }
		
		
		try {
			String[] args1 = new String[] { "python", "E:/myeclipseWorkspaces/thyroid/zeng_liang.py","1.jpg","1.jpg"};
            Process process = Runtime.getRuntime().exec(args1);
            process.waitFor();
            System.out.println("完成");
        } catch (IOException e) {
        	System.out.println("imagesPretreatment类增强出错");
        }

		 
		 

	}
}

