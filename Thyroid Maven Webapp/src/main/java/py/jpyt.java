//package py;
//import javax.servlet.http.HttpSession;
//
///**
// * java�ɹ�����python����
// */
//import org.python.core.PyFunction;
//import org.python.core.PyInteger;
//import org.python.core.PyObject;
//import org.python.core.PyString;
//import org.python.util.PythonInterpreter;
//
//import org.python.core.Py;
//import org.python.core.PySystemState;
//
//public class jpyt {
////	public static void main(String args[])  
////    {  
////          
////        PythonInterpreter interpreter = new PythonInterpreter();  
////        interpreter.execfile("E:/myeclipseWorkspaces/.metadata/.me_tcat85/webapps/Thyroid/py1.py");  
////        PyFunction func = (PyFunction)interpreter.get("adder",PyFunction.class);  
////  
////        int a = 2010, b = 2 ;  
////        PyObject pyobj = func.__call__(new PyInteger(a), new PyInteger(b));  
////        System.out.println("anwser = " + pyobj.toString());  
////  
////  
////    } 
//	public static void main(String[] args) {
//		//����python
//				
//				PythonInterpreter interpreter = new PythonInterpreter(); 
//				
//				
//				PySystemState sys = Py.getSystemState();   
//				sys.path.add("E:/ruanjian/java/jpython/Lib"); 
//				System.out.println(sys.path.toString());   // later
////				
//		        interpreter.execfile("E:/myeclipseWorkspaces/.metadata/.me_tcat85/webapps/Thyroid/py/ROI_tuo.py");  
//		        PyFunction func = (PyFunction)interpreter.get("ROI_tuo",PyFunction.class);  
//		       //��ȡsession
//				//HttpSession session = req.getSession();
//				//��ȡ�ϴ�֮���ͼ����
//				//String image_name=(String)session.getAttribute("image_name");
//		 
//		        PyObject pyobj = func.__call__(new PyString("1.jpg"));  
//		        System.out.println("anwser = " + pyobj.toString());
//	}
//}
