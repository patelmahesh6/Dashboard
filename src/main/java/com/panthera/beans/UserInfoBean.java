/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.panthera.beans;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 *
 * @author user
 */
@Data
@NoArgsConstructor
public class UserInfoBean {

    @NotNull
    private Integer userDetailId;

    @NotEmpty(message = "first name must not be empty")
    private String firstName;

    @NotEmpty(message = "last name must not be empty")
    private String lastName;

    @NotEmpty(message = "email must not be empty")
    @Email(message = "email should be a valid email")
    private String email;

}
