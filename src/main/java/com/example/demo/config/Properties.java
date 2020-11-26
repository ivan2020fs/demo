package com.example.demo.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class Properties {
    @Value("${exception.message}")
    private String exceptionMessage;
    @Value("${file.name}")
    private String fileName;
    @Value("${log.file.name}")
    private String logFileName;
    @Value("${log.title.name}")
    private String logTitleName;
    public String getExceptionMessage() {
        return exceptionMessage;
    }

    public String getFileName() {
        return fileName;
    }

    public String getLogFileName() {
        return logFileName;
    }

    public String getLogTitleName() {
        return logTitleName;
    }

}

