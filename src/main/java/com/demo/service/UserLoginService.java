package com.demo.service;

import javax.servlet.http.HttpServletResponse;

import com.demo.model.LoginVM;

/***
 * Contract for {@code UserLoginServiceImpl}
 * 
 * @author Devendra.Kumar
 * @version 1.0
 *
 */
public interface UserLoginService {

	public String login(LoginVM loginVM,HttpServletResponse response);
}
