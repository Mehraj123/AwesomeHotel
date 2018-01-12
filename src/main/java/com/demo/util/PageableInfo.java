package com.demo.util;

import java.io.Serializable;
import java.util.List;

/**
 * @author Mehraj Malik
 * @version 1.0
 *
 */
public class PageableInfo<T> implements Serializable {

	private static final long serialVersionUID = 1L;

	private List<T> content;
	private PageInfo pageInfo;

	public List<T> getContent() {
		return content;
	}

	public void setContent(List<T> content) {
		this.content = content;
	}

	public PageInfo getPageInfo() {
		return pageInfo;
	}

	public void setPageInfo(PageInfo pageInfo) {
		this.pageInfo = pageInfo;
	}

}
