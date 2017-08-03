package com.rzx.ssm.controller.msg;

public class RequestMessage {



	@Override
	public String toString() {
		return "RequestMessage [id=" + id + ", desc=" + desc + ", proc=" + proc + ", data=" + data + "]";
	}

	public RequestMessage(String id, String desc, String proc, String data) {
		super();
		this.id = id;
		this.desc = desc;
		this.proc = proc;
		this.data = data;
	}

	public RequestMessage() {
		super();
	}


	public String id;
	public String desc;
	public String proc;
	public String data;
	public String getProcClassName(){
		return proc.split("_")[0];
	}
	
	public String getMethodName(){
		return proc.split("_")[1];
	}
}
