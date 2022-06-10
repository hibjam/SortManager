package com.sparta.jh.controller;

import com.sparta.jh.exceptions.IncorrectSelectException;
import com.sparta.jh.model.Sorter;
import com.sparta.jh.model.generatearray.CreateRandomArray;
import com.sparta.jh.view.DisplayManager;

import java.util.Arrays;
import java.util.logging.Level;
import java.util.logging.Logger;

import static com.sparta.jh.logging.logConfiguration.logger;

public class SortManager {
    int[] intsArray;
    int[] arrayClone;

    public static Logger newLogger = Logger.getLogger("Sort Manager Logger");

    public void sortManager() {
       logger();
        DisplayManager.welcome();
        int[] arrayToSort = getArrayBeforeSort();
        String compareAgain = "yes";
        while (compareAgain.equalsIgnoreCase("yes")) {
            DisplayManager userInput = getResultsAfterSort(arrayToSort);
            compareAgain = userInput.compareToOtherSorter();
            if (compareAgain.equalsIgnoreCase("yes"))
                newLogger.log(Level.INFO, "User has chosen to compare to another sorter");
            }
        newLogger.log(Level.INFO,"Sort Manager has Finished");
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
        arrayClone = intsArray.clone();
        return intsArray;
    }

    private DisplayManager getResultsAfterSort(int[] intsArray) {
        DisplayManager userInput = new DisplayManager();
        String userChosenSorter = userInput.userChooseSorter();
        newLogger.log(Level.INFO, "User has selected which sorting method they would like to use");
        newLogger.log(Level.INFO, "User has chosen the " + userChosenSorter + " method");

        Sorter sorter;
        try {
            sorter = SortFactory.getSorter(userChosenSorter);
        } catch (IncorrectSelectException e) {
            throw new RuntimeException(e);
        }

        long start = System.nanoTime();
        sorter.sort(intsArray);
        long end = System.nanoTime();
        String stringArray = Arrays.toString(sorter.sort(intsArray));
        newLogger.log(Level.INFO, "The sort has been completed, time to complete the sort has been recorded");

        String userFormat = userInput.resultsDisplay();
        if (userFormat.equalsIgnoreCase("yes")) {
            newLogger.log(Level.INFO, "User has chosen to view the arrays");
            DisplayManager.fullResults(arrayClone, start, stringArray, end);
            newLogger.log(Level.INFO, "Full results have been printed to the screen");
        } else {
            newLogger.log(Level.INFO, "User has chosen not to view the arrays");
            DisplayManager.onlyTimeResults(start, end);
            newLogger.log(Level.INFO, "Only time data has now been displayed");
        }
        return userInput;
    }
}
