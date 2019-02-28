/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.panthera.service;

import com.panthera.model.UserInfo;
import com.panthera.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author user
 */
@Service
public class UserService {
    
    @Autowired
    private UserRepository userRepository;
    
    public UserInfo getAllUserDetails() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    public UserInfo saveUserInfo(UserInfo userInfo) {
        UserInfo userInfoD = new UserInfo();
        userInfoD.setFirstName("Mahesh");
        userInfoD.setLastName("Patel");
        userInfoD.setEmail("patelmahesh1618@gmail.com");
        userRepository.save(userInfoD);
        return userInfoD;
    }
    
}
