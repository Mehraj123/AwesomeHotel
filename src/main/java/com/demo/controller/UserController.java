package com.demo.controller;

import static com.demo.successcode.UserRegistrationSuccessCode.USER_CREATED;
import static com.demo.successcode.UserRegistrationSuccessCode.USER_LOGIN_SUCCESS;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;
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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.demo.model.LoginVM;
import com.demo.model.UserRegistrationVM;
import com.demo.mv.UserRegistrationMV;
import com.demo.service.UserLoginService;
import com.demo.service.UserRegistrationService;

import static com.demo.successcode.UserRegistrationSuccessCode.*;

import static com.demo.util.Constants.PAGE_INFO;

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
@RestController
@RequestMapping("/users")
// @CrossOrigin(origins="http://localhost:4200", allowedHeaders="*")
public class UserController {

    private static final Logger log = LoggerFactory.getLogger(UserController.class);

    private UserRegistrationService userRegistrationService;
    private UserLoginService userLoginService;
    private ViewController viewController;

    public UserController(UserRegistrationService userRegistrationService, UserLoginService userLoginService, ViewController viewController) {
        this.userRegistrationService = userRegistrationService;
        this.userLoginService = userLoginService;
        this.viewController = viewController;
    }

    /***
     * @author Iti Gupta
     * @param userRegistrationVM
     * @return Custom Response
     */
    @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<CustomResponse> registration(@RequestBody @Valid UserRegistrationVM userRegistrationVM) {

        return new ResponseEntity<>(new CustomResponse(USER_CREATED.getCode(), USER_CREATED.getMessage(),
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
        pageinfo.put(PAGE_INFO, users.getPageInfo());
        return new ResponseEntity<>(
                new CustomResponse(USER_FETCHED.getCode(), USER_FETCHED.getMessage(), users.getContent(), pageinfo),
                HttpStatus.OK);
    }

    @GetMapping("/check")
    public String check() {

        return "Hello";
    }

    /***
     * @author Iti Gupta
     * @param loginVM
     * @param response
     * @return Custom Response
     */
    @PostMapping(value = "/login", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<CustomResponse> userLogin(@RequestBody @Valid LoginVM loginVM, HttpServletResponse response) {
        String s = userLoginService.login(loginVM, response);
        return new ResponseEntity<>(new CustomResponse(USER_LOGIN_SUCCESS.getCode(), USER_LOGIN_SUCCESS.getMessage(),
                s, null), HttpStatus.OK);

    }
}
