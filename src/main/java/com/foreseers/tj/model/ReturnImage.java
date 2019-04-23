package com.foreseers.tj.model;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

public class ReturnImage extends User implements Serializable{

	
	int countnum;
	List<String> listimage;
	int age;
	int vipday;
	int lifeuserid;


	public int getVipday() {
		return vipday;
	}
	public void setVipday(int vipday) {
		this.vipday = vipday;
	}
	public int getCountnum() {
		return countnum;
	}
	public void setCountnum(int countnum) {
		this.countnum = countnum;
	}
	public List<String> getListimage() {
		return listimage;
	}
	public void setListimage(List<String> listimage) {
		this.listimage = listimage;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public int getLifeuserid() {
		return lifeuserid;
	}
	public void setLifeuserid(int lifeuserid) {
		this.lifeuserid = lifeuserid;
	}
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("ReturnImage [countnum=").append(countnum).append(", ");
		if (listimage != null)
			builder.append("listimage=").append(listimage).append(", ");
		builder.append("age=").append(age).append(", vipday=").append(vipday).append(", lifeuserid=").append(lifeuserid)
				.append("]");
		return builder.toString();
	}


	
	
}
