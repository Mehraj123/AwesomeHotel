package com.ah.error;

import java.util.function.Supplier;

/**
 * @author Mehraj Malik
 * @version 1.0
 */
public final class HotelExceptionSupplier {

	private HotelExceptionSupplier() {
	}

	public static final Supplier<CustomParameterizedException> HOTEL_FETCH_EXCEPTION = () -> new CustomParameterizedException(
			RegisteredException.HOTEL_EXCEPTION.getException(), CustomExceptionCode.HOTEL_FETCH_EXCEPTION.getErrMsg(),
			CustomExceptionCode.HOTEL_FETCH_EXCEPTION.getErrCode());

	public static final Supplier<CustomParameterizedException> HOTEL_SAVE_EXCEPTION = () -> new CustomParameterizedException(
			RegisteredException.HOTEL_EXCEPTION.getException(), CustomExceptionCode.HOTEL_SAVE_EXCEPTION.getErrMsg(),
			CustomExceptionCode.HOTEL_SAVE_EXCEPTION.getErrCode());

	public static final Supplier<CustomParameterizedException> HOTEL_UPDATE_EXCEPTION = () -> new CustomParameterizedException(
			RegisteredException.HOTEL_EXCEPTION.getException(), CustomExceptionCode.HOTEL_UPDATE_EXCEPTION.getErrMsg(),
			CustomExceptionCode.HOTEL_UPDATE_EXCEPTION.getErrCode());

	public static final Supplier<CustomParameterizedException> HOTEL_DELETE_EXCEPTION = () -> new CustomParameterizedException(
			RegisteredException.HOTEL_EXCEPTION.getException(), CustomExceptionCode.HOTEL_DELETE_EXCEPTION.getErrMsg(),
			CustomExceptionCode.HOTEL_DELETE_EXCEPTION.getErrCode());

	public static final Supplier<CustomParameterizedException> NO_HOTEL_FOUND_BY_ID_EXCEPTION = () -> new CustomParameterizedException(
			RegisteredException.HOTEL_EXCEPTION.getException(),
			CustomExceptionCode.NO_HOTEL_EXIST_WITH_ID_EXCEPTION.getErrMsg(),
			CustomExceptionCode.NO_HOTEL_EXIST_WITH_ID_EXCEPTION.getErrCode());

	public static final Supplier<CustomParameterizedException> HOTELNAME_NOT_UNIQUE_EXCEPTION = () -> new CustomParameterizedException(
			RegisteredException.HOTEL_EXCEPTION.getException(),
			CustomExceptionCode.HOTELNAME_NOT_UNIQUE_EXCEPTION.getErrMsg(),
			CustomExceptionCode.HOTELNAME_NOT_UNIQUE_EXCEPTION.getErrCode());

	public static final Supplier<CustomParameterizedException> SIZE_CANNOT_BE_NEGATIVE_EXCEPTION = () -> new CustomParameterizedException(
			RegisteredException.HOTEL_EXCEPTION.getException(), CustomExceptionCode.SIZE_CANNOT_BE_NEGATIVE.getErrMsg(),
			CustomExceptionCode.SIZE_CANNOT_BE_NEGATIVE.getErrCode());

}
