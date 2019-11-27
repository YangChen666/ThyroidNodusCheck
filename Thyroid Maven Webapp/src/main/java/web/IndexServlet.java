package web;

import java.io.IOException;
import java.io.Serializable;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class IndexServlet extends HttpServlet implements Serializable {

	/*@Override
	protected void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		//暂时没有数据
		//直接转发
		Object o=req.getAttribute("image");
		System.out.println(o);
		req.getRequestDispatcher("/WEB-INF/main/home.jsp").forward(req, res);
		
	}*/
	
}
