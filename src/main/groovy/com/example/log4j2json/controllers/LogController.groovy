package com.example.log4j2json.controllers

import com.example.log4j2json.services.LogService
import groovy.util.logging.Slf4j
import org.springframework.boot.logging.LogLevel
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController

@Slf4j
@RequestMapping('/log')
@RestController
class LogController {

    private final LogService service

    LogController(LogService service) {
        this.service = service
    }

    @GetMapping
    ResponseEntity<Map> writeLog(@RequestParam String message, @RequestParam(defaultValue = 'INFO') LogLevel level) {
        service.writeLog(message, level)
        ResponseEntity.ok(message: message, level: level)
    }

}
