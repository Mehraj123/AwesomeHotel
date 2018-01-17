package com.demo.controller;

import java.util.HashMap;
import java.util.Map;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.demo.model.UserRegistrationVM;
import com.demo.mv.UserRegistrationMV;
import com.demo.service.UserRegistrationService;
import com.demo.successcode.UserRegistrationSuccessCode;
import com.demo.util.Constants;
import com.demo.util.CustomResponse;
import com.demo.util.PageableInfo;

/***
 * 
 * REST Controller for User Registration
 * 
 * @author Iti Gupta
 * @version 1.0
 *
 */
@RestController("/users")
// @CrossOrigin(origins="http://localhost:4200", allowedHeaders="*")
public class RegistrationController {

	private static final Logger log = LoggerFactory.getLogger(RegistrationController.class);

	private UserRegistrationService userRegistrationService;

	public RegistrationController(UserRegistrationService userRegistrationService) {
		this.userRegistrationService = userRegistrationService;
	}

	/***
	 * @author Iti Gupta
	 * @param userRegistrationVM
	 * @return Custom Response
	 */
	@PostMapping(produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<CustomResponse> userRegistration(@RequestBody @Valid UserRegistrationVM userRegistrationVM) {

		return new ResponseEntity<>(new CustomResponse(UserRegistrationSuccessCode.USER_CREATED.getCode(),
				UserRegistrationSuccessCode.USER_CREATED.getMessage(),
				userRegistrationService.userRegistration(userRegistrationVM), null), HttpStatus.OK);

	}

	/***
	 * @author Iti Gupta
	 * @param pageable
	 * @return Custom Response
	 */
	@GetMapping
	public ResponseEntity<CustomResponse> getAllUsers(Pageable pageable) {
		log.info("Enter in getAllUsers()...");
		PageableInfo<UserRegistrationMV> users = userRegistrationService.getAll(pageable);
		Map<String, Object> pageinfo = new HashMap<>(1);
		pageinfo.put(Constants.PAGE_INFO, users.getPageInfo());
		return new ResponseEntity<>(
				new CustomResponse(UserRegistrationSuccessCode.USER_FETCHED.getCode(),
						UserRegistrationSuccessCode.USER_FETCHED.getMessage(), users.getContent(), pageinfo),
				HttpStatus.OK);
	}
}
