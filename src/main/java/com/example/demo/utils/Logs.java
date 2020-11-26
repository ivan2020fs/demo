package com.example.demo.utils;

import com.example.demo.config.Properties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.logging.java.SimpleFormatter;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.logging.FileHandler;
import java.util.logging.Logger;

@Component
public class Logs {

    @Autowired
    private Properties properties;

    @Async
    //función que crea los log en la carpeta del proyecto
    public boolean writeLog(LogType logType, String msg) {

        Logger logger = Logger.getLogger(properties.getLogTitleName());
        FileHandler fh;

        try {

            fh = new FileHandler(properties.getLogFileName(),true);
            logger.addHandler(fh);
            SimpleFormatter formatter = new SimpleFormatter();
            fh.setFormatter(formatter);

            switch (logType) {
                case INFO:
                    logger.info(msg);
                    break;
                case WARN:
                    logger.warning(msg);
                    break;
                case DEBUG:
                    logger.config(msg);
                    break;
                case ERROR:
                    logger.severe(msg);
                    break;

            }
            fh.close();

        } catch (SecurityException e) {
            e.printStackTrace();
            return false;
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }

        return true;
    }
}
