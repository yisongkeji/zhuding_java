package com.foreseers.tj.util;

import java.io.Serializable;
import java.util.List;

public class ReturnUserInfo    implements Serializable {

	int age ;
	int num;
	String sex;
	String obligate;
	int friend;
	String name;
	String head;
	//List<UserImage> images;
	List<String> images;
	//int lookimages ;
	String ziwei;
	int sevenday;
	int thirthday;
	int lookhead;
	int vip;
	
	String userdesc;
	int userscore;
	int distance;
	int lifeuserid;

	

	
	public int getLifeuserid() {
		return lifeuserid;
	}

	public void setLifeuserid(int lifeuserid) {
		this.lifeuserid = lifeuserid;
	}

	public String getUserdesc() {
		return userdesc;
	}

	public void setUserdesc(String userdesc) {
		this.userdesc = userdesc;
	}

	public int getUserscore() {
		return userscore;
	}

	public void setUserscore(int userscore) {
		this.userscore = userscore;
	}

	public int getDistance() {
		return distance;
	}

	public void setDistance(int distance) {
		this.distance = distance;
	}

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
		StringBuilder builder = new StringBuilder();
		builder.append("ReturnUserInfo [age=").append(age).append(", num=").append(num).append(", ");
		if (sex != null)
			builder.append("sex=").append(sex).append(", ");
		if (obligate != null)
			builder.append("obligate=").append(obligate).append(", ");
		builder.append("friend=").append(friend).append(", ");
		if (name != null)
			builder.append("name=").append(name).append(", ");
		if (head != null)
			builder.append("head=").append(head).append(", ");
		if (images != null)
			builder.append("images=").append(images).append(", ");
		if (ziwei != null)
			builder.append("ziwei=").append(ziwei).append(", ");
		builder.append("sevenday=").append(sevenday).append(", thirthday=").append(thirthday).append(", lookhead=")
				.append(lookhead).append(", vip=").append(vip).append(", ");
		if (userdesc != null)
			builder.append("userdesc=").append(userdesc).append(", ");
		builder.append("userscore=").append(userscore).append(", distance=").append(distance).append(", lifeuserid=")
				.append(lifeuserid).append("]");
		return builder.toString();
	}




}
