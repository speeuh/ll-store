package com.ll.store.config.validation.exceptions;

public class SectionNotFoundException extends RuntimeException{

    private static final long serialVersionUID = 1L;
    public SectionNotFoundException(String message){
        super(message);
    }

}
