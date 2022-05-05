package com.example.log4j2json.services

import groovy.util.logging.Log4j2
import org.apache.logging.log4j.LogManager
import org.apache.logging.log4j.Logger
import org.springframework.boot.logging.LogLevel
import org.springframework.stereotype.Service

@Log4j2
@Service
class LogService {

    private final static Logger LOGGER = LogManager.getLogger(this)

    void writeLog(String message, LogLevel level) {
        switch (level) {
            case LogLevel.INFO:
                log.info(message)
                break
            case LogLevel.WARN:
                log.warn(message)
                break
            case LogLevel.ERROR:
                log.error(message, new RuntimeException("Exception 1", new IllegalArgumentException("Exception Cause")))
                break
            default:
                LOGGER.debug(message)
        }
    }

}
