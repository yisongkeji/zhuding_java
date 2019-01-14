package com.example.demo.model;

import java.io.Serializable;

public class ReturnUser extends User implements Serializable,Comparable<ReturnUser>{

	Integer userscore;
	
	Integer  distance;

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

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((distance == null) ? 0 : distance.hashCode());
		result = prime * result + ((userscore == null) ? 0 : userscore.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		ReturnUser other = (ReturnUser) obj;
		if (distance == null) {
			if (other.distance != null)
				return false;
		} else if (!distance.equals(other.distance))
			return false;
		if (userscore == null) {
			if (other.userscore != null)
				return false;
		} else if (!userscore.equals(other.userscore))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "ReturnUser [userscore=" + userscore + ", distance=" + distance + ", getUserscore()=" + getUserscore()
				+ ", getDistance()=" + getDistance() + ", hashCode()=" + hashCode() + ", getId()=" + getId()
				+ ", getUsername()=" + getUsername() + ", getSex()=" + getSex() + ", getDate()=" + getDate()
				+ ", getTime()=" + getTime() + ", getZone()=" + getZone() + ", getFacebook()=" + getFacebook()
				+ ", getNum()=" + getNum() + ", getHead()=" + getHead() + ", getPicture()=" + getPicture()
				+ ", getVip()=" + getVip() + ", getViptime()=" + getViptime() + ", getCity()=" + getCity()
				+ ", getBazi()=" + getBazi() + ", getZodiac()=" + getZodiac() + ", getXingzuo()=" + getXingzuo()
				+ ", getZiwei()=" + getZiwei() + ", getArea()=" + getArea() + ", getCountry()=" + getCountry()
				+ ", getLat()=" + getLat() + ", getLng()=" + getLng() + ", getSpare()=" + getSpare() + ", getSpare1()="
				+ getSpare1() + ", getUpdatetime()=" + getUpdatetime() + ", getObligate()=" + getObligate()
				+ ", toString()=" + super.toString() + ", getClass()=" + getClass() + "]";
	}

	@Override
	public int compareTo(ReturnUser arg0) {
		// TODO Auto-generated method stub
		return this.getUserscore().compareTo(arg0.getUserscore());
	}
	
	
}
