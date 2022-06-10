package com.sparta.jh.functiontesting;



import com.sparta.jh.model.binarysort.BinarySort;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

public class BinarySortTest{
    public BinarySort bs = new BinarySort();

    @Test
    @DisplayName("BinarySort can return a single array")
    void binarySortReturnsArray() {
        int[] array = {1};
        int[] array2 = array.clone();
        bs.sort(array2);
        Assertions.assertArrayEquals(array, array2);
    }

    @Test
    @DisplayName("BinarySort is able to take a large array of ints and sort them into order")
    void binarySortReturnsSortedArray() {
        int[] arrayToSort = {241, 206, 253, 130, 299, 115, 215, 243, 137, 113, 130, 87, 107, 250, 26, 1, 252, 134, 3, 139, 143, 221, 269, 51, 208, 24, 115, 11, 255, 117};
        int[] arrayClone = arrayToSort.clone();
        String actual = Arrays.toString(bs.sort(arrayToSort));
        Arrays.sort(arrayClone);
        String expected = Arrays.toString(arrayClone);
        Assertions.assertEquals(expected, actual);
    }

    @Test
    @DisplayName("BinarySort is able to take an array of negative int values and sort them")
    void binarySortNegativeArray() {
        int[] negativeArray = {-5, -13, -4, -42, -19, -17, -8, -19, -3, -18};
        int[] negativeSortedArray = negativeArray.clone();
        String actual = Arrays.toString(bs.sort(negativeArray));
        Arrays.sort(negativeSortedArray);
        String expected = Arrays.toString(negativeSortedArray);
        Assertions.assertEquals(expected, actual);
    }

    @Test
    @DisplayName("BinarySort returns an array of zeros if an array of zeros is passed into it")
    void binarySortZeros() {
        int[] arrayOfZeros = {0, 0, 0, 0, 0, 0};
        int[] zerosSorted = arrayOfZeros.clone();
        bs.sort(zerosSorted);
        Assertions.assertArrayEquals(arrayOfZeros, zerosSorted);
    }
    @Test
    @DisplayName("BinarySort test with already sorted array")
    void alreadySorted(){
        int[] sorted = {1, 2, 3, 4, 5, 6};
        int[] binarySorted = sorted.clone();
        bs.sort(binarySorted);
        Assertions.assertArrayEquals(sorted,binarySorted);
    }
}





