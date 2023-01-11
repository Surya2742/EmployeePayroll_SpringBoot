package com.project.employeepayroll.exception;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Exception extends RuntimeException {
    String message;

    public Exception(String fieldValue) {
        this.message = fieldValue;
    }

}