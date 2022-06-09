package com.sparta.jh.controller;

import com.sparta.jh.exceptions.IncorrectSelectException;
import com.sparta.jh.model.Sorter;

import java.util.Arrays;


public class ArrayInputInSorter {

    public ArrayInputInSorter (){}
    public static String completeSort(String choice, int[] arrayToSort){
        try {
            Sorter s = SortFactory.getSorter(choice);
            return Arrays.toString(s.sort(arrayToSort));
        }catch (IncorrectSelectException e){
            System.out.println(e.getMessage());
        }
        return null;
    }
}
