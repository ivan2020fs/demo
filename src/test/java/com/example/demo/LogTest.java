package com.example.demo;

import com.example.demo.config.Properties;
import com.example.demo.utils.LogType;
import com.example.demo.utils.Logs;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;


import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(MockitoExtension.class)
public class LogTest {

    @Mock
    private Properties properties;

    @InjectMocks
    private Logs logs;

    @BeforeEach
    public void setup(){
        Mockito.when(properties.getLogTitleName()).thenReturn("logtitlename");
        Mockito.when(properties.getLogFileName()).thenReturn("logfilename");
    }

    @Test
    public void writeLogTest(){
    Boolean response = logs.writeLog(LogType.INFO,"mensaje 1");
        assertEquals(true,response);
        response = logs.writeLog(LogType.WARN,"mensaje 2");
        assertEquals(true,response);
        response = logs.writeLog(LogType.DEBUG,"mensaje 3");
        assertEquals(true,response);
        response = logs.writeLog(LogType.ERROR,"mensaje 4");
        assertEquals(true,response);
    }
}
