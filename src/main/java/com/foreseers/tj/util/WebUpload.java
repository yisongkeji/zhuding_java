package com.foreseers.tj.util;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties(prefix = "web")
public class WebUpload {

	private String uploadpath ;
	private String frontpath;
	
	
	public String getUploadpath() {
		return uploadpath;
	}
	public void setUploadpath(String uploadpath) {
		this.uploadpath = uploadpath;
	}
	public String getFrontpath() {
		return frontpath;
	}
	public void setFrontpath(String frontpath) {
		this.frontpath = frontpath;
	}
	
	
}
