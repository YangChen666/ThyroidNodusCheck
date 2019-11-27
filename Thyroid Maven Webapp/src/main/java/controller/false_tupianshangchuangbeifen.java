package controller;
import java.io.File;
import java.io.IOException;

/**
 * 这是按照书上的。对应于upimages.jsp
 */
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
//具体上传处理备份
@Controller
public class false_tupianshangchuangbeifen {
	@RequestMapping("/toupimages1.do")
	public String toupimages(HttpServletRequest req,@RequestParam("description") String description,@RequestParam("file") MultipartFile file) throws IllegalStateException, IOException{
		//读请求数据
		System.out.println("description");
		//
		if(!file.isEmpty()){
			//
			String path=req.getServletContext().getRealPath("/images/");
			//
			String filename=file.getOriginalFilename();
			File filepath=new File(path,filename);
			//
			if(!filepath.getParentFile().exists()){
				filepath.getParentFile().mkdirs();
			}
			//
			file.transferTo(new File(path+File.separator+ filename));
			System.out.println(path+File.separator+ filename);
			return "upimages";
		}else{
			System.out.println("XXXXXXXXXXXXX");
			return "error";
		}
		
	}
}
