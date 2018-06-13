package org.i9.lock.platform.utils;

import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.io.FilenameUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

@Controller
public class UploadController {
	
	private static final String ROOT_PATH = "F:\\";
	
    // 上传图片
    @RequestMapping(value = "/upload/uploadPic")
    public @ResponseBody String uploadPic(@RequestParam(value = "uploadHead", required = false) MultipartFile uploadFile,HttpServletRequest request,HttpServletResponse response) throws Exception {
        response.setHeader("Access-Control-Allow-Origin", "*"); //生产环境绝对不允许设置为“*”
        response.setHeader("Access-Control-Allow-Methods", "*");
        response.setHeader("Access-Control-Allow-Headers", "x-requested-with,content-type");
        response.setContentType("application/json");
        response.setCharacterEncoding("utf-8");
        try {
        	//获得文件扩展名
            String ext = FilenameUtils.getExtension(uploadFile.getOriginalFilename());
            //使用UUID产生一个随机的通用唯一识别码 加上 扩展名 组成一个一个新的文件名
            String filename = UUID.randomUUID().toString() + ext;
            //String rootPath = request.getSession().getServletContext().getRealPath("/");
            //uploadFile.transferTo(new File(rootPath + path));
            //压缩文件到900kb以内
            ThumbPicUtil.commpressPicForScale(uploadFile.getInputStream(), ROOT_PATH + filename, 900, 0.8);
            return filename;
        } catch (Exception ex) {
            ex.printStackTrace();
            return "上传图片失败!";
        }
    }
    
 
    
    /*@ResponseBody
    @RequestMapping(value = "/upload/importPics")
    public ReturnMessage importPics(
            @RequestParam(value = "file", required = false) MultipartFile[] uploadFiles,
            HttpServletRequest request, HttpServletResponse response) {
        response.setHeader("Access-Control-Allow-Origin", "*"); //生产环境绝对不允许设置为“*”
        response.setHeader("Access-Control-Allow-Methods", "*");
        response.setHeader("Access-Control-Allow-Headers", "x-requested-with,content-type");
        response.setContentType("application/json");
        response.setCharacterEncoding("utf-8");
        
        ReturnMessage t_rtnMessage = new ReturnMessage();
        t_rtnMessage.setResult(ReturnMessage.SUCCESS);
        System.out.println("开始批量上传:文件数量：" + uploadFiles.length);
        try {
            List<String> filenames = new ArrayList<String>();
            for (MultipartFile uploadFile : uploadFiles) {
                String ext = FilenameUtils.getExtension(uploadFile.getOriginalFilename());
                //String rootPath = request.getSession().getServletContext().getRealPath("/");
                String filename = UUID.randomUUID().toString() + "." + ext;
               // String path = "/uploads/" + filename;
                filenames.add(filename);
                ThumbPicUtil.commpressPicForScale(uploadFile.getInputStream(), ROOT_PATH + filename, 900, 0.8);
                //uploadFile.transferTo(new File(rootPath + path));
            }
            t_rtnMessage.setObject(filenames);
        } catch (Exception ex) {
            ex.printStackTrace();
            t_rtnMessage.setResult(ReturnMessage.FAILED);
            t_rtnMessage.setMessage("上传图片失败!");
        }
        return t_rtnMessage;
    }*/
}
