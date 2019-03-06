/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.panthera.exception;

import org.springframework.security.core.AuthenticationException;

/**
 *
 * @author user
 */
public class OAuth2AuthException extends AuthenticationException {

    public OAuth2AuthException(String msg, Throwable t) {
        super(msg, t);
    }

    public OAuth2AuthException(String msg) {
        super(msg);
    }

}
