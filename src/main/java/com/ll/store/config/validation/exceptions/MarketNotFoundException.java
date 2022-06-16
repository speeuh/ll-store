package com.ll.store.config.validation.exceptions;

public class MarketNotFoundException extends RuntimeException {
        private static final long serialVersionUID = 1L;
        public MarketNotFoundException(String message){
            super(message);
        }
    }
