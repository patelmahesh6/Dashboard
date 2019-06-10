/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.panthera.beans;

import lombok.Getter;
import lombok.Setter;

/**
 *
 * @author Mahesh
 */
@Getter
@Setter
public class RegisterUser {

    private Long userId;

    private String login;

    private String password;

    private String username;

    private String firstName;

    private String lastName;

    private String email;

    private String mobileNo;

    private int loginType;

    private String imageUrl;

    private String langKey;

    private String activationKey;

}
