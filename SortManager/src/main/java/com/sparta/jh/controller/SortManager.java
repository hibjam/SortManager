package com.sparta.jh.controller;

import com.sparta.jh.model.generatearray.CreateRandomArray;
import com.sparta.jh.view.DisplayManager;

import java.util.logging.Level;
import java.util.logging.Logger;

public class SortManager {
    int[] intsArray;

    public static Logger newLogger = Logger.getLogger("Sort Manager Logger");

    public void sortManager() {
        int[] arrayToSort = getArrayBeforeSort();
        String compareAgain = "yes";
        while (compareAgain.equalsIgnoreCase("yes")) {
            DisplayManager userInput = getResultsAfterSort(arrayToSort);

            intsArray = arrayToSort.clone();
            compareAgain = userInput.compareToOtherSorter();
            if (compareAgain.equalsIgnoreCase("yes"))
                newLogger.log(Level.INFO, "User has chosen to compare to another sorter");
            }
        newLogger.log(Level.INFO, "Sort Manager has Finished");
        }

    private int[] getArrayBeforeSort() {
        newLogger.log(Level.INFO, "Sort Manager Started");

        CreateRandomArray randomArray = new CreateRandomArray();
        int chosenSize = randomArray.getArraySize();
        newLogger.log(Level.INFO, "User has entered the desired size of their array");


        int chosenBound = randomArray.generateArrayBound();
        newLogger.log(Level.INFO, "User has entered their desired array bound");


        this.intsArray = randomArray.generateArray(chosenSize, chosenBound);
        newLogger.log(Level.INFO, "A random array has now been generated");
        return intsArray;
    }
    private DisplayManager getResultsAfterSort(int[] arrayToSort) {
        DisplayManager userInput = new DisplayManager();
        String userChosenSorter = userInput.userSorter();
        newLogger.log(Level.INFO, "User has selected which sorting method they would like to use");


        long start = System.nanoTime();
        String sortedArray = SortFactory.beginSort(userChosenSorter, intsArray);
        long end = System.nanoTime();
        newLogger.log(Level.INFO, "Time to complete the sort has been recorded");

        String userFormat = userInput.resultsDisplay();
        if (userFormat.equalsIgnoreCase("yes")) {
            newLogger.log(Level.INFO, "User has chosen to view the arrays");
            DisplayManager.fullResults(arrayToSort, start, sortedArray, end);
            newLogger.log(Level.INFO, "Full results have been printed to the screen");
        } else {
            newLogger.log(Level.INFO, "User has chosen not to view the arrays");
            DisplayManager.onlyTimeResults(start, end);
            newLogger.log(Level.INFO, "Only time data has now been displayed");
        }
        return userInput;
    }
}
