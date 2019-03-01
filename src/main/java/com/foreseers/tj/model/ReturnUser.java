package com.foreseers.tj.model;

import java.io.Serializable;

public class ReturnUser extends User implements Serializable,Comparable<ReturnUser>{

	int userscore;
	
	Integer  distance;

	Integer  numuser;
	
	int age;
	
	int lookhead;
	
	String DESC;
	
	
	
	public String getDESC() {
		return DESC;
	}

	public void setDESC(String dESC) {
		DESC = dESC;
	}

	public void setUserscore(int userscore) {
		this.userscore = userscore;
	}

	public int getLookhead() {
		return lookhead;
	}

	public void setLookhead(int lookhead) {
		this.lookhead = lookhead;
	}

	public Integer getUserscore() {
		return userscore;
	}

	public void setUserscore(Integer userscore) {
		this.userscore = userscore;
	}

	public Integer getDistance() {
		return distance;
	}

	public void setDistance(Integer distance) {
		this.distance = distance;
	}

	
	public Integer getNumuser() {
		return numuser;
	}

	public void setNumuser(Integer numuser) {
		this.numuser = numuser;
	}
	
	
	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}


	
@Override
	public String toString() {
		return "ReturnUser [userscore=" + userscore + ", distance=" + distance + ", numuser=" + numuser + ", age=" + age
				+ ", lookhead=" + lookhead + ", DESC=" + DESC + ", getDESC()=" + getDESC() + ", getLookhead()="
				+ getLookhead() + ", getUserscore()=" + getUserscore() + ", getDistance()=" + getDistance()
				+ ", getNumuser()=" + getNumuser() + ", getAge()=" + getAge() + ", getId()=" + getId()
				+ ", getUsername()=" + getUsername() + ", getSex()=" + getSex() + ", getDate()=" + getDate()
				+ ", getTime()=" + getTime() + ", getZone()=" + getZone() + ", getFacebook()=" + getFacebook()
				+ ", getNum()=" + getNum() + ", getHead()=" + getHead() + ", getPicture()=" + getPicture()
				+ ", getVip()=" + getVip() + ", getViptime()=" + getViptime() + ", getCity()=" + getCity()
				+ ", getBazi()=" + getBazi() + ", getZodiac()=" + getZodiac() + ", getXingzuo()=" + getXingzuo()
				+ ", getZiwei()=" + getZiwei() + ", getArea()=" + getArea() + ", getCountry()=" + getCountry()
				+ ", getLat()=" + getLat() + ", getLng()=" + getLng() + ", getSpare()=" + getSpare() + ", getSpare1()="
				+ getSpare1() + ", getUpdatetime()=" + getUpdatetime() + ", getObligate()=" + getObligate()
				+ ", getNumerology()=" + getNumerology() + ", getUserstar()=" + getUserstar() + ", getReservedint()="
				+ getReservedint() + ", getReservedvar()=" + getReservedvar() + ", getReservedvar1()="
				+ getReservedvar1() + ", getCat1()=" + getCat1() + ", hashCode()=" + hashCode() + ", toString()="
				+ super.toString() + ", getClass()=" + getClass() + "]";
	}

	/*
	@Override
	public String toString() {
		return "ReturnUser [userscore=" + userscore + ", distance=" + distance + ", numuser=" + numuser + ", age=" + age
				+ ", lookhead=" + lookhead + ", getLookhead()=" + getLookhead() + ", getUserscore()=" + getUserscore()
				+ ", getDistance()=" + getDistance() + ", getNumuser()=" + getNumuser() + ", getAge()=" + getAge()
				+ ", getId()=" + getId() + ", getUsername()=" + getUsername() + ", getSex()=" + getSex()
				+ ", getDate()=" + getDate() + ", getTime()=" + getTime() + ", getZone()=" + getZone()
				+ ", getFacebook()=" + getFacebook() + ", getNum()=" + getNum() + ", getHead()=" + getHead()
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
*/
	@Override
	public int compareTo(ReturnUser o) {
		// TODO Auto-generated method stub
		return o.getUserscore() - this.getUserscore();
	}
	
	
}
