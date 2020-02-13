package ch.sbb.cca;

import org.jetbrains.annotations.NotNull;

import java.util.*;

public class Main {

    public static void main(String[] args) {
        int[] intList = {0, 9, 5, 2, 4, 1, 3, 8, 7};

        int[] sortedIntArray = insertionSort(intList);
        for (int element : sortedIntArray) {
            System.out.print(String.format("%s ", element));
        }

        System.out.println("\n");

        List<Integer> integerList = new ArrayList<>();
        for (int element : intList){
            integerList.add(element);
        }
        List<Integer> quickSorted = quickSort(integerList);
        quickSorted.forEach( element -> System.out.print(element + " "));
    }

    /**
     * Sort a list of integers with bubble sort algorithm
     * @param intList Array of Integers
     * @return Array of sorted Integers (ascending)
     */
    public static int[] insertionSort(int[] intList){
        for (int indexToSort = 0; indexToSort < intList.length; indexToSort++) {
            for (int indexToCheck = 0; indexToCheck < intList.length; indexToCheck++) {
                if (indexToCheck + 1 <= intList.length - 1){
                    // with "<" it's an ascending sort, therefore a ">" will be a descending sort algorithm
                    if (intList[indexToSort] < intList[indexToCheck]){
                        int numberToSwap = intList[indexToCheck];
                        intList[indexToCheck] = intList[indexToSort];
                        intList[indexToSort] = numberToSwap;
                    }
                } else {
                    continue;
                }
            }
        }
        return intList;
    }

    /**
     * Sort a list of unsorted Integers with quickSort algorithm
     * @param intList Unsorted List of Integer
     * @return Sorted List of Integers
     */
    public static List<Integer> quickSort(List<Integer> intList){
        int pivot = intList.get(0);
        List<Integer> lowerThanPivot = new ArrayList<>();
        List<Integer> higherThanPivot = new ArrayList<>();

        // split intList at pivot (index 0 of intList)
        for (int indexToSort = 0; indexToSort < intList.size(); indexToSort++){
            if (intList.get(indexToSort) < pivot){
                // add to lowerThanPivot
                lowerThanPivot.add(intList.get(indexToSort));
            } else if (intList.get(indexToSort) > pivot){
                // add to higherThanPivot
                higherThanPivot.add(intList.get(indexToSort));
            }
        }

        List<Integer> sortedList = new ArrayList<>();
        /* Start new quickSort */
        if (lowerThanPivot.size() > 0) {
            // start quickSort for all lowerThanPivot integers
            sortedList.addAll(quickSort(lowerThanPivot));
        }

        // add pivot to list
        sortedList.add(pivot);

        if (higherThanPivot.size() > 0) {
            // start quickSort for all higherThanPivot integers
            sortedList.addAll(higherThanPivot);
        }

        // return sortedList
        return sortedList;
    }
}
