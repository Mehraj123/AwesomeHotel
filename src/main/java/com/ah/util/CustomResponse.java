package com.ah.util;

import java.util.Map;

/**
 * @author Mehraj Malik
 * @version 1.0
 *
 */
public class CustomResponse {

	private final boolean success;
	private final String infoCode;
	private final String infoMsg;
	private final Map<String, Object> metaInfo;
	private final Object data;

	public CustomResponse(String infoCode, String infoMsg, Map<String, Object> metaInfo) {
		this(infoCode, infoMsg, null, metaInfo);
	}

	public CustomResponse(String infoCode, String infoMsg, Object data, Map<String, Object> metaInfo) {
		this.success = true;
		this.infoCode = infoCode;
		this.infoMsg = infoMsg;
		this.data = data;
		this.metaInfo = metaInfo;
	}

	public CustomResponse(String infoCode, String infoMsg) {
		this(infoCode, infoMsg, null);
	}

	public boolean isSuccess() {
		return success;
	}

	public Object getInfoCode() {
		return infoCode;
	}

	public Object getInfoMsg() {
		return infoMsg;
	}

	public Object getData() {
		return data;
	}

	public Map<String, Object> getMetaInfo() {
		return metaInfo;
	}

}
