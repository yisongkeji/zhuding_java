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
	List<UserImage> images;
	int lookimages ;
	String ziwei;
	int sevenday;
	int thirthday;
	int lookhead;
	int vip;
	
	
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

	public List<UserImage> getImages() {
		return images;
	}

	public void setImages(List<UserImage> images) {
		this.images = images;
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

	@Override
	public String toString() {
		return "ReturnUsermatch [age=" + age + ", num=" + num + ", sex=" + sex + ", obligate=" + obligate + ", friend="
				+ friend + ", name=" + name + ", head=" + head + ", images=" + images + ", lookimages=" + lookimages
				+ ", ziwei=" + ziwei + ", sevenday=" + sevenday + ", thirthday=" + thirthday + ", lookhead=" + lookhead
				+ ", vip=" + vip + ", getVip()=" + getVip() + ", getLookhead()=" + getLookhead() + ", getZiwei()="
				+ getZiwei() + ", getSevenday()=" + getSevenday() + ", getThirthday()=" + getThirthday()
				+ ", getLookimages()=" + getLookimages() + ", getImages()=" + getImages() + ", getHead()=" + getHead()
				+ ", getName()=" + getName() + ", getAge()=" + getAge() + ", getNum()=" + getNum() + ", getSex()="
				+ getSex() + ", getObligate()=" + getObligate() + ", getFriend()=" + getFriend() + ", getCommentdesc()="
				+ getCommentdesc() + ", getCharacteristicdesc()=" + getCharacteristicdesc() + ", hashCode()="
				+ hashCode() + ", toString()=" + super.toString() + ", getId()=" + getId() + ", getZhuid()="
				+ getZhuid() + ", getCongid()=" + getCongid() + ", getUserscore()=" + getUserscore()
				+ ", getUserdesc()=" + getUserdesc() + ", getCommentgood()=" + getCommentgood() + ", getCommentbad()="
				+ getCommentbad() + ", getCharacteristicgood()=" + getCharacteristicgood() + ", getCharacteristicbad()="
				+ getCharacteristicbad() + ", getMindscore()=" + getMindscore() + ", getMinddesc()=" + getMinddesc()
				+ ", getBodyscore()=" + getBodyscore() + ", getBodydesc()=" + getBodydesc() + ", getCharacterscore()="
				+ getCharacterscore() + ", getCharacterdesc()=" + getCharacterdesc() + ", getDistance()="
				+ getDistance() + ", getSpare()=" + getSpare() + ", getSpare1()=" + getSpare1() + ", getSpare2()="
				+ getSpare2() + ", getClass()=" + getClass() + "]";
	}



}
