package com.rzx.ssm.controller.msg;

public class ResponseMessage {
	public String id;
	public int status;
	public String desc;
	//data == json
	public String data;
	@Override
	public String toString() {
		return "ResponseMessage [id=" + id + ", status=" + status + ", desc=" + desc + ", data=" + data + "]";
	}
	
}
