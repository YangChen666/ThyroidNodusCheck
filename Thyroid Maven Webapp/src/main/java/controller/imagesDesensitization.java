package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 这是识别与脱敏处理
 * @author hcx
 *
 */

@Controller
public class imagesDesensitization {


	@RequestMapping("/roi.do")
	protected String Toup(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		//没有数据
		return "home_ROI_tuo";
	}

	@RequestMapping("/imgClip.do")
	protected String Clip(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		//没有数据
		return "home_img_clip";
	}
	@RequestMapping("/clipShow.do")
	protected String clipShow(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		//没有数据
		return "clipImageFrame";
	}
	//脱敏--点击脱敏功能显示的是上传成功页--脱敏完成显示此页
	//如下上传后显示上传成功-显示上传图像--图像脱敏处理提交前显示图像上传成功页，脱敏处理后显示脱敏也
	@RequestMapping("/home_ROI_tuo.do")
	protected String Index(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException, InterruptedException {
		//获取session
		HttpSession session = req.getSession();
		String image_name=(String)session.getAttribute("image_name");
		session.setAttribute("name_qian", image_name);
		String clipParameter=(String)req.getParameter("clipParameter");
		System.out.println("裁剪参数"+clipParameter);
		try {
			String[] args1 = new String[] { "E:/IntelliJ Projects/Thyroid/batchFiles/ROI_tuo.bat",image_name,clipParameter};
            Process process = Runtime.getRuntime().exec(args1);
            process.waitFor();
            String newimage_name="ROI_tuo"+image_name;
            session.setAttribute("image_name",newimage_name);
            session.setAttribute("name_ROI_tuo",newimage_name);
        } catch (IOException e) {
        	System.out.println("imagesDesensitization类脱敏出错");
        }
		return "home_ROI_tuo";
	}
}
