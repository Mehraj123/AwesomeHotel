package com.demo.error;

import com.google.common.base.Supplier;

/**
 * @author Mehraj Malik
 * @version 1.0
 */
public final class HotelExceptionSupplier {

	private HotelExceptionSupplier() {
	}

	public static final Supplier<CustomParameterizedException> NO_HOTEL_FOUND_BY_ID = () -> new CustomParameterizedException(
			RegisteredException.HOTEL_EXCEPTION.getException(),
			CustomExceptionCode.NO_HOTEL_EXIST_WITH_ID_EXCEPTION.getErrMsg(),
			CustomExceptionCode.NO_HOTEL_EXIST_WITH_ID_EXCEPTION.getErrCode());

}
