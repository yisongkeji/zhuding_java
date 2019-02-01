package com.foreseers.tj.model;

import java.io.Serializable;

public class ReturnUsermatch extends UsermatchWithBLOBs implements Serializable {

	int age ;
	int num;
	String sex;
	String obligate;
	int friend;
	String name;
	
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
				+ friend + ", name=" + name + ", getName()=" + getName() + ", getAge()=" + getAge() + ", getNum()="
				+ getNum() + ", getSex()=" + getSex() + ", getObligate()=" + getObligate() + ", getFriend()="
				+ getFriend() + ", getCommentdesc()=" + getCommentdesc() + ", getCharacteristicdesc()="
				+ getCharacteristicdesc() + ", hashCode()=" + hashCode() + ", toString()=" + super.toString()
				+ ", getId()=" + getId() + ", getZhuid()=" + getZhuid() + ", getCongid()=" + getCongid()
				+ ", getUserscore()=" + getUserscore() + ", getUserdesc()=" + getUserdesc() + ", getCommentgood()="
				+ getCommentgood() + ", getCommentbad()=" + getCommentbad() + ", getCharacteristicgood()="
				+ getCharacteristicgood() + ", getCharacteristicbad()=" + getCharacteristicbad() + ", getMindscore()="
				+ getMindscore() + ", getMinddesc()=" + getMinddesc() + ", getBodyscore()=" + getBodyscore()
				+ ", getBodydesc()=" + getBodydesc() + ", getCharacterscore()=" + getCharacterscore()
				+ ", getCharacterdesc()=" + getCharacterdesc() + ", getDistance()=" + getDistance() + ", getSpare()="
				+ getSpare() + ", getSpare1()=" + getSpare1() + ", getSpare2()=" + getSpare2() + ", getClass()="
				+ getClass() + "]";
	}


	
	
}
