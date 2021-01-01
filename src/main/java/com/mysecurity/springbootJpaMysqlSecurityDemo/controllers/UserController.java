package com.mysecurity.springbootJpaMysqlSecurityDemo.controllers;

import com.mysecurity.springbootJpaMysqlSecurityDemo.entity.UserCred;
import com.mysecurity.springbootJpaMysqlSecurityDemo.repository.UserCredRepo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    @Autowired
    UserCredRepo userCredRepo;

    private Logger logger = LoggerFactory.getLogger(UserController.class);

    @GetMapping("/")
    public String getHome(){
        logger.error("error log");
        logger.warn("warn log");
        logger.info("info log");
        logger.debug("debug log");
        logger.trace("trace log");
        return "welcome to home page";
    }

    @GetMapping("/getUserCred/{username}")
    public UserCred getUserCred(@PathVariable String username){
        return userCredRepo.findByUsername(username);
    }

    @GetMapping("/admin")
    public String getAdmin(){
        return "welcome to Admin page";
    }

    @GetMapping("/user")
    public String getUser(){
        return "welcome to User page";
    }
}
