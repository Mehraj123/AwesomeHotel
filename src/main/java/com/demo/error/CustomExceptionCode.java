package com.demo.error;

/**
 * @author Mehraj Malik
 * @version 1.0
 */
public enum CustomExceptionCode {

	HOTEL_CREATE_EXCEPTION("ERR0001","Exception occured while creating hotel"),
	HOTEL_SAVE_EXCEPTION("ERR0002","Exception occured while saving hotel"),
	HOTEL_UPDATE_EXCEPTION("ERR0003","Exception occured while updating hotel"),
	HOTEL_DELETE_EXCEPTION("ERR0004","Exception occured while deleting hotel"),
	NO_HOTEL_EXIST_WITH_ID_EXCEPTION("ERR0005","No hotel exist with provided Id");
	
	
	private final String errCode;
	private final String errMsg;

	private CustomExceptionCode(final String errCode, final String errMsg) {
		this.errCode = errCode;
		this.errMsg = errMsg;
	}

	public String getErrCode() {
		return errCode;
	}

	public String getErrMsg() {
		return errMsg;
	}

	@Override
	public String toString() {
		return errCode + " : " + errMsg;
	}
}
