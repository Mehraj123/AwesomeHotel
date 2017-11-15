package com.demo.service;

import java.io.Serializable;

/**
 * @author Mehraj Malik
 *
 */
public class Armor implements Serializable {

	private static final long serialVersionUID = 1L;

	private String name;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
