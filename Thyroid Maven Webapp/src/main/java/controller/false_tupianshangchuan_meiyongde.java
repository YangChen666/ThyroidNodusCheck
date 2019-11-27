package controller;

import java.io.File;
import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import entity.ResultData;

public class false_tupianshangchuan_meiyongde {
	/**
     * ͼƬ�ļ��ϴ�
     */
    @ResponseBody
    @RequestMapping(value = "/image.do",method = RequestMethod.POST)
    public ResultData<Object> photoUpload(MultipartFile file,HttpServletRequest request,HttpServletResponse response,HttpSession session) throws IllegalStateException, IOException{
        System.out.println("image_controller");
    	ResultData<Object> resultData=new ResultData<Object>();
        // �ж��û��Ƿ��¼
        /*User user=(User) session.getAttribute("user");
        if (user==null) {
            resultData.setCode(40029);
            resultData.setMsg("�û�δ��¼");
            return resultData;
        }*/
        if (file!=null) {// �ж��ϴ����ļ��Ƿ�Ϊ��
            String path=null;// �ļ�·��
            String type=null;// �ļ�����
            String fileName=file.getOriginalFilename();// �ļ�ԭ����
            System.out.println("�ϴ����ļ�ԭ����:"+fileName);
            // �ж��ļ�����
            type=fileName.indexOf(".")!=-1?fileName.substring(fileName.lastIndexOf(".")+1, fileName.length()):null;
            if (type!=null) {// �ж��ļ������Ƿ�Ϊ��
                if ("GIF".equals(type.toUpperCase())||"PNG".equals(type.toUpperCase())||"JPG".equals(type.toUpperCase())) {
                    // ��Ŀ��������ʵ�ʷ������еĸ�·��
                    String realPath=request.getSession().getServletContext().getRealPath("/");
                    // �Զ�����ļ�����
                    String trueFileName=String.valueOf(System.currentTimeMillis())+fileName;
                    // ���ô��ͼƬ�ļ���·��
                    path=realPath+/*System.getProperty("file.separator")+*/trueFileName;
                    System.out.println("���ͼƬ�ļ���·��:"+path);
                    // ת���ļ���ָ����·��
                    file.transferTo(new File(path));
                    System.out.println("�ļ��ɹ��ϴ���ָ��Ŀ¼��");
                }else {
                    System.out.println("����������Ҫ���ļ�����,�밴Ҫ�������ϴ�");
                    return null;
                }
            }else {
                System.out.println("�ļ�����Ϊ��");
                return null;
            }
        }else {
            System.out.println("û���ҵ����Ӧ���ļ�");
            return null;
        }
        return resultData;
    }
}
