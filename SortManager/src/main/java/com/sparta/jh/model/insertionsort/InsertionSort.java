package com.sparta.jh.model.insertionsort;

import com.sparta.jh.model.Sorter;

public class InsertionSort implements Sorter {

    @Override
    public int[] sort(int[] arrayToSort){
        insertionSort(arrayToSort);
        return arrayToSort;
    }

    private void insertionSort(int[] array){
        for (int i=1; i<array.length;i++){
            int numPosition = array[i];
            int j = i-1;

            while (j>=0 && array[j] > numPosition){
                array[j+1] = array[j];
                j = j-1;
            }
            array[j+1] = numPosition;
        }
    }
}
