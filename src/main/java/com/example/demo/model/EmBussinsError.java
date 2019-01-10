package com.example.demo.model;

public enum EmBussinsError implements CommonError{
	
	
	USER_NOT_EXIT(1001,"用户不存在"),
	UNKNOWN_ERROR(1000,"未知错误")
	;
	
	private EmBussinsError(int errCode,String errMsg ) {
		this.errCode = errCode;
		this.errMsg = errMsg;	
	}
	private int errCode;
	private String errMsg;
	
	@Override
	public int getErrcode() {
		// TODO Auto-generated method stub
		return this.errCode;
	}

	@Override
	public String getErrMsg() {
		// TODO Auto-generated method stub
		return this.errMsg;
	}

	@Override
	public CommonError setErrMsg(String errMsg) {
		// TODO Auto-generated method stub
		this.errMsg = errMsg;
		return this;
	}

}
