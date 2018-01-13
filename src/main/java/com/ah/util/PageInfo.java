package com.ah.util;

import java.io.Serializable;

/**
 * @author Mehraj Malik
 * @version 1.0
 *
 */
public class PageInfo implements Serializable {

	private static final long serialVersionUID = 1L;

	private String totalPages;
	private String totalElements;
	private String size;
	private String number;
	private String numberOfElements;

	public String getTotalPages() {
		return totalPages;
	}

	public void setTotalPages(String totalPages) {
		this.totalPages = totalPages;
	}

	public String getTotalElements() {
		return totalElements;
	}

	public void setTotalElements(String totalElements) {
		this.totalElements = totalElements;
	}

	public String getSize() {
		return size;
	}

	public void setSize(String size) {
		this.size = size;
	}

	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}

	public String getNumberOfElements() {
		return numberOfElements;
	}

	public void setNumberOfElements(String numberOfElements) {
		this.numberOfElements = numberOfElements;
	}

	@Override
	public String toString() {
		return "PageInfo [totalpages=" + totalPages + ", totalElements=" + totalElements + ", size=" + size
				+ ", number=" + number + ", numberOfElements=" + numberOfElements + "]";
	}
}
