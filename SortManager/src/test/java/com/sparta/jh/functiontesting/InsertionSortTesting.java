package com.sparta.jh.functiontesting;

import com.sparta.jh.model.Sorter;
import com.sparta.jh.model.insertionsort.InsertionSort;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

public class InsertionSortTesting {

    Sorter sorter = new InsertionSort();

    @Test
    @DisplayName("InsertionSort returns single length array")
    void insertionSortReturnsArray(){
        int[] array = {1};
        int[] array2 = array.clone();
        sorter.sort(array2);
        Assertions.assertArrayEquals(array, array2);
    }

    @Test
    @DisplayName("Insertion Sort is able to take a large array of ints and sort them into order")
    void insertionSortReturnsSortedArray() {
        int[] arrayToSort = {241, 206, 253, 130, 299, 115, 215, 243, 137, 113, 130, 87, 107, 250, 26, 1, 252, 134, 3, 139, 143, 221, 269, 51, 208, 24, 115, 11, 255, 117};
        int[] sortedArray = arrayToSort.clone();
        sorter.sort(sortedArray);
        Arrays.sort(arrayToSort);
        Assertions.assertArrayEquals(arrayToSort, sortedArray);
    }

    @Test
    @DisplayName("Insertion Sort is able to take an array of negative int values and sort them")
    void insertionSortNegativeArray(){
        int[] negativeArray = {-5, -13, -4, -42, -19, -17, -8, -19, -3, -18};
        int[] negativeSortedArray = negativeArray.clone();
        sorter.sort(negativeSortedArray);
        Arrays.sort(negativeArray);
        Assertions.assertArrayEquals(negativeArray, negativeSortedArray);
    }

    @Test
    @DisplayName("Insertion Sort returns an array of zeros if an array of zeros is passed into it")
    void insertionSortZeros(){
        int[] arrayOfZeros = {0,0,0,0,0,0};
        int[] zerosSorted = arrayOfZeros.clone();
        sorter.sort(zerosSorted);
        Assertions.assertArrayEquals(arrayOfZeros,zerosSorted);
    }

    @Test
    @DisplayName("Insertion eSort will return an empty array if an empty array is entered")
    void emptyArray(){
        int[] empty = {};
        int[] emptyClone = empty.clone();
        sorter.sort(emptyClone);
        Assertions.assertArrayEquals(empty,emptyClone);
    }

    @Test
    @DisplayName("Insertion Sort test with already sorted array")
    void alreadySorted(){
        int[] sorted = {1, 2, 3, 4, 5, 6};
        int[] toSort = sorted.clone();
        sorter.sort(toSort);
        Assertions.assertArrayEquals(sorted,toSort);
    }
}
