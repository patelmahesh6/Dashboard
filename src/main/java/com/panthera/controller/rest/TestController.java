/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.panthera.controller.rest;

import com.panthera.model.User;
import com.panthera.service.MailService;
import com.panthera.service.UserService;
import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
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

}
