/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.panthera.utility.enums;

/**
 *
 * @author user
 */
public enum AuthenticationProvider {
    local(1),
    facebook(2),
    google(3),
    github(4),
    linkedin(5),
    other(6);

    private int value;

    private AuthenticationProvider(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}
