package com.sparta.jh;

import com.sparta.jh.controller.SortManager;
import com.sparta.jh.logging.CustomFilter;
import com.sparta.jh.logging.CustomFormat;
import com.sparta.jh.model.binarysort.BinarySort;

import java.io.IOException;
import java.util.logging.FileHandler;
import java.util.logging.Handler;
import java.util.logging.Level;

import static com.sparta.jh.controller.SortManager.newLogger;
import static com.sparta.jh.logging.logCongif.logger;

public class Start {
    public static void main(String[] args) {
        logger();
        new SortManager().sortManager();
    }
}
