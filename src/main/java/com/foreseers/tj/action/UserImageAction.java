package com.foreseers.tj.action;

import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Random;

import javax.servlet.http.HttpServletRequest;

//import org.junit.runners.Parameterized.Parameter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.foreseers.tj.model.BusinessExpection;
import com.foreseers.tj.model.EmBussinsError;
import com.foreseers.tj.model.ResultType;
import com.foreseers.tj.model.UserImage;
import com.foreseers.tj.service.UserImageService;
import com.foreseers.tj.util.WebUpload;

@Controller
@RequestMapping("/userimage")
public class UserImageAction extends BaseAction{
	
	private static final Logger log = LoggerFactory.getLogger(UserImageAction.class);
	@Autowired
	private UserImageService userImageService;
	
	@Autowired
	private WebUpload webUpload;
	
	@Value("${httpurl}")
	private String httpurl;
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
		String imageyml = webUpload.getFrontpath();   //配置文件中相册的地址
		log.info("配置文件中相册的地址:"+imageyml);
		String imagepath = imageyml+userid; 
		log.info("最终相册保存的地址："+imagepath);
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
			String result =  getRandom();
			String name = bf.format(date)+result+"."+namesuffix;
		//	log.info("name:"+name);
		   log.info("图片名称："+name);
			File savefile = new File(imagepath);
			if(!savefile.exists()) {
				savefile.mkdirs();
			}			
			String save = imagepath+"/"+name;
		//	log.info("图片名称："+name);
			String saveurl = httpurl+userid+"/"+name;
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
	 * 上传模糊相册
	 */
	@RequestMapping("/uploadblurimage")
	@ResponseBody
	public ResultType uploadblurimage(HttpServletRequest request,MultipartFile file) throws BusinessExpection, IllegalStateException, IOException {
		log.info("进入上传模糊相册方法");
		String userid =  request.getParameter("userid");	
		log.info("参数：userid:"+userid);
		String imageyml = webUpload.getFrontpath();   //配置文件中相册的地址
		log.info("配置文件中相册的地址:"+imageyml);
		String imagepath = imageyml+userid; 
		log.info("最终相册保存的地址："+imagepath);
		log.info("保存路径"+imagepath);
		if(file == null) {
			 throw new BusinessExpection(EmBussinsError.ILLAGAL_PARAMETERS);	
		}
	//	 String imagename = file.getOriginalFilename();   //得到图片的后缀名
	//	 log.info(imagename);
		 int uid = 0; 
		 String bimagename = "";
		 List<UserImage> list = userImageService.queryByUseridlist(Integer.parseInt(userid));
		 UserImage userImage = new UserImage();
			for(int i= 0;i<list.size();i++) {
				UserImage userImageinfo = list.get(i);
				if(userImageinfo.getSpare() == null) {
					 uid = userImageinfo.getId();
					 bimagename = userImageinfo.getImagename();
				}
			}
			if(uid != 0) {  //存在模糊头像为空的位置，保存图片到本地和数据库
				DateFormat bf = new SimpleDateFormat("yyyyMMddHHmmss");//多态
				Date date = new Date();
				String result =  getRandom();
				String name = bf.format(date)+result+"."+"jpg";
				   log.info("模糊图片名称："+name);
					File savefile = new File(imagepath);
					if(!savefile.exists()) {
						savefile.mkdirs();
					}			
					String save = imagepath+"/"+name;
					log.info("图片保存地址："+name);
					String saveurl = httpurl+userid+"/"+name;
					log.info(saveurl);
					file.transferTo(new File(save));   //保存图片			
					userImage.setId(uid);
					userImage.setSpare(saveurl);
					userImageService.updateByPrimaryKeySelective(userImage);	
					 log.info("返回参数："+userImage);
			}else { //不存在
				throw new BusinessExpection(EmBussinsError.UNKNOWN_ERROR);	
			}


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
		log.info("进入删除相册方法");
		String imageyml = webUpload.getFrontpath();   //配置文件中相册的地址
		UserImage userImage = new UserImage();
		String userid = request.getParameter("userid");
		String nameurl = request.getParameter("nameurl");
		log.info("请求参数：userid"+userid);
		log.info("请求参数：nameurl"+nameurl);
		
		if(userid == null || nameurl == null) {
			log.error("参数不合法");
			 throw new BusinessExpection(EmBussinsError.ILLAGAL_PARAMETERS);	
		}
		String[] names = nameurl.split("/");
		 String name =  names[names.length-1];
		//System.out.println(name);
		String imagepath = imageyml+userid; 
		 List<UserImage> list = userImageService.queryByUseridlist(Integer.parseInt(userid));  
		String bimagename = null;
			for(int i= 0;i<list.size();i++) {  //查询相对应的模糊相册的地址
				UserImage userImageinfo = list.get(i);
				if(userImageinfo.getImagename().equals(name)) {
					// uid = userImageinfo.getId();
					 bimagename = userImageinfo.getSpare();
					 log.info("查询到模糊头像的地址："+bimagename);
				}
			}
		userImage.setUserid(Integer.parseInt(userid));
		userImage.setImagename(name);
		userImageService.deleteimage(userImage);
		if(bimagename != null) {
			String[] mname = bimagename.split("/");
			String bname = mname[mname.length-1];
			log.info("模糊头像的名称："+bname);
			new File(imagepath+"/"+bname).delete();  //删除模糊图片
		}
		new File(imagepath+"/"+name).delete();  //删除本地地图片
		
		
		return ResultType.creat("success");
	}
	
	public String getRandom() {
		Random random = new Random();
		String result="";
		for (int i=0;i<6;i++)
		{
			result+=random.nextInt(10);
		}
		return result;
	}
	
}
