package com.sparta.jh;

import com.sparta.jh.model.BubbleSort;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Random;

public class BubbleSortTest {
    public BubbleSort bs = new BubbleSort();



    @Test
    @DisplayName("BubbleSort returns single length array")
    void bubbleSortReturnsArray(){
        int[] array = {1};
        int[] array2 = array.clone();
        bs.bubbleSort(array2);
        Assertions.assertArrayEquals(array, array2);
    }

    @Test
    @DisplayName("BubbleSort is able to take a large array of ints and sort them into order")
    void bubbleSortReturnsSortedArray() {
        int[] arrayToSort = {241, 206, 253, 130, 299, 115, 215, 243, 137, 113, 130, 87, 107, 250, 26, 1, 252, 134, 3, 139, 143, 221, 269, 51, 208, 24, 115, 11, 255, 117};
        int[] sortedArray = arrayToSort.clone();
        bs.sort(sortedArray);
        Arrays.sort(arrayToSort);
        Assertions.assertArrayEquals(arrayToSort, sortedArray);
    }

    @Test
    @DisplayName("BubbleSort is able to take an array of negative int values and sort them")
    void bubbleSortNegativeArray(){
        int[] negativeArray = {-5, -13, -4, -42, -19, -17, -8, -19, -3, -18};
        int[] negativeSortedArray = negativeArray.clone();
        bs.bubbleSort(negativeSortedArray);
        Arrays.sort(negativeArray);
        Assertions.assertArrayEquals(negativeArray, negativeSortedArray);
    }

    @Test
    @DisplayName("BubbleSort returns an array of zeros if an array of zeros is passed into it")
    void bubbleSortZeros(){
        int[] arrayOfZeros = {0,0,0,0,0,0};
        int[] zerosSorted = arrayOfZeros.clone();
        bs.bubbleSort(zerosSorted);
        Assertions.assertArrayEquals(arrayOfZeros,zerosSorted);
    }

    @Test
    @DisplayName("BubbleSort will return an empty array if an empty array is entered")
    void emptyArray(){
        int[] empty = {};
        int[] emptyClone = empty.clone();
        bs.bubbleSort(emptyClone);
        Assertions.assertArrayEquals(empty,emptyClone);
    }

    @Test
    @DisplayName("BubbleSort test with already sorted array")
    void alreadySorted(){
        int[] sorted = {1, 2, 3, 4, 5, 6};
        int[] bubbleSorted = sorted.clone();
        bs.sort(bubbleSorted);
        Assertions.assertArrayEquals(sorted,bubbleSorted);
    }
}
