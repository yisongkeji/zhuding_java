package com.foreseers.tj.model;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

public class ReturnImage extends User implements Serializable{

	
	int countnum;
	List<String> listimage;
	
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
	@Override
	public String toString() {
		return "ReturnImage [countnum=" + countnum + ", listimage=" + listimage + ", getCountnum()=" + getCountnum()
				+ ", getListimage()=" + getListimage() + ", getId()=" + getId() + ", getUsername()=" + getUsername()
				+ ", getSex()=" + getSex() + ", getDate()=" + getDate() + ", getTime()=" + getTime() + ", getZone()="
				+ getZone() + ", getFacebook()=" + getFacebook() + ", getNum()=" + getNum() + ", getHead()=" + getHead()
				+ ", getPicture()=" + getPicture() + ", getVip()=" + getVip() + ", getViptime()=" + getViptime()
				+ ", getCity()=" + getCity() + ", getBazi()=" + getBazi() + ", getZodiac()=" + getZodiac()
				+ ", getXingzuo()=" + getXingzuo() + ", getZiwei()=" + getZiwei() + ", getArea()=" + getArea()
				+ ", getCountry()=" + getCountry() + ", getLat()=" + getLat() + ", getLng()=" + getLng()
				+ ", getSpare()=" + getSpare() + ", getSpare1()=" + getSpare1() + ", getUpdatetime()=" + getUpdatetime()
				+ ", getObligate()=" + getObligate() + ", getNumerology()=" + getNumerology() + ", getUserstar()="
				+ getUserstar() + ", getReservedint()=" + getReservedint() + ", getReservedvar()=" + getReservedvar()
				+ ", getReservedvar1()=" + getReservedvar1() + ", getCat1()=" + getCat1() + ", hashCode()=" + hashCode()
				+ ", toString()=" + super.toString() + ", getClass()=" + getClass() + "]";
	}

	
	
}
