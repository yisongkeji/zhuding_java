package com.foreseers.tj.model;

public class ReturnProduct implements Comparable<ReturnProduct>{

	Integer id;
	String googleID;
	String appleID;
	String name;
	String type;
	/**
	 * @return the id
	 */
	public Integer getId() {
		return id;
	}
	/**
	 * @param id the id to set
	 */
	public void setId(Integer id) {
		this.id = id;
	}
	/**
	 * @return the googleID
	 */
	public String getGoogleID() {
		return googleID;
	}
	/**
	 * @param googleID the googleID to set
	 */
	public void setGoogleID(String googleID) {
		this.googleID = googleID;
	}
	/**
	 * @return the appleID
	 */
	public String getAppleID() {
		return appleID;
	}
	/**
	 * @param appleID the appleID to set
	 */
	public void setAppleID(String appleID) {
		this.appleID = appleID;
	}
	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}
	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}
	/**
	 * @return the type
	 */
	public String getType() {
		return type;
	}
	/**
	 * @param type the type to set
	 */
	public void setType(String type) {
		this.type = type;
	}
	
	@Override
	public int compareTo(ReturnProduct o) {
		// TODO Auto-generated method stub
	//	return this.getId()-o.getId();
		return o.getId()-this.getId();
	}
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("ReturnProduct [");
		if (id != null)
			builder.append("id=").append(id).append(", ");
		if (googleID != null)
			builder.append("googleID=").append(googleID).append(", ");
		if (appleID != null)
			builder.append("appleID=").append(appleID).append(", ");
		if (name != null)
			builder.append("name=").append(name).append(", ");
		if (type != null)
			builder.append("type=").append(type);
		builder.append("]");
		return builder.toString();
	}
	
	
}
