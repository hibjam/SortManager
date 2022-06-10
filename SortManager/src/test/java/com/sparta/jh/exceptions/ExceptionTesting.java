package com.sparta.jh.exceptions;

import com.sparta.jh.controller.SortFactory;
import com.sparta.jh.model.Sorter;
import com.sparta.jh.model.binarysort.BinarySort;
import org.junit.jupiter.api.*;

public class ExceptionTesting {


    @Test
    @DisplayName("Check exception is thrown")
    void testExpectedException() {
        BinarySort tree = new BinarySort();
        tree.binarySortTree(10);
        Assertions.assertThrows(ChildNotFoundException.class, () -> tree.getLeftChild(10));
    }

    @Test
    @DisplayName("Check exception is not thrown")
    void testExceptionNotThrown(){
        BinarySort tree = new BinarySort();
        tree.binarySortTree(50);
        tree.addElement(60);
        Assertions.assertDoesNotThrow(() -> tree.getRightChild(50));
    }
    @Test
    @DisplayName("Check exception is thrown when entering incorrect sort algorithm")
    void checkSortFactoryException(){
        SortFactory sorter = new SortFactory();
        Assertions.assertThrows(IncorrectSelectException.class, () -> sorter.getSorter("array") );
    }
    @Test
    @DisplayName("Check no exception thrown when entering correct sort method")
    void checkSortFactoryNoException(){
        SortFactory sorter = new SortFactory();
        Assertions.assertDoesNotThrow(() -> sorter.getSorter("binary"));
    }
}
