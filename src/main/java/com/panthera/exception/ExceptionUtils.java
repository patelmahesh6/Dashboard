/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.panthera.exception;

import java.time.LocalDateTime;
import java.util.Map;

/**
 *
 * @author Mahesh
 */
public class ExceptionUtils {

    public static ExceptionResponse getExceptionDetails(Map<String, Object> errorMap) {

        ExceptionResponse exception = new ExceptionResponse();

        exception.setStatus((Integer) errorMap.get("status"));
        exception.setPath((String) errorMap.get("path"));
        exception.setErrorMessage((String) errorMap.get("message"));
        exception.setTrace((String) errorMap.get("error"));
        exception.setTimeStamp(LocalDateTime.now());

        return exception;
    }
}
