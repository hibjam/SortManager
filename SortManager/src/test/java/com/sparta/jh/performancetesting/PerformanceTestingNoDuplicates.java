package com.sparta.jh.performancetesting;

import com.sparta.jh.model.Sorter;
import com.sparta.jh.model.binarysort.BinarySort;
import com.sparta.jh.model.bubblesort.BubbleSort;
import com.sparta.jh.model.insertionsort.InsertionSort;
import com.sparta.jh.model.mergesort.MergeSort;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

public class PerformanceTestingNoDuplicates {
    private final int[] arrayNoDuplicates = {3, 45, 654,31,23,73, 49, 369, 53,234,436,65,56,25,444,532,232,342,453,124,123,414,139,63,75,37,13,};

    @Test
    @DisplayName("Test BubbleSort no duplicates")
    public void testBubbleNoDuplicates(){
        Sorter sorter = new BubbleSort();
        long start = System.nanoTime();
        int[] sortedArray = sorter.sort(arrayNoDuplicates);
        long end = System.nanoTime();
        System.out.println("Bubble Sort no duplicates: \n" + (end - start) + " nanoseconds" + "\n" + Arrays.toString(sortedArray));
    }
    @Test
    @DisplayName("Test MergeSort no duplicates")
    public void testMergeNoDuplicates(){
        Sorter sorter = new MergeSort();
        long start = System.nanoTime();
        int[] sortedArray = sorter.sort(arrayNoDuplicates);
        long end = System.nanoTime();
        System.out.println("Merge Sort no duplicates: \n" + (end - start) + " nanoseconds" + "\n" + Arrays.toString(sortedArray));
    }
    @Test
    @DisplayName("Test BinarySort no duplicates")
    public void testBinarNoDuplicates(){
        Sorter sorter = new BinarySort();
        long start = System.nanoTime();
        int[] sortedArray = sorter.sort(arrayNoDuplicates);
        long end = System.nanoTime();
        System.out.println("Binary Sort no duplicates: \n" + (end - start) + " nanoseconds" + "\n" + Arrays.toString(sortedArray));
    }
    @Test
    @DisplayName("Test Insertion Sort no duplicates")
    public void testInsertionNoDuplicates(){
        Sorter sorter = new InsertionSort();
        long start = System.nanoTime();
        int[] sortedArray = sorter.sort(arrayNoDuplicates);
        long end = System.nanoTime();
        System.out.println("Insertion Sort no duplicates: \n" + (end - start) + " nanoseconds" + "\n" + Arrays.toString(sortedArray));
    }
}
