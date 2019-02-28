/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.panthera.controller;

import com.panthera.annotation.MethodExecutionTime;
import com.panthera.beans.UserInfoBean;
import com.panthera.exception.RecordNotFoundException;
import com.panthera.model.UserInfo;
import com.panthera.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author user
 */
@RestController
@RequestMapping("/")
public class UserController {

    @Autowired
    private UserService userService;

    @MethodExecutionTime
    @GetMapping(path = "/getUserDetails", produces = "application/json")
    public ResponseEntity<UserInfo> getAllUserDetails() {
        throw new RecordNotFoundException("No Record Avilable: ");
        //UserInfoBean bean = new UserInfoBean();
        //return new ResponseEntity<>(userService.saveUserInfo(new UserInfo()), HttpStatus.OK);
    }

    @PostMapping(path = "/addUserDetails", consumes = "application/json", produces = "application/json")
    public ResponseEntity<Object> addUserDetails(@RequestBody UserInfoBean userDetails) {
        return new ResponseEntity<>(userService.saveUserInfo(new UserInfo()), HttpStatus.OK);
    }

}
