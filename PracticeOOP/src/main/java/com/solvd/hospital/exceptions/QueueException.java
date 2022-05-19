package com.solvd.hospital.exceptions;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class QueueException extends RuntimeException {
    private static final Logger LOGGER = LogManager.getLogger(QueueException.class);

    public QueueException() {
        LOGGER.info("info about queue");
    }

    public QueueException(String message) {
        super(message);
    }
}
