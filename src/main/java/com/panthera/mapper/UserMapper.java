/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.panthera.mapper;

import com.panthera.beans.RegisterUser;
import com.panthera.model.User;
import org.mapstruct.Mapper;

/**
 *
 * @author dpimac
 */
@Mapper
public interface UserMapper{
    
    RegisterUser toUser(User user);

    User toRegisterUser(RegisterUser registerUser);

}
