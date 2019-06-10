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
 * @author dpimac
 */
@Getter
@Setter
public class JasperBean {

    String  header;
    String footer;
    String background;

    public JasperBean getDefaultProperties() {
        JasperBean jasperBean = new JasperBean();
        jasperBean.setHeader(header);
        jasperBean.setFooter(footer);
        jasperBean.setBackground(background);
        return jasperBean;

    }
}
