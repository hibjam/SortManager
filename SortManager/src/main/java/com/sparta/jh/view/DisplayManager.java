package com.sparta.jh.view;

import java.util.Arrays;
import java.util.Scanner;

public class DisplayManager {
    public DisplayManager(){}

    public int selectArraySize() {
        int chosenArraySize;
        System.out.println("Please enter how many numbers you would like your array to store (enter -1 to exit): ");
        Scanner scanner = new Scanner(System.in);
        chosenArraySize = scanner.nextInt();
        return chosenArraySize;
    }
    public int selectArrayBound(){
        int chosenArrayBound;
        System.out.println("Please choose your array bound (-1 to exit): ");
        Scanner scanner = new Scanner(System.in);
        chosenArrayBound = scanner.nextInt();
        return chosenArrayBound;
    }
    public String userSorter(){
        String chosenMethod = "";
        while (!chosenMethod.toLowerCase().equals("bubble") && !chosenMethod.toLowerCase().equals("binary") && !chosenMethod.toLowerCase().equals("merge")){
            System.out.println("Please enter the NAME of the sorting method you would like to choose:\n" +
                    "1. Binary\n" +
                    "2. Bubble\n" +
                    "3. Merge\n" +
                    "or press x to exit");
            Scanner scanner = new Scanner(System.in);
            chosenMethod = scanner.next();
            if (chosenMethod.equals("x")){
                System.exit(0);
            }
        }
        return chosenMethod.toLowerCase();
    }

    public String resultsDisplay() {
        System.out.println("Would you like to view both the unsorted and sorted arrays in the console (yes or no)?");
        String displayResults = "";
        Scanner scanner;
        while (!displayResults.toLowerCase().equals("yes") && !displayResults.toLowerCase().equals("no")) {
            scanner = new Scanner(System.in);
            displayResults = scanner.next();
        }
        return displayResults;
    }

    public static void onlyTimeResults(long start, long end) {
        System.out.println("Your sort comparison took: " + (end - start) + " nanoseconds");
    }

    public static void fullResults(int[] arrayClone, long start, String sortedArray, long end) {
        System.out.println("The unsorted array is:\n" + Arrays.toString(arrayClone));
        System.out.println("The sorted array is: \n" + sortedArray);
        System.out.println("This took: " + (end - start) + " nanoseconds");
    }

    public String compareToOtherSorter() {
        String compareAgain = "";
        Scanner scanner;
        while (!compareAgain.toLowerCase().equals("yes")) {
            System.out.println("Would you like to compare this same array with another sort method (yes or no)?");
            scanner = new Scanner(System.in);
            compareAgain = scanner.next();
            if (compareAgain.equals("no")) {
                System.exit(0);
            }
        }
        return compareAgain;
    }
}
