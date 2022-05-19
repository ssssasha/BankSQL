package com.solvd.hospital.exceptions;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class NumberException extends RuntimeException{
    private static final Logger LOGGER = LogManager.getLogger(NumberException.class);

    public NumberException(String message) {
        super(message);
    }
}
