package com.sparta.jh.controller;

import com.sparta.jh.exceptions.IncorrectSelectException;
import com.sparta.jh.model.BubbleSort;
import com.sparta.jh.model.MergeSort;
import com.sparta.jh.model.Sorter;
import com.sparta.jh.model.binarysort.BinarySort;

import java.util.logging.Level;

import static com.sparta.jh.controller.SortManager.newLogger;

public class SortFactory {
    public static Sorter getSorter(String choice) throws IncorrectSelectException {
        switch (choice) {
            case "bubble":
                return new BubbleSort();
            case "binary":
                return new BinarySort();
            case "merge":
                return new MergeSort();
            default:
                newLogger.log(Level.WARNING, "User has not entered a valid choice!");
                throw new IncorrectSelectException("Not a valid sort method: " + choice);
        }
    }
}

