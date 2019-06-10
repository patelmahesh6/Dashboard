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
public class PasswordChange {

    private String key;
    private String currentPassword;
    private String newPassword;

}
