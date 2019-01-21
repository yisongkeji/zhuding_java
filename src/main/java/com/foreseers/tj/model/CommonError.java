package com.foreseers.tj.model;

public interface CommonError {
	public int getErrcode();
	public String getErrMsg();
	public CommonError setErrMsg(String errMsg);

}
