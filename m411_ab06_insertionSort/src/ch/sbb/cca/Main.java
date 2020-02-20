package ch.sbb.cca;

import ch.sbb.cca.Algorithms.SelectionSorter;
import ch.sbb.cca.Stopwatch.Stopwatch;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        int[][] generation = {
                {0,0,0,0,0},
                {0,0,1,0,0},
                {0,0,1,0,0},
                {0,0,1,0,0},
                {0,0,0,0,0}
        };

        // selection sort test
        ArrayUtil util = new ArrayUtil();
        BufferedWriter writer = new BufferedWriter(new FileWriter("data.csv"));
        writer.write("time,length\n");

        // insertion sort test
        int[] insertionResult = insertionSort(util.randomIntArray(10, 100), 0, 9);

        for (int i = 1; i < 100; i++) {
            int[] randomArray = util.randomIntArray(i * 1000, 1000);
            Stopwatch timer = new Stopwatch();
            SelectionSorter sorter = new SelectionSorter(randomArray);
            double time = timer.elapsedTime();
            int[] sortedArray = sorter.returnSortedArray();
            writer.write(String.format("%s,%s\n", time, sortedArray.length));
        }
        writer.close();

        // java sort test
    }

    /* Function to sort array using insertion sort */
    public static int[] insertionSort(int[] arrayToSort, int start, int end) {
        for (int i = start; i <= end; i++)
            for (int j = i - 1; j >= start && arrayToSort[j] > arrayToSort[j + 1]; j--)
                swap(arrayToSort, j, j + 1);

        return arrayToSort;
    }

    /* Swap arrays */
    private static void swap(int[] A, int i, int j) {
        int temp = A[i];
        A[i] = A[j];
        A[j] = temp;
    }

    /**
     * Sort a list of integers with bubble sort algorithm
     *
     * @param intList Array of Integers
     * @return Array of sorted Integers (ascending)
     */
    public static int[] bubbleSort(int[] intList) {
        for (int indexToSort = 0; indexToSort < intList.length; indexToSort++) {
            for (int indexToCheck = 0; indexToCheck < intList.length; indexToCheck++) {
                if (indexToCheck + 1 <= intList.length - 1) {
                    // with "<" it's an ascending sort, therefore a ">" will be a descending sort algorithm
                    if (intList[indexToSort] < intList[indexToCheck]) {
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
     *
     * @param intList Unsorted List of Integer
     * @return Sorted List of Integers
     */
    public static List<Integer> quickSort(List<Integer> intList) {
        int pivot = intList.get(0);
        List<Integer> lowerThanPivot = new ArrayList<>();
        List<Integer> higherThanPivot = new ArrayList<>();

        // split intList at pivot (index 0 of intList)
        for (int indexToSort = 0; indexToSort < intList.size(); indexToSort++) {
            if (intList.get(indexToSort) < pivot) {
                // add to lowerThanPivot
                lowerThanPivot.add(intList.get(indexToSort));
            } else if (intList.get(indexToSort) > pivot) {
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
