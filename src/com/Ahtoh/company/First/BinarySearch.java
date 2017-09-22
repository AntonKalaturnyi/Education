package com.Ahtoh.company.First;

import java.util.Arrays;
import static java.lang.System.out;

/**
 * Task 1
 * @author Kalaturnui Anton
 */

public class BinarySearch {

    public BinarySearch() {
    }

    public static void main(String[] args) {

        int index;
        int data[] = { 3, 6, 7, 10, 34, 56, 60 };
        int numberToFind = 10;

        if((index = Arrays.binarySearch(data, numberToFind)) > 0) {
           out.println("The index of element is: " + index);
       } else {
            out.println("Such element does not exist in the array. Index: " + index);
        }
    }
}
