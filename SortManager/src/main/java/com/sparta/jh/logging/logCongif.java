package com.sparta.jh.logging;

import java.io.IOException;
import java.util.logging.FileHandler;
import java.util.logging.Handler;

import static com.sparta.jh.controller.SortManager.newLogger;

public class logCongif {
    public static void logger() {
        try {
            Handler fileHandler = new FileHandler("src/main/java/com/sparta/jh/logging/sortManagerLog.log", true);
            newLogger.addHandler(fileHandler);
            newLogger.setFilter(new CustomFilter());
            fileHandler.setFormatter(new CustomFormat());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
