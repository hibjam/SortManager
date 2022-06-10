package com.sparta.jh.model.bubblesort;

import com.sparta.jh.model.Sorter;

import java.util.Arrays;
import java.util.logging.Level;

import static com.sparta.jh.controller.SortManager.newLogger;

public class BubbleSort implements Sorter {

    public int[] sort(int[] intsArray){
        bubbleSort(intsArray);
        return (intsArray);
    }
    public static int[] bubbleSort(int[] intsArray) {
        for(int i=0; i < intsArray.length; i++){
            for(int index=1; index < (intsArray.length-i); index++){
                if(intsArray[index-1] > intsArray[index]){
                    swapNumbers(intsArray, index);
                }
            }
        }
        return intsArray;
    }
    private static void swapNumbers(int[] intsArray, int index) {
        int largerNum;
        largerNum = intsArray[index -1];
        intsArray[index -1] = intsArray[index];
        intsArray[index] = largerNum;
    }
}
