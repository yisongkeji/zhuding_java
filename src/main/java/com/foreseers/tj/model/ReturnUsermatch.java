package com.foreseers.tj.model;

import java.io.Serializable;
import java.util.List;

public class ReturnUsermatch extends UsermatchWithBLOBs  implements Serializable {

	int age ;
	int num;
	String sex;
	String obligate;
	int friend;
	String name;
	String head;
	//List<UserImage> images;
//	List<String> images;
//	int lookimages ;
//	String ziwei;
//	int sevenday;
//	int thirthday;
//	int lookhead;
	int vip;
	





	public int getVip() {
		return vip;
	}

	public void setVip(int vip) {
		this.vip = vip;
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
		builder.append("ReturnUsermatch [age=").append(age).append(", num=").append(num).append(", ");
		if (sex != null)
			builder.append("sex=").append(sex).append(", ");
		if (obligate != null)
			builder.append("obligate=").append(obligate).append(", ");
		builder.append("friend=").append(friend).append(", ");
		if (name != null)
			builder.append("name=").append(name).append(", ");
		if (head != null)
			builder.append("head=").append(head).append(", ");
		builder.append("vip=").append(vip).append("]");
		return builder.toString();
	}





}
