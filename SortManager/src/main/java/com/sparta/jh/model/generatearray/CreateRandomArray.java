package com.sparta.jh.model.generatearray;

import com.sparta.jh.view.DisplayManager;

import java.util.InputMismatchException;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;

public class CreateRandomArray {
    public static Logger newLogger = Logger.getLogger("Sort Manager Logger");
    public int[] generateArray(int chosenSize, int chosenBound){
        int[] arraySize = new int[chosenSize];
        Random random = new Random();
        for (int i = 0; i<arraySize.length;i++){
            arraySize[i] = random.nextInt(chosenBound);
        }
        return arraySize;
    }
    public int getArraySize(){
        int chosenArraySize = 0;
        while (chosenArraySize <= 0 || chosenArraySize > 1000000){
            try {
                DisplayManager size = new DisplayManager();
                chosenArraySize = size.selectArraySize();
                if (chosenArraySize == -1) {
                    System.exit(0);
                }
                if (chosenArraySize <=0) {
                    System.out.println("Please enter a number greater than 0!");
                } else if (chosenArraySize > 1000000){
                    System.out.println("Please enter a number less than 1_000_000!");
                }
            } catch (InputMismatchException e) {
                System.out.println("Please enter an integer between 1 and 1_000_000!");
                newLogger.log(Level.WARNING, "User entered an incorrect data type for the array size!");
                chosenArraySize = 0;
            }
        }
        return chosenArraySize;
    }
    public int generateArrayBound(){
        int chosenBound = 0;
        while (chosenBound <= 0 || chosenBound > 1000000){
            try {
                DisplayManager bound = new DisplayManager();
                chosenBound = bound.selectArrayBound();
                if (chosenBound == -1) {
                    System.exit(0);
                }
                if (chosenBound <=0) {
                    System.out.println("Please enter a number greater than 0!");
                } else if (chosenBound > 1000000){
                    System.out.println("Please enter a number less than 1_000_000!");
                }
            } catch (InputMismatchException e) {
                System.out.println("Please enter an integer between 1 and 1_000_000!");
                newLogger.log(Level.WARNING, "User entered an incorrect data type for the array bound!");
                chosenBound = 0;
            }
        }
        return chosenBound;
    }
}


