package com.foreseers.tj.action;

import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;

//import org.junit.runners.Parameterized.Parameter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.foreseers.tj.model.BusinessExpection;
import com.foreseers.tj.model.EmBussinsError;
import com.foreseers.tj.model.ResultType;
import com.foreseers.tj.model.UserImage;
import com.foreseers.tj.service.UserImageService;

@Controller
@RequestMapping("/userimage")
public class UserImageAction extends BaseAction{
	
	private static final Logger log = LoggerFactory.getLogger(UserImageAction.class);
	@Autowired
	private UserImageService userImageService;
	
	/*
	 * 上传相册
	 */
	@RequestMapping("/upload")
	@ResponseBody
	public ResultType uploadimage(HttpServletRequest request,MultipartFile file) throws BusinessExpection, IllegalStateException, IOException {
		log.info("进入上传相册方法");
		String userid =  request.getParameter("userid");
		//System.out.println(userid);
		log.info("参数：userid:"+userid);
		String imagepath = "E:/dt/image/"+userid; 
		log.info("保存路径"+imagepath);
		if(file == null) {
			 throw new BusinessExpection(EmBussinsError.ILLAGAL_PARAMETERS);	
		}
		 String imagename = file.getOriginalFilename();   //得到图片的后缀名
		 log.info(imagename);
		 String[] names = imagename.split("\\.");
		 log.info(names[0]);
		 String namesuffix = names[names.length-1];
		 log.info(namesuffix);
			DateFormat bf = new SimpleDateFormat("yyyyMMddHHmmss");//多态
			Date date = new Date();
			String name = bf.format(date)+"."+namesuffix;
		//	log.info("name:"+name);
		   log.info("图片名称："+name);
			File savefile = new File(imagepath);
			if(!savefile.exists()) {
				savefile.mkdirs();
			}			
			String save = imagepath+"/"+name;
		//	log.info("图片名称："+name);
			String saveurl = "http://192.168.1.73:8080/"+userid+"/"+name;
			log.info(saveurl);
			file.transferTo(new File(save));   //保存图片
//			System.out.println(Integer.parseInt(userid));
//			System.out.println(saveurl);
//			System.out.println(name);
			UserImage userImage = new UserImage();
			userImage.setUserid(Integer.parseInt(userid));
			userImage.setImage(saveurl);
			userImage.setImagename(name);
			userImageService.insertSelective(userImage);
			 log.info("返回参数："+userImage);
			return ResultType.creat(userImage);
	}
	/*
	 * 删除相册
	 * @Parameter(userid) 用户id
	 * @Parameter(nameurl) 用户图片name
	 */
	@RequestMapping("/deleteimage")
	@ResponseBody
	public ResultType deleteimage(HttpServletRequest request) throws BusinessExpection {
		
		UserImage userImage = new UserImage();
		String userid = request.getParameter("userid");
		String nameurl = request.getParameter("nameurl");
		
		if(userid == null || nameurl == null) {
			 throw new BusinessExpection(EmBussinsError.ILLAGAL_PARAMETERS);	
		}
		String[] names = nameurl.split("/");
		 String name =  names[names.length-1];
		System.out.println(name);
		String imagepath = "E:/dt/image/"+userid; 
		
		userImage.setUserid(Integer.parseInt(userid));
		userImage.setImagename(name);
		userImageService.deleteimage(userImage);
		
		new File(imagepath+"/"+name).delete();  //删除本地地图片
		
		return ResultType.creat("success");
	}
	
}
