package com.zufe.pojo;

import net.sf.json.JSONObject;
import net.sf.json.util.JSONUtils;

public class Msg {

	public Boolean success = true;
	
	public String msg = "";

	public Msg(){
	}
	
	public Msg(Boolean success, String msg) {
		super();
		this.success = success;
		this.msg = msg;
	}

	public Boolean getSuccess() {
		return success;
	}

	public void setSuccess(Boolean success) {
		this.success = success;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}
	
	public String toJson(){
		JSONObject json = JSONObject.fromObject(this);
		return json.toString();
	}
	
}
