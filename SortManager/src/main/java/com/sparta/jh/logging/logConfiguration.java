package com.sparta.jh.logging;

import java.io.IOException;
import java.util.logging.FileHandler;
import java.util.logging.Handler;

import static com.sparta.jh.controller.SortManager.newLogger;

public class logConfiguration {
    public static void logger() {
        try {
            Handler newFileHandler = new FileHandler("src/main/java/com/sparta/jh/logging/logFile.log", true);
            newLogger.addHandler(newFileHandler);
            newLogger.setFilter(new CustomFilter());
            newFileHandler.setFormatter(new CustomFormat());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
