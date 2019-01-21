package com.example.demo.model;

import java.io.Serializable;

public class ReturnUsermatch extends UsermatchWithBLOBs implements Serializable {

	int age ;

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	@Override
	public String toString() {
		return "ReturnUsermatch [age=" + age + ", getAge()=" + getAge() + ", getCommentdesc()=" + getCommentdesc()
				+ ", getCharacteristicdesc()=" + getCharacteristicdesc() + ", hashCode()=" + hashCode()
				+ ", toString()=" + super.toString() + ", getId()=" + getId() + ", getZhuid()=" + getZhuid()
				+ ", getCongid()=" + getCongid() + ", getUserscore()=" + getUserscore() + ", getUserdesc()="
				+ getUserdesc() + ", getCommentgood()=" + getCommentgood() + ", getCommentbad()=" + getCommentbad()
				+ ", getCharacteristicgood()=" + getCharacteristicgood() + ", getCharacteristicbad()="
				+ getCharacteristicbad() + ", getMindscore()=" + getMindscore() + ", getMinddesc()=" + getMinddesc()
				+ ", getBodyscore()=" + getBodyscore() + ", getBodydesc()=" + getBodydesc() + ", getCharacterscore()="
				+ getCharacterscore() + ", getCharacterdesc()=" + getCharacterdesc() + ", getDistance()="
				+ getDistance() + ", getSpare()=" + getSpare() + ", getSpare1()=" + getSpare1() + ", getSpare2()="
				+ getSpare2() + ", getClass()=" + getClass() + "]";
	}
	
	
	
}
