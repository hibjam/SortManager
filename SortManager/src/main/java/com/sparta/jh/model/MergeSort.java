package com.sparta.jh.model;

import java.util.Arrays;
import java.util.logging.Level;

import static com.sparta.jh.controller.SortManager.newLogger;

public class MergeSort implements Sorter {
    public int[] sort(int[] intsArray){
        splitArray(intsArray);
        return (intsArray);
    }

    public int[] sorterForTest(int[] intsArray){
        splitArray(intsArray);
        return intsArray;
    }
    public static void splitArray(int[] intsArray){
        int fullArrayLength = intsArray.length;
        if (fullArrayLength < 2) {
            return;
        }
        int middleIndex = fullArrayLength / 2;
        int[] leftArray = new int[middleIndex];
        int[] rightArray = new int[fullArrayLength - middleIndex];
        for (int i = 0; i < middleIndex; i++) {
            leftArray[i] = intsArray[i];
        }
        for (int i = middleIndex; i < fullArrayLength; i++) {
            rightArray[i - middleIndex] = intsArray[i];
        }
        splitArray(leftArray);
        splitArray(rightArray);
        mergeArray(intsArray, leftArray, rightArray);

    }

    public static void mergeArray ( int[] intsArray, int[] leftHalf, int[] rightHalf){
        int leftSize = leftHalf.length;
        int rightSize = rightHalf.length;
        int i = 0;
        int j = 0;
        int k = 0;
        while (i < leftSize && j < rightSize) {
            if (leftHalf[i] <= rightHalf[j]) {
                intsArray[k] = leftHalf[i];
                i++;
            } else {
                intsArray[k] = rightHalf[j];
                j++;
            }
            k++;
        }
        while (i < leftSize) {
            intsArray[k] = leftHalf[i];
            i++; k++;
        }
        while (j < rightSize) {
            intsArray[k] = rightHalf[j];
            j++; k++;
        }
    }
}

