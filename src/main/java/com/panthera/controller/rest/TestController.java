/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.panthera.controller.rest;

import com.panthera.annotation.MethodExecutionTime;
import com.panthera.beans.UserInfoBean;
import com.panthera.model.User;
import com.panthera.model.UserInfo;
import com.panthera.service.MailService;
import com.panthera.service.UserService;
import com.panthera.utility.PaginationUtil;
import java.util.List;
import javax.validation.Valid;
import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Mahesh
 */
@RestController
@RequestMapping("/test")
public class TestController {

    @Autowired
    private MailService mailService;

    @Autowired
    private UserService userService;

    /*
    
    @Autowired
    private Producer producer;

    @GetMapping(value = "/kafka")
    public void sendMessageToKafkaTopic() {
        for (int i = 0; i < 10; i++) {
            this.producer.sendMessage("Hello World" + i);
        }

    }
    
    */
    
    
    @GetMapping("/mail")
    public void sendMail() {
        User user = new User();
        user.setLogin("patelmahesh6");
        user.setPassword(RandomStringUtils.random(60));
        user.setActivated(true);
        user.setEmail("patelmahesh1618@gmail.com");
        user.setFirstName("Mahesh");
        user.setLastName("Patel");
        user.setImageUrl("http://placehold.it/50x50");
        user.setLangKey("en");

        mailService.sendActivationEmail(user);
    }

    @GetMapping("/exception")
    public void getEception() throws Exception {
        throw new Exception("Exception Occurred");
    }

    @MethodExecutionTime
    @GetMapping(path = "/getUserDetails", produces = "application/json")
    public ResponseEntity<UserInfo> getAllUserDetails() {
        //throw new RecordNotFoundException("No Record Avilable: ");
        UserInfoBean bean = new UserInfoBean();
        return new ResponseEntity<>(userService.saveUserInfo(new UserInfo()), HttpStatus.OK);
    }

    @PostMapping(path = "/addUserDetails", consumes = "application/json", produces = "application/json")
    public ResponseEntity<Object> addUserDetails(@Valid @RequestBody UserInfoBean userDetails) {
        return new ResponseEntity<>(userService.saveUserInfo(new UserInfo()), HttpStatus.OK);
    }

    @GetMapping("/getAllUsers")
    public ResponseEntity<List<User>> getAllUsers(Pageable pageable) {
        final Page<User> page = userService.getAllUsers(pageable);
        HttpHeaders headers = PaginationUtil.generatePaginationHttpHeaders(page, "/getAllUsers");
        return new ResponseEntity<>(page.getContent(), headers, HttpStatus.OK);
    }
  
}
