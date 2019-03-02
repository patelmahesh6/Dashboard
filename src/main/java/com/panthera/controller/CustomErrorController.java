/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.panthera.controller;

import com.panthera.exception.ExceptionResponse;
import com.panthera.exception.ExceptionUtils;
import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.error.ErrorAttributes;
import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.context.request.WebRequest;
import springfox.documentation.annotations.ApiIgnore;

/**
 *
 * @author user
 */
@ApiIgnore
@Controller
public class CustomErrorController implements ErrorController {

    @Autowired
    private ErrorAttributes errorAttributes;

    @RequestMapping("/error")
    @ResponseBody
    public ExceptionResponse error(WebRequest webRequest, HttpServletResponse response) {
        ExceptionResponse exceptionResponse = ExceptionUtils.getExceptionDetails(errorAttributes.getErrorAttributes(webRequest, true));
        exceptionResponse.setStatus(response.getStatus());
        return exceptionResponse;
    }

    @Override
    public String getErrorPath() {
        return "/error";
    }

}
