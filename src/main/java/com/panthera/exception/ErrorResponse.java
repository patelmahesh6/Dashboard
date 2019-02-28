/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.panthera.exception;

import com.fasterxml.jackson.annotation.JsonFormat;
import java.time.LocalDateTime;
import java.util.List;
import lombok.Data;
import org.springframework.http.HttpStatus;

/**
 *
 * @author user
 */
@Data
public class ErrorResponse {

    private HttpStatus status;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy hh:mm:ss")
    private LocalDateTime timestamp;
    private String message;
    private List<String> details;

    private ErrorResponse() {
        timestamp = LocalDateTime.now();
    }

    public ErrorResponse(String message) {
        this();
        this.message = message;

    }

    public ErrorResponse(HttpStatus status, List<String> details) {
        this();
        this.status = status;
        this.details = details;

    }

    public ErrorResponse(HttpStatus status, String message, List<String> details) {
        this();
        this.status = status;
        this.message = message;
        this.details = details;

    }
}
