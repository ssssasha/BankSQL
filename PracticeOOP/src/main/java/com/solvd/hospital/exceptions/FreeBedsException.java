package com.solvd.hospital.exceptions;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class FreeBedsException extends RuntimeException  {
    private static final Logger LOGGER = LogManager.getLogger(FreeBedsException.class);

    public FreeBedsException() {
        LOGGER.info("info about available beds");
    }

    public FreeBedsException(String message) {
        super(message);
    }
}
