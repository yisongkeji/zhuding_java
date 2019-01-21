package com.foreseers.tj.model;

public class ResultType {
 
	private String status;
	private Object data;
	
	public static ResultType creat(Object data) {
		return  ResultType.creat(data,"success");
	}
	public static ResultType creat(Object data,String status) {
		ResultType resulttype = new ResultType();
		resulttype.setStatus(status);
		resulttype.setData(data);
		return  resulttype;
	}
	
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public Object getData() {
		return data;
	}
	public void setData(Object data) {
		this.data = data;
	}
	
	
}
