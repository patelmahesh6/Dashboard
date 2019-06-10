/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.panthera.mapper;

/**
 *
 * @author dpimac
 */

public interface GenericMapper<M,B> {
    M toModel(B bean);
    B toBean(M model);
}
