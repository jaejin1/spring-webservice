package com.jaejin.webservice.exception;

import lombok.Getter;

@Getter
public class StudentNotFoundException extends RuntimeException {

    private long id;

    public StudentNotFoundException(long id) {
        this.id = id;
    }
}
