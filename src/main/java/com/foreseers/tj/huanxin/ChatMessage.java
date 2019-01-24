package com.foreseers.tj.huanxin;

public class ChatMessage {

	
	String  msg_id ;      //消息ID
	String  timestamp;    //消息发送的时间
	String  direction;    //
	String  from_user;    //发送消息的用户
	String to_user;       //接收消息的用户
	String msg;           //发送的消息
	String type;           //聊天类型（txt，img）
	String url;            // 图片的 url
	String secret;          //上传图片后返回的字符串
	//String chat_type;     //增加地段，判断聊天的形式（基本上都是单聊）
	public String getMsg_id() {
		return msg_id;
	}
	public void setMsg_id(String msg_id) {
		this.msg_id = msg_id;
	}
	public String getTimestamp() {
		return timestamp;
	}
	public void setTimestamp(String timestamp) {
		this.timestamp = timestamp;
	}
	public String getDirection() {
		return direction;
	}
	public void setDirection(String direction) {
		this.direction = direction;
	}
	public String getFrom_user() {
		return from_user;
	}
	public void setFrom_user(String from_user) {
		this.from_user = from_user;
	}
	public String getTo_user() {
		return to_user;
	}
	public void setTo_user(String to_user) {
		this.to_user = to_user;
	}
	public String getMsg() {
		return msg;
	}
	public void setMsg(String msg) {
		this.msg = msg;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public String getSecret() {
		return secret;
	}
	public void setSecret(String secret) {
		this.secret = secret;
	}
	
	
}
