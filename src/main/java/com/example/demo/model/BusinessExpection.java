package com.example.demo.model;

//包装器业余类实现
public class BusinessExpection extends Exception implements CommonError{

	private CommonError commonError;
	
	//直接接收BusinessExpection的传参数用于构造业务异常
	public BusinessExpection(CommonError commonError) {
		super();
		this.commonError = commonError;	
	}
	
	public BusinessExpection(CommonError commonError,String errMsg) {
		super();
		this.commonError = commonError;
		this.commonError.setErrMsg(errMsg);
		
	}
	@Override
	public int getErrcode() {
		// TODO Auto-generated method stub
		return this.commonError.getErrcode();
	}

	@Override
	public String getErrMsg() {
		// TODO Auto-generated method stub
		return this.commonError.getErrMsg();
	}

	@Override
	public CommonError setErrMsg(String errMsg) {
		// TODO Auto-generated method stub
		this.commonError.setErrMsg(errMsg);
		return this;
	}

}
