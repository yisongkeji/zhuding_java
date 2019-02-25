package com.foreseers.tj.model;

public enum EmBussinsError implements CommonError{
	
	
	USER_NOT_EXIT(1001,"用户不存在"),
	UNKNOWN_ERROR(1000,"未知错误"),
	HUANXIN_ERROR(1002,"环信注册失败"),
	MINGSHU_ERROR(1003,"命书注册失败"),
	ILLAGAL_PARAMETERS(1004,"参数不合法"),
	GENERAL_ERROR(2000,"通用错误")
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
