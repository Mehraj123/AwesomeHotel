package com.demo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/test")
@RestController
public class TestController {

    @GetMapping
    ApiResponse<String> get() throws Exception {
       if(true)
            throw new Exception("My exception ");
        return ApiResponse.success().object("hello");
    }
}
