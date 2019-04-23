package com.foreseers.tj;

import javax.servlet.MultipartConfigElement;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.MultipartConfigFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@MapperScan("com.foreseers.tj.mapper")
@ComponentScan(basePackages = "com.foreseers.tj.*")
@EnableScheduling
public class DatingApplication {

	public static void main(String[] args) {
		SpringApplication.run(DatingApplication.class, args);
	}

	@Bean
	public MultipartConfigElement multipartConfigElement() {
	   MultipartConfigFactory factory = new MultipartConfigFactory();
	   //单个文件最大
	   factory.setMaxFileSize("10MB");
	   /// 设置总上传数据总大小
	   factory.setMaxRequestSize("50MB");
	   return factory.createMultipartConfig();
	}
	
//	@Bean
//	 public EmbeddedServletContainerFactory servletContainer(){
//	      TomcatEmbeddedServletContainerFactory tomcat=new TomcatEmbeddedServletContainerFactory(){
//	          @Override
//	          protected void postProcessContext(Context context) {
//	              SecurityConstraint securityConstraint=new SecurityConstraint();
//	              securityConstraint.setUserConstraint("CONFIDENTIAL");//confidential
//	              SecurityCollection collection=new SecurityCollection();
//	              collection.addPattern("/*");
//	              securityConstraint.addCollection(collection);
//	              context.addConstraint(securityConstraint);
//	          }
//	      };
//	      tomcat.addAdditionalTomcatConnectors(httpConnector());
//	      return tomcat;
//	  }


	
}

