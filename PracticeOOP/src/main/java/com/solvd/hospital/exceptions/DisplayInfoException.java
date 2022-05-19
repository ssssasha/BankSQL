package com.solvd.hospital.exceptions;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class DisplayInfoException extends RuntimeException {
    private static final Logger LOGGER = LogManager.getLogger(DisplayInfoException.class);

    public DisplayInfoException() {
        LOGGER.info("Data must be provided");
    }

    public DisplayInfoException(String message) {
        super(message);
    }
}
