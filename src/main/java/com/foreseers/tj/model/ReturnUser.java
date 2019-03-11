package com.foreseers.tj.model;

import java.io.Serializable;

public class ReturnUser   implements Serializable,Comparable<ReturnUser>{

	int id;
	String facebook;
	String username;
	String sex;
	String head;
	Integer reservedint;
	String ziwei;	
	int userscore;
	Integer  distance;
	Integer  numuser;
	//int age;
	int lookhead;
	
	String DESC;
	
	
	
	public String getZiwei() {
		return ziwei;
	}

	public void setZiwei(String ziwei) {
		this.ziwei = ziwei;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFacebook() {
		return facebook;
	}

	public void setFacebook(String facebook) {
		this.facebook = facebook;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public String getHead() {
		return head;
	}

	public void setHead(String head) {
		this.head = head;
	}

	public Integer getReservedint() {
		return reservedint;
	}

	public void setReservedint(Integer reservedint) {
		this.reservedint = reservedint;
	}

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
	
	



	

	@Override
	public int compareTo(ReturnUser o) {
		// TODO Auto-generated method stub
		return o.getUserscore() - this.getUserscore();
	}
	
	
}
