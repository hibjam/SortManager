package com.sparta.jh.functiontesting;

import com.sparta.jh.model.mergesort.MergeSort;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

public class MergeSortTest {
    public MergeSort ms = new MergeSort();

    @Test
    @DisplayName("Merge sort is able to return single array")
    void mergeSortReturnsSingle(){
        int[] array = {1};
        int[] array2 = array.clone();
        ms.sort(array2);
        Assertions.assertArrayEquals(array,array2);
    }
    @Test
    @DisplayName("Merge sort is able to sort a large array and return it")
    void mergeSortReturnsSortedArray(){
        int[] arrayToSort = {241, 206, 253, 130, 299, 115, 215, 243, 137, 113, 130, 87, 107, 250, 26, 1, 252, 134, 3, 139, 143, 221, 269, 51, 208, 24, 115, 11, 255, 117};
        int[] sortedArray = arrayToSort.clone();
        ms.sort(sortedArray);
        Arrays.sort(arrayToSort);
        Assertions.assertArrayEquals(arrayToSort, sortedArray);
    }
    @Test
    @DisplayName("Merge sort is able to take an array of negative int values and sort them")
    void mergeSortCanSortNegatives(){
        int[] negativeArray = {-5, -13, -4, -5, -19, -17, -8, -19, -3, -8};
        int[] negativeSortedArray = negativeArray.clone();
        ms.sort(negativeSortedArray);
        Arrays.sort(negativeArray);
        Assertions.assertArrayEquals(negativeArray,negativeSortedArray);
    }
    @Test
    @DisplayName("Merge sort can take an array of 0's and return an array of 0's")
    void mergeSortZeros(){
        int[] arrayOfZeros = {0,0,0,0,0,0};
        int[] zerosSorted = arrayOfZeros.clone();
        ms.sort(zerosSorted);
        Assertions.assertArrayEquals(arrayOfZeros,zerosSorted);
    }
    @Test
    @DisplayName("Merge sort will return an empty array if an empty array is passed into it")
    void mergeSortEmptyArray(){
        int[] empty = {};
        int[] emptyClone = empty.clone();
        ms.sort(emptyClone);
        Assertions.assertArrayEquals(empty, emptyClone);
    }
    @Test
    @DisplayName("MergeSort test with already sorted array")
    void alreadySorted(){
        int[] sorted = {1, 2, 3, 4, 5, 6};
        int[] mergeSorted = sorted.clone();
        ms.sort(mergeSorted);
        Assertions.assertArrayEquals(sorted,mergeSorted);
    }
}
