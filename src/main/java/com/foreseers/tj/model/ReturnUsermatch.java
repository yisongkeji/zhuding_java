package com.foreseers.tj.model;

import java.io.Serializable;
import java.util.List;

public class ReturnUsermatch extends UsermatchWithBLOBs implements Serializable {

	int age ;
	int num;
	String sex;
	String obligate;
	int friend;
	String name;
	String head;
	//List<UserImage> images;
	List<String> images;
	int lookimages ;
	String ziwei;
	int sevenday;
	int thirthday;
	int lookhead;
	int vip;
	
	
	
	public List<String> getImages() {
		return images;
	}

	public void setImages(List<String> images) {
		this.images = images;
	}

	public int getVip() {
		return vip;
	}

	public void setVip(int vip) {
		this.vip = vip;
	}

	public int getLookhead() {
		return lookhead;
	}

	public void setLookhead(int lookhead) {
		this.lookhead = lookhead;
	}

	public String getZiwei() {
		return ziwei;
	}

	public void setZiwei(String ziwei) {
		this.ziwei = ziwei;
	}

	public int getSevenday() {
		return sevenday;
	}

	public void setSevenday(int sevenday) {
		this.sevenday = sevenday;
	}

	public int getThirthday() {
		return thirthday;
	}

	public void setThirthday(int thirthday) {
		this.thirthday = thirthday;
	}

	public int getLookimages() {
		return lookimages;
	}

	public void setLookimages(int lookimages) {
		this.lookimages = lookimages;
	}


	public String getHead() {
		return head;
	}

	public void setHead(String head) {
		this.head = head;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public String getObligate() {
		return obligate;
	}

	public void setObligate(String obligate) {
		this.obligate = obligate;
	}

	public int getFriend() {
		return friend;
	}

	public void setFriend(int friend) {
		this.friend = friend;
	}




}
