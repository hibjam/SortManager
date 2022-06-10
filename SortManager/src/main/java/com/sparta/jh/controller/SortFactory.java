package com.sparta.jh.controller;

import com.sparta.jh.exceptions.IncorrectSelectException;
import com.sparta.jh.model.bubblesort.BubbleSort;
import com.sparta.jh.model.insertionsort.InsertionSort;
import com.sparta.jh.model.mergesort.MergeSort;
import com.sparta.jh.model.Sorter;
import com.sparta.jh.model.binarysort.BinarySort;

import java.util.Arrays;
import java.util.logging.Level;

import static com.sparta.jh.controller.SortManager.newLogger;

public class SortFactory {
    public static String beginChosenSort(String choice, int[] arrayToSort){
        try {
            Sorter s = SortFactory.getSorter(choice);
            return Arrays.toString(s.sort(arrayToSort));
        }catch (IncorrectSelectException e){
            System.out.println(e.getMessage());
        }
        return null;
    }
    public static Sorter getSorter(String choice) throws IncorrectSelectException {
        switch (choice) {
            case "bubble":
                return new BubbleSort();
            case "binary":
                return new BinarySort();
            case "merge":
                return new MergeSort();
            case "insertion":
                return new InsertionSort();
            default:
                newLogger.log(Level.WARNING, "User has not entered a valid choice!");
                throw new IncorrectSelectException("Not a valid sort method: " + choice);
        }
    }
}

