package com.sparta.jh.performancetesting;

import com.sparta.jh.model.bubblesort.BubbleSort;
import com.sparta.jh.model.insertionsort.InsertionSort;
import com.sparta.jh.model.mergesort.MergeSort;
import com.sparta.jh.model.Sorter;
import com.sparta.jh.model.binarysort.BinarySort;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Random;

public class PerformanceTestingRandomArray {

    private int[] clonedArray;
    private static int[] generatedArray;


    @BeforeAll
    public static void arrayGenerator() {
        Random random = new Random();
        generatedArray = new int[100];
        for (int i = 0; i < generatedArray.length; i++) {
            generatedArray[i] = random.nextInt(1000);
        }
    }

    @BeforeEach
    public void setClonedArray() {
        clonedArray = generatedArray.clone();
    }

    @Test
    @DisplayName("Test Bubble Sort Performance Random Array")
    public void testBubbleSorterPerformance() {
        Sorter sorter = new BubbleSort();
        long start = System.nanoTime();
        int[] sortedArray = sorter.sort(clonedArray);
        long end = System.nanoTime();
        System.out.println("Bubble Sort: \n" + (end - start) + " nanoseconds" + "\n" + Arrays.toString(sortedArray));
    }

    @Test
    @DisplayName("Test Merge Sort Performance Random Array")
    public void testMergeSortPerformance() {
        Sorter sorter = new MergeSort();
        long start = System.nanoTime();
        int[] sortedArray = sorter.sort(clonedArray);
        long end = System.nanoTime();
        System.out.println("Merge Sort: \n" + (end - start) + " nanoseconds" + "\n" + Arrays.toString(sortedArray));
    }

    @Test
    @DisplayName("Test Binary Sort Performance Random Array")
    public void testBinarySortPerformance() {
        Sorter sorter = new BinarySort();
        long start = System.nanoTime();
        int[] sortedArray = sorter.sort(clonedArray);
        long end = System.nanoTime();
        System.out.println("Binary Sort: \n" + (end - start) + " nanoseconds" + "\n" + Arrays.toString(sortedArray));
    }
    @Test
    @DisplayName("Test Insertion Sort Performance Random Array")
    public void testInsertionSortPerformance() {
        Sorter sorter = new InsertionSort();
        long start = System.nanoTime();
        int[] sortedArray = sorter.sort(clonedArray);
        long end = System.nanoTime();
        System.out.println("Insertion Sort: \n" + (end - start) + " nanoseconds" + "\n" + Arrays.toString(sortedArray));
    }
}

// assert throws

